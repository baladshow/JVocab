package jvocab.jixa.com.jvocab.Cache;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import jvocab.jixa.com.jvocab.Model.*;

import java.sql.SQLException;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager ourInstance;
    private DataBaseHelper mHelper;
    private Context mContext;
    private Dao<Exam,Integer> examsDao;
    private Dao<Word,Integer> wordDao;

    public static void init (Context context){
        if (ourInstance == null)
            ourInstance = new DatabaseManager(context);
    }

    public static DatabaseManager getInstance() {
        return ourInstance;
    }

    private DatabaseManager(Context context) {

        mHelper = new DataBaseHelper(context);

    }

    private Dao<Exam, Integer> getExamsDao() {
        if(null == examsDao)

            try {
                examsDao = mHelper.getDao(Exam.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return examsDao;
    }

    private Dao<Word, Integer> getWordDao() {
        if(null == wordDao)

            try {
                wordDao = mHelper.getDao(Word.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return wordDao;
    }


    public void putWord(Word word){
        try {
            getWordDao().create(word);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<Word>  getWords(){
        try {
            return getWordDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public List<ReviewableWord> getWords(){
//        List<ReviewableWord> reviewableWords = null;
//        try {
//             reviewableWords =  mHelper.getReWordsDao().queryForAll();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return  reviewableWords;
//    }

    public List<CollectionWord> getCollectionWords(){
        return null;
    }

    public List<Exam> getExams (){
        return null;
    }

//    public void putRewWordInDb(ReviewableWord r){
//
//        try {
//            mHelper.getReWordsDao().create(r);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void dropTableReWords(){

    }
}
