package com.abhimanyusharma.hewlett_packard_training;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class DatabaseActivity extends AppCompatActivity
{
    TableLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        tl=(TableLayout)findViewById(R.id.tableLayout1);
        SQLiteDatabase db=openOrCreateDatabase("DemoDB",MODE_APPEND,null);
        db.execSQL("Create table if not exists Student(name varchar,phone varchar)");
        SharedPreferences sp=getSharedPreferences("DemoDBfile",0);
        String msg=sp.getString("STATUS","Not Intialized");
        if (msg.equals("Not Intialized"))
        {
            db.execSQL("insert into Student(name,phone) values('Katrina','9444444444')");
            db.execSQL("insert into Student values('Jatin','9111111111')");
            db.execSQL("insert into Student values('Abhi','9222222222')");
            Toast.makeText(DatabaseActivity.this,"TABLE CREATED && RECORD INSERTED", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("STATUS","Intialized");
            editor.commit();
        }
        else
        {
            Toast.makeText(DatabaseActivity.this,"Table already exists with 4 records", LENGTH_SHORT).show();
            TableRow tr;
            String q="select * from Student";
            Cursor c=db.rawQuery(q,null);
            String name,phone;
            while (c.moveToNext())
            {
                name=c.getString(0);
                phone=c.getString(1);
                tr=new TableRow(this);
                TextView tv1=new TextView(this);
                tv1.setText(name);
                TextView tv2=new TextView(this);
                tv2.setText(phone);
                tr.addView(tv1);
                tr.addView(tv2);
                tl.addView(tr);


                String n="Katrina";
                db.execSQL("delete from Student where name='"+n+"'" );
               // db.execSQL("delete from Student where name='Abhinv'" );
                Toast.makeText(DatabaseActivity.this,"RECORD DELETED SUCCESSFULLY", LENGTH_SHORT).show();
                db.execSQL("update Student set phone='1111111111' where name='Abhi'");
                Toast.makeText(DatabaseActivity.this,"RECORD UPDATED SUCCESSFULLY", LENGTH_SHORT).show();
            }//end of while
        }//end of else
           db.close();
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
