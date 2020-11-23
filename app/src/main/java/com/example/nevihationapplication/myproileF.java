package com.example.nevihationapplication;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link myproileF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class myproileF extends Fragment  {
    ImageView imageView;
    CardView card1;
    CardView card2;
    Button btProfile;
    TextView prName;
    TextView prAddrss;
    TextView profile;
    ImageView photo;


    ArrayList<String> arrayName1=new ArrayList<String>();
    ArrayList<String> arrayYouAre=new ArrayList<String>();
    ArrayList<String> arrayEmail=new ArrayList<String>();
    ArrayList<String> arrayMobile=new ArrayList<String>();
    ArrayList<String> arrayAddress=new ArrayList<String>();
    ArrayList<String> arrayPassword=new ArrayList<String>();
    ArrayList<String> arrayConPass=new ArrayList<String>();
    ArrayList<String> arrayImage=new ArrayList<String>();
    ArrayList<String> arrayBirth=new ArrayList<String>();
    ArrayList<String> arrayLast=new ArrayList<String>();
    ArrayList<String> arrayCp=new ArrayList<String>();
    ArrayList<String> arrayCity=new ArrayList<String>();
    ArrayList<String> arrayAddr=new ArrayList<String>();
    ArrayList<String> arrayBio=new ArrayList<String>();
    ArrayList<String> arrayParticulr=new ArrayList<String>();
    ArrayList<String> arrayProfes=new ArrayList<String>();
    ArrayList<String> arrayProfess=new ArrayList<String>();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public myproileF() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment myproileF.
     */
    // TODO: Rename and change types and number of parameters
    public static myproileF newInstance(String param1, String param2) {
        myproileF fragment = new myproileF();
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
        View view=inflater.inflate(R.layout.fragment_myproile, container, false);
        imageView=(ImageView)view.findViewById(R.id.map);
        photo=(ImageView)view.findViewById(R.id.pphoto);
        btProfile=(Button)view.findViewById(R.id.editpButton);
        card1=(CardView)view.findViewById(R.id.cardP1);
        card2=(CardView)view.findViewById(R.id.cardP2);
        prName=(TextView) view.findViewById(R.id.textviewmypName);
        prAddrss=(TextView) view.findViewById(R.id.mypAddress);
        profile=(TextView) view.findViewById(R.id.proflComplete);

        singleDatabase db=new singleDatabase(getActivity());

       logindialogbox l=new logindialogbox();
       String s=l.s1;

       arrayName1.clear();

        Cursor c=db.getFirstNameNei(s);
        while (c.moveToNext())
        {
            String name1=c.getString(1);
            String youare=c.getString(2);
            String email=c.getString(3);
            String mobile=c.getString(4);
            String location=c.getString(5);
            String pas=c.getString(6);
            String conpass=c.getString(7);
            String img=c.getString(8);
            String birth=c.getString(9);
            String last=c.getString(10);
            String cp=c.getString(11);
            String city=c.getString(12);
            String addr=c.getString(13);
            String bio=c.getString(14);
            String part=c.getString(15);
            String p1=c.getString(16);
            String p2=c.getString(17);

            arrayName1.add(name1);
            arrayYouAre.add(youare);
            arrayEmail.add(email);
            arrayMobile.add(mobile);
            arrayAddress.add(location);
            arrayPassword.add(pas);
            arrayConPass.add(conpass);
            arrayImage.add(img);
            arrayBirth.add(birth);
            arrayLast.add(last);
            arrayCp.add(cp);
            arrayCity.add(city);
            arrayAddr.add(addr);
            arrayBio.add(bio);
            arrayParticulr.add(part);
            arrayProfes.add(p1);
            arrayProfess.add(p2);

        }

        prName.setText(arrayName1.get(0));
        prAddrss.setText(arrayAddress.get(0));

        Uri u=Uri.parse(arrayImage.get(0));

      //  File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "u");
      //  Glide.with(getActivity()).load(u).into(photo);
       // int match=
       photo.setImageURI(u);


        btProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btProfile.setVisibility(View.GONE);
                imageView.setVisibility(View.GONE);
                card1.setVisibility(View.GONE);
                card2.setVisibility(View.GONE);
                editmyprofilfrag editf=new editmyprofilfrag();
                getFragmentManager().beginTransaction().replace(R.id.myprofragment,editf).commit();
            }
        });
        return  view;
    }


}
