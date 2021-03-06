package com.minerva;

import android.content.Context;

import android.hardware.Camera;

import android.os.Environment;

import android.widget.Toast;



import java.io.File;

/**
 * Created by razi on 4/8/2017.
 */
public class PhotoHandler  implements Camera.PictureCallback {

    private static final String TAG = PhotoHandler.class.getSimpleName();

    private static final String CLOUD_VISION_API_KEY = "AIzaSyCZL62RLKn9_XB8EEgSURW0vy_APs4fsic";
    private static final String ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String ANDROID_PACKAGE_HEADER = "X-Android-Package";

    private final Context context;

    public dataPass dataListener;

    public interface dataPass {
         void onDataPass(byte[] data);
    }

    public PhotoHandler(Context context, dataPass listener) {
        this.context = context;
        dataListener=listener;
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {

        /* TODO Erase this commented code whenever it won't be no more useful. It corresponds to the management of image saving.
        File pictureFileDir = getDir();

        if (!pictureFileDir.exists() && !pictureFileDir.mkdirs()) {

            Toast.makeText(context, "Can't create directory to save image.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        String photoFile = "Picture.jpg";

        String filename = pictureFileDir.getPath() + File.separator + photoFile;

        File pictureFile = new File(filename);

        try {
           // FileOutputStream fos = new FileOutputStream(pictureFile);
            //fos.write(data);
            //fos.close();
            Toast.makeText(context, "New Image saved:" + photoFile,
                    Toast.LENGTH_LONG).show();
        } catch (Exception error) {
            Toast.makeText(context, "Image could not be saved.",
                    Toast.LENGTH_LONG).show();
        }*/

        if(dataListener != null) {
            dataListener.onDataPass(data);
        }
    }

    private File getDir() {
        File sdDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return new File(sdDir, "Minerva");
    }

}