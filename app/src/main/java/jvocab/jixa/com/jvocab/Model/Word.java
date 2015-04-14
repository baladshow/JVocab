package jvocab.jixa.com.jvocab.Model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.List;

public class Word {

    @DatabaseField (generatedId = true)
    private int id;
    @DatabaseField
    private String word;

    @DatabaseField(foreign = true,foreignAutoCreate = true)
    private Word synonym;

    @DatabaseField(foreign = true,foreignAutoCreate = true)
    private Word antonym;

    @ForeignCollectionField
    private ForeignCollection<Word> synonyms;

    @ForeignCollectionField
    private ForeignCollection<Word> antonyms;

    public Word(){}

    public Word(String word) {
        this.word = word;
    }

    public Word getSynonym() {
        return synonym;
    }

    public Word getAntonym() {
        return antonym;
    }

    public void setAntonym(Word antonym) {
        this.antonym = antonym;
    }

    public void setSynonym(Word synonym) {
        this.synonym = synonym;
    }

    public int getSentencesCount() {
        return sentencesCount;
    }

    public void setSentencesCount(int sentencesCount) {
        this.sentencesCount = sentencesCount;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private int sentencesCount;



}
