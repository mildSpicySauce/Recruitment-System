package Business.Network;

import Business.Enterprise.BankEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDir;
import Business.Enterprise.ExamEnterprise.ExamEnterprise;
import Business.Enterprise.ITEnterprise;
import Business.Job.JobType;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 15:06
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class Network {
    private String id;
    private EnterpriseDir enterpriseDir;
    private String state;

    private static int counter = 0;

    public Network(String state) {
        enterpriseDir = new EnterpriseDir();
        this.state = state;
        this.id = "Network" + counter;
        counter++;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnterpriseDir getEnterpriseDirectory() {
        return enterpriseDir;
    }        
    
    public ArrayList<Enterprise> getFullTimeEnterprise () {
        ArrayList<Enterprise> result = new ArrayList<>();
        for (Enterprise en : this.enterpriseDir.getEnterpriseList()) {
            if (!en.getHireFullTimeJobs().isEmpty()) {
                result.add (en);
            } 
        }
        return result;
    }
    
    public ArrayList<Enterprise> getInterEnterprise () {
        ArrayList<Enterprise> result = new ArrayList<>();
        for (Enterprise en : this.enterpriseDir.getEnterpriseList()) {
            if (!en.getHireInternJobs().isEmpty()) {
                result.add (en);
            } 
        }
        return result;
    }
    
    public ArrayList<ITEnterprise> getITEnterpriseList() {
        ArrayList<ITEnterprise> ITs = new ArrayList<>();
        for (Enterprise en : this.enterpriseDir.getEnterpriseList()) {
            if (en instanceof ITEnterprise) {
                ITEnterprise it = (ITEnterprise) en;
                ITs.add(it);                
            }
        }
        return ITs;
    }
    
    public ArrayList<BankEnterprise> getBankEnterpriseList() {
        ArrayList<BankEnterprise> banks = new ArrayList<>();
        for (Enterprise en : this.enterpriseDir.getEnterpriseList()) {
            if (en instanceof BankEnterprise) {
                BankEnterprise bank = (BankEnterprise) en;
                banks.add (bank);
            }
        }
        return banks;
    }
    
    public ArrayList<ExamEnterprise> getExamEnterpriseList() {
        ArrayList<ExamEnterprise> exams = new ArrayList<>();
        for (Enterprise en : this.enterpriseDir.getEnterpriseList()) {
            if (en instanceof ExamEnterprise) {
                ExamEnterprise exam = (ExamEnterprise) en;
                exams.add(exam);
            }
        }
        return exams;
    }

    public void setstate(String state) {
        this.state = state;
    }

    public String getstate() {
        return this.state;
    }
    
    public ITEnterprise createITEnterprise (String name) {
        ITEnterprise it = new ITEnterprise(name);
        it.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(it);
        return it;
    }

    public BankEnterprise createBankEnterprise (String name) {
        BankEnterprise bank = new BankEnterprise(name);
        bank.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(bank);
        return bank;    
    }
    
    public ExamEnterprise createExamEnterprise (String name) {
        ExamEnterprise exam = new ExamEnterprise(name);
        exam.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(exam);
        return exam;
    }

    public boolean isEnterpriseAvabliable(Enterprise en) {
        for(Enterprise e: this.enterpriseDir.getEnterpriseList()){
            if(e.getName().equals(en.getName())){
                return false;
            }
        }
        return true;
    }

    
    
}
