package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    //DEFINE FIELDS
    Button btnClose;
    TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //GET IDS
        btnClose = findViewById(R.id.btnClose);
        textMessage = findViewById(R.id.textMessage);

        //GET INHERITED VALUES
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msgFromMain");

        //SET TEXT FIELDS
        textMessage.setText(msg);
        btnClose.setText(msg);

        //SET EVENT HANDLERS
        btnClose.setOnClickListener(v -> {
            finish();
        });
    }
}