package Business.Enterprise;

import Business.Account.Account;
import Business.Employee.Employee;
import Business.Exam.ExamConfig;
import Business.Job.FullTimeJob;
import Business.Job.InternshipJob;
import Business.Job.Job;
import Business.Job.JobType;
import Business.Organization.Organization;
import Business.Organization.OrganizationDir;
import Business.Question.QuestionBank;
import Business.Role.Role;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 15:06
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public abstract class Enterprise extends Organization{

    private OrganizationDir organizations;
    private static int idCounter = 0;
    private String phone;
    private String address;
    private String description;
    private ArrayList<InternshipJob> hireInternJobs;
    private ArrayList<FullTimeJob> hireFullTimeJobs;
    private ArrayList<Employee> employees;
    private ArrayList<ExamConfig> examConfigs; 
    private QuestionBank bank;
    private String photoPath;
    
    
    public Enterprise(String name) {
        super(name);
        photoPath = "";
        phone = "";
        address = "";
        description = "";
        this.organizations = new OrganizationDir();
        hireInternJobs = new ArrayList<>();
        hireFullTimeJobs = new ArrayList<>();
        employees = new ArrayList<>();
        bank = new QuestionBank();
        examConfigs = new ArrayList<> ();
    }

    public OrganizationDir getOrganizationDirectory() {
        return organizations;
    }
    
    public void addEmployee (Employee employee) {
        employees.add(employee);
    }
    
    public void addInterns (InternshipJob job) {
        hireInternJobs.add(job);
    }
    
    public void addFullTimes (FullTimeJob job) {
        hireFullTimeJobs.add (job);
    }

    public ArrayList<InternshipJob> getHireInternJobs() {
        return hireInternJobs;
    }

    public ArrayList<FullTimeJob> getHireFullTimeJobs() {
        return hireFullTimeJobs;
    }
    
    public QuestionBank getQuestionBank() {
        return this.bank;
    }
    
    public void clearQuestionBank() {
        this.bank = new QuestionBank();
    }

    public ArrayList<ExamConfig> getExamConfigs() {
        return examConfigs;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionBank getBank() {
        return bank;
    }

    public void setBank(QuestionBank bank) {
        this.bank = bank;
    }
    
    public abstract String getId();

    public abstract void setId(String id);

    public abstract void createOrganizations();

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
