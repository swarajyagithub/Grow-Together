package com.example.nevihationapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.SearchView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class searchbox extends AppCompatActivity {

    SearchView searchView;
    GridView gridView;
    customAdapter adapterI;



   singleDatabase datadb;
    ArrayList<String> arrayName=new ArrayList<String>();
    ArrayList<Integer> arrayImg=new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchbox);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        searchView=findViewById(R.id.sv);
        gridView=findViewById(R.id.grid);

        //searchView.setQuery("Category Search...",true);

        datadb=new singleDatabase(this);

        arrayName.clear();
        arrayImg.clear();

        String a = "Agriculture & Farming";
        String b = "Apparel & Garments";
        String c = "Automobile, Parts & Spares";
        String d = "Building & Construction";
        String e = "Bussiness & Audit Services";
        String f = "Computer & IT Solutions";
        String g = "Education & Learning";
        String h = "Electronics";


        //getting identifier of drawable resources and storing it into database(imageURLData2)
        //First Image

        // String aURL="@drawable/agri1";
        // int aURL1=getResources().getIdentifier(aURL,null,getPackageName());
        //  boolean r2=datadb.addCategory(a,aURL1);

        // String gURL="@drawable/gar";
        //  int gURL1=getResources().getIdentifier(gURL,null,getPackageName());
        //  boolean r2=datadb.addCategory(b,gURL1);

        //   String auURL="@drawable/saprs";
        //  int auURL1=getResources().getIdentifier(auURL,null,getPackageName());
        //  boolean r2=datadb.addCategory(c,auURL1);

        //   String buiURL="@drawable/construction";
        //   int buiURL1=getResources().getIdentifier(buiURL,null,getPackageName());
        //  boolean r2=datadb.addCategory(d,buiURL1);

        //  String audURL="@drawable/audit1";
        //  int audURL1=getResources().getIdentifier(audURL,null,getPackageName());
        //  boolean r2=datadb.addCategory(e,audURL1);

        //String itURL="@drawable/it";
        // int itURL1=getResources().getIdentifier(itURL,null,getPackageName());
        // boolean r2=datadb.addCategory(f,itURL1);

        // String eduURL="@drawable/educa";
        //  int eduURL1=getResources().getIdentifier(eduURL,null,getPackageName());
        //  boolean r2=datadb.addCategory(g,eduURL1);

        //   String elURL="@drawable/ele";
        //  int elURL1=getResources().getIdentifier(elURL,null,getPackageName());
        //   boolean r2=datadb.addCategory(h,elURL1);



        //if image is inserted successfully,then display message "Data Inserted"
        //if(r2==true)
        //  {
        //  Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        //  }
        //   else
        //   { Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        // }



        Cursor cData=datadb.getCategory();
        while (cData.moveToNext())
        {
            String categoryName=cData.getString(1);
            int categoryImage=cData.getInt(2);
           arrayName.add(categoryName);
           arrayImg.add(categoryImage);
        }

        List<ItemModel> itemModelList=new ArrayList<>();

        for(int i=0;i<arrayName.size();i++)
        {
            ItemModel itemModel=new ItemModel(arrayName.get(i),arrayImg.get(i));
            itemModelList.add(itemModel);
        }
        adapterI=new customAdapter(itemModelList,this);
        gridView.setAdapter(adapterI);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterI.getFilter().filter(newText);
                return true;
            }
        });





    }
    public class customAdapter extends BaseAdapter implements Filterable
    {
        private List<ItemModel> itemModelelList;
        private List<ItemModel> itemModelFiltered;
        private Context context;



        public customAdapter(List<ItemModel> itemModelelList, Context context) {
            this.itemModelelList = itemModelelList;
            this.itemModelFiltered=itemModelelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemModelFiltered.size();
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
            final View view=getLayoutInflater().inflate(R.layout.rawdata,null);
            TextView textView=view.findViewById(R.id.txt);
            final ImageView imageView=view.findViewById(R.id.img);
            imageView.setImageResource(itemModelFiltered.get(position).getImage());
            textView.setText(itemModelFiltered.get(position).getName());

           view.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String IT = "Computer & IT Solutions";
                   if(IT.equals(itemModelFiltered.get(position).getName()))
                       {
                           Intent intent=new Intent(searchbox.this,subcategory.class);
                           startActivity(intent);
                       }

               }
           });
            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter=new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults=new FilterResults();
                    if(constraint==null||constraint.length()==0)
                    {
                        filterResults.count=itemModelelList.size();
                        filterResults.values=itemModelelList;
                    }
                    else {
                        String searStr=constraint.toString().toLowerCase();
                        List<ItemModel> resultData=new ArrayList<>();
                        for (ItemModel itemModel:itemModelelList)
                        {
                            if(itemModel.getName().toLowerCase(Locale.getDefault()).startsWith(searStr)) {

                                resultData.add(itemModel);

                                filterResults.count = resultData.size();
                                filterResults.values = resultData;
                            }
                        }
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemModelFiltered= (List<ItemModel>) results.values;
                    notifyDataSetChanged();

                }
            };
            return filter;


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
