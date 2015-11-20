/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.servlet;

import chocomax.entidades.Cliente;
import chocomax.negocios.ClienteN;
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
public class ClienteServlet extends HttpServlet {

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
        String modulo = "./FCliente.jsp";   
        String pagina = "./FPrincipal.jsp";
        request.setAttribute("targetModulo", modulo);
        request.setAttribute("listado", null);
        request.setAttribute("datocliente", null);
        request.setAttribute("mensaje", null);
        String men = "";
        String d = "";
        ClienteN NC = new ClienteN ();
        
  String codcliente=request.getParameter("txtcodcliente");
  String nombre= request.getParameter("txtnombre");
  String apellido1=request.getParameter("txtapellido1");
  String apellido2=request.getParameter("txtapellido2");
  String telefono=request.getParameter("txttelefono");
  String mail=request.getParameter("txtmail");
  String direccion=request.getParameter("txtdireccion");
  String estado=request.getParameter("txtestadocliente");
  String boton =request.getParameter("action");
  
        
        
        if("mostrar".equals(request.getParameter("action"))) {
          try {
          request.setAttribute("listado",NC.listadoCliente());
          }catch (Exception E){
          men=""+ E.getMessage();
          }
          }// fin boton mostrar
        
        if("buscar".equals(request.getParameter("action"))) {
          try {
          request.setAttribute("datocliente",NC.getCliente(codcliente));
          men=" Respuesta boton del servlet :"+ boton;
          d="Nombre :"+ nombre;
          }catch (Exception E){}
        }// fin boton buscar

        
        
        if("guardar".equals(request.getParameter("action"))){
        try{
           NC.getInsertarCliente(new Cliente(codcliente,nombre,apellido1,apellido2,telefono,mail,direccion,estado));
           request.setAttribute("listado",NC.listadoCliente());
        }catch(Exception e){
            men=""+ e.getMessage();
        }
        }//fin boton guardar   
        
        
        
           
        if("actualizar".equals(request.getParameter("action"))){
        try{
            men="Respuesta boton del servlet :"+ boton ;
            d="Nombre :"+ nombre;
        }catch(Exception e){
        
        }
        }//fin boton actualizar
        
        if("eliminar".equals(request.getParameter("action"))){
        try{
            men="Respuesta boton del servlet :"+ boton ;
            d="Nombre :"+ nombre;
        }catch(Exception e){
        
        }
        }//fin boton eliminar
        
        request.setAttribute("mensajes", men);
        request.setAttribute("datos", d);    
        request.getRequestDispatcher(pagina).forward(request, response);
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
    }// </editor-fold>
}
