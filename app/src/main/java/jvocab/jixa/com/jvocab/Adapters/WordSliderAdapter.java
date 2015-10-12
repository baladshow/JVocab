package jvocab.jixa.com.jvocab.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

import jvocab.jixa.com.jvocab.Model.Word;
import jvocab.jixa.com.jvocab.View.Fragments.WordFragment;


public class WordSliderAdapter extends FragmentPagerAdapter {
    public static String TAG = "*****" + WordSliderAdapter.class.getName();
    private int count;
    private List<Word> words;
    public WordSliderAdapter(FragmentManager fm, int count, List<Word> words) {
        super(fm);
        this.count = count;
        this.words = words;
    }



    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "word id : " + words.get(position).getId());
        return WordFragment.getInstance(words.get(position).getId());

    }


    @Override
    public int getCount() {
        return this.count;
    }
}