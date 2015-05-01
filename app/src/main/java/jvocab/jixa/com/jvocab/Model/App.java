package jvocab.jixa.com.jvocab.Model;

import android.app.Application;

import jvocab.jixa.com.jvocab.Managers.ExamManager;
import jvocab.jixa.com.jvocab.Managers.WordsManager;


public class App  extends Application{


    public App() {

//        WordsManager wordsManager = WordsManager.getInstance();
//        ExamManager examsManager = ExamManager.getInstance();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
