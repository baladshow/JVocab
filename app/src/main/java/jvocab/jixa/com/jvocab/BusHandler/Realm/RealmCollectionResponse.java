package jvocab.jixa.com.jvocab.BusHandler.Realm;


import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.Collection;

public class RealmCollectionResponse extends RealmResponse {
    public RealmCollectionResponse(String id, RealmResults<Collection> results) {
        super(id,results);
    }
}
