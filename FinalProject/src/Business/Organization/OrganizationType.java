package Business.Organization;

public enum OrganizationType {

    Admin ("Admin Organization"),
    Manager ("Manager Organization"),
    Examinee("Examinee Organization"),
    HR("Hirer Organization");


    private String value;

    private OrganizationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}