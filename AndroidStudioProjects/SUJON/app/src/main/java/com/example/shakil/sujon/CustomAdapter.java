package com.example.shakil.sujon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    String[] textArray;
    int[] imageArray;
    Context gridviewActivity;

    public static LayoutInflater layoutInflater;

    public CustomAdapter(Context gridviewActivity, String[] textArray, int[] imageArray) {
        this.textArray = textArray;
        this.imageArray = imageArray;
        this.gridviewActivity = gridviewActivity;

        layoutInflater = (LayoutInflater) this.gridviewActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

     return this.textArray.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    public class Gridviewclas{
        TextView sometext;
        ImageView someimage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Gridviewclas gridviewclas = new Gridviewclas();

        View view;
        view = layoutInflater.inflate(R.layout.grid_layout, null);
        gridviewclas.sometext = (TextView) view.findViewById(R.id.gridTextId);
        gridviewclas.someimage = (ImageView) view.findViewById(R.id.gridImageId);

        gridviewclas.sometext.setText(this.textArray[position]);
        gridviewclas.someimage.setImageResource(this.imageArray[position]);


        return view;
    }
}