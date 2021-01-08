package com.example.nevihationapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class status extends AppCompatActivity {

    TextView Email;
    TextView Uid;
    TextView Status;
    Button Send;
    Button Refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Email=findViewById(R.id.txtEmail);
        Uid =findViewById(R.id.txtUID);
        Status=findViewById(R.id.txtStatus);
        Send=findViewById(R.id.sendV);
        Refresh=findViewById(R.id.refresh);
        
        sentInfo();

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Send.setEnabled(false);

                FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Send.setEnabled(true);

                        if(task.isSuccessful())
                        {
                            Toast.makeText(status.this,"Verification email sent to : "+FirebaseAuth.getInstance().getCurrentUser().getEmail(),Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(status.this,"Failed to send verification email.",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().getCurrentUser().reload().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        sentInfo();
                    }
                });
            }
        });

    }

    private void sentInfo() {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        Email.setText(new StringBuffer("EMAIL: ").append(user.getEmail()));
        Uid.setText(new StringBuffer("UID: ").append(user.getUid()));
        Status.setText(new StringBuffer("STATUS: ").append(String.valueOf(user.isEmailVerified())));
    }
}
