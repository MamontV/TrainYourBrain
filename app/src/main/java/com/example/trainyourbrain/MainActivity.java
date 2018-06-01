package com.example.trainyourbrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.about:
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
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