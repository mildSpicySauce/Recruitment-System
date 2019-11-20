package Business.Resume;

/**
 * @author Renzi Meng
 * @date 2019-4-18 19:44:23
 */
public class SkillsResume {
    String skill;
    String description;

    public SkillsResume(String skill, String description) {
        this.skill = skill;
        this.description = description;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}