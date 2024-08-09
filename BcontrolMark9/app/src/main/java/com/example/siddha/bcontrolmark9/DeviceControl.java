package com.example.siddha.bcontrolmark9;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class DeviceControl extends AppCompatActivity implements View.OnClickListener{

    Button discButton;
    String address = null;
    BluetoothAdapter BA = null;
    private ProgressDialog progress;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_control);

        Intent newint = getIntent();
        address = newint.getStringExtra(MainActivity.EXTRA_ADDRESS);

        discButton = (Button) findViewById(R.id.disconnectBtn);

        discButton.setOnClickListener(this);

        new ConnectBT().execute();  
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.disconnectBtn:
                disconnectBT();
                break;
        }
    }

    private void disconnectBT() {
        if (btSocket != null) {
            try {
                btSocket.close();
            }

            catch (IOException e){
                msg("Error");
            }
        }
        finish(); // return to the first layout
    }

    private class ConnectBT extends AsyncTask<Void, Void, Void> {
        private boolean ConnectSuccess = true;
        // if at this point, its almost connected

        @Override
        protected void onPreExecute() {
            // shows progress dialog
            progress = ProgressDialog.show(DeviceControl.this, "Connecting...", "Please Wait!!!");
        }

        @Override
        protected Void doInBackground(Void... devices) { // While the progress dialog is shown, the connection is done in the background
            try {
                if (btSocket == null || !isBtConnected) {
                    BA = BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice dispositivo = BA.getRemoteDevice(address);
                    // Gets the device and connects to its address and checks if its available

                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
                    // creates RFCOMM connection

                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect(); // start connection
                }
            }

            catch (IOException e) {
                ConnectSuccess = false;
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Connection Failed. Is it a SPP Bluetooth? Try again.");
                finish();
            }
            else
            {
                msg("Connected.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }

    private void msg(String textshow)
    {
        Toast.makeText(getApplicationContext(),textshow,Toast.LENGTH_LONG).show();
    }

}
