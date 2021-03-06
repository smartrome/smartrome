package com.minerva;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.vision.v1.Vision;
import com.google.api.services.vision.v1.VisionRequest;
import com.google.api.services.vision.v1.VisionRequestInitializer;
import com.google.api.services.vision.v1.model.AnnotateImageRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse;
import com.google.api.services.vision.v1.model.EntityAnnotation;
import com.google.api.services.vision.v1.model.Feature;
import com.google.api.services.vision.v1.model.Image;
import com.google.api.services.vision.v1.model.LocationInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by razi on 4/11/2017.
 */
public class GalleryActivity extends AppCompatActivity {

    private static final int GALLERY_PERMISSIONS_REQUEST = 0;
    public static final int GALLERY_IMAGE_REQUEST = 1;
    private static final String CLOUD_VISION_API_KEY = "AIzaSyCZL62RLKn9_XB8EEgSURW0vy_APs4fsic";
    private static final String ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String TAG = Command.class.getSimpleName();
    public Bitmap bitmap;

    private static final int PROGRESS = 0x1;
    private ProgressBar mProgress;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();

    private static GalleryActivity parent;

    protected Uri imageUri; // *** Preserve image URI to pass it later to the Result activity ***

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        startGalleryChooser();
    }

    //method for opening the gallery to choose picture
    public void startGalleryChooser() {
        if (PermissionUtils.requestPermission(this, GALLERY_PERMISSIONS_REQUEST, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select a photo"),
                    GALLERY_IMAGE_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            uploadImage(data.getData());
        }else
        {
            this.finish();
        }
    }

    public void uploadImage(Uri uri) {
        if (uri != null) {
            try {
                // *** Scale the image to save on bandwidth ***
                bitmap = scaleBitmapDown(MediaStore.Images.Media.getBitmap(getContentResolver(), uri), 1200);

                // *** Preserve image URI in order to be called by the result activity ***
                imageUri = uri;

                callCloudVision(bitmap);

            } catch (IOException e) {
                Log.d(TAG, "Image picking failed because " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.d(TAG, "Image picker gave us a null image.");
        }
    }
    // reduce the size of the image which we want to upload
    public Bitmap scaleBitmapDown(Bitmap bitmap, int maxDimension) {

        int originalWidth = bitmap.getWidth();
        int originalHeight = bitmap.getHeight();
        int resizedWidth = maxDimension;
        int resizedHeight = maxDimension;

        if (originalHeight > originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = (int) (resizedHeight * (float) originalWidth / (float) originalHeight);
        } else if (originalWidth > originalHeight) {
            resizedWidth = maxDimension;
            resizedHeight = (int) (resizedWidth * (float) originalHeight / (float) originalWidth);
        } else if (originalHeight == originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = maxDimension;
        }
        return Bitmap.createScaledBitmap(bitmap, resizedWidth, resizedHeight, false);
    }

    // calling to cloud vision API
    public  void callCloudVision(final Bitmap bitmap) throws Exception {
        // Switch text to loading
        // mImageDetails.setText(R.string.loading_message);

        // Do the real work in an async task, because we need to use the network anyway
        new AsyncTask<Object, Void, String>() {
            @Override
            protected String doInBackground(Object... params) {
                try {
                    HttpTransport httpTransport = AndroidHttp.newCompatibleTransport();
                    JsonFactory jsonFactory = GsonFactory.getDefaultInstance();

                    VisionRequestInitializer requestInitializer =
                            new VisionRequestInitializer(CLOUD_VISION_API_KEY) {
                                /**
                                 * We override this so we can inject important identifying fields into the HTTP
                                 * headers. This enables use of a restricted cloud platform API key.
                                 */
                                @Override
                                protected void initializeVisionRequest(VisionRequest<?> visionRequest)
                                        throws IOException {
                                    super.initializeVisionRequest(visionRequest);

                                    String packageName = getPackageName();
                                    visionRequest.getRequestHeaders().set(ANDROID_PACKAGE_HEADER, packageName);

                                    String sig = PackageManagerUtils.getSignature(getPackageManager(), packageName);

                                    visionRequest.getRequestHeaders().set(ANDROID_CERT_HEADER, sig);
                                }
                            };

                    Vision.Builder builder = new Vision.Builder(httpTransport, jsonFactory, null);
                    builder.setVisionRequestInitializer(requestInitializer);

                    Vision vision = builder.build();

                    BatchAnnotateImagesRequest batchAnnotateImagesRequest =
                            new BatchAnnotateImagesRequest();
                    batchAnnotateImagesRequest.setRequests(new ArrayList<AnnotateImageRequest>() {{
                        AnnotateImageRequest annotateImageRequest = new AnnotateImageRequest();

                        // Add the image
                        Image base64EncodedImage = new Image();
                        // Convert the bitmap to a JPEG
                        // Just in case it's a format that Android understands but Cloud Vision
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                        byte[] imageBytes = byteArrayOutputStream.toByteArray();

                        // Base64 encode the JPEG
                        base64EncodedImage.encodeContent(imageBytes);
                        annotateImageRequest.setImage(base64EncodedImage);

                        // add the features we want
                        annotateImageRequest.setFeatures(new ArrayList<Feature>() {{
                            Feature labelDetection = new Feature();
                            labelDetection.setType("LANDMARK_DETECTION");
                            labelDetection.setMaxResults(10);
                            add(labelDetection);
                        }});

                        // Add the list of one thing to the request
                        add(annotateImageRequest);
                    }});

                    Vision.Images.Annotate annotateRequest =
                            vision.images().annotate(batchAnnotateImagesRequest);
                    // Due to a bug: requests to Vision API containing large images fail when GZipped.
                    annotateRequest.setDisableGZipContent(true);
                    Log.d(TAG, "created Cloud Vision request object, sending request");

                    BatchAnnotateImagesResponse response = annotateRequest.execute();
                    convertResponseToString(response);

                } catch (GoogleJsonResponseException e) {
                    Log.d(TAG, "failed to make API request because " + e.getContent());
                } catch (IOException e) {
                    Log.d(TAG, "failed to make API request because of other IOException " +
                            e.getMessage());
                }
                return "Cloud Vision API request failed. Check logs for details.";
            }

            protected void onPostExecute(String result) {
                //mImageDetails.setText(result);
            }
        }.execute();
    }

    // converting the result of cloud vision API to string
    public void convertResponseToString(BatchAnnotateImagesResponse response) {

        List<String> placeName = new ArrayList<String>();
        List<Double> latitude = new ArrayList<Double>();
        List<Double> longitude = new ArrayList<Double>();

        //need to check the availability of data, need to get coordinates
        if(response.getResponses().get(0).getLandmarkAnnotations()!= null)
        {
            for (EntityAnnotation annotation : response.getResponses().get(0).getLandmarkAnnotations()) {
                LocationInfo info = annotation.getLocations().listIterator().next();

                if(info !=null && !(annotation.getDescription().isEmpty()))
                {
                    placeName.add(annotation.getDescription());
                    latitude.add(info.getLatLng().getLatitude());
                    longitude.add(info.getLatLng().getLongitude());
                }

                if(!(placeName.get(0).isEmpty()) && latitude.get(0)!= 0.1010 && longitude.get(0)!= 0.1010){

                    //FIXME Watch out, we are getting inside this 'if' statement more than just one time

                    // *** Creating intent passing landmark information to the result activity ***
                    Log.i(TAG, "Creating intent and passing it to the Result Activity...");
                    Intent intent = new Intent(GalleryActivity.this, ResultActivity.class);
                    intent.putExtra("PLACE_NAME", placeName.get(0));
                    intent.putExtra("PLACE_LATITUDE", latitude.get(0));
                    intent.putExtra("PLACE_LONGITUDE", longitude.get(0));

                    // *** Passing URI location of the image within the phone storage ***
                    String userImageURI = imageUri.toString();
                    Log.d(TAG, "Passing to the Result Activity the image URI: " + userImageURI);
                    intent.putExtra("USER_IMAGE_URI", userImageURI);

                    // *** It will indicate to the Result Activity if we come or not from the Camera Activity ***
                    intent.putExtra("FROM_CAMERA", false);

                    // Finishing the Gallery Activity and starting the Result Activity
                    finish();
                    GalleryActivity.this.startActivity(intent);
                    break;

                }else{
                    GalleryActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            AlertDialog alertDialog = new AlertDialog.Builder(GalleryActivity.this).create();
                            alertDialog.setTitle("Alert");
                            alertDialog.setMessage("Please Try Again");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            Intent intent = new Intent(GalleryActivity.this , MainActivity.class);
                                            finish();
                                            startActivity(intent);
                                        }
                                    });
                            alertDialog.show();

                        }
                    });
                }
            }
        }

        else{
            GalleryActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog alertDialog = new AlertDialog.Builder(GalleryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Please Try Again");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    Intent intent = new Intent(GalleryActivity.this , MainActivity.class);
                                    finish();
                                    startActivity(intent);
                                }
                            });
                    alertDialog.show();
                }
            });

        }


            }


}
