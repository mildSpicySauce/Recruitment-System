/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.Manager;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Job.FullTimeJob;
import Business.Job.InternshipJob;
import Business.Job.Job;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 11638
 */
public class FullTimeFrame extends javax.swing.JFrame {

    EcoSystem system;
    Enterprise enterprise;
    FullTimeJob job;
    ManageJobJPanel manageJobJPanel;
    
    /**
     * Creates new form JobFrame
     */
    public FullTimeFrame(EcoSystem system, Enterprise enterprise, FullTimeJob job, JPanel jPanel) {
        this.system = system;
        this.enterprise = enterprise;
        this.job = job;
        this.manageJobJPanel = (ManageJobJPanel) jPanel;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JobJpanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        requirementTF = new javax.swing.JTextField();
        jobTF = new javax.swing.JTextField();
        categoryTF = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        workPlaceTF = new javax.swing.JTextField();
        salaryTF = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        JobJpanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("微软雅黑", 0, 25)); // NOI18N
        jLabel21.setText("Requirement:");

        jLabel16.setFont(new java.awt.Font("微软雅黑", 0, 25)); // NOI18N
        jLabel16.setText("Job:");

        cancelButton.setBackground(new java.awt.Color(36, 193, 93));
        cancelButton.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(0, 51, 51));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(36, 193, 93));
        saveButton.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 51, 51));
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        requirementTF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jobTF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        categoryTF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel18.setFont(new java.awt.Font("微软雅黑", 0, 25)); // NOI18N
        jLabel18.setText("Category:");

        workPlaceTF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        salaryTF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel24.setFont(new java.awt.Font("微软雅黑", 0, 25)); // NOI18N
        jLabel24.setText("WorkPlace:");

        jLabel20.setFont(new java.awt.Font("微软雅黑", 0, 25)); // NOI18N
        jLabel20.setText("Salary:");

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Full Time Job");

        javax.swing.GroupLayout JobJpanelLayout = new javax.swing.GroupLayout(JobJpanel);
        JobJpanel.setLayout(JobJpanelLayout);
        JobJpanelLayout.setHorizontalGroup(
            JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JobJpanelLayout.createSequentialGroup()
                .addGroup(JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JobJpanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(requirementTF, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JobJpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JobJpanelLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(workPlaceTF))
                            .addGroup(JobJpanelLayout.createSequentialGroup()
                                .addGap(0, 53, Short.MAX_VALUE)
                                .addGroup(JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(JobJpanelLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addComponent(salaryTF, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(JobJpanelLayout.createSequentialGroup()
                                            .addComponent(jLabel16)
                                            .addGap(18, 18, 18)
                                            .addComponent(jobTF))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JobJpanelLayout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addGap(18, 18, 18)
                                            .addComponent(categoryTF, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(JobJpanelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        JobJpanelLayout.setVerticalGroup(
            JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JobJpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jobTF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(requirementTF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(categoryTF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(workPlaceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryTF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(47, 47, 47)
                .addGroup(JobJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JobJpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JobJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(!jobTF.getText().equals("") ||
            !requirementTF.getText().equals("") ||
            !categoryTF.getText().equals("") ||
            !workPlaceTF.getText().equals("") ||
            !salaryTF.getText().equals("")
                ) {
            job.setName(jobTF.getText());
            job.setRequirement(requirementTF.getText());
            job.setSalary(salaryTF.getText());
            job.setCategory(categoryTF.getText());
            job.setWorkPlace(workPlaceTF.getText());
            manageJobJPanel.populateJobTable();
            DB4OUtil.getInstance().storeSystem(system);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JobJpanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField categoryTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JTextField jobTF;
    private javax.swing.JTextField requirementTF;
    private javax.swing.JTextField salaryTF;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField workPlaceTF;
    // End of variables declaration//GEN-END:variables
}
