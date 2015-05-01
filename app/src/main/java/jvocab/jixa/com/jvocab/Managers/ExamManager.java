package jvocab.jixa.com.jvocab.Managers;


import jvocab.jixa.com.jvocab.Model.Exam;
import java.util.List;

public class ExamManager extends  AbstractManager<Exam> {


    private static ExamManager EMInstance = new ExamManager();

    public static ExamManager getInstance() {
        return EMInstance;
    }

    private ExamManager() {   }


    @Override
    public List<Exam> Load() {
        return null;
    }

    @Override
    public void Store() {

    }
}
