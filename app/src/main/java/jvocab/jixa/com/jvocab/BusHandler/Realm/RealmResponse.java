package jvocab.jixa.com.jvocab.BusHandler.Realm;


import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Interfaces.BusResponse;

public class RealmResponse implements BusResponse{

    private String id;

    public RealmResponse(String id) {
        this.id = id;
    }

    @Override
    public String getResponseID() {
        return this.id;
    }


}
