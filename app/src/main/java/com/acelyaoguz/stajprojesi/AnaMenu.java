package com.acelyaoguz.stajprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AnaMenu extends AppCompatActivity {

    ImageButton imageButtonNot;
    ImageButton imageButtonVki;
    ImageButton imageButtonAdim;
    ImageButton imageButtonKronometre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_menu);

        imageButtonNot=findViewById(R.id.imageButtonNot);
        imageButtonVki=findViewById(R.id.imageButtonVki);
        imageButtonAdim=findViewById(R.id.imageButtonAdim);
        imageButtonKronometre=findViewById(R.id.imageButtonKronometre);

        imageButtonNot.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AnaMenu.this,HedefListem.class);
                startActivity(intent);
            }
        });

        imageButtonVki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AnaMenu.this,vucutKitleIndex.class);
                startActivity(intent);
            }
        });

        imageButtonAdim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AnaMenu.this,adimSayar.class);
                startActivity(intent);
            }
        });

        imageButtonKronometre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AnaMenu.this,kronometre.class);
                startActivity(intent);
            }
        });
    }
}