package Business.Account;

import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 15:06
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public abstract class Account {
    private int id;
    private String username;
    private String password;
    private Role role;
    private WorkQueue workQ;
    private static int counter = 0;

    public Account(String username, String password, Role role) {
        this.id = counter;
        counter++;
        this.username = username;
        this.password = password;
        this.role = role;
        this.workQ = new WorkQueue();
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WorkQueue getWorkQueue() {
        return this.workQ;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
