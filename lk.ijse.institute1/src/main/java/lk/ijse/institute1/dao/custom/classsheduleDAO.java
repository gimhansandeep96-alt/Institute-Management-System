/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.institute1.dao.custom;

import entity.sheduleEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.institute1.dao.superDAO;

/**
 *
 * @author asus
 */
public interface classsheduleDAO extends superDAO {
       
     public boolean save(sheduleEntity entity) throws SQLException, ClassNotFoundException ;
     public boolean delete(String id) throws SQLException, ClassNotFoundException;
     public boolean update(sheduleEntity entity) throws SQLException, ClassNotFoundException;
     ArrayList<sheduleEntity> getAll() throws SQLException, ClassNotFoundException;
    
    
}
