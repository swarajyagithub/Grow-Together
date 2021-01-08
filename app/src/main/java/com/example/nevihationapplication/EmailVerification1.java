package com.example.nevihationapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EmailVerification1 extends AppCompatActivity {

    EditText name;
    EditText eamil;
    EditText passw;
    Button reg;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification1);

        firebaseAuth=FirebaseAuth.getInstance();

        name=findViewById(R.id.userName);
        eamil=findViewById(R.id.userEmail);
        passw=findViewById(R.id.userPassword);
        reg=findViewById(R.id.regist);



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e = eamil.getEditableText().toString();
                String p = passw.getEditableText().toString();
                addUser(e,p);

            }
        });
    }
    private void addUser(String eml,String psw)
    {


           firebaseAuth.createUserWithEmailAndPassword(eml, psw)
                   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                   @Override
                                   public void onComplete(@androidx.annotation.NonNull Task<Void> task) {
                                       if (task.isSuccessful()) {
                                           // Sign in success, update UI with the signed-in user's information
                                           Toast.makeText(getApplicationContext(), "Registred Successfully!!! Please check your email for verification.", Toast.LENGTH_LONG).show();

                                       } else {

                                           Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                       }

                                   }
                               });

                           } else {
                               // If sign in fails, display a message to the user.
                               Toast.makeText(getApplicationContext(), "Registration Failed!!!", Toast.LENGTH_LONG).show();
                           }

                           // ...
                       }
                   });


    }
}
