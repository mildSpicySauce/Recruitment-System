package Business.Account;

import Business.Applicant.Applicant;
import Business.Exam.ExamOrderDir;
import Business.Role.ApplicantRole;
import java.util.ArrayList;

/**
 * @author Renzi Meng
 * @date 2019-4-12 15:26:41
 */
public class ApplicantAccount extends Account{

    private Applicant applicant;
    
    public ApplicantAccount(String username, String password, Applicant applicant) {
        super(username, password, new ApplicantRole());
        this.applicant = applicant;
    }

    public Applicant getApplicant() {
        return applicant;
    }
    
}