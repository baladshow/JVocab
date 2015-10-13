package jvocab.jixa.com.jvocab.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import jvocab.jixa.com.jvocab.Adapters.MainPagerAdapter;
import jvocab.jixa.com.jvocab.R;

public class MainPagesActivity extends FragmentActivity implements ViewPager.OnPageChangeListener{
    private static final String TAG = "****MainPages ";
    private ViewPager viewPager ;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        Intent intent = getIntent();
        int currentPageId = intent.getIntExtra("pageId", 0);
        Log.d(TAG, "current page id : " + currentPageId);
        viewPager = (ViewPager) findViewById(R.id.activity_slider_view_pager);
        title = (TextView) findViewById(R.id.activity_slider_title);
        viewPager.setOnPageChangeListener(this);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        viewPager.setPageTransformer(false, new FadePageTransformer());
        viewPager.setCurrentItem(currentPageId);
    }


    @Override
    public void onPageSelected(int position) {
        Toast.makeText(getApplicationContext(),
                "Selected page position: " + position, Toast.LENGTH_SHORT).show();
    }

    // This method will be invoked when the current page is scrolled
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        Toast.makeText(getApplicationContext(),
//                "Scrolled page position: " + position, Toast.LENGTH_SHORT).show();
    }

    // Called when the scroll state changes:
    // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
    @Override
    public void onPageScrollStateChanged(int state) {
//        Toast.makeText(getApplicationContext(),
//                "Changed page position: " , Toast.LENGTH_SHORT).show();
    }



 }

class FadePageTransformer implements ViewPager.PageTransformer {
    public void transformPage(View view, float position) {
        view.setTranslationX(view.getWidth() * -position);

        if(position <= -1.0F || position >= 1.0F) {
            view.setAlpha(0.0F);
        } else if( position == 0.0F ) {
            view.setAlpha(1.0F);
        } else {
            // position is between -1.0F & 0.0F OR 0.0F & 1.0F
            view.setAlpha(1.0F - Math.abs(position));
        }
    }
}




