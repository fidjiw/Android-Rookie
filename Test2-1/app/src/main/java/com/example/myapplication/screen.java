package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(screen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(4000)
                .withBackgroundColor(Color.parseColor("#ffffff"))
                .withHeaderText("")
                .withFooterText("")
                .withBeforeLogoText("")
                .withAfterLogoText("")
                .withLogo(R.drawable.logo);
        config.getHeaderTextView().setTextColor(Color.WHITE);

        View screen = config.create();
        setContentView(screen);
    }
}
