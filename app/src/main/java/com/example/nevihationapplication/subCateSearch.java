package com.example.nevihationapplication;

import android.content.Context;
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

public class subCateSearch extends AppCompatActivity {

    SearchView searchViewS;
    GridView gridViewS;
    customAdapterSub adapterS;



    singleDatabase dataSub;

    ArrayList<String> namS1=new ArrayList<String>();
    ArrayList<Integer> namS2=new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_cate_search);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataSub=new singleDatabase(this);

        searchViewS=findViewById(R.id.subSearch);
        gridViewS=findViewById(R.id.gridS);

        int num4=5;
        int num5=4;
        int num6=1;
        String a1="81 Computer,IT & Software Training";
        String b1="191 Software Development & IT Consultant";
        String c1="211 Web Development & Marketing Services";

       //  Boolean r1=dataSub.insertDataS(a1,num4);
       // Boolean r1=dataSub.insertDataS(b1,num5);
        //   Boolean r1=dataSub.insertDataS(c1,num6);
        //  if(r1==true)
        //    {
        //  Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        //  }
        //   else
        //  {
        //Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        //  }

        namS1.clear();
        namS2.clear();

        Cursor subC=dataSub.getDataS();
        while (subC.moveToNext()) {
            String subName=subC.getString(1);
            int subNum=subC.getInt(2);
            namS1.add(subName);
            namS2.add(subNum);
        }

        List<ItemModelSub>  itemModelSubList=new ArrayList<>();

        for(int i=0;i<namS1.size();i++)
        {
            ItemModelSub itemModelSub=new ItemModelSub(namS1.get(i),namS2.get(i));
            itemModelSubList.add(itemModelSub);

        }
        adapterS=new customAdapterSub(itemModelSubList,this);
        gridViewS.setAdapter(adapterS);

        searchViewS.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterS.getFilter().filter(newText);
                return true;
            }
        });

    }

    public class customAdapterSub extends BaseAdapter implements Filterable {

        private List<ItemModelSub> itemModelSubList;
        private  List<ItemModelSub> itemSubFilter;
        private Context context;

        public customAdapterSub(List<ItemModelSub> itemModelSubList, Context context) {
            this.itemModelSubList = itemModelSubList;
            this.itemSubFilter=itemModelSubList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemSubFilter.size();
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
            View view=getLayoutInflater().inflate(R.layout.subcategory_item,null);
            TextView textView1=view.findViewById(R.id.txt1);
            TextView textView2=view.findViewById(R.id.txt2);
            textView1.setText(itemSubFilter.get(position).getNames());
            textView2.setText(String.valueOf(itemSubFilter.get(position).getNums()));
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
                        filterResults.count=itemModelSubList.size();
                        filterResults.values=itemModelSubList;
                    }
                    else {
                        String serachstr=constraint.toString().toLowerCase();
                        List<ItemModelSub> resulDaTaS=new ArrayList<>();
                        for (ItemModelSub itemModelSub:itemModelSubList)
                        {
                            if(itemModelSub.getNames().toLowerCase(Locale.getDefault()).startsWith(serachstr))
                            {
                                resulDaTaS.add(itemModelSub);
                                filterResults.count=resulDaTaS.size();
                                filterResults.values=resulDaTaS;
                            }
                        }
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemSubFilter= (List<ItemModelSub>) results.values;
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
