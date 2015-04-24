package jvocab.jixa.com.jvocab.Model;

import java.util.Date;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import jvocab.jixa.com.jvocab.R;

public class ReviewableWord extends RealmObject{

    @PrimaryKey
    private int id;

    private Word word;

    private int numCorrectReview;

//    private Date nextReview;
    private long nextReview;

    private short stage;

    public ReviewableWord (){}

    private boolean reviewComplete;

    public ReviewableWord(Word word){
        this.setWord(word);
        this.setNextReview(nextReview);
        this.setNumCorrectReview(0);
        this.reviewComplete = true;
        this.stage = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public int getNumCorrectReview() {
        return numCorrectReview;
    }

    public void setNumCorrectReview(int numCorrectReview) {
        this.numCorrectReview = numCorrectReview;
    }

    public long getNextReview() {
        return nextReview;
    }

    public void setNextReview(long nextReview) {
        this.nextReview = nextReview;
    }

    public boolean isReviewComplete() {
        return reviewComplete;
    }

    public void setReviewComplete(boolean reviewComplete) {
        this.reviewComplete = reviewComplete;
    }

    public short getStage() {
        return stage;
    }

    public void setStage(short stage) {
        this.stage = stage;
    }

    public void plusNumCorrects(){ this.setNumCorrectReview(++this.numCorrectReview);  }

    public void correctAnswer(){
        this.setNumCorrectReview(this.getNumCorrectReview() + 1);
    }

}
