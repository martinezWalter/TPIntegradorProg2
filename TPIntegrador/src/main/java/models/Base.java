/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Joel_
 */

public abstract class Base {
    private long id;
    private boolean eliminado;

    public Base(long id, boolean eliminado) {
        this.id = id;
        this.eliminado = eliminado;
    }
    
    // constructor de una persona vacia
    // id generado por db
    // por defecto, no estan eliminadas
    protected Base() {
        this.eliminado = false;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
}