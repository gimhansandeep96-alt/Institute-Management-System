/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.custom.Impl;

import bo.custom.classsheduleBO;
import dto.sheduleDTO;
import entity.sheduleEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.institute1.dao.DAOFactory;
import static lk.ijse.institute1.dao.DAOFactory.DAOTypes.SHEDULE;
import lk.ijse.institute1.dao.custom.classsheduleDAO;

/**
 *
 * @author asus
 */
public class classsheduleBOImpl implements classsheduleBO {
     private final classsheduleDAO classsheduleDAO = (classsheduleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SHEDULE);
    
    @Override
    public boolean saveSchedule(sheduleDTO dto) throws SQLException, ClassNotFoundException{
        sheduleEntity entity = new sheduleEntity(
        dto.getScheduleId(),
        dto.getCourseId(),     
        dto.getLecturerId(),
        dto.getSubjectName(),
        dto.getDate(),
        dto.getTime()
    );

    return classsheduleDAO.save(entity);
        }
    
    @Override
    public boolean deleteSchedule(String id) throws SQLException, ClassNotFoundException {
    return classsheduleDAO.delete(id);
}

    @Override
    public boolean updateSchedule(sheduleDTO dto) throws SQLException, ClassNotFoundException {
    return classsheduleDAO.update(new sheduleEntity(
        dto.getScheduleId(),
        dto.getCourseId(),
        dto.getLecturerId(),
        dto.getSubjectName(),
        dto.getDate(),
        dto.getTime()
    ));
}
    @Override
    public ArrayList<sheduleDTO> getAllSchedules() throws SQLException, ClassNotFoundException {
    ArrayList<sheduleEntity> entityList = classsheduleDAO.getAll();
    ArrayList<sheduleDTO> dtoList = new ArrayList<>();

    for (sheduleEntity entity : entityList) {
        dtoList.add(new sheduleDTO(
            entity.getScheduleId(),
            entity.getCourseId(),
            entity.getLecturerId(),
            entity.getSubjectName(),
            entity.getDate(),
            entity.getTime()
        ));
    }
    return dtoList;
}
    }
    
    
    
    
    
    
    
    
    
    

