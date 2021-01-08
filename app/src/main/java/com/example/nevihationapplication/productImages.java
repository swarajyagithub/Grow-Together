package com.example.nevihationapplication;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class productImages extends AppCompatActivity {
    GridView grid;
    ArrayList<String> imageArrayS=new ArrayList<String>();
    ArrayList<Integer> imageArray=new ArrayList<Integer>();
    AdapterImage adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_images);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        singleDatabase idb=new singleDatabase(this);
        String a = "Agriculture & Farming";
        String b = "Apparel & Garments";
        String c = "Automobile, Parts & Spares";
        String d = "Building & Construction";
        String e = "Bussiness & Audit Services";
        String f = "Computer & IT Solutions";
        String g = "Education & Learning";
        String h = "Electronics";
        grid=findViewById(R.id.gridImgP);
        imageArray.clear();
         String aURL="@drawable/agri1";
         int aURL1=getResources().getIdentifier(aURL,null,getPackageName());
        // boolean r2=idb.addCategory(a,aURL1);
         String gURL="@drawable/gar";
          int gURL1=getResources().getIdentifier(gURL,null,getPackageName());
         // boolean r2=idb.addCategory(b,gURL1);

           String auURL="@drawable/saprs";
           int auURL1=getResources().getIdentifier(auURL,null,getPackageName());
        //  boolean r2=idb.addCategory(c,auURL1);


          String buiURL="@drawable/construction";
           int buiURL1=getResources().getIdentifier(buiURL,null,getPackageName());
         // boolean r2=idb.addCategory(d,buiURL1);
        String audURL="@drawable/audit1";
          int audURL1=getResources().getIdentifier(audURL,null,getPackageName());
         // boolean r2=idb.addCategory(e,audURL1);



        String itURL="@drawable/it";
         int itURL1=getResources().getIdentifier(itURL,null,getPackageName());
       //  idb.addCategory(f,itURL1);



         String eduURL="@drawable/educa";
          int eduURL1=getResources().getIdentifier(eduURL,null,getPackageName());
        //idb.addCategory(g,eduURL1);



           String elURL="@drawable/ele";
          int elURL1=getResources().getIdentifier(elURL,null,getPackageName());
      //  idb.addCategory(h,elURL1);


        String u1="@drawable/h";
        int x1=getResources().getIdentifier(u1,null,getPackageName());
      //  idb.addCategory("A",x1);
       // idb.removeCategory(h);

        String u2="@drawable/r1";
        int x2=getResources().getIdentifier(u2,null,getPackageName());
          //idb.addCategory("A",x2);
        String u3="@drawable/r2";
        int x3=getResources().getIdentifier(u3,null,getPackageName());
          //idb.addCategory("A",x3);
        String u4="@drawable/r3";
        int x4=getResources().getIdentifier(u4,null,getPackageName());
      //  idb.addCategory("A",x4);



        // if(r2==true)
       //   {
       //   Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
       //   }
         //  else
         //  { Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
       //  }
        Cursor cData=idb.getCategory();
        while (cData.moveToNext())
        {
            String categoryName=cData.getString(1);
            int categoryImage=cData.getInt(2);
            imageArrayS.add(categoryName);
            imageArray.add(categoryImage);
        }

        List<ItemModelImageProduct> itemModelIList=new ArrayList<>();

        for(int i=0;i<imageArrayS.size();i++)
        {
            ItemModelImageProduct itemModelI=new ItemModelImageProduct(imageArray.get(i),imageArrayS.get(i));
            itemModelIList.add(itemModelI);
        }
        adapter=new AdapterImage(itemModelIList,this);
        grid.setAdapter(adapter);

    }
    public class AdapterImage extends BaseAdapter{
        private List<ItemModelImageProduct> itemModelIList;
        private List<ItemModelImageProduct> itemModelIFiltered;
        private Context context;

        public AdapterImage(List<ItemModelImageProduct> itemModelIList, Context context) {
            this.itemModelIList = itemModelIList;
            this.itemModelIFiltered=itemModelIList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemModelIFiltered.size();
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
            final View view=getLayoutInflater().inflate(R.layout.product_item,null);

            final ImageView imageView=view.findViewById(R.id.idP);
            imageView.setImageResource(itemModelIFiltered.get(position).getImgProduct());

            //view.setOnClickListener(new View.OnClickListener() {
               // @Override
               // public void onClick(View v) {

                  //  Intent in=new Intent(productImages.this,addServices.class);
                  //  in.putExtra("I",itemModelIFiltered.get(position).getNameProduct());
                  //  in.putExtra("IMAGE",itemModelIFiltered.get(position).getImgProduct());
                  //  startActivity(in);
              //  }
           // });

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
