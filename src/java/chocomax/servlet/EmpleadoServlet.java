/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.servlet;
   
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
public class EmpleadoServlet extends HttpServlet {

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
        String modulo = "FEmpleado.jsp";
        String m = "";
        String d = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        
        String user = request.getParameter("txtusuario");
        String nombre = request.getParameter("txtnombre");
        String clave = request.getParameter("txtclave");
        String perfil = request.getParameter("cboperfil");
        String estado = request.getParameter("cboestado");
        String boton = request.getParameter("action");
        
        if ("buscar".equals(request.getParameter("action"))) {
        
        
        

        try {
            m = "Respuesta boton del servlet: " + boton;
            d = "Nombre:" + nombre;
        } catch(Exception e) {            
            
        }
    }//fin boton buscar
        
        if ("actualizar".equals(request.getParameter("action"))) {
            try {
                m = "Respuesta boton del servlet: "+boton;
                d = "Nombre:"+ nombre;
            } catch (Exception e) {
            }
        }//fin boton actualizar
         
         if ("guardar".equals(request.getParameter("action"))) {
            try {
                m = "Respuesta boton del servlet: "+boton;
                d = "Nombre:"+ nombre;
            } catch (Exception e) {
            }
        }//fin boton guardar
         
         if ("modificar".equals(request.getParameter("action"))) {
            try {
                m = "Respuesta boton del servlet: "+boton;
                d = "Nombre:"+ nombre;
            } catch (Exception e) {
            }
        }//fin boton modificar
         
         if ("bloquear".equals(request.getParameter("action"))) {
            try {
                m = "Respuesta boton del servlet: "+ boton;
                d = "Nombre:"+ nombre;
            } catch (Exception e) {
            }
        }//fin boton bloquear
        
        request.setAttribute("mensajes", m);
        request.setAttribute("datos", d);
        request.getRequestDispatcher(modulo).forward(request, response);
        
    }//fin metodo processRequest
        

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
    }// </editor-fold>
}
    
    
