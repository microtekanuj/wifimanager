package com.example.wifimanager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class wifilist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifilist);
        ListView listView=findViewById(R.id.list);
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()) {
            Toast.makeText(getApplicationContext(), "Turning WiFi ON...", Toast.LENGTH_LONG).show();
            wifiManager.setWifiEnabled(true);

        }
        }
    }
