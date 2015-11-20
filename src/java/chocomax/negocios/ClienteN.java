/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.//version buena 
 */
package chocomax.negocios;

import chocomax.entidades.Cliente;
import chocomax.entidades.Usuario;
import chocomax.persistencia.Daos;
import chocomax.utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ClienteN {
 Daos dao;
    private String StringmensajeError;
 public ClienteN(){
 dao = new Daos();
 
 } // fin constructor
 
 public List<Cliente>listadoCliente(){
 Connection c= new Conexion().getCon();
  return dao.Listadocliente(c);
  //Una vez programado pasamos al servlet 

 }

    public Cliente getCliente(String cliente) {
        Connection c=new Conexion().getCon();
        return dao.getCliente(c, cliente);
    }
 public void getInsertarCliente(Cliente cliente)throws Exception{
 //throws es una clase que permite programas nuestras
 //propias exceptiones
 Conexion con= new Conexion();
 String mensajeError="";
 String cc = cliente.getCodcliente();
 String nombre = cliente.getNombre();
 String primerapellido = cliente.getPrimerapellido();
 String segundoapellido = cliente.getSegundoapellido();
 String telefono = cliente.getTelefono();
 String mail = cliente.getMail();
 String direccion = cliente.getDireccion();
 String estado = cliente.getEstado();
 
 if ("".equals(cc)|| null ==cc){
 mensajeError+="<br>Ingrese el codigo del cliente";
 }
 
  if ("".equals(nombre)|| null ==nombre){
 mensajeError+="<br>Ingrese el nombre";
 }
  
   if ("".equals(primerapellido)|| null ==primerapellido){
 mensajeError+="<br>Ingrese primerapellido";
 }
   
    if ("".equals(segundoapellido)|| null ==segundoapellido){
 mensajeError+="<br>Ingrese el segundo";
 }
    
     if ("".equals(telefono)|| null ==telefono){
 mensajeError+="<br>Ingrese su telefono";
 }
      
           
      if ("".equals(mail)|| null ==mail){
 mensajeError+="<br>Ingrese su email";
 }
      
      if ("".equals(direccion)|| null ==direccion){
 mensajeError+="<br>Ingrese su direccion";
 }
      
     if ("".equals(estado)|| null ==estado){
 estado="Activo";
 }
 //Lanzamos una excepcion cuando falte algun
 //Dato obligatorio
 if(!"".equals(mensajeError)){
 throw new Exception(mensajeError);
 }//fin si no hay ningun error 
 //Ejecutamos la accion
 if (dao.siExisteCliente(con.getCon(), estado)){
     mensajeError= "El cliente  identificado : "+cc+ " ya existe ";
 throw new Exception(mensajeError);
 
 }
 mensajeError= dao.getInsertarCliente(con.getCon(), cc, nombre, primerapellido, segundoapellido, mail, telefono,direccion, estado);
 
//validamos y enviamos una excepcion al guardar el 
//dato 
 if(!"".equals(mensajeError)){
 throw new Exception(mensajeError);
 }
 }//fin metodo Regresamos al UsuarioServlet    
 
 public Usuario getValidarIngreso(String cliente,String ca){
Connection c= new Conexion().getCon();
return dao.validarIngreso(c, cliente,ca);
// una vez programado pasamos
//  al UsuarioServlet al buscar
}  
 }// fin clase
