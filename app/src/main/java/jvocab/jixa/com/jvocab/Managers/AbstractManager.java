package jvocab.jixa.com.jvocab.Managers;



import java.util.List;

import jvocab.jixa.com.jvocab.Interfaces.IManager;
import jvocab.jixa.com.jvocab.Interfaces.Storable;

public abstract class AbstractManager<T> implements IManager<T>, Storable<T> {

    List<T> members;

    @Override
    public List<T> getAllMember(){
        return members;
    }

    @Override
    public void add(T newMember){
        members.add(newMember);
    }

    @Override
    public T getMemberByIndex(int index){
        return members.get(index);
    }

    @Override
    public abstract List<T> Load();

    @Override
    public abstract void Store();


}
