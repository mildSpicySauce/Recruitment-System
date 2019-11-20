package Business.Organization;

import Business.Account.AccountDir;
import Business.Employee.EmployeeDir;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 15:53
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public abstract class Organization {

    private int organizationId;
    private String name;
    private WorkQueue workQ;
    private EmployeeDir employees;
    private AccountDir accounts;
    private static int counter;

    public Organization(String name) {
        counter++;
        this.organizationId = counter;
        this.name = name;
        this.workQ = new WorkQueue();
        this.employees = new EmployeeDir();
        this.accounts = new AccountDir();
    }

    public abstract ArrayList<Role> getSupportedRole();

    public int getOrganizationId() {
        return organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQ() {
        return workQ;
    }

    public EmployeeDir getEmployees() {
        return employees;
    }

    public AccountDir getAccountDir() {
        return accounts;
    }

    public static int getCounter() {
        return counter;
    }


}
