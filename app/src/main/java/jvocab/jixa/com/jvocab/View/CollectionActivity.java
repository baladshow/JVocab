package jvocab.jixa.com.jvocab.View;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import de.greenrobot.event.EventBus;
import jvocab.jixa.com.jvocab.Adapters.CollectionListAdapter;
import jvocab.jixa.com.jvocab.Adapters.CollectionSliderAdapter;
import jvocab.jixa.com.jvocab.Adapters.MainPagerAdapter;
import jvocab.jixa.com.jvocab.Adapters.SliderAdapter;
import jvocab.jixa.com.jvocab.Adapters.WordSliderAdapter;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmCollectionListResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmRequest;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.Model.Word;
import jvocab.jixa.com.jvocab.R;
import jvocab.jixa.com.jvocab.View.Fragments.CollectionFragment;

public class CollectionActivity extends SliderActivity implements BusResponseReciver{
    private static final String TAG = "**** Collection ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        RealmRequest request = new RealmRequest(getApplicationContext(),RealmRequest.COLLECTION_LIST_REQUEST,getBusID());
        EventBus.getDefault().post(request);


    }

    public void onEvent(RealmCollectionListResponse response){
        List<Collection> collections =  response.getData();
        int selectedCollectionPos =  getIntent().getIntExtra("selectedCollectionPos", 0);
        setAdapter(new CollectionSliderAdapter(getSupportFragmentManager(), collections.size(), collections));
        viewPager.setCurrentItem(selectedCollectionPos);
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

    @Override
    public String getBusID() {
        return "BUS_ID_" + this.getClass().getName();
    }


}



