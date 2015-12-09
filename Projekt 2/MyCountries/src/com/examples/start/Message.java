package com.examples.start;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class Message {

	public static void message(Context context, String message) {
		Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP|Gravity.END, 0, 50);
		toast.show();
	}
}