package com.examples.start;

import java.util.ArrayList;
import java.util.HashMap;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
//import android.widget.SimpleAdapter;

public class MainActivity extends ActionBarActivity implements OnItemClickListener {
	
	ListView listView;
	ArrayList<HashMap<String, String>> countryList; // previously dataArray
	String[] contextMenu = {"Update", "Delete", "Cancel"};
	String[] columnNames = {"countryId", "year", "country"};
	String lastSort = "countryAscending";
	String backgroundColor = "Yellow";
	DBTools dbTools = new DBTools(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ListView) findViewById(R.id.listView);
		listView.setOnItemClickListener(this);
		registerForContextMenu(listView);

	}
	
	@Override
	protected void onResume() {
		super.onResume();
		loadSortPreference();
		updateBackgoundColor(loadPreference("backgroundColor"));
		synchronize();
	}
	
	protected void updateBackgoundColor(String colorName) {
		LinearLayout layout = (LinearLayout) findViewById(R.id.countryLayout);
		String colorCode;
		
		if (colorName.equals("default")) {
			colorCode = "#F3F3F3";
		}
		
		if (colorName.equals("Halo Light")) {
			colorCode = "#F3F3F3";
		} else if (colorName.equals("Yellow")) {
			colorCode = "#FDFF00";
		}  else if (colorName.equals("Beige")) {
			colorCode = "#FDFEEF";
		}   else if (colorName.equals("Pink")) {
			colorCode = "#FFBFD3";
		} else {
			colorCode = "#F3F3F3";
		}
		
        layout.setBackgroundColor(Color.parseColor(colorCode));
	}
	
	protected void synchronize() {	
		countryList = dbTools.getAllCountries(lastSort);
		
		ListAdapter adapter = new MySimpleAdapter(this, countryList, R.layout.country_entry, 
				columnNames, new int[] {R.id.countryId, R.id.year, R.id.country});
		
		listView.setAdapter(adapter);
		
		saveSortPreference();
	}
	
	protected String loadPreference(String key) {	
		SharedPreferences sharedPreferences = getSharedPreferences("PreferenceData", Context.MODE_PRIVATE);
		String valueString = sharedPreferences.getString(key, "default");
		return valueString;
	}
	
	protected void loadSortPreference() {	
		SharedPreferences sharedPreferences = getSharedPreferences("PreferenceData", Context.MODE_PRIVATE);
		lastSort = sharedPreferences.getString("lastSort", lastSort);
	}
	
	protected void saveSortPreference() {	
		SharedPreferences sharedPreferences = getSharedPreferences("PreferenceData", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("lastSort", lastSort);
		editor.commit();
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		if(v.getId() == R.id.listView) {	
			for (int i = 0; i < contextMenu.length; i++) {
				menu.add(Menu.NONE, i, i, contextMenu[i]);
			}
		}
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		// get list item
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
		int clickedIndex = info.position;
		HashMap<String, String> rowHash = countryList.get(clickedIndex);
		String countryId = rowHash.get("countryId");
		
		// get menu item
		int menuItemIndex = item.getItemId();
		String menuItemName = contextMenu[menuItemIndex];
		
		if (menuItemName.equals("Delete")) {
			dbTools.deleteCountry(countryId);
			synchronize();
		} else if (menuItemName.equals("Update")) {
			Intent intent = new Intent(this, UpdateCountry.class);
			intent.putExtra("countrytId", countryId);
        	startActivity(intent);
		} 
		
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
		} else if (id == R.id.addButton) {
        	Intent intent = new Intent(this, AddNewCountry.class);
        	startActivity(intent);
            return true;
        }  else if (id == R.id.sortAscendingByYear) {
        	lastSort = "yearAscending";
        	saveSortPreference();
        	synchronize();
            return true;
        } else if (id == R.id.sortDescendingByYear) {
        	lastSort = "yearDescending";
        	saveSortPreference();
        	synchronize();
            return true;
        } else if (id == R.id.sortAscendingByCountry) {
        	lastSort = "countryAscending";
        	saveSortPreference();
        	synchronize();
            return true;
        } else if (id == R.id.sortDescendingByCountry) {
        	lastSort = "countryDescending";
        	saveSortPreference();
        	synchronize();
            return true;
        }  else if (id == R.id.preferences) {
        	Intent intent = new Intent(this, Preferences.class);
        	startActivity(intent); 
            return true;
        }
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Message.message(this, "Try long press on an item!");
	}
}
