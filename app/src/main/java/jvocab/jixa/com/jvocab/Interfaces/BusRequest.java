package jvocab.jixa.com.jvocab.Interfaces;


public interface BusRequest {
    public int getRequestType();
    public BusRequest setRequestType(int requestType);
    public BusRequest setID(String id);
    public String getID();
}
