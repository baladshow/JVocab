package jvocab.jixa.com.jvocab.BusHandler.Realm;


import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.Model.Word;

public class RealmWordListResponse extends RealmResponse {
    private RealmResults<Word> data;
    public RealmWordListResponse(String id, RealmResults<Word> results) {
        super(id);
        this.data = results;
    }

    public RealmResults<Word> getData() {
        return data;
    }

    public void setData(RealmResults<Word> data) {
        this.data = data;
    }
}
