/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import bo.custom.Impl.courseBOImpl;
import bo.custom.Impl.lecturerBOImpl;
import bo.custom.Impl.studentBOImpl;
import lk.ijse.institute1.dao.superDAO;

/**
 *
 * @author asus
 */
public class BOFactory {
      private static BOFactory df;
    
    public static enum BOTypes{
        COURSE,LECTURER,STUDENT
    }
  public static BOFactory getInstance(){
  return (df==null)? df= new BOFactory():df ;
  
  }
    
public superBO getBO(BOTypes type) {
    switch (type) {
        
        case COURSE:
            return new courseBOImpl();
            
        case LECTURER:
            return new lecturerBOImpl();
            
        case STUDENT:
            return new studentBOImpl();
            
        default:
            return null;
    }
}
    
    
    
}
