package jvocab.jixa.com.jvocab.View;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import android.widget.Toast;

import jvocab.jixa.com.jvocab.Adapters.MainPagerAdapter;
import jvocab.jixa.com.jvocab.Adapters.SliderAdapter;
import jvocab.jixa.com.jvocab.R;
import jvocab.jixa.com.jvocab.View.Fragments.CollectionFragment;

public class CollectionActivity extends SliderActivity{
    private static final String TAG = "**** Collection ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int count  = getIntent().getIntExtra("collectionsCount",0);
        int collectionId =  getIntent().getIntExtra("id",0);
        setAdapter(new SliderAdapter<CollectionFragment>(getSupportFragmentManager(),count,CollectionFragment.class));
        viewPager.setCurrentItem(collectionId);

    }


    @Override
    public void onPageSelected(int position) {
        Toast.makeText(getApplicationContext(),
                "Selected page position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        Toast.makeText(getApplicationContext(),
//                "Scrolled page position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
//        Toast.makeText(getApplicationContext(),
//                "Changed page position: " , Toast.LENGTH_SHORT).show();
    }

 }




