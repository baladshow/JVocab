package jvocab.jixa.com.jvocab.BusHandler.Realm;

import android.util.Log;

import de.greenrobot.event.EventBus;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.Model.Exam;
import jvocab.jixa.com.jvocab.Model.Word;

public class RealmBusHandler {
    private static final String TAG = "***RealmBusHandler";
    private static RealmBusHandler mInstance;
    public static RealmBusHandler createInstance(){
        mInstance = new RealmBusHandler();
        EventBus.getDefault().register(mInstance);
        return mInstance;
    }

    public static RealmBusHandler getIntance(){
        return mInstance;
    }

    public void onEvent(RealmRequest request) {
        Log.d("*****", "realmBus handler  : ");
        int typeRequest = request.getRequestType();
        if(typeRequest == RealmRequest.COLLECTION_LIST_REQUEST){
            RealmResults<Collection> results = DatabaseManager.getInstance().getAllCollections(request.getContext());
            EventBus.getDefault().post(new RealmCollectionListResponse(request.getID(),results));
            Log.d("*****", "get and send collection list : " + results);
        }else if(typeRequest == RealmRequest.COLLECTION_REQUEST){
            Collection collection = DatabaseManager.getInstance().getCollectionByID(request.getContext(), request.getParam());
            EventBus.getDefault().post(new  RealmCollectionResponse(request.getID(),collection));
        }else if(typeRequest == RealmRequest.EXAM_REQUEST){
            Exam exam  = DatabaseManager.getInstance().getExamByID(request.getContext(), request.getParam());
            EventBus.getDefault().post(new  RealmExamResponse(request.getID(),exam));
        }else if(typeRequest == RealmRequest.EXAM_LIST_REQUEST){
            Log.d(TAG, "exam list request realm bus handler");
            RealmResults<Exam> exams = DatabaseManager.getInstance().getAllExams(request.getContext());
            Log.d(TAG, "exam list request realm bus handler exams : " + exams);
            EventBus.getDefault().post(new  RealmExamListResponse(request.getID(),exams));
        }else if(typeRequest == RealmRequest.WORD_LIST_REQUEST){
            Log.d(TAG, "word list request realm bus handler");
            RealmResults<Word> words = DatabaseManager.getInstance().getCollectionWords(request.getContext(), request.getParam());
            Log.d(TAG, "wordlist request realm bus handler words : " + words);
            EventBus.getDefault().post(new  RealmWordListResponse(request.getID(),words));
        }else if(typeRequest == RealmRequest.WORD_REQUEST){
            Word word = DatabaseManager.getInstance().getWordById(request.getContext(), request.getParam());
            EventBus.getDefault().post(new  RealmWordResponse(request.getID(),word));
        }

    }

}
