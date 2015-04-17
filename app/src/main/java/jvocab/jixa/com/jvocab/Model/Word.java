package jvocab.jixa.com.jvocab.Model;

<<<<<<< HEAD
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.List;
=======
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
>>>>>>> Database

public class Word extends RealmObject {

    @PrimaryKey
    private int id;
<<<<<<< HEAD
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
=======

    private String text;

    private RealmList<Word> synonyms;

    private RealmList<Word> antonyms;

    private RealmList<Sentence> sentences;

    private String image;

    private int level;

    private boolean isFavorite;

    public Word() {
    }

    public Word(String word) {
        this.text = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
>>>>>>> Database
    }

    public RealmList<Word> getSynonyms() {
        return synonyms;
    }

<<<<<<< HEAD
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
=======
    public void setSynonyms(RealmList<Word> synonyms) {
        this.synonyms = synonyms;
    }

    public RealmList<Word> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(RealmList<Word> antonyms) {
        this.antonyms = antonyms;
>>>>>>> Database
    }

    public RealmList<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(RealmList<Sentence> sentences) {
        this.sentences = sentences;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
