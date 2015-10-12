package Bus;

import jvocab.jixa.com.jvocab.Interfaces.BusRequest;

/**
 * Created by root on 9/18/15.
 */
public class HostActivityRequest implements BusRequest {
    String id;
    int type;
    public HostActivityRequest(int type, String id){
        this.id = id;
        this.type = type;
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
        return  this;
    }

    @Override
    public String getID() {
        return id;
    }
}
