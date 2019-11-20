package Business.Role;

import Business.Account.Account;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import UserInterface.SystemAdmin.SystemAdminMainJPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 20:02
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class SystemManagerRole extends Role{
    public SystemManagerRole() {
        super(RoleType.SystemManager);
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, Account Account, Network net, Enterprise en, JFrame frame) {
        SystemAdminMainJPanel sa = new SystemAdminMainJPanel(system, container, Account, frame);
        container.add(sa);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
        
    }

    @Override
    public String toString() {
        return RoleType.SystemManager.getValue();
    }
}
