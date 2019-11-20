package Business.Job;

/**
 * @author Renzi Meng
 * @date 2019-4-12 19:44:39
 */
public enum JobType {
    FullTime ("Full-time Job"),
    Intership ("Intership Job");
    
    private String value;
    
    private JobType (String value) {
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