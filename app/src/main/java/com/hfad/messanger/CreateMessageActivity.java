package com.hfad.messanger;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hfad.messanger.databinding.ActivityCreateMessageBinding;

public class CreateMessageActivity extends AppCompatActivity {
    ActivityCreateMessageBinding binding;

    public static String TAG = "CreateMessageActivity: Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");

        binding = ActivityCreateMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSend.setOnClickListener(view -> {

            String title = binding.etTitle.getText().toString().trim();
            String message = binding.etMsg.getText().toString().trim();

            if (title.isEmpty()) {
                Toast.makeText(this, "Title is empty!!", Toast.LENGTH_SHORT).show();
            } else if (message.isEmpty()) {
                Toast.makeText(this, "Message is empty!!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent;
                intent = new Intent(this, RecieveMessageActivity.class);
                intent.putExtra(RecieveMessageActivity.EXTRA_MESSAGE, message);
                intent.putExtra(RecieveMessageActivity.EXTRA_TITLE, title);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
