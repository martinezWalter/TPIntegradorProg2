/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import models.CredencialAcceso;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Joel_
 */


// Esta interfaz esta pensada para metodos propios de la case Credencial. Podríamos haber usado la interfaz generica
// e implementar el metodo tambien en Usuario, pero es poco escalable en un futuro, si agregamos inventarios, productos, etc.
// no todos van a implementar si o si el metodo.

public interface CredencialAccesoDAO extends GenericDAO<CredencialAcceso>{
    
    List<CredencialAcceso> findByUsername(String filtro) throws SQLException;
    
    CredencialAcceso findByExactUsername(String username) throws SQLException;
    
    void insert(Connection conn, CredencialAcceso entidad) throws SQLException;
    
}