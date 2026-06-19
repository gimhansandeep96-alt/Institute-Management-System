/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bo.custom;

import bo.superBO;
import dto.sheduleDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public interface classsheduleBO extends superBO {
   public boolean saveSchedule(sheduleDTO dto) throws SQLException, ClassNotFoundException;
   public boolean deleteSchedule(String id) throws SQLException, ClassNotFoundException;
   public boolean updateSchedule(sheduleDTO dto) throws SQLException, ClassNotFoundException;
   ArrayList<sheduleDTO> getAllSchedules() throws SQLException, ClassNotFoundException;
    
   
    
}
