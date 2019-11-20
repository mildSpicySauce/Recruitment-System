package Business.Resume;

/**
 * @author Renzi Meng
 * @date 2019-4-18 19:41:37
 */
public class EducationResume {
    String school;
    String degree;
    String GPA;

    public EducationResume(String school, String degree, String GPA) {
        this.school = school;
        this.degree = degree;
        this.GPA = GPA;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getGPA() {
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }
    
    
    
}