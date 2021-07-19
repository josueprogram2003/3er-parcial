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
public class Venta {

    int id_s;
    int id_c;
    int id_v;
    String fecha;
    String tipo_doc;

    public Venta(int id_s, int id_c, int id_v, String fecha, String tipo_doc) {
        this.id_s = id_s;
        this.id_c = id_c;
        this.id_v = id_v;
        this.fecha = fecha;
        this.tipo_doc = tipo_doc;
    }

    public Venta() {
    }

    public Venta(int id_s, int id_c, String fecha, String tipo_doc) {
        this.id_s = id_s;
        this.id_c = id_c;
        this.fecha = fecha;
        this.tipo_doc = tipo_doc;
    }
    
    

    public int getId_s() {
        return id_s;
    }

    public void setId_s(int id_s) {
        this.id_s = id_s;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public int getId_v() {
        return id_v;
    }

    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }
    
    
}
