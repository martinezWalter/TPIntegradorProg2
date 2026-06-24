/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author Joel_
 */

public interface GenericService<T>{
    
    void insert(T entidad) throws Exception;
    
    void update(T entidad) throws Exception;
    
    void delete(long id) throws Exception;

    T findById(long id) throws Exception;

    List<T> findByAll() throws Exception;
    
}