package com.example.nevihationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class landingPage extends AppCompatActivity  {
    TextView text2;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        text2=findViewById(R.id.textAl);
        button=findViewById(R.id.butn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationDialogbox d=new registrationDialogbox();
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menuitem,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnu:
                Intent intent=new Intent(landingPage.this,neigbhorRegistration.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }


}
