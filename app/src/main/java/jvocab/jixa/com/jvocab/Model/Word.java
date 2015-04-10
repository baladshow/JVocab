package jvocab.jixa.com.jvocab.Model;

import com.j256.ormlite.field.DatabaseField;

public class Word {

    @DatabaseField (generatedId = true)
    private int id;
    @DatabaseField
    private String word ;
    private Word[] Synonymous = new Word[3];
    private Word antonym;

    public Word(String word) {
        this.word = word;
    }
    public Word(){}

    public int getSentencesCount() {
        return sentencesCount;
    }

    public void setSentencesCount(int sentencesCount) {
        this.sentencesCount = sentencesCount;
    }


    public Word getAntonym() {
        return antonym;
    }

    public void setAntonym(Word antonym) {
        this.antonym = antonym;
    }

    public Word[] getSynonymous() {
        return Synonymous;
    }

    public void setSynonymous(Word[] synonymous) {
        Synonymous = synonymous;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private int sentencesCount;



}
