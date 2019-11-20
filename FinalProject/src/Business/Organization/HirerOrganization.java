package Business.Organization;

import Business.Role.ManagerRole;
import Business.Role.Role;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 16:23
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class HirerOrganization extends Organization{
    public HirerOrganization() {
        super(OrganizationType.HR.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add (new ManagerRole());
        return roles;
    }
}
