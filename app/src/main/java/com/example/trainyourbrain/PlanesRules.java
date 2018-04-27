package com.example.trainyourbrain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

public class PlanesRules extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfragment);

        ViewPager pager2 = (ViewPager) findViewById(R.id.pager2);
        pager2.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }
    private class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return(3);
        }
        @Override
        public Fragment getItem(int position) {
            return(PlanesFragment.newInstance(position));
        }
    }
}