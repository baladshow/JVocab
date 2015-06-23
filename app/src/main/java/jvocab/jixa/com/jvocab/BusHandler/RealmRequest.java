package jvocab.jixa.com.jvocab.BusHandler;

import android.content.Context;

import jvocab.jixa.com.jvocab.Interfaces.BusRequest;

public class RealmRequest implements BusRequest {
    public static final int COLLECTION_WORD_REQUEST = 0;
    private int type;
    private String id;
    private Context context;



    public RealmRequest(int type, String id, Context context) {
        this.type = type;
        this.id = id;
        this.context = context;
    }

    @Override
    public int getRequestType() {
        return type;
    }

    @Override
    public BusRequest setRequestType(int requestType) {
        this.type = requestType;
        return this;
    }

    @Override
    public BusRequest setID(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String getID() {
        return id;
    }


    public Context getContext() {
        return context;
    }

    public BusRequest setContext(Context context) {
        this.context = context;
        return this;
    }
}
