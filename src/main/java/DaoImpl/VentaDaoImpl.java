/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Config.Conexion;
import Dao.VentaDao;
import Model.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jdomi
 */
public class VentaDaoImpl implements VentaDao {

    Connection cx;
    ResultSet rs;
    PreparedStatement pst;
    int d;

    @Override
    public List<HashMap<String, Object>> listar() {
        List<HashMap<String, Object>> mapa = new ArrayList<>();
        String consulta = "select  v.id_v,s.nombre as 'sucursal', concat(c.nombre,' ',c.apellidos) 'cliente',v.fecha, v.tipo_doc "
                + "from venta v inner join sucursal s on v.id_s = s.id_s "
                + "inner join cliente c on v.id_c = c.id_c;";
        try {
            cx = Conexion.getConexion();
            pst = cx.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                HashMap<String, Object> lista = new HashMap<>();
                lista.put("id_v", rs.getInt("id_v"));
                lista.put("sucursal", rs.getString("sucursal"));
                lista.put("cliente", rs.getString("cliente"));
                lista.put("fecha", rs.getString("fecha"));
                lista.put("tipo_doc", rs.getString("tipo_doc"));
                mapa.add(lista);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return mapa;
    }

    @Override
    public int insertar(Venta v) {
        String consulta = "insert into venta (id_s,id_c,fecha,tipo_doc)values(?,?,?,?);";
        try {
            cx = Conexion.getConexion();
            pst = cx.prepareStatement(consulta);
            pst.setInt(1, v.getId_s());
            pst.setInt(2, v.getId_c());
            pst.setString(3, v.getFecha());
            pst.setString(4, v.getTipo_doc());
            d = pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return d;
    }

    @Override
    public int eliminar(int id_v) {
        String consulta = "delete from venta where id_v = ?;";
        try {
            cx = Conexion.getConexion();
            pst = cx.prepareStatement(consulta);
            pst.setInt(1, id_v);
            d = pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return d;
    }

}
