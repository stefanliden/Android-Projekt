package com.stefan.utvardering;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.stefan.utvardering.viewpager.R;

import java.util.Locale;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setOffscreenPageLimit(5);

		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}


	public void sendFeedback(View button) {


		//questions
		Spinner Questions1 = (Spinner)findViewById(R.id.q3);
		String q1 = Questions1.getSelectedItem().toString();
		Spinner Questions2 = (Spinner)findViewById(R.id.q4);
		String q2 = Questions2.getSelectedItem().toString();
		Spinner Questions3 = (Spinner)findViewById(R.id.q5);
		String q3 = Questions3.getSelectedItem().toString();
		Spinner Questions4 = (Spinner)findViewById(R.id.questions1);
		String q4 = Questions4.getSelectedItem().toString();
		Spinner Questions5 = (Spinner)findViewById(R.id.q2);
		String q5 = Questions5.getSelectedItem().toString();
		Spinner Questions6 = (Spinner)findViewById(R.id.q6);
		String q6 = Questions6.getSelectedItem().toString();
		Spinner Questions7 = (Spinner)findViewById(R.id.q7);
		String q7 = Questions7.getSelectedItem().toString();
		Spinner Questions8 = (Spinner)findViewById(R.id.q8);
		String q8 = Questions8.getSelectedItem().toString();
		Spinner Questions9 = (Spinner)findViewById(R.id.q9);
		String q9 = Questions9.getSelectedItem().toString();
		Spinner Questions10 = (Spinner)findViewById(R.id.q10);
		String q10 = Questions10.getSelectedItem().toString();
		Spinner Questions11 = (Spinner)findViewById(R.id.q11);
		String q11 = Questions11.getSelectedItem().toString();
		Spinner Questions12 = (Spinner)findViewById(R.id.q12);
		String q12 = Questions12.getSelectedItem().toString();
		Spinner Questions13 = (Spinner)findViewById(R.id.q13);
		String q13 = Questions13.getSelectedItem().toString();
		Spinner Questions14 = (Spinner)findViewById(R.id.q14);
		String q14 = Questions14.getSelectedItem().toString();
		Spinner Questions15 = (Spinner)findViewById(R.id.q15);
		String q15 = Questions15.getSelectedItem().toString();
		Spinner Questions16 = (Spinner)findViewById(R.id.q16);
		String q16 = Questions16.getSelectedItem().toString();

		EditText edit = (EditText)findViewById(R.id.editText1);
		String q17 = edit.getText().toString();





		//quest
		final TextView Question1 = (TextView) findViewById(R.id.question3);
		String k1 = Question1.getText().toString();

		final TextView Question2 = (TextView) findViewById(R.id.question4);
		String k2 = Question2.getText().toString();

		final TextView Question3 = (TextView) findViewById(R.id.question5);
		String k3 = Question3.getText().toString();


		final TextView Question4 = (TextView) findViewById(R.id.TextView01);
		String k4 = Question4.getText().toString();

		final TextView Question5 = (TextView) findViewById(R.id.question2);
		String k5 = Question5.getText().toString();

		final TextView Question6 = (TextView) findViewById(R.id.question6);
		String k6 = Question6.getText().toString();

		final TextView Question7 = (TextView) findViewById(R.id.question7);
		String k7 = Question7.getText().toString();

		final TextView Question8 = (TextView) findViewById(R.id.question8);
		String k8 = Question8.getText().toString();

		final TextView Question9 = (TextView) findViewById(R.id.question9);
		String k9 = Question9.getText().toString();

		final TextView Question10 = (TextView) findViewById(R.id.question10);
		String k10 = Question10.getText().toString();

		final TextView Question11 = (TextView) findViewById(R.id.question11);
		String k11 = Question11.getText().toString();





		final TextView Question12 = (TextView) findViewById(R.id.question12);
		String k12 = Question12.getText().toString();



		final TextView Question13 = (TextView) findViewById(R.id.question13);
		String k13 = Question13.getText().toString();

		final TextView Question14 = (TextView) findViewById(R.id.question14);
		String k14 = Question14.getText().toString();

		final TextView Question15 = (TextView) findViewById(R.id.question15);
		String k15 = Question15.getText().toString();

		final TextView Question16 = (TextView) findViewById(R.id.question16);
		String k16 = Question16.getText().toString();






		String qk1 = k1 + " /" + q1 + '\n' + '\n' ;

		String qk2 = k2 + " /" + q2 + '\n' + '\n' ;
		String qk3 = k3 + " /" + q3 + '\n' + '\n' ;
		String qk4 = k4 + " /" + q4 + '\n' + '\n' ;
		String qk5 = k5 + " /" + q5 + '\n' + '\n' ;
		String qk6 = k6 + " /" + q6 + '\n' + '\n' ;
		String qk7 = k7 + " /" + q7 + '\n' + '\n' ;
		String qk8 = k8 + " /" + q8 + '\n' + '\n' ;
		String qk9 = k9 + " /" + q9 + '\n' + '\n' ;
		String qk10 = k10 + " /" + q10 + '\n' + '\n' ;
		String qk11 = k11 + " /" + q11 + '\n' + '\n' ;
		String qk12 = k12 + " /" + q12 + '\n' + '\n' ;
		String qk13 = k13 + " /" + q13 + '\n' + '\n' ;
		String qk14 = k14 + " /" + q14 + '\n' + '\n' ;
		String qk15 = k15 + " /" + q15 + '\n' + '\n' ;
		String qk16 = k16 + " /" + q16 + '\n' + '\n' ;
		String qk17 = "Något annat du vill tillägga?" + " /" + q17 + '\n' + '\n' ;
		final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);

		if(responseCheckbox.isChecked())
		{


			Intent messageIntent = new Intent(Intent.ACTION_SEND);
			String mysz2 = q2.replaceAll("\\s","");


			String aEmailList[] = {mysz2.toLowerCase()+"@lundInformatik.se" };
			messageIntent.putExtra(Intent.EXTRA_EMAIL, aEmailList);

			messageIntent.putExtra(Intent.EXTRA_SUBJECT, "Utvärdering på kursen" + " "  +q1 );

			messageIntent.setType("plain/text");
			messageIntent.putExtra(Intent.EXTRA_TEXT,  qk2
					+ qk3  + qk4 + qk5 +   qk6 + qk7 + qk8 + qk9 + qk10 + qk11 + qk12 + qk13 + qk14 + qk15 + qk16 + 	qk17);

			startActivity(messageIntent);
		}

		else {


			Approve();


		}

	}

	public void Approve() {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Kursutvärdering");
		builder.setMessage("Du måste godkänna för att skicka in din utvärdering till din lärare");
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {

			}
		});

		AlertDialog alert = builder.create();



		alert.show();


	}


	@Override
	public void onTabSelected(ActionBar.Tab tab,
							  FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
								FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
								FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment=null;
			if(position==0){
				fragment = new question0();
			}
			else if(position==1){
				fragment=new question1();
			}
			else if(position==2){
				fragment=new question2();
			}

			else if(position==3){
				fragment=new question3();
			}

			else if(position==4){
				fragment=new question4();
			}







			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 5;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
				case 0:
					return getString(R.string.title_section1).toUpperCase(l);
				case 1:
					return getString(R.string.title_section2).toUpperCase(l);
				case 2:
					return getString(R.string.title_section3).toUpperCase(l);

				case 3:
					return getString(R.string.title_section4).toUpperCase(l);

				case 4:
					return getString(R.string.title_section5).toUpperCase(l);


			}
			return null;

		}


	}


}
