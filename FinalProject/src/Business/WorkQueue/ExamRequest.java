package Business.WorkQueue;

import Business.Account.ApplicantAccount;
import Business.Enterprise.Enterprise;
import Business.Exam.ExamConfig;

/**
 * @author Renzi Meng
 * @date 2019-4-17 14:55:38
 */
public class ExamRequest extends WorkRequest{
    ExamStatus examStatus;
    int score;
    

    public ExamRequest(Enterprise enterprise, ApplicantAccount account) {
        super(enterprise, account);
        score = -1;
        examStatus = examStatus.Ready;
    }

    public ExamStatus getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(ExamStatus examStatus) {
        this.examStatus = examStatus;
    }
    
    public void setScore (int score) {
        this.score = score;
    }
    
    public int getScore () {
        return score;
    }
    
    
    
}