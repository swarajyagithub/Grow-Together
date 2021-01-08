package com.example.nevihationapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.cardview.widget.CardView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class postdialogbox extends AppCompatDialogFragment {
    private TextView txenqT;
    private TextView txenqT1;
    EditText q;
    EditText b;
    EditText day;
    EditText bug;
    EditText loc;
    EditText po;
    ImageView imageView;

    Spinner s;
    Spinner quta;
    TextView tt1;
    TextView tt2;


    RadioButton r1;
    RadioButton r2;

  CardView c1;
  CardView c2;

  ImageView imageView1;

  Button post;
  Button uploadimage;

    SimpleDateFormat simpleDateFormat;
    String time;
    Calendar calander;
    ArrayList<String> arrayName=new ArrayList<String>();
    ArrayList<String> arrayLocation=new ArrayList<String>();
    ArrayList<String> arrayPin=new ArrayList<String>();
    ArrayList<String> arrayProfilepic=new ArrayList<String>();
    private static final int GALLERY_REQUEST_CODE=123;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        final View view=inflater.inflate(R.layout.postdialogbox,null);
        builder.setView(view).setNegativeButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        txenqT=view.findViewById(R.id.postTe);
        imageView=(ImageView) view.findViewById(R.id.clsimage);
        r1=view.findViewById(R.id.radio1);
        r2=view.findViewById(R.id.radio2);
        s=view.findViewById(R.id.spd1);
        po=view.findViewById(R.id.postdata);
        quta=view.findViewById(R.id.spdqutation);
        post=view.findViewById(R.id.btpost);
        uploadimage=view.findViewById(R.id.buttonimagepostupload);
        imageView1=view.findViewById(R.id.imagepostupload);
        loc=view.findViewById(R.id.loc2);
        s.setVisibility(View.VISIBLE);
        quta.setVisibility(View.GONE);
        q=view.findViewById(R.id.spd2);
        q.setVisibility(View.GONE);
        day=view.findViewById(R.id.ed1);
        day.setVisibility(View.VISIBLE);
        bug=view.findViewById(R.id.ed2);
        bug.setVisibility(View.VISIBLE);
        b=view.findViewById(R.id.qutE);
        b.setVisibility(View.GONE);



     r1.setChecked(false);
     r2.setChecked(false);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });





        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setChecked(true);
                r2.setChecked(false);

                s.setVisibility(View.VISIBLE);
                day.setVisibility(View.VISIBLE);
                bug.setVisibility(View.VISIBLE);

                q.setVisibility(View.GONE);
                b.setVisibility(View.GONE);
                quta.setVisibility(View.GONE);

               // c1.setVisibility(View.GONE);
               // c1.setVisibility(View.VISIBLE);
              //  c2.setVisibility(View.GONE);
                //c2.setVisibility(View.VISIBLE);
              // getFragmentManager().beginTransaction().replace(R.id.ff1,aw1).commit();

            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setChecked(false);
                r2.setChecked(true);

                s.setVisibility(View.GONE);
                day.setVisibility(View.GONE);
                bug.setVisibility(View.GONE);

                q.setVisibility(View.VISIBLE);
                b.setVisibility(View.VISIBLE);
                quta.setVisibility(View.VISIBLE);
               // c2.setVisibility(View.GONE);
             //   c2.setVisibility(View.VISIBLE);
               // c1.setVisibility(View.GONE);
               //  getFragmentManager().beginTransaction().replace(R.id.ff2, aw2).commit();
            }
        });



        uploadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent();
                in.setType("image/*");
                in.setAction(Intent.ACTION_OPEN_DOCUMENT);
                in.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                in.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivityForResult(Intent.createChooser(in,"Pick an image"),GALLERY_REQUEST_CODE);
            }
        });




//getFragmentManager().beginTransaction().replace(R.id.oF1,ob).commit();





       // txenqT1=view.findViewById(R.id.post1);
        return builder.create();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==GALLERY_REQUEST_CODE && resultCode==RESULT_OK && data!=null) {
            final Uri imagedata = data.getData();
            Toast.makeText(getContext(),"Image uploaded successfully!",Toast.LENGTH_LONG).show();
            imageView1.setImageURI(imagedata);


            logindialogbox l=new logindialogbox();
            final String email=l.s1;

            final singleDatabase db=new singleDatabase(getActivity());
            Cursor c=db.getFirstNameNei(email);
            while (c.moveToNext()){
                String loca=c.getString(5);
                String name=c.getString(1);
                String pin=c.getString(11);
                String profileimage=c.getString(8);
                arrayName.add(name);
                arrayLocation.add(loca);
                arrayPin.add(pin);
                arrayProfilepic.add(profileimage);
            }
            final String locat=arrayLocation.get(0);
            final String frent=s.getSelectedItem().toString();
            final String d=day.getEditableText().toString();
            final String b1=bug.getText().toString();
            final String lo=loc.getEditableText().toString();
            final String q=quta.getSelectedItem().toString();
            final String i=imagedata.toString();
            final String p=po.getEditableText().toString();
            final String b2=b.getText().toString();
            final String n=arrayName.get(0);
            final  String pincode=arrayPin.get(0);
            final  String profileI=arrayProfilepic.get(0);

            calander = Calendar.getInstance();
          //  simpleDateFormat = new SimpleDateFormat("hh:mm:ss a"); //Time in 12 hour formate
         //   simpleDateFormat = new SimpleDateFormat("HH:mm:ss ");  //Time in 24 hour formte

            simpleDateFormat = new SimpleDateFormat("mm");
        final String    posttimeinminutes = simpleDateFormat.format(calander.getTime());

            simpleDateFormat = new SimpleDateFormat("HH");
            final String    posttimeinhh = simpleDateFormat.format(calander.getTime());

            //final String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            final String postdate = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
            final String postmonth = new SimpleDateFormat("MM", Locale.getDefault()).format(new Date());
            final String postyear= new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date());


            post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   // int date=Integer.parseInt(postdate);
                  //  int month=Integer.parseInt(postmonth);
                   // int diff=month-date;
                   // day.setText(String.valueOf(diff));

                    //day.setText(time);
                   boolean r2=db.postRequestDataN(email,locat,frent,d,b1,lo,q,i,p,b2,n,postdate,posttimeinminutes,pincode,profileI,postmonth,postyear,posttimeinhh);

                    if(r2==true)
                    {
                        Toast.makeText(getContext(),"Request posted.",Toast.LENGTH_LONG).show();
                    }
                    else
                   { Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }

                }
            });

        }

        }
}
