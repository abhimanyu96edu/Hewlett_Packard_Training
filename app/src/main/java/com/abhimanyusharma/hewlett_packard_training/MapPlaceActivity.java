package com.abhimanyusharma.hewlett_packard_training;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MapPlaceActivity extends AppCompatActivity
{
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_place);

        editText1=(EditText)findViewById(R.id.editText1);
    }
    public void map(View v)
    {
        String s1=editText1.getText().toString();
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+s1));
        startActivity(i);
    }
}
