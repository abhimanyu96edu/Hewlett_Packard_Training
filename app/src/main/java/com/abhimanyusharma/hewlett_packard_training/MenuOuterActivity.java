package com.abhimanyusharma.hewlett_packard_training;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuOuterActivity extends ListActivity
{
    String screen[]={"MainActivity","LoveActivity","LoginActivity","MenuActivity","SpinnerActivity","RadioActivity","DealActivity",
                     "CameraActivity","AlertDialogActivity","OptionMenuActivity","SharedPreferencesActivity","ProgressBarActivity",
                      "SeekBarActivity","CustomListActivity","SDCardActivity","DatabaseActivity","DynamicListActivity","BluetoothActivity",
                      "ProximitySensorActivity","OrientationSensorActivity","MusicActivity","GPSDemoActivity","MyBroadCastReceiver1","MyBroadCastReceiver2","EXIT"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu_outer);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, screen);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,screen[position],Toast.LENGTH_SHORT).show();
        if(screen[position].equals("EXIT"))
        {
            finish();
        }
        else
        {
            String str=screen[position];
            str="com.abhimanyusharma.hewlett_packard_training"+"."+str;
            try
            {
                Class c=Class.forName(str);
                Intent intent=new Intent(this,c);
                startActivity(intent);
            }
            catch (Exception e)
            {
                Toast.makeText(this,"Screen is not yet design",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
