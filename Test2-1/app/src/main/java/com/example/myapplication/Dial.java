package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Dial extends AppCompatActivity {
    private static final int REQUEST_CALl = 1;
    private EditText exitnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);

        exitnum = findViewById(R.id.edit_text_number);
        ImageView imagecall = findViewById(R.id.image_call);

        imagecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makephonecall();
            }
        });
    }
    private void makephonecall(){
        String number = exitnum.getText().toString();
        if (number.length() > 0 && number.length() < 12){
            if (ContextCompat.checkSelfPermission(Dial.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Dial.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALl);

            }else{
                String call = "tel:"+number;
                Intent surf = new Intent(Intent.ACTION_DIAL, Uri.parse(call));
                startActivity(surf);
            }

        }else{
            Toast.makeText(Dial.this,"请输入正确的手机号码！",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALl){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makephonecall();       }
             else {
                     Toast.makeText(Dial.this, "已禁止使用权限",Toast.LENGTH_SHORT).show();
}
}
}
}