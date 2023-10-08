package com.acelyaoguz.stajprojesi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class kronometre extends AppCompatActivity {

    private int saniye;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kronometre);
        if(savedInstanceState!=null){savedInstanceState.getInt("saniye");savedInstanceState.getBoolean("running");savedInstanceState.getBoolean("wasRunning");}
        timerCasiltir();
    }
    public void OnStart(View view){
    running=true;} public void OnStop(View view){running=false;} public void onReset(View view){running=false; saniye=0;}

    @Override
    protected void onPause() {
        super.onPause(); wasRunning=running; running=false;
    }

    @Override
    protected void onResume() {
        super.onResume(); if(wasRunning){running=true;}
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState); outState.putInt("saniye",saniye); outState.putBoolean("running",running); outState.putBoolean("wasRunning",wasRunning);
    }

    private void timerCasiltir(){
        TextView zamanGorunumu=findViewById(R.id.txtSayac);
        Handler handler=new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int saat=saniye/3600;
                int dakika=(saniye % 3600)/60;
                int sn=saniye % 60;

                String zaman=String.format(Locale.getDefault(),"%d:%02d%02d",saat,dakika,sn);
                zamanGorunumu.setText(zaman);

                if(running){

                    saniye++;
                }
                handler.postDelayed(this,1000);

            }
        });
    }
}