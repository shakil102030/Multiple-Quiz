package com.example.shakil.sujon;


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

    TabLayout tabTextId;
    ViewPager viewPagerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        tabTextId = (TabLayout) findViewById(R.id.tabTextId);
        viewPagerId = (ViewPager) findViewById(R.id.viewPagerId);

        gettingclassobjandpassdata(viewPagerId);

        tabTextId.setupWithViewPager(viewPagerId);
    }

    public void gettingclassobjandpassdata(ViewPager viewPager){

        Viewpagerfragment viewpagerfragment = new Viewpagerfragment(getSupportFragmentManager());
        viewpagerfragment.addfragmentandtitle(new FragmentTextone(), "Fragment one");
        viewpagerfragment.addfragmentandtitle(new FragmentTexttwo(), "Fragment two");
        viewpagerfragment.addfragmentandtitle(new FragmentTextthree(), "Fragment three");

        viewPager.setAdapter(viewpagerfragment);
    }

    public class Viewpagerfragment extends FragmentPagerAdapter {
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        List<String> stringList = new ArrayList<String>();

        public Viewpagerfragment(FragmentManager fragmentManager) {
            super(fragmentManager);
        }




        @Override
        public Fragment getItem(int position) {

            return fragmentList.get(position);

        }

        @Override
        public int getCount() {

            return fragmentList.size();

        }

        public void addfragmentandtitle(Fragment flist, String slist){

            fragmentList.add(flist);
            stringList.add(slist);

        }


        @Override
        public CharSequence getPageTitle(int position) {

            return stringList.get(position);
        }
    }
}
