package jvocab.jixa.com.jvocab.Model;

import jvocab.jixa.com.jvocab.Model.Enum.WordsLevel;
import com.j256.ormlite.field.DatabaseField;

import java.util.List;

public class Exam {
   private List<CollectionWord> collectionWords;
   @DatabaseField
   private String name;
   @DatabaseField
   private String explain;
   @DatabaseField
   private WordsLevel level;
}
