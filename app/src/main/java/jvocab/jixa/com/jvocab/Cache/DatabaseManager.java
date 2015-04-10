package jvocab.jixa.com.jvocab.Cache;

import android.content.Context;

import jvocab.jixa.com.jvocab.Model.*;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager ourInstance;
    private DataBaseHelper mHelper;
    private Context mContext;

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
