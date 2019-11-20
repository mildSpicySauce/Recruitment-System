package Business.Applicant;

import Business.Enterprise.Enterprise;
import Business.Exam.ExamInfo;
import Business.Exam.ExamOrderDir;
import Business.Job.Job;
import Business.Resume.Resume;
import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/10 16:52
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class Applicant {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private Resume resume;
    private static int count = 0;
    private ArrayList<Application> applications;
    private ExamOrderDir examOrderDir;
    
    public Applicant(String firstName, String lastName, String email, String phone) {
        id = count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = "";
        this.email = email;
        this.phone = phone;
        this.resume = new Resume();
        this.applications = new ArrayList<>();
        this.examOrderDir = new ExamOrderDir();
    }
    
    public void createResume (Resume resume) {
        this.resume = resume;
    }
    
    public Resume getResume () {
        return resume;
    }
    
    public void addApply (Application application) {
        if (!applications.contains(application)) applications.add(application);
    }
    
    public void deleteApply (Application application) {
        applications.remove(application);
    }
    
    public ArrayList<Application> getApplications () {
        return applications;
    }

    public int getId() {
        return id;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.getFirstName()+" "+this.getLastName();
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String addr) {
        this.address = addr;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public ExamOrderDir getExamOrderDir() {
        return examOrderDir;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
