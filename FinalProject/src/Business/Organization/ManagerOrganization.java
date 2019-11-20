package Business.Organization;

import Business.Role.ManagerRole;
import Business.Role.Role;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 16:24
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class ManagerOrganization extends Organization {
    public ManagerOrganization() {
        super(OrganizationType.Manager.getValue());
    }
//        super(Organization.getType().Manager.getValue());

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ManagerRole());
        return roles;
    }
}
