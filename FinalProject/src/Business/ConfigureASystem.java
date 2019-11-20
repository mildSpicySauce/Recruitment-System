package Business;

import Business.Account.Account;
import Business.Account.ApplicantAccount;
import Business.Account.EmployeeAccount;
import Business.Applicant.Applicant;
import Business.Employee.Employee;
import Business.Enterprise.BankEnterprise;
import Business.Enterprise.ExamEnterprise.ExamEnterprise;
import Business.Enterprise.ITEnterprise;
import Business.Job.FullTimeJob;
import Business.Job.InternshipJob;
import Business.Network.Network;
import Business.Resume.EducationResume;
import Business.Resume.ProjectExperienceResume;
import Business.Resume.Resume;
import Business.Resume.SkillsResume;
import Business.Role.HRRole;
import Business.Role.ManagerRole;
import Business.Role.SystemManagerRole;

/**
 * @Description:
 * @Author: RenziMeng
 * @Date: 2019/4/7 14:42
 * @Copyright (C):, 2019, RenziMeng, All Rights Reserved.
 */
public class ConfigureASystem {

    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();

        Network networkMa = system.createNetwork("Massachusetts");
        networkMa.setId("MA");
        Network networkCa = system.createNetwork("California");
        networkCa.setId("CA");
        
        //MA Network
        // IT Company
        ITEnterprise google = networkMa.createITEnterprise("Google");
        Employee hrGoogle = new Employee("Turkey", "Little", "(360)233-6267", "littleturkey@qq.com");
        google.addEmployee(hrGoogle);
        EmployeeAccount hrGoogleAccount = new EmployeeAccount("googlehr", "googlehr", new HRRole(), hrGoogle);
        google.getAccountDir().getAccountList().add(hrGoogleAccount);
        FullTimeJob SDEGoogle = new FullTimeJob("Software Developer", "Java, Backend development experience", hrGoogle, google);
        google.addFullTimes(SDEGoogle);
        InternshipJob internGoogle = new InternshipJob("Intern", "using C++", hrGoogle, google);
        google.addInterns(internGoogle);
        Employee managerGoogle = new Employee("Turkey", "Large", "(508)932-7868", "largeturkey@qq.com");
        google.addEmployee(managerGoogle);
        EmployeeAccount managerGoogleAccount = new EmployeeAccount("googlemanager", "googlemanager", new ManagerRole(), managerGoogle);
        google.getAccountDir().getAccountList().add(managerGoogleAccount);
        google.setPhotoPath("images/google.jpg");

        // Bank Company
        BankEnterprise boa = networkMa.createBankEnterprise("BankOfAmerica");
        Employee hrBoa = new Employee("Monkey", "Little", "(516)954-1770", "littlemonkey@qq.com");
        boa.addEmployee(hrBoa);
        EmployeeAccount hrBoaAccount = new EmployeeAccount("boahr", "boahr", new HRRole(), hrBoa);
        boa.getAccountDir().getAccountList().add(hrBoaAccount);
        Employee managerBoa = new Employee("Monkey", "Large", "(573)326-1556", "largemonkey@qq.com");
        boa.addEmployee(managerBoa);
        EmployeeAccount managerBoaAccount = new EmployeeAccount("boamanager", "boamanager", new ManagerRole(), managerBoa);
        boa.getAccountDir().getAccountList().add(managerBoaAccount);
        FullTimeJob TestBoa = new FullTimeJob("Test", "Java, Test Soft Engineer", hrBoa, boa);
        boa.addFullTimes(TestBoa);
        InternshipJob internBoa = new InternshipJob("Intern", "using Oracle", hrBoa, boa);
        boa.addInterns(internBoa);
        boa.setPhotoPath("images/boa.png");

        // Exam Enterprise
        ExamEnterprise examCenter = networkMa.createExamEnterprise("Fenway Exam Enterprise");
        Employee manEmployee = new Employee("Elk", "Large", "(213)705-9425", "largeelk@qq.com");
        examCenter.addEmployee(manEmployee);
        EmployeeAccount manAccount = new EmployeeAccount("3", "3", new ManagerRole(), manEmployee);
        examCenter.getAccountDir().getAccountList().add(manAccount);

