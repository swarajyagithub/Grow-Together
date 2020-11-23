package com.example.nevihationapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class logindialogbox extends AppCompatDialogFragment {
    TextView textView;
    ImageView imageView;
    EditText emailU;
    EditText passworU;
    Button bt;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    public static  String s2 = "login";
    public static  String s1 = "login";

    SimpleDateFormat simpleDateFormat;
    Calendar calander;
    ArrayList<Integer> arrayID=new ArrayList<Integer>();
    ArrayList<String> arrayName=new ArrayList<String>();


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        final View view=inflater.inflate(R.layout.logindial,null);
        builder.setView(view).setNegativeButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        final singleDatabase db=new singleDatabase(getContext());
        textView=(TextView)view.findViewById(R.id.ud2);
        emailU=(EditText) view.findViewById(R.id.userEmail);
        passworU=(EditText) view.findViewById(R.id.userPassword);
        bt=(Button) view.findViewById(R.id.login);
        progressBar=(ProgressBar) view.findViewById(R.id.p);
        //final String e1=emailU.getEditableText().toString();
       // final String p1=pas.getEditableText().toString();
        firebaseAuth=FirebaseAuth.getInstance();
        String udata="Forgot your password? ";
        SpannableString content=new SpannableString(udata);
        content.setSpan(new UnderlineSpan(),0,udata.length(),0);
        textView.setText(content);
        imageView=(ImageView) view.findViewById(R.id.clsimage);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ForgotPassword.class);
                startActivity(intent);
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



              // Bundle data = new Bundle();//create bundle instance
             //   data.putString("E","Hi" );
          //    myproileF f=new myproileF();
           //    f.setArguments(data);

           s1=emailU.getEditableText().toString();
           s2=passworU.getEditableText().toString();

//myproileF f=(myproileF) getActivity().getSupportFragmentManager().findFragmentByTag("MyProfile");

//f.prName.setText(emailU.getEditableText().toString());

                progressBar.setVisibility(View.VISIBLE);
           //  boolean b=db.checkLogin(emailU.getText().toString(),passworU.getText().toString());
           //  if(b==false) {
                 firebaseAuth.signInWithEmailAndPassword(emailU.getText().toString(), passworU.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         progressBar.setVisibility(View.GONE);
                         db.insertloginTime(emailU.getText().toString(),"","","","","");
                         calander = Calendar.getInstance();
                         simpleDateFormat = new SimpleDateFormat("mm");
                         final String logintimeinminutes = simpleDateFormat.format(calander.getTime());

                         simpleDateFormat = new SimpleDateFormat("HH");
                         final String    logintimeinhh = simpleDateFormat.format(calander.getTime());

                         //final String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                         final String ldate = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
                         final String lmonth = new SimpleDateFormat("MM", Locale.getDefault()).format(new Date());
                         final String lyear= new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date());
                         db.updateloginTime(emailU.getText().toString(),lyear,lmonth,ldate,logintimeinminutes,logintimeinhh);
                         db.updateloginpassword(emailU.getText().toString(), passworU.getText().toString());
                         if (task.isSuccessful()) {
                             Intent intent = new Intent(getContext(), home_page.class);
                             startActivity(intent);
                         } else {
                             Toast.makeText(getContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                         }
                     }
                 });

            // }
            // else {
                // progressBar.setVisibility(View.GONE);
               //  Toast.makeText(getContext(),"Invalid email or password.Please try again.",Toast.LENGTH_LONG).show();
           //  }

            }
        });


        return builder.create();
    }

    public String getMyData() {
        String user_name =  emailU.getText().toString();


        return user_name;


    }

}
