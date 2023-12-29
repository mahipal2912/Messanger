package com.hfad.messanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.hfad.messanger.databinding.ActivityCreateMessageBinding;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCreateMessageBinding binding;

        super.onCreate(savedInstanceState);

        binding = ActivityCreateMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnSend.setOnClickListener(view -> {

             String mesaageText = binding.etMsg.getText().toString();

            Intent intent;

                intent = new Intent(this, RecieveMessageActivity.class);


            intent.putExtra(RecieveMessageActivity.EXTRA_MESSAGE,mesaageText);
            startActivity(intent);
        });
    }

}
