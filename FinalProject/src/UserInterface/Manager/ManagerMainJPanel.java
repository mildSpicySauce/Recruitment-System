/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Manager;

import Business.Account.Account;
import Business.Account.EmployeeAccount;
import Business.Applicant.Applicant;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ExamEnterprise.ExamEnterprise;
import Business.Exam.ExamConfig;
import Business.Job.FullTimeJob;
import Business.Job.InternshipJob;
import Business.Job.Job;
import Business.Job.JobType;
import Business.Network.Network;
import Business.Role.HRRole;
import Business.Role.Role;
import Business.Role.RoleType;
import Business.WorkQueue.ApplicationStatus;
import Business.WorkQueue.ApplyRequest;
import Business.WorkQueue.ExamRequest;
import Business.WorkQueue.ReviewRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.LoginJFrame;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jxw
 */


/*
public class ManagerMainJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private JPanel container;
    private Enterprise en;
    private EmployeeAccount account;
    private JFrame frame;
    private Role role;
    private Employee employee;

    public ManagerMainJPanel(EcoSystem system, JPanel container, Enterprise en, Account userAccount, 
            JFrame frame, Role role) {
        initComponents();
        this.system = system;
        this.container = container;
        this.en = en;
        this.account = (EmployeeAccount) userAccount;
        this.frame = frame;
        this.employee = this.account.getEmployee();
        this.role = role;
        if (!(en instanceof ExamEnterprise)) {
            jTabbedPane1.removeTabAt(7);
        } else {
            jTabbedPane1.removeTabAt(3);
        }
        
        if (role.getRoleType().equals(RoleType.HR)) {
            jTabbedPane1.removeTabAt(5);
            jLabel5.setText("");
            editButton1.setVisible(false);
            saveButton1.setVisible(false);
            cancelButton1.setVisible(false);
        }
        
        // Profile Tab
        setInfo();
        setInfo2();
        editButton.setEnabled(true);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton1.setEnabled(true);
        saveButton1.setEnabled(false);
        cancelButton1.setEnabled(false);
        
        setFieldsEditable(false);
        setFieldEditable2(false);
        
        
        populateApplyTable(getAllRequest());
        populateReviewTable(getAllRequest());
        populateJobTable();
        populateHRTable();
    }

    
    private ArrayList<WorkRequest> getAllRequest() {
        ArrayList<WorkRequest> list = new ArrayList<>();
        list.addAll(this.en.getWorkQ().getWorkRequests());
        list.addAll(this.account.getWorkQueue().getWorkRequests());
        return list;
    }
    
    private void populateReviewTable(ArrayList<WorkRequest> list) {
        DefaultTableModel dtm = (DefaultTableModel) reviewTable.getModel();
        double score = 0, count = 0;
        dtm.setRowCount(0);
        for (WorkRequest wr : list) {
            if (wr instanceof ReviewRequest) {
                ReviewRequest request = (ReviewRequest) wr;
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = request.getAccount();
                row[2] = request.getRate();
                row[3] = request.getMessage();
                dtm.addRow(row);
                score += request.getRate();
                count ++;
            }
        }
        if (count != 0) score = score / count;
        currentRateTextField.setText(String.format("%.2f", score));
    }
    
    private void populateApplyTable(ArrayList<WorkRequest> list) {
        DefaultTableModel dtm = (DefaultTableModel) applicantTable.getModel();
        dtm.setRowCount(0);
        for (WorkRequest wr : list) {
            if (wr instanceof ApplyRequest) {
                ApplyRequest ar = (ApplyRequest) wr;
                Object row[] = new Object[4];
                row[0] = ar;
                row[1] = ar.getAccount();
                row[2] = ((Applicant) ar.getAccount().getApplicant()).getEmail();
                row[3] = ar.getApplystatus();
                dtm.addRow(row);
            }
        }
    }

//    private void populateExamTable() {
//        DefaultTableModel dtm = (DefaultTableModel) examTable.getModel();
//        dtm.setRowCount(0);
//        
//        for (ExamConfig config : en.getExamConfigs()) {
//            Object[] row = new Object[4];
//            row[0] = config.getTitle();
//            row[1] = config.getTimeLimit();
//            row[2] = config.getQuestionCount();
//            row[3] = config.getUsers().size();
//            dtm.addRow(row);
//        } 
//    }
    
    private void populateHRTable() {
        DefaultTableModel dtm = (DefaultTableModel) HRTable.getModel();
        dtm.setRowCount(0);

        for (Account account : en.getAccountDir().getAccountList()) {
            if (account.getRole().getRoleType().equals(RoleType.HR)) {
               EmployeeAccount ac = (EmployeeAccount) account;
               
                Object[] row = new Object[4];
                row[0] = ac.getEmployee().getId();
                row[1] = ac;
                row[2] = ac.getEmployee().getPhone();
                row[3] = ac.getEmployee().getEmail();
                dtm.addRow(row);
            }
        }
    }
    
    private void populateJobTable() {
        DefaultTableModel dtm = (DefaultTableModel) jobTable.getModel();
        dtm.setRowCount(0);

        for (Job job : en.getHireFullTimeJobs()) {
            Object[] row = new Object[4];
            row[0] = job;
            row[1] = "Full Time Job";
            row[2] = job.getRequirement();
            row[3] = job.getIssuer();
            dtm.addRow(row);
        }            
        
        for (Job job : en.getHireInternJobs()) {
            Object[] row = new Object[4];
            row[0] = job;
            row[1] = "Internship Job";
            row[2] = job.getRequirement();
            row[3] = job.getIssuer();
            dtm.addRow(row);
        }
    }
   
    private void setInfo() {
        roleTextField.setText(this.account.getRole().getRoleType().getValue());
        nameLabel.setText(employee.getFirstName());
        emailTextField.setText(employee.getEmail());
        firstNameTextField.setText(employee.getFirstName());
        lastNameTextField.setText(employee.getLastName());
        phoneTextField.setText(employee.getPhone());
        usernameTextField.setText(account.getUsername());
    }

    private void setInfo2() {
        nameTfl.setText(en.getName());
        phoneTfl.setText(en.getPhone());
        addressTfl.setText(en.getAddress());
        descriptTfl.setText(en.getDescription());
    }
    
    
    private void resetPasswordField() {
        passwordField.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
    }

    private void setFieldsEditable(boolean b) {
        emailTextField.setEnabled(b);
        firstNameTextField.setEnabled(b);
        lastNameTextField.setEnabled(b);
        phoneTextField.setEnabled(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        firstNameTextField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        roleTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        passwordField1 = new javax.swing.JPasswordField();
        passwordField2 = new javax.swing.JPasswordField();
        cancelButton3 = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        submitButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jobTable = new javax.swing.JTable();
        addInterBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        addFullTimeBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        applicantTable = new javax.swing.JTable();
        sendTestBtn = new javax.swing.JButton();
        viewResumeBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        viewResultBtn = new javax.swing.JButton();
        passBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        nameTfl = new javax.swing.JTextField();
        phoneTfl = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        addressTfl = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        descriptTfl = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        saveButton1 = new javax.swing.JButton();
        editButton1 = new javax.swing.JButton();
        cancelButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        HRTable = new javax.swing.JTable();
        deleteHRBtn = new javax.swing.JButton();
        addHRBtn = new javax.swing.JButton();
        alterHRBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        rateTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        customerTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        currentRateTextField = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        reviewTable = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        reviewTextArea = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel5.setText("Welcome, ");

        nameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        nameLabel.setText("<Name>");

        logoutButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Last Name: ");

        usernameTextField.setEnabled(false);
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel12.setText("First Name: ");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Email:");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Phone:");

        saveButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Username: ");

        cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Role:");

        roleTextField.setEnabled(false);
        roleTextField.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(roleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(69, 69, 69))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 317, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(roleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profile", jPanel2);

        cancelButton3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton3.setText("Cancel");
        cancelButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton3ActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel15.setText("Confirm Password:");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel14.setText("New Password:");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel13.setText("Old Password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(362, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton3))
                .addContainerGap(353, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Change Password", jPanel1);

        jobTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Job", "Type", "Requirment", "Creator"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jobTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jobTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jobTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jobTable);

        addInterBtn.setText("Add Internship");
        addInterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInterBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete Job");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        addFullTimeBtn.setText("Add Full Time Job");
        addFullTimeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFullTimeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addInterBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addFullTimeBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn)
                    .addComponent(addInterBtn)
                    .addComponent(addFullTimeBtn))
                .addContainerGap(313, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Job", jPanel7);

        applicantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Job", "Applicant", "Email", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        applicantTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        applicantTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applicantTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(applicantTable);

        sendTestBtn.setText("Give Test Authority");
        sendTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendTestBtnActionPerformed(evt);
            }
        });

        viewResumeBtn.setText("View Resume");
        viewResumeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResumeBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Reject");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        viewResultBtn.setText("View Test Result");
        viewResultBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultBtnActionPerformed(evt);
            }
        });

        passBtn.setText("Pass");
        passBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewResumeBtn)
                        .addGap(18, 18, 18)
                        .addComponent(sendTestBtn)
                        .addGap(21, 21, 21)
                        .addComponent(passBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)
                        .addGap(26, 26, 26)
                        .addComponent(viewResultBtn)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendTestBtn)
                    .addComponent(viewResumeBtn)
                    .addComponent(cancelBtn)
                    .addComponent(viewResultBtn)
                    .addComponent(passBtn))
                .addContainerGap(316, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Applicant", jPanel4);

        usernameTextField.setEnabled(false);
        nameTfl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTflActionPerformed(evt);
            }
        });

        phoneTfl.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        phoneTfl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTflActionPerformed(evt);
            }
        });

        addressTfl.setColumns(20);
        addressTfl.setEnabled(false);
        jScrollPane4.setViewportView(addressTfl);

        descriptTfl.setColumns(20);
        descriptTfl.setLineWrap(true);
        descriptTfl.setEnabled(false);
        jScrollPane5.setViewportView(descriptTfl);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Description: ");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("Address:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Phone:");

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Company Name:");

        saveButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        saveButton1.setText("Save");
        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });

        editButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        editButton1.setText("Edit");
        editButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton1ActionPerformed(evt);
            }
        });

        cancelButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton1.setText("Cancel");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(editButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(phoneTfl, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameTfl, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)))
                .addContainerGap(365, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(nameTfl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(phoneTfl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton1)
                    .addComponent(saveButton1)
                    .addComponent(cancelButton1))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Company Info", jPanel3);

        HRTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "HR Name", "Phone", "Email"
            }
        ));
        jScrollPane3.setViewportView(HRTable);

        deleteHRBtn.setText("Delete HR");
        deleteHRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteHRBtnActionPerformed(evt);
            }
        });

        addHRBtn.setText("Add HR");
        addHRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHRBtnActionPerformed(evt);
            }
        });

        alterHRBtn.setText("Alter HR");
        alterHRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterHRBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(alterHRBtn)
                        .addGap(32, 32, 32)
                        .addComponent(addHRBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteHRBtn)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteHRBtn)
                    .addComponent(addHRBtn)
                    .addComponent(alterHRBtn))
                .addContainerGap(363, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Employee", jPanel6);

        rateTextField.setEditable(false);
        rateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateTextFieldActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel19.setText("Rate:");

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel20.setText("Comment:");

        customerTextField.setEditable(false);
        customerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerTextFieldActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel21.setText("Applicant:");

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel22.setText("Review Details");

        currentRateTextField.setEditable(false);
        currentRateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentRateTextFieldActionPerformed(evt);
            }
        });

        reviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Applicant", "Rate", "Comment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reviewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reviewTableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(reviewTable);

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel23.setText("Current Rate:");

        reviewTextArea.setEditable(false);
        reviewTextArea.setColumns(20);
        reviewTextArea.setLineWrap(true);
        reviewTextArea.setRows(5);
        jScrollPane9.setViewportView(reviewTextArea);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel22)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(currentRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel22)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(customerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(rateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Review", jPanel5);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 989, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Test", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addGap(23, 23, 23)
                .addComponent(logoutButton)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        LoginJFrame lf = new LoginJFrame();
        this.frame.dispose();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        int index = jTabbedPane1.getSelectedIndex();
        if (index != 0 && index != -1) {
            setInfo();
        }
        setFieldsEditable(false);
        resetPasswordField();

        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void alterHRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterHRBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = HRTable.getSelectedRow();
        TableModel model = HRTable.getModel();

        if (selectedRow >= 0) {
            EmployeeAccount hr = (EmployeeAccount) model.getValueAt(selectedRow, 1);
            HRJFrame frame = new HRJFrame(system, en, hr);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            DB4OUtil.getInstance().storeSystem(system);
        }
    }//GEN-LAST:event_alterHRBtnActionPerformed

    private void addHRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHRBtnActionPerformed
        // TODO add your handling code here:
        AddHRJFrame frame = new AddHRJFrame(system, en);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        DB4OUtil.getInstance().storeSystem(system);
        populateHRTable();
    }//GEN-LAST:event_addHRBtnActionPerformed

    private void deleteHRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteHRBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = HRTable.getSelectedRow();
        TableModel model = HRTable.getModel();
        if (selectedRow >= 0) {
            EmployeeAccount hr = (EmployeeAccount) model.getValueAt(selectedRow, 1);
            en.getAccountDir().removeAccount(account);
            DB4OUtil.getInstance().storeSystem(system);
        } else {
            JOptionPane.showMessageDialog(null, "Please choose the HR");
            return;
        }
    }//GEN-LAST:event_deleteHRBtnActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        // TODO add your handling code here:
        setFieldEditable2(false);
        setInfo();

        saveButton1.setEnabled(false);
        cancelButton1.setEnabled(false);
        editButton1.setEnabled(true);
    }//GEN-LAST:event_cancelButton1ActionPerformed

    private void editButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton1ActionPerformed
        // TODO add your handling code here:
        saveButton1.setEnabled(true);
        cancelButton1.setEnabled(true);
        editButton1.setEnabled(false);
        setFieldEditable2(true);
    }//GEN-LAST:event_editButton1ActionPerformed

    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
        // TODO add your handling code here:
        if (!nameTfl.getText().equals("") && !phoneTfl.getText().equals("")
            && !addressTfl.getText().equals("") && !descriptTfl.getText().equals("")) {
            en.setName(nameTfl.getName());
            en.setPhone(phoneTfl.getText());
            en.setAddress(addressTfl.getText());
            en.setDescription(descriptTfl.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }

        saveButton1.setEnabled(false);
        cancelButton1.setEnabled(false);
        editButton1.setEnabled(true);

        DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_saveButton1ActionPerformed

    private void phoneTflActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTflActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_phoneTflActionPerformed

    private void nameTflActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTflActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTflActionPerformed

    private void viewResultBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResultBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewResultBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        int index = applicantTable.getSelectedRow();
        if (index >= 0) {
            ApplyRequest selectedRequest = (ApplyRequest) applicantTable.getValueAt(index, 0);
            system.getWorkQ().deleteRequest(selectedRequest.getExamRequest());
            system.getWorkQ().deleteRequest(selectedRequest);
            DB4OUtil.getInstance().storeSystem(system);
            populateApplyTable(getAllRequest());
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void viewResumeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResumeBtnActionPerformed
        // TODO add your handling code here:
        int index = applicantTable.getSelectedRow();
        ApplyRequest selectedRequest = (ApplyRequest) applicantTable.getValueAt(index, 0);
        ResumeJFrame resumeJFrame = new ResumeJFrame(selectedRequest.getResume());
        resumeJFrame.setLocationRelativeTo(null);
        resumeJFrame.setVisible(true);
    }//GEN-LAST:event_viewResumeBtnActionPerformed

    private void sendTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendTestBtnActionPerformed
        int index = applicantTable.getSelectedRow();
        if (index >= 0) {
            ApplyRequest selectedRequest = (ApplyRequest) applicantTable.getValueAt(index, 0);
            ExamRequest examRequest = new ExamRequest(en, selectedRequest.getAccount());
            selectedRequest.createExamRequest(examRequest);
            system.getWorkQ().addRequest(examRequest);
            DB4OUtil.getInstance().storeSystem(system);

            populateApplyTable(getAllRequest());
        }
    }//GEN-LAST:event_sendTestBtnActionPerformed

    private void applicantTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicantTableMouseClicked
        int index = applicantTable.getSelectedRow();

        //        if (index >= 0) {
            //            selectedRequest = (DeliveryRequest) applicantTable.getValueAt(index, 1);
            //            if (selectedRequest.getStatus().equals(StatusEnum.Ready)) {
                //                sendTestBtn.setEnabled(true);
                //                pickupButton.setEnabled(false);
                //                deliveredButton.setEnabled(false);
                //            }
            //            if (selectedRequest.getStatus().equals(StatusEnum.WaitForPickup)) {
                //                sendTestBtn.setEnabled(false);
                //                pickupButton.setEnabled(true);
                //                deliveredButton.setEnabled(false);
                //            }
            //            if (selectedRequest.getStatus().equals(StatusEnum.OnTheWay)) {
                //                sendTestBtn.setEnabled(false);
                //                pickupButton.setEnabled(false);
                //                deliveredButton.setEnabled(true);
                //            }
            //            if (selectedRequest.getStatus().equals(StatusEnum.Completed) ||
                //                    selectedRequest.getStatus().equals(StatusEnum.Cancelled)) {
                //                sendTestBtn.setEnabled(false);
                //                pickupButton.setEnabled(false);
                //                deliveredButton.setEnabled(false);
                //            }
            //            populateDetails();
            //        } else {
            //            sendTestBtn.setEnabled(false);
            //        }
    }//GEN-LAST:event_applicantTableMouseClicked

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        char[] passwordCharArray = passwordField2.getPassword();
        String password = String.valueOf(passwordCharArray);
        char[] passwordCharArray1 = passwordField.getPassword();
        String new1 = String.valueOf(passwordCharArray1);
        char[] passwordCharArray2 = passwordField1.getPassword();
        String new2 = String.valueOf(passwordCharArray2);

        if (password.equals(account.getPassword())) {
            if (!new1.equals("")) {
                if (new1.equals(new2)) {
                    account.setPassword(new1);
                    JOptionPane.showMessageDialog(null, "Password updated successfully!");
                    DB4OUtil.getInstance().storeSystem(system);
                    resetPasswordField();
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords don't match!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password can't be empty!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correct!");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton3ActionPerformed
        resetPasswordField();
    }//GEN-LAST:event_cancelButton3ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setFieldsEditable(false);
        setInfo();

        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (!emailTextField.getText().equals("") && !firstNameTextField.getText().equals("")
            && !lastNameTextField.getText().equals("") && !phoneTextField.getText().equals("")) {
            this.employee.setEmail(emailTextField.getText());
            this.employee.setFirstName(firstNameTextField.getText());
            this.employee.setLastName(lastNameTextField.getText());
            this.employee.setPhone(phoneTextField.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }
        setFieldsEditable(false);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);

        DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        saveButton.setEnabled(true);
        cancelButton.setEnabled(true);
        editButton.setEnabled(false);

        setFieldsEditable(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void jobTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jobTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jobTableMouseClicked

    private void addInterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInterBtnActionPerformed
        // TODO add your handling code here:
        InternshipJob internshipJob = new InternshipJob("", "", employee, en);
        en.addInterns(internshipJob);
        InternFrame inter = new InternFrame (system, en, internshipJob);
        inter.setLocationRelativeTo(null);
        inter.setVisible(true);
        DB4OUtil.getInstance().storeSystem(system);
        populateJobTable();
    }//GEN-LAST:event_addInterBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int index = jobTable.getSelectedRow();
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addFullTimeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFullTimeBtnActionPerformed
        // TODO add your handling code here:
        FullTimeJob fullTimeJob = new FullTimeJob("", "", employee, en);
        en.addFullTimes(fullTimeJob);
        FullTimeFrame fullTime = new FullTimeFrame(system, en, fullTimeJob);
        fullTime.setLocationRelativeTo(null);
        fullTime.setVisible(true);
        DB4OUtil.getInstance().storeSystem(system);
        populateJobTable();
    }//GEN-LAST:event_addFullTimeBtnActionPerformed

    private void rateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rateTextFieldActionPerformed

    private void customerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerTextFieldActionPerformed

    private void currentRateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentRateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentRateTextFieldActionPerformed

    private void reviewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reviewTableMouseClicked
        int index = reviewTable.getSelectedRow();

        if (index >= 0) {
            ReviewRequest rr = (ReviewRequest) reviewTable.getValueAt(index, 0);
            customerTextField.setText(rr.getAccount().getUsername());
            rateTextField.setText(rr.getRate() + "");
            reviewTextArea.setText(rr.getMessage());
        }                
    }//GEN-LAST:event_reviewTableMouseClicked

    private void passBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passBtnActionPerformed
        // TODO add your handling code here:
        int index = applicantTable.getSelectedRow();
        if (index >= 0) {
            ApplyRequest selectedRequest = (ApplyRequest) applicantTable.getValueAt(index, 0);
            selectedRequest.setApplicationstatus(ApplicationStatus.AD);
            populateApplyTable(getAllRequest());
        }
    }//GEN-LAST:event_passBtnActionPerformed
    
    private void setFieldEditable2 (Boolean b) {
        nameTfl.setEnabled(b);
        nameTfl.setEditable(b);
        phoneTfl.setEditable(b);
        phoneTfl.setEnabled(b);
        addressTfl.setEditable(b);
        addressTfl.setEnabled(b);
        descriptTfl.setEditable(b);        
        descriptTfl.setEnabled(b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HRTable;
    private javax.swing.JButton addFullTimeBtn;
    private javax.swing.JButton addHRBtn;
    private javax.swing.JButton addInterBtn;
    private javax.swing.JTextArea addressTfl;
    private javax.swing.JButton alterHRBtn;
    private javax.swing.JTable applicantTable;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton cancelButton3;
    private javax.swing.JTextField currentRateTextField;
    private javax.swing.JTextField customerTextField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteHRBtn;
    private javax.swing.JTextArea descriptTfl;
    private javax.swing.JButton editButton;
    private javax.swing.JButton editButton1;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jobTable;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTfl;
    private javax.swing.JButton passBtn;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JTextField phoneTfl;
    private javax.swing.JTextField rateTextField;
    private javax.swing.JTable reviewTable;
    private javax.swing.JTextArea reviewTextArea;
    private javax.swing.JTextField roleTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveButton1;
    private javax.swing.JButton sendTestBtn;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JButton viewResultBtn;
    private javax.swing.JButton viewResumeBtn;
    // End of variables declaration//GEN-END:variables
}
*/