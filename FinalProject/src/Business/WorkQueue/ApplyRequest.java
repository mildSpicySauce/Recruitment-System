package Business.WorkQueue;

import Business.Account.ApplicantAccount;
import Business.Enterprise.Enterprise;
import Business.Job.Job;
import Business.Resume.Resume;

/**
 * @author Renzi Meng
 * @date 2019-4-17 14:54:23
 */
public class ApplyRequest extends WorkRequest{
    
    private ApplicationStatus applicationstatus;
    private Job job;
    private Resume resume;
    private ExamRequest examRequest;

    public ApplyRequest(Enterprise enterprise, ApplicantAccount account, Job job) {
        super(enterprise, account);
        applicationstatus = ApplicationStatus.Pending;
        this.job = job;
        resume = account.getApplicant().getResume();
    }

    public ApplicationStatus getApplystatus() {
        return applicationstatus;
    }
    
    public void createExamRequest(ExamRequest request) {
        this.examRequest = request;
        this.applicationstatus = ApplicationStatus.WaitExam;
    }
    
    public ApplicationStatus getApplicationstatus() {
        return applicationstatus;
    }

    public void setApplicationstatus(ApplicationStatus applicationstatus) {
        this.applicationstatus = applicationstatus;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public ExamRequest getExamRequest() {
        return examRequest;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    
    
    
    @Override
    public String toString() {
        return job.getName();
    }
    
}