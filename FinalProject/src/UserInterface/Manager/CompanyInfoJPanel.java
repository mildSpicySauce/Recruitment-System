/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.Manager;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author 11638
 */
public class CompanyInfoJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private Enterprise en;

    /**
     * Creates new form CompanyInfoJPanel
     */
    public CompanyInfoJPanel(EcoSystem system, Enterprise enterprise) {
        initComponents();
        this.system = system;
        this.en = enterprise;
        setInfo2();

        setFieldEditable2(false);
        uploadButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        descriptTfl = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        saveButton1 = new javax.swing.JButton();
        nameTfl = new javax.swing.JTextField();
        editButton1 = new javax.swing.JButton();
        phoneTfl = new javax.swing.JTextField();
        cancelButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        addressTfl = new javax.swing.JTextArea();
        uploadButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();

        descriptTfl.setColumns(20);
        descriptTfl.setLineWrap(true);
        descriptTfl.setEnabled(false);
        jScrollPane5.setViewportView(descriptTfl);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Description: ");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Address:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Phone:");

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Company Name:");

        saveButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        saveButton1.setText("Save");
        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });

        nameTfl.setEnabled(false);
        nameTfl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTflActionPerformed(evt);
            }
        });

        editButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        editButton1.setText("Edit");
        editButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton1ActionPerformed(evt);
            }
        });

        phoneTfl.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        phoneTfl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTflActionPerformed(evt);
            }
        });

        cancelButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton1.setText("Cancel");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        addressTfl.setColumns(20);
        addressTfl.setEnabled(false);
        jScrollPane4.setViewportView(addressTfl);

        uploadButton.setText("Upload Photo");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel4)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(uploadButton)
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTfl))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(phoneTfl))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(nameTfl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(phoneTfl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1)
                                .addGap(67, 67, 67))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(uploadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton1)
                    .addComponent(saveButton1)
                    .addComponent(cancelButton1))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {nameTfl, phoneTfl});

    }// </editor-fold>//GEN-END:initComponents

    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
        // TODO add your handling code here:
        if (!phoneTfl.getText().equals("")
            && !addressTfl.getText().equals("") && !descriptTfl.getText().equals("")) {
           
            en.setPhone(phoneTfl.getText());
            en.setAddress(addressTfl.getText());
            en.setDescription(descriptTfl.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }
        setFieldEditable2(false);
        saveButton1.setEnabled(false);
        cancelButton1.setEnabled(false);
        editButton1.setEnabled(true);
        
        ImageIcon image = new ImageIcon(en.getPhotoPath());
        image.setImage(image.getImage().getScaledInstance(150, 110, Image.SCALE_DEFAULT));
        imageLabel.setIcon(image);
        
        DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_saveButton1ActionPerformed
    
    private void setInfo2() {
        ImageIcon image = new ImageIcon(en.getPhotoPath());
        image.setImage(image.getImage().getScaledInstance(150, 110, Image.SCALE_DEFAULT));
        imageLabel.setIcon(image);
        nameTfl.setText(en.getName());
        phoneTfl.setText(en.getPhone());
        addressTfl.setText(en.getAddress());
        descriptTfl.setText(en.getDescription());
    }
    
    private void setFieldEditable2 (Boolean b) {
        
        phoneTfl.setEditable(b);
        phoneTfl.setEnabled(b);
        addressTfl.setEditable(b);
        addressTfl.setEnabled(b);
        descriptTfl.setEditable(b);        
        descriptTfl.setEnabled(b);
    }
    


    private void nameTflActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTflActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTflActionPerformed

    private void editButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton1ActionPerformed
        // TODO add your handling code here:
        saveButton1.setEnabled(true);
        cancelButton1.setEnabled(true);
        editButton1.setEnabled(false);
        uploadButton.setEnabled(true);
        setFieldEditable2(true);
    }//GEN-LAST:event_editButton1ActionPerformed

    private void phoneTflActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTflActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTflActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        // TODO add your handling code here:
        setFieldEditable2(false);

        uploadButton.setEnabled(false);
        saveButton1.setEnabled(false);
        cancelButton1.setEnabled(false);
        editButton1.setEnabled(true);
        setInfo2();
    }//GEN-LAST:event_cancelButton1ActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        String path = "";
        int i = chooser.showOpenDialog(null);
        if (i == chooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            en.setPhotoPath(path);
        } else {
            JOptionPane.showMessageDialog(null, "No file was selected");
        }
        ImageIcon image = new ImageIcon(path);
        image.setImage(image.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
        imageLabel.setIcon(image);
    }//GEN-LAST:event_uploadButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTfl;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JTextArea descriptTfl;
    private javax.swing.JButton editButton1;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField nameTfl;
    private javax.swing.JTextField phoneTfl;
    private javax.swing.JButton saveButton1;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
