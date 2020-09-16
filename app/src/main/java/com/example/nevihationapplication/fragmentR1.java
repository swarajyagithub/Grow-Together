package com.example.nevihationapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentR1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentR1 extends Fragment {
    GridView gridV;
    AdapterReferral adapterR;
    ArrayList<String> namReferral=new ArrayList<String>();
    Button b1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentR1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentR1.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentR1 newInstance(String param1, String param2) {
        fragmentR1 fragment = new fragmentR1();
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
        View view= inflater.inflate(R.layout.fragment_r1, container, false);
        b1=(Button)view.findViewById(R.id.addRF);
        namReferral.clear();
        final singleDatabase dbr=new singleDatabase(getActivity());

        Cursor subR=dbr.getDataReferral();
        while(subR.moveToNext())
        {
            String n=subR.getString(1);
            namReferral.add(n);
        }
        List<ItemModelReferral> itemModelRList=new ArrayList<>();
        for(int i=0;i<namReferral.size();i++)
        {
            ItemModelReferral itemModelR=new ItemModelReferral(namReferral.get(i));
            itemModelRList.add(itemModelR);

        }
        gridV=(GridView)view.findViewById(R.id.gridVRF);


        adapterR= new AdapterReferral(itemModelRList,getActivity());
        gridV.setAdapter(adapterR);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),addreferal.class);
                startActivity(i);
            }
        });


        return view;
    }
    public class AdapterReferral extends BaseAdapter{
        private List<ItemModelReferral> itemModelRList;
        private  List<ItemModelReferral> itemRFilter;
        private Context context;
        LayoutInflater inflater;

        public AdapterReferral(List<ItemModelReferral> itemModelRList, Context context) {
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
            View view=getLayoutInflater().inflate(R.layout.referral_item,null);
            TextView textView1=view.findViewById(R.id.NR);
            textView1.setText(itemRFilter.get(position).getNameRF());
            return view;
        }
    }
}
