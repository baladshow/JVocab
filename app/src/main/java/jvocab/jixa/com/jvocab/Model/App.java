package jvocab.jixa.com.jvocab.Model;

import android.app.Application;
import android.util.Log;

import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.Managers.ClassesManager;
import jvocab.jixa.com.jvocab.Managers.ExamsManager;
import jvocab.jixa.com.jvocab.Managers.WordsManager;


public class App  extends Application{


    public App() {


        WordsManager wordsManager = WordsManager.getInstance();
        ExamsManager examsManager = ExamsManager.getInstance();
        ClassesManager classesManager = ClassesManager.getInstance();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
