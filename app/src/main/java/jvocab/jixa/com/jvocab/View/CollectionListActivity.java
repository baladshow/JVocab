package jvocab.jixa.com.jvocab.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import de.greenrobot.event.EventBus;
import io.realm.Realm;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Adapters.CollectionListAdapter;
import jvocab.jixa.com.jvocab.BusHandler.RealmBusHandler;
import jvocab.jixa.com.jvocab.BusHandler.RealmRequest;
import jvocab.jixa.com.jvocab.BusHandler.RealmResponse;
import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.Model.Word;
import jvocab.jixa.com.jvocab.R;

public class CollectionListActivity extends Activity  implements BusResponseReciver{

    CollectionListAdapter adapter;
    GridView gridView;
    RealmResults<Collection> collections;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_grid_layout);
        EventBus.getDefault().register(this);
        RealmRequest request = new RealmRequest(RealmRequest.COLLECTION_WORD_REQUEST,getBusID(),getApplicationContext());
        EventBus.getDefault().post(request);

    }

    public void onEvent(RealmResponse response){
        if(getBusID().equals(response.getResponseID())) {
            collections = response.getData();
//            Log.d(TAG,)
            if(null == adapter){
                adapter = new CollectionListAdapter(getApplicationContext(),collections,true);
                gridView = (GridView) findViewById(R.id.collection_grid_view);
                gridView.setAdapter(adapter);
            }
            else{
                adapter.setData(collections);
            }
        }
    }

    @Override
    public String getBusID() {
        return "BUS_ID_"+CollectionListActivity.class.getName();
    }
}
