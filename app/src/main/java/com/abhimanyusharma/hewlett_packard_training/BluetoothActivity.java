package com.abhimanyusharma.hewlett_packard_training;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class BluetoothActivity extends AppCompatActivity
{
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        tv = (TextView)findViewById(R.id.textView1);
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if(adapter != null)
        {   Toast.makeText(this, "Device is bluetooth enabled.", Toast.LENGTH_LONG).show();
            tv.append("Start Scanning Devices......");
            adapter.startDiscovery();
            tv.append("\nScanning Devices Completed......");
            Set<BluetoothDevice> devices = adapter.getBondedDevices();
            for(BluetoothDevice d : devices)
            {   tv.append("Device : "+d);
                tv.append("\nDevice Name :"+d.getName() );
                tv.append("\nDevice Address:"+d.getAddress() );
                tv.append("\n--------------------------------------\n");
            }//end of for loop
        }//end of if block
        else
        { Toast.makeText(this, "Please switch on the bluetooth device", Toast.LENGTH_LONG).show();
        }
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }//end of onCreate() method
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}