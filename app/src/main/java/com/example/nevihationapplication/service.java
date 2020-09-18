package com.example.nevihationapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class service extends AppCompatActivity {
    private static final int GALLERY_REQUEST_CODE = 123;
    GridView g;
    AdapterService adapter;
    Button add;
    ArrayList<String> companyName=new ArrayList<String>();
    ArrayList<String> pName=new ArrayList<String>();
    ArrayList<String> prz=new ArrayList<String>();
    ArrayList<String> curren=new ArrayList<String>();
    ArrayList<String> ims=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        g=findViewById(R.id.gridSer);
        add=findViewById(R.id.addSer);
        singleDatabase db=new singleDatabase(this);
        companyName.clear();
        pName.clear();
        prz.clear();
        curren.clear();
        ims.clear();

    // db.removeS1Data();
  //     db.removeS2Data();
//Receive image from activity addService.java
        //Intent intent=getIntent();
         //   String s=intent.getStringExtra("IM");
          //  db.insertIPData("IMAGE",s);
           // Cursor get=db.getIPData();
          //  while (get.moveToNext()){
           //     String s1=get.getString(2);
           //     ims.add(s1);
         //   }

      //  Intent receiverdIntent = getIntent();
     //   String action = receiverdIntent.getAction();
     //   String type = receiverdIntent.getType();
      //  if (Intent.ACTION_SEND.equals(action) && type != null) {
           // if (type.startsWith("image/*")) {
             //   Uri imageUri = (Uri) receiverdIntent.getParcelableExtra(Intent.EXTRA_STREAM);// Handle single image being sent
              //  String k=imageUri.toString();
              //  db.insertIPData("IMAGE",k);
              //  Cursor get=db.getIPData();
              //    while (get.moveToNext()){
              //       String s1=get.getString(2);
               //      ims.add(s1);
               //    }
          //  }
     //   }


        Cursor subC = db.getSData();
        while (subC.moveToNext()) {
            String comName = subC.getString(1);
            String pnm = subC.getString(2);
            String cr = subC.getString(5);
            String pr = subC.getString(6);
            String img=subC.getString(8);


            companyName.add(comName);
            pName.add(pnm);
            curren.add(cr);
            prz.add(pr);
            ims.add(img);

        }
        List<ItemModelService> itemModelCM1List = new ArrayList<>();

        for (int i = 0; i < companyName.size(); i++) {
            ItemModelService itemModelCM1 = new ItemModelService(companyName.get(i),pName.get(i),prz.get(i),curren.get(i),ims.get(i));
            itemModelCM1List.add(itemModelCM1);

        }
        adapter = new AdapterService(itemModelCM1List, this);
        g.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(service.this,addServices.class);
                startActivity(i);
            }
        });

    }
    public  class AdapterService extends BaseAdapter{

        private List<ItemModelService> itemModelCM1List;
        private List<ItemModelService> itemCM1Filter;
        private Context context;


        public AdapterService(List<ItemModelService> itemModelCM1List, Context context) {
            this.itemModelCM1List = itemModelCM1List;
            this.itemCM1Filter = itemModelCM1List;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemCM1Filter.size();
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
            View view = getLayoutInflater().inflate(R.layout.service_item, null);
            TextView textView1 = view.findViewById(R.id.cNameS);
            TextView textView2 = view.findViewById(R.id.pnS);
            TextView textView3 = view.findViewById(R.id.crS);
            TextView textView4 = view.findViewById(R.id.prS);
            ImageView imageView=view.findViewById(R.id.imser);

            textView1.setText(itemCM1Filter.get(position).getCompanyNameGS());
            textView2.setText(itemCM1Filter.get(position).getProductNameGS());
            textView3.setText(itemCM1Filter.get(position).getCurrencyGS());
            textView4.setText(itemCM1Filter.get(position).getPrizeGS());

       //   Intent intent=getIntent();
      //    String s=intent.getStringExtra("IM");
        //    Uri u=Uri.parse(s);
          //  imageView.setImageURI(itemCM1Filter.get(position).getImageGS());

               // Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
          //      intent.addCategory(Intent.CATEGORY_OPENABLE);
         //   intent.setAction(Intent.ACTION_GET_CONTENT);
         //   intent.setType("image/*");

          //  Intent in=new Intent();
          //  in.setType("image/*");
         //   in.setAction(Intent.ACTION_OPEN_DOCUMENT);
           // Intent intent = new Intent();
           // intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
         //   intent.addCategory(Intent.CATEGORY_OPENABLE);
         //   intent.setType("image/*");


         //   startActivityForResult(intent, 1);
                // Optionally, specify a URI for the file that should appear in the
                // system file picker when it loads.
            //startActivityForResult(Intent.createChooser(intent,"Pick an image"),GALLERY_REQUEST_CODE);
           imageView.setImageURI(Uri.parse(itemCM1Filter.get(position).getImageGS()));


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
