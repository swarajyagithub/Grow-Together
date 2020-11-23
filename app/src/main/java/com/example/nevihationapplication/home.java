package com.example.nevihationapplication;

import android.content.Context;
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
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {

    GridView gridViewPost;
    AdapterPost adapterPost;


    TextView t1;
    TextView t2;

    TextView ans;

    ArrayList<String> arrayImageP=new ArrayList<String>();
    ArrayList<String> arrayNmae=new ArrayList<String>();
    ArrayList<String> arrayQu=new ArrayList<String>();
    ArrayList<String> arrayPost=new ArrayList<String>();
    ArrayList<String> arrayImagePost=new ArrayList<String>();

    ArrayList<String> arrayyear=new ArrayList<String>();
    ArrayList<String> arraymonth=new ArrayList<String>();
    ArrayList<String> arraydate=new ArrayList<String>();
    ArrayList<String> arrayhour=new ArrayList<String>();
    ArrayList<String> arrayminutes=new ArrayList<String>();
    ArrayList<Integer> arrayID=new ArrayList<Integer>();


    ArrayList<String> arrayyearL=new ArrayList<String>();
    ArrayList<String> arraymonthL=new ArrayList<String>();
    ArrayList<String> arraydateL=new ArrayList<String>();
    ArrayList<String> arrayhourL=new ArrayList<String>();
    ArrayList<String> arrayminutesL=new ArrayList<String>();

    ArrayList<String> arrayShowTime1=new ArrayList<String>();
    ArrayList<String> arrayShowTime2=new ArrayList<String>();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
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
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        final singleDatabase db=new singleDatabase(getActivity());
        arrayImageP.clear();
        arrayNmae.clear();
        arrayQu.clear();
        arrayPost.clear();
        arrayImagePost.clear();


          arrayminutes.clear();
          arrayhour.clear();
          arraydate.clear();
          arraymonth.clear();
          arrayyear.clear();
          arrayID.clear();

          arrayminutesL.clear();
           arrayhourL.clear();
           arraydateL.clear();
            arraymonthL.clear();
            arrayyearL.clear();

            arrayShowTime1.clear();
            arrayShowTime2.clear();



        logindialogbox l=new logindialogbox();
        String s=l.s1;


        Cursor cursor=db.getPosDataNei(s);
        while (cursor.moveToNext()) {
            String image=cursor.getString(15);
            String Name=cursor.getString(11);
            String qutq=cursor.getString(7);
            String postd=cursor.getString(9);
            String postimage=cursor.getString(8);
            arrayImageP.add(image);
            arrayNmae.add(Name);
            arrayQu.add(qutq);
            arrayPost.add(postd);
            arrayImagePost.add(postimage);

        }

        Cursor cursor2=db.getPosDataNei(s);
          while (cursor2.moveToNext()) {
           String year=cursor2.getString(17);
           String month=cursor2.getString(16);
           String date=cursor2.getString(12);
           String hour=cursor2.getString(18);
            String minutes=cursor2.getString(13);
            int id=cursor2.getInt(0);
           arrayyear.add(year);
           arraymonth.add(month);
           arraydate.add(date);
            arrayhour.add(hour);
            arrayminutes.add(minutes);
            arrayID.add(id);

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

            for(int j=0;j<arrayID.size();j++){
                int dyear=Integer.parseInt(arrayyearL.get(0))-Integer.parseInt(arrayyear.get(j));
                    int dmonth=Integer.parseInt(arraymonthL.get(0))-Integer.parseInt(arraymonth.get(j));
                   int ddate=Integer.parseInt(arraydateL.get(0))-Integer.parseInt(arraydate.get(j));
                    int dhour=Integer.parseInt(arrayhourL.get(0))-Integer.parseInt(arrayhour.get(j));
                   int dminute=Integer.parseInt(arrayminutesL.get(0))-Integer.parseInt(arrayminutes.get(j));

                if(dyear==0){
                          if(dmonth==0){
                               if(ddate==0){

                      if(dhour==0){
                       if(dminute==0){
                    //    T1.setText("0");
                    //    T2.setText("minutes");
                        //   db.insertshowTime("","");
                           db.updateShowTime(arrayID.get(j),"0","minute");
                       }
                       else {
                           if(dminute==1) {

                    //       T1.setText("1");
                    //      T2.setText("minute");
                            //   db.insertshowTime("","");
                               db.updateShowTime(arrayID.get(j),"1","minute");
                       }
                       else {
                          String diffminutes = String.valueOf(dminute);
                    //      T1.setText(diffminutes);
                    //      T2.setText("minutes");
                             //  db.insertshowTime("","");
                               db.updateShowTime(arrayID.get(j),diffminutes,"minutes");
                        }
                       }
                        }
                        else{
                         String diffhour = String.valueOf(dhour);
                    //     T1.setText(diffhour);
                    //     T2.setText("hours");
                       //   db.insertshowTime("","");
                          db.updateShowTime(arrayID.get(j),diffhour,"hours");
                       }
                       }
                       else{
                        if(ddate==1) {

                    //      T1.setText("1");
                    //      T2.setText("day");
                         //   db.insertshowTime("","");
                            db.updateShowTime(arrayID.get(j),"1","day");
                      }else{
                        String diffdate = String.valueOf(ddate);
                    //    T1.setText(diffdate);
                    //    T2.setText("days");
                       //     db.insertshowTime("","");
                            db.updateShowTime(arrayID.get(j),diffdate,"days");
                        }
                        } }
                     else {
                       if(dmonth==1){

                    //    T1.setText("1");
                    //    T2.setText("month");
                         //  db.insertshowTime("","");
                           db.updateShowTime(arrayID.get(j),"1","month");
                               }
                        else {
                        String diffmonth=String.valueOf(dmonth);
                    //     T1.setText(diffmonth);
                    //    T2.setText("months");
                         //  db.insertshowTime("","");
                           db.updateShowTime(arrayID.get(j),diffmonth,"months");
                       }
                     }


                      }
                     else {
                      if(dyear==1){

                    //    T1.setText("1");
                    //     T2.setText("year");
                        //  db.insertshowTime("","");
                          db.updateShowTime(arrayID.get(j),"1","year");
                      }
                      else {
                        String diffyear = String.valueOf(dyear);
                    //     T1.setText(diffyear);
                    //     T2.setText("years");
                     //     db.insertshowTime("","");
                          db.updateShowTime(arrayID.get(j),diffyear,"years");
                     }
                     }

                }


        Cursor cursorT=db.getShowTimeData(s);
        while (cursorT.moveToNext()) {
            String t1=cursorT.getString(19);
            String t2=cursorT.getString(20);

           arrayShowTime1.add(t1);
           arrayShowTime2.add(t2);


        }


        List<ItemModelPost> itemModelPoList=new ArrayList<>();
        for(int i=0;i<arrayNmae.size();i++)
        {
            ItemModelPost itemModelPo=new ItemModelPost(arrayImageP.get(i),arrayNmae.get(i),arrayQu.get(i),arrayPost.get(i),arrayImagePost.get(i),arrayShowTime1.get(i),arrayShowTime2.get(i));
            itemModelPoList.add(itemModelPo);

        }

        gridViewPost=(GridView)view.findViewById(R.id.gridP);


        adapterPost= new AdapterPost(itemModelPoList,getActivity());
        gridViewPost.setAdapter(adapterPost);

        return view;
    }

    public class AdapterPost extends BaseAdapter{

        private List<ItemModelPost> itemModelPoList;
        private  List<ItemModelPost> itemPoFilter;
        private Context context;
        LayoutInflater inflater;

        public AdapterPost(List<ItemModelPost> itemModelPoList, Context context) {
            this.itemModelPoList = itemModelPoList;
            this.itemPoFilter=itemModelPoList;
            this.context = context;
            inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return itemPoFilter.size();
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
            View view=getLayoutInflater().inflate(R.layout.post_request_item,null);
            ImageView profilpic=(ImageView)view.findViewById(R.id.pphoto);
            TextView name=(TextView)view.findViewById(R.id.name);
            TextView quotation=(TextView)view.findViewById(R.id.q);
            TextView postrequest=(TextView)view.findViewById(R.id.post);
            ImageView postImage=(ImageView)view.findViewById(R.id.imgpost);

            TextView T1=(TextView)view.findViewById(R.id.time1);
            TextView T2=(TextView)view.findViewById(R.id.time2);;



            final singleDatabase db=new singleDatabase(getActivity());

            logindialogbox l=new logindialogbox();
            String s=l.s1;

          //  arrayminutes.clear();
          //  arrayhour.clear();
          //  arraydate.clear();
          //  arraymonth.clear();
          //  arrayyear.clear();

          //  arrayminutesL.clear();
         //   arrayhourL.clear();
         //   arraydateL.clear();
        //    arraymonthL.clear();
        //    arrayyearL.clear();


        //    Cursor cursor=db.getPosDataNei(s);
          //  while (cursor.moveToNext()) {
             //   String year=cursor.getString(17);
             //   String month=cursor.getString(16);
             //   String date=cursor.getString(12);
             //   String hour=cursor.getString(18);
            //    String minutes=cursor.getString(13);
             //   arrayyear.add(year);
             //   arraymonth.add(month);
             //   arraydate.add(date);
            //    arrayhour.add(hour);
            //    arrayminutes.add(minutes);

          //  }

          //  Cursor cursor1=db.getLoginDateNei(s);
        //    while (cursor1.moveToNext()) {
              //  String lyear=cursor1.getString(2);
              //  String lmonth=cursor1.getString(3);
             //   String ldate=cursor1.getString(4);
             //   String lhour=cursor1.getString(6);
             //   String lminutes=cursor1.getString(5);
             //   arrayyearL.add(lyear);
             //   arraymonthL.add(lmonth);
             //   arraydateL.add(ldate);
             //   arrayhourL.add(lhour);
             //   arrayminutesL.add(lminutes);

          //  }

           // T1.setText(arraydate.get(0));
           // T1.setText(arraydateL.get(0));



         //   int dyear=Integer.parseInt(arrayyearL.get(0))-Integer.parseInt(arrayyear.get(0));
        //    int dmonth=Integer.parseInt(arraymonthL.get(0))-Integer.parseInt(arraymonth.get(0));
        //   int ddate=Integer.parseInt(arraydateL.get(0))-Integer.parseInt(arraydate.get(0));
        //    int dhour=Integer.parseInt(arrayhourL.get(0))-Integer.parseInt(arrayhour.get(0));
         //   int dminute=Integer.parseInt(arrayminutesL.get(0))-Integer.parseInt(arrayminutes.get(0));

        //   if(dyear==0){
         //      if(dmonth==0){
        //           if(ddate==0){

                       //  if(dhour==0){
                          //   if(dminute==0){
                             //    T1.setText("0");
                             //    T2.setText("minutes");
                          //   }
                         //    else {
                         //        if(dminute==1) {

                              //       T1.setText("1");
                               //      T2.setText("minute");
                              //   }
                              //   else {
                               //      String diffminutes = String.valueOf(dminute);
                               //      T1.setText(diffminutes);
                               //      T2.setText("minutes");
                             //    }
                          //   }
                     //    }
                     //    else{
                       //      String diffhour = String.valueOf(dhour);
                        //     T1.setText(diffhour);
                        //     T2.setText("hours");
                      //   }
                //   }
                //   else{
                   //    if(ddate==1) {

                     //      T1.setText("1");
                     //      T2.setText("day");
                     //  }else{
                       //    String diffdate = String.valueOf(ddate);
                       //    T1.setText(diffdate);
                       //    T2.setText("days");
                  //     }
               //    } }
             //  else {
                //   if(dmonth==1){

               //    T1.setText("1");
              //    T2.setText("month");}
               //    else {
                  //     String diffmonth=String.valueOf(dmonth);
                  //     T1.setText(diffmonth);
                   //    T2.setText("months");
               //    }
             //  }


         //  }
         //  else {
             //  if(dyear==1){

               //    T1.setText("1");
              //     T2.setText("year");
             //  }
             //  else {
              //     String diffyear = String.valueOf(dyear);
              //     T1.setText(diffyear);
              //     T2.setText("years");
             //  }
          // }


            profilpic.setImageURI(Uri.parse(itemPoFilter.get(position).getProfilepic()));
            name.setText(itemPoFilter.get(position).getName());
           quotation.setText(itemPoFilter.get(position).getQuotation());
            postrequest.setText(itemPoFilter.get(position).getPostdata());
            postImage.setImageURI(Uri.parse(itemPoFilter.get(position).getPostimage()));

            T1.setText(itemPoFilter.get(position).getpShowTime1());
            T2.setText(itemPoFilter.get(position).getpShowTime2());




            return view;
        }
    }
}
