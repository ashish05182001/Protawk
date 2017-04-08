package sddtu.org.protawk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by ASHISH KUMAR on 3/15/2017.
 */

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedPreferences=getSharedPreferences("GoogleInt", Context.MODE_PRIVATE);
        final int gInt=sharedPreferences.getInt("GInt",0);
        Thread thread=new Thread(){
            @Override
            public void run(){
                try {

                    sleep(3000);
                    if(gInt==1||gInt==2){
                        Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else {
                        Intent intent = new Intent(SplashScreen.this, CustomerSPActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        thread.start();

    }
}
