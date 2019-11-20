package Business.Job;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;

/**
 * @author Renzi Meng
 * @date 2019-4-12 19:39:38
 */
public class FullTimeJob extends Job{

    public FullTimeJob(String name, String requirement, Employee issuer, Enterprise enterprise) {
        super(name, requirement, issuer, enterprise);
    }
}