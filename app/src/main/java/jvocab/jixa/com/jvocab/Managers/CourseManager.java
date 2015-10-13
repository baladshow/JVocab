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

    private final static int LEITNER_COURSE = 0;
    private final static int CUSTOM_COURSE = 1;
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
                               int courseType, String name, int numNewWordPerDay,
                               int numStageRequired
    ) {
        return dbm.createCourse(context,wordList,courseType,name,numNewWordPerDay,numStageRequired);
    }

    public List<Course> getAllCourse(Context context) {
        dbm = DatabaseManager.getInstance();
        return dbm.getAllCourses(context);
    }

    public void startCourse(Course course) {
        long today = new Date().getTime();
        int days = 0;
        for (ReviewableWord rWord : course.getReviewableWords()) {
            rWord.setNextReview(today + (24 * 60 * 60 * 1000) * ((days++) % course.getNumNewWordPerDay()));
        }
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
                if (Math.abs(rWord.getNextReview() - today) < 24 * 60 * 60 * 1000) {
                    todayWords.add(rWord);
                    if (course.getCourseType() == LEITNER_COURSE)
                        rWord.setNextReview((int) (Math.pow(2, rWord.getStage())) * 24 * 60 * 60 * 1000);
                    else if (course.getCourseType() == CUSTOM_COURSE)
                        rWord.setNextReview((rWord.getStage() + 1) * 24 * 60 * 60 * 1000);
//                    rWord.setStage(rWord.getStage() + 1);
                }

            }
            if (course.getCourseType() == CUSTOM_COURSE) {
                for (int i = 0; i < course.getNeedMoreReview().size(); i++) {
                    if (numWords++ > MAX_WORD_EACH_TIME) {
                        return todayWords;
                    }
                    todayWords.add(course.getNeedMoreReview().remove(i));
                }
            }
        }
        return todayWords;
    }

    public void setWordWrongAnswer(ReviewableWord word, Course course) {
        if (course.getCourseType() == LEITNER_COURSE) {
            word.setStage(0);
        } else if (course.getCourseType() == CUSTOM_COURSE) {
            course.getNeedMoreReview().add(word);
        }

    }

    public void setWordCorrectAnswer(ReviewableWord word) {
        word.setStage(word.getStage() + 1);
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
