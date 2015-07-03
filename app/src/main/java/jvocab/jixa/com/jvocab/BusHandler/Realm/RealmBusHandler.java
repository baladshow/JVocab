package jvocab.jixa.com.jvocab.BusHandler.Realm;

import de.greenrobot.event.EventBus;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.Model.Collection;

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
        if(typeRequest == RealmRequest.COLLECTION_WORD_REQUEST){
            RealmResults<Collection> results = DatabaseManager.getInstance().getAllCollections(request.getContext());

            EventBus.getDefault().post(new RealmCollectionResponse(request.getID(),results));
        }
    }

}
