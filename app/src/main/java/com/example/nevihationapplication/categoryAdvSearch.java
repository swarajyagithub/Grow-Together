package com.example.nevihationapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class categoryAdvSearch extends AppCompatActivity {

    Spinner spinner;



    SearchView searchViewA;
    GridView gridViewA;
    AdapterAdvCat adapterAdvCat;

    singleDatabase datadbAdv;
    ArrayList<String> arrayNameAdv=new ArrayList<String>();
    ArrayList<Integer> arrayImgAdv=new ArrayList<Integer>();








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_adv_search);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner=findViewById(R.id.spinner);
        gridViewA=findViewById(R.id.gridAdv);

        datadbAdv=new singleDatabase(this);
        arrayNameAdv.clear();
        arrayImgAdv.clear();

        Cursor cData=datadbAdv.getCategory();
        while (cData.moveToNext())
        {
            String categoryName=cData.getString(1);
            int categoryImage=cData.getInt(2);
            arrayNameAdv.add(categoryName);
            arrayImgAdv.add(categoryImage);
        }

        List<ItemModelAdv> itemModelAdvList=new ArrayList<>();

        for(int i=0;i<arrayNameAdv.size();i++)
        {
            ItemModelAdv itemModelAdv=new ItemModelAdv(arrayNameAdv.get(i),arrayImgAdv.get(i));
            itemModelAdvList.add(itemModelAdv);
        }
        adapterAdvCat=new AdapterAdvCat(itemModelAdvList,this);
        gridViewA.setAdapter(adapterAdvCat);







    }

    public class AdapterAdvCat extends BaseAdapter{

        private List<ItemModelAdv> itemModelAdvList;
        private List<ItemModelAdv> itemModelAdvFiltered;
        private Context context;

        public AdapterAdvCat(List<ItemModelAdv> itemModelAdvList, Context context) {
            this.itemModelAdvList = itemModelAdvList;
            this.itemModelAdvFiltered=itemModelAdvList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemModelAdvFiltered.size();
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
            final View view=getLayoutInflater().inflate(R.layout.cat_adv_item,null);
            TextView textView=view.findViewById(R.id.txtA);
            final ImageView imageView=view.findViewById(R.id.imgA);
            imageView.setImageResource(itemModelAdvFiltered.get(position).getImageAdv());
            textView.setText(itemModelAdvFiltered.get(position).getNameAdv());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String IT = "Agriculture & Farming";
                    if(IT.equals(itemModelAdvFiltered.get(position).getNameAdv()))
                    {
                        Intent intent=new Intent(categoryAdvSearch.this,birds_seed_layout.class);
                        startActivity(intent);
                    }
                }
            });
            return view;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.searchicon,menu);
        return true;
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


