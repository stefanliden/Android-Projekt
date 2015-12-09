package com.examples.start;

import java.util.HashMap;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddNewCountry extends ActionBarActivity {

	DBTools dbTools = new DBTools(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_country);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_new_country, menu);
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

	public void addNewCountry(View v) {
		finish();
	}

	@Override
	public void finish() {

		EditText yearEditText = (EditText) findViewById(R.id.yearEditText);
		EditText countryEditText = (EditText) findViewById(R.id.countryEditText);
		String yearString = yearEditText.getText().toString();
		String countryString = countryEditText.getText().toString();
		countryString = countryString.trim();

		if (yearString.length() != 0 && countryString.length() != 0) {
			HashMap<String, String> queryValuesMap = new HashMap<String, String>();
			queryValuesMap.put("year", yearString);
			queryValuesMap.put("country", countryString);
			dbTools.insertCountry(queryValuesMap);
		}

		super.finish();
	}
}
