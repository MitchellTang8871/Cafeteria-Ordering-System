package com.mycompany.oodj_assignment;


import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Asus
 */
public final class MakeOrder extends javax.swing.JFrame {

    /**
     * Creates new form Order_Food
     */
    String user;
    String role;
    String uName;
    
    public MakeOrder() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                LBLCurrentDate.setText(LocalDate.now().toString());
            }
        });
        loadTB();
    }
    
    public MakeOrder(String id, String usr, String rl) {
        initComponents();
        user = id;
        uName = usr;
        role = rl;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                LBLCurrentDate.setText(LocalDate.now().toString());
                LBLuser.setText("User : "+uName+" ("+role+")");
            }
        });
        loadTB();
    }
    
    String getMenuFile(){
        String mf=null;
        if (CBcategory.getSelectedIndex()==0) {
            mf = "food";
        }
        if (CBcategory.getSelectedIndex()==1) {
            mf = "beverage";
        }
        return mf;
    }
    
    void fillTable(ArrayList<ArrayList<String>> menu){
        DefaultTableModel model = (DefaultTableModel)TBmenu.getModel();
        model.setRowCount(0);
            for(int i = 0; i<menu.size(); i++){
                Object[] row = {menu.get(i).get(0),menu.get(i).get(1)};
                model.addRow(row);
            }
    }
    
    void loadTB(){
        Menu m = new Menu();
        fillTable(m.getMenu(getMenuFile()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CBcategory = new javax.swing.JComboBox<>();
        BTNback = new javax.swing.JButton();
        BTNadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBmenu = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBcart = new javax.swing.JTable();
        BTNclear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        LBLCurrentDate = new javax.swing.JLabel();
        LBLuser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BTNdel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        BTNorder = new javax.swing.JButton();
        LBLtotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CBcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Food", "Beverage" }));
        CBcategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBcategoryItemStateChanged(evt);
            }
        });

        BTNback.setText("Back");
        BTNback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNbackActionPerformed(evt);
            }
        });

        BTNadd.setText("Add to Cart");
        BTNadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNaddActionPerformed(evt);
            }
        });

        TBmenu.setModel(new javax.swing.table.DefaultTableModel(
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
        TBmenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TBmenuKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TBmenu);

        TBcart.setModel(new javax.swing.table.DefaultTableModel(
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
        TBcart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TBcartKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(TBcart);

        BTNclear.setText("Clear");
        BTNclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNclearActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Sans Unicode", 3, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Make Order");

        LBLCurrentDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBLCurrentDate.setText("yyyy-mm-dd");

        LBLuser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LBLuser.setText("User : null (null)");

        jLabel1.setText("Category:");

        BTNdel.setText("Remove");
        BTNdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNdelActionPerformed(evt);
            }
        });

        jLabel2.setText("Order Cart: ");

        BTNorder.setText("Order");
        BTNorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNorderActionPerformed(evt);
            }
        });

        LBLtotal.setText("0");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total : RM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(LBLuser, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(LBLCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CBcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(BTNadd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BTNback)
                        .addGap(328, 328, 328)
                        .addComponent(BTNorder))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(BTNclear)
                        .addGap(38, 38, 38)
                        .addComponent(BTNdel)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBLtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBLuser)
                    .addComponent(LBLCurrentDate))
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(CBcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(BTNadd)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNclear)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LBLtotal)
                        .addComponent(jLabel4))
                    .addComponent(BTNdel))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNback)
                    .addComponent(BTNorder)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void add(){
        if (TBmenu.getSelectedRowCount()!=0) {
            DefaultTableModel model = (DefaultTableModel)TBmenu.getModel();
            int[] indexs = TBmenu.getSelectedRows();
            Object[] row = new Object[2];
            DefaultTableModel model2 = (DefaultTableModel)TBcart.getModel();
            for (int i = 0; i < indexs.length; i++) {
                row[0] = model.getValueAt(indexs[i], 0);
                row[1] = model.getValueAt(indexs[i], 1);
                model2.addRow(row);
                setTotal();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Please select item from menu that you want to add to cart.","Alert",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    void del(){
        if (TBcart.getSelectedRowCount()!=0) {
            DefaultTableModel model2 = (DefaultTableModel)TBcart.getModel();
            int[] rows = TBcart.getSelectedRows();
            for(int i=0;i<rows.length;i++){
                model2.removeRow(rows[i]-i);
            }
            setTotal();
        }
        else{
            JOptionPane.showMessageDialog(null,"Please select item from your cart that you want to remove.","Alert",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    void setTotal(){
        float total=0;
        DefaultTableModel model2 = (DefaultTableModel)TBcart.getModel();
        for (int i = 0; i < TBcart.getRowCount(); i++) {
            total += Float.parseFloat((String) model2.getValueAt(i, 1));
        }
        LBLtotal.setText(String.format("%.2f",total));
    }
    void clear(){
        DefaultTableModel model2 = (DefaultTableModel)TBcart.getModel();
        model2.setRowCount(0);
        LBLtotal.setText("0");
    }
    
    private void BTNaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNaddActionPerformed
        add();
    }//GEN-LAST:event_BTNaddActionPerformed

    private void BTNbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNbackActionPerformed
        this.setVisible(false);
        new CusMenu(user,uName,role).setVisible(true);
    }//GEN-LAST:event_BTNbackActionPerformed

    private void BTNclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNclearActionPerformed
        clear();
    }//GEN-LAST:event_BTNclearActionPerformed

    private void BTNdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNdelActionPerformed
        del();
    }//GEN-LAST:event_BTNdelActionPerformed

    private void CBcategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBcategoryItemStateChanged
        Menu m = new Menu();
        fillTable(m.getMenu(getMenuFile()));
    }//GEN-LAST:event_CBcategoryItemStateChanged

    private void TBmenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBmenuKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            add();
        }
    }//GEN-LAST:event_TBmenuKeyPressed

    private void TBcartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBcartKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_DELETE){
            del();
        }
    }//GEN-LAST:event_TBcartKeyPressed

    private void BTNorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNorderActionPerformed
        DefaultTableModel model2 = (DefaultTableModel)TBcart.getModel();
        if (model2.getRowCount()!=0) {
            ArrayList<ArrayList<String>> cart = new ArrayList<>();
            for (int i = 0; i < TBcart.getRowCount(); i++){
                ArrayList<String> row = new ArrayList<>();
                for (int j = 0; j < TBcart.getColumnCount(); j++){
                    row.add((String) model2.getValueAt(i, j));
                }
                cart.add(row);
            }
            Order o = new Order(user);
            o.registerOrder(cart, LBLtotal.getText());
            clear();
        }
        else{
            JOptionPane.showMessageDialog(null,"Please add item to your cart first before ordering.","Alert",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BTNorderActionPerformed

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
            java.util.logging.Logger.getLogger(MakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakeOrder().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNadd;
    private javax.swing.JButton BTNback;
    private javax.swing.JButton BTNclear;
    private javax.swing.JButton BTNdel;
    private javax.swing.JButton BTNorder;
    private javax.swing.JComboBox<String> CBcategory;
    private javax.swing.JLabel LBLCurrentDate;
    private javax.swing.JLabel LBLtotal;
    private javax.swing.JLabel LBLuser;
    private javax.swing.JTable TBcart;
    private javax.swing.JTable TBmenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
