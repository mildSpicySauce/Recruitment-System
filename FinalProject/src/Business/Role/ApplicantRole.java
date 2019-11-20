package Business.Role;

import Business.Account.Account;
import Business.Account.ApplicantAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import UserInterface.Applicant.ApplicantMainJPanel;
import java.awt.CardLayout;

import javax.swing.*;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 20:01
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class ApplicantRole extends Role {

    public ApplicantRole() {
        super(RoleType.Applicant);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, Account account, Network net, Enterprise en, JFrame frame) {
        ApplicantMainJPanel cp = new ApplicantMainJPanel(system, container, frame, (ApplicantAccount) account);
        container.add(cp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }
}
