package jvocab.jixa.com.jvocab.BusHandler;


import io.realm.RealmObject;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Interfaces.BusResponse;

public class RealmResponse<E extends RealmObject> implements BusResponse{

    private String id;
    private RealmResults<E> data;


    public RealmResponse(String id, RealmResults<E> data) {
        this.id = id;
        this.data = data;
    }

    public RealmResults<E> getData(){
        return data;
    }



    @Override
    public String getResponseID() {
        return this.id;
    }

    public BusResponse setData(RealmResults<E> data) {
        this.data = data;
        return this;
    }
}
