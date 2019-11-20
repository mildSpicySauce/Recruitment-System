package Business.WorkQueue;

/**
 * @author Renzi Meng
 * @date 2019-4-16 14:44:43
 */
public enum ApplicationStatus {
    Pending("Pending"),
    Reject("Reject"),
    WaitExam("Wait Exam"),
    ExamPass("Exam passed"),
    ExamFail("Exam failed"),
    AD("AD");

    private String value;

    ApplicationStatus(String value) {
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