package Business.Job;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;

/**
 * @author Renzi Meng
 * @date 2019-4-12 19:39:26
 */
public class InternshipJob extends Job{

    private Boolean isReturn;
    private int internshipTime;

    public InternshipJob(String name, String requirement, Employee issuer, Enterprise enterprise) {
        super(name, requirement, issuer, enterprise);
    }
    
    public Boolean isReturn() {
        return isReturn;
    }

    public void setReturn(Boolean isReturn) {
        this.isReturn = isReturn;
    }

    public int getInternshipTime() {
        return internshipTime;
    }

    public void setInternshipTime(int internshipTime) {
        this.internshipTime = internshipTime;
    }
    
}