package com.example.nevihationapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class sessionmanagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String shared_preferanceName="SharedPreference";
    String session_key="sessionUser";

    public sessionmanagement(Context context) {
      sharedPreferences=context.getSharedPreferences(shared_preferanceName,Context.MODE_PRIVATE);
      editor=sharedPreferences.edit();
    }
    public  void saveSession(User user){
//save session of user:
         int id=user.getId();
         editor.putInt(session_key,id).commit();
    }

    public  int getSession(){
        //int:id of user
        //rerurn user Id whose session is saved:
       return sharedPreferences.getInt(session_key,-1);


    }

    public  void removeSession(){
        editor.putInt(session_key,-1).commit();
    }
}
