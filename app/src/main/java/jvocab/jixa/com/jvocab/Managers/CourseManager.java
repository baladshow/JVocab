package jvocab.jixa.com.jvocab.Managers;


import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.Model.Course;
import jvocab.jixa.com.jvocab.Model.ReviewableWord;
import jvocab.jixa.com.jvocab.Model.Word;

public class CourseManager extends AbstractManager<Course> {

    private final static String LEITNER_COURSE = "LEITNER_COURSE";
    private final static String CUSTOM_COURSE = "CUSTOM_COURSE";
    private final static int MAX_WORD_EACH_TIME = 30;
    private final static int MAX_NEW_WORD_PER_DAY = 20;

    private static CourseManager CMInstance;
    private DatabaseManager dbm;

    public static CourseManager getInstance() {
        if (null != CMInstance) {
            return CMInstance;
        }
        return CMInstance = new CourseManager();
    }

    public Course createCourse(Context context, List<Word> wordList,
                               String courseType, String name, int numNewWordPerDay,
                               int numStageRequired
    ) {
        dbm = DatabaseManager.getInstance();
        return dbm.createCourse(context,wordList,courseType,name,numNewWordPerDay,numStageRequired);
    }

    public List<Course> getAllCourse(Context context) {
        dbm = DatabaseManager.getInstance();
        return dbm.getAllCourses(context);
    }

    public void startCourse(Context context,Course course) {
        Realm realm = Realm.getInstance(context);
        long today = new Date().getTime();
        int days = 0;
        realm.beginTransaction();
        for (ReviewableWord rWord : course.getReviewableWords()) {
            rWord.setNextReview(today + (24 * 60 * 60 * 1000) * ((days++) % course.getNumNewWordPerDay()));
        }
        realm.commitTransaction();
    }

    private List<ReviewableWord> getTodayWords(Context context) {
        List<ReviewableWord> todayWords = new ArrayList<>();
        long today = new Date().getTime();
        int numWords = 0;
        for (Course course : getAllCourse(context)) {
            for (ReviewableWord rWord : course.getReviewableWords()) {
                if (numWords++ > MAX_WORD_EACH_TIME) {
                    return todayWords;
                }
                if (today > rWord.getNextReview() || rWord.getNextReview() - today < 24 * 60 * 60 * 1000) {
                    todayWords.add(rWord);
                }

            }
            if (course.getCourseType().equals(CUSTOM_COURSE)) {
                for (ReviewableWord rWord : course.getNeedMoreReview()) {
                    if (numWords++ > MAX_WORD_EACH_TIME) {
                        return todayWords;
                    }
                    todayWords.add(rWord);
                }
            }
        }
        return todayWords;
    }

    public void setWordWrongAnswer(Context context,List<ReviewableWord> words, Course course) {
        long today = new Date().getTime();
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        for (ReviewableWord rWord : words) {
            if (course.getCourseType().equals(LEITNER_COURSE)) {
                rWord.setStage(0);
                rWord.setNextReview(today + 24 * 60 * 60 * 1000);
            } else if (course.getCourseType().equals(CUSTOM_COURSE)) {
                course.getNeedMoreReview().add(rWord);
            }
        }
        realm.commitTransaction();

    }

    public void setWordCorrectAnswer(Context context,List<ReviewableWord> words,Course course) {
        long today = new Date().getTime();
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        for ( ReviewableWord rWord : words) {
            if(course.getCourseType().equals(LEITNER_COURSE)) {
                rWord.setNextReview((int) (Math.pow(2, rWord.getStage())) * 24 * 60 * 60 * 1000);
            }else if(course.getCourseType().equals(CUSTOM_COURSE)) {
                if (today > rWord.getNextReview() || rWord.getNextReview() - today < 24 * 60 * 60 * 1000){
                    rWord.setNextReview((rWord.getStage() + 1) * 24 * 60 * 60 * 1000);
                }else{
                    course.getNeedMoreReview().remove(course.getNeedMoreReview().indexOf(rWord));
                }
            }
            rWord.setStage(rWord.getStage() + 1);
        }
        realm.commitTransaction();
    }

    public int CalculateNewWordPerDay(int numWords, int numDays) {
        if (numWords / (numDays - 15) <= MAX_NEW_WORD_PER_DAY) {
            return numWords / (numDays - 15);
        } else if (numWords / (numDays - 6) <= MAX_NEW_WORD_PER_DAY) {
            return numWords / (numDays - 6);
        }
        return -1;
    }

    @Override
    public List<Course> Load() {
        return null;
    }

    @Override
    public void Store() {

    }


}
