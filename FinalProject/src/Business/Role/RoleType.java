package Business.Role;

import Business.Organization.OrganizationType;

public enum RoleType {
    Manager("Manager"),
    HR("Human Resources Manager"),
    Applicant("Applicant"),
    SystemManager("System Manager");

    private String value;
    private RoleType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
