/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.institute1.dao.custom.impl;

import db.DBconnection;
import entity.sheduleEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.institute1.dao.custom.classsheduleDAO;

/**
 *
 * @author asus
 */
public class classsheduleDAOImpl implements classsheduleDAO {
    @Override
    public boolean save(sheduleEntity entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO class_schedule VALUES(?, ?, ?, ?, ?, ?)";
        
         Connection conn= DBconnection.getInstance().getConnection();
         PreparedStatement stm =conn.prepareStatement(sql);
        
        stm.setString(1, entity.getScheduleId());
        stm.setInt(2, entity.getCourseId());       
        stm.setInt(3, entity.getLecturerId());     
        stm.setString(4, entity.getSubjectName());
        stm.setObject(5, entity.getDate()); 
        stm.setString(6, entity.getTime());
        
        return stm.executeUpdate() > 0;
    }
    
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
    String sql = "DELETE FROM class_schedule WHERE schedule_id=?";
     Connection conn= DBconnection.getInstance().getConnection();
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, id);
    return pstm.executeUpdate() > 0;
}
    
    
    @Override
public boolean update(sheduleEntity entity) throws SQLException, ClassNotFoundException {
    String sql = "UPDATE class_schedule SET course_id=?, lecturer_id=?, subject_name=?, class_date=?, time_slot=? WHERE schedule_id=?";
    Connection conn= DBconnection.getInstance().getConnection();
    PreparedStatement pstm = conn.prepareStatement(sql);
    
    pstm.setInt(1, entity.getCourseId());
    pstm.setInt(2, entity.getLecturerId());
    pstm.setString(3, entity.getSubjectName());
    pstm.setObject(4, entity.getDate());
    pstm.setString(5, entity.getTime());
    pstm.setString(6, entity.getScheduleId());
    
    return pstm.executeUpdate() > 0;
}

    @Override
    public ArrayList<sheduleEntity> getAll() throws SQLException, ClassNotFoundException {
    String sql = "SELECT * FROM class_schedule";
     Connection conn= DBconnection.getInstance().getConnection();
         PreparedStatement stm =conn.prepareStatement(sql);
        
    ResultSet rst = stm.executeQuery();

    ArrayList<sheduleEntity> allSchedules = new ArrayList<>();

    while (rst.next()) {
        sheduleEntity entity = new sheduleEntity(
            rst.getString(1), 
            rst.getInt(2),    
            rst.getInt(3),    
            rst.getString(4), 
            rst.getDate(5).toLocalDate(), 
            rst.getString(6)  
        );
        allSchedules.add(entity);
    }
    return allSchedules;
}

}
    

