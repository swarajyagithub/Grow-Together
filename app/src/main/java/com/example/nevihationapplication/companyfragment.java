package com.example.nevihationapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link companyfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class companyfragment extends Fragment {
    EditText name;
    EditText ceo;
    EditText address;
    EditText city;
    EditText pin;
    EditText id;
    EditText idr;
    EditText mobile;
    EditText tel;
    EditText fax;
    EditText web;
    EditText gmap;
    EditText k;

    Spinner country;
    Spinner state;
    Spinner dist;

    Button bt;





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public companyfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment companyfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static companyfragment newInstance(String param1, String param2) {
        companyfragment fragment = new companyfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
        View view= inflater.inflate(R.layout.fragment_companyfragment, container, false);

        final singleDatabase com=new singleDatabase(getActivity());

        name=(EditText)view.findViewById(R.id.nameCom);
        ceo=(EditText)view.findViewById(R.id.ceoCom);
        address=(EditText)view.findViewById(R.id.addressCom);
        city=(EditText)view.findViewById(R.id.cityCom);
        pin=(EditText)view.findViewById(R.id.pinCom);
        id=(EditText)view.findViewById(R.id.idC);
        idr=(EditText)view.findViewById(R.id.idrCom);
        mobile=(EditText)view.findViewById(R.id.mobileCom);
        tel=(EditText)view.findViewById(R.id.telCom);
        fax=(EditText)view.findViewById(R.id.faxCom);
        web=(EditText)view.findViewById(R.id.webCom);
        gmap=(EditText)view.findViewById(R.id.gmapCom);
        k=(EditText)view.findViewById(R.id.kCom);

        country=(Spinner)view.findViewById(R.id.spinnerCom);
        state=(Spinner)view.findViewById(R.id.spinnerState);
        dist=(Spinner)view.findViewById(R.id.spinnerDist);



        bt=(Button)view.findViewById(R.id.saveCom);




        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cty=String.valueOf(parent.getItemIdAtPosition(position));
                long cty1=parent.getItemIdAtPosition(position);
                Toast.makeText(getContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
               // name.setText(String.valueOf(cty1));
                String cty3=country.getSelectedItem().toString();
               // name.setText(cty3);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cty4=country.getSelectedItem().toString();
                //ceo.setText(cty4);

                String st=state.getSelectedItem().toString();
                //name.setText(st);

                String dt=dist.getSelectedItem().toString();

                final String n=name.getText().toString();
                final String cn=ceo.getEditableText().toString();
                final String adr=address.getEditableText().toString();
                final String cy=city.getEditableText().toString();
                final   String p=pin.getEditableText().toString();
                final String eml=id.getEditableText().toString();
                final    String emlr=idr.getEditableText().toString();
                final String mbl=mobile.getEditableText().toString();
                final    String telp=tel.getEditableText().toString();
                final   String f=fax.getEditableText().toString();
                final   String wb=web.getEditableText().toString();
                final   String gp=gmap.getEditableText().toString();
                final    String kw=k.getEditableText().toString();

                  boolean r2=com.insertDataCompany2(n,cn,adr,cty4,st,dt,cy,p,eml,emlr,mbl,telp,f,wb,gp,kw);

                 if(r2==true)
                    {
                   Toast.makeText(getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                   }
                     else
                      { Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                   }

            }
        });



        return view;
    }
}
