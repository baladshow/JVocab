package jvocab.jixa.com.jvocab.View.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

//import com.poliveira.apps.parallaxlistview.ParallaxListView;

import com.nirhart.parallaxscroll.views.ParallaxListView;

import java.util.List;

import de.greenrobot.event.EventBus;
import io.realm.RealmList;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Adapters.ExamListAdapter;
import jvocab.jixa.com.jvocab.Adapters.SliderAdapter;
import jvocab.jixa.com.jvocab.Adapters.WordListAdapter;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmCollectionResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmExamListResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmRequest;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.Model.Word;
import jvocab.jixa.com.jvocab.R;
import jvocab.jixa.com.jvocab.View.MainPagesActivity;
import jvocab.jixa.com.jvocab.View.WordActivity;


public class CollectionFragment extends SliderPageFragment implements BusResponseReciver,AdapterView.OnItemClickListener {

    private static final String TAG = "****Collection Fragment";
//    private int id;
    private Collection collection;
    private WordListAdapter adapter;
    private ParallaxListView mListView;
    private TextView mTitle;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection,container,false);
        mListView = (ParallaxListView) view.findViewById(R.id.collection_words_list);

        mTitle = new TextView(getActivity().getApplicationContext());
        mTitle.setGravity(Gravity.CENTER);
        mTitle.setTextSize(40);
        mTitle.setHeight(400);
//                mTitle.setBackgroundResource(R.drawable.item_background);
        mListView.addParallaxedHeaderView(mTitle);
//        mTitle. = (TextView) view.findViewById(R.id.parallax_listview_header_title);
        init();
        return view;
    }

    @Override
    public void init(){
//        Log.d(TAG, "init :" + id);
        int id = getArguments().getInt("id");
        EventBus bus = EventBus.getDefault();
//        Log.d(TAG,"get activity : " + mActivity);
        RealmRequest request = new RealmRequest(getActivity().getApplicationContext(),RealmRequest.COLLECTION_REQUEST,getBusID());
        request.setParam(id);
        bus.post(request);
    }

    public void onEvent(RealmCollectionResponse response){
        if(getBusID().equals(response.getResponseID())) {
            collection = response.getData();
            String collectionName = collection.getName();
            RealmResults<Word> words =collection.getWords().where().findAll();;
//            Log.d(TAG, words.);
            Log.d(TAG, collectionName);
//            Log.d(TAG, courses.get(0).getWords().get(0).getText());
            if(null == adapter){

                adapter = new WordListAdapter(getActivity().getApplicationContext(),words, true);
                mTitle.setText(collectionName);
                mListView.setAdapter(adapter);
                mListView.setOnItemClickListener(this);

            }
            else{
//                adapter.setData(collection);
            }

//            progress_bar.setVisibility(View.GONE);
        }
    }



    @Override
    public String getBusID() {
        return "BUS_ID_" + this.getClass().getName();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity().getApplicationContext(), WordActivity.class);
        intent.putExtra("selectedWordPos", position);
        intent.putExtra("collectionId", collection.getId());
        Log.d(TAG, Integer.toString(position));
        Log.d(TAG, collection.getName());
        startActivity(intent);
    }
}
