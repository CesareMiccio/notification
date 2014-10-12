package com.testnot;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		notification();
	}
	
	public void notification()
	{
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(
        MainActivity.this);

		//Titolo e testo della notifica
		notificationBuilder.setContentTitle("Titolo della mia notifica");
		notificationBuilder.setContentText("Testo della mia notifica");
		
		//Testo che compare nella barra di stato non appena compare la notifica
		notificationBuilder.setTicker("Questo è il tickerText");
		
		//Data e ora della notifica
		notificationBuilder.setWhen(System.currentTimeMillis());
		
		//Icona della notifica
		notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
		
		//Creiamo il pending intent che verrà lanciato quando la notifica
		//viene premuta
		Intent notificationIntent = new Intent(this, MainActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
		            notificationIntent, 0);
		
		notificationBuilder.setContentIntent(contentIntent);
		
		//Impostiamo il suono, le luci e la vibrazione di default
		notificationBuilder.setDefaults(Notification.DEFAULT_SOUND
		            | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
		final int SIMPLE_NOTIFICATION_ID = 1;
		mNotificationManager.notify(SIMPLE_NOTIFICATION_ID, notificationBuilder.build());
	}
	
			
	
	
}
