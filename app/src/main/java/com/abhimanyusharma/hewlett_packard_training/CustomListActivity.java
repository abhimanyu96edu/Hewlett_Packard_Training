package com.abhimanyusharma.hewlett_packard_training;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class CustomListActivity extends ListActivity
{
    String[] nameMenu = {"Banana", "Graps", "Mango", "Cherry", "Guava", "Strawberry"};
    String[] infoMenu = {"For Shakes"  , "For Dry Fruits"  , "King of fruits" ,
            "For decoration"  ,  "A common fruit" , "For decoration"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_custom_list);
        ArrayAdapter adpt = null;
        adpt = new MyAdapter(this, android.R.layout.simple_list_item_1, nameMenu);
        setListAdapter(adpt);
    }

    class MyAdapter extends ArrayAdapter
    {
        public MyAdapter(Context context, int resource, Object[] objects)
        {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = li.inflate(R.layout.activity_custom_list, parent, false);
            ImageView iv = (ImageView) row.findViewById(R.id.imageView1);
            TextView tv1 = (TextView) row.findViewById(R.id.textView1);
            TextView tv2 = (TextView) row.findViewById(R.id.textView2);
            tv1.setText(nameMenu[position]);
            tv2.setText(infoMenu[position]);
            if (position%2==0) {
                iv.setImageResource(android.R.drawable.star_big_on);
            } else {
                iv.setImageResource(android.R.drawable.star_big_off);
            }
            return row;
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this, nameMenu[position], Toast.LENGTH_LONG ).show();
    }
}

