package Business.Resume;

/**
 * @author Renzi Meng
 * @date 2019-4-18 19:41:56
 */
public class ProjectExperienceResume {
    String company;
    String postion;
    String description;

    public ProjectExperienceResume(String company, String postion, String description) {
        this.company = company;
        this.postion = postion;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}