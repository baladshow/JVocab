package jvocab.jixa.com.jvocab.View;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import de.greenrobot.event.EventBus;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmCollectionResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmExamResponse;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmRequest;
import jvocab.jixa.com.jvocab.Interfaces.BusResponseReciver;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.Model.Exam;

public class ExamActivity extends Activity implements BusResponseReciver{
    private static final String TAG = "****Exam ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        requestData();

    }

    private void requestData(){

        int examID = getIntent().getIntExtra("id",0);
        Log.d(TAG , "request  " + examID);
        RealmRequest request = new RealmRequest(getApplicationContext(),RealmRequest.EXAM_REQUEST,getBusID(),examID);
        EventBus.getDefault().post(request);
    }

    public void onEvent(RealmExamResponse response){
        Log.d(TAG , "onEvent()");
        if(getBusID().equals(response.getResponseID())) {
            Exam exam =  response.getData();
//            Log.d("a : ", exam.getWords().get(10).getText());
            Log.d(TAG, exam.getName());
        }
    }

    @Override
    public String getBusID() {
        return "BUS_ID_"+this.getClass().getName();
    }
}
