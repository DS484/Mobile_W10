package com.ducsang.week10;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ducsang.week10.model.User;

public class ImageActivity extends AppCompatActivity {
    private ImageView profileImage;
    private Button logoutButton;
    private ImageButton btnBack;
    // Các TextView trong item_row
    private TextView tvUserId;
    private TextView tvUsername;
    private TextView tvFullName;
    private TextView tvEmail;
    private TextView tvGender;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileImage = findViewById(R.id.imgChoose);
        logoutButton = findViewById(R.id.btnLogout);
        btnBack = findViewById(R.id.btnBack);
        tvUserId = findViewById(R.id.tvUserId);
        tvUsername = findViewById(R.id.tvUsername);
        tvFullName = findViewById(R.id.tvFullName);
        tvEmail = findViewById(R.id.tvEmail);
        tvGender = findViewById(R.id.tvGender);

        // Load dữ liệu User từ SharedPreferences
        User user = UserManager.getUser(this);
        if (user != null) {
            tvUserId.setText(String.valueOf(user.getId()));
            tvUsername.setText(user.getUsername());
            tvFullName.setText(user.getName());
            tvEmail.setText(user.getEmail());
            tvGender.setText(user.getGender());

            // Nếu avatar được lưu dưới dạng Base64, chuyển đổi và hiển thị
            if (user.getAvtBase64() != null) {
//                byte[] imageBytes = Base64.decode(user.getAvtBase64(), Base64.DEFAULT);
//                profileImage.setImageBitmap(android.graphics.BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length));
            }
        } else {
            Toast.makeText(this, "Không có dữ liệu người dùng!", Toast.LENGTH_SHORT).show();
        }

        // Thiết lập sự kiện cho nút quay lại
        btnBack.setOnClickListener(v -> finish());

        // Khi nhấn vào ảnh đại diện chuyển sang UploadFileActivity
        profileImage.setOnClickListener(v -> {
            Intent intent = new Intent(ImageActivity.this, UploadFileActivity.class);
            startActivity(intent);
        });

        // Xử lý đăng xuất: hiển thị thông báo và xoá dữ liệu nếu cần
        logoutButton.setOnClickListener(v -> {
            Toast.makeText(this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
            UserManager.clearUser(this);
            finish();
        });
    }
}
