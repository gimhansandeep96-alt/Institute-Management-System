package lk.ijse.institute1.dao.custom.impl;

import db.DBconnection;
import entity.attendanceEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.institute1.dao.custom.attendanceDAO;


public class attendanceDAOImpl implements attendanceDAO {

    @Override
    public boolean save(attendanceEntity entity) throws Exception {
        String sql = "INSERT INTO attendance (schedule_id, student_id, status) VALUES(?, ?, ?)";
        Connection conn= DBconnection.getInstance().getConnection();
         PreparedStatement stm =conn.prepareStatement(sql);
        
        stm.setInt(1, entity.getScheduleId());
        stm.setInt(2, entity.getStudentId());
        stm.setString(3, entity.getStatus());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(attendanceEntity entity) throws Exception {
        String sql = "UPDATE attendance SET schedule_id=?, student_id=?, status=? WHERE attendance_id=?";
         Connection conn= DBconnection.getInstance().getConnection();
         PreparedStatement stm =conn.prepareStatement(sql);
        
        stm.setInt(1, entity.getScheduleId());
        stm.setInt(2, entity.getStudentId());
        stm.setString(3, entity.getStatus());
        stm.setInt(4, entity.getAttendanceId());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws Exception { // 👈 මෙතන 'int' සහ 'throws Exception' විය යුතුයි
        String sql = "DELETE FROM attendance WHERE attendance_id=?";
        Connection conn= DBconnection.getInstance().getConnection();
         PreparedStatement stm =conn.prepareStatement(sql);
        
        stm.setInt(1, id);
        return stm.executeUpdate() > 0;
    }

    @Override
    public ArrayList<attendanceEntity> getAll() throws Exception {
        String sql = "SELECT * FROM attendance";
         Connection conn= DBconnection.getInstance().getConnection();
         PreparedStatement stm =conn.prepareStatement(sql);
        
        ResultSet rst = stm.executeQuery();
        
        ArrayList<attendanceEntity> allAttendance = new ArrayList<>();
        while (rst.next()) {
            allAttendance.add(new attendanceEntity(
                rst.getInt("attendance_id"),
                rst.getInt("schedule_id"),
                rst.getInt("student_id"),
                rst.getString("status")
            ));
        }
        return allAttendance;
    }
}