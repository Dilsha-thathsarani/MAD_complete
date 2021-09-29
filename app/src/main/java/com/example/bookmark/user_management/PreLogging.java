package com.example.bookmark.user_management;

import androidx.appcompat.app.AppCompatActivity;
import com.example.bookmark.R;
import com.example.bookmark.payment_management.activity_h2p;
import com.example.bookmark.payment_management.cardform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class PreLogging extends AppCompatActivity {

    Button btnSign, btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_logging);

        btnSign = (Button)findViewById(R.id.btnpSignin);
        btnReg = (Button)findViewById(R.id.btnpReg);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreLogging.this, UserLogin.class);
                startActivity(intent);
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreLogging.this, UserRegister.class);
                startActivity(intent);
            }
        });

    }
}