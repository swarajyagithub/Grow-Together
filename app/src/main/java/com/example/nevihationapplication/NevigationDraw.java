package com.example.nevihationapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.design.widget.NavigationView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.jar.Attributes;

import static java.util.jar.Attributes.*;

public class NevigationDraw extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout draw;
    private ActionBarDrawerToggle act;
    CardView card;

    TextView f;
    TextView l;
    TextView e;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nevigation_draw);



        card=findViewById(R.id.cardV);






        draw=(DrawerLayout)findViewById(R.id.drawer);
        act=new ActionBarDrawerToggle(this,draw,R.string.open,R.string.close);
        draw.addDrawerListener(act);
        act.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(NevigationDraw.this, cate.class);
                startActivity(in);
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

