/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bo.custom;

import bo.superBO;
import dto.attendanceDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public interface attendanceBO extends superBO {
   boolean saveAttendance(attendanceDTO dto) throws Exception;
    boolean updateAttendance(attendanceDTO dto) throws Exception;
    boolean deleteAttendance(int id) throws Exception;
    ArrayList<attendanceDTO> getAllAttendance() throws Exception;
}

