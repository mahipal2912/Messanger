package com.hfad.messanger;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.hfad.messanger.databinding.ActivityRecieveMessageBinding;

public class RecieveMessageActivity extends AppCompatActivity {

    public static final  String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         ActivityRecieveMessageBinding binding;

        super.onCreate(savedInstanceState);
        binding = ActivityRecieveMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();

        String messageText = intent.getStringExtra(EXTRA_MESSAGE);


        binding.message.setText(messageText);


        binding.btnSendto.setOnClickListener(view -> {

            Intent intent1 = new Intent(Intent.ACTION_SEND);
            intent1.putExtra(Intent.EXTRA_TEXT, messageText);
            intent1.setType("text/plain");

            Intent chooser = Intent.createChooser(intent1,"send your message to others");

            startActivity(chooser);
        });
    }


}