/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.institute1.dao.custom.impl;

import db.DBconnection;
import dto.courseDTO;
import entity.courseEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.ijse.institute1.dao.custom.courseDAO;
/**
 *
 * @author asus
 */
public class courseDAOImpl implements courseDAO {
  @Override 
  public boolean save(courseEntity Entity)throws Exception{
  Connection conn= DBconnection.getInstance().getConnection();
  if(conn!=null){
      String sql ="INSERT INTO COURSE (course_id, course_name, duration,price)VALUES(?,?,?,?)";
      
      PreparedStatement stm =conn.prepareStatement(sql);
      
      stm.setInt(1, Entity.getCourse_id());
      stm.setString(2, Entity.getCourse_name());
      stm.setString(3, Entity.getDuration());
      stm.setDouble(4, Entity.getPrice());
      
      int result =stm.executeUpdate();
      return result>0;
  }
  return false;
 }
  @Override
  public boolean update(courseEntity Entity)throws Exception{
      boolean rs=false;
      Connection conn= DBconnection.getInstance().getConnection();
    if(conn!=null){
        String sql ="UPDATE course SET course_name=?, duration=?, price=? WHERE course_id=?";
        
         PreparedStatement stm =conn.prepareStatement(sql);
      
        stm.setString(1,Entity.getCourse_name());
        stm.setString(2,Entity.getDuration());
        stm.setDouble(3,Entity.getPrice());
        stm.setInt(4,Entity.getCourse_id());
        
        int result =stm.executeUpdate();
        rs =result>0;
     }
  return rs;
  }

  @Override
  public boolean delete(int CourseId )throws Exception{
      boolean rs=false;
      Connection conn= DBconnection.getInstance().getConnection();
      
  if(conn!=null){
        String sql ="DELETE FROM course WHERE course_id=?";
        PreparedStatement stm =conn.prepareStatement(sql);
        stm.setInt(1,CourseId);
        int result =stm.executeUpdate();
        rs =result>0;}
  
  return rs;
 
  }
  @Override
  public java.util.ArrayList<courseEntity> getAll() throws Exception {
    Connection conn = DBconnection.getInstance().getConnection();
    java.util.ArrayList<courseEntity> allCourses = new java.util.ArrayList<>();

    if (conn != null) {
    String sql = "SELECT * FROM course"; 
    PreparedStatement stm = conn.prepareStatement(sql);
    ResultSet rst = stm.executeQuery();

    while (rst.next()) {
            courseEntity entity = new courseEntity(
                rst.getInt("course_id"),      
                rst.getString("course_name"),   
                rst.getString("duration"),
                rst.getDouble("price")
            );
            allCourses.add(entity);
        }
    }
    return allCourses;
}



  
  
  
  
  
  
  
  
  
  
  
  
}
