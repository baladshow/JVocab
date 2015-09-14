package jvocab.jixa.com.jvocab.BusHandler.Realm;


import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.Exam;

public class RealmExamListResponse extends RealmResponse {
    private RealmResults<Exam> data;
    public RealmExamListResponse(String id, RealmResults<Exam> results) {
        super(id);
        this.data = results;
    }

    public RealmResults<Exam> getData() {
        return data;
    }

    public void setData(RealmResults<Exam> data) {
        this.data = data;
    }
}
