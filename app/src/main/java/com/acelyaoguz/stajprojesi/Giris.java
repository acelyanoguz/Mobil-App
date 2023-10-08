package com.acelyaoguz.stajprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class Giris extends AppCompatActivity implements View.OnClickListener {

    EditText EdEmail,EdSifre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        Button kayitol = findViewById(R.id.kayitol);
        Button giris = findViewById(R.id.giris);

    kayitol.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Giris.this,kaydol.class);
            startActivity(intent);
        }
    });

    EdEmail=findViewById(R.id.EdEmail);
    EdSifre=findViewById(R.id.EdSifre);

        giris.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String e_mail = EdEmail.getText().toString();
                String password = EdSifre.getText().toString();

                if (v.getId() == giris.getId()) {
                    if (e_mail.length() == 0) {
                        EdEmail.requestFocus();
                        EdEmail.setError("lütfen E-mail Alanını Doldurunuz.");
                    }
                    else if (password.length() == 0) {
                        EdSifre.requestFocus();
                        EdSifre.setError("lütfen Şifre Alanını Doldurunuz.");
                    }

                    else {
                        Intent intent = new Intent(Giris.this,AnaMenu.class);
                        startActivity(intent);

                    }
                }
            }


        });

        //su alarm servisi aktivasyonu
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent notificationIntent = new Intent(this, SuHatirlaticiBildirimi.class);
        PendingIntent sender = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 5);

        if (alarmManager != null) {
            // 1000 milisaniye * 60saniye * 60        60 dakika
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 1000 * 60 * 60, sender);
        }

    }

    @Override
    public void onClick(View view) {

    }
}