package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class get_guess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_guess);

        Intent intent = getIntent();
        String text1 = intent.getStringExtra(get_text.EXTRA_TEXT1);
        int text2 = intent.getIntExtra(get_text.EXTRA_TEXT2,0);

        TextView textView1 = (TextView)findViewById(R.id.edit1);
        TextView textView2 = (TextView)findViewById(R.id.edit1);

        textView1.setText(text1);
        textView1.setText(text2);

        }

    }

