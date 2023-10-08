package com.acelyaoguz.stajprojesi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class kaydol extends AppCompatActivity implements View.OnClickListener {

    EditText Kytsifre,Edtelefon,EdAdSoyad,Kytemail;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);

        Button kullanicikayit = findViewById(R.id.kullanicikayit);

        EdAdSoyad = (EditText) findViewById(R.id.EdAdSoyad);
        Kytemail = (EditText) findViewById(R.id.Kytemail);
        Kytsifre = (EditText) findViewById(R.id.Kytsifre);
        Edtelefon = (EditText) findViewById(R.id.Edtelefon);

        mAuth=FirebaseAuth.getInstance();

        kullanicikayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth=FirebaseAuth.getInstance();

                String isim_soyisim = EdAdSoyad.getText().toString();
                String e_mail = Kytemail.getText().toString();
                String sifre = Kytsifre.getText().toString();
                String telefon = Edtelefon.getText().toString();

                if (v.getId() == kullanicikayit.getId()) {
                    if (isim_soyisim.length() == 0) {
                        EdAdSoyad.requestFocus();
                        EdAdSoyad.setError("Lütfen Ad Soyad Alanını Doldurunuz.");
                    } else if (e_mail.length() == 0) {
                        Kytemail.requestFocus();
                        Kytemail.setError("Lütfen E-Mail Alanını Doldurunuz.");
                    } else if (sifre.length() == 0) {
                        Kytsifre.requestFocus();
                        Kytsifre.setError("Lütfen Şifre Alanını Doldurunuz.");
                    }
                    else if (telefon.length() == 0) {
                        Edtelefon.requestFocus();
                        Edtelefon.setError("Lütfen Telefon Alanını Doldurunuz.");
                    }
                    else {

                        mAuth.createUserWithEmailAndPassword(e_mail,sifre);
                        Intent intent = new Intent(kaydol.this, kayitSonuc.class);
                        startActivity(intent);
                    }

                }

            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}