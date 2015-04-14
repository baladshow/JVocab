package jvocab.jixa.com.jvocab.Cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import jvocab.jixa.com.jvocab.Model.*;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "JvocabDB";
    private static final int DATABASE_VERSION = 3;


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            Log.i(DataBaseHelper.class.getName(), "onCreateDatabase");
            TableUtils.createTable(connectionSource, Word.class);
        } catch (SQLException e) {
            Log.e(DataBaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        try {
            Log.i(DataBaseHelper.class.getName(), "onUpgradeDataBase");
            TableUtils.createTable(connectionSource, Word.class);
        } catch (SQLException e) {
            Log.e(DataBaseHelper.class.getName(), "Can't upgrade database", e);
            throw new RuntimeException(e);
        }


    }


}


