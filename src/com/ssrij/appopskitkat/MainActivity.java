package com.ssrij.appopskitkat;
import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	// Some variables we require
	final String latestKitKat = "4.4.2";
	private static final String TAG = "ssrijAOL";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Init
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void launchao(View v) {
		 // Check if user is on 4.4.2
		 if (!strcmp(latestKitKat, android.os.Build.VERSION.RELEASE)) {
			 // For debugging
			 Log.v(TAG, android.os.Build.VERSION.RELEASE);
			 // Tell user the device is not on 4.4.2
			 Toast.makeText(getApplicationContext(), "This app only supports the latest revision of Android 4.4 KitKat (4.4.2_r1)", Toast.LENGTH_LONG).show();
		 } else {
			 // Do some magic and launch AppOps!
			 Intent aoIntent = new Intent("android.intent.action.MAIN");
			 aoIntent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings"));
			 aoIntent.putExtra(":android:show_fragment", "com.android.settings.applications.AppOpsSummary");
	         startActivity(aoIntent);
	         return;
		 }
	}
	
	@SuppressWarnings("null")
	// String comparison routine I wrote a while back
	public static boolean strcmp(final String str1, final String str2) {
		boolean isSame = (str1.hashCode() == str2.hashCode() && str1.equals(str2)) ? true : false; 
		return isSame; }
}
