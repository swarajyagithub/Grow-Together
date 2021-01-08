package com.example.nevihationapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class career extends AppCompatActivity {

    GridView gridViewCar;
    AdapterCareer adaptercareer;
    singleDatabase datacareer;
    Button addCareerinfo;

    ArrayList<String> namT=new ArrayList<String>();
    ArrayList<String> namL=new ArrayList<String>();
    ArrayList<String> namP=new ArrayList<String>();
    ArrayList<String> namNP=new ArrayList<String>();
    ArrayList<String> namD=new ArrayList<String>();
    ArrayList<String> namC=new ArrayList<String>();
    ArrayList<String> namw=new ArrayList<String>();
    ArrayList<String> namE=new ArrayList<String>();
    ArrayList<String> namJ=new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        datacareer=new singleDatabase(this);
        gridViewCar=findViewById(R.id.gridCareer);
        addCareerinfo=findViewById(R.id.addCareerData);
       // datacareer.removeCareerData("a");
       // datacareer.removeCareerData("Pune");
        addCareerinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(career.this,addcareer.class);
                startActivity(intent);
            }
        });
        namT.clear();
        namL.clear();
        namP.clear();;
        namNP.clear();
        namC.clear();
        namw.clear();
        namE.clear();
        namJ.clear();
        Cursor subC=datacareer.getDataCareer();
        while (subC.moveToNext()) {
            String subT=subC.getString(1);
            String subL=subC.getString(2);
            String subP=subC.getString(3);
            String subNP=subC.getString(4);
            String subCo=subC.getString(5);
            String subW=subC.getString(6);
            String subE=subC.getString(7);
            String subJ=subC.getString(8);
            String subD=subC.getString(9);
            namT.add(subT);
            namL.add(subL);
            namP.add(subP);
            namNP.add(subNP);
            namC.add(subCo);
            namw.add(subW);
            namE.add(subE);
            namJ.add(subJ);
            namD.add(subD);

        }

        List<ItemModelCareer> itemModelCarList=new ArrayList<>();

        for(int i=0;i<namT.size();i++)
        {
            ItemModelCareer itemModelCar=new ItemModelCareer(namT.get(i),namL.get(i),namP.get(i),namNP.get(i),namC.get(i),namw.get(i),namE.get(i),namJ.get(i),namD.get(i));
            itemModelCarList.add(itemModelCar);

        }
        adaptercareer=new AdapterCareer(itemModelCarList,this);
        gridViewCar.setAdapter(adaptercareer);

    }

    public  class AdapterCareer extends BaseAdapter{
        private List<ItemModelCareer> itemModelCarList;
        private  List<ItemModelCareer> itemCarFilter;
        private Context context;

        public AdapterCareer(List<ItemModelCareer> itemModelCarList, Context context) {
            this.itemModelCarList = itemModelCarList;
            this.itemCarFilter=itemModelCarList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemCarFilter.size();
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
            View view=getLayoutInflater().inflate(R.layout.career_item,null);
            TextView textView1=view.findViewById(R.id.edittitleT);
            TextView textView2=view.findViewById(R.id.editlocT);
            TextView textView3=view.findViewById(R.id.editpackT);
            TextView textView4=view.findViewById(R.id.editposT);
            TextView textView5=view.findViewById(R.id.spcompT);
            TextView textView6=view.findViewById(R.id.editexprT);
            TextView textView7=view.findViewById(R.id.edieducT);
            TextView textView8=view.findViewById(R.id.editjobcatT);
            TextView textView9=view.findViewById(R.id.editdiscT);
            textView1.setText(itemCarFilter.get(position).getComTitle());
            textView2.setText(itemCarFilter.get(position).getComLocation());
            textView3.setText(itemCarFilter.get(position).getComPackage());
            textView4.setText(itemCarFilter.get(position).getComNPosition());
            textView5.setText(itemCarFilter.get(position).getComCompany());
            textView6.setText(itemCarFilter.get(position).getComWork());
            textView7.setText(itemCarFilter.get(position).getComEducation());
            textView8.setText(itemCarFilter.get(position).getComJob());
            textView9.setText(itemCarFilter.get(position).getComDist());
          //  textView2.setText(String.valueOf(itemSubFilter.get(position).getNums()));
            return view;
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
