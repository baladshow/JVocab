package jvocab.jixa.com.jvocab.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;


import de.greenrobot.event.EventBus;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Adapters.CollectionListAdapter;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmCollectionListResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmRequest;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Interfaces.IMainPage;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.R;

public class    CollectionListFragment extends Fragment implements BusResponseReciver, IMainPage,AdapterView.OnItemClickListener {

    private static final String TAG = "****CollectionList";
    private CollectionListAdapter adapter;
    private ListView listView;
    private RealmResults<Collection> collections;
    private   ProgressBar progressBar;
    private static final String TITLE = "Collection List" ;

    public static Fragment newInstance(){
        return new CollectionListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "register to eventbus");
        EventBus.getDefault().register(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        Log.d(TAG, "on create view()");
        View view = inflater.inflate(R.layout.fragment_collection_list,container,false);
        listView = (ListView) view.findViewById(R.id.collection_list_view);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) view.findViewById(R.id.collection_list_progress);
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "on viewCreated()");
        RealmRequest request = new RealmRequest(getActivity().getApplicationContext(),RealmRequest.COLLECTION_LIST_REQUEST,getBusID());
        EventBus.getDefault().post(request);
    }

    public void onEvent(RealmCollectionListResponse response){
        Log.d(TAG, "on event()");
        Log.d(TAG, response.getResponseID());
        if(getBusID().equals(response.getResponseID())) {
            collections = response.getData();

            Log.d(TAG, collections.get(0).getName());
//            Log.d(TAG, courses.get(0).getWords().get(0).getText());
            if(null == adapter){
                adapter = new CollectionListAdapter(getActivity().getApplicationContext(),collections,true);
                listView.setAdapter(adapter);
            }
            else{
                adapter.setData(collections);
            }

            progressBar.setVisibility(View.GONE);
        }
    }


    @Override
    public String getBusID() {
        return "BUS_ID_"+this.getClass().getName();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG,"clicked");
        Intent intent = new Intent(getActivity().getApplicationContext(),CollectionActivity.class);
        intent.putExtra("selectedCollectionPos", position);
        intent.putExtra("collectionsCount",collections.size());
//        intent.put
        Log.d(TAG, "in item click count :" + collections.size());
        startActivity(intent);
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
