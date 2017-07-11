package com.abhimanyusharma.hewlett_packard_training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity
{
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);
        textView1=(TextView) findViewById(R.id.textView1);
        Intent box=getIntent();
        String u=box.getStringExtra("U");
        String p=box.getStringExtra("P");

        textView1.setText("UserName:"+u);
        textView1.append("\nPassword:"+p);

        if(u.equals(p))
        {
            textView1.append("\n\nLogin Authentication Successful");
        }
        else
        {
            textView1.append("\n\nLogin Authentication Failed!retry!");
        }
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
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