        ExamEnterprise examCenter2 = networkMa.createExamEnterprise("Malden Test Corporation");
        Employee manEmployee2 = new Employee("Fox", "Large", "(412)512-8293", "largefox@qq.com");
        examCenter2.addEmployee(manEmployee2);
        EmployeeAccount manAccount2 = new EmployeeAccount("4", "4", new ManagerRole(), manEmployee);
        examCenter2.getAccountDir().getAccountList().add(manAccount2);

        
        //CA Network
        // IT Company
        ITEnterprise amazon = networkCa.createITEnterprise("Amazon");
        Employee hrAmazon = new Employee("Shellfish", "Little", "(360)233-6267", "littleshellfish@qq.com");
        amazon.addEmployee(hrAmazon);
        EmployeeAccount hrAmazonAccount = new EmployeeAccount("amazonhr", "amazonhr", new HRRole(), hrAmazon);
        amazon.getAccountDir().getAccountList().add(hrAmazonAccount);
        FullTimeJob MLEAmazon = new FullTimeJob("Machine Learning Engineer", "Python, Backend development experience", hrAmazon, amazon);
        amazon.addFullTimes(MLEAmazon);
        InternshipJob internAmazon = new InternshipJob("Intern", "using C++", hrAmazon, amazon);
        amazon.addInterns(internAmazon);
        Employee managerAmazon = new Employee("Shellfish", "Large", "(508)932-7868", "largeshellfish@qq.com");
        amazon.addEmployee(managerAmazon);
        EmployeeAccount managerAmazonAccount = new EmployeeAccount("amazonmanager", "amazonmanager", new ManagerRole(), managerAmazon);
        amazon.getAccountDir().getAccountList().add(managerAmazonAccount);
        amazon.setPhotoPath("images/amazon.jpg");

        // Bank Company
        BankEnterprise citi = networkCa.createBankEnterprise("CitiBank");
        Employee hrCiti = new Employee("Seal", "Little", "(516)954-1770", "littleseal@qq.com");
        citi.addEmployee(hrCiti);
        EmployeeAccount hrCitiAccount = new EmployeeAccount("citihr", "citihr", new HRRole(), hrCiti);
        citi.getAccountDir().getAccountList().add(hrCitiAccount);
        Employee managerCiti = new Employee("Seal", "Large", "(573)326-1556", "largeseal@qq.com");
        citi.addEmployee(managerCiti);
        EmployeeAccount managerCitiAccount = new EmployeeAccount("citimanager", "citimanager", new ManagerRole(), managerCiti);
        citi.getAccountDir().getAccountList().add(managerCitiAccount);
        FullTimeJob TestCiti = new FullTimeJob("Test", "Java, Test Soft Engineer", hrCiti, citi);
        citi.addFullTimes(TestCiti);
        InternshipJob internCiti = new InternshipJob("Intern", "using MySql", hrCiti, citi);
        citi.addInterns(internCiti);
        citi.setPhotoPath("images/citi.png");
        
        // Exam Enterprise
        ExamEnterprise examCenter3 = networkCa.createExamEnterprise("LA Exam Enterprise");
        Employee manEmployee3 = new Employee("Crab", "Large", "(213)705-9425", "largecrab@qq.com");
        examCenter3.addEmployee(manEmployee3);
        EmployeeAccount manAccount3 = new EmployeeAccount("5", "5", new ManagerRole(), manEmployee3);
        examCenter3.getAccountDir().getAccountList().add(manAccount3);

        ExamEnterprise examCenter4 = networkCa.createExamEnterprise("SF Test Corporation");
        Employee manEmployee4 = new Employee("Lobster", "Large", "(412)512-8293", "largelobster@qq.com");
        examCenter4.addEmployee(manEmployee4);
        EmployeeAccount manAccount4 = new EmployeeAccount("6", "6", new ManagerRole(), manEmployee4);
        examCenter4.getAccountDir().getAccountList().add(manAccount4);
        
        
        //Applicant
        //applicant1
        Applicant applicant = new Applicant("Ribbit", "Little", "littlerabbit@qq.com", "(716)298-9497");
        ApplicantAccount account = new ApplicantAccount("1", "1", applicant);
        EducationResume educationResume = new EducationResume("NEU", "BS", "4.0");
        ProjectExperienceResume project = new ProjectExperienceResume("Yelp", "product manager", "design ui and follow projects");
        SkillsResume skillsResume = new SkillsResume("java", "good at programming");
        Resume resume = new Resume(project, educationResume, skillsResume);
        applicant.createResume(resume);
        system.getAccountDir().addAccount(account);

        //applicant2
        Applicant applicant2 = new Applicant("Lamb", "Little", "littlelamb@qq.com", "(802)380-1059");
        ApplicantAccount account2 = new ApplicantAccount("2", "2", applicant2);
        EducationResume educationResume2 = new EducationResume("BU", "Ms", "3.6");
        ProjectExperienceResume project2 = new ProjectExperienceResume("Chase Bank", "test engineer", "do database tests");
        SkillsResume skillsResume2 = new SkillsResume("sql", "know database");
        Resume resume2 = new Resume(project2, educationResume2, skillsResume2);
        applicant2.createResume(resume2);
        system.getAccountDir().addAccount(account2);
        
        //System Administrator
        Employee sysadmin = system.getEmployees().createEmployee("Tiger", "Large", "(402)952-6040", "sysadmin@qq.com");
        Account ua1 = system.getAccountDir().createEmployeeAccount("sysadmin", "sysadmin", new SystemManagerRole(), sysadmin);
        
        
        return system;
    }
    /*

    public static EcoSystem configure() {
        return new EcoSystem();
    }
     */
}
