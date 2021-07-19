/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Config.Conexion;
import Dao.ClienteDao;
import Model.Cliente;
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
public class ClienteDaoImpl implements ClienteDao{
    
    Connection cx;
    ResultSet rs;
    PreparedStatement pst;
    
    @Override
    public List<Cliente> listar() {
         List<Cliente> lista = new ArrayList<>();
        String consulta = "select * from cliente;";
        try {
            cx = Conexion.getConexion();
            pst = cx.prepareStatement(consulta);
            rs=pst.executeQuery();
            while (rs.next()) {                
                Cliente s = new Cliente();
                s.setId_c(rs.getInt("id_c"));
                s.setNombre(rs.getString("nombre"));
                s.setApellidos(rs.getString("apellidos"));
                s.setTelefono(rs.getString("telefono"));
                lista.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
    
}
