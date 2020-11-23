package com.example.nevihationapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registrationDialogbox extends AppCompatDialogFragment {
    TextView textView;
    TextView textView1;
    ImageView imageView;
    EditText fnN;
    EditText pin;
    Spinner sp;
    TextInputLayout emN;
    EditText mb;
    EditText ad;
    TextInputLayout passN;
    TextInputLayout conpassN;
    Button bt;
    RadioButton r;

   private FirebaseAuth firebaseAuth;





    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.registratiodialg, null);
        builder.setView(view).setNegativeButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        final singleDatabase db = new singleDatabase(getContext());



        textView = (TextView) view.findViewById(R.id.ud);
        textView1 = (TextView) view.findViewById(R.id.u1);
        imageView = (ImageView) view.findViewById(R.id.clsimage);
        fnN = (EditText) view.findViewById(R.id.firstname);
        sp = (Spinner) view.findViewById(R.id.youare);
        emN = (TextInputLayout) view.findViewById(R.id.emailN);
        mb = (EditText) view.findViewById(R.id.mobile);
        ad = (EditText) view.findViewById(R.id.address);
        pin = (EditText) view.findViewById(R.id.pincode);
        passN = (TextInputLayout) view.findViewById(R.id.passwordN);
        conpassN= (TextInputLayout) view.findViewById(R.id.confirmp);
        bt = (Button) view.findViewById(R.id.registerbutton);
        r = (RadioButton) view.findViewById(R.id.radio1);
        String udata = "General conditions of ";
        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(), 0, udata.length(), 0);
        textView.setText(content);
        String udata1 = "Sale and Use ";
        SpannableString content1 = new SpannableString(udata1);
        content1.setSpan(new UnderlineSpan(), 0, udata1.length(), 0);
        textView1.setText(content1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });


        
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean RadioButtonState = r.isChecked();
                String n = fnN.getText().toString();
                String s = sp.getSelectedItem().toString();
                //String e = em.getEditText().getText().toString();
                String m = mb.getText().toString();
                String a = ad.getEditableText().toString();
                String pcode=pin.getText().toString();
              //  String p = pass.getEditText().getText().toString();
              //  String cp = conpass.getEditText().getText().toString();
                final String emF= emN.getEditText().getText().toString();
                final String pasF = passN.getEditText().getText().toString();
                String conPasF = conpassN.getEditText().getText().toString();


                firebaseAuth=FirebaseAuth.getInstance();


                    if (n.equals("") || s.equals("") || emF.equals("") || m.equals("") || a.equals("") || pasF.equals("") || conPasF.equals("") == true) {
                        Toast.makeText(getContext(), "Please enter all details.", Toast.LENGTH_SHORT).show();
                    }
                    else if (pasF.equals(conPasF)) {
                        if (RadioButtonState == true) {

                            Boolean b = db.checkMailNei(emF);
                            if (b == false) {
                                Toast.makeText(getContext(), "Email already exists. ", Toast.LENGTH_LONG).show();
                              //  emN.setError("Email already exixts.");
                            }
                            else {

                                String img="";
                                String dbirth="";
                               // String cp="";
                                String city="";
                                String addr="";
                                String bio="";
                                String par="";
                                String pr1="";
                                String pr2="";
                                String last="";



                                db.insertNeiData(n,s,emF,m,a,pasF,conPasF,img,dbirth,last,pcode,city,addr,bio,par,pr1,pr2);
                                firebaseAuth.createUserWithEmailAndPassword(emF, pasF).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getContext(), "You have registred Successfully!!! ", Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
                                        }

                                    }
                                });
                            }
                        }
                        else {
                            Toast.makeText(getContext(), "Please accept terms and conditions.", Toast.LENGTH_LONG).show();
                        }

                        }
                         else {
                            //conpassN.setError("Password doesn't match");
                        Toast.makeText(getContext(), "Password doesn't match.", Toast.LENGTH_LONG).show();
                          }











            // boolean b=   db.insertUserExData(n);
                // if(b==true)
                // {
                //  Toast.makeText(getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
               //    }
               //   else
               //    { Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                //    }
               // if (RadioButtonState == true) {
                  //  if (n.equals("") || s.equals("") || emF.equals("") || m.equals("") || a.equals("") || pasF.equals("") || conPasF.equals("") == true) {
                    //    Toast.makeText(getContext(), "Please enter all details.", Toast.LENGTH_SHORT).show();
                //    }
                    // else {
                    // if (p.equals(cp)) {
                    //  Boolean b = db.checkMail(e);
                    //  if (b == false) {
                    //      em.setError("Email already exixts.");
                    //   }
                 //   else {


                       // firebaseAuth.createUserWithEmailAndPassword(n, m).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        //    @Override
                         //   public void onComplete(@NonNull Task<AuthResult> task) {
                           //     if (task.isSuccessful()) {
                                    // firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    //  @Override
                                    //  public void onComplete(@NonNull Task<Void> task) {

                                    // if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    //        dataS.insertUserData(fnameF, lmameF, emF, pasF);
                                 //   Toast.makeText(getContext(), "You have registred Successfully!!! Please check your email for verification.", Toast.LENGTH_LONG).show();

                                    //   } else {

                                    //     Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                              //  }
                              //  else {
                                  //  Toast.makeText(getContext(),"Registration Failed!!",Toast.LENGTH_LONG).show();
                              //  }

                            }
                        });
                //    }


           // }
                               //    });









                 //   }

            //    }







             //

          //  }
     //   });

        return builder.create();
    }
}