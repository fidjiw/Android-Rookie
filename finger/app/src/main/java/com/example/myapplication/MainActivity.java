package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private FingerprintManager fingerprintManager;
    private FingerprintManager.AuthenticationCallback authenticationCallback;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.image1);
        fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);

        authenticationCallback = new FingerprintManager.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                textView.setText("ERROR");
                imageView.setImageResource(R.drawable.image2);
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                textView.setText("HELP");
                imageView.setImageResource(R.drawable.image1);
                super.onAuthenticationHelp(helpCode, helpString);
            }

            @Override
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
                textView.setText("SUCCESS");
                imageView.setImageResource(R.drawable.image3);
                super.onAuthenticationSucceeded(result);

                Intent intent = new Intent(MainActivity.this,jin.class);
                startActivity(intent);

            }

            @Override
            public void onAuthenticationFailed() {
                textView.setText("FAILED");
                imageView.setImageResource(R.drawable.image2);
                super.onAuthenticationFailed();
            }
        };
    }

    public void scanButton(View view){ ;
        fingerprintManager.authenticate(null, null, 0, authenticationCallback, null);
    }
}
