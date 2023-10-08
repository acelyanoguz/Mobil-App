package com.acelyaoguz.stajprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class vucutKitleIndex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vucut_kitle_index);

        EditText editTextBoy, editTextKilo;
        TextView txtHesap, txtDetay;
        Button btnHesapla, btnSifirla;

        editTextKilo=findViewById(R.id.editTextKilo);
        editTextBoy=findViewById(R.id.editTextBoy);

        txtDetay=findViewById(R.id.txtDetay);
        txtHesap=findViewById(R.id.txtHesap);

        btnHesapla=findViewById(R.id.btnHesapla);
        btnSifirla=findViewById(R.id.btnSifirla);

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strkilo=editTextKilo.getText().toString();
                String strboy=editTextBoy.getText().toString();

                if(strkilo.equals("")){
                    editTextKilo.setError("Lütfen Kilonuzu Giriniz");
                    editTextKilo.requestFocus();
                    return;
                }
                if(strboy.equals("")){
                    editTextBoy.setError("Lütfen Boyunuzu Giriniz");
                    editTextBoy.requestFocus();
                    return;
                }

                float kilo=Float.parseFloat(strkilo);
                float boy=Float.parseFloat(strboy)/100;

                float vkiDegeri=VKIHesaplayici(kilo,boy);

                txtDetay.setText(SonucVKI(vkiDegeri));
                txtHesap.setText("VKI="+vkiDegeri);

            }
        });

        btnSifirla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextBoy.setText("");
                editTextKilo.setText("");
                txtDetay.setText("");
                txtHesap.setText("");
            }
        });
    }
    public float VKIHesaplayici(float kilo, float boy){
        return kilo / (boy * boy);
    }
    public String SonucVKI(float vkiDegeri){
        if (vkiDegeri<16){
            return "Çok Zayıf";
        }
        else if (vkiDegeri<18.5){
            return "Zayıf";
        }
        else if (vkiDegeri<25){
            return "Normal";
        }
        else if (vkiDegeri<30){
            return "Kilolu";
        }
        else
            return "Aşırı Kilolu";
    }
}