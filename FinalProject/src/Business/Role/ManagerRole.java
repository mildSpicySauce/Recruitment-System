package Business.Role;

import Business.Account.Account;
import Business.Account.EmployeeAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import UserInterface.Manager.NewManagerMainJPanel;
import java.awt.CardLayout;

import javax.swing.*;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 19:56
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class ManagerRole extends Role {
    public ManagerRole() {
        super(RoleType.Manager);
    }

    @Override
    public String toString() {
        return RoleType.Manager.getValue();
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, Account account, Network net, Enterprise en, JFrame frame) {
        NewManagerMainJPanel cp = new NewManagerMainJPanel(system, net, container, en, (EmployeeAccount) account, frame, this);
        container.add(cp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }
}
