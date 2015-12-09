package com.stefan.submit1.exercise3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.stefan.submit1.R;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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

    // My Methods
    public void addClicked(MenuItem item) {
        // get data from text fields
        // get year
        TextView editYear = (TextView) findViewById(R.id.editYear);
        String stringYear = editYear.getText().toString();

        if (stringYear.equals("") ) {
            toastMsgCenter("Enter both year and country!");
            return;
        }
        int intYear = Integer.parseInt(stringYear);

        TextView editCountry = (TextView) findViewById(R.id.editCountry);
        String stringCountry = editCountry.getText().toString();
        if (stringCountry.equals("") ) {
            toastMsgCenter("Enter both year and country!");
            return;
        }

        Intent intent = new Intent();
        intent.putExtra("year", intYear);
        intent.putExtra("country", stringCountry);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancelClicked(MenuItem item) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    private void toastMsgCenter(String msg) {
        Toast toast= Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER| Gravity.CENTER, 0, 0);
        toast.show();
    }

    private void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

}

