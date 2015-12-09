package com.stefan.submit1;

import com.stefan.submit1.exercise1.Ex1;
import com.stefan.submit1.exercise2.Ex2;
import com.stefan.submit1.exercise3.Ex3;
import com.stefan.submit1.exercise4.Ex4;
import com.stefan.submit1.exercise5.Ex5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void doEx1(View view) {
        startActivity(new Intent(MainActivity.this, Ex1.class));
    }

    public void doEx2(View view) {
        startActivity(new Intent(MainActivity.this, Ex2.class));
    }

    public void doEx3(View view) {
        startActivity(new Intent(MainActivity.this, Ex3.class));
    }

    public void doEx4(View view) {
        startActivity(new Intent(MainActivity.this, Ex4.class));
    }

    public void doEx5(View view) { startActivity(new Intent(MainActivity.this, Ex5.class)); }

}
