package com.example.nevihationapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseRegistration extends AppCompatActivity {

    singleDatabase dataS;

    EditText firstNameF;
    EditText lastNameF;
    TextInputLayout emailAdF;
    TextInputLayout passF;
    TextInputLayout conPasswF;
    Button registF;

    private FirebaseAuth firebaseAuth;
    Button s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_registration);

        dataS=new singleDatabase(this);

        firstNameF = findViewById(R.id.firstF);
        lastNameF = findViewById(R.id.lastF);
        emailAdF = findViewById(R.id.textEmailF);
        passF = findViewById(R.id.text_input_passwordF);
        conPasswF = findViewById(R.id.text_con_passwordF);
        registF = findViewById(R.id.signUpF);


        firebaseAuth=FirebaseAuth.getInstance();

      registF.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              final String fnameF = firstNameF.getText().toString();
              final String lmameF = lastNameF.getText().toString();
              final String emF= emailAdF.getEditText().getText().toString();
              final String pasF = passF.getEditText().getText().toString();
              String conPasF = conPasswF.getEditText().getText().toString();


               if (fnameF.equals("") || lmameF.equals("") || emF.equals("") || pasF.equals("") || conPasF.equals("") == true) {
               Toast.makeText(getApplicationContext(), "Please enter all details.", Toast.LENGTH_SHORT).show();
                }
               else {
                   if (pasF.equals(conPasF)) {
                       Boolean b = dataS.checkMail(emF);
                       if (b == false) {
                           emailAdF.setError("Email already exixts.");
                       } else {

                           firebaseAuth.createUserWithEmailAndPassword(emF,pasF).addOnCompleteListener(FirebaseRegistration.this, new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if(task.isSuccessful()){
                                       firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                           @Override
                                           public void onComplete(@NonNull Task<Void> task) {
                                               if (task.isSuccessful()) {
                                                   // Sign in success, update UI with the signed-in user's information
                                                   dataS.insertUserData(fnameF, lmameF, emF, pasF);
                                                   Toast.makeText(getApplicationContext(), "You have registred Successfully!!! Please check your email for verification.", Toast.LENGTH_LONG).show();

                                               } else {

                                                   Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                               }


                                           }
                                       });
                                   }
                                   else
                                   {
                                       Toast.makeText(getApplicationContext(), "Registration Failed!!!", Toast.LENGTH_LONG).show();
                                   }

                               }
                           });

                       }
                   } else {
                       conPasswF.setError("Password doesn't match");
                   }
               }




          }
      });




        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
