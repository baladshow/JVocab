package jvocab.jixa.com.jvocab.Model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Collection extends RealmObject{

    @PrimaryKey
    private int id;

    private String name;


    private int extra;

    private RealmList<Word> words;

//    private String nikName;

//    private int color;

//    private int level;

//    private int daysLong;

    public Collection(){}

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

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }

    public RealmList<Word> getWords() {
        return words;
    }

    public void setWords(RealmList<Word> words) {
        this.words = words;
    }

//    public int getColor() {
//        return color;
//    }
//
//    public void setColor(int color) {
//        this.color = color;
//    }


//    public String getNikName() {
//        return nikName;
//    }
//
//    public void setNikName(String nikName) {
//        this.nikName = nikName;
//    }

//
//    public int getLevel() {
//        return level;
//    }
//
//    public void setLevel(int level) {
//        this.level = level;
//    }
//
//    public int getDaysLong() {
//        return daysLong;
//    }
//
//    public void setDaysLong(int daysLong) {
//        this.daysLong = daysLong;
//    }
}
