package com.stefan.utvardering;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stefan.utvardering.viewpager.R;


public class question2 extends Fragment {
	
	public question2() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_main_quest2,
				container, false);
	
		return rootView;
	}

	}