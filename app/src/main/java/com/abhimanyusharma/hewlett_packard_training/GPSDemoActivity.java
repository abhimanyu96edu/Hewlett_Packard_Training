package com.abhimanyusharma.hewlett_packard_training;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class GPSDemoActivity extends AppCompatActivity {
    LocationManager locationManager;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpsdemo);
        tv = (TextView) findViewById(R.id.textView1);

        locationManager = (LocationManager) getSystemService(
                Context.LOCATION_SERVICE);

        MyLocationListener locationListener = new MyLocationListener();

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
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }//end of onCreate()

    class MyLocationListener implements LocationListener
    {   @Override
    public void onLocationChanged(Location arg0)
    {
        String text="My current Location is :\n LATTITUDE="+
                arg0.getLatitude() + "\nLONGITUDE=" +
                arg0.getLongitude();

        // Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        tv.setText(text);
    }
        @Override
        public void onProviderDisabled(String provider)
        { Toast.makeText(getApplicationContext(), "GPS Disabled by User", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onProviderEnabled(String provider)
        {   Toast.makeText(getApplicationContext(), "GPS Enabled by User", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras)
        {
        }
    }// end of MyLocationListener class
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

}//end of GPSDemoActivity
