
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.nevihationapplication.R.id;
import static com.example.nevihationapplication.R.layout;

public class company extends AppCompatActivity {
    GridView gridViewCom;
    CompanyAdapter companyAdapter;

    singleDatabase dataCompany;
    FloatingActionButton fot;


    ArrayList<String> companyName=new ArrayList<String>();
    ArrayList<String> ceoName=new ArrayList<String>();
    ArrayList<String> companyEmail=new ArrayList<String>();
    ArrayList<String> companyCity=new ArrayList<String>();
    ArrayList<String> companyMobile=new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_company);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataCompany=new singleDatabase(this);

        gridViewCom=findViewById(id.gridCompany);

        final Button bt1=findViewById(R.id.addData);





        companyName.clear();
        ceoName.clear();
        companyEmail.clear();
        companyCity.clear();
        companyMobile.clear();
        // dataCompany.removeCompanyData("India");
        dataCompany.removeCompanyData("Afganistan");
        //dataCompany.removeCompanyData("Australia");

        Cursor subC = dataCompany.getDataCompany();
        while (subC.moveToNext()) {
            String comName = subC.getString(1);
            String ceoN = subC.getString(2);
            String comEmail = subC.getString(9);
            String comCity = subC.getString(7);
            String comMobile = subC.getString(11);
            companyName.add(comName);
            ceoName.add(ceoN);
            companyEmail.add(comEmail);
            companyCity.add(comCity);
            companyMobile.add(comMobile);
        }


        List<ItemModelCompany> itemModelCMList = new ArrayList<>();

        for (int i = 0; i < companyName.size(); i++) {
            ItemModelCompany itemModelCM = new ItemModelCompany(companyName.get(i), ceoName.get(i), companyEmail.get(i), companyCity.get(i), companyMobile.get(i));
            itemModelCMList.add(itemModelCM);

        }
        companyAdapter = new CompanyAdapter(itemModelCMList, this);
        gridViewCom.setAdapter(companyAdapter);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(company.this, editCompany.class);
                startActivity(intent);
            }
        });




    }

    public class CompanyAdapter extends BaseAdapter {


        private List<ItemModelCompany> itemModelCMList;
        private List<ItemModelCompany> itemCMFilter;
        private Context context;

        public CompanyAdapter(List<ItemModelCompany> itemModelCMList, Context context) {
            this.itemModelCMList = itemModelCMList;
            this.itemCMFilter = itemModelCMList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemCMFilter.size();
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
            View view = getLayoutInflater().inflate(layout.companyedit_item, null);
            TextView textView1 = view.findViewById(id.cName);
            TextView textView2 = view.findViewById(id.cCOE);
            TextView textView3 = view.findViewById(id.cEmail);
            TextView textView4 = view.findViewById(id.cMob);
            TextView textView5 = view.findViewById(id.cCity);
            Button bedit = view.findViewById(id.cEdit);

            textView1.setText(itemCMFilter.get(position).getComName());
            textView2.setText(itemCMFilter.get(position).getCeoName());
            textView3.setText(itemCMFilter.get(position).getComEmail());
            textView4.setText(itemCMFilter.get(position).getComMobile());
            textView5.setText(itemCMFilter.get(position).getComCity());
            bedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(company.this, saveCompany.class);
                    startActivity(in);


                }
            });


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



