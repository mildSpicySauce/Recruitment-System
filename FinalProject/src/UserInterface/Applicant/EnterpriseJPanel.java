/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Applicant;

import Business.Account.Account;
import Business.Account.ApplicantAccount;
import Business.Applicant.Applicant;
import Business.EcoSystem;
import Business.Enterprise.BankEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseType;
import Business.Enterprise.ITEnterprise;
import Business.Job.FullTimeJob;
import Business.Job.InternshipJob;
import Business.Job.Job;
import Business.Job.JobType;
import Business.Network.Network;
import Business.Role.ApplicantRole;
import Business.Role.Role;
import Business.Role.RoleType;
import Business.WorkQueue.ApplyRequest;
import UserInterface.LoginJFrame;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author 11638
 */
public class EnterpriseJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private JPanel container;
    private ApplicantAccount account;
    private Network net;
    private JobType type;

    /**
     * Creates new form EnterpriseJPanel
     */
    public EnterpriseJPanel(EcoSystem system, Network net, ApplicantAccount account, JobType type, Role accessRole) {
        initComponents();
        this.system = system;
        this.net = net;
        this.account = account;
        this.type = type;
        initcomboBox();
        populateTable("All");
    }

    private void showImage(Enterprise en) {
        ImageIcon image = null;
        image = new ImageIcon(en.getPhotoPath());
        image.setImage(image.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
        imageLabel.setIcon(image);
    }

    private void populateTable(String select) {
        DefaultTableModel dtm = (DefaultTableModel) EnterpriseTable.getModel();
        dtm.setRowCount(0);

        if (select.equals("All")) {
            for (Enterprise enterprise : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (type.equals(JobType.FullTime)) {
                    for (Job job : enterprise.getHireFullTimeJobs()) {
                        Object[] row = new Object[2];
                        row[0] = job;
                        row[1] = enterprise;
                        dtm.addRow(row);
                    }
                } else if (type.equals(JobType.Intership)) {
                    for (Job job : enterprise.getHireInternJobs()) {
                        Object[] row = new Object[2];
                        row[0] = job;
                        row[1] = enterprise;
                        dtm.addRow(row);
                    }
                }
            }
        } else if (select.equals("IT")) {
            for (Enterprise enterprise : net.getITEnterpriseList()) {
                if (type.equals(JobType.FullTime)) {
                    for (Job job : enterprise.getHireFullTimeJobs()) {
                        Object[] row = new Object[2];
                        row[0] = job;
                        row[1] = enterprise;
                        dtm.addRow(row);
                    }
                } else if (type.equals(JobType.Intership)) {
                    for (Job job : enterprise.getHireInternJobs()) {
                        Object[] row = new Object[2];
                        row[0] = job;
                        row[1] = enterprise;
                        dtm.addRow(row);
                    }
                }
            }
        } else if (select.equals("Bank")) {
            for (Enterprise enterprise : net.getBankEnterpriseList()) {
                if (type.equals(JobType.FullTime)) {
                    for (Job job : enterprise.getHireFullTimeJobs()) {
                        Object[] row = new Object[2];
                        row[0] = job;
                        row[1] = enterprise;
                        dtm.addRow(row);
                    }
                } else if (type.equals(JobType.Intership)) {
                    for (Job job : enterprise.getHireInternJobs()) {
                        Object[] row = new Object[2];
                        row[0] = job;
                        row[1] = enterprise;
                        dtm.addRow(row);
                    }
                }
            }
        }

    }

    private void initcomboBox() {
        int len = EnterpriseType.values().length;
        int i = 1;
        String[] cbStrings = new String[len + 1];
        cbStrings[0] = "All";

        for (EnterpriseType type : EnterpriseType.values()) {
            cbStrings[i++] = String.valueOf(type);
        }

        categoryCB.setModel(new javax.swing.DefaultComboBoxModel(cbStrings));
    }

    private void setLB(Job job, Enterprise en) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><HTML><body> Job:" + job.getName() + "<br>");
        sb.append("<br>" + "Category: " + job.getCategory() + "<br>");
        sb.append("<br>" + "Wage: " + job.getSalary() + "<br>");
        sb.append("<br>" + "Work Place: " + job.getWorkPlace() + "<br>");
        if (job instanceof InternshipJob) {
            sb.append("<br>" + "Return Offer: " + ((InternshipJob) job).isReturn() + "<br>");
        }
        sb.append("<br>" + "Requirement: " + job.getRequirement() + "<br>");
        jobInfoTF.setText(sb.toString());

        sb = new StringBuilder();
        sb.append("<html><HTML><body>" + "Company: " + en.getName() + "<br>");
        sb.append("<br>" + "Industry: ");
        if (en instanceof ITEnterprise) {
            sb.append("IT" + "<br>" + "</body></html>");
        } else if (en instanceof BankEnterprise) {
            sb.append("Bank" + "<br>" + "</body></html>");
        }
        companyTF.setText(sb.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDoctor = new javax.swing.JLabel();
        jobInfoTF = new javax.swing.JLabel();
        companyTF = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        applyBtn = new java.awt.Button();
        jScrollPane3 = new javax.swing.JScrollPane();
        EnterpriseTable = new javax.swing.JTable();
        lbPatient = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        categoryCB = new javax.swing.JComboBox();
        imageLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbDoctor.setFont(new java.awt.Font("微软雅黑", 1, 24)); // NOI18N
        lbDoctor.setText(" Company Info");
        lbDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDoctorMouseClicked(evt);
            }
        });

        jobInfoTF.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        jobInfoTF.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        companyTF.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        companyTF.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        applyBtn.setBackground(new java.awt.Color(36, 193, 93));
        applyBtn.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        applyBtn.setForeground(new java.awt.Color(255, 255, 255));
        applyBtn.setLabel("Apply");
        applyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBtnActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        EnterpriseTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        EnterpriseTable.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        EnterpriseTable.setForeground(new java.awt.Color(51, 51, 51));
        EnterpriseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Job", "Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EnterpriseTable.setGridColor(new java.awt.Color(240, 240, 240));
        EnterpriseTable.setRowHeight(40);
        EnterpriseTable.setSelectionBackground(new java.awt.Color(96, 83, 150));
        EnterpriseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickTB(evt);
            }
        });
        jScrollPane3.setViewportView(EnterpriseTable);

        lbPatient.setFont(new java.awt.Font("微软雅黑", 1, 24)); // NOI18N
        lbPatient.setText("  Job Info");
        lbPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPatientMouseClicked(evt);
            }
        });

        jLabel2.setText("Compay Type:");

        categoryCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", " " }));
        categoryCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(categoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbPatient)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(lbDoctor)
                            .addComponent(companyTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(jobInfoTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jobInfoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbDoctor)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(companyTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EnterpriseTableMouseClicked(java.awt.event.MouseEvent evt) {
        int index = EnterpriseTable.getSelectedRow();
        TableModel model = EnterpriseTable.getModel();

        if (index >= 0) {
            Job job = (FullTimeJob) model.getValueAt(index, 0);
            Enterprise enterprise = job.getEnterprise();
            setLB(job, enterprise);
        }
    }


    private void lbDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDoctorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbDoctorMouseClicked

    private void applyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBtnActionPerformed
        // TODO add your handling code here:
        if (account.getApplicant().getResume().getEducationResume().getDegree().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Create the Resume First");
            return;
        }

        int index = EnterpriseTable.getSelectedRow();
        TableModel model = EnterpriseTable.getModel();

        if (index >= 0) {
            Job job = (Job) model.getValueAt(index, 0);
            Enterprise enterprise = job.getEnterprise();
            ApplyRequest apply = new ApplyRequest(enterprise, account, job);
            if (!system.getWorkQ().existApply(apply)) {
                system.getWorkQ().getWorkRequests().add(apply);
                system.getWorkQ().addRequest(apply);
                JOptionPane.showMessageDialog(null, "Apply succesfully!");
            }else{
                JOptionPane.showMessageDialog(null, "You cannot apply for a same job twice!");
            }

        }
    }//GEN-LAST:event_applyBtnActionPerformed

    private void lbPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPatientMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbPatientMouseClicked

    private void categoryCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBActionPerformed
        // TODO add your handling code here:
        String select = categoryCB.getSelectedItem().toString();
        populateTable(select);
    }//GEN-LAST:event_categoryCBActionPerformed

    private void mouseClickTB(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickTB
        // TODO add your handling code here:
        int index = EnterpriseTable.getSelectedRow();
        TableModel model = EnterpriseTable.getModel();
        if (index >= 0) {
            Job job = (FullTimeJob) model.getValueAt(index, 0);
            Enterprise enterprise = job.getEnterprise();
            setLB(job, enterprise);
            showImage(enterprise);
        }
    }//GEN-LAST:event_mouseClickTB


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable EnterpriseTable;
    private java.awt.Button applyBtn;
    private javax.swing.JComboBox categoryCB;
    private javax.swing.JLabel companyTF;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jobInfoTF;
    private javax.swing.JLabel lbDoctor;
    private javax.swing.JLabel lbPatient;
    // End of variables declaration//GEN-END:variables
}
