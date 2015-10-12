package jvocab.jixa.com.jvocab.View.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nirhart.parallaxscroll.views.ParallaxListView;

import de.greenrobot.event.EventBus;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Adapters.WordListAdapter;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmCollectionResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmRequest;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmWordResponse;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Model.Word;
import jvocab.jixa.com.jvocab.R;

//import com.poliveira.apps.parallaxlistview.ParallaxListView;


public class WordFragment extends Fragment implements BusResponseReciver {

    private static final String TAG = "****Word Fragment";

    private TextView mTitle;




    public static WordFragment getInstance(int id){
        WordFragment instance = new WordFragment();
        Bundle args = new Bundle();
        args.putInt("wordId",id);
        instance.setArguments(args);
        return instance;
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
        init();
        return view;
    }

    public void init(){
//        Log.d(TAG, "init :" + wordId);
        int wordId = getArguments().getInt("wordId");
        EventBus bus = EventBus.getDefault();
//        Log.d(TAG,"get activity : " + mActivity);
        RealmRequest request = new RealmRequest(getActivity().getApplicationContext(),RealmRequest.WORD_REQUEST,getBusID());
        request.setParam(wordId);
        bus.post(request);
    }

    public void onEvent(RealmWordResponse response){
        if(getBusID().equals(response.getResponseID())) {
            Word word = response.getData();
            String WordName = word.getText();
//            RealmResults<Word> words =collection.getWords().where().findAll();;
            Log.d(TAG, word.getText());
            Log.d(TAG," "  + word.getId());
            Toast.makeText(getActivity().getApplicationContext(), word.getText(), Toast.LENGTH_LONG).show();
//            Log.d(TAG, collectionName);
//            Log.d(TAG, courses.get(0).getWords().get(0).getText());

//            progress_bar.setVisibility(View.GONE);
        }
    }



    @Override
    public String getBusID() {
        return "BUS_ID_" + this.getClass().getName();
    }



}
