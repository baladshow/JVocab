package jvocab.jixa.com.jvocab.Managers;


import java.util.List;

import jvocab.jixa.com.jvocab.Interfaces.IStatistic;
import jvocab.jixa.com.jvocab.Model.Word;

public class WordsManager extends  AbstractManager<Word> implements IStatistic {

    private static WordsManager ourInstance = new WordsManager();


    private WordsManager() {}

    public static WordsManager getInstance() {
        return ourInstance;
    }





    @Override
    public List<Word> Load() {
        return null;
    }

    @Override
    public void Store() {

    }

    @Override
    public int wordsLearned() {
        return 0;
    }

    @Override
    public int wordsReviewed() {
        return 0;
    }

    @Override
    public int wordsReaded() {
        return 0;
    }

    @Override
    public int answerWrong() {
        return 0;
    }

    @Override
    public int answerCorrect() {
        return 0;
    }
}
