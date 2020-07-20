package com.example.nevihationapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login extends AppCompatActivity {

    TextInputLayout e;
    TextInputLayout p;
    Button l;
    Button r;

    String FirstN;
    String LastN;




    database db;
    singleDatabase singled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=new database(this);
        singled=new singleDatabase(this);

        e=findViewById(R.id.email);
        p=findViewById(R.id.text_input_password);
        l=findViewById(R.id.login);
        r=findViewById(R.id.register);




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

              //  Cursor cFL=db.getFirstName(eml);
               // while (cFL.moveToNext()) {
                   //  FirstN = cFL.getString(1);
                   //  LastN = cFL.getString(2);
             //   }

              //  if (eml.equals("") || psw.equals("")  == true) {
                //    Toast.makeText(getApplicationContext(), "Please enter all details.", Toast.LENGTH_SHORT).show();
               // }
               // else
                //    {

              //  if(db.isLogin(eml,psw)==false)
               // {
                  //  Intent intent=new Intent(login.this,NevigationDraw.class);
                   // intent.putExtra("First",FirstN);
               //     intent.putExtra("Last",LastN);
                //    intent.putExtra("Email",eml);
                //    startActivity(intent);
                 //   Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
             //   }
               // else
              //  {
               //     e.setError("Invalid email or password");
             //   }
             //   }


                Cursor cFL=singled.getFirstName(eml);
                while (cFL.moveToNext()) {
                    FirstN = cFL.getString(1);
                    LastN = cFL.getString(2);
                }

                if (eml.equals("") || psw.equals("")  == true) {
                    Toast.makeText(getApplicationContext(), "Please enter all details.", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    if(singled.isLogin(eml,psw))
                    {
                        Intent intent=new Intent(login.this,NevigationDraw.class);
                        intent.putExtra("First",FirstN);
                        intent.putExtra("Last",LastN);
                        intent.putExtra("Email",eml);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        e.setError("Invalid email or password");
                    }
                }



            }
        });


    }



}
