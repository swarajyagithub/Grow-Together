package com.example.nevihationapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class addcareer extends AppCompatActivity {

    EditText title;
    EditText location;
    EditText pack;
    EditText pos;
    EditText discp;
    Spinner compy;
    Spinner expr;
    Spinner educat;
    Spinner jobcate;
    Button saveCar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcareer);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final singleDatabase dbcareer=new singleDatabase(this);

        title=findViewById(R.id.edittitle);
        location=findViewById(R.id.editloc);
        pack=findViewById(R.id.editpack);
        pos=findViewById(R.id.editpos);
        discp=findViewById(R.id.editdisc);
        compy=findViewById(R.id.spcomp);
        expr=findViewById(R.id.editexpr);
        educat=findViewById(R.id.edieduc);
        jobcate=findViewById(R.id.editjobcat);
        saveCar=findViewById(R.id.addCareer);

        saveCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=title.getEditableText().toString();
                String l=location.getEditableText().toString();
                String p=pack.getEditableText().toString();
                String po=pos.getEditableText().toString();
                String c=compy.getSelectedItem().toString();
                String e=expr.getSelectedItem().toString();
                String ed=educat.getSelectedItem().toString();
                String j=jobcate.getSelectedItem().toString();
                String d=discp.getEditableText().toString();

                Boolean r2=dbcareer.insertDataCareer12(t,l,p,po,c,e,ed,j,d);
                if(r2==true)
                {
                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                }
                else
                { Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }

            }
        });



    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
