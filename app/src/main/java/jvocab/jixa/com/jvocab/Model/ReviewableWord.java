package jvocab.jixa.com.jvocab.Model;

import java.util.Date;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ReviewableWord extends RealmObject{

    @PrimaryKey
    private int id;

    private Word word;

    private int numCorrectReview;

    private Date nextReview;

    public ReviewableWord (){}

    public ReviewableWord(Word word,Date nextReview){
        this.setWord(word);
        this.setNextReview(nextReview);
        this.setNumCorrectReview(0);
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

    public Date getNextReview() {
        return nextReview;
    }

    public void setNextReview(Date nextReview) {
        this.nextReview = nextReview;
    }

}
