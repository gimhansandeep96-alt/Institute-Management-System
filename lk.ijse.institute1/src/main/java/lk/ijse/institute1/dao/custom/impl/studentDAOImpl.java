/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.institute1.dao.custom.impl;

import db.DBconnection;
import entity.studentEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.ijse.institute1.dao.custom.studentDAO;

/**
 *
 * @author asus
 */
public class studentDAOImpl implements studentDAO{
  @Override
  public boolean save(studentEntity Entity)throws Exception{
  Connection conn= DBconnection.getInstance().getConnection();
  if(conn!=null){
      String sql ="INSERT INTO student (student_id, student_name, email,adress)VALUES(?,?,?,?)";
      
      PreparedStatement stm =conn.prepareStatement(sql);
      
      stm.setInt(1, Entity.getStudent_id());
      stm.setString(2, Entity.getStudent_name());
      stm.setString(3, Entity.getEmail());
      stm.setString(4, Entity.getAdress());
      
      int result =stm.executeUpdate();
      return result>0;
  }
  return false;
 }
  @Override
  public boolean update(studentEntity Entity)throws Exception{
      boolean rs=false;
      Connection conn= DBconnection.getInstance().getConnection();
    if(conn!=null){
        String sql ="UPDATE student SET student_name=?, email=?, adress=? WHERE student_id=?";
        
         PreparedStatement stm =conn.prepareStatement(sql);
      
      stm.setString(1, Entity.getStudent_name());
      stm.setString(2, Entity.getEmail());
      stm.setString(3, Entity.getAdress());
      stm.setInt(4, Entity.getStudent_id());
        
        int result =stm.executeUpdate();
        rs =result>0;
     }
  return rs;
  }

  @Override
  public boolean delete(int id )throws Exception{
      boolean rs=false;
      Connection conn= DBconnection.getInstance().getConnection();
      
  if(conn!=null){
        String sql ="DELETE FROM student WHERE student_id=?";
        PreparedStatement stm =conn.prepareStatement(sql);
        stm.setInt(1,id);
        int result =stm.executeUpdate();
        rs =result>0;}
  
  return rs;
 
  }
  @Override
  public java.util.ArrayList<studentEntity> getAll() throws Exception {
    Connection conn = DBconnection.getInstance().getConnection();
    java.util.ArrayList<studentEntity> allstudent = new java.util.ArrayList<>();

    if (conn != null) {
    String sql = "SELECT * FROM student"; 
    PreparedStatement stm = conn.prepareStatement(sql);
    ResultSet rst = stm.executeQuery();

    while (rst.next()) {
            studentEntity entity = new studentEntity(
                rst.getInt("student_id"),      
                rst.getString("student_name"),   
                rst.getString("email"),
                rst.getString("adress")
            );
            allstudent.add(entity);
        }
    }
    return allstudent;
}

    
    
    
    
    
    
    
    
    
    
    
    
    
}
