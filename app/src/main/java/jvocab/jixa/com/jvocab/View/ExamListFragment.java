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
import jvocab.jixa.com.jvocab.Adapters.ExamListAdapter;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmExamListResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmRequest;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Interfaces.IMainPage;
import jvocab.jixa.com.jvocab.Model.Exam;
import jvocab.jixa.com.jvocab.R;

public class ExamListFragment extends Fragment implements BusResponseReciver, IMainPage,AdapterView.OnItemClickListener {

    private static final String TAG = "****ExamList";
    private ExamListAdapter adapter;
    private ListView listView;
    private RealmResults<Exam> exams;
    private   ProgressBar progressBar;
    private static final String TITLE = "Exam List" ;

    public static Fragment newInstance(){
        return new ExamListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.fragment_exam_list);
        Log.d(TAG, "onCreate ExamListFragment");
        EventBus.getDefault().register(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        Log.d(TAG, "onCreateView ExamListFragment");
        View view = inflater.inflate(R.layout.fragment_exam_list,container,false);
        listView = (ListView) view.findViewById(R.id.exam_list_view);
        progressBar = (ProgressBar) view.findViewById(R.id.exam_list_progress);
        RealmRequest request = new RealmRequest(getActivity().getApplicationContext(),RealmRequest.EXAM_LIST_REQUEST,getBusID());
        EventBus.getDefault().post(request);
        return view;

    }

    public void onEvent(RealmExamListResponse response){
        Log.d(TAG, "onEvent ExamListFragment");
        if(getBusID().equals(response.getResponseID())) {
            exams = response.getData();
//            Log.d(TAG, "onEvent ---> ExamListFragment exam : " + exams);
//            Log.d(TAG, courses.get(0).getName());
//            Log.d(TAG, courses.get(0).getWords().get(0).getText());
            if(null == adapter){
                adapter = new ExamListAdapter(getActivity().getApplicationContext(),exams,true);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(this);
            }
            else{
                adapter.setData(exams);
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
        Intent intent = new Intent(getActivity().getApplicationContext(),ExamActivity.class);
        intent.putExtra("id",adapter.getData().get(position).getId());
        startActivity(intent);
    }

    @Override
    public String getTitle() {
        return TITLE;
    }


}
