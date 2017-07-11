package com.abhimanyusharma.hewlett_packard_training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;

public class RadioActivity extends AppCompatActivity
{
    RadioGroup rg;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
       //setContentView(R.layout.activity_option_menu); the entity can only connected with one xml file
        rg=(RadioGroup)findViewById(R.id.radioGroup);

        tv1=(TextView)findViewById(R.id.textView1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                String str="You have selected:";
                switch(checkedId)
                {
                    case R.id.radioButton1:str=str+"Breakfast";
                        break;
                    case R.id.radioButton2:str=str+"Lunch";
                        break;
                    case R.id.radioButton3:str=str+"Dinner";
                        break;
                    case R.id.radioButton4:str=str+"All diet is required";
                        break;
                }
                tv1.setText(str);
            }
        });//end of statement
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void clearGroup(View v)
    {
        rg.clearCheck();
        tv1.setText("You have selected:None");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        switch (id)
        {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;

            case R.id.item2:
                Toast.makeText(this, "View All", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
