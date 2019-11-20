package Business.Enterprise;

public enum EnterpriseType {
    IT("IT"),
    Bank("Bank");

    private String value;

    EnterpriseType(String value) {
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
