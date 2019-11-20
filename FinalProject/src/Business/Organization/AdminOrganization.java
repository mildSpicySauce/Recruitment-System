package Business.Organization;

import Business.Role.Role;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 20:16
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class AdminOrganization extends Organization {
    public AdminOrganization(String name) {
        super(name);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
