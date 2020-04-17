package com.example.wifimanager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button on,off,av,bon,boff,list,blist;
        on=findViewById(R.id.on);
        off=findViewById(R.id.off);
        av=findViewById(R.id.next);
        bon=findViewById(R.id.bon);
        boff=findViewById(R.id.boff);
        list=findViewById(R.id.list);
        blist=findViewById(R.id.blist);
        //WifiManager wifiManager=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        //wifiManager.setWifiEnabled(false);
        Toast.makeText(this, "WiFi is currently off", Toast.LENGTH_SHORT).show();
        blist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,wifilist.class);
                startActivity(intent);
            }
        });
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wifi turned on", Toast.LENGTH_SHORT).show();
                WifiManager wifiManager=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wifi turned off", Toast.LENGTH_SHORT).show();
                WifiManager wifiManager=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,wifilist.class);
                startActivity(i1);
            }
        });
        bon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Bluetooth turned on", Toast.LENGTH_SHORT).show();
                //BluetoothManager bluetoothManager=(BluetoothManager)getApplicationContext().getSystemService(Context.BLUETOOTH_SERVICE);
                BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
                bluetoothAdapter.enable();
            }
        });
        boff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Bluetooth turned on", Toast.LENGTH_SHORT).show();
                //BluetoothManager bluetoothManager=(BluetoothManager)getApplicationContext().getSystemService(Context.BLUETOOTH_SERVICE);
                BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
                bluetoothAdapter.disable();

            }
        });
        av.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i1);
            }
        });
    }
}
