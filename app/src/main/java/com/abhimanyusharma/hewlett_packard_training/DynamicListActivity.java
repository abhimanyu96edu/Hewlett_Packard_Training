package com.abhimanyusharma.hewlett_packard_training;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DynamicListActivity extends ListActivity
{
    ArrayList screens;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {    super.onCreate(savedInstanceState);
        SQLiteDatabase db = openOrCreateDatabase("DemoDataBase",MODE_APPEND, null);
        String q = "select * from Student";
        Cursor c =db.rawQuery(q, null);

        String name;
        screens = new ArrayList();
        while(c.moveToNext())
        {	name = c.getString(0);
            screens.add(name);
        }//end of while loop
        db.close();
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,screens);
        setListAdapter(adapter);
    }//end of onCreate()


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {    super.onListItemClick(l, v, position, id);
        Toast.makeText(this, "Name Selected:"+screens.get(position), Toast.LENGTH_LONG).show();

        SQLiteDatabase db = openOrCreateDatabase("DemoDataBase",MODE_APPEND, null);

        String q="select * from Student where name= '" + screens.get(position)+"' ";
        String phone=null;
        Cursor c =db.rawQuery(q, null);
        if(c.moveToNext())
        {    phone = c.getString(1);
        }
        Toast.makeText(this, "Phone :"+phone, Toast.LENGTH_LONG).show();
    }
}
