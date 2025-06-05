/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.nhanvien;
import service.DBconnect;
/**
 *
 * @author ADMIN
 */
public class nhanvienDAO {
    public List<nhanvien> GETALL() {
        List<nhanvien> listnv = new ArrayList<>();
        String sql = "SELECT * FROM QLNV";
        try (Connection con = DBconnect.getConnection();
     Statement stm = con.createStatement();
     ResultSet rs = stm.executeQuery(sql)) {

    while (rs.next()) {
        nhanvien nv = new nhanvien();
        nv.setId(rs.getString(1));
        nv.setUsername(rs.getString(2));
        nv.setPass(rs.getString(3));
        nv.setChucvu(rs.getString(4));
        listnv.add(nv);
    }

} catch (Exception e) {
    System.out.println("Lỗi: " + e.getMessage());
}
        return listnv;
    }
    public Object GETROW( nhanvien nv){
        String id = nv.getId();
        String username = nv.getUsername();
        String password = nv.getPass();
        String chucvu = nv.getChucvu();
        Object[] row = new Object[]{id, username, password, chucvu};
        return row;
    }
    
public int addnv(nhanvien nv){
        String sql ="insert into QLNV values(?,?,?,?)";
        Connection con = DBconnect.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, nv.getId());
            pstm.setString(2, nv.getUsername());
            pstm.setString(3, nv.getPass());
            pstm.setString(4, nv.getChucvu());
            
            if(pstm.executeLargeUpdate()>0){
                System.out.println("Thêm tài khoản nhân viên mới thành công!");
                return 1;
            }
        } catch (Exception e) {
            
        }
        return 0;


        
        
        
        
        
        
    }
    public int Updatenv(String id, nhanvien nv){
        String sql ="update QLNV set ID = ?,USERNAME =?,PASS =?,CHUCVU =? where ID= ? ";
        Connection con = DBconnect.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, nv.getId());
            pstm.setString(2, nv.getUsername());
            pstm.setString(3, nv.getPass());
            pstm.setString(4, nv.getChucvu());
            pstm.setString(5, id);
            if(pstm.executeLargeUpdate()>0){
                System.out.println("Sửa tài khoản nhân viên thành công!");
                return 1;
            }
        } catch (Exception e) {
            
        }
        return 0;
        
    }
    public int Deletenv(String id){
          String sql ="DELETE FROM QLNV WHERE ID LIKE ?";
        Connection con = DBconnect.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
              pstm.setString(1, id);
            
            if(pstm.executeLargeUpdate()>0){
                System.out.println("Xóa tài khoản nhân viên thành công thành công!");
                return 1;
            }
        } catch (Exception e) {
            
        }
        return 0;
    }
}

