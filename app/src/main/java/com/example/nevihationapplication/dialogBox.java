package com.example.nevihationapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class dialogBox extends AppCompatDialogFragment {
    private TextView txenq;
    private EditText enqry;
    private TextView txtN;
    private TextView txtM;
    private TextView txtE;
    private EditText edtN;
    private EditText edtM;
    private EditText edtE;
    private EditText edtEx;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater=getActivity().getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.layout_dailogbox,null);
        builder.setView(view).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("send enquiry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        txenq=view.findViewById(R.id.textEnquiry);
        enqry=view.findViewById(R.id.edtenq);
        txtN=view.findViewById(R.id.tName);
        txtM=view.findViewById(R.id.txtMobile);
        txtE=view.findViewById(R.id.id);
        edtN=view.findViewById(R.id.edtName);
        edtM=view.findViewById(R.id.edtmbl);
        edtE=view.findViewById(R.id.edtId);
        edtEx=view.findViewById(R.id.Ex);
        return builder.create();
    }
}
