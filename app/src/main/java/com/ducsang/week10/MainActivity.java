package com.ducsang.week10;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.ducsang.week10.model.User;

public class MainActivity extends AppCompatActivity {
    private ImageView avt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        avt = findViewById(R.id.imgChoose);

        ImageManager manager = new ImageManager(this);
        String imgUrl = manager.getUserImageUrl();

        if (imgUrl != null) {
            Glide.with(this).load(imgUrl).into(avt);
        }
    }

    public void profileImageOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, UploadFileActivity.class);
        startActivity(intent);
    }
}