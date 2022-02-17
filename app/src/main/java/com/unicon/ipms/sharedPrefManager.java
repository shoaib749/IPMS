package com.unicon.ipms;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedPrefManager {
    private static sharedPrefManager instance;
    private static Context ctx;

    private static final String SHARED_PREF_NAME="IPMS";
    private static final String KEY_USER_FNAME="fname";
    private static final String KEY_USER_LNAME="lname";
    private static final String KEY_USER_EMAIL="email_id";

    private sharedPrefManager(Context context) {
        ctx = context;

    }

    public static synchronized sharedPrefManager getInstance(Context context) {
        if (instance == null) {
            instance = new sharedPrefManager(context);
        }
        return instance;
    }

    public boolean userLogin(String fname,String lname,String email){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_USER_FNAME,fname);
        editor.putString(KEY_USER_LNAME,lname);
        editor.putString(KEY_USER_EMAIL,email);
        editor.apply();

        return true;
    }
    public boolean islogedIn(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USER_EMAIL,null)!=null){
            return true;
        }
        return false;

    }
    public boolean logout(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    public String getUsername(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL,null);
    }
    public String getEmail(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL,null);
    }
}
