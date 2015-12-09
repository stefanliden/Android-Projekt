package com.stefan.submit1.exercise4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.stefan.submit1.R;

import java.util.ArrayList;


//Adapter

class MyAdapter extends ArrayAdapter<String>
{
    Context c;
    int [] images;
    ArrayList<String> infoArray;
    ArrayList<String> myCodeList;

    MyAdapter(Context context, ArrayList<String> filteredArrayList, int imgs[], ArrayList<String> codeList)
    {
        super(context, R.layout.single_row, R.id.textView, filteredArrayList);
        c = context;
        images = imgs;
        infoArray = filteredArrayList;
        myCodeList = codeList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row, parent, false);
        ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
        TextView myInfo = (TextView) row.findViewById(R.id.textView);

        String codeString = myCodeList.get(position);
        int index = indexForCodeString(codeString);

        myImage.setImageResource(images[index]);
        myInfo.setText(infoArray.get(position));

        return row;
    }

    private int indexForCodeString(String codeString) {
        String[] indices = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12,", "13", "14", "15", "20", "21", "22", "23,", "24", "25", "26", "27", "28", "29", "30", "31,", "32", "33", "34", "40", "41", "42", "43,", "44", "45", "46", "47", "48", "49", "50"};
        //int resultIndex = 0;
        for (int i = 0; i < indices.length; i++) {
            if (codeString.equals(indices[i])) {
                //resultIndex=i;
                return i;
            }
        }
        return 0;
    }

}