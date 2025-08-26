package com.julian.tpo1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    private TextView tvEstado;

    public AirplaneModeReceiver() {
    }

    public AirplaneModeReceiver(TextView tvEstado) {
        this.tvEstado = tvEstado;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

            String mje = isAirplaneModeOn ?
                    "Modo Avión Activado" :
                    "Modo Avión Desactivado";

            Toast.makeText(context, mje, Toast.LENGTH_SHORT).show();

            if (tvEstado != null) {
                tvEstado.post(() -> tvEstado.setText("Estado de modo avión: " + mje));
            }


            if (!isAirplaneModeOn) {
                Intent llamar = new Intent(Intent.ACTION_DIAL);
                llamar.setData(android.net.Uri.parse("tel:2664553747"));
                llamar.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(llamar);
            }
        }
    }

}
