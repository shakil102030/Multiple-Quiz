package com.example.shakil.shakil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdaptor extends BaseAdapter{
    String[] name;
    int[] image;
    Context context;
    public static LayoutInflater layoutInflater;

    public CustomAdaptor(Custom_View mainActivity, String[] nm, int[] im){
        name = nm;
        image = im;
        context = mainActivity;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }



    @Override
    public int getCount() {

        return name.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    public class Nameimage{
        TextView nametext;
        ImageView imageview;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Nameimage nameimage = new Nameimage();
        View view;

        view = layoutInflater.inflate(R.layout.customlayout,null);

        nameimage.nametext = (TextView) view.findViewById(R.id.CustomTextViewId);
        nameimage.imageview = (ImageView) view.findViewById(R.id.ImageViewId);

        nameimage.nametext.setText(name[position]);
        nameimage.imageview.setImageResource(image[position]);


        return view;
    }
}