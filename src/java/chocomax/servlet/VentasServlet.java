/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.servlet;

import chocomax.entidades.Venta;
import chocomax.negocios.VentasN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joha
 */
public class VentasServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FVentas.jsp";
        String m = "";
        String d = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        
        String cons=request.getParameter("txtcons");
        String idecliente =request.getParameter("txtidecliente");
        String usuario =request.getParameter("txtusuario");
        String fecha =request.getParameter("txtfecha");
        String subtotal =request.getParameter("txtsubtotal");
        String iva =request.getParameter("txtiva");
        String estado =request.getParameter("estado");
        String boton =request.getParameter("action");
        request.setAttribute("listado", null);
        request.setAttribute("datoventa", null);
        
        
        VentasN v = new VentasN();
     
        if("buscar".equals(request.getParameter("action"))){
        try{
            request.setAttribute("datoventas",v.getventas(cons));
            
            m="Respuesta boton del servlet :"+ boton ;
            d="idecliente :"+ idecliente;
        }catch(Exception e){}
        }//fin boton Buscar 
        // Mostrar todos los datos contenidos en
        // tabla o consulta
         
        
        
        if("mostrar".equals(request.getParameter("action"))){
        try{
        request.setAttribute("listado",v.listadoventas());    
        }catch(Exception e){
        m=""+ e.getMessage();
        }
        }//fin boton mostrar y 
         //--------------->Regresamos a FUsuario.jsp
      
        
         if("guardar".equals(request.getParameter("action"))){
        try{
           v.getInsertarventas(new Venta ( ));
           request.setAttribute("listado",v.listadoventas());
        }catch(Exception e2){
            m=""+ e2.getMessage();
        }
        }//fin boton guardar --- Regresamos Fusuarioo.jsp
        
        
        
        if("actualizar".equals(request.getParameter("action"))){
        try{
            m="Respuesta boton del servlet :"+ boton ;
            d="idecliente :"+ idecliente;
        }catch(Exception e3){
        
        }
        }//fin boton actualizar
        
        
        
        if("eliminar".equals(request.getParameter("action"))){
        try{
            m="Respuesta boton del servlet :"+ boton ;
            d="idecliente :"+ idecliente;
        }catch(Exception e4){
        
        }
        }//fin boton eliminar
        
        
        
        
        if("modificar".equals(request.getParameter("action"))){
        try{
            m="Respuesta boton del servlet :"+ boton ;
            d="idecliente :"+ idecliente;
        }catch(Exception e5){}
        }//fin boton modificar
        
        
        if("salir".equals(request.getParameter("action"))){
        try{
            request.getSession().invalidate();
           request.getRequestDispatcher("./index.jsp").forward(request, response);   
        }catch(Exception e){}
        }//fin boton modificar 
        
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

       