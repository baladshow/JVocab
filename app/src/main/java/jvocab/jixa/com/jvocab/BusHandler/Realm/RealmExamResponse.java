package jvocab.jixa.com.jvocab.BusHandler.Realm;


import jvocab.jixa.com.jvocab.Model.Exam;

public class RealmExamResponse extends RealmResponse {
    private Exam data;
    public RealmExamResponse(String id, Exam result) {
        super(id);
        this.data = result;
    }

    public Exam getData() {
        return data;
    }

    public void setData(Exam data) {
        this.data = data;
    }
}
