/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.institute1.dao;

/**
 *
 * @author asus
 */
public interface crudDAO<T> extends superDAO {
     public boolean save(T Entity)throws Exception;
     public boolean update(T Entity)throws Exception ;       
     public boolean delete(int id )throws Exception;
     public java.util.ArrayList<T> getAll() throws Exception;
             
}
