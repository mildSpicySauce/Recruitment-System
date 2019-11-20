package Business.WorkQueue;

/**
 * @author Renzi Meng
 * @date 2019-4-16 15:06:46
 */
public enum ExamStatus {
    Ready ("Ready"),
    ExamAccepted("Applicant accepted exam."),
    Testing ("Testing"),
    Finished ("Finished");
    
    private String value;
    
    private ExamStatus (String value) {
        this.value = value;
    }
    
    public String getValue () {
        return value;
    }

    
    
    
    
    @Override
    public String toString() {
        return value;
    }
}