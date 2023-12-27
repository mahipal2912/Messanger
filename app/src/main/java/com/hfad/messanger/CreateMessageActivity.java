package com.hfad.messanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view) {

        EditText messageView = findViewById(R.id.message);
        String messgaeText = messageView.getText().toString();
        Intent intent = new Intent(this,RecieveMessageActivity.class);

        intent.putExtra(RecieveMessageActivity.EXTRA_MESSAGE,messgaeText);
        startActivity(intent);
    }
}