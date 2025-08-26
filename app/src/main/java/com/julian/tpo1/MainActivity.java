package com.julian.tpo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvAirplaneEstado;
    private AirplaneModeReceiver airplaneModeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //referencia al TextView
        airplaneModeReceiver = new AirplaneModeReceiver(tvAirplaneEstado);

        // broadcast dinámico
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // evitar fugas de memoria
        unregisterReceiver(airplaneModeReceiver);
    }
}
