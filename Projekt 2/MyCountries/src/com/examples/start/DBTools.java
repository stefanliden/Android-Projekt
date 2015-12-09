package com.examples.start;

import java.util.ArrayList;
import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBTools extends SQLiteOpenHelper {

	// Context : provides access to application-specific resources and classes

	public DBTools(Context applicationContext) {
		// Call use the database or to create it
		super(applicationContext, "countriesDB.db", null, 1);
	}

	// onCreate is called the first time the database is created

	public void onCreate(SQLiteDatabase database) {

		// Make sure you don't put a ; at the end of the query

		String query = "CREATE TABLE countries (countryId INTEGER PRIMARY KEY, year TEXT, "
				+ "country TEXT)";

		database.execSQL(query);
	}

	// onUpgrade is used to drop tables, add tables, or do anything
	// else it needs to upgrade
	// This is dropping the table to delete the data and then calling
	// onCreate to make an empty table

	public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
		String query = "DROP TABLE IF EXISTS countries";
		database.execSQL(query);
		onCreate(database);
	}

	public void insertCountry(HashMap<String, String> queryValues) {

		SQLiteDatabase database = this.getWritableDatabase();

		// ContentValues data type is needed because the database
		// requires a ContentValues to be passed as an argument 
		// database.insert(String TableName, String nullColumnHack, CountrieValues value)

		ContentValues values = new ContentValues();

		values.put("year", queryValues.get("year"));
		values.put("country", queryValues.get("country"));

		database.insert("countries", null, values);
		database.close();
	}

	// think of (HashMap<String, String> as a dictionary where 
	// the key is a string and the value is a string
	public int updateCountry(HashMap<String, String> queryValues) {

		SQLiteDatabase database = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put("year", queryValues.get("year"));
		values.put("country", queryValues.get("country"));

		// database.update(TableName, ContentValueForTable, WhereClause, ArgumentForWhereClause)

		return database.update("countries", values, "countryId" + " = ?",
				new String[] { queryValues.get("countryId") });
	}


	public void deleteCountry(String id) {

		SQLiteDatabase database = this.getWritableDatabase();

		String deleteQuery = "DELETE FROM  countries where countryId='" + id
				+ "'";

		database.execSQL(deleteQuery);
	}

	public ArrayList<HashMap<String, String>> getAllCountries(String sortOrder) {

		// ArrayList that contains every row in the database
		// and each row key / value stored in a HashMap

		ArrayList<HashMap<String, String>> countryArrayList;
		String selectQuery;

		countryArrayList = new ArrayList<HashMap<String, String>>();
		
		if (sortOrder.equalsIgnoreCase("yearAscending")) {
			selectQuery = "SELECT  * FROM countries ORDER BY year";
		} else if (sortOrder.equalsIgnoreCase("yearDescending")) {
			selectQuery = "SELECT  * FROM countries ORDER BY year DESC";
		}  else if (sortOrder.equalsIgnoreCase("countryDescending")) {
			selectQuery = "SELECT  * FROM countries ORDER BY country DESC";
		}  else {
			selectQuery = "SELECT  * FROM countries ORDER BY country";
		}

		SQLiteDatabase database = this.getWritableDatabase();

		// Cursor provides read and write access for the
		// data returned from a database query

		// rawQuery executes the query and returns the result as a Cursor

		Cursor cursor = database.rawQuery(selectQuery, null);

		// Move to the first row

		if (cursor.moveToFirst()) {
			do {
				HashMap<String, String> countryMap = new HashMap<String, String>();

				// Store the key / value pairs in a HashMap
				// Access the Cursor data by index that is in the same order
				// as used when creating the table

				countryMap.put("countryId", cursor.getString(0));
				countryMap.put("year", cursor.getString(1));
				countryMap.put("country", cursor.getString(2));

				countryArrayList.add(countryMap);
			} while (cursor.moveToNext()); // Move Cursor to the next row
		}

		return countryArrayList;
	}

	public HashMap<String, String> getCountry(String id) {
		HashMap<String, String> countryMap = new HashMap<String, String>();

		// Open a database for reading only
		SQLiteDatabase database = this.getReadableDatabase();

		String selectQuery = "SELECT * FROM countries where countryId='" + id
				+ "'";

		// rawQuery executes the query and returns the result as a Cursor

		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {

				countryMap.put("year", cursor.getString(1));
				countryMap.put("country", cursor.getString(2));

			} while (cursor.moveToNext());
		}
		return countryMap;
	}
}