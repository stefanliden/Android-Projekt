package com.stefan.submit1.exercise5;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.stefan.submit1.R;

public class Ex5 extends AppCompatActivity {

    ViewPager pager;
    ViewPagerAdapter adapter;

    int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5);

        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);


        ViewPager.OnPageChangeListener mListener=new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                selectedIndex = arg0;
                updateTitle(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        };

        pager.addOnPageChangeListener(mListener);
    }


    // -------------------------------- My methods ------------------------------------

    public void updateTitle(int pos) {
        TextView tvTitle = (TextView) findViewById(R.id.title);
        int num = pos+1;
        tvTitle.setText("Beer " + num + " out of 7");
    }


}
