package com.abhimanyusharma.hewlett_packard_training;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends ListActivity
{
    String scrArray[]={"PHONE_CALL","SMS","WEB","WEB_SEARCH","PHONE_BOOK","MAP_SEARCH","EXIT"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_menu);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,scrArray);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        if(scrArray[position].equals("EXIT"))
        {
            finish();
            Toast.makeText(this,"EXIT",Toast.LENGTH_LONG).show();
        }
        else if(scrArray[position].equals("PHONE_CALL"))
        {
            Intent box=new Intent(this,CallNoActivity.class);
            startActivity(box);
        }
        else if(scrArray[position].equals("SMS"))
        {
            Intent box=new Intent(this,SmsDetailsActivity.class);
            startActivity(box);
        }
        else if(scrArray[position].equals("WEB"))
        {
            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(i);
        }
        else if(scrArray[position].equals("WEB_SEARCH"))
        {
            Intent box=new Intent(this,SearchActivity.class);
            startActivity(box);
        }
        else if(scrArray[position].equals("PHONE_BOOK"))
        {
            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts//people"));
            startActivity(i);
        }
        else if(scrArray[position].equals("MAP_SEARCH"))
        {
            Intent box=new Intent(this,MapPlaceActivity.class);
            startActivity(box);
        }

    }
}
