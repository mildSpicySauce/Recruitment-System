package Business.WorkQueue;

public enum RequestStatus {

    Processing("Processing"),
    Ready("Ready"),
    Cancelled("Cancelled"),
    Completed("Completed");

    private String value;

    private RequestStatus(String value) {
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
