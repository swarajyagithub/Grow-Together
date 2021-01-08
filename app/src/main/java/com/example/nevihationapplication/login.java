package com.example.nevihationapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    TextInputLayout e;
    TextInputLayout p;
    Button l;
    Button r;

    String FirstN;
    String LastN;

    database db;
    singleDatabase singled;

    private FirebaseAuth firebaseAuth;

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

        firebaseAuth=FirebaseAuth.getInstance();


        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 //Original Code
               // Intent in=new Intent(login.this,MainActivity.class);
                //startActivity(in);
 //Original Code

                Intent in=new Intent(login.this,FirebaseRegistration.class);
                startActivity(in);
            }
        });

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String eml=e.getEditText().getText().toString();
                final String psw=p.getEditText().getText().toString();



                if(eml.equals("")||psw.equals("")==true)
                {
                    Toast.makeText(getApplicationContext(),"Please enter all details.",Toast.LENGTH_LONG).show();
                }
                else {


                    firebaseAuth.signInWithEmailAndPassword(eml, psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                if (firebaseAuth.getCurrentUser().isEmailVerified()) {

                                    Cursor cr=singled.getFirstName(eml);
                                    while (cr.moveToNext())
                                    {
                                        String FirstN=cr.getString(1);
                                        String LastN=cr.getString(2);
                                    }

                                    Intent intent = new Intent(login.this, NevigationDraw.class);
                                    intent.putExtra("First",FirstN);
                                    intent.putExtra("Last",LastN);
                                    intent.putExtra("Email",eml);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(),"Login successfully!!!",Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(login.this, "Please verify your email address", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                            }

                        }
                    });


                }


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



//Single Database:
               // Cursor cFL=singled.getFirstName(eml);
            //    while (cFL.moveToNext()) {
                 //   FirstN = cFL.getString(1);
                  //  LastN = cFL.getString(2);
               // }

               // if (eml.equals("") || psw.equals("")  == true) {
                 //   Toast.makeText(getApplicationContext(), "Please enter all details.", Toast.LENGTH_SHORT).show();
              //  }
               // else
              //  {

                //    if(singled.isLogin(eml,psw))
                  //  {
                      //  Intent intent=new Intent(login.this,NevigationDraw.class);
                     //   intent.putExtra("First",FirstN);
                     //   intent.putExtra("Last",LastN);
                      //  intent.putExtra("Email",eml);
                     //   startActivity(intent);
                      //  Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
              //      }
               //     else
                 //   {
                 //       e.setError("Invalid email or password");
                //    }
             //   }
//Single Database


           }
        });

    }

}

