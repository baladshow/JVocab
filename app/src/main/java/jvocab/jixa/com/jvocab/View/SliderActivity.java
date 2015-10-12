package jvocab.jixa.com.jvocab.View;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import android.widget.TextView;


import jvocab.jixa.com.jvocab.R;

public class SliderActivity extends FragmentActivity implements  ViewPager.OnPageChangeListener{
    protected ViewPager viewPager;
    protected TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        viewPager = (ViewPager) findViewById(R.id.activity_slider_view_pager);
        title = (TextView) findViewById(R.id.activity_slider_title);
        viewPager.setOnPageChangeListener(this);
//        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
//        EventBus.getDefault().register(this);
//        requestData();
    }

    public void setAdapter(FragmentPagerAdapter adapter){
        viewPager.setAdapter(adapter);
    }

//    private void requestData(){
//
//        int collectionID = getIntent().getIntExtra("id",0);
//        Log.d(TAG , "request  " + collectionID);
//        RealmRequest request = new RealmRequest(getApplicationContext(),RealmRequest.COLLECTION_REQUEST,getBusID(),collectionID);
//        EventBus.getDefault().post(request);
//    }

//    public void onEvent(RealmCollectionResponse response){
//        Log.d(TAG , "onEvent()");
//        if(getBusID().equals(response.getResponseID())) {
//            Collection collection =  response.getData();
//            Log.d("all words : ", collection.getWords().get(10).getText());
//            Log.d(TAG, collection.getName());
//        }
//    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}