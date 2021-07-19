/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Venta;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jdomi
 */
public interface VentaDao {
    List<HashMap<String,Object>> listar();
    int insertar(Venta v);
    int eliminar(int id_v);
}
