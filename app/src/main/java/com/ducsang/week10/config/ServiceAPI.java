package com.ducsang.week10.config;

import android.os.Message;

import com.ducsang.week10.Const;
import com.ducsang.week10.model.ImageUpload;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ServiceAPI {
    @Multipart
    @POST("test/update-profile")
    Call<ImageUpload> upload(
            @Part MultipartBody.Part avatar
    );
}

