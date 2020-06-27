package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class email extends AppCompatActivity {
    private EditText editTextto;
    private EditText editTextsubject;
    private EditText editTextmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        editTextto = findViewById(R.id.email_to);
        editTextsubject = findViewById(R.id.email_subject);
        editTextmessage = findViewById(R.id.email_message);

        Button buttonsend = findViewById(R.id.button_email);
        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }
    private void sendMail(){
        String recipientlist = editTextto.getText().toString();
        String[] recipients = recipientlist.split(",");

        String subject = editTextsubject.getText().toString();
        String message = editTextmessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"选择一个邮箱端！"));
    }
}