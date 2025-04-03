package com.ducsang.week10;

import android.content.Context;
import android.content.SharedPreferences;

public class ImageManager {
    private static final String PREF_NAME = "UserPrefs";
    private static final String KEY_USER_IMAGE_URL = "image";
    private SharedPreferences sharedPreferences;

    // Constructor
    public ImageManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    // Lưu URL ảnh của người dùng
    public void saveUserImageUrl(String imageUrl) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_IMAGE_URL, imageUrl);
        editor.apply();  // Dùng apply() thay vì commit() để không chờ đợi kết quả lưu
    }

    // Lấy URL ảnh của người dùng
    public String getUserImageUrl() {
        return sharedPreferences.getString(KEY_USER_IMAGE_URL, null);
    }

    // Xóa URL ảnh (nếu cần)
    public void clearUserImageUrl() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_USER_IMAGE_URL);
        editor.apply();
    }
}
