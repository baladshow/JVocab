package jvocab.jixa.com.jvocab.BusHandler.Realm;

import de.greenrobot.event.EventBus;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.Model.Exam;

public class RealmBusHandler {
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
        int typeRequest = request.getRequestType();
        if(typeRequest == RealmRequest.COLLECTION_LIST_REQUEST){
            RealmResults<Collection> results = DatabaseManager.getInstance().getAllCollections(request.getContext());
            EventBus.getDefault().post(new RealmCollectionListResponse(request.getID(),results));
        }else if(typeRequest == RealmRequest.COLLECTION_REQUEST){
            Collection collection = DatabaseManager.getInstance().getCollectionByID(request.getContext(), request.getParam());
            EventBus.getDefault().post(new  RealmCollectionResponse(request.getID(),collection));
        }else if(typeRequest == RealmRequest.EXAM_REQUEST){
            Exam exam  = DatabaseManager.getInstance().getExamByID(request.getContext(), request.getParam());
            EventBus.getDefault().post(new  RealmExamResponse(request.getID(),exam));
        }else if(typeRequest == RealmRequest.EXAM_LIST_REQUEST){
            RealmResults<Exam> exams = DatabaseManager.getInstance().getAllExams(request.getContext());
            EventBus.getDefault().post(new  RealmExamListResponse(request.getID(),exams));
        }

    }

}
