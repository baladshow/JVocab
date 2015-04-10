package jvocab.jixa.com.jvocab.Managers;


import jvocab.jixa.com.jvocab.Model.Exam;
import java.util.List;

public class ExamsManager extends  AbstractManager<Exam> {


    private static ExamsManager ourInstance = new ExamsManager();

    public static ExamsManager getInstance() {
        return ourInstance;
    }

    private ExamsManager() {
    }


    @Override
    public List<Exam> Load() {
        return null;
    }

    @Override
    public void Store() {

    }
}
