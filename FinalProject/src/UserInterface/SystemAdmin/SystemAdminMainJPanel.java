/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdmin;

import Business.Account.Account;
import Business.Account.EmployeeAccount;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import UserInterface.Applicant.ExamListJPanel;
import UserInterface.LoginJFrame;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jxw
 */
public class SystemAdminMainJPanel extends javax.swing.JPanel {
    private EcoSystem system;
    private JPanel container;
    private EmployeeAccount employeeAccount;
    private JFrame frame;
    private Employee employee;

    /**
     * Creates new form SystemAdminMainJPanel
     */
    public SystemAdminMainJPanel() {
        initComponents();
        this.setLayout(null);
        nameLabel.setText(employee.getFirstName()+" "+employee.getLastName());
    }

    public SystemAdminMainJPanel(EcoSystem system, JPanel container, Account Account, JFrame frame) {
        initComponents();
        this.system = system;
        this.container = container;
        this.employeeAccount = (EmployeeAccount)Account;
        this.frame = frame;
        
        this.employee = employeeAccount.getEmployee();
        
        nameLabel.setText(Account.getUsername());
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        leftPanel = new javax.swing.JPanel();
        closeLb = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        networkLbl = new javax.swing.JLabel();
        applicantsLbl = new javax.swing.JLabel();
        profileLbl = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        leftPanel.setBackground(new java.awt.Color(54, 33, 89));

        closeLb.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        closeLb.setForeground(new java.awt.Color(255, 255, 255));
        closeLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Close_Window_64px.png"))); // NOI18N
        closeLb.setText("Log out");
        closeLb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLbMouseClicked(evt);
            }
        });

        passwordLbl.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        passwordLbl.setForeground(new java.awt.Color(255, 255, 255));
        passwordLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Graduation_Cap_64px.png"))); // NOI18N
        passwordLbl.setText("Change Password");
        passwordLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordLblMouseClicked(evt);
            }
        });

        networkLbl.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        networkLbl.setForeground(new java.awt.Color(255, 255, 255));
        networkLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Resume_64px.png"))); // NOI18N
        networkLbl.setText("Manage NetWork");
        networkLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                networkLblMouseClicked(evt);
            }
        });

        applicantsLbl.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        applicantsLbl.setForeground(new java.awt.Color(255, 255, 255));
        applicantsLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Organization_64px.png"))); // NOI18N
        applicantsLbl.setText("Manage Applicants");
        applicantsLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applicantsLblMouseClicked(evt);
            }
        });

        profileLbl.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        profileLbl.setForeground(new java.awt.Color(255, 255, 255));
        profileLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Submit_Resume_64px.png"))); // NOI18N
        profileLbl.setText("Manage Profile");
        profileLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileLblMouseClicked(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("微软雅黑", 1, 24)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("<Name>");

        jLabel2.setFont(new java.awt.Font("微软雅黑", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome, ");

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLabel))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(closeLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(networkLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profileLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(applicantsLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addComponent(networkLbl)
                .addGap(18, 18, 18)
                .addComponent(applicantsLbl)
                .addGap(18, 18, 18)
                .addComponent(profileLbl)
                .addGap(18, 18, 18)
                .addComponent(passwordLbl)
                .addGap(18, 18, 18)
                .addComponent(closeLb)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(leftPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 896, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void closeLbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLbMouseClicked
        // TODO add your handling code here:
        this.frame.dispose();
        System.out.println(system.getNetworkList().size());
        
        //        JOptionPane.showMessageDialog(null, "ksksksks");
        LoginJFrame lf = new LoginJFrame();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }//GEN-LAST:event_closeLbMouseClicked

    private void passwordLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordLblMouseClicked
        ChangePasswordJPanel cpJPanel = new ChangePasswordJPanel(system, employeeAccount);
        jSplitPane1.setRightComponent(cpJPanel);
        
        networkLbl.setForeground(Color.GRAY);
        applicantsLbl.setForeground(Color.GRAY);
        profileLbl.setForeground(Color.GRAY);
        passwordLbl.setForeground(Color.WHITE);
        closeLb.setForeground(Color.GRAY);
        
    }//GEN-LAST:event_passwordLblMouseClicked

    private void networkLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_networkLblMouseClicked
        NetworkJPanel networkJPanel = new NetworkJPanel(system, this.employeeAccount);
        jSplitPane1.setRightComponent(networkJPanel);

        networkLbl.setForeground(Color.WHITE);
        applicantsLbl.setForeground(Color.GRAY);
        profileLbl.setForeground(Color.GRAY);
        passwordLbl.setForeground(Color.GRAY);
        closeLb.setForeground(Color.GRAY);
    }//GEN-LAST:event_networkLblMouseClicked

    private void applicantsLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicantsLblMouseClicked
        ManageApplicantsJPanel manageApplicantsJPanel = new ManageApplicantsJPanel(system, this.employeeAccount);
        jSplitPane1.setRightComponent(manageApplicantsJPanel);
        
        networkLbl.setForeground(Color.GRAY);
        applicantsLbl.setForeground(Color.WHITE);
        profileLbl.setForeground(Color.GRAY);
        passwordLbl.setForeground(Color.GRAY);
        closeLb.setForeground(Color.GRAY);
    }//GEN-LAST:event_applicantsLblMouseClicked

    private void profileLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileLblMouseClicked
        ManageProfileJPanel mpJPanel = new ManageProfileJPanel(system, employeeAccount, nameLabel);
        jSplitPane1.setRightComponent(mpJPanel);
        
        networkLbl.setForeground(Color.GRAY);
        applicantsLbl.setForeground(Color.GRAY);
        profileLbl.setForeground(Color.WHITE);
        passwordLbl.setForeground(Color.GRAY);
        closeLb.setForeground(Color.GRAY);
    }//GEN-LAST:event_profileLblMouseClicked

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel applicantsLbl;
    private javax.swing.JLabel closeLb;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel networkLbl;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JLabel profileLbl;
    // End of variables declaration//GEN-END:variables

    void resetAllLists() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}