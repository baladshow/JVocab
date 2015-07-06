package jvocab.jixa.com.jvocab.BusHandler.Realm;


import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.Collection;

public class RealmCollectionListResponse extends RealmResponse {
    private RealmResults<Collection> data;
    public RealmCollectionListResponse(String id, RealmResults<Collection> results) {
        super(id);
        this.data = results;
    }

    public RealmResults<Collection> getData() {
        return data;
    }

    public void setData(RealmResults<Collection> data) {
        this.data = data;
    }
}
