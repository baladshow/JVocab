package jvocab.jixa.com.jvocab.Managers;

import jvocab.jixa.com.jvocab.Model.TrainClass;
import java.util.List;

public class ClassesManager extends AbstractManager<TrainClass> {

    private static ClassesManager ourInstance = new ClassesManager();
    private boolean isClassRunning;      // aya alan ye train class dar hal ejras?!

    private ClassesManager() {}

    public static ClassesManager getInstance() {

        return ourInstance;
    }



    @Override
    public List<TrainClass> Load() {
        return null;
    }

    @Override
    public void Store() {

    }
}
