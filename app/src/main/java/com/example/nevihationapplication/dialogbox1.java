package com.example.nevihationapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class dialogbox1 extends AppCompatDialogFragment {
    private TextView txenqT;
    private TextView enqryT;
    private TextView txtNT;
    private TextView txtMT;
    private TextView txtET;
    private TextView edtNT;
    private TextView edtMT;
    private TextView edtET;
    private EditText edtExT;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dioalogbox1,null);
        builder.setView(view).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Send Enuiry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        txenqT=view.findViewById(R.id.textEnquiryT);
        enqryT=view.findViewById(R.id.edtenqT);
        txtNT=view.findViewById(R.id.tNameT);
        txtMT=view.findViewById(R.id.txtMobileT);
        txtET=view.findViewById(R.id.idT);
        edtNT=view.findViewById(R.id.edtNameT);
        edtMT=view.findViewById(R.id.edtmblT);
        edtET=view.findViewById(R.id.edtIdT);
        edtExT=view.findViewById(R.id.ExT);


        return builder.create();
    }




}
