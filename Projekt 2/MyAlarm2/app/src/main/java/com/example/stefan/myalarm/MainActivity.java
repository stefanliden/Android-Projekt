package com.example.stefan.myalarm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    MediaPlayer mp;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    TextView countDownView;
    EditText edit;
    EditText edit1;
    int interval;
    TextView textView;
    CounterClass timer1;
    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.abba);
        final Handler handler = new Handler();
        Runnable runable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, interval);
                String date = sdf.format(new Date());
                textView.setText(date);


            }
        };


        countDownView = (TextView) findViewById(R.id.countDownTextView1);

        textView = (TextView) findViewById(R.id.timeTextView);

        String date = sdf.format(new Date());
        textView.setText(date);
        edit = (EditText) findViewById(R.id.editText1);
        edit1 = (EditText) findViewById(R.id.EditText01);
        handler.postDelayed(runable, interval);

        timer1 = new CounterClass(600000, 1000);

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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            countDownView.setText(hms);
        }

        @Override
        public void onFinish() {
            countDownView.setText("00:00:00");
            mp.start();
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(1802);
            myAlert();
        }
    }




    public void startButtonClicked(View view) {
        int i;
        int j;
        if (edit.getText().length() == 0) {
            i = 1000;
        } else {
            i = 0x36ee80 * Integer.parseInt(edit.getText().toString());
        }
        if (edit1.getText().length() == 0) {
            j = 1000;
        } else {
            j = 60000 * Integer.parseInt(edit1.getText().toString());
        }
        timer1 = new CounterClass(j + i, 100);
        timer1.start();


    }


    public void stopButtonClicked(View view) {
        timer1.cancel();
        countDownView.setText("00:00:00");
        edit1.setText("");
        edit.setText("");



    }

    public void myAlert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alarm Clock");
        builder.setMessage("Times up!!");
        builder.setPositiveButton("New Alarm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                mp.pause();
                mp.seekTo(0);
            }
        });
        builder.setNegativeButton("Close Alarm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();

                mp.pause();
                mp.seekTo(0);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        AlertDialog alert = builder.create();
        alert.setCanceledOnTouchOutside(true);

        alert.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        alert.show();


    }








}

