package com.abhimanyusharma.hewlett_packard_training;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class ProximitySensorActivity extends AppCompatActivity implements SensorEventListener
{   SensorManager sm;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);
        iv = (ImageView)findViewById(R.id.imageView1);

        String ss = Context.SENSOR_SERVICE;
        sm = (SensorManager)getSystemService(ss);
        int rollOfSensor = Sensor.TYPE_PROXIMITY;
        Sensor s = sm.getDefaultSensor(rollOfSensor);
        sm.registerListener( this,s,SensorManager.SENSOR_DELAY_NORMAL);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }//end of onCreate() method

    @Override
    public void onSensorChanged(SensorEvent event)
    {   float f = event.values[0];
        Toast.makeText(this, "Sensor Value="+f, Toast.LENGTH_LONG).show();
        if(f==0.0)
        {	iv.setImageResource(android.R.drawable.alert_dark_frame);
        }
        else
        {   iv.setImageResource(android.R.drawable.presence_audio_away);
        }
    }//end of onSensorChanged() method

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }


    @Override
    protected void onStop()
    {		super.onStop();
        sm.unregisterListener(this);
    }
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

}//end of ProximitySensorActivity