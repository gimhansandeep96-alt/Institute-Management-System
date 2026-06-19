/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.custom.Impl;



import bo.custom.studentBO;
import bo.superBO;
import dto.studentDTO;
import entity.studentEntity;
import java.util.ArrayList;
import lk.ijse.institute1.dao.DAOFactory;
import lk.ijse.institute1.dao.custom.studentDAO;

/**
 *
 * @author asus
 */
public class studentBOImpl implements studentBO,superBO {
    
    private final studentDAO studentDAO = (studentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    
     @Override
     public boolean save(studentDTO dto)throws Exception {
          studentEntity lecturerEntity=convertstudentDTOTostudentEntity(dto);
          boolean rs =studentDAO.save(lecturerEntity);  
          return rs;
      }
      
      @Override
      public boolean update(studentDTO dto)throws Exception {
          studentEntity lecturerEntity=convertstudentDTOTostudentEntity(dto);
          boolean rs =studentDAO.update(lecturerEntity);  
          return rs;
      }
      
      @Override
      public boolean delete(int CourseId )throws Exception {
          boolean rs =studentDAO.delete(CourseId);  
          return rs;
      }
      @Override
      public java.util.ArrayList <studentDTO> getAll() throws Exception  {
        ArrayList<studentDTO> dtoList = new ArrayList<>();
        ArrayList<studentEntity> entityList = studentDAO.getAll();
        for (studentEntity entity : entityList) {
            dtoList.add(convertstudentEntityTolecturerDTO(entity));
            }
            return dtoList;
      }
      
  private studentEntity convertstudentDTOTostudentEntity(studentDTO dto) {
        
        studentEntity studentEntity = new studentEntity(dto.getStudentId(), dto.getStudentName(), dto.getStudentemail(), dto.getStudentadress());
        return studentEntity;
        
    }
    
    private studentDTO convertstudentEntityTolecturerDTO(studentEntity entity) {
        
        studentDTO studentDTO = new studentDTO(entity.getStudent_id(), entity.getStudent_name(), entity.getEmail(), entity.getAdress());
        return studentDTO;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
