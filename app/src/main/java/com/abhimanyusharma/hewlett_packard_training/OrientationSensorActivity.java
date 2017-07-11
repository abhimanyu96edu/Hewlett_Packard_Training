package com.abhimanyusharma.hewlett_packard_training;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class OrientationSensorActivity extends AppCompatActivity implements SensorEventListener
{
    SensorManager sm;
    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation_sensor);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener( this,s,SensorManager.SENSOR_DELAY_NORMAL);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        int x=(int)(event.values[0]*100);
        int y=(int)(event.values[1]*100);
        int z=(int)(event.values[2]*100);
        CharSequence status="X="+x+"\nY="+y+"\nZ="+z;
        tv1.setText(status);
        tv2.setBackgroundColor( Color.rgb( x,y,z ) );
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

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
}
