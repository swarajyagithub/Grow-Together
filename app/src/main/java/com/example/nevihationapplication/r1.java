package com.example.nevihationapplication;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link r1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class r1 extends Fragment {
    EditText nameR;
    EditText phneR;
    EditText emailR;
    EditText addR;
    EditText cmtR;
    Spinner NSR;
    Button b;
    TextView t1;
    ArrayList<String> nameSpinner=new ArrayList<String>();

    AdapterRef adapterR;
 //   communication com;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public r1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment r1.
     */
    // TODO: Rename and change types and number of parameters
    public static r1 newInstance(String param1, String param2) {
        r1 fragment = new r1();
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
        View view= inflater.inflate(R.layout.fragment_r3, container, false);
        final singleDatabase dbref=new singleDatabase(getActivity());

        nameR=(EditText)view.findViewById(R.id.rName);
        phneR=(EditText)view.findViewById(R.id.rPhone);
        emailR=(EditText)view.findViewById(R.id.rEmail);
        addR=(EditText)view.findViewById(R.id.radd);
        cmtR=(EditText)view.findViewById(R.id.rComment);
        b=(Button)view.findViewById(R.id.AR);
        NSR=(Spinner)view.findViewById(R.id.referTo);


        nameSpinner.clear();

      //  nameSR.setAdapter(new ArrayAdapter<>(getActivity(),R.layout.spinner_item,nameSpinner));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=nameR.getText().toString();
                String p=phneR.getEditableText().toString();
                String e=emailR.getEditableText().toString();
                String a=addR.getEditableText().toString();
                String c=cmtR.getEditableText().toString();
                boolean r2=dbref.insertDataReferral(n,p,e,a,c);
                if(r2==true)
                {
                    Toast.makeText(getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                }
                else
                { Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                }


            }
        });

//dbref.removeReferralData();
        Cursor subR=dbref.getDataReferral();
        while(subR.moveToNext())
        {
            String n1=subR.getString(1);
            nameSpinner.add(n1);
        }
       NSR.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,nameSpinner));
        NSR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sn=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
  // nameSR.setAdapter(new ArrayAdapter<>(getActivity(),R.layout.spinner_item,nameSpinner));
      //  ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,nameSpinner);
     //   NSR.setAdapter(adapter);




       //List<ItemModelReferral> itemModelRList=new ArrayList<>();
       // for(int i=0;i<nameSpinner.size();i++)
      //  {
        //    ItemModelReferral itemModelR=new ItemModelReferral(nameSpinner.get(i));
        //    itemModelRList.add(itemModelR);

       // }
       // adapterR= new AdapterRef(itemModelRList,getActivity());
       // NSR.setAdapter(adapterR);

    //   nameSR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
     //       @Override
       //     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             //   if(position==0){

           //     }
            //    else {
               //   String st=parent.getItemAtPosition(position).toString();
              //     TextView textView1=view.findViewById(R.id.spid);
               //     textView1.setText(st);

              //  }

         //   }

  //          @Override
  //      public void onNothingSelected(AdapterView<?> parent) {

    //        }
    //   });


      //ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,nameSpinner);
        // ArrayAdapter<String> adp1;
       // adp1 = new ArrayAdapter<String>(this,R.array.ReferTo, simple_spinner_item, nameSpinner);
        //adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter.setDropDownViewResource(R.layout.spinner_item);









              //  com.sendMessage(n,p,e,a,c);

        //Intent intent=new Intent(getActivity(),addreferal.class);
       // Intent in=new Intent();
     //   in.putExtra("N",n);
       // intent.putExtra("NameR",n);
      //  intent.putExtra("PhoneR",p);
     //  intent.putExtra("EmailR",e);
     //   intent.putExtra("AddR",a);
     //  intent.putExtra("CommentR",c);
       // startActivity(intent);

        return view;
    }
    public class AdapterRef extends BaseAdapter{
        private List<ItemModelReferral> itemModelRList;
        private  List<ItemModelReferral> itemRFilter;
        private Context context;
        LayoutInflater inflater;

        public AdapterRef(List<ItemModelReferral> itemModelRList, Context context) {
            this.itemModelRList = itemModelRList;
            this.itemRFilter=itemModelRList;
            this.context = context;
            inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return itemRFilter.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=getLayoutInflater().inflate(R.layout.spinner_item,null);
            TextView textView1=view.findViewById(R.id.spid);
            textView1.setText(itemRFilter.get(position).getNameRF());
            return view;
        }
    }

   // public interface communication{
      //  public void sendMessage(String name,String phone,String email,String address, String comment);
  //  }

  //  @Override
  //  public void onAttach(Context context) {
      //  super.onAttach(context);
       // Activity activity=(Activity)context;

       // try {
      //      com=(communication)activity;
       // }
       // catch (ClassCastException e){
         //   throw  new ClassCastException(activity.toString()+"Must implement communication");
       // }
   // }
}
