/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jdomi
 */
public class Sucursal {
     int id_s;
    String nombre;

    public Sucursal(int id_s, String nombre) {
        this.id_s = id_s;
        this.nombre = nombre;
    }

    public Sucursal() {
    }

    public Sucursal(String nombre) {
        this.nombre = nombre;
    }

    
    
    public int getId_s() {
        return id_s;
    }

    public void setId_s(int id_s) {
        this.id_s = id_s;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

