package com.hfad.messanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecieveMessageActivity extends AppCompatActivity {

    public static final  String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_message);
        Intent intent = getIntent();

        String messageText = intent.getStringExtra(EXTRA_MESSAGE);

        TextView messageView = findViewById(R.id.message);

        messageView.setText(messageText);
    }


}