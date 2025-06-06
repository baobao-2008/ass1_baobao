/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.sanphamDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.sanpham;

/**
 *
 * @author ADMIN
 */
public class menu extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    sanphamDAO spd = new sanphamDAO();
    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        intitTable();
        fillTable();
    }
    public void intitTable(){
        tableModel= new DefaultTableModel();
        String[] cols = new String []{"Mã sản phẩm","Tên sản phẩm", "Giá sản phẩm","Tình trạng", "Ghi chú"};
            tableModel.setColumnIdentifiers(cols);
            tblBang.setModel(tableModel);
    }
    public void fillTable(){
        tableModel.setRowCount(0);
    for (sanpham x : spd.GETALL()) {
       Object[] rows =  (Object[]) spd.GETROW(x);
       tableModel.addRow(rows);
    }
    }
    public void Add(){
        String MaSP = txtMaSP.getText();
        String TenSP = txtTenSP.getText();
        float giaSP = Float.parseFloat(txtGiaSP.getText());
        String tinhTrang = rdoCon.isSelected()?"CÒN":"HẾT";
        String ghichu = txtGhiChu.getText();
        sanpham sp = new sanpham(MaSP, TenSP, giaSP, tinhTrang, ghichu);
    int result = spd.addsp(sp);
    if( result==1){
        fillTable();
        JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
    }else{
        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra");
    }
    }
    public void Update(){
        int chon = tblBang.getSelectedRow();
        if(chon>=0){
            int sua = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa không", "Xác nhận", JOptionPane.YES_NO_OPTION);
     if(sua==JOptionPane.YES_OPTION){
    String MaSP = txtMaSP.getText();
        String TenSP = txtTenSP.getText();
        float giaSP = Float.parseFloat(txtGiaSP.getText());
        String tinhTrang = rdoCon.isSelected()?"CÒN":"HẾT";
        sanpham sp = new sanpham(MaSP, TenSP, giaSP, tinhTrang, TenSP);
    int result = spd.Updatesp(MaSP, sp);
    if( result==1){
        fillTable();
        JOptionPane.showMessageDialog(this, "Sửa thành công");
    }else{
        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra");
    }
     }
        }
    }
    public void Delete(){
        int chon = tblBang.getSelectedRow();
        if(chon>=0){
            int xoa = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa không", "Xác nhận", JOptionPane.YES_NO_OPTION);
     if(xoa==JOptionPane.YES_OPTION){
    String MaSP = txtMaSP.getText();
    int result = spd.Deletesp(MaSP);
    if( result==1){
        fillTable();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
    }else{
        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra");
    }
     }
        }
    }
    public void Reset(){
        txtGhiChu.setText(null);
        txtGiaSP.setText(null);
        txtMaSP.setText(null);
        txtTenSP.setText(null);
        buttonGroup1.clearSelection();
    }
    public void nhanbang(){
        int chon = tblBang.getSelectedRow();
        if(chon>=0){
            sanpham sp = spd.GETALL().get(chon);
            txtMaSP.setText(sp.getMaSP());
            txtTenSP.setText(sp.getTenSP());
            txtGiaSP.setText(String.valueOf(sp.getGiaSP()));
            if(sp.getTinhTrang().equals("CÒN")){
                rdoCon.setSelected(true);
            }else{
                rdoHet.setSelected(true);
            }
            txtGhiChu.setText(sp.getGhiChu());
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtGiaSP = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        rdoCon = new javax.swing.JRadioButton();
        rdoHet = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã sản phẩm");

        jLabel2.setText("Tên sản phẩm");

        jLabel4.setText("Giá sản phẩm");

        jLabel5.setText("Tình trạng");

        jLabel6.setText("Ghi chú");

        buttonGroup1.add(rdoCon);
        rdoCon.setText("CÒN");
        rdoCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoConActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHet);
        rdoHet.setText("HẾT");

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setText("Quản lý sản phẩm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(txtGhiChu))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(rdoCon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                                .addComponent(rdoHet)
                                .addGap(74, 74, 74))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSP)
                            .addComponent(txtMaSP)
                            .addComponent(txtGiaSP))))
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnReset))
                .addGap(196, 196, 196))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel7)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtGiaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnReset))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(rdoCon)
                                    .addComponent(rdoHet))))))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoConActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        Update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        Delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        // TODO add your handling code here:
        nhanbang();
    }//GEN-LAST:event_tblBangMouseClicked

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoCon;
    private javax.swing.JRadioButton rdoHet;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGiaSP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
