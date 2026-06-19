/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.institute1.dao;

import lk.ijse.institute1.dao.custom.impl.classsheduleDAOImpl;
import lk.ijse.institute1.dao.custom.impl.lecturerDAOImpl;
import lk.ijse.institute1.dao.custom.impl.studentDAOImpl;
import lk.ijse.institute1.dao.custom.impl.courseDAOImpl;

/**
 *
 * @author asus
 */
public class DAOFactory {
    
    private static DAOFactory df;
    
    public static enum DAOTypes{
        COURSE,LECTURER,STUDENT,SHEDULE,//ATTENDANCE
    }
  public static DAOFactory getInstance(){
  return (df==null)? df= new DAOFactory():df ;
  
  }
    
public superDAO getDAO(DAOTypes type) {
    switch (type) {
        
        case COURSE:
            return new courseDAOImpl();
            
        case LECTURER:
            return new lecturerDAOImpl();
            
        case STUDENT:
            return new studentDAOImpl();
        case SHEDULE:
            return new classsheduleDAOImpl();
            
        //case ATTENDANCE:
            
            //return new courseBOImpl();
            
        default:
            return null;
    }
}
 
 
 
 }
    
    
    
    
    
    
    
    
    
    
    

