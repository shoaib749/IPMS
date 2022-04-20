package com.unicon.ipms;

import android.content.Context;
import android.content.SharedPreferences;

public class sharepref_moreInfo {
    private static sharepref_moreInfo instance;
    private static Context ctx;

    private static final String SHARED_PREF_NAME="IPMS_more_info";
    private static final String KEY_USER_FNAME="fname";
    private static final String KEY_USER_LNAME="lname";
    private static final String KEY_USER_EMAIL="email_id";
    private static final String KEY_USER_studentNo="student_no";
    private static final String KEY_USER_parentsNo="parents_no";
    private static final String KEY_USER_dept="dept";
    private static final String KEY_USER_registration="registration";
    private static final String KEY_USER_semester="semester";
    private static final String KEY_USER_pass10="pass10";
    private static final String KEY_USER_per10="per10";
    private static final String KEY_USER_pass12="pass12";
    private static final String KEY_USER_per12="per12";
    private static final String KEY_USER_passDip="passDip";
    private static final String KEY_USER_perDip="perDip";
    private static final String KEY_USER_admission="admission";
    private static final String KEY_USER_sgpa1="sgpa1";
    private static final String KEY_USER_sgpa2="sgpa2";
    private static final String KEY_USER_sgpa3="sgpa3";
    private static final String KEY_USER_sgpa4="sgpa4";
    private static final String KEY_USER_sgpa5="sgpa5";
    private static final String KEY_USER_sgpa6="sgpa6";
    private static final String KEY_USER_sgpa7="sgpa7";
    private static final String KEY_USER_sgpa8="sgpa8";
    private static final String KEY_USER_avgSgpa="abgSgpa";
    private static final String KEY_USER_passout="passout";
    private static final String KEY_USER_live="live";
    private static final String KEY_USER_dead="dead";
    private static final String KEY_USER_option1="option1";
    private static final String KEY_USER_placement_status="placement_status";
    private static final String KEY_USER_gap="gap";
    private static final String KEY_USER_PROFILE_URL = "profile_url";

    private sharepref_moreInfo(Context context) {
        ctx = context;

    }

    public static synchronized sharepref_moreInfo getInstance(Context context) {
        if (instance == null) {
            instance = new sharepref_moreInfo(context);
        }
        return instance;
    }
    // method to store moreInfo data into sarepref
    public boolean moreInfo_1(String fname,String lname,String email,String studentNo,String parentNo,String dept,String registration,String semester){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString(KEY_USER_FNAME,fname);
        editor.putString(KEY_USER_LNAME,lname);
        editor.putString(KEY_USER_EMAIL,email);
        editor.putString(KEY_USER_studentNo,studentNo);
        editor.putString(KEY_USER_parentsNo,parentNo);
        editor.putString(KEY_USER_dept,dept);
        editor.putString(KEY_USER_registration,registration);
        editor.putString(KEY_USER_semester,semester);
        editor.apply();

        return true;
    }
    public boolean moreInfo2(String pass10,String per10, String pass12, String per12, String passDip, String perDip){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_pass10,pass10);
        editor.putString(KEY_USER_per10,per10);
        editor.putString(KEY_USER_pass12,pass12);
        editor.putString(KEY_USER_per12,per12);
        editor.putString(KEY_USER_passDip,passDip);
        editor.putString(KEY_USER_perDip,perDip);
        editor.apply();
        return true;
    }
    public boolean moreInfo3(String admission,String sgpa1,String sgpa2,String sgpa3,String sgpa4,String sgpa5,String sgpa6,String sgpa7,String sgpa8,String avgSgpa,String passout,String live,String dead){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_admission,admission);
        editor.putString(KEY_USER_sgpa1,sgpa1);
        editor.putString(KEY_USER_sgpa2,sgpa2);
        editor.putString(KEY_USER_sgpa3,sgpa3);
        editor.putString(KEY_USER_sgpa4,sgpa4);
        editor.putString(KEY_USER_sgpa5,sgpa5);
        editor.putString(KEY_USER_sgpa6,sgpa6);
        editor.putString(KEY_USER_sgpa7,sgpa7);
        editor.putString(KEY_USER_sgpa8,sgpa8);
        editor.putString(KEY_USER_avgSgpa,avgSgpa);
        editor.putString(KEY_USER_passout,passout);
        editor.putString(KEY_USER_live,live);
        editor.putString(KEY_USER_dead,dead);
        editor.apply();
        return true;
    }
    public boolean moreInfo4(String option1,String placement_status,String gap){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.putString(KEY_USER_option1,option1);
        editor.putString(KEY_USER_placement_status,placement_status);
        editor.putString(KEY_USER_gap,gap);
        editor.apply();
        return true;
    }
    public boolean setProfile_url(String profile_url){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.putString(KEY_USER_PROFILE_URL,profile_url);
        editor.apply();
        return true;
    }
    public String getKeyUserProfileUrl(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_PROFILE_URL,null);
    }
    public String getfname(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_FNAME,null);
    }
    public String getlname(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_LNAME,null);
    }
    public String getemail(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_EMAIL,null);
    }
    public String getstudentNo(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_studentNo,null);
    }
    public String getparentsNo(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_parentsNo,null);
    }
    public String getdept(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_dept,null);
    }
    public String getregistration(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_registration,null);
    }
    public String getsemester(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_semester,null);
    }
    public String getpass10(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_pass10,null);
    }
    public String getpass12(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_pass12,null);
    }
    public String getper10(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_per10,null);
    }
    public String getper12(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_per12,null);
    }
    public String getpassDip(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_passDip,null);
    }
    public String getperDip(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_perDip,null);
    }
    public String getadmission(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_admission,null);
    }
    public String getsgpa1(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_sgpa1,null);
    }
    public String getsgpa2(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_sgpa2,null);
    }
    public String getsgpa3(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_sgpa3,null);
    }
    public String getsgpa4(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_sgpa4,null);
    }
    public String getsgpa5(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_sgpa5,null);
    }
    public String getsgpa6(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_sgpa6,null);
    }
    public String getsgpa7(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_sgpa7,null);
    }
    public String getsgpa8(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_sgpa8,null);
    }
    public String getavgSgpa(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_avgSgpa,null);
    }
    public String getpassout(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_USER_passout,null);
    }
    public String getlive(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_USER_live,null);
    }
    public String getdead(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_USER_dead,null);
    }
    public String getoption1(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_USER_option1,null);
    }
    public String getplacement_status(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_USER_placement_status,null);
    }
    public String getgap(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_USER_gap,null);
    }

}
