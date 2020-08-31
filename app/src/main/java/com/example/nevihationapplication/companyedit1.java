package com.example.nevihationapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


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

        btE=(Button)view.findViewById(R.id.updateedit);

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
