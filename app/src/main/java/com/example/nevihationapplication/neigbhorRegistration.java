package com.example.nevihationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class neigbhorRegistration extends AppCompatActivity {

    TextView textreg;
    TextView textlogin;
    TextView text1;
    TextView text2;
    TextView homep;

    @Override
    public void onStart() {
        super.onStart();
        //check if usr is logged in
        //if loggedin move to home-page activity
        sessionmanagement ss=new sessionmanagement(neigbhorRegistration.this);
        int userId= ss.getSession();
        if(userId!=-1){
            Intent intent=new Intent(neigbhorRegistration.this,home_page.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neigbhor_registration);
        textreg=findViewById(R.id.reg);
        textlogin=findViewById(R.id.login);
        text2=findViewById(R.id.textAl);
        homep=findViewById(R.id.texthome);
        textreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationDialogbox d=new registrationDialogbox();
                d.show(getSupportFragmentManager(),"Dailogbox");

            }
        });
        textlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logindialogbox d=new logindialogbox();
                d.show(getSupportFragmentManager(),"Dailogbox");

            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logindialogbox d=new logindialogbox();
                d.show(getSupportFragmentManager(),"Dailogbox");
            }
        });

        homep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User(1,"Nitin");

                sessionmanagement sess=new sessionmanagement(neigbhorRegistration.this);
                sess.saveSession(user);
                Intent intent=new Intent(neigbhorRegistration.this,home_page.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.close,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.cls:
                Intent intent=new Intent(neigbhorRegistration.this,landingPage.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
