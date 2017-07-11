package com.abhimanyusharma.hewlett_packard_training;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity
{
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editText1=(EditText)findViewById(R.id.editText1);
    }
    public void search(View v)
    {
        String s1=editText1.getText().toString();
        Intent i=new Intent(Intent.ACTION_WEB_SEARCH, Uri.parse("http://www.google.com"));
        i.putExtra(SearchManager.QUERY,s1);
        startActivity(i);
    }
}
