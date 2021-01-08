package com.example.nevihationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link securityFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class securityFrag extends Fragment {
    TextView rst;
    EditText currentp;
    EditText newp;
    EditText confirmp;
    Button update;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public securityFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment securityFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static securityFrag newInstance(String param1, String param2) {
        securityFrag fragment = new securityFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_security, container, false);

        rst=(TextView)view.findViewById(R.id.reset);
        currentp=(EditText)view.findViewById(R.id.currentpassword);
        newp=(EditText)view.findViewById(R.id.newpassword);
        confirmp=(EditText) view.findViewById(R.id.confirmpssword);
        update=(Button) view.findViewById(R.id.updatepass);

        logindialogbox l=new logindialogbox();
        final String s=l.s1;

        String udata="Reset it";
        SpannableString content=new SpannableString(udata);
        content.setSpan(new UnderlineSpan(),0,udata.length(),0);
        rst.setText(content);


        firebaseAuth=FirebaseAuth.getInstance();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final singleDatabase db=new singleDatabase(getActivity());

                if(newp.getText().toString().equals(confirmp.getText().toString())){
                   firebaseUser=firebaseAuth.getCurrentUser();
                   if(firebaseUser!=null){
                       firebaseUser.updatePassword(newp.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if(task.isSuccessful()){
                                   db.updatepassword(s,newp.getText().toString());
                                   Toast.makeText(getContext(),"Your password has been changed!",Toast.LENGTH_LONG).show();
                               }
                               else
                               {
                                   Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                               }
                           }
                       });
                   }
                }
                else {
                    Toast.makeText(getContext(),"Password dosen't match.",Toast.LENGTH_LONG).show();
                }
            }
        });

        rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ForgotPassword.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
