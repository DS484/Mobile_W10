package com.ducsang.week10;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ducsang.week10.model.User;

public class UserManager {
    private static final String PREF_NAME = "UserPrefs";
    private static final String KEY_USER = "user_data";

    public static void saveUser(Context context, User user) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_USER, user.toJson()); // Lưu dưới dạng JSON
        editor.apply();
    }

    public static User getUser(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String userJson = prefs.getString(KEY_USER, null);
        return userJson != null ? User.fromJson(userJson) : null;
    }

    public static void clearUser(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().remove(KEY_USER).apply();
    }

}
