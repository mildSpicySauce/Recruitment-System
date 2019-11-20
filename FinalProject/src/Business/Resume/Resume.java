package Business.Resume;

/**
 * @author Renzi Meng
 * @date 2019-4-18 19:40:56
 */
public class Resume {
    ProjectExperienceResume projectExperienceResume;
    EducationResume educationResume;
    SkillsResume skillsResume;

    public Resume(ProjectExperienceResume projectExperienceResume, EducationResume educationResume, SkillsResume skillsResume) {
        this.projectExperienceResume = projectExperienceResume;
        this.educationResume = educationResume;
        this.skillsResume = skillsResume;
    }

    public Resume() {
        projectExperienceResume = new ProjectExperienceResume("", "", "");
        educationResume = new EducationResume("", "", "");
        skillsResume = new SkillsResume("", "");
    }


    public ProjectExperienceResume getProjectExperienceResume() {
        return projectExperienceResume;
    }

    public void setProjectExperienceResume(ProjectExperienceResume projectExperienceResume) {
        this.projectExperienceResume = projectExperienceResume;
    }

    public EducationResume getEducationResume() {
        return educationResume;
    }

    public void setEducationResume(EducationResume educationResume) {
        this.educationResume = educationResume;
    }

    public SkillsResume getSkillsResume() {
        return skillsResume;
    }

    public void setSkillsResume(SkillsResume skillsResume) {
        this.skillsResume = skillsResume;
    }
    
}