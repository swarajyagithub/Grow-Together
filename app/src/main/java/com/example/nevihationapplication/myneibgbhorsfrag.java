package com.example.nevihationapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link myneibgbhorsfrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class myneibgbhorsfrag extends Fragment {
    GridView gridViewPostNei;
    AdapterPostN adapterPostN;

    ArrayList<String> arrayImageP=new ArrayList<String>();
    ArrayList<String> arrayNmae=new ArrayList<String>();
    ArrayList<String> arrayPincode=new ArrayList<String>();
    ArrayList<String> arrayPost=new ArrayList<String>();
    ArrayList<String> arrayImagePost=new ArrayList<String>();
    ArrayList<String> arrayEmail=new ArrayList<String>();

    ArrayList<String> arrayImageP1=new ArrayList<String>();
    ArrayList<String> arrayNmae1=new ArrayList<String>();
    ArrayList<String> arrayPincode1=new ArrayList<String>();
    ArrayList<String> arrayPost1=new ArrayList<String>();
    ArrayList<String> arrayImagePost1=new ArrayList<String>();

    ArrayList<String> arrayImageP2=new ArrayList<String>();
    ArrayList<String> arrayNmae2=new ArrayList<String>();
    ArrayList<String> arrayPincode2=new ArrayList<String>();
    ArrayList<String> arrayPost2=new ArrayList<String>();
    ArrayList<String> arrayImagePost2=new ArrayList<String>();

    ArrayList<String> arrayyear=new ArrayList<String>();
    ArrayList<String> arraymonth=new ArrayList<String>();
    ArrayList<String> arraydate=new ArrayList<String>();
    ArrayList<String> arrayhour=new ArrayList<String>();
    ArrayList<String> arrayminutes=new ArrayList<String>();

    ArrayList<String> arrayyearL=new ArrayList<String>();
    ArrayList<String> arraymonthL=new ArrayList<String>();
    ArrayList<String> arraydateL=new ArrayList<String>();
    ArrayList<String> arrayhourL=new ArrayList<String>();
    ArrayList<String> arrayminutesL=new ArrayList<String>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Override
    public void onStart() {
        super.onStart();
        //check if usr is logged in
        //if loggedin move to home-page activity
        sessionmanagement ss=new sessionmanagement(getActivity());
        int userId= ss.getSession();
        if(userId!=-1){
            Intent intent=new Intent(getActivity(),home_page.class);
            startActivity(intent);
        }
    }


    public myneibgbhorsfrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment myneibgbhorsfrag.
     */
    // TODO: Rename and change types and number of parameters
    public static myneibgbhorsfrag newInstance(String param1, String param2) {
        myneibgbhorsfrag fragment = new myneibgbhorsfrag();
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
        View view= inflater.inflate(R.layout.fragment_myneibgbhorsfrag, container, false);
        final singleDatabase db=new singleDatabase(getActivity());
        arrayImageP.clear();
        arrayNmae.clear();
        arrayPost.clear();
        arrayImagePost.clear();
        arrayPincode.clear();

        arrayImageP1.clear();
        arrayNmae1.clear();
        arrayPost1.clear();
        arrayImagePost1.clear();
        arrayPincode1.clear();

        arrayImageP2.clear();
        arrayNmae2.clear();
        arrayPost2.clear();
        arrayImagePost2.clear();
        arrayPincode2.clear();
        logindialogbox l=new logindialogbox();
        String s=l.s1;

        Cursor c1=db.getFirstNameNei(s);
        while (c1.moveToNext())
        {
            String pincode=c1.getString(11);
            arrayPincode.add(pincode);
        }



            Cursor c2 = db.getPinCodeDataNei(arrayPincode.get(0));
            while (c2.moveToNext()) {
                String image = c2.getString(15);
                String Name = c2.getString(11);
                String postd = c2.getString(9);
                String postimage = c2.getString(8);
                String email = c2.getString(1);
                arrayImageP.add(image);
                arrayNmae.add(Name);
                arrayPost.add(postd);
                arrayImagePost.add(postimage);
                arrayEmail.add(email);
            }



        for(int i=0;i<arrayNmae.size();i++)
        {
           if(s.equals(arrayEmail.get(i))){
               arrayImageP1.add(arrayImageP.get(i));
               arrayNmae1.add(arrayNmae.get(i));
               arrayPost1.add(arrayPost.get(i));
               arrayImagePost1.add(arrayImagePost.get(i));
           }
           else {
               arrayImageP2.add(arrayImageP.get(i));
               arrayNmae2.add(arrayNmae.get(i));
               arrayPost2.add(arrayPost.get(i));
               arrayImagePost2.add(arrayImagePost.get(i));
           }
        }

        List<ItemModelPostN> itemModelPoNList=new ArrayList<>();
        for(int i=0;i<arrayNmae2.size();i++)
        {
            ItemModelPostN itemModelPoN=new ItemModelPostN(arrayImageP2.get(i),arrayNmae2.get(i),arrayPost2.get(i),arrayImagePost2.get(i));
            itemModelPoNList.add(itemModelPoN);

        }

        gridViewPostNei=(GridView)view.findViewById(R.id.gridPN);
        adapterPostN= new AdapterPostN(itemModelPoNList,getActivity());
        gridViewPostNei.setAdapter(adapterPostN);

        return view;
    }

    public  class AdapterPostN extends BaseAdapter{

        private List<ItemModelPostN> itemModelPoNList;
        private  List<ItemModelPostN> itemPoNFilter;
        private Context context;
        LayoutInflater inflater;

        public AdapterPostN(List<ItemModelPostN> itemModelPoNList, Context context) {
            this.itemModelPoNList = itemModelPoNList;
            this.itemPoNFilter=itemModelPoNList;
            this.context = context;
            inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return itemPoNFilter.size();
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
            View view=getLayoutInflater().inflate(R.layout.neighbor_post_item,null);

            TextView T1=(TextView)view.findViewById(R.id.time1);
            TextView T2=(TextView)view.findViewById(R.id.time2);;



            final singleDatabase db=new singleDatabase(getActivity());

            logindialogbox l=new logindialogbox();
            String s=l.s1;

            arrayminutes.clear();
            arrayhour.clear();
            arraydate.clear();
            arraymonth.clear();
            arrayyear.clear();

            arrayminutesL.clear();
            arrayhourL.clear();
            arraydateL.clear();
            arraymonthL.clear();
            arrayyearL.clear();


            Cursor cursor=db.getPosDataNei(s);
            while (cursor.moveToNext()) {
                String year=cursor.getString(17);
                String month=cursor.getString(16);
                String date=cursor.getString(12);
                String hour=cursor.getString(18);
                String minutes=cursor.getString(13);
                arrayyear.add(year);
                arraymonth.add(month);
                arraydate.add(date);
                arrayhour.add(hour);
                arrayminutes.add(minutes);

            }

            Cursor cursor1=db.getLoginDateNei(s);
            while (cursor1.moveToNext()) {
                String lyear=cursor1.getString(2);
                String lmonth=cursor1.getString(3);
                String ldate=cursor1.getString(4);
                String lhour=cursor1.getString(6);
                String lminutes=cursor1.getString(5);
                arrayyearL.add(lyear);
                arraymonthL.add(lmonth);
                arraydateL.add(ldate);
                arrayhourL.add(lhour);
                arrayminutesL.add(lminutes);

            }

            // T1.setText(arraydate.get(0));
            // T1.setText(arraydateL.get(0));



         //   int dyear=Integer.parseInt(arrayyearL.get(0))-Integer.parseInt(arrayyear.get(0));
         //   int dmonth=Integer.parseInt(arraymonthL.get(0))-Integer.parseInt(arraymonth.get(0));
          //  int ddate=Integer.parseInt(arraydateL.get(0))-Integer.parseInt(arraydate.get(0));
          //  int dhour=Integer.parseInt(arrayhourL.get(0))-Integer.parseInt(arrayhour.get(0));
         //   int dminute=Integer.parseInt(arrayminutesL.get(0))-Integer.parseInt(arrayminutes.get(0));

           // if(dyear==0){
               // if(dmonth==0){
                  //  if(ddate==0){
                     //   if(dhour==0){
                         //   if(dminute==0){
                             //   T1.setText("0");
                            //    T2.setText("minutes");
                        //    }
                        //    else {
                           //     if(dminute==1) {

                               //     T1.setText("1");
                              //      T2.setText("minute");
                              //  }
                            //    else {
                                //    String diffminutes = String.valueOf(dminute);
                                //    T1.setText(diffminutes);
                                //    T2.setText("minutes");
                           //     }
                          //  }
                     //   }
                   //     else{
                        //    String diffhour = String.valueOf(dhour);
                         //   T1.setText(diffhour);
                         //   T2.setText("hours");
                       // }
                 //   }
                  //  else{
                   //     if(ddate==1) {

                        //    T1.setText("1");
                        //    T2.setText("day");
                      //  }else{
                         //   String diffdate = String.valueOf(ddate);
                         //   T1.setText(diffdate);
                        //    T2.setText("days");
                  //      }
                  //  } }
              //  else {
             //       if(dmonth==1){

                  //      T1.setText("1");
                   //     T2.setText("month");}
                 //   else {
                   //     String diffmonth=String.valueOf(dmonth);
                   //     T1.setText(diffmonth);
                    //    T2.setText("months");
                //    }
             //   }


         //   }
         //   else {
            //    if(dyear==1){

               //     T1.setText("1");
                //    T2.setText("year");
              //  }
               // else {
                //    String diffyear = String.valueOf(dyear);
                 //   T1.setText(diffyear);
            //        T2.setText("years");
           //     }
         //   }


            ImageView profilpic=(ImageView)view.findViewById(R.id.pphotoN);
            TextView name=(TextView)view.findViewById(R.id.nameN);
            TextView postrequest=(TextView)view.findViewById(R.id.postN);
            ImageView postImage=(ImageView)view.findViewById(R.id.imgpostN);
            profilpic.setImageURI(Uri.parse(itemPoNFilter.get(position).getProfilepicN()));
            name.setText(itemPoNFilter.get(position).getNamN());
            postrequest.setText(itemPoNFilter.get(position).getPostdataN());
            postImage.setImageURI(Uri.parse(itemPoNFilter.get(position).getPostimageN()));
            return view;
        }
    }
}
