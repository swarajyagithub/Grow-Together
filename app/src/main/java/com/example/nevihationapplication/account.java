package com.example.nevihationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link account#newInstance} factory method to
 * create an instance of this fragment.
 */
public class account extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView faqt;
    TextView myP;
    TextView secu;
    TextView req;
    TextView con;
    TextView cot;
    TextView in;
    TextView log;
    CardView c;
    CardView w1;
    CardView w2;
    CardView w3;
    CardView w4;
    CardView w5;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    public account() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment account.
     */
    // TODO: Rename and change types and number of parameters
    public static account newInstance(String param1, String param2) {
        account fragment = new account();
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_account, container, false);
        faqt = (TextView) view.findViewById(R.id.faqc);
        myP=(TextView)view.findViewById(R.id.MyProfile);
        secu=(TextView)view.findViewById(R.id.security);
        req = (TextView) view.findViewById(R.id.MyRequest);
        con = (TextView) view.findViewById(R.id.contract);
        cot = (TextView) view.findViewById(R.id.cont);
        in = (TextView) view.findViewById(R.id.invite);
        log = (TextView) view.findViewById(R.id.logout);
        w1 = (CardView)view.findViewById(R.id.ca1);
        w2 = (CardView)view.findViewById(R.id.ca2);
        w3 = (CardView)view.findViewById(R.id.ca3);
        w4 = (CardView)view.findViewById(R.id.ca4);
        w5 = (CardView)view.findViewById(R.id.ca5);



firebaseAuth=FirebaseAuth.getInstance();
firebaseUser=firebaseAuth.getCurrentUser();

       // final a1 a = new a1();

        faqt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faqfragm f = new faqfragm();
             //   postdialogbox dibox=new postdialogbox();
              //  dibox.show(getFragmentManager(),"example dialog");
//view.setVisibility(View.INVISIBLE);
                w1.setVisibility(View.GONE);
                w2.setVisibility(View.GONE);
                w3.setVisibility(View.GONE);
                w4.setVisibility(View.GONE);
                w5.setVisibility(View.GONE);
                getFragmentManager().beginTransaction().replace(R.id.faqfrag, f).commit();

            }
        });

        myP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myproileF myf=new myproileF();

                w1.setVisibility(View.GONE);
                w2.setVisibility(View.GONE);
                w3.setVisibility(View.GONE);
                w4.setVisibility(View.GONE);
                w5.setVisibility(View.GONE);
                getFragmentManager().beginTransaction().replace(R.id.faqfrag, myf).commit();

            }
        });
        secu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                securityFrag sec=new securityFrag();

                w1.setVisibility(View.GONE);
                w2.setVisibility(View.GONE);
                w3.setVisibility(View.GONE);
                w4.setVisibility(View.GONE);
                w5.setVisibility(View.GONE);
                getFragmentManager().beginTransaction().replace(R.id.faqfrag, sec).commit();

            }
        });
        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRequestFrag r=new myRequestFrag();

                w1.setVisibility(View.GONE);
                w2.setVisibility(View.GONE);
                w3.setVisibility(View.GONE);
                w4.setVisibility(View.GONE);
                w5.setVisibility(View.GONE);
                getFragmentManager().beginTransaction().replace(R.id.faqfrag, r).commit();

            }
        });
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myContractsFrag c=new myContractsFrag();

                w1.setVisibility(View.GONE);
                w2.setVisibility(View.GONE);
                w3.setVisibility(View.GONE);
                w4.setVisibility(View.GONE);
                w5.setVisibility(View.GONE);
                getFragmentManager().beginTransaction().replace(R.id.faqfrag, c).commit();

            }
        });
        cot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactFrag cotct=new contactFrag();

                w1.setVisibility(View.GONE);
                w2.setVisibility(View.GONE);
                w3.setVisibility(View.GONE);
                w4.setVisibility(View.GONE);
                w5.setVisibility(View.GONE);
                getFragmentManager().beginTransaction().replace(R.id.faqfrag, cotct).commit();

            }
        });
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                w1.setVisibility(View.GONE);
                w2.setVisibility(View.GONE);
                w3.setVisibility(View.GONE);
                w4.setVisibility(View.GONE);
                w5.setVisibility(View.GONE);

                invitedialogbox ind=new invitedialogbox();
                ind.show(getFragmentManager(),"example dialog");


            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // FirebaseAuth.getInstance().signOut();
                sessionmanagement s=new sessionmanagement(getActivity());
                s.removeSession();
                Intent intent=new Intent(getContext(),landingPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


        return view;



    }

}
