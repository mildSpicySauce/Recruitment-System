package Business.WorkQueue;

import Business.Account.Account;
import Business.Account.ApplicantAccount;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ExamEnterprise.ExamEnterprise;
import javafx.beans.binding.ObjectExpression;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 15:29
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public abstract class WorkRequest {
    private String id;
    private String message;
    private Enterprise enterprise;
    private ApplicantAccount account;
    
    
    private Date requestDate;

    public WorkRequest (Enterprise enterprise, ApplicantAccount account) {
        this.id = genId();
        this.enterprise = enterprise;
        this.account = account;
        this.message = "";
        requestDate = new Date();
    }
    
    private String genId() {
        String orderId
                = (System.currentTimeMillis() + "").substring(1)
                + (System.nanoTime() + "").substring(7, 10);
        return orderId;
    }
    
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String mess) {
        this.message = mess;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public ApplicantAccount getAccount() {
        return account;
    }

    public void setAccount(ApplicantAccount account) {
        this.account = account;
    }

    public String getRequestDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(this.requestDate);
        return dateString;
    }

    @Override
    public String toString() {
        return this.getRequestDate();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final WorkRequest other = (WorkRequest) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
