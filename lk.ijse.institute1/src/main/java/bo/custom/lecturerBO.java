/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bo.custom;

import bo.superBO;
import dto.lecturerDTO;
import entity.lecturerEntity;

/**
 *
 * @author asus
 */
public interface lecturerBO extends superBO {
   public boolean save(lecturerDTO dto)throws Exception ;
   public boolean update(lecturerDTO dto)throws Exception;
   public boolean delete(int Id )throws Exception ;
   public java.util.ArrayList<lecturerDTO> getAllLecturers() throws Exception ;
       
       
}
