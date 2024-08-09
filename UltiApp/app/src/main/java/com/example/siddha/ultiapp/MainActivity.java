package com.example.siddha.ultiapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView latView = (TextView) findViewById(R.id.latView);
        final TextView longView = (TextView) findViewById(R.id.longView);
        final Button coordbutton = (Button) findViewById(R.id.coordButton);

        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // CHECKS FOR PERMISSION FOR USING THEIR LOCATION
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        final Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        LocationListener loclist = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                // Gets the lat and long using the last known location variable
                final double latitude = location.getLatitude();
                final double longitude = location.getLongitude();
                coordbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        latView.setText(Double.toString(latitude));
                        longView.setText(Double.toString(longitude));
                    }
                });
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };


    }
}
