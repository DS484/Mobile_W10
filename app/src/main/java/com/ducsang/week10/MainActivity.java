package com.ducsang.week10;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducsang.week10.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create user
//        User user = new User();
//        user.setId(3);
//        user.setUsername("ds");
//        user.setName("Duc Sang");
//        user.setEmail("duc@example.com");
//        user.setGender("Nam");
//        user.setAvtBase64(null);
//        UserManager.saveUser(this, user);


        Intent intent = new Intent(MainActivity.this, ImageActivity.class);
        startActivity(intent);
        finish();
    }
}