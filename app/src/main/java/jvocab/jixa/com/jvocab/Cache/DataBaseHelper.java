package jvocab.jixa.com.jvocab.Cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import jvocab.jixa.com.jvocab.Model.*;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "JvocabDB";
    private static final int DATABASE_VERSION = 1;
    private Dao<Exam, Integer> examsDao;
    private Dao<CollectionWord, Integer> collectionDao;


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {

    }
}


