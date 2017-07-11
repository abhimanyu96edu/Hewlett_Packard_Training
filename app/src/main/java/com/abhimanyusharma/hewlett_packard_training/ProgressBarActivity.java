package com.abhimanyusharma.hewlett_packard_training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
public class ProgressBarActivity extends AppCompatActivity
{
    ProgressBar pb;
    Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        pb = (ProgressBar) findViewById(R.id.progressBar1);

        t = new Thread()
        {
            public void run()
            {   for(int i=0;i<=100;i++)
            {   pb.setProgress(i);
                try
                {  Thread.sleep(100);
                }
                catch (Exception e)
                {
                }
            }//end of for loop

            }//end of run()

        }; //end of annonymous Thread type class
        //Toast.makeText(ProgressBarActivity.this,"Completed",Toast.LENGTH_SHORT).show();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }//end of onCreate()


    //Declarative Event handling
    public void startProgressBar(View v)
    {   t.start();
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

}//end of ProgressBarActivity


/*public class ProgressBarActivity extends AppCompatActivity
{
    ProgressBar pb;
    Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        pb=(ProgressBar)findViewById(R.id.progressBar1);
        t= new Thread()
        {
            public void run()
            {
                for(int i=0;i<=100;i++)
                {
                    pb.setProgress(i);
                    try
                    {
                        Thread.sleep(50);
                    }
                    catch (Exception e)
                    {

                    }
                }
                Toast.makeText(ProgressBarActivity.this,"Completed",Toast.LENGTH_SHORT).show();
            }
        };//end
    }
    public void startProgressBar(View v)
    {
        t.start();
    }

}*/
