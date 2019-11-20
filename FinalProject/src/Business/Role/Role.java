package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Account.Account;

import javax.swing.*;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 14:49
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public abstract class Role {
    private RoleType type;

    public Role(RoleType type) {
        this.type = type;
    }

    public RoleType getRoleType() {
        return this.type;
    }

    @Override
    public abstract String toString();

    public abstract void createWorkArea(EcoSystem system, JPanel container, Account account, Network net, Enterprise en, JFrame frame);
}
