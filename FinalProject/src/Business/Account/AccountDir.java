package Business.Account;

import Business.Applicant.Applicant;
import Business.Employee.Employee;
import Business.Role.Role;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 15:28
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class AccountDir {
    private ArrayList<Account> AccountList;

    public AccountDir() {
        this.AccountList = new ArrayList<>();
    }

    public ArrayList<Account> getAccountList() {
        return this.AccountList;
    }

    public Account authenticateUser(String username, String password) {
        Account account = null;
        for (Account ua : AccountList) {
            if (ua.getUsername().equalsIgnoreCase(username) && ua.getPassword().equals(password)) {
                account = ua;
            }
        }
        return account;
    }

    public boolean isUsernameValid(String username) {
        if (AccountList.isEmpty()) {
            return true;
        }
        for (Account ua : AccountList) {
            if (ua.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }
        return true;
    }

    public EmployeeAccount createEmployeeAccount(String username, String password, Role role, Employee em) {
        EmployeeAccount ua = new EmployeeAccount(username, password, role, em);
        AccountList.add(ua);
        return ua;
    }
    
    public ApplicantAccount createApplicantAccount(String username, String passwordString, Applicant applicant) {
        ApplicantAccount aa = new ApplicantAccount(username, passwordString, applicant);
        AccountList.add (aa);
        return aa;
    }
    
    public void addAccount(Account account) {
        AccountList.add(account);
    }

    public Account searchAccountByUsername (String username) {
        if (!AccountList.isEmpty()) {
            for (Account u : AccountList) {
                if (u.getUsername().equals(username)) {
                    return u;
                }
            }
        }
        return null;
    }

    public boolean removeAccount(Account account) {
        return AccountList.remove(account);
    }

}
