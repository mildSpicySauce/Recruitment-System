package Business.Organization;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/9 17:13
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class OrganizationDir {
    private ArrayList<Organization> organizationList;

    public OrganizationDir() {
        this.organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return this.organizationList;
    }

    public Organization getTypicalOrganization(OrganizationType type) {
        if (type.equals(OrganizationType.Examinee)) {
            for (Organization or : this.organizationList) {
                if (or.getName().equalsIgnoreCase(OrganizationType.Examinee.getValue())) {
                    return or;
                }
            }
        }
        
        if (type.equals(OrganizationType.HR)) {
            for (Organization or : this.organizationList) {
                if (or.getName().equalsIgnoreCase(OrganizationType.HR.getValue())) {
                    return or;
                }
            }
        }
        
        if (type.equals(OrganizationType.Manager)) {
            for (Organization or : this.organizationList) {
                if (or.getName().equalsIgnoreCase(OrganizationType.Manager.getValue())) {
                    return or;
                }
            }
        }
        
        if (type.equals(OrganizationType.Admin)) {
            for (Organization or : this.organizationList) {
                if (or.getName().equalsIgnoreCase(OrganizationType.Admin.getValue())) {
                    return or;
                }
            }
        }
        return null;
    }
}
