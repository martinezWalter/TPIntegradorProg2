/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import models.CredencialAcceso;
import models.Usuario;

/**
 *
 * @author Joel_
 */

public interface CredencialAccesoService extends GenericService<CredencialAcceso>{
    
    Usuario login(String username, String passwordPlano) throws Exception;
    
    void changePassword(long userId, String passwordNuevo) throws Exception;
}