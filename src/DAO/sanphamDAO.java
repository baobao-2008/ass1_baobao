/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.sanpham;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import service.DBconnect;

/**
 *
 * @author ADMIN
 */
public class sanphamDAO {

    public List<sanpham> GETALL() {
        List<sanpham> listsp = new ArrayList<>();
        String sql = "select * from sanpham";
        try (Connection con = DBconnect.getConnection();
     Statement stm = con.createStatement();
     ResultSet rs = stm.executeQuery(sql)) {

    while (rs.next()) {
        sanpham sp = new sanpham();
        sp.setMaSP(rs.getString(1));
        sp.setTenSP(rs.getNString(2));
        sp.setGiaSP(rs.getFloat(3));
        sp.setTinhTrang(rs.getNString(4));
        sp.setGhiChu(rs.getNString(5));
        listsp.add(sp);
    }

} catch (Exception e) {
    System.out.println("Lỗi: " + e.getMessage());
}
        return listsp;
    }
    public Object GETROW(sanpham sp){
        String maSP = sp.getMaSP();
        String tenSP = sp.getTenSP();
        int giaSP =  (int) sp.getGiaSP();
        String tinhTrang = sp.getTinhTrang();
        String ghiChu = sp.getGhiChu();
        Object[] row = new Object[]{maSP,tenSP, giaSP, tinhTrang, ghiChu};
        return row;
    }
    
        public int addsp(sanpham sp){
        String sql ="insert into sanpham values(?,?,?,?,?)";
        Connection con = DBconnect.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, sp.getMaSP());
            pstm.setString(2, sp.getTenSP());
            pstm.setFloat(3, sp.getGiaSP());
            pstm.setString(4, sp.getTinhTrang());
            pstm.setString(5, sp.getGhiChu());
            
            if(pstm.executeLargeUpdate()>0){
                System.out.println("Thêm sản phẩm mới thành công!");
                return 1;
            }
        } catch (Exception e) {
            
        }
        return 0;


        
        
    }
    public int Updatesp(String masp, sanpham sp){
        String sql ="update SanPham set MASP=?, TENSP=?, GIASP=?"
                + ", TINHTRANG=?, GHICHU=? where MASP= ?";
        Connection con = DBconnect.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, sp.getMaSP());
            pstm.setString(2, sp.getTenSP());
            pstm.setFloat(3, sp.getGiaSP());
            pstm.setString(4, sp.getTinhTrang());
            pstm.setString(5, sp.getGhiChu());
            pstm.setString(6, masp);
            if(pstm.executeLargeUpdate()>0){
                System.out.println("Sửa sản phẩm mới thành công!");
                return 1;
            }
        } catch (Exception e) {
            
        }
        return 0;
        
    }
    public int Deletesp(String masp){
          String sql ="DELETE FROM sanpham WHERE MASP LIKE ?";
        Connection con = DBconnect.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
              pstm.setString(1, masp);
            
            if(pstm.executeLargeUpdate()>0){
                System.out.println("Xóa sản phẩm thành công thành công!");
                return 1;
            }
        } catch (Exception e) {
            
        }
        return 0;
    }
}
