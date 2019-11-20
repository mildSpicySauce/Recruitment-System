package Business.Enterprise.ExamEnterprise;

import Business.Enterprise.Enterprise;
import Business.Organization.HirerOrganization;
import Business.Organization.ManagerOrganization;

/**
 * @author Renzi Meng
 * @date 2019-4-20 13:35:31
 */
public class ExamEnterprise extends Enterprise{

    private String id;    
    private String description;
    private String address;
    private String phone;
     private static int counter = 0;
   
    public ExamEnterprise(String name) {
        super(name);
        this.id = ("Exam Enterprise" + counter++);
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void createOrganizations() {
        this.getOrganizationDirectory().getOrganizationList().add (new ManagerOrganization());
    }
}