/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.custom.Impl;

import bo.custom.attendanceBO;
import dto.attendanceDTO;
import entity.attendanceEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.institute1.dao.DAOFactory;
import lk.ijse.institute1.dao.custom.attendanceDAO;

/**
 *
 * @author asus
 */
public class attendancrBOImpl implements attendanceBO{
    
   private final attendanceDAO attendanceDAO = (attendanceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ATTENDANCE);


    @Override
    public boolean saveAttendance(attendanceDTO dto) throws Exception {
        return attendanceDAO.save(new attendanceEntity(
            dto.getAttendanceId(),
            dto.getScheduleId(),
            dto.getStudentId(),
            dto.getStatus()
        ));
    }

    @Override
    public boolean updateAttendance(attendanceDTO dto) throws Exception {
        return attendanceDAO.update(new attendanceEntity(
            dto.getAttendanceId(),
            dto.getScheduleId(),
            dto.getStudentId(),
            dto.getStatus()
        ));
    }

    @Override
    public boolean deleteAttendance(int id) throws Exception {
        return attendanceDAO.delete(id);
    }

    @Override
    public ArrayList<attendanceDTO> getAllAttendance() throws Exception {
        ArrayList<attendanceEntity> allEntity = attendanceDAO.getAll();
        ArrayList<attendanceDTO> allDTO = new ArrayList<>();
        for (attendanceEntity entity : allEntity) {
            allDTO.add(new attendanceDTO(
                entity.getAttendanceId(),
                entity.getScheduleId(),
                entity.getStudentId(),
                entity.getStatus()
            ));
        }
        return allDTO;
    }
    
}
