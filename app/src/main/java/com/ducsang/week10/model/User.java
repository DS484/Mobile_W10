package com.ducsang.week10.model;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private int id;
    private String username;
    private String name;
    private String email;
    private String gender;
    private String avtBase64;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvtBase64() {
        return avtBase64;
    }

    public void setAvtBase64(String avtBase64) {
        this.avtBase64 = avtBase64;
    }

    // Chuyển User thành JSON
    public String toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("name", name);
            json.put("username", username);
            json.put("email", email);
            json.put("gender", gender);
            json.put("avatar", avtBase64); // Thêm ảnh vào JSON
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    // Tạo User từ JSON
    public static User fromJson(String jsonString) {
        User user = new User();
        try {
            JSONObject json = new JSONObject(jsonString);
            user.name = json.getString("name");
            user.username = json.getString("username");
            user.gender = json.getString("gender");
            user.id = json.getInt("id");
            user.email = json.getString("email");
            user.avtBase64 = json.optString("avatar", null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }
}
