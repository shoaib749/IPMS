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

    }







