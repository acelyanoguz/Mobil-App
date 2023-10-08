package com.acelyaoguz.stajprojesi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class adimSayar extends AppCompatActivity implements SensorEventListener {

    TextView txtAdimlar;
    SharedPreferences sharedPreferences;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adim_sayar);
        //textview ı bağlama
        txtAdimlar=findViewById(R.id.txtAdimlar);

        //shared preferences de bugünün tarihinin bir anahtarını oluşturdm
        String gecerliTarih=new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        //sharedpref veri tabanı kurulumu
        sharedPreferences=this.getSharedPreferences("com.acelyaoguz.stajprojesi", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed;

        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Sensor sayiciSensor= sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(sayiciSensor != null){
            sensorManager.registerListener(this,sayiciSensor,SensorManager.SENSOR_DELAY_UI);
        }
        else{
            Toast.makeText(this,"Sensör bulunamadı!",Toast.LENGTH_LONG).show();
        }
        //eğer sharedpref içermiyorsa
        if(!sharedPreferences.contains(gecerliTarih)){
            sharedPreferences.edit().putInt(gecerliTarih,0).apply();
        }
        if(sharedPreferences.contains(gecerliTarih)){
            int v=sharedPreferences.getInt(gecerliTarih,1);
            txtAdimlar.setText(String.valueOf(v));
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        String gecerliTarih=new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault()).format(new Date());

        if(sharedPreferences.contains(gecerliTarih)){
            int valu=sharedPreferences.getInt(gecerliTarih,1);
            valu=valu + 1;
            sharedPreferences.edit().putInt(gecerliTarih,valu).apply();
            Toast.makeText(this,String.valueOf(valu),Toast.LENGTH_LONG).show();
            txtAdimlar.setText(String.valueOf(valu));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}