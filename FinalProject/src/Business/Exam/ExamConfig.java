package Business.Exam;

import Business.Account.ApplicantAccount;
import Business.Applicant.Applicant;
import Business.Question.Question;
import java.util.HashMap;
import java.util.List;

/**
 * @author Renzi Meng
 * @date 2019-4-16 10:34:13
 */
public class ExamConfig {
    
    private int id;
    private static int counter = 0;
    
    private String title;
    private int timeLimit;
    private int questionCount;
    
    private HashMap<Integer, Applicant> users = new HashMap<>();
    private HashMap<Integer, List<Question>> questions = new HashMap<>();
    
    public ExamConfig() {
        id = counter ++;
    }

    public int getId() {
        return id;
    }

    public HashMap<Integer, Applicant> getUsers() {
        return users;
    }

    public void setUsers(HashMap<Integer, Applicant> users) {
        this.users = users;
    }

    public HashMap<Integer, List<Question>> getQuestions() {
        return questions;
    }

    public void setQuestions(HashMap<Integer, List<Question>> questions) {
        this.questions = questions;
    }

    public static void setCounter(int counter) {
        ExamConfig.counter = counter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}