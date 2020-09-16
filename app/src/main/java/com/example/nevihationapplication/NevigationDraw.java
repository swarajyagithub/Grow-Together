package com.example.nevihationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NevigationDraw extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout draw;
    private ActionBarDrawerToggle act;
    CardView card;
    CardView cardCom;
    CardView cardcar;
    CardView carEnq;
    CardView carGEnq;
    CardView cardR;



    TextView f;
    TextView l;
    TextView e;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nevigation_draw);



        card=findViewById(R.id.cardV);
        cardCom=findViewById(R.id.cardCompany);
        cardcar=findViewById(R.id.cardCRE);
        carEnq=findViewById(R.id.enq);
        carGEnq=findViewById(R.id.genq);
        cardR=findViewById(R.id.cardRef);




        draw=(DrawerLayout)findViewById(R.id.drawer);
        act=new ActionBarDrawerToggle(this,draw,R.string.open,R.string.close);
        draw.addDrawerListener(act);
        act.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(NevigationDraw.this, searchbox.class);
                startActivity(in);
            }
        });

        cardCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inCom=new Intent(NevigationDraw.this, company.class);
                startActivity(inCom);
            }
        });

        cardcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent incar=new Intent(NevigationDraw.this,career.class);
                startActivity(incar);
            }
        });
        carEnq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent incarE=new Intent(NevigationDraw.this,enquiryfragment.class);
                startActivity(incarE);
            }
        });
        carGEnq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent incargE=new Intent(NevigationDraw.this,enquiryfragment.class);
                startActivity(incargE);
            }
        });
        cardR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent incargR=new Intent(NevigationDraw.this,referal.class);
                startActivity(incargR);
            }
        });





        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        f=(TextView)navigationView.getHeaderView(0).findViewById(R.id.firstName);
        l=(TextView)navigationView.getHeaderView(0).findViewById(R.id.lastName);
        e=(TextView)navigationView.getHeaderView(0).findViewById(R.id.email);
        Intent intent=getIntent();
        String fN=intent.getStringExtra("First");
        String lN=intent.getStringExtra("Last");
        String eM=intent.getStringExtra("Email");
        f.setText(fN);
        l.setText(lN);
        e.setText(eM);






    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(act.onOptionsItemSelected(item)) {

            return true;
        }

            return super.onOptionsItemSelected(item);

    }

    @Override
   public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


       return true;

    }



}

