/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.institute1.dao;

import db.DBconnection;
import entity.lecturerEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author asus
 */
public class lecturerDAOImpl {
    public boolean save(lecturerEntity Entity)throws Exception{
  Connection conn= DBconnection.getInstance().getConnection();
  if(conn!=null){
      String sql ="INSERT INTO lecturer (id, name, email,address)VALUES(?,?,?,?)";
      
      PreparedStatement stm =conn.prepareStatement(sql);
      
      stm.setInt(1, Entity.getId());
      stm.setString(2, Entity.getName());
      stm.setString(3, Entity.getEmail());
      stm.setString(4, Entity.getAddress());
      
      int result =stm.executeUpdate();
      return result>0;
  }
  return false;
 }

  public boolean update(lecturerEntity Entity)throws Exception{
      boolean rs=false;
      Connection conn= DBconnection.getInstance().getConnection();
    if(conn!=null){
        String sql ="UPDATE lecturer SET name=?, email=?, address=? WHERE id=?";
        
         PreparedStatement stm =conn.prepareStatement(sql);
      
      stm.setString(1, Entity.getName());
      stm.setString(2, Entity.getEmail());
      stm.setString(3, Entity.getAddress());
      stm.setInt(4, Entity.getId());
        
        int result =stm.executeUpdate();
        rs =result>0;
     }
  return rs;
  }


  public boolean delete(int id )throws Exception{
      boolean rs=false;
      Connection conn= DBconnection.getInstance().getConnection();
      
  if(conn!=null){
        String sql ="DELETE FROM lecturer WHERE id=?";
        PreparedStatement stm =conn.prepareStatement(sql);
        stm.setInt(1,id);
        int result =stm.executeUpdate();
        rs =result>0;}
  
  return rs;
 
  }

public java.util.ArrayList<lecturerEntity> getAll() throws Exception {
    Connection conn = DBconnection.getInstance().getConnection();
    java.util.ArrayList<lecturerEntity> alllecturers = new java.util.ArrayList<>();

    if (conn != null) {
    String sql = "SELECT * FROM lecturer"; 
    PreparedStatement stm = conn.prepareStatement(sql);
    ResultSet rst = stm.executeQuery();

    while (rst.next()) {
            lecturerEntity entity = new lecturerEntity(
                rst.getInt("id"),      
                rst.getString("name"),   
                rst.getString("email"),
                rst.getString("address")
            );
            alllecturers.add(entity);
        }
    }
    return alllecturers;
}



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
