/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jdomi
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/parcial?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USUARIO = "root";
	private static final String PASS = "";
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static Connection cx = null;
        
        public static Connection getConexion() {
		try {
			Class.forName(DRIVER);
			if (cx==null) {
				cx = DriverManager.getConnection(URL, USUARIO, PASS);
				System.out.println("Conexion Exitosa");
			}
			
		} catch (Exception ex) {
			System.out.println("Error de coneccion: "+ex);
		}
		return cx;
	}
}
