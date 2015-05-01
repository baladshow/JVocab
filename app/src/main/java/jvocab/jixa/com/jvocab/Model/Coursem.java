package jvocab.jixa.com.jvocab.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.R;

public class Coursem extends RealmObject {

    @PrimaryKey
    private int id;

    private String name;

    private final int NUM_CORRECT_REQUIRED;

    private final int NUM_WORD_PER_DAY;

    private final int NUM_WORD_LIMIT_PER_DAY;

    private RealmList<ReviewableWord> reviweableWords;

    private RealmList<ReviewableWord> needMoreReview;

    public Coursem(Context context, List<Word> words, int num_correct_required,
                   int num_word_per_day,
                   int num_word_limit_per_day
    ) {
        this.setReviweableWords(
                DatabaseManager.getInstance().wordToReviewableWord(context, words));
        this.NUM_CORRECT_REQUIRED = num_correct_required;
        this.NUM_WORD_PER_DAY = num_word_per_day;
        this.NUM_WORD_LIMIT_PER_DAY = num_word_limit_per_day;
    }

    public void start() {
        long today = new Date().getTime();
        int days = 0;
        for (ReviewableWord rWord : reviweableWords) {
            rWord.setNextReview(today + (24 * 60 * 60 * 1000) * ((days++) % NUM_WORD_PER_DAY));
        }
    }

    public List<ReviewableWord> getTodayWords() {
        List<ReviewableWord> todayWords = new ArrayList<>();
        long today = new Date().getTime();
        int numWords = 0;
//        Calendar calendar = Calendar.getInstance();
        for (ReviewableWord rWord : reviweableWords) {
            if (numWords++ > this.NUM_WORD_LIMIT_PER_DAY) {
                return todayWords;

            }
            if (Math.abs(rWord.getNextReview() - today) < 24 * 60 * 60 * 1000) {
                todayWords.add(rWord);
                rWord.setNextReview((rWord.getStage() + 1) * 24 * 60 * 60 * 1000);
            }

        }
        for (ReviewableWord rWord : needMoreReview) {
            if (numWords++ > this.NUM_WORD_LIMIT_PER_DAY) {
                return todayWords;
            }
            todayWords.add(rWord);
        }
        return todayWords;
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
        return reviweableWords;
    }

    public void setReviweableWords(RealmList<ReviewableWord> reviweableWords) {
        this.reviweableWords = reviweableWords;
    }

    public int getNUM_CORRECT_REQUIRED() {
        return NUM_CORRECT_REQUIRED;
    }

    public int getNUM_WORD_PER_DAY() {
        return NUM_WORD_PER_DAY;
    }

    public int getNUM_WORD_LIMIT_PER_DAY() {
        return NUM_WORD_LIMIT_PER_DAY;
    }

    public RealmList<ReviewableWord> getNeedMoreReview() {
        return needMoreReview;
    }

    public void setNeedMoreReview(RealmList<ReviewableWord> needMoreReview) {
        this.needMoreReview = needMoreReview;
    }

    public void setWordCorrectAnwer(ReviewableWord word) {
        word.correctAnswer();
    }

    public void setWordWorngAnswer(ReviewableWord word) {
        RealmList<ReviewableWord> list = this.getNeedMoreReview();
        list.add(word);
        this.setReviweableWords(list);
    }

}
