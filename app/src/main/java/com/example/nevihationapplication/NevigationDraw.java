package com.example.nevihationapplication;

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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.jar.Attributes;

import static java.util.jar.Attributes.*;

public class NevigationDraw extends AppCompatActivity {

    private DrawerLayout draw;
    private ActionBarDrawerToggle act;
    CardView card;





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




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(act.onOptionsItemSelected(item)) {
            return true;
        }
            return super.onOptionsItemSelected(item);

    }



}

