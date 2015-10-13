package jvocab.jixa.com.jvocab.BusHandler.Realm;


import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.Collection;

public class RealmCollectionResponse extends RealmResponse {
    private Collection data;
    public RealmCollectionResponse(String id, Collection result) {
        super(id);
        this.data = result;
    }

    public Collection getData() {
        return data;
    }

    public void setData(Collection data) {
        this.data = data;
    }
}
