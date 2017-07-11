package com.abhimanyusharma.hewlett_packard_training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DealConfirmActivity extends AppCompatActivity
{
    TextView tv1,tv2;
    String answer="Unanswered";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_confirm);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        Intent intent=getIntent();
        tv1.setText("Quantity:"+intent.getStringExtra("Q"));
        tv2.setText("Price:"+intent.getStringExtra("P"));
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public void dealStatus(View v)
    {
        int bid=v.getId();
        switch (bid)
        {
            case R.id.button1:answer="Deal Confirmed";
                break;
            case R.id.button2:answer="Deal Rejected";
                break;
        }
        Intent intent=new Intent();
        intent.putExtra("msg",answer);
        setResult(999,intent);
        finish();
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
    }}
