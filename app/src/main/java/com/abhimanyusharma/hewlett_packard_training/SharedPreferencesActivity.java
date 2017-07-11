package com.abhimanyusharma.hewlett_packard_training;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

public class SharedPreferencesActivity extends AppCompatActivity
{
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        et1=(EditText)findViewById(R.id.editText1);
        SharedPreferences sharedPreferences=getSharedPreferences("DemoFile",0);
        String msg=sharedPreferences.getString("STATUS",null);
        et1.setText(msg);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        SharedPreferences sharedPreferences=getSharedPreferences("DemoFile",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("STATUS",et1.getText().toString());
        editor.commit();
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
