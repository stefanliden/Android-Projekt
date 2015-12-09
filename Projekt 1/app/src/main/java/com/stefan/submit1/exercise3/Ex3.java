package com.stefan.submit1.exercise3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.stefan.submit1.R;

import java.util.List;

public class Ex3 extends AppCompatActivity {
    private static final int REQUEST_CODE_1 = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ex3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // -------------------------------- My methods ------------------------------------
    public void addCountryClicked(MenuItem item) {
        //String msg = "addCountryClicked";
        //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, Detail.class);
        startActivityForResult(intent, REQUEST_CODE_1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==REQUEST_CODE_1) {
            if (resultCode==RESULT_OK) {
                int year = data.getIntExtra("year", -1);
                String country = data.getStringExtra("country");

//                String msg = Integer.toString(year) + " " + country;
//                Toast.makeText(this, msg,Toast.LENGTH_LONG).show();

                Visit visit = new Visit(year,country);
                CountryList.addVisit(visit);
                updateListView();
            }
            else if (resultCode==RESULT_CANCELED) {
                //Toast.makeText(this, "Cancelled",Toast.LENGTH_LONG).show();
                return;
            }
        }
    }

    private void updateListView() {
        List<Visit> curList = CountryList.getCountryList();

        ArrayAdapter<Visit> visitArrayAdapter = new ArrayAdapter<Visit>(this, android.R.layout.simple_list_item_1, curList);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(visitArrayAdapter);
    }
}
