/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.oodj_assignment;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public final class OrderDetail extends javax.swing.JFrame {
    String user;
    String role;
    String uName;
    String oid;
    String from;
    
    /**
     * Creates new form OrderDetail
     */
    public OrderDetail() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                LBLCurrentDate.setText(LocalDate.now().toString());
            }
        });
    }
    
    public OrderDetail(String id, String usr, String rl, String oid) {
        initComponents();
        user = id;
        uName = usr;
        role = rl;
        this.oid = oid;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                LBLCurrentDate.setText(LocalDate.now().toString());
                LBLuser.setText("User : "+uName+" ("+role+")");
            }
        });
        loadForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLCurrentDate = new javax.swing.JLabel();
        LBLuser = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LBLoid = new javax.swing.JLabel();
        LBLouid = new javax.swing.JLabel();
        LBLdate = new javax.swing.JLabel();
        LBLstatus = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBoItems = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        BTNclose = new javax.swing.JButton();
        BTNpayment = new javax.swing.JButton();
        LBLtotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BTNreceipt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LBLCurrentDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBLCurrentDate.setText("yyyy-mm-dd");

        LBLuser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LBLuser.setText("User : null (null)");

        jLabel6.setFont(new java.awt.Font("Lucida Sans Unicode", 3, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Order Details");

        LBLoid.setText("-");

        LBLouid.setText("-");

        LBLdate.setText("-");

        LBLstatus.setText("-");

        jLabel.setText("Order ID :");

        jLabel2.setText("Order By(ID) :");

        jLabel3.setText("Order Date :");

        jLabel5.setText("Order Status :");

        TBoItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price (RM)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TBoItems);

        jLabel7.setText("Ordered items:");

        BTNclose.setText("Close");
        BTNclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNcloseActionPerformed(evt);
            }
        });

        BTNpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNpaymentActionPerformed(evt);
            }
        });

        LBLtotal.setText("0");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total : RM");

        BTNreceipt.setText("Receipt");
        BTNreceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNreceiptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LBLuser, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(LBLCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(LBLstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LBLdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LBLoid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LBLouid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BTNclose)
                        .addGap(78, 78, 78)
                        .addComponent(BTNreceipt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNpayment)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBLtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLuser)
                    .addComponent(LBLCurrentDate))
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLoid)
                    .addComponent(jLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLouid)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLdate)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLstatus)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLtotal)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNclose)
                    .addComponent(BTNpayment)
                    .addComponent(BTNreceipt))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void loadForm(){
        String[] order;
        Order o = new Order(user,role);
        order = o.getOrderDetail(oid);
        LBLoid.setText(order[0]);
        LBLouid.setText(order[1]);
        LBLdate.setText(order[2]);
        LBLtotal.setText(order[3]);
        LBLstatus.setText(order[4]);
        DefaultTableModel model = (DefaultTableModel)TBoItems.getModel();
        model.setRowCount(0);
            for(int i = 5; i<order.length; i=i+2){
                Object[] row = {order[i],order[i+1]};
                model.addRow(row);
            }
        
        if ("Pending".equals(order[4])) {
            BTNreceipt.setVisible(false);
            if ("Customer".equals(role)) {
                BTNpayment.setText("Pay");
            }
            else{
                BTNpayment.setText("Collect Payment");
            }
        }
        else{
            BTNpayment.setText("Check Feedback");
            BTNreceipt.setVisible(true);
        }
    }
    
    void fillTable(String[] order){
        DefaultTableModel model = (DefaultTableModel)TBoItems.getModel();
        model.setRowCount(0);
        for(int i = 5; i<order.length; i=i+2){
            Object[] row = {order[i],order[i+1]};
            model.addRow(row);
        }
    }
    
    private void BTNpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNpaymentActionPerformed
        if ("Pending".equals(LBLstatus.getText())) {
            Order o = new Order(user,role);
            o.payOrder(oid, LBLtotal.getText());
            loadForm();
        }
        else{
            new Feedback(oid).setVisible(true);
        }
    }//GEN-LAST:event_BTNpaymentActionPerformed

    private void BTNcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNcloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BTNcloseActionPerformed

    private void BTNreceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNreceiptActionPerformed
        new Receipt(oid).setVisible(true);
    }//GEN-LAST:event_BTNreceiptActionPerformed

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
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNclose;
    private javax.swing.JButton BTNpayment;
    private javax.swing.JButton BTNreceipt;
    private javax.swing.JLabel LBLCurrentDate;
    private javax.swing.JLabel LBLdate;
    private javax.swing.JLabel LBLoid;
    private javax.swing.JLabel LBLouid;
    private javax.swing.JLabel LBLstatus;
    private javax.swing.JLabel LBLtotal;
    private javax.swing.JLabel LBLuser;
    private javax.swing.JTable TBoItems;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
