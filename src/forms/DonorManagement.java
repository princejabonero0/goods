package forms;
import config.config;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
public class DonorManagement extends javax.swing.JFrame {
    public DonorManagement() {
        initComponents();
        setLocationRelativeTo(null);
        customizeUI();
        loadDonorData();
    }
    
    private void customizeUI() {
        getContentPane().setBackground(new Color(44, 62, 80));
        jPanel1.setBackground(new Color(255, 255, 255));
        
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(new Color(231, 76, 60));
        
        btnAdd.setBackground(new Color(46, 204, 113));
        btnUpdate.setBackground(new Color(52, 152, 219));
        btnDelete.setBackground(new Color(231, 76, 60));
        btnRefresh.setBackground(new Color(241, 196, 15));
        btnBack.setBackground(new Color(149, 165, 166));
        
        JButton[] buttons = {btnAdd, btnUpdate, btnDelete, btnRefresh, btnBack};
        for (JButton btn : buttons) {
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
            btn.setFocusPainted(false);
        }
    }
    private void loadDonorData() {
        try {
            Connection conn = config.connectDB();
            String sql = "SELECT * FROM donors";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) tblDonors.getModel();
            model.setRowCount(0);
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("donor_id"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("blood_type"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("address"),
                    rs.getString("last_donation_date"),
                    rs.getString("status")
                });
            }
            
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }
    
    private void clearFields() {
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtAge.setText("");
        txtAddress.setText("");
        txtLastDonation.setText("");
        cmbBloodType.setSelectedIndex(0);
        cmbGender.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonors = new javax.swing.JTable();
        txtAddress = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        cmbBloodType = new javax.swing.JComboBox<>();
        cmbGender = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtLastDonation = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDonors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Email", "Phone", "Age", "Address", "Blood Type", "Gender"
            }
        ));
        tblDonors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonorsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDonors);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 90));

        txtAddress.setText("Address");
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        txtName.setText("Name");
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txtEmail.setText("Email");
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txtPhone.setText("Phone");
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        txtAge.setText("Age");
        jPanel1.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        cmbBloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O" }));
        jPanel1.add(cmbBloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel1.add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, -1, -1));

        txtLastDonation.setText("Last Donation");
        jPanel1.add(txtLastDonation, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, -1, -1));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTitle.setText("DONORS");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDonorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonorsMouseClicked
        int row = tblDonors.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblDonors.getModel();
            txtName.setText(model.getValueAt(row, 1).toString());
            txtEmail.setText(model.getValueAt(row, 2).toString());
            txtPhone.setText(model.getValueAt(row, 3).toString());
            cmbBloodType.setSelectedItem(model.getValueAt(row, 4).toString());
            txtAge.setText(model.getValueAt(row, 5).toString());
            cmbGender.setSelectedItem(model.getValueAt(row, 6).toString());
            txtAddress.setText(model.getValueAt(row, 7).toString());
            txtLastDonation.setText(model.getValueAt(row, 8) != null ? model.getValueAt(row, 8).toString() : "");
        }
    }//GEN-LAST:event_tblDonorsMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        String bloodType = cmbBloodType.getSelectedItem().toString();
        String ageStr = txtAge.getText().trim();
        String gender = cmbGender.getSelectedItem().toString();
        String address = txtAddress.getText().trim();
        String lastDonation = txtLastDonation.getText().trim();
        
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || ageStr.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int age = Integer.parseInt(ageStr);
            
            config conf = new config();
            String sql = "INSERT INTO donors (full_name, email, phone, blood_type, age, gender, address, last_donation_date, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            conf.addRecord(sql, name, email, phone, bloodType, age, gender, address, lastDonation.isEmpty() ? null : lastDonation, "Active");
            
            JOptionPane.showMessageDialog(this, "Donor added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadDonorData();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = tblDonors.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a donor to update!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tblDonors.getModel();
        int donorId = (int) model.getValueAt(row, 0);
        
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        String bloodType = cmbBloodType.getSelectedItem().toString();
        String ageStr = txtAge.getText().trim();
        String gender = cmbGender.getSelectedItem().toString();
        String address = txtAddress.getText().trim();
        String lastDonation = txtLastDonation.getText().trim();
        
        try {
            int age = Integer.parseInt(ageStr);
            
            Connection conn = config.connectDB();
            String sql = "UPDATE donors SET full_name=?, email=?, phone=?, blood_type=?, age=?, gender=?, address=?, last_donation_date=? WHERE donor_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, bloodType);
            pstmt.setInt(5, age);
            pstmt.setString(6, gender);
            pstmt.setString(7, address);
            pstmt.setString(8, lastDonation.isEmpty() ? null : lastDonation);
            pstmt.setInt(9, donorId);
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
            JOptionPane.showMessageDialog(this, "Donor updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadDonorData();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblDonors.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a donor to delete!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this donor?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tblDonors.getModel();
        int donorId = (int) model.getValueAt(row, 0);
        
        try {
            Connection conn = config.connectDB();
            String sql = "DELETE FROM donors WHERE donor_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, donorId);
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
            JOptionPane.showMessageDialog(this, "Donor deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadDonorData();
            clearFields();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadDonorData();
        clearFields();
        JOptionPane.showMessageDialog(this, "Data refreshed!");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DonorManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DonorManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DonorManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DonorManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DonorManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbBloodType;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblDonors;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastDonation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
