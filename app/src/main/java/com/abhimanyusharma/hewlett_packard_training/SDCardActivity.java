package com.abhimanyusharma.hewlett_packard_training;

import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static android.widget.Toast.LENGTH_SHORT;
/*public class SDCardActivity extends AppCompatActivity
{
    EditText et1;
    EditText et2;
    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);

        et1 =  (EditText) findViewById(R.id.editText1);
        et2 =  (EditText) findViewById(R.id.editText2);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(  new WriteSDCard()  );
        btn2.setOnClickListener(  new ReadSDCard()   );

    }//end of onCreate()

    class WriteSDCard implements View.OnClickListener
    {   @Override
    public void onClick(View v)
    {   File rootPath = Environment.getExternalStorageDirectory();
        File f = new File(rootPath,"ContactsData.txt");
        if( f.exists() == false)
        {   try
        { f.createNewFile();
            Toast.makeText(SDCardActivity.this,"FILE CREATED!!!",Toast.LENGTH_LONG).show();
        }
        catch(Exception e)
        {
        }
        }//end of if block

        try
        {
            String details = et1.getText().toString()+":"+
                    et2.getText().toString()+"\n";

            FileOutputStream fos = new FileOutputStream(f, true);
            fos.write( details.getBytes() );
            Toast.makeText(SDCardActivity.this,"DATA SAVED!!!",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {    e.printStackTrace();
        }
    }//end of onClick()
    }//end of WriteSDCard class





    class ReadSDCard implements View.OnClickListener
    {   @Override
    public void onClick(View v)
    {   File rootPath = Environment.getExternalStorageDirectory();
        File f = new File(rootPath,"ContactsData.txt");
        if(f.exists() == true )
        {   try
        {   FileInputStream fis = new FileInputStream(f);
            String fd = "";
            while(true)
            {   int a = fis.read();
                if(a == -1)
                {	break;
                }
                fd = fd+(char)a;
            }//end of while
            Toast.makeText(SDCardActivity.this,fd,Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {	Log.d("PROBLEM", e.toString());
        }
        }//end of if block
        else
        {   Toast.makeText(SDCardActivity.this,"NO DATA",Toast.LENGTH_LONG).show();
        }
    }//end of onClick()
    }//end of WriteSDCard class


}//end of SDCardActivtiy*/



public class SDCardActivity extends AppCompatActivity
{
    EditText editText1;
    EditText editText2;
    Button button1;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(new WriteSDCard());
        button2.setOnClickListener(new ReadSDCard());
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
    class WriteSDCard implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            File rootPath= Environment.getExternalStorageDirectory();
            File file=new File(rootPath,"ContactsData.txt");
            if(file.exists()==false)
            {
                try
                {
                    file.createNewFile();
                    Toast.makeText(SDCardActivity.this,"FILE CREATED!!", LENGTH_SHORT).show();
                }
                catch (Exception e)
                {

                }
            }
            try
            {
                String dis = editText1.getText().toString()+":"+
                        editText2.getText().toString()+"\n";
                FileOutputStream fos=new FileOutputStream(file,true);
                fos.write(dis.getBytes());
                Toast.makeText(SDCardActivity.this,"DATA SAVED!!", LENGTH_SHORT).show();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
     public class ReadSDCard implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            File rootPath=Environment.getExternalStorageDirectory();
            File f=new File(rootPath,"ContactsData.txt");
            if(f.exists()==true)
            {
                try
                {
                    FileInputStream fis=new FileInputStream(f);
                    String fd="";
                    while (true)
                    {
                        int a=fis.read();
                        if (a==-1)
                        {
                            break;
                        }
                        fd=fd+(char)a;
                    }
                    Toast.makeText(SDCardActivity.this,fd,Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Log.d("PROBLEM", e.toString());
                }
            }
            else
            {
                Toast.makeText(SDCardActivity.this,"NO DATA!!",Toast.LENGTH_SHORT).show();
            }
        }
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
