package com.example.nevihationapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment  {

    GridView gridViewEn;
     AdapterEn adapterEn;

    private TextView txenqT;
    private TextView enqryT;
    private TextView txtNT;
    private TextView txtMT;
    private TextView txtET;
    private TextView edtNT;
    private TextView edtMT;
    private TextView edtET;
    private EditText edtExT;



    ArrayList<String> namEn=new ArrayList<String>();
    ArrayList<String> namNm=new ArrayList<String>();
    ArrayList<Integer> namMb=new ArrayList<Integer>();
    ArrayList<String> namEm=new ArrayList<String>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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
        View rootView= inflater.inflate(R.layout.fragment_blank, container, false);
        final singleDatabase dbenquiry=new singleDatabase(getActivity());
        namEn.clear();
        namNm.clear();
        namMb.clear();
        namEm.clear();


        Cursor subEn=dbenquiry.getDataEnquiry();
        while (subEn.moveToNext()) {
            String subEnquiry=subEn.getString(1);
            String subName=subEn.getString(2);
            int subMobile=subEn.getInt(3);
            String subEmail=subEn.getString(4);
            namEn.add(subEnquiry);
            namNm.add(subName);
            namMb.add(subMobile);
            namEm.add(subEmail);

        }
       // TextView t=(TextView)rootView.findViewById(R.id.t1);
       // t.setText(namEn.get(0));
        List<ItemModelEn> itemModelEnList=new ArrayList<>();
        for(int i=0;i<namEn.size();i++)
        {
            ItemModelEn itemModelEn=new ItemModelEn(namEn.get(i),namNm.get(i),namMb.get(i),namEm.get(i));
            itemModelEnList.add(itemModelEn);

        }


       gridViewEn=(GridView)rootView.findViewById(R.id.gridEn);


        adapterEn= new AdapterEn(itemModelEnList,getActivity());
        gridViewEn.setAdapter(adapterEn);

        return rootView;


    }


    public class AdapterEn extends BaseAdapter{

    private List<ItemModelEn> itemModelEnList;
    private  List<ItemModelEn> itemEnFilter;
    private Context context;
    LayoutInflater inflater;


    public AdapterEn(List<ItemModelEn> itemModelEnList, Context context) {
        this.itemModelEnList = itemModelEnList;
        this.itemEnFilter=itemModelEnList;
        this.context = context;
        inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return itemEnFilter.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view=getLayoutInflater().inflate(R.layout.enquiry_item,null);
        TextView textView1=view.findViewById(R.id.edt);
        Button bt=view.findViewById(R.id.edtb);
        bt.setText("View Enquiry");
        textView1.setText(itemEnFilter.get(position).getNameNm());

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //  dialogbox1 d=new dialogbox1();
              // d.show(getFragmentManager(),"Example dialog");
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                LayoutInflater inflater=getActivity().getLayoutInflater();
                View view=inflater.inflate(R.layout.dioalogbox1,null);
                builder.setView(view).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Send Enquiry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                txenqT=view.findViewById(R.id.textEnquiryT);
                enqryT=view.findViewById(R.id.edtenqT);
                txtNT=view.findViewById(R.id.tNameT);
                txtMT=view.findViewById(R.id.txtMobileT);
                txtET=view.findViewById(R.id.idT);
                edtNT=view.findViewById(R.id.edtNameT);
                edtMT=view.findViewById(R.id.edtmblT);
                edtET=view.findViewById(R.id.edtIdT);
                edtExT=view.findViewById(R.id.ExT);
                enqryT.setText(itemEnFilter.get(position).getNameEn());
                edtNT.setText(itemEnFilter.get(position).getNameNm());
                edtMT.setText(String.valueOf(itemEnFilter.get(position).getNameMb()));
                edtET.setText(itemEnFilter.get(position).getNameEm());



                builder.show();
               // return builder.create();
            }
        });




        return view;
    }




}



}
