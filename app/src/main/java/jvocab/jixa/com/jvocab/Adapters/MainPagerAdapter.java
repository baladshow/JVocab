package jvocab.jixa.com.jvocab.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.List;

import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.Model.Exam;
import jvocab.jixa.com.jvocab.R;
import jvocab.jixa.com.jvocab.View.CollectionListFragment;
import jvocab.jixa.com.jvocab.View.ExamListFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {
    public static String TAG = "*****"+MainPagerAdapter.class.getName();
    public static final int RESOURCE = R.layout.exam_list_item;
    private static final int PAGES_COUNT = 2;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return CollectionListFragment.newInstance();
        }else if(position == 1){
            return ExamListFragment.newInstance();
        }
        return null;
    }


    @Override
    public int getCount() {
        return PAGES_COUNT;
    }

}