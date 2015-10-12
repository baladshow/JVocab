package jvocab.jixa.com.jvocab.BusHandler.Realm;


import jvocab.jixa.com.jvocab.Model.Word;

public class RealmWordResponse extends RealmResponse {
    private Word data;
    public RealmWordResponse(String id, Word result) {
        super(id);
        this.data = result;
    }

    public Word getData() {
        return data;
    }

    public void setData(Word data) {
        this.data = data;
    }
}
