/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.minerva;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    /*** Logging tag ***/

    protected String LOG_TAG;

    /*** General activity attributes ***/

    private static final int GALLERY_PERMISSIONS_REQUEST = 0;

    private static final int GALLERY_IMAGE_REQUEST = 1;

    public static final int CAMERA_PERMISSIONS_REQUEST = 2;

    public static final int CAMERA_IMAGE_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LOG_TAG = MainActivity.this.getClass().getSimpleName();

        Log.i(LOG_TAG, "Creating application Main Activity...");

        // *** Setting up the Toolbar ***
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // *** Handling navigation buttons and clicks ***
        BottomNavigationView bottomNavigationVew = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationVew.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_camera:
                        Log.i(LOG_TAG, "Accessing Camera Activity...");
                        Intent cameraIntent = new Intent(MainActivity.this, CameraActivity.class);
                        startActivity(cameraIntent);
                        finish();
                        break;
                    case R.id.action_gallery:
                        Log.i(LOG_TAG, "Accessing Gallery Activity...");
                        Intent galleryIntent = new Intent(MainActivity.this, GalleryActivity.class);
                        startActivity(galleryIntent);
                        break;
                    case R.id.action_home:
                        break;
                }

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // *** Inflate the menu; this adds items to the action bar if it is present. ***
        getMenuInflater().inflate(R.menu.toolbar_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*** Handle action bar item clicks here. The action bar will
            automatically handle clicks on the Home/Up button, so long
            as you specify a parent activity in AndroidManifest.xml. ***/

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.settings) {
            // *** Launch Settings Activity ***
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.aboutUs) {
            // *** Display AboutUs Section ***
            aboutUs();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void aboutUs() {
        Log.i(LOG_TAG, "Displaying AboutUs information...");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = LayoutInflater.from(this);
        View viewRoot = inflater.inflate(R.layout.about_us, null);

        builder.setTitle("About Us");
        builder.setView(viewRoot);
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    }
}
