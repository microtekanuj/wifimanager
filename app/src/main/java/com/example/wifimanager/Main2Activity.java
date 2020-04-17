package com.example.wifimanager;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button b1,b2,b3,b4;
        b1=findViewById(R.id.mode);
        b2=findViewById(R.id.vibrate);
        b3=findViewById(R.id.silent);
        b4=findViewById(R.id.ring);
        final AudioManager audioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mod=audioManager.getRingerMode();
                if (mod==AudioManager.RINGER_MODE_NORMAL)
                {
                    Toast.makeText(Main2Activity.this, "Normal mode", Toast.LENGTH_SHORT).show();
                }
                else if(mod==AudioManager.RINGER_MODE_VIBRATE){
                    Toast.makeText(Main2Activity.this, "Vibrate mode", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(Main2Activity.this, "Silent mode", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(Main2Activity.this, "Vibrate mode turned on", Toast.LENGTH_SHORT).show();
            }
        });
        NotificationManager notificationManager =
                (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && !notificationManager.isNotificationPolicyAccessGranted()) {

            Intent intent = new Intent(
                    android.provider.Settings
                            .ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);

            startActivity(intent);
        }
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(Main2Activity.this, "Silent mode turned on", Toast.LENGTH_SHORT).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(Main2Activity.this, "Normal mode turned on", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
