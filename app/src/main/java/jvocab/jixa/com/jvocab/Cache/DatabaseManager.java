package jvocab.jixa.com.jvocab.Cache;

import android.content.Context;


import io.realm.Realm;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.*;

import java.util.List;

public class DatabaseManager {
    private static DatabaseManager DBMInstance;
    public static DatabaseManager getInstance() {
        if (null == DBMInstance)
            return DBMInstance = new DatabaseManager();
        return DBMInstance;
    }

}
