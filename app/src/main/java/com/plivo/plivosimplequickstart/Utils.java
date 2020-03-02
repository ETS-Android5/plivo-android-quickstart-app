package com.plivo.plivosimplequickstart;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

public class Utils {
    // endpoint username & password
    static final String USERNAME = "sanity180521094254";
    static final String PASSWORD = "12345";

    static final String HH_MM_SS = "%02d:%02d:%02d";
    static final String MM_SS = "%02d:%02d";
    static String deviceToken = "";
    private static SharedPreferences mSharedPreferences;
    private static Context context;

    public static HashMap<String, Object> options = new HashMap<String, Object>()
    {{
        put("enableTracking",true);
    }};

    static String from(String fromContact, String fromSip) {
        String from = TextUtils.isEmpty(fromContact)?
                TextUtils.isEmpty(fromSip)? "" : fromSip:
                fromContact;
        return from.contains("\"") ?
                from.substring(from.indexOf("\"")+1, from.lastIndexOf("\"")):
                from;

    }

    static String to(String toSip) {
        return TextUtils.isEmpty(toSip) ? "" :
                toSip.substring(toSip.indexOf(":")+1, toSip.indexOf("@"));
    }

    static String getDeviceToken() {
        context = (Context) options.get("context");
        mSharedPreferences = context.getSharedPreferences("plivo_refs", Context.MODE_PRIVATE);
        return mSharedPreferences.getString("token1", "");
    }

    static void setDeviceToken(String newDeviceToken) {
        deviceToken = newDeviceToken;
        context = (Context) options.get("context");
        mSharedPreferences = context.getSharedPreferences("plivo_refs", Context.MODE_PRIVATE);
        mSharedPreferences.edit().putString("token1", newDeviceToken).apply();
    }
}
