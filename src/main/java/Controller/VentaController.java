/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.VentaDao;
import DaoImpl.VentaDaoImpl;
import Model.Venta;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jdomi
 */
@WebServlet(name = "VentaController", urlPatterns = {"/VC"})
public class VentaController extends HttpServlet {
    
    VentaDao v = new VentaDaoImpl();
     Gson gson = new Gson();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter p = response.getWriter();
       int opcion = Integer.parseInt(request.getParameter("opc"));
       switch (opcion) {
		//Listar
		case 1:
			System.out.println(opcion);
                        p.println(gson.toJson(v.listar()));
			break;
		//Insertar
		case 2:
			System.out.println(opcion);
			int id_s = Integer.parseInt(request.getParameter("id_s"));
                        int id_c = Integer.parseInt(request.getParameter("id_c"));
                        String fecha = request.getParameter("fecha");
                        String tipo_doc = request.getParameter("tipo_doc");
                        Venta ve = new Venta(id_s, id_c, fecha, tipo_doc);
                        p.println(gson.toJson(v.insertar(ve)));
			break;
                //Eliminar
                case 3:
                    System.out.println(opcion);
                     p.println(gson.toJson(v.eliminar(Integer.parseInt(request.getParameter("id_v")))));
                    break;
		default:
			p.println("No hay nada");
			break;
		}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
