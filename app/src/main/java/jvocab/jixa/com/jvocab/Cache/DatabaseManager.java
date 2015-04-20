package jvocab.jixa.com.jvocab.Cache;

import android.content.Context;


import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager DBMInstance;
    public static DatabaseManager getInstance() {
        if (null == DBMInstance)
            return DBMInstance = new DatabaseManager();
        return DBMInstance;
    }

    public Word getWordById(Context context,int id){
        Realm realm = Realm.getInstance(context);
        return realm.where(Word.class).equalTo("id",id).findAll().get(0);
    }

    public void putWord(Context context,Word word){
        Realm realm = Realm.getInstance(context);
        realm.copyToRealm(word);
        realm.commitTransaction();
    }

    public RealmResults<Word>  getAllWords(Context context){
        Realm realm = Realm.getInstance(context);
        return realm.where(Word.class).findAll();
    }

    public RealmList<ReviewableWord> wordToReviewableWord(Context context,List<Word> words){
        Realm realm = Realm.getInstance(context);
        RealmList<ReviewableWord> reviewableWords = new RealmList<>();
        int days = 0;
        for (Word word : words){
            ReviewableWord reviewableWord = new ReviewableWord(word);
            reviewableWords.add(realm.copyToRealm(reviewableWord));
        }
        realm.commitTransaction();
        return reviewableWords;
    }


    public List<Exam> getExams (){
        return null;
    }


    public void dropTableReWords(){

    }
}
