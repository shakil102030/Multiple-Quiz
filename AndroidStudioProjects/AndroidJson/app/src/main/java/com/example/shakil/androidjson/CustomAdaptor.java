package com.example.shakil.androidjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdaptor extends BaseAdapter{
     Context applicationcontext;
     int customlayout;
     List<Democlass> s;
    LayoutInflater layoutInflater;


    public CustomAdaptor(Context applicationcontext, int customlayout, List<Democlass> s) {
        this.applicationcontext = applicationcontext;
        this.customlayout = customlayout;
        this.s = s;

        layoutInflater = (LayoutInflater) applicationcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return s.size();

    }

    @Override
    public Object getItem(int position) {
        return s.get(position);

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

        LayoutInflater layoutInflater;

        if(convertView == null){
            layoutInflater = (LayoutInflater) applicationcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.customlayout, parent, false);
        }
        Nameimage nameimage = new Nameimage();
       // View view;

       // view = layoutInflater.inflate(R.layout.customlayout,null);

        nameimage.nametext = (TextView) convertView.findViewById(R.id.CustomTextViewId);
        nameimage.imageview = (ImageView) convertView.findViewById(R.id.ImageViewId);

        nameimage.nametext.setText(s.get(position).getName());
        nameimage.imageview.setImageResource(Integer.parseInt(s.get(position).getImage()));


        return convertView;
    }

    }
   /*// public class CustomAdaptor extends BaseAdapter {
       Context applicationcontext;
       int name;  //ImageLoadingActivity.JsonT mainActivity
       List<Democlass> img;
        Context context;
        public static LayoutInflater layoutInflater;

        public CustomAdaptor(Context applicationcontext, int nm, List<Democlass> img){
            this.name = nm;
            this.img = img;
            this.applicationcontext = applicationcontext;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        }



        @Override
        public int getCount() {

            return img.size();
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

            nameimage.nametext.setText(name);
            nameimage.imageview.setImageResource(img.get().getImage());


            return view;
        }*/
    //}
