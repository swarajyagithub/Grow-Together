package com.example.nevihationapplication;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link editmyprofilfrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class editmyprofilfrag extends Fragment {

    Button editphoto;
    private static final int GALLERY_REQUEST_CODE=123;
    private static final  int SELECT_PHOTO=1;
    private  static final int CAPTURE_PHOO=2;
    ImageView imageView;
    TextView w;
    TextView m;
    TextView y;
    CheckBox c1;
    CheckBox c2;
    Button cary;
    EditText dbirt;
    EditText fn;
    EditText ln;
    EditText em;
    EditText mb;
    EditText a1;
    EditText a2;
    EditText a3;
    EditText bi;
    Spinner snr1;
    Spinner snr2;
    EditText pr;
    CheckBox ch;

    private ColorStateList defaultTextColorp;
    int colorvalue;
    String y1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public editmyprofilfrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment editmyprofilfrag.
     */
    // TODO: Rename and change types and number of parameters
    public static editmyprofilfrag newInstance(String param1, String param2) {
        editmyprofilfrag fragment = new editmyprofilfrag();
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
        View view= inflater.inflate(R.layout.fragment_editmyprofilfrag, container, false);

        editphoto=(Button)view.findViewById(R.id.editphotobt);
        imageView=(ImageView) view.findViewById(R.id.profilephoto);
        w=(TextView) view.findViewById(R.id.woman);
        m=(TextView) view.findViewById(R.id.man);
        y=(TextView) view.findViewById(R.id.youaret);
        c1=(CheckBox) view.findViewById(R.id.womanc);
        c2=(CheckBox) view.findViewById(R.id.manc);
        cary=(Button) view.findViewById(R.id.carry);
        dbirt=(EditText) view.findViewById(R.id.dbirth);
        fn=(EditText) view.findViewById(R.id.fname);
        ln=(EditText) view.findViewById(R.id.lname);
        em=(EditText) view.findViewById(R.id.email);
        mb=(EditText) view.findViewById(R.id.mobile);
        a1=(EditText) view.findViewById(R.id.cp);
        a2=(EditText) view.findViewById(R.id.c1);
        a3=(EditText) view.findViewById(R.id.c2);
        bi=(EditText) view.findViewById(R.id.bio);
        snr1=(Spinner) view.findViewById(R.id.spinnerpart);
        snr2=(Spinner) view.findViewById(R.id.spinnerprof);
        pr=(EditText) view.findViewById(R.id.profession);
        ch=(CheckBox) view.findViewById(R.id.chbox);





        editphoto.setOnClickListener(new View.OnClickListener() {
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

       // w.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
               // w.setTextColor(Color.parseColor("#f88379"));
              //  m.setTextColor(Color.parseColor("#D3D3D3"));
            //    w.setTextColor(Color.RED);
             //   m.setTextColor(Color.GRAY);
             //   yr=w.getText().toString();

         //   }
    //    });

      //  m.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
                //m.setTextColor(Color.parseColor("#f88379"));
               // w.setTextColor(Color.parseColor("#D3D3D3"));
         //       m.setTextColor(Color.RED);
         //       w.setTextColor(Color.GRAY);
       //     }
      //  });


          //  colorvalue=w.getCurrentTextColor();// colorvalue= -1979711488
          //  y.setText(Integer.toString(colorvalue));






        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==GALLERY_REQUEST_CODE && resultCode==RESULT_OK && data!=null) {

            final singleDatabase db=new singleDatabase(getActivity());

            logindialogbox l=new logindialogbox();
            final String email=l.s1;
            final String pass=l.s2;

            //Code to get image from phone gallery:
            final Uri imagedata = data.getData();
            imageView.setImageURI(imagedata);

            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c2.setChecked(true);
                    c1.setChecked(false);
                    m.setTextColor(Color.RED);
                    w.setTextColor(Color.GRAY);
                }
            });

            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c1.setChecked(true);
                    c2.setChecked(false);
                    w.setTextColor(Color.RED);
                    m.setTextColor(Color.GRAY);
                }
            });


            cary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String i=imagedata.toString();

                    if(c1.isChecked()==true)
                    {
                      y1=w.getText().toString();
                      //  y.setText(y1);

                    }
                    else {
                         y1=m.getText().toString();
                       // y.setText(y1);
                    }

                    String b=dbirt.getText().toString();
                    String f=fn.getText().toString();
                    String l=ln.getText().toString();
                    String e=em.getText().toString();
                    String m=mb.getText().toString();
                    String b1=a1.getText().toString();
                    String b2=a2.getText().toString();
                    String b3=a3.getText().toString();
                    String b4=bi.getText().toString();
                    String s1=snr1.getSelectedItem().toString();
                    String s2=snr2.getSelectedItem().toString();
                    String p=pr.getText().toString();

                    if(ch.isChecked()==true){

                       boolean r2= db.updateNeibrData(f,y1,e,m,b2,pass,pass,i,b,l,b1,b2,b3,b4,s1,s2,p);
                       if(r2=true){

                           Toast.makeText(getContext(),"Data saved",Toast.LENGTH_LONG).show();
                       }
                       else {
                           Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                       }

                    }
                    else {

                        Toast.makeText(getContext(),"Please accept terms and conditions to continue.",Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }
}
