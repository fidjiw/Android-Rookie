package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class get_text extends AppCompatActivity {

    public static final String EXTRA_TEXT1 = "com.example.myapplicatin.example.EXTRA_TEXT1";
    public static final String EXTRA_TEXT2 = "com.example.myapplicatin.example.EXTRA_TEXT2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_text);

        Button button_guess = (Button)findViewById(R.id.button_guess);
        button_guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openget_guess();
            }
        });
    }
    public  void openget_guess(){
        EditText editText1 = (EditText) findViewById(R.id.edit1);
        String text1 = editText1.getText().toString();

        EditText editText2 = (EditText) findViewById(R.id.edit2);
        int text2 = Integer.parseInt(editText2.getText().toString());

        Intent intent = new Intent(get_text.this,get_guess.class);
        intent.putExtra(EXTRA_TEXT1,text1);
        intent.putExtra(EXTRA_TEXT2,text2);
        startActivity(intent);
    }


}
