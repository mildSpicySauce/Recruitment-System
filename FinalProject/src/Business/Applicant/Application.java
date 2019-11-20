package Business.Applicant;

import Business.Applicant.Applicant;
import Business.Job.Job;
import java.util.Date;

/**
 * @author Renzi Meng
 * @date 2019-4-14 22:39:34
 */
public class Application {
    private Job job;
    private Date date;
    private Applicant applicant;

    public Application(Job job, Applicant applicant) {
        this.job = job;
        this.date = new Date();
        this.applicant = applicant;
    }

    public Job getJob() {
        return job;
    }

    public Date getDate() {
        return date;
    }

    public Applicant getApplicant() {
        return applicant;
    }
    
    @Override
    public String toString() {
        return job.getName();
    }
    
}