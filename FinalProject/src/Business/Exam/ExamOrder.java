package Business.Exam;

import Business.WorkQueue.ExamStatus;
import Business.Account.ApplicantAccount;
import Business.Question.Question;
import java.util.ArrayList;

/**
 * @author Renzi Meng
 * @date 2019-4-16 11:05:55
 */
public class ExamOrder {
    
    public int id;
    private static int counter = 0;
    private String title;
    private ApplicantAccount account;
    private int timeLimit;
    private ArrayList<Question> questions;
    private int questionCount;
    private ExamStatus status;
    
    public ExamOrder(String title, ApplicantAccount account, int timeLimit, ArrayList<Question> questions, int count) {
        this.id = counter ++;
        this.account = account;
        this.timeLimit = timeLimit;
        this.questions = questions;
        this.questionCount = count;
        this.status = ExamStatus.Ready;
    }
    
    
    public String getTitle() {
        return title;
    }
    public ApplicantAccount getUser() {
        return account;
    }
    public int getTimeLimit() {
        return timeLimit;
    }
    public int getQuestionCount() {
        return questionCount;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
    
    public ExamStatus getStatus () {
        return status;
    }
    
    public void setStatus(ExamStatus status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return title;
    }

 
}