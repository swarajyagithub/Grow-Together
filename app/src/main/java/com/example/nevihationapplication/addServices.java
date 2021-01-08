package com.example.nevihationapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class addServices extends AppCompatActivity {

    Spinner cate;
    Spinner subCat;

    Spinner company;
    EditText prname;
    Spinner cr;
    EditText p1;
    EditText p2;
    EditText dis;
    EditText ke;

    Button addB;
    Button addB2;
    ImageView im;
    ArrayList<String> agriArrayL=new ArrayList<String>();
    ArrayList<String> itArrayL=new ArrayList<String>();
    ArrayList<Integer> imgArrayL=new ArrayList<Integer>();
    ArrayList<String> itArrayL1=new ArrayList<String>();
    private static final int GALLERY_REQUEST_CODE=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_services);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addB=findViewById(R.id.addSer);
      addB2=findViewById(R.id.selectIMG);
      p1=findViewById(R.id.pr);
      p2=findViewById(R.id.dispr);
      company=findViewById(R.id.spCompany);
        cr=findViewById(R.id.spCurrency);
      dis=findViewById(R.id.spd);
      ke=findViewById(R.id.ky);
      im=findViewById(R.id.prdI);
      prname=findViewById(R.id.pname);
        cate=findViewById(R.id.spCategory);
        subCat=findViewById(R.id.spSubCategory);
        final singleDatabase dbp=new singleDatabase(this);
        final String s1="Agriculture and Farming";
        final String s2="Computer and IT Solutions";
        final String s3="Select Sub Catrgory";

        cate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // String a1=parent.getItemAtPosition(position).toString();
                String a1=cate.getSelectedItem().toString();
                   if(a1.equals(s1)) {
                       agriArrayL.clear();

                       agriArrayL.add("Birds Seeds, Poultry & Animal Foods");
                       agriArrayL.add("Farming & Pet Animals");
                       agriArrayL.add("Fresh Flowers, Plants & Trees");
                       subCat.setAdapter(new ArrayAdapter<>(addServices.this, android.R.layout.simple_spinner_dropdown_item, agriArrayL));
                   }
                   else if(a1.equals(s2))
                   {
                       itArrayL.clear();
                       itArrayL.add("Computer IT & Software Testing");
                       itArrayL.add("Software Developement & IT Consultant");
                       itArrayL.add("Web Development & Marketing Services");
                       subCat.setAdapter(new ArrayAdapter<>(addServices.this,android.R.layout.simple_spinner_dropdown_item,itArrayL));
                   }



           }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        addB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent();
                in.setType("image/*");
                in.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(in,"Pick an image"),GALLERY_REQUEST_CODE);
               // Intent i=new Intent(addServices.this,productImages.class);
               // startActivity(i);
               // imgArrayL.clear();
               // Intent in=getIntent();
              //  String img= in.getStringExtra("I");
               // Cursor cData=dbp.getImageP(img);
               // while (cData.moveToNext())
               // {
                 //   String categoryName=cData.getString(1);
                  //  int categoryImage=cData.getInt(2);
                    //arrayNameAdv.add(categoryName);
                  //  imgArrayL.add(categoryImage);
               // }
             //   im.setImageDrawable(getResources().getDrawable(imgArrayL.get(0)));



            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        if(requestCode==GALLERY_REQUEST_CODE && resultCode==RESULT_OK && data!=null)
        {
            //Code to get image from phone gallery:
            final Uri imagedata=data.getData();
            im.setImageURI(imagedata);
            //code to convert uri into string:
            //Uri u=data.getData();
            //String s= u.toString();
            //Code to convert string into uri:
            //Uri u1=Uri.parse(s);
            //Code to set image uri to imageView:
            //ImageView i;
            //i.setImageUri(u1);
            final singleDatabase db=new singleDatabase(this);
            final String cm=company.getSelectedItem().toString();
            final String pn=prname.getEditableText().toString();
            final String ct=cate.getSelectedItem().toString();
            final String sct=subCat.getSelectedItem().toString();
            final String crr=cr.getSelectedItem().toString();
            final String p3=p1.getEditableText().toString();
            final String p4=p2.getEditableText().toString();

            final String d=dis.getEditableText().toString();
            final String k=ke.getEditableText().toString();


            addB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String s=imagedata.toString();
                    boolean r2=db.insertSData(cm,pn,ct,sct,crr,p3,p4,s,d,k);

                //  boolean r3= db.insertIPData(pn,s);
                     if(r2==true)
                     {
                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                     }
                      else
                       { Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                        }

                  //Sending single image via Intent.
                  //  Intent intent=new Intent(addServices.this,service.class);
                  //  intent.putExtra("IM",s);
                   //   startActivity(intent);


                  //  Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                   // sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                 //   sharingIntent.setType("image/*");
                   // sharingIntent.putExtra(Intent.EXTRA_STREAM, imagedata);
                   // startActivity(Intent.createChooser(sharingIntent, "Share Image Using"));
                }
            });
            //Retrive image from tableNameIP
          //  Cursor cData=db.getIPData();
            // while (cData.moveToNext())
            // {
            //   String categoryName=cData.getString(1);
             // String categoryImage=cData.getString(2);
            //arrayNameAdv.add(categoryName);
            //  itArrayL.add(categoryImage);
           //  }
            //Set image to imageview
            //Code to convert string into uri
            // Uri u=Uri.parse(itArrayL.get(0));
           //  ImageView i;
           //  i=findViewById(R.id.prdP);
           //  i.setImageURI(u);



        }
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
