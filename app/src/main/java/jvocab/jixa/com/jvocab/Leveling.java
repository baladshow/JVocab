package jvocab.jixa.com.jvocab;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.Model.Word;

public class Leveling {
    DatabaseManager dbm;
    Leveling LVLInstance;
    int[] factors;

    public Leveling getInstance() {
        if (null == LVLInstance)
            return LVLInstance = new Leveling();
        return LVLInstance;
    }

    public List<Word> getWords(Context context) {
        int interval = 3000;
        factors = new int[25];
        List<Word> words = new ArrayList<>();
        int t = 0;
        int sum = 0;
        dbm = DatabaseManager.getInstance();
        for (int i = 0; i < 10000; i += interval) {
            for (int j = 0; j < 5; j++) {
                int rnd = i + (int) (Math.random() * ((interval) + 1));
                words.add(dbm.getWordById(context, rnd));
                factors[t++] = rnd;
                sum += rnd;
            }
            interval -= 500;
        }
        for (int i = 0; i < 25; i++) {
            factors[i] = factors[i] / sum;
        }
        return words;
    }

//    public int calculateLevel(boolean[] answers){
//        int result = 0;
//        float coefficient = 0.5f;
//        for (int i=0 ; i<=25 ; i++){
//            if (answers[i]){
//                result += factors[i] * (1.4 - coefficient);
//            }else{
//                result += factors[]
//            }
//        }
//        return 0;
//    }
}