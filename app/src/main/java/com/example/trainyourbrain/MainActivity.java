package com.example.trainyourbrain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {
    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "Память";
            }
            else if (position == 1) {
                return "Внимание";
            }
            else if (position == 2) {
                return "Мышление";
            }
            return null;
        }
        @Override
        public Fragment getItem(int position) {
            return ChoosePageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}