package com.examples.start;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MySimpleAdapter extends SimpleAdapter{

private Context context;
private int id; 
ArrayList<HashMap<String, String>> results;
HashMap<String,String> hm;


public MySimpleAdapter(Context context, ArrayList<HashMap<String, String>> aList, 
		int resource, String[] from, int[] to) 
{
	super(context, aList, resource, from, to);
	id =resource;
	this.results =  aList;
	this.context = context;
}

public View getView(int position, View view, ViewGroup parent)
{	
	View v = super.getView(position, view, parent);

	if (v == null) {
		LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = vi.inflate(id, null);
	}
	
	hm = results.get(position);
	
	TextView countryTextView = (TextView) v.findViewById(R.id.country);
	countryTextView.setText(hm.get("country"));
	
	TextView yearTextView = (TextView) v.findViewById(R.id.year);
	yearTextView.setText(hm.get("year"));
	
	String sizeString = loadPreference("fontSize");
	float size = Float.parseFloat(sizeString);
	
	countryTextView.setTextSize(size);
	yearTextView.setTextSize(size);
	
	return v;
}

protected String loadPreference(String key) {	
	SharedPreferences sharedPreferences = context.getSharedPreferences("PreferenceData", Context.MODE_PRIVATE);
	String valueString = sharedPreferences.getString(key, "16"); // gotcha
	return valueString;
}

}
