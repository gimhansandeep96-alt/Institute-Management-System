/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bo.custom;

import bo.superBO;
import dto.studentDTO;
import entity.studentEntity;

/**
 *
 * @author asus
 */
public interface studentBO extends superBO {
   public boolean save(studentDTO dto)throws Exception ;
   public boolean update(studentDTO dto)throws Exception;
   public boolean delete(int Id )throws Exception ;
   public java.util.ArrayList<studentDTO> getAll() throws Exception ;
       
       
           
       
       
}

