package jvocab.jixa.com.jvocab.Model;

import jvocab.jixa.com.jvocab.Model.Enum.*;
import jvocab.jixa.com.jvocab.Model.Interfaces.Periodly;

import java.sql.Time;
import java.util.List;

public class TrainClass implements Periodly {

    private List<CollectionWord> collectionWords;
    private List<Word> todayWords;
    private String name;
    private int daysCount , hoursPerDay , wordsPerDay ;
    private ReviewType reviewType;


    public List<CollectionWord> getCollectionWords() {
        return collectionWords;
    }

    public void setCollectionWords(List<CollectionWord> collectionWords) {
        this.collectionWords = collectionWords;
    }

    public List<Word> getTodayWords() {
        return todayWords;
    }

    public void setTodayWords(List<Word> todayWords) {
        this.todayWords = todayWords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }

    public int getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(int hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public int getWordsPerDay() {
        return wordsPerDay;
    }

    public void setWordsPerDay(int wordsPerDay) {
        this.wordsPerDay = wordsPerDay;
    }

    @Override
    public Time startTime() {
        return null;
    }

    @Override
    public Time EndTime() {
        return null;
    }

    @Override
    public Time elaspedTime() {
        return null;
    }




}
