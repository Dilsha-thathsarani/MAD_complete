package com.example.bookmark.user_management;

import androidx.appcompat.app.AppCompatActivity;
import com.example.bookmark.R;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Objects;

public class loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
    }
}