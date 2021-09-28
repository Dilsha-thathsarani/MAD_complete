package com.example.bookmark.payment_management;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmark.R;

public class activity_h2p extends AppCompatActivity {

    private Button button;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_h2p);

        button = (Button) findViewById(R.id.savedbtn);
        button2 = (Button) findViewById(R.id.newbtn);
        button3 = (Button) findViewById(R.id.btnManage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSaved();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNew();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManage();
            }
        });

    }

    public void openSaved(){
        Intent intent = new Intent(this, Addedcards2.class);
        startActivity(intent);
    }

    public void openManage(){
        Intent intent = new Intent(this, Addedcards.class);
        startActivity(intent);
    }

    public void openNew(){
        Intent intent = new Intent(this, cardform.class);
        startActivity(intent);
    }

    public  void showSuccess(){
        Intent intent = new Intent(this, activity_payStatus2.class);
        startActivity(intent);
    }



}