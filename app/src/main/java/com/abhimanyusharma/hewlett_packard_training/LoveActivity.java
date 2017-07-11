package com.abhimanyusharma.hewlett_packard_training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoveActivity extends AppCompatActivity
{
    EditText editText1;
    EditText editText2;
    TextView textView1;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        textView1=(TextView) findViewById(R.id.textView1);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
    public void calculate(View v)
    {
        String s1=editText1.getText().toString();
        String s2=editText2.getText().toString();
        int len1=s1.length();
        int len2=s2.length();
        int res=len1+len2;

        res=res%11;
        res=res*10;
        textView1.setText("Your Love Percentage:"+res);
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
