package com.example.nevihationapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    database mydb;
    singleDatabase dataS;

    EditText firstName;
    EditText lastName;
    TextInputLayout emailAd;
    TextInputLayout pass;
    TextInputLayout conPassw;
    Button sing;

    private FirebaseAuth firebaseAuth;
    Button s;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new database(this);
        dataS=new singleDatabase(this);

        firstName = findViewById(R.id.first);
        lastName = findViewById(R.id.last);
        emailAd = findViewById(R.id.textEmail);
        pass = findViewById(R.id.text_input_password);
        conPassw = findViewById(R.id.text_con_password);
        sing = findViewById(R.id.signUp);


        firebaseAuth=FirebaseAuth.getInstance();




        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname = firstName.getText().toString();
                String lmame = lastName.getText().toString();
                String em = emailAd.getEditText().getText().toString();
                String pas = pass.getEditText().getText().toString();
                String conPas = conPassw.getEditText().getText().toString();





                  // if (fname.equals("") || lmame.equals("") || em.equals("") || pas.equals("") || conPas.equals("") == true) {
                //  Toast.makeText(getApplicationContext(), "Please enter all details.", Toast.LENGTH_SHORT).show();
                  //  } else
                  //  {
                 // if (pas.equals(conPas)) {
                   // Boolean b = dataS.checkMail(em);
                  // if (b == false) {
                 //  emailAd.setError("Email already exixts.");
                //  } else {
                    //   dataS.insertUserData(fname,lmame,em,pas);

                 // Toast.makeText(getApplicationContext(), "You have successfully registered.", Toast.LENGTH_LONG).show();
                 //  }


               //   } else
                //  {
                  // conPassw.setError("Password doesn't match");
               //  }
                 // }













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

