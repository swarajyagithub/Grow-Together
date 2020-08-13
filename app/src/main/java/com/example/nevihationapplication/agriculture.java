package com.example.nevihationapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class agriculture extends AppCompatActivity {

    SearchView searchViewAgri;
    GridView gridViewA;
    AdapterAgri adapterAgri;


    singleDatabase dataagri;
    ArrayList<String> namAgriS=new ArrayList<String>();
    ArrayList<Integer> namAgriI=new ArrayList<Integer>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataagri=new singleDatabase(this);
        searchViewAgri=findViewById(R.id.agriSearch);
        gridViewA=findViewById(R.id.gridAgri);



        int num7=4;
        int num8=1;
        int num9=1;
        String a7="01 Bird Seeds,Poultry & Animal Food";
        String b8="31 Farming & Pet Animals";
        String c9="81 Fresh Flowers,Plants & Trees";


     // Boolean r1=dataagri.insertDataAgri(a7,num7);
        //Boolean r1=dataagri.insertDataAgri(b8,num8);
       //  Boolean r1=dataagri.insertDataAgri(c9,num9);
        // if(r1==true)
         //  {
         // Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
       //   }
        //   else
      //    {
     //   Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
      //    }

       // dataagri.removeAgriData(a7);


        namAgriS.clear();
        namAgriI.clear();


        Cursor cagri=dataagri.getDataAgri();
        while (cagri.moveToNext())
        {
            String agriS=cagri.getString(1);
            int agriI=cagri.getInt(2);
            namAgriS.add(agriS);
            namAgriI.add(agriI);
        }

        List<ItemModelAgri> itemModelAgriList=new ArrayList<>();
        for(int i=0;i<namAgriS.size();i++)
        {
            ItemModelAgri itemModelAgri=new ItemModelAgri(namAgriS.get(i),namAgriI.get(i));
            itemModelAgriList.add(itemModelAgri);

        }
        adapterAgri=new AdapterAgri(itemModelAgriList,this);
        gridViewA.setAdapter(adapterAgri);

        searchViewAgri.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterAgri.getFilter().filter(newText);
                return true;
            }
        });








        //   t7.setText(namAgriS.get(0));
      //  t71.setText(String.valueOf(namAgriI.get(0)));
      //  t8.setText(namAgriS.get(3));
      //  t81.setText(String.valueOf(namAgriI.get(3)));
      //  t9.setText(namAgriS.get(4));
       // t91.setText(String.valueOf(namAgriI.get(4)));
    }

    public class AdapterAgri extends BaseAdapter implements Filterable {

        private List<ItemModelAgri> itemModelAgriList;
        private  List<ItemModelAgri> itemAgriFilter;
        private Context context;

        public AdapterAgri(List<ItemModelAgri> itemModelAgriList, Context context) {
            this.itemModelAgriList = itemModelAgriList;
            this.itemAgriFilter=itemModelAgriList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemAgriFilter.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view=getLayoutInflater().inflate(R.layout.agri_item_layout,null);
            TextView textView1=view.findViewById(R.id.txtAgri1);
            TextView textView2=view.findViewById(R.id.txtAgri2);
            textView1.setText(itemAgriFilter.get(position).getNameA());
            textView2.setText(String.valueOf(itemAgriFilter.get(position).getNumA()));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String IT = "01 Bird Seeds,Poultry & Animal Food";
                    if(IT.equals(itemAgriFilter.get(position).getNameA()))
                    {
                        Intent intent=new Intent(agriculture.this,birds_seed_layout.class);
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
                        { filterResults.count=itemModelAgriList.size();
                           filterResults.values=itemModelAgriList;
                }
                    else {
                            String serachstr=constraint.toString().toLowerCase();
                            List<ItemModelAgri> resulDaTaS=new ArrayList<>();
                            for (ItemModelAgri itemModelAgri:itemModelAgriList)
                             {
                           if(itemModelAgri.getNameA().toLowerCase(Locale.getDefault()).startsWith(serachstr))
                           {
                             resulDaTaS.add(itemModelAgri);
                            filterResults.count=resulDaTaS.size();
                            filterResults.values=resulDaTaS;
                             }
                            }
                            }
                               return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {

                    itemAgriFilter= (List<ItemModelAgri>) results.values;
                        notifyDataSetChanged();
                }
            };
            return filter;
        }

        // @Override
       // public Filter getFilter() {
          //  Filter filter=new Filter() {
           //     @Override
            //    protected FilterResults performFiltering(CharSequence constraint) {
               //     FilterResults filterResults=new FilterResults();
               //     if(constraint==null||constraint.length()==0)
               //     {
                //        filterResults.count=itemModelAgriList.size();
                 //       filterResults.values=itemModelAgriList;
                 //   }
                 //   else {
                    //    String serachstr=constraint.toString().toLowerCase();
                    //    List<ItemModelAgri> resulDaTaS=new ArrayList<>();
                    //    for (ItemModelAgri itemModelAgri:itemModelAgriList)
                   //     {
                         //   if(itemModelAgri.getNameA().toLowerCase(Locale.getDefault()).startsWith(serachstr))
                         //   {
                           //     resulDaTaS.add(itemModelAgri);
                            //    filterResults.count=resulDaTaS.size();
                           //     filterResults.values=resulDaTaS;
                       //     }
                    //    }
                //    }
             //       return filterResults;
             //   }

             //   @Override
              //  protected void publishResults(CharSequence constraint, FilterResults results) {
               //     itemAgriFilter= (List<ItemModelAgri>) results.values;
               //     notifyDataSetChanged();

            //    }
        //    };
         //   return filter;
     //   }
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

   // @Override
  //  public boolean onCreateOptionsMenu(Menu menu) {
      //   MenuInflater inflater=getMenuInflater();
      //   inflater.inflate(R.menu.filtericon,menu);

     //   return true;
   // }
}
