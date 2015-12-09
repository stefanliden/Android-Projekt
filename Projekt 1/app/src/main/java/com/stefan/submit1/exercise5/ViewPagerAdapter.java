package com.stefan.submit1.exercise5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.TextView;

import com.stefan.submit1.R;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int[] picture = {R.drawable.morningdelight, R.drawable.goodmorning, R.drawable.headytopper,
            R.drawable.kentuck, R.drawable.norrlands, R.drawable.plinytheyounger, R.drawable.plinytheelder};


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return ViewPagerFragment.newInstance(position, picture[position]);
    }

    @Override
    public int getCount() {
        return picture.length;
    }


}
