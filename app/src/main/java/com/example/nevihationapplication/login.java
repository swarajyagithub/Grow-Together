package com.example.nevihationapplication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login extends AppCompatActivity {

    TextInputLayout e;
    TextInputLayout p;
    TextInputLayout first;
    TextInputLayout last;
    Button l;
    Button r;




    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=new database(this);

        e=findViewById(R.id.email);
        p=findViewById(R.id.text_input_password);
        l=findViewById(R.id.login);
        r=findViewById(R.id.register);
        first=findViewById(R.id.f);
        last=findViewById(R.id.l);

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(login.this,MainActivity.class);
                startActivity(in);
            }
        });

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String eml=e.getEditText().getText().toString();
                String psw=p.getEditText().getText().toString();

                if(db.isLogin(eml,psw)==false)
                {
                    Intent intent=new Intent(login.this,NevigationDraw.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
                }
                else
                {
                    e.setError("Invalid email or password");
                }

            }
        });


    }

}
