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
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class birds_seed_layout extends AppCompatActivity {

    singleDatabase bird;
    SearchView searchViewBird;
    GridView gridViewB;
    AdapterBird adapterBird;

    ArrayList<String> namBrd1=new ArrayList<String>();
    ArrayList<String> namBrd2=new ArrayList<String>();
    ArrayList<String> namBrd3=new ArrayList<String>();
    ArrayList<String> namBrd4=new ArrayList<String>();
    ArrayList<Integer> imgBrd=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds_seed_layout);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bird=new singleDatabase(this);
        searchViewBird=findViewById(R.id.birdSearch);
        gridViewB=findViewById(R.id.gridBird);


        String n1="hfjjjc";
        String n2="hfjjjc";
        String n3="रु 0.00";
        String n4="रु 0.00";

        String na1="t";
        String na2="t";
        String na3="रु 0.00";
        String na4="रु 0.00";

        String nam1="Test Product";
        String nam2="Test Product";
        String nam3="रु 0.00";
        String nam4="रु 2500.00";

        String name1="Sub";
        String name2="Sub";
        String name3="रु 0.00";
        String name4="रु 0.00";


        String b1="@drawable/h";
        int ib1=getResources().getIdentifier(b1,null,getPackageName());
       // boolean r2=bird.insertDataB(n1,n2,n3,n4,ib1);

        String ba1="@drawable/crm";
        int iba1=getResources().getIdentifier(ba1,null,getPackageName());
       // boolean r2=bird.insertDataB(na1,na2,na3,na4,iba1);

        String bam1="@drawable/wirebundle";
        int ibam1=getResources().getIdentifier(bam1,null,getPackageName());
        //boolean r2=bird.insertDataB(nam1,nam2,nam3,nam4,ibam1);

        String bame1="@drawable/crm";
        int ibame1=getResources().getIdentifier(bame1,null,getPackageName());
       // boolean r2=bird.insertDataB(name1,name2,name3,name4,ibame1);


      //  if(r2==true)
      //    {
      //    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
      //   }
      //     else
     //      { Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
      //   }

       // bird.removeBirdData(n1);
       // bird.removeBirdData(na1);
        //bird.removeBirdData(nam1);
       // bird.removeBirdData(name1);

        namBrd1.clear();
        namBrd2.clear();
        namBrd3.clear();
        namBrd4.clear();
         imgBrd.clear();


        Cursor cbrd=bird.getDataBrd();
        while (cbrd.moveToNext()) {
            String brdN1 = cbrd.getString(1);
            String brdN2 = cbrd.getString(2);
            String brdN3 = cbrd.getString(3);
            String brdN4 = cbrd.getString(4);
            int brdI = cbrd.getInt(5);
            namBrd1.add(brdN1);
            namBrd2.add(brdN2);
            namBrd3.add(brdN3);
            namBrd4.add(brdN4);
            imgBrd.add(brdI);
        }


        List<ItemModelBird> itemModelBirdList=new ArrayList<>();
        for(int i=0;i<namBrd1.size();i++)
        {
            ItemModelBird itemModelBird=new ItemModelBird(namBrd1.get(i),namBrd2.get(i),namBrd3.get(i),namBrd4.get(i),imgBrd.get(i));
            itemModelBirdList.add(itemModelBird);

        }
        adapterBird=new AdapterBird(itemModelBirdList,this);
        gridViewB.setAdapter(adapterBird);

        searchViewBird.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterBird.getFilter().filter(newText);
                return true;
            }
        });



    }

    public  class AdapterBird extends BaseAdapter implements Filterable
    {
        private List<ItemModelBird> itemModelBirdList;
        private  List<ItemModelBird> itemBirdFilter;
        private Context context;

        public AdapterBird(List<ItemModelBird> itemModelBirdList, Context context) {
            this.itemModelBirdList = itemModelBirdList;
            this.itemBirdFilter=itemModelBirdList;
            this.context = context;
        }

       @Override
        public int getCount() {
            return itemBirdFilter.size();
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
            View view=getLayoutInflater().inflate(R.layout.bird_item_layout,null);
            ImageView imBird=view.findViewById(R.id.imgBirds);
            TextView textView1=view.findViewById(R.id.txtBird1);
            TextView textView2=view.findViewById(R.id.txtBird2);
            TextView textView3=view.findViewById(R.id.txtBird3);
            TextView textView4=view.findViewById(R.id.txtBird4);
            textView1.setText(itemBirdFilter.get(position).getNameB1());
            textView2.setText(itemBirdFilter.get(position).getNameB2());
            textView3.setText(itemBirdFilter.get(position).getNameB3());
            textView4.setText(itemBirdFilter.get(position).getNameB4());
            imBird.setImageResource(itemBirdFilter.get(position).getNumB());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String IT = "Test Product";
                    if(IT.equals(itemBirdFilter.get(position).getNameB1()))
                    {
                        Intent intent=new Intent(birds_seed_layout.this,productdescription.class);
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
                        filterResults.count=itemModelBirdList.size();
                        filterResults.values=itemModelBirdList;
                    }
                    else {
                        String serachstr=constraint.toString().toLowerCase();
                        List<ItemModelBird> resulDaTaS=new ArrayList<>();
                        for (ItemModelBird itemModelBird:itemModelBirdList)
                        {
                            if(itemModelBird.getNameB1().toLowerCase(Locale.getDefault()).startsWith(serachstr))
                            {
                                resulDaTaS.add(itemModelBird);
                                filterResults.count=resulDaTaS.size();
                                filterResults.values=resulDaTaS;
                            }
                        }
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemBirdFilter= (List<ItemModelBird>) results.values;
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
   //  @Override
    //  public boolean onCreateOptionsMenu(Menu menu) {
    //   MenuInflater inflater=getMenuInflater();
     //  inflater.inflate(R.menu.filtericon,menu);
     //  return true;
  //   }
}


















