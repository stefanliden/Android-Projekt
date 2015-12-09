package com.stefan.submit1.exercise2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.stefan.submit1.R;

import java.text.DecimalFormat;

public class Ex2 extends AppCompatActivity {
    TextView tvLength ;
    TextView tvWeight;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        getTextViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ex2, menu);
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

    public void doComputeButton(View view) {

        //toastMsg("doComputeButton trapped");

        String strLength = tvLength.getText().toString();
        String strWeight = tvWeight.getText().toString();

        if (!strLength.equals("") && !strWeight.equals("")) {
            double length = Double.parseDouble(strLength);
            length = length / 100.0;
            double weight = Double.parseDouble(strWeight);
            double bmi = weight / Math.pow(length, 2);
            DecimalFormat df = new DecimalFormat("#.0");
            String bmiFormated = df.format(bmi);
            tvResult.setText(bmiFormated);
            //toastMsg(bmiFormated);
        } else {
            toastMsg("Enter length and weight before computing");
        }
    }

    public void doResetButton(View view) {
        //toastMsg("doResetButton trapped");
        tvLength.setText("");
        tvWeight.setText("");
        tvResult.setText("");
    }

    public void getTextViews() {
        tvLength = (TextView) findViewById(R.id.editLength);
        tvWeight = (TextView) findViewById(R.id.editWeight);
        tvResult= (TextView) findViewById(R.id.textViewResult);
    }

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
}
