package Business.Organization;

import Business.Role.ApplicantRole;
import Business.Role.Role;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 20:12
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class ExamineeOrganization extends Organization {
    public ExamineeOrganization(String name) {
        super(name);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add (new ApplicantRole());
        return roles;
    }
}
