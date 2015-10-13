package jvocab.jixa.com.jvocab.View;

//import android.app.Fragment;
//import android.app.FragmentManager;
import android.os.Bundle;
//import android.app.Fragment
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import jvocab.jixa.com.jvocab.R;
import jvocab.jixa.com.jvocab.View.Fragments.FirstSplashPageFragment;
import jvocab.jixa.com.jvocab.View.Fragments.SecondSplashPageFragment;

public class SplashScreenActivity extends FragmentActivity {

    private static final int NUM_PAGES = 2;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    List<Fragment> pages = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pages.add(new FirstSplashPageFragment());
        pages.add(new SecondSplashPageFragment());
        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new SplashPageAdapter(getSupportFragmentManager(),pages);
        mPager.setAdapter(mPagerAdapter);

//        setContentView();
    }


    private class SplashPageAdapter extends FragmentStatePagerAdapter{
        private List<Fragment> pages;
        public SplashPageAdapter(FragmentManager fm , List<Fragment> pages){
            super(fm);
            this.pages = pages;
        }

        @Override
        public Fragment getItem(int position) {
            return this.pages.get(position);
        }

        @Override
        public int getCount() {
            return this.pages.size();
        }
    }

}
