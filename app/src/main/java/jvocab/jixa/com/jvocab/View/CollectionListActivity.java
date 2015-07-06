package jvocab.jixa.com.jvocab.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;


import de.greenrobot.event.EventBus;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Adapters.CollectionListAdapter;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmCollectionListResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmRequest;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.R;

public class CollectionListActivity extends Activity  implements BusResponseReciver,AdapterView.OnItemClickListener {

    private static final String TAG = "****CollectionList";
    CollectionListAdapter adapter;
    GridView gridView;
    RealmResults<Collection> collections;
    private   ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_grid_layout);
        gridView = (GridView) findViewById(R.id.collection_grid_view);
        progressBar = (ProgressBar) findViewById(R.id.collection_grid_progress);
        EventBus.getDefault().register(this);
        RealmRequest request = new RealmRequest(getApplicationContext(),RealmRequest.COLLECTION_LIST_REQUEST,getBusID());
        EventBus.getDefault().post(request);


    }

    public void onEvent(RealmCollectionListResponse response){
        if(getBusID().equals(response.getResponseID())) {
            collections = response.getData();

//            Log.d(TAG, collections.get(0).getName());
//            Log.d(TAG, collections.get(0).getWords().get(0).getText());
            if(null == adapter){
                adapter = new CollectionListAdapter(getApplicationContext(),collections,true);
                gridView.setAdapter(adapter);
                gridView.setOnItemClickListener(this);
            }
            else{
                adapter.setData(collections);
            }

            progressBar.setVisibility(View.GONE);
        }
    }


    @Override
    public String getBusID() {
        return "BUS_ID_"+CollectionListActivity.class.getName();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG,"clicked");
        Intent intent = new Intent(getApplicationContext(),CollectionActivity.class);
        intent.putExtra("id",adapter.getData().get(position).getId());
        startActivity(intent);
    }
}
