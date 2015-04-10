package jvocab.jixa.com.jvocab.Model;

import jvocab.jixa.com.jvocab.Model.Enum.WordsLevel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

@DatabaseTable
public class CollectionWord {
    private ArrayList<Word> words;
    @DatabaseField
    private String name;
    @DatabaseField
    private String explain;
    @DatabaseField
    private WordsLevel level;

    public CollectionWord(ArrayList<Word> words, int wordsCount, String name, String explain, WordsLevel level) {
        this.words = words;
        this.name = name;
        this.explain = explain;
        this.level = level;
    }
}

