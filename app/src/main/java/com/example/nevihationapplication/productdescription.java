package com.example.nevihationapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class  productdescription extends AppCompatActivity implements dialogBox.ExampleDailogListner {


Button senden;
singleDatabase diadata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdescription);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        diadata=new singleDatabase(this);

        senden=findViewById(R.id.sendenq);

        senden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });



    }

 public void openDialog(){
   dialogBox dibox=new dialogBox();
   dibox.show(getSupportFragmentManager(),"example dialog");
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

    @Override
    public void applyText(String Enquiry, String Name, int Mobile, String email) {
      boolean r2=diadata.insertDataDialog(Enquiry,Name,Mobile,email);
          if(r2==true)
            {
            Toast.makeText(getApplicationContext(),"Sent Enquiry",Toast.LENGTH_LONG).show();
           }
             else
              { Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
           }
    }
}
