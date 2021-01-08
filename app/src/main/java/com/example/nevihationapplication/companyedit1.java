package com.example.nevihationapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link companyedit1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class companyedit1 extends Fragment {
    EditText nameE;
    EditText ceoE;
    EditText addressE;
    EditText cityE;
    EditText pinE;
    EditText idE;
    EditText idrE;
    EditText mobileE;
    EditText telE;
    EditText faxE;
    EditText webE;
    EditText gmapE;
    EditText kE;

    Spinner countryE;
    Spinner stateE;
    Spinner distE;

    Button btE;

    ArrayList<String> c1=new ArrayList<String>();
    ArrayList<String> c2=new ArrayList<String>();
    ArrayList<String> c3=new ArrayList<String>();
    ArrayList<String> c4=new ArrayList<String>();
    ArrayList<String> c5=new ArrayList<String>();
    ArrayList<String> c6=new ArrayList<String>();
    ArrayList<String> c7=new ArrayList<String>();
    ArrayList<String> c8=new ArrayList<String>();
    ArrayList<String> c9=new ArrayList<String>();
    ArrayList<String> c10=new ArrayList<String>();
    ArrayList<String> c11=new ArrayList<String>();
    ArrayList<String> c12=new ArrayList<String>();
    ArrayList<String> c13=new ArrayList<String>();
    ArrayList<String> c14=new ArrayList<String>();
    ArrayList<String> c15=new ArrayList<String>();
    ArrayList<String> c16=new ArrayList<String>();




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public companyedit1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment companyedit1.
     */
    // TODO: Rename and change types and number of parameters
    public static companyedit1 newInstance(String param1, String param2) {
        companyedit1 fragment = new companyedit1();
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
        View view=inflater.inflate(R.layout.fragment_companyedit1, container, false);

        final singleDatabase edit=new singleDatabase(getActivity());






        Cursor subC = edit.getDataCompany();
        c1.clear();
        c2.clear();
        c3.clear();
        c4.clear();
        c5.clear();
        c6.clear();
        c7.clear();
        c8.clear();
        c9.clear();
        c10.clear();
        c11.clear();
        c12.clear();
        c13.clear();
        c14.clear();
        c15.clear();
        c16.clear();

        while (subC.moveToNext()) {
            String comName = subC.getString(1);
            String ceoN = subC.getString(2);
            String add=subC.getString(3);
            String cunt=subC.getString(4);
            String sate=subC.getString(5);
            String dis=subC.getString(6);
            String pin=subC.getString(8);
            String comEmail = subC.getString(9);
            String comCity = subC.getString(7);
            String emr=subC.getString(10);
            String comMobile = subC.getString(11);
            String tel=subC.getString(12);
            String fax=subC.getString(13);
            String web=subC.getString(14);
            String g=subC.getString(15);
            String k=subC.getString(16);
            c1.add(comName);
            c2.add(ceoN);
            c3.add(add);
            c4.add(cunt);
            c5.add(sate);
            c6.add(dis);
            c7.add(comCity);
            c8.add(pin);
            c9.add(comEmail);
            c10.add(emr);
            c11.add(comMobile);
            c12.add(tel);
            c13.add(fax);
            c14.add(web);
            c15.add(g);
            c16.add(k);



        }


        nameE=(EditText)view.findViewById(R.id.editname);
        ceoE=(EditText)view.findViewById(R.id.editceo);
        addressE=(EditText)view.findViewById(R.id.editaddress);
        cityE=(EditText)view.findViewById(R.id.cityedit);
        pinE=(EditText)view.findViewById(R.id.pinedit);
        idE=(EditText)view.findViewById(R.id.idedit);
        idrE=(EditText)view.findViewById(R.id.idredit);
        mobileE=(EditText)view.findViewById(R.id.mobileedit);
        telE=(EditText)view.findViewById(R.id.teledit);
        faxE=(EditText)view.findViewById(R.id.faxedit);
        webE=(EditText)view.findViewById(R.id.webedit);
        gmapE=(EditText)view.findViewById(R.id.gmapedit);
        kE=(EditText)view.findViewById(R.id.kedit);



        countryE=(Spinner)view.findViewById(R.id.editcountry);
        stateE=(Spinner)view.findViewById(R.id.editstate);
        distE=(Spinner)view.findViewById(R.id.editstate);

        countryE.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,c4));
        stateE.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,c5));
        distE.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,c6));




        btE=(Button)view.findViewById(R.id.updateedit);
      //  String getArg=getArguments().getString("N");

     //   Bundle bundle=getArguments();
       // String getArg=bundle.getString("N");



        nameE.setText(c1.get(0));
        ceoE.setText(c2.get(0));
        addressE.setText(c3.get(0));
        cityE.setText(c7.get(0));
        pinE.setText(c8.get(0));
        idE.setText(c9.get(0));
        idrE.setText(c10.get(0));
        mobileE.setText(c11.get(0));
        telE.setText(c12.get(0));
        faxE.setText(c13.get(0));
        webE.setText(c14.get(0));
        gmapE.setText(c15.get(0));
        kE.setText(c16.get(0));


        nameE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=nameE.getEditableText().toString();
                Cursor sub=edit.edit(s);
                c1.clear();
                c2.clear();
                c3.clear();
                c4.clear();
                c5.clear();
                c6.clear();
                c7.clear();
                c8.clear();
                c9.clear();
                c10.clear();
                c11.clear();
                c12.clear();
                c13.clear();
                c14.clear();
                c15.clear();
                c16.clear();
                while (sub.moveToNext()) {
                    String comName = sub.getString(1);
                    String ceoN = sub.getString(2);
                    String add=sub.getString(3);
                    String cunt=sub.getString(4);
                    String sate=sub.getString(5);
                    String dis=sub.getString(6);
                    String pin=sub.getString(8);
                    String comEmail = sub.getString(9);
                    String comCity = sub.getString(7);
                    String emr=sub.getString(10);
                    String comMobile = sub.getString(11);
                    String tel=sub.getString(12);
                    String fax=sub.getString(13);
                    String web=sub.getString(14);
                    String g=sub.getString(15);
                    String k=sub.getString(16);
                    c1.add(comName);
                    c2.add(ceoN);
                    c3.add(add);
                    c4.add(cunt);
                    c5.add(sate);
                    c6.add(dis);
                    c7.add(comCity);
                    c8.add(pin);
                    c9.add(comEmail);
                    c10.add(emr);
                    c11.add(comMobile);
                    c12.add(tel);
                    c13.add(fax);
                    c14.add(web);
                    c15.add(g);
                    c16.add(k);



                }
                nameE.setText(c1.get(0));
                ceoE.setText(c2.get(0));
                addressE.setText(c3.get(0));
                cityE.setText(c7.get(0));
                pinE.setText(c8.get(0));
                idE.setText(c9.get(0));
                idrE.setText(c10.get(0));
                mobileE.setText(c11.get(0));
                telE.setText(c12.get(0));
                faxE.setText(c13.get(0));
                webE.setText(c14.get(0));
                gmapE.setText(c15.get(0));
                kE.setText(c16.get(0));
                countryE.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,c4));
                stateE.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,c5));
                distE.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,c6));

            }
        });









        btE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cty4=countryE.getSelectedItem().toString();
                //ceo.setText(cty4);

                String st=stateE.getSelectedItem().toString();
                //name.setText(st);

                String dt=distE.getSelectedItem().toString();

                final String n=nameE.getText().toString();
                final String cn=ceoE.getEditableText().toString();
                final String adr=addressE.getEditableText().toString();
                final String cy=cityE.getEditableText().toString();
                final   String p=pinE.getEditableText().toString();
                final String eml=idE.getEditableText().toString();
                final    String emlr=idrE.getEditableText().toString();
                final String mbl=mobileE.getEditableText().toString();
                final    String telp=telE.getEditableText().toString();
                final   String f=faxE.getEditableText().toString();
                final   String wb=webE.getEditableText().toString();
                final   String gp=gmapE.getEditableText().toString();
                final    String kw=kE.getEditableText().toString();


                boolean r2=edit.updateCompanyData(n,cn,adr,cty4,st,dt,cy,p,eml,emlr,mbl,telp,f,wb,gp,kw);

                if(r2==true)
                {
                    Toast.makeText(getContext(),"Data Updated",Toast.LENGTH_LONG).show();
                }
                else
                { Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                }

            }
        });




         return view;



    }
}
