/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.custom.Impl;

import bo.custom.courseBO;
import bo.superBO;
import dto.courseDTO;
import entity.courseEntity;
import java.util.ArrayList;
import lk.ijse.institute1.dao.DAOFactory;
import lk.ijse.institute1.dao.custom.courseDAO;


/**
 *
 * @author asus
 */
public class courseBOImpl implements courseBO,superBO {
    
    private final courseDAO courseDAO = (courseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);
      public boolean save(courseDTO dto)throws Exception {
          courseEntity courseEntity=convertcourseDTOTocourseEntity(dto);
          boolean rs =courseDAO.save(courseEntity);  
          return rs;
      }
      
      
      public boolean update(courseDTO dto)throws Exception {
          courseEntity courseEntity=convertcourseDTOTocourseEntity(dto);
          boolean rs =courseDAO.update(courseEntity);  
          return rs;
      }
      
      
      public boolean delete(int CourseId )throws Exception {
          boolean rs =courseDAO.delete(CourseId);  
          return rs;
      }
      public java.util.ArrayList <courseDTO> getAll() throws Exception  {
        ArrayList<courseDTO> dtoList = new ArrayList<>();
        ArrayList<courseEntity> entityList = courseDAO.getAll();
        for (courseEntity entity : entityList) {
            dtoList.add(convertcourseEntityTocourseDTO(entity));
            }
            return dtoList;
      }
      
  private courseEntity convertcourseDTOTocourseEntity(courseDTO dto) {
        
        courseEntity courseEntity = new courseEntity(dto.getCourseId(), dto.getCourseName(), dto.getDuration(), dto.getPrice());
        return courseEntity;
        
    }
    
    private courseDTO convertcourseEntityTocourseDTO(courseEntity entity) {
        
        courseDTO courseEntity = new courseDTO(entity.getCourse_id(), entity.getCourse_name(), entity.getDuration(), entity.getPrice());
        return courseEntity;
        
    }
    



}
