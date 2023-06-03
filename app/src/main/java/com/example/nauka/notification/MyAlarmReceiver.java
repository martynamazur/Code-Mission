package com.example.nauka.notification;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.nauka.R;

public class MyAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Tworzenie intencji dla aktywności, która zostanie uruchomiona po kliknięciu powiadomienia
        Intent notificationIntent = new Intent(context, MyAlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

        // Tworzenie powiadomienia
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel_id")
                .setSmallIcon(R.drawable.apps_icon)
                .setContentTitle("Tytuł powiadomienia")
                .setContentText("Treść powiadomienia")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        // Wyświetlanie powiadomienia
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(123, builder.build());
    }

}

