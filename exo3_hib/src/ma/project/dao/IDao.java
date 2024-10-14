/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.dao;

import java.util.List;

/**
 *
 * @author ACER
 * @param <T>
 */
public interface IDao <T>{
   boolean create(T O);
   boolean update(T O);
   boolean delete(T o);
   List<T> getAll();
   T getById(int id);
    
}
