package Business.Employee;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 16:00
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class EmployeeDir {
    private ArrayList<Employee> employeeList;

    public EmployeeDir() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public boolean isEmployeeExist(Employee emp) {
        if (!this.employeeList.isEmpty()) {
            for (Employee em : this.employeeList) {
                if (em.getId() == emp.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Employee createEmployee(String firstName, String lastName, String phone, String email) {
        Employee employee = new Employee(firstName, lastName, phone, email);
        employeeList.add(employee);
        return employee;
    }

}
