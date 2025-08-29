package com.julian.tpo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private TextView tvEstado;
    private TextView tvAirplaneEstado;
    private AirplaneModeReceiverActivity airplaneModeReceiverActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencia al TextView
        airplaneModeReceiverActivity = new AirplaneModeReceiverActivity();

        // broadcast dinámico
        IntentFilter x = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeReceiverActivity, x);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // evitar fugas de memoria
        unregisterReceiver(airplaneModeReceiverActivity);
    }
}
