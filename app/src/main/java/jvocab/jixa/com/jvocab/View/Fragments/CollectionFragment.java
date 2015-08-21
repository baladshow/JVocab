package jvocab.jixa.com.jvocab.View.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.greenrobot.event.EventBus;
import jvocab.jixa.com.jvocab.Adapters.ExamListAdapter;
import jvocab.jixa.com.jvocab.Adapters.SliderAdapter;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmCollectionResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmExamListResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmRequest;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Model.Collection;


public class CollectionFragment extends SliderPageFragment implements BusResponseReciver {

    private static final String TAG = "****Collection Fragment";
    private int id;
    private Collection collection;
    private SliderAdapter adapter;

    public CollectionFragment(){
        Log.d(TAG," in costructor");
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
//        Log.d(TAG, "987on create view");
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        Log.d(TAG, "987on createed view");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void init(){
//        Log.d(TAG, "init :" + id);
        this.id = getArguments().getInt("id");
        EventBus bus = EventBus.getDefault();
//        Log.d(TAG,"get activity : " + mActivity);
        RealmRequest request = new RealmRequest(getActivity().getApplicationContext(),RealmRequest.COLLECTION_REQUEST,getBusID());
        request.setParam(this.id);
        bus.post(request);
    }

    public void onEvent(RealmCollectionResponse response){
        if(getBusID().equals(response.getResponseID())) {
            collection = response.getData();

            Log.d(TAG, collection.getName());
//            Log.d(TAG, courses.get(0).getWords().get(0).getText());
            if(null == adapter){

//                adapter = new E(getActivity().getApplicationContext(),collection,true);
//                adapter = new SliderAdapter(getActivity().getSupportFragmentManager(),)
//                listView.setAdapter(adapter);
//                listView.setOnItemClickListener(this);
            }
            else{
//                adapter.setData(collection);
            }

//            progressBar.setVisibility(View.GONE);
        }
    }


    @Override
    public String getBusID() {
        return "BUS_ID_" + this.getClass().getName();
    }



}
