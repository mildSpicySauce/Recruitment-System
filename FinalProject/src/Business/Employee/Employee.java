package Business.Employee;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 16:00
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String phone;
    private String email;
    private static int count = 0;

    public Employee(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.phone = phone;
        this.email = email;
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.fullName;
    }
}
