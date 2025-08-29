package com.julian.tpo1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class AirplaneModeReceiverActivity extends BroadcastReceiver {


    public AirplaneModeReceiverActivity() {
    }



    @Override
    public void onReceive(Context context, Intent intent) {

            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

            String mje = isAirplaneModeOn ?
                    "Modo Avión Activado" :
                    "Modo Avión Desactivado";

            Toast.makeText(context, mje, Toast.LENGTH_SHORT).show();


            if (!isAirplaneModeOn) {
                Intent marcar = new Intent(Intent.ACTION_DIAL);
                marcar.setData(android.net.Uri.parse("tel:2664553747"));
                marcar.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(marcar);
            }
        }


}
