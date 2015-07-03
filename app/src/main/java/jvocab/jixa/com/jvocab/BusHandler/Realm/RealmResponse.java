package jvocab.jixa.com.jvocab.BusHandler.Realm;


import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Interfaces.BusResponse;

public class RealmResponse implements BusResponse{

    private String id;
    private RealmResults data;

    public RealmResponse(String id,RealmResults data) {
        this.id = id;
        this.data = data;
    }

    public RealmResults getData(){
        return data;
    }

    @Override
    public String getResponseID() {
        return this.id;
    }

    public BusResponse setData(RealmResults data) {
        this.data = data;
        return this;
    }

}
