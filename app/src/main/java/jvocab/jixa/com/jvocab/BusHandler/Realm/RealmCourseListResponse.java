package jvocab.jixa.com.jvocab.BusHandler.Realm;


import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.Model.Course;

public class RealmCourseListResponse extends RealmResponse {
    private RealmResults<Course> data;
    public RealmCourseListResponse(String id, RealmResults<Course> results) {
        super(id);
        this.data = results;
    }

    public RealmResults<Course> getData() {
        return data;
    }

    public void setData(RealmResults<Course> data) {
        this.data = data;
    }
}
