package com.example.siddha.bcontrolmark9;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_ADDRESS = "com.example.siddha.bcontrolmark9.EXTRA_ADDRESS";

    private BluetoothAdapter BA;
    private Set<BluetoothDevice>pairedDevices;

    Button showdeviceBtn, discoverBtn, nfBtn;
    ListView bDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bDevices = (ListView) findViewById(R.id.deviceList);
        BA = BluetoothAdapter.getDefaultAdapter();

        pairedDevices = BA.getBondedDevices();

        showdeviceBtn = (Button) findViewById(R.id.showDevicesButton);
        discoverBtn = (Button) findViewById(R.id.discoverableButton );
        nfBtn = (Button) findViewById(R.id.onoffButton);

        discoverBtn.setOnClickListener(this);
        showdeviceBtn.setOnClickListener(this);
        nfBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showDevicesButton:
                devicesListView(v);
                break;
            case R.id.discoverableButton:
                discoverable(v);
                break;
            case R.id.onoffButton:
                blueOn(v);
                break;
        }
    }

    public void blueOn(View v) {
        if (!BA.isEnabled()) {
            // Enables the Bluetooth of your device
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);

            nfBtn.setText("BlueTooth: ON");
            Toast.makeText(getApplicationContext(), "BlueTooth Enabled", Toast.LENGTH_LONG).show();
        }
        else {
            BA.disable();
            nfBtn.setText("BlueTooth: OFF");
            Toast.makeText(getApplicationContext(), "BlueTooth Disabled", Toast.LENGTH_LONG).show();
        }
    }

    public void discoverable(View v) {
        discoverBtn.setText("Discoverable: ON");
        Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);
    }

    public void devicesListView(View v) {
        pairedDevices = BA.getBondedDevices();

        ArrayList devices = new ArrayList();

        // For every device, add its name to the list of devices which will be showed in a listView
        for (BluetoothDevice bt : pairedDevices) devices.add(bt.getName() + "\n" + bt.getAddress());
        Toast.makeText(getApplicationContext(), "Showing Paired Devices", Toast.LENGTH_LONG).show();

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, devices);
        bDevices.setAdapter(adapter);
        bDevices.setOnItemClickListener(DevicesitemClickListener);
    }

    private AdapterView.OnItemClickListener DevicesitemClickListener = new AdapterView.OnItemClickListener()
    {
        public void onItemClick (AdapterView av, View v, int arg2, long arg3)
        {
            // Get the device MAC address, the last 17 chars in the View
            String info = ((TextView) v).getText().toString();
            String address = info.substring(info.length() - 17);

            // Make an intent to start next activity.
            Intent i = new Intent(MainActivity.this, DeviceControl.class);

            //Change the activity.
            i.putExtra(EXTRA_ADDRESS, address);

            //this will be received at ledControl (class) Activity
            startActivity(i);
        }
    };
}
