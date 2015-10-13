package jvocab.jixa.com.jvocab.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.Model.Word;
import jvocab.jixa.com.jvocab.View.Fragments.CollectionFragment;
import jvocab.jixa.com.jvocab.View.Fragments.WordFragment;


public class CollectionSliderAdapter extends FragmentPagerAdapter {
    public static String TAG = "*****" + CollectionSliderAdapter.class.getName();
    private int count;
    private List<Collection> collections;
    public CollectionSliderAdapter(FragmentManager fm, int count, List<Collection> collections) {
        super(fm);
        this.count = count;
        this.collections = collections;
    }



    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "word id : " + collections.get(position).getId());
        return CollectionFragment.getInstance(collections.get(position).getId());

    }


    @Override
    public int getCount() {
        return this.count;
    }
}