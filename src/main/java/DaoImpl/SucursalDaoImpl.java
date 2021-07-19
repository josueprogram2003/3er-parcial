/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Config.Conexion;
import Dao.SucursalDao;
import Model.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jdomi
 */
public class SucursalDaoImpl implements SucursalDao {

    Connection cx;
    ResultSet rs;
    PreparedStatement pst;

    @Override
    public List<Sucursal> listar() {
        List<Sucursal> lista = new ArrayList<>();
        String consulta = "select * from sucursal;";
        try {
            cx = Conexion.getConexion();
            pst = cx.prepareStatement(consulta);
            rs=pst.executeQuery();
            while (rs.next()) {                
                Sucursal s = new Sucursal();
                s.setId_s(rs.getInt("id_s"));
                s.setNombre(rs.getString("nombre"));
                lista.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }

}
