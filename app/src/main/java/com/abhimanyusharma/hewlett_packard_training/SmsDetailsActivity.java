package com.abhimanyusharma.hewlett_packard_training;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SmsDetailsActivity extends AppCompatActivity
{
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_details);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
    }
    public void sms(View v)
    {
        String s1=editText1.getText().toString();
        String s2=editText2.getText().toString();
        Intent i=new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+s1));
        i.putExtra("sms_body",s2);
        startActivity(i);
    }
}
