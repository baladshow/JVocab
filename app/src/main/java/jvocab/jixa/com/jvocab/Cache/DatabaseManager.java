package jvocab.jixa.com.jvocab.Cache;

import android.content.Context;

<<<<<<< HEAD
import com.j256.ormlite.dao.Dao;

import jvocab.jixa.com.jvocab.Model.*;

import java.sql.SQLException;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager ourInstance;
    private DataBaseHelper mHelper;
    private Context mContext;
    private Dao<Exam,Integer> examsDao;
    private Dao<Word,Integer> wordDao;

    public static void init (Context context){
        if (ourInstance == null)
            ourInstance = new DatabaseManager(context);
    }

=======

import io.realm.Realm;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.*;

import java.util.List;

public class DatabaseManager {
    private static DatabaseManager DBMInstance;
>>>>>>> Database
    public static DatabaseManager getInstance() {
        if (null == DBMInstance)
            return DBMInstance = new DatabaseManager();
        return DBMInstance;
    }

    public Word getWordById(Context context,int id){
        Realm realm = Realm.getInstance(context);
        return realm.where(Word.class).equalTo("id",id).findAll().get(0);
    }

<<<<<<< HEAD
    private Dao<Exam, Integer> getExamsDao() {
        if(null == examsDao)

            try {
                examsDao = mHelper.getDao(Exam.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return examsDao;
    }

    private Dao<Word, Integer> getWordDao() {
        if(null == wordDao)

            try {
                wordDao = mHelper.getDao(Word.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return wordDao;
    }


    public void putWord(Word word){
        try {
            getWordDao().create(word);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<Word>  getWords(){
        try {
            return getWordDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
=======
    public void putWord(Context context,Word word){
        Realm realm = Realm.getInstance(context);
        realm.copyToRealm(word);
        realm.commitTransaction();
>>>>>>> Database
    }

    public RealmResults<Word>  getAllWords(Context context){
        Realm realm = Realm.getInstance(context);
        return realm.where(Word.class).findAll();
    }


    public List<Exam> getExams (){
        return null;
    }


    public void dropTableReWords(){

    }
}
