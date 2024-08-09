package com.example.siddha.appexperimentone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.attr.data;


public class WebApp2 extends AppCompatActivity{

    String mCurrentPhotoPath;
    static final int color = 1;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    private Button startprocessbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_app2);

        startprocessbtn = (Button) findViewById(R.id.startprocess);
        startprocessbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while(true) {
                    takePictureIntent();
                    onActivityResult(data);
                    try {
                        createImageFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    private void takePictureIntent() {
        // creates an instance of an image capture
        Intent PictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //only starts the camera if it finds an activity that can handle the intent
        if (PictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the file where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                PictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(PictureIntent, REQUEST_TAKE_PHOTO);
            startActivityForResult(PictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    // displays the photo in an imageview
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView.setImageBitmap(imageBitmap);
        }
    }
    private File createImageFile() throws IOException {
        // Create an image file name
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timestamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile (imageFileName, ".jpg", storageDir);
        //                                prefix        suffix   directory
        // Save a file: path for use with action view intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }
}
