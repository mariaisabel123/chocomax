/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.servlet;

import chocomax.entidades.Producto;
import chocomax.negocios.ProductosN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MANU
 */
public class ProductosServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FProductos.jsp";
        String m = "";
        String d = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        
        String prd =request.getParameter("txtcodproducto");
        String nombre =request.getParameter("txtnombre");
        String valor_venta =request.getParameter("txtvalor_venta");
        String valor_compra =request.getParameter("txtvalor_compra");
        String existencias =request.getParameter("txtexistencias");
        String stock_min =request.getParameter("stock_min");
        String stock_max =request.getParameter("stock_max");
        String estado =request.getParameter("estado");
        String boton =request.getParameter("action");
        request.setAttribute("listado", null);
        request.setAttribute("datoproducto", null);
        
        
        ProductosN pd = new ProductosN();
     
        if("buscar".equals(request.getParameter("action"))){
        try{
            request.setAttribute("datoproducto",pd.getproductos(prd));
            
            m="Respuesta boton del servlet :"+ boton ;
            d="nombre :"+ nombre;
        }catch(Exception e){}
        }//fin boton Buscar 
        // Mostrar todos los datos contenidos en
        // tabla o consulta
         
        
        
        if("mostrar".equals(request.getParameter("action"))){
        try{
        request.setAttribute("listado",pd.listadoproductos());    
        }catch(Exception e){
        m=""+ e.getMessage();
        }
        }//fin boton mostrar y 
         //--------------->Regresamos a FUsuario.jsp
      
        
         if("guardar".equals(request.getParameter("action"))){
        try{
           pd.getInsertarproducto(new Producto(prd,nombre,valor_venta,valor_compra,existencias,stock_min,stock_max,estado));
           request.setAttribute("listado",pd.listadoproductos());
        }catch(Exception e2){
            m=""+ e2.getMessage();
        }
        }//fin boton guardar --- Regresamos Fusuarioo.jsp
        
        
        
        if("actualizar".equals(request.getParameter("action"))){
        try{
            m="Respuesta boton del servlet :"+ boton ;
            d="nombre :"+ nombre;
        }catch(Exception e3){
        
        }
        }//fin boton actualizar
        
        
        
        if("eliminar".equals(request.getParameter("action"))){
        try{
            m="Respuesta boton del servlet :"+ boton ;
            d="nombre :"+ nombre;
        }catch(Exception e4){
        
        }
        }//fin boton eliminar
        
        
        
        
        if("modificar".equals(request.getParameter("action"))){
        try{
            m="Respuesta boton del servlet :"+ boton ;
            d="nombre :"+ nombre;
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
