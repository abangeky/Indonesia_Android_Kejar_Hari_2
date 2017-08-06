package com.ekyadhiputra.loginaplikasi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    //deklarasi sebagai waktu
    private static int WAKTU_SPLASH = 3000; //3000 = 3 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, login.class);

                startActivity(i);

                finish();
            }
        }, WAKTU_SPLASH);
    }
}
