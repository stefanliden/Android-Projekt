package com.stefan.submit1.exercise4;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.stefan.submit1.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Ex4 extends ListActivity {

    public static String TAG = "dv606.weather";

    private InputStream input;
    private WeatherReport report = null;
    ArrayList<String> imageCodeList;
    ArrayList<String> rawList;
    ArrayList<String> filteredList;
    ListView listView;

    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8,
            R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12,
            R.drawable.img13, R.drawable.img14, R.drawable.img15,
            R.drawable.img20, R.drawable.img21, R.drawable.img22,  R.drawable.img23,
            R.drawable.img24, R.drawable.img25, R.drawable.img26,  R.drawable.img27,
            R.drawable.img28, R.drawable.img29, R.drawable.img30,  R.drawable.img31,
            R.drawable.img32, R.drawable.img33, R.drawable.img34,
            R.drawable.img40, R.drawable.img41, R.drawable.img42,  R.drawable.img43,
            R.drawable.img44, R.drawable.img45, R.drawable.img46,  R.drawable.img47,
            R.drawable.img48, R.drawable.img49, R.drawable.img50};


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rawList = new ArrayList<String>();
        filteredList = new ArrayList<String>();
        imageCodeList = new ArrayList<String>();

        //Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();

        try {
            URL url = new URL("http://www.yr.no/sted/Sverige/Kronoberg/V%E4xj%F6/forecast.xml");
            AsyncTask task = new WeatherRetriever().execute(url);
        } catch (IOException ioe ) {
            ioe.printStackTrace();
        }

    }

    // -------------------------------- Teacher methods ------------------------------------
    private void printReportToLog() {
        if (this.report != null) {
        	/* Print location meta data */
            Log.i(TAG, report.toString());

        	/* Print forecasts */
            int count = 0;
            for (WeatherForecast forecast : report) { // for (Class instance : list) just like for:in in Objective-C
                count++;
//				Log.i(TAG, "Forecast #" + count);


                String forecastString = forecast.toString();
                // Log.i(TAG, forecastString);
                rawList.add(forecastString); // here is the source of the data
            }

            // now rawList contains all the needed data
            presentData();
        }
        else {
            Log.e(TAG, "Weather report has not been loaded.");
        }
    }

    private class WeatherRetriever extends AsyncTask<URL, Void, WeatherReport> {
        protected WeatherReport doInBackground(URL... urls) {

            try {
                return WeatherHandler.getWeatherReport(urls[0]);
            } catch (Exception e) {
                Log.d(TAG,"WeatherHandler exception");
                throw new RuntimeException(e);
            }
        }

        protected void onProgressUpdate(Void... progress) {

        }

        protected void onPostExecute(WeatherReport result) {
            //Toast.makeText(getApplicationContext(), "WeatherRetriever task finished", Toast.LENGTH_LONG).show();

            report = result;
            printReportToLog();
        }
    }

    // -------------------------------- My methods ------------------------------------

    private void presentData() {
        filterData();

        listView = getListView();
        MyAdapter myadapter = new MyAdapter(this, filteredList, images, imageCodeList);
        listView.setAdapter(myadapter);
    }

    private void filterData() {

        for (int i = 0; i < rawList.size(); i++) {
            String data = rawList.get(i);
            String[] dataArray = data.split("\n");

            // get day of the week (Mon, ..., Sat, Sun)
            String dayOfWeek = dayOfWeek(dataArray[0]); // Thu
            //Log.i(TAG, dayOfWeek);

            // get part of the day (night, morning, afternoon or evening)
            String partOfDay = partOfDay(dataArray[1]);
            //Log.i(TAG, partOfDay);

            // get temperature
            String wind = wind(dataArray[3]);
            //Log.i(TAG, wind);

            // get temperature
            String temperature = temperature(dataArray[4]);
            //Log.i(TAG, temperature);

            // construct the infoString
            StringBuilder buf = new StringBuilder();
            buf.append(dayOfWeek + ", " + partOfDay + " : " + temperature + "°");
            buf.append(", " + wind );
            String infoString = buf.toString();
            //Log.i(TAG, infoString);

            filteredList.add(infoString);

            // get Code
            imageCodeList.add(getImageCode(dataArray[2]));
        }
    }

    private String wind(String line) {
        String windString = line;
        int commaPosition = windString.indexOf(",");
        int colonPosition = windString.indexOf(":");
        String windDirection = windString.substring(colonPosition + 2, commaPosition);

        windString = windString.substring(commaPosition);
        int secondColonPosition = windString.indexOf(":");
        String windSpeed = windString.substring(secondColonPosition + 2);

        windString = windDirection + " " + windSpeed;
        return windString;
    }

    private String temperature(String line) {
        String temperatureString = line;
        int commaPosition = temperatureString.indexOf(",");
        int colonPosition = temperatureString.indexOf(":");
        temperatureString = temperatureString.substring(colonPosition+2, commaPosition);
        return temperatureString;
    }

    private String partOfDay(String line) {
        String partOfDayCode = line.substring(line.length()-1); // the last char

        String partOfDay = "foo";

        if (partOfDayCode.equals("0")) {
            partOfDay = "night";
        } else if (partOfDayCode.equals("1")) {
            partOfDay = "morning";
        } else if (partOfDayCode.equals("2")) {
            partOfDay = "afternoon";
        } else if (partOfDayCode.equals("3")) {
            partOfDay = "evening";
        }

        return partOfDay;
    }

    private String dayOfWeek(String line) {
        String dateString = line; // Date: 2015-12-05
        dateString = dateString.substring(6); // 2015-12-05
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String result = new SimpleDateFormat("EEE MMM dd",Locale.US).format(date); // Thu
        return result;
    }

    private String getImageCode(String inString) {
        String codeLine = inString;
        String last = codeLine.substring(codeLine.length() - 3);
        String codeString="";

        if (last.substring(0, 1).equals(":")) {
            codeString = last.substring(2, 3);
        } else {
            codeString = last.substring(1, 3);
        }
        //Log.d("Stille", codeString);
        Log.i(TAG, codeString);
        return codeString;
    }

}
