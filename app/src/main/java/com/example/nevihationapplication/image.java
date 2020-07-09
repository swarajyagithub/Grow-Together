package com.example.nevihationapplication;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class image extends AppCompatActivity {


    imageInsert imd;
    Button b1;
    Button b2;
    ImageView i;
    TextView n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imd=new imageInsert(this);
        b1=findViewById(R.id.add);
        b2=findViewById(R.id.view);
        i=findViewById(R.id.im);
        n=findViewById(R.id.textN);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get image from drawable
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.agri);
                // convert bitmap to byte
                String a = "Agriculture & Farming";
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte imageInByte[] = stream.toByteArray();
                Boolean isInserted = imd.insertData(imageInByte, a);
                if (isInserted == true) {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                } else {
                    // Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    //}
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                i.setImageBitmap(imd.viewImage(1));

            }
        });



    }
}
