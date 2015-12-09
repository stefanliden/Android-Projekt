package com.examples.start;

import java.util.HashMap;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class UpdateCountry extends ActionBarActivity {
	
	DBTools dbTools = new DBTools(this);
	EditText yearEditText;
	EditText countryEditText;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_country);
		
		yearEditText = (EditText) findViewById(R.id.yearEditText);
		countryEditText = (EditText) findViewById(R.id.countryEditText);
		
		Intent theIntent = getIntent();
		String countryId = theIntent.getStringExtra("countrytId");
		HashMap<String, String> countryList = dbTools.getCountry(countryId);
		 
		 if(countryList.size()!=0) {
			    // Put the values in the EditText boxes
			    yearEditText.setText(countryList.get("year"));
			    countryEditText.setText(countryList.get("country"));
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_country, menu);
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
	
	public void updateCountry(View v) {
		finish();
	}

	@Override
	public void finish() {
		
		Intent theIntent = getIntent();
		String countryId = theIntent.getStringExtra("countrytId");

		EditText yearEditText = (EditText) findViewById(R.id.yearEditText);
		EditText countryEditText = (EditText) findViewById(R.id.countryEditText);
		String yearString = yearEditText.getText().toString();
		String countryString = countryEditText.getText().toString();
		countryString = countryString.trim();

		if (yearString.length() != 0 && countryString.length() != 0) {
			HashMap<String, String> queryValuesMap = new HashMap<String, String>();
			queryValuesMap.put("countryId", countryId);
			queryValuesMap.put("year", yearString);
			queryValuesMap.put("country", countryString);
			dbTools.updateCountry(queryValuesMap);
		}

		super.finish();
	}
}
