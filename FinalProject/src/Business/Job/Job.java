package Business.Job;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import java.util.Objects;

/**
 * @author Renzi Meng
 * @date 2019-4-12 19:38:51
 */
public abstract class Job {
    private String name;
    private String requirement;
    private String category;
    private String workPlace;
    private String salary;
    private Employee issuer;
    private Enterprise enterprise;

    public Job(String name, String requirement, Employee issuer, Enterprise enterprise) {
        this.name = name;
        this.requirement = requirement;
        this.issuer = issuer;
        this.enterprise = enterprise;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setIssuer(Employee issuer) {
        this.issuer = issuer;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }
    
    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    public String getRequirement() {
        return requirement;
    }
    
    public String getCategory() {
        return category;
    }
    
    public String getWorkPlace() {
        return workPlace;
    }

    public Employee getIssuer() {
        return issuer;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Job other = (Job) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.enterprise, other.enterprise)) {
            return false;
        }
        return true;
    }
    
}