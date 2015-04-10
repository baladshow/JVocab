package jvocab.jixa.com.jvocab.Model.Interfaces;

import java.util.List;

/**
 * Created by mohammad on 3/15/15.
 */
public interface Storable<T> {

    List<T> Load();
    void Store();

}
