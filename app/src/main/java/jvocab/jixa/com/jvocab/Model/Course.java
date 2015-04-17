package jvocab.jixa.com.jvocab.Model;

import android.content.Context;

import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import jvocab.jixa.com.jvocab.Cache.DatabaseManager;

public class Course extends RealmObject {

    @PrimaryKey
    private int id;

    private String name;

    private RealmList<ReviewableWord> ReviweableWords;

    public Course(Context context, List<Word> words) {
        this.setReviweableWords(
                DatabaseManager.getInstance().wordToReviewableWord(context, words, new Date()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<ReviewableWord> getReviweableWords() {
        return ReviweableWords;
    }

    public void setReviweableWords(RealmList<ReviewableWord> reviweableWords) {
        ReviweableWords = reviweableWords;
    }
}
