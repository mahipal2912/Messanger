package com.hfad.messanger;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hfad.messanger.databinding.ActivityRecieveMessageBinding;

import java.util.ArrayList;

public class RecieveMessageActivity extends AppCompatActivity {

    private ActivityRecieveMessageBinding binding;

    public static final String EXTRA_MESSAGE = "message";

    public static final String EXTRA_TITLE = "title";

    public static String TAG = "RecieveMessageActivity : Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        binding = ActivityRecieveMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();

        String title = intent.getStringExtra(EXTRA_TITLE);
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);

        binding.tvMessage.setText(messageText);
        binding.tvTitle.setText(title);

        binding.btnSendtoOthers.setOnClickListener(view -> {
            composeMessageToOthers(title, messageText);
        });

        binding.btnSendtoMail.setOnClickListener((v) -> {
            composeEmail(new ArrayList<>(), title, messageText);
        });

    }

    public void composeMessageToOthers(String title, String message) {
        String fullMessage = title + "\n" + message;
        Intent intent1 = new Intent(Intent.ACTION_SEND);
        intent1.putExtra(Intent.EXTRA_TEXT, fullMessage);
        intent1.setType("text/plain");
        Intent chooser = Intent.createChooser(intent1, "Send your message to others");
        startActivity(chooser);
    }

    public void composeEmail(ArrayList<String> addresses, String subject, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Your device hasn't email app.", Toast.LENGTH_SHORT).show();
        }
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