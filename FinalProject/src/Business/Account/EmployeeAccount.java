package Business.Account;

import Business.Employee.Employee;
import Business.Role.Role;

/**
 * @author Renzi Meng
 * @date 2019-4-12 15:26:56
 */
public class EmployeeAccount extends Account{

    Employee employee;

    public EmployeeAccount(String username, String password, Role role, Employee em) {
        super (username, password, role);
        this.employee = em;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    public void setEmployee(Employee em) {
        this.employee = em;
    }

    @Override
    public String toString() {
        return employee.getFirstName() + " " + employee.getLastName();
    }
}