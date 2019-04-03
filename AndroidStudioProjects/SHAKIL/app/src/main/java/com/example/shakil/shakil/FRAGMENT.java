package com.example.shakil.shakil;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FRAGMENT extends AppCompatActivity {
    private TabLayout tavlayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        tavlayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        setupviewpager(viewpager);
        tavlayout.setupWithViewPager(viewpager);


    }

    public void setupviewpager(ViewPager vp){
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        vpa.addfragmentandpager(new Fragmentone(), "Fragment one");
        vpa.addfragmentandpager(new Fragmenttwo(), "Fragment two");
        vpa.addfragmentandpager(new Fragmentthree(), "Fragment thr");

        vp.setAdapter(vpa);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<Fragment>();
        private final List<String>  pagertitleList= new ArrayList<String>();

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {

            return fragmentList.size();
        }

        @Override
        public Fragment getItem(int position) {

            return fragmentList.get(position);

        }



        public void addfragmentandpager(Fragment fragmen, String pagtitle){
            fragmentList.add(fragmen);
            pagertitleList.add(pagtitle);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (CharSequence) pagertitleList.get(position);
        }
    }
}
