package Business.Role;

import Business.Account.Account;
import Business.Account.ApplicantAccount;
import Business.Account.EmployeeAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import UserInterface.Applicant.ApplicantMainJPanel;
import UserInterface.Manager.NewManagerMainJPanel;
import java.awt.CardLayout;

import javax.swing.*;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 20:06
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class HRRole extends Role {
    public HRRole() {
        super(RoleType.HR);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, Account account, Network net, Enterprise en, JFrame frame) {
        NewManagerMainJPanel cp = new NewManagerMainJPanel(system, net, container, en, (EmployeeAccount) account, frame, this);
        container.add(cp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }
}
