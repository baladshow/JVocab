package jvocab.jixa.com.jvocab.BusHandler.Realm;

import android.content.Context;

import jvocab.jixa.com.jvocab.Interfaces.BusRequest;

public class RealmRequest implements BusRequest {
    public static final int COLLECTION_LIST_REQUEST = 0;
    public static final int COLLECTION_REQUEST = 1;
    public static final int COURSE_LIST_REQUEST = 2;
    public static final int COURSE_REQUEST = 3;
    public static final int EXAM_REQUEST = 4;
    public static final int EXAM_LIST_REQUEST = 5;
    private int type;
    private String id;
    private int param;
    private Context context;




    public RealmRequest(Context context,int type, String id) {
        this.type = type;
        this.id = id;
        this.context = context;
    }
    public RealmRequest(Context context,int type, String id,int param) {
        this.type = type;
        this.id = id;
        this.context = context;
        this.param = param;
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

    public int getParam() {
        return param;
    }

    public RealmRequest setParam(int pram) {
        this.param = pram;
        return this;
    }
}
