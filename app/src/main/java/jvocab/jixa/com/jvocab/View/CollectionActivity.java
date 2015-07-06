package jvocab.jixa.com.jvocab.View;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import de.greenrobot.event.EventBus;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmCollectionListResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmCollectionResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmRequest;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Model.Collection;

public class CollectionActivity extends Activity implements BusResponseReciver{
    private static final String TAG = "****Collection";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
//        setContentView();
        requestData();

    }

    private void requestData(){
        int collectionID = getIntent().getIntExtra("id",0);
        RealmRequest request = new RealmRequest(getApplicationContext(),RealmRequest.COLLECTION_REQUEST,getBusID(),collectionID);
        EventBus.getDefault().post(request);
    }

    public void onEvent(RealmCollectionResponse response){
        Log.d(TAG , "onEvent()");
        if(getBusID().equals(response.getResponseID())) {
            Collection collection =  response.getData();
            Log.d(TAG, collection.getName());
        }
    }

    @Override
    public String getBusID() {
        return "BUS_ID_"+this.getClass().getName();
    }
}
