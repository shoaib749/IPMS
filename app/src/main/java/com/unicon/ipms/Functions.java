package com.unicon.ipms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
    public boolean isStringOnlyAlphabet(String str) {
        return ((str != null) && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }

    public boolean invalidNoOfChars(String str, int num) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ')
                count++;
        }
        if (count > num) {
            return true;
        }
        return false;
    }

    public boolean invalidEmail(String str) {
        final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(str);
        return matcher.find();
    }

    public boolean invalidPasswordChars(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ')
                count++;
        }
        if (count < 8 || count > 16) {
            return true;
        } else {
            return false;
        }
    }

    public boolean invalidPassword(String str1, String str2) {
        return str1.equals(str2);
    }

    public static boolean invalidNum(String s) {
        Pattern p = Pattern.compile("[0-9]{8}");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }

    public boolean cannotBeBlank(String str) {
        return str.equals("");
    }

    public static boolean invalidPhone(String s) {
        Pattern p = Pattern.compile("(0|91)?[6-9][0-9]{9}");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }

    public boolean invalidYear(String s) {
        Pattern p = Pattern.compile("[0-9]{4}");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }

    public boolean invalidPer(String s) {
        if (Integer.parseInt(s) > 100 || Integer.parseInt(s) < 0) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean invalidCGPA(String s){
        if (Float.parseFloat(s)>10.0 ||(Float.parseFloat(s)<1.0)){
            return true;
        }
        else{
            return false;
        }
    }



}







