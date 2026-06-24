/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import models.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Joel_
 */

public interface UsuarioDAO extends GenericDAO<Usuario>{
    
    void insert(Connection conn, Usuario user) throws SQLException;
    
    Usuario findByEmail(String email) throws SQLException;
    
    void restore(Connection conn, long id) throws SQLException;
    
    void restore(long id) throws SQLException;
}