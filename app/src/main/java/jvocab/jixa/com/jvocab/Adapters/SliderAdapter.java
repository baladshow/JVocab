package jvocab.jixa.com.jvocab.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import jvocab.jixa.com.jvocab.View.Fragments.SliderPageFragment;


public class SliderAdapter<T extends SliderPageFragment> extends FragmentPagerAdapter {
    public static String TAG = "*****" + SliderAdapter.class.getName();
    private int count;
    private Class<T> c;
    public SliderAdapter(FragmentManager fm,int count,Class<T> c) {
        super(fm);
        this.count = count;
        this.c = c;
    }



    @Override
    public Fragment getItem(int position) {
        try {
            T fragment = c.newInstance();
            Bundle args = new Bundle();
            args.putInt("id",position+1);
            fragment.setArguments(args);
            return fragment;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int getCount() {
        return this.count;
    }
}