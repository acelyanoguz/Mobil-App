package com.acelyaoguz.stajprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kayitSonuc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_sonuc);

        Button btnanaMenu = findViewById(R.id.btnanaMenu);
        btnanaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kayitSonuc.this,AnaMenu.class);
                startActivity(intent);
            }
        });

    }
}