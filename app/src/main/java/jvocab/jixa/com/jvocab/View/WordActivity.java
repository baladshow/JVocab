package jvocab.jixa.com.jvocab.View;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import de.greenrobot.event.EventBus;
import jvocab.jixa.com.jvocab.Adapters.WordSliderAdapter;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmRequest;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmWordListResponse;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Model.Word;

public class WordActivity extends SliderActivity implements BusResponseReciver {
    private static final String TAG = "**** Word Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        Log.d(TAG, "on Create");
        int collectionId =  getIntent().getIntExtra("collectionId",0);
        RealmRequest request = new RealmRequest(getApplicationContext(),RealmRequest.WORD_LIST_REQUEST,getBusID());
        request.setParam(collectionId);
        EventBus.getDefault().post(request);

    }

    public void onEvent(RealmWordListResponse response){
        List<Word> words =  response.getData();
        int wordPos =  getIntent().getIntExtra("selectedWordPos", 0);
        setAdapter(new WordSliderAdapter(getSupportFragmentManager(), words.size(), words));
        viewPager.setCurrentItem(wordPos);
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




