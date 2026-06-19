/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bo.custom;

import bo.superBO;
import dto.courseDTO;
import entity.courseEntity;

/**
 *
 * @author asus
 */
public interface courseBO extends superBO{
    public boolean save(courseDTO dto)throws Exception ;
   public boolean update(courseDTO dto)throws Exception;
   public boolean delete(int Id )throws Exception ;
   public java.util.ArrayList<courseDTO> getAll() throws Exception ;
       
       
}
