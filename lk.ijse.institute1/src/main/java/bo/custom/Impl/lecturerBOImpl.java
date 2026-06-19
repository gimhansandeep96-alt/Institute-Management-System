/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.custom.Impl;


import bo.custom.lecturerBO;
import bo.superBO;
import dto.lecturerDTO;
import entity.lecturerEntity;
import java.util.ArrayList;
import lk.ijse.institute1.dao.DAOFactory;
import lk.ijse.institute1.dao.custom.courseDAO;
import lk.ijse.institute1.dao.custom.lecturerDAO;

/**
 *
 * @author asus
 */
public class lecturerBOImpl implements lecturerBO,superBO {
 
 private final lecturerDAO lecturerDAO = (lecturerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LECTURER);
      @Override
      public boolean save(lecturerDTO dto)throws Exception {
          lecturerEntity lecturerEntity=convertlecturerDTOTolecturerEntity(dto);
          boolean rs =lecturerDAO.save(lecturerEntity);  
          return rs;
      }
      
      @Override
      public boolean update(lecturerDTO dto)throws Exception {
          lecturerEntity lecturerEntity=convertlecturerDTOTolecturerEntity(dto);
          boolean rs =lecturerDAO.update(lecturerEntity);  
          return rs;
      }
      
      @Override
      public boolean delete(int CourseId )throws Exception {
          boolean rs =lecturerDAO.delete(CourseId);  
          return rs;
      }
      
      @Override
      public java.util.ArrayList <lecturerDTO> getAllLecturers() throws Exception  {
        ArrayList<lecturerDTO> dtoList = new ArrayList<>();
        ArrayList<lecturerEntity> entityList = lecturerDAO.getAll();
        for (lecturerEntity entity : entityList) {
            dtoList.add(convertlecturerEntityTolecturerDTO(entity));
            }
            return dtoList;
      }
      
  private lecturerEntity convertlecturerDTOTolecturerEntity(lecturerDTO dto) {
        
        lecturerEntity lecturerEntity = new lecturerEntity(dto.getLecturerId(), dto.getLecturerName(), dto.getLectureremail(), dto.getLectureradress());
        return lecturerEntity;
        
    }
    
    private lecturerDTO convertlecturerEntityTolecturerDTO(lecturerEntity entity) {
        
        lecturerDTO lecturerDTO = new lecturerDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getAddress());
        return lecturerDTO;
        
    }
    
    
    
}
