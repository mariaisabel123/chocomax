/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.servlet;

import chocomax.entidades.Usuario;
import chocomax.negocios.UsuarioN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mary
 */
public class Autenticacion extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String usuario= request.getParameter("txtusuario");
        String  clave = request.getParameter("txtclave");
        String  mail = request.getParameter("txtmail");
        UsuarioN  n = new UsuarioN();
        Usuario u= n.getValidarIngreso(usuario, clave);
        request.setAttribute("targetOpcion",null);
        if(!"0".equals(u.getUsuario()))  {
            request.getSession(true).setAttribute("usuario", u);
            request.setAttribute("target", "./FPrincipal.jsp");
        }
        else
        {
          // request.setAttribute("target", "./FPrincipal.jsp");
            request.setAttribute("mensajeError", "Revisar datos");
            request.setAttribute("target", "./FLoginBox.jsp");
          
          
        }



        request.getRequestDispatcher("./Principal.jsp").forward(request, response);
    }
       
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
    } // </editor-fold>
 }