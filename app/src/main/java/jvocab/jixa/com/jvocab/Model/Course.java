package jvocab.jixa.com.jvocab.Model;

import io.realm.RealmList;
import io.realm.annotations.PrimaryKey;

public class Course {

    @PrimaryKey
    private int  id;

    private String name;

    private int numCorrectRequired;

    private int numNewWordPerDay ;

    private int numWordLimitPerDay;

    private RealmList<ReviewableWord> reviewableWords;

    private RealmList<ReviewableWord> needMoreReview;

    public Course(){   }

    public Course(int numNewWordPerDay, int numWordLimitPerDay){
        this.numNewWordPerDay = numNewWordPerDay;
        this.numWordLimitPerDay = numWordLimitPerDay;
        this.numCorrectRequired = 5;
    }

    public Course(int numNewWordPerDay, int numWordLimitPerDay, int numCorrectRequired){
        this.numNewWordPerDay = numNewWordPerDay;
        this.numWordLimitPerDay = numWordLimitPerDay;
        this.numCorrectRequired = numCorrectRequired;
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

    public int getNumCorrectRequired() {
        return numCorrectRequired;
    }

    public void setNumCorrectRequired(int numCorrectRequired) {
        this.numCorrectRequired = numCorrectRequired;
    }

    public int getNumNewWordPerDay() {
        return numNewWordPerDay;
    }

    public void setNumNewWordPerDay(int numNewWordPerDay) {
        this.numNewWordPerDay = numNewWordPerDay;
    }

    public int getNumWordLimitPerDay() {
        return numWordLimitPerDay;
    }

    public void setNumWordLimitPerDay(int numWordLimitPerDay) {
        this.numWordLimitPerDay = numWordLimitPerDay;
    }

    public RealmList<ReviewableWord> getReviewableWords() {
        return reviewableWords;
    }

    public void setReviewableWords(RealmList<ReviewableWord> reviewableWords) {
        this.reviewableWords = reviewableWords;
    }

    public RealmList<ReviewableWord> getNeedMoreReview() {
        return needMoreReview;
    }

    public void setNeedMoreReview(RealmList<ReviewableWord> needMoreReview) {
        this.needMoreReview = needMoreReview;
    }
}
