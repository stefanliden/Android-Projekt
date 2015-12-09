package com.examples.start;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Preferences extends ActionBarActivity {
	
	Button backgroundColorButton;
	
	String[] backgroundColorItems = {"Yellow", "Beige", "Pink", "Halo Light"};
	String[] fontSizeItems = {"16", "20", "24"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preferences);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preferences, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void updateBackgroundColor(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a color");
		builder.setItems(backgroundColorItems, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	savePreference("backgroundColor", backgroundColorItems[item]);
		    	finish();
		    }
		});
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	public void updateFontSize(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a size");
		builder.setItems(fontSizeItems, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	savePreference("fontSize", fontSizeItems[item]);
		    	finish();
		    }
		});
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	public void returnToMain(View v) {
		finish();
	}	
	
	protected void savePreference(String key, String value) {	
		SharedPreferences sharedPreferences = getSharedPreferences("PreferenceData", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

}
