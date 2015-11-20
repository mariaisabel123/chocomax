/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.//version buena 
 */
package chocomax.negocios;

import chocomax.entidades.Usuario;
import chocomax.persistencia.Daos;
import chocomax.utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioN {
 Daos dao;
 Connection c= new Conexion().getCon();
 public UsuarioN(){
 dao = new Daos();
 
 } // fin constructor
 
 public List<Usuario>listadoUsuario(){
 return dao.ListadoUsuarios(c);
  //Una vez programado pasamos al servlet 

 }

 public Usuario getUsuarioMail(String mail){
return dao.getUsuarioMail(c, mail);
}
    
    public Usuario getUsuario(String user) {
        return dao.getUsuario(c, user); 
    }
    //public Usuario getUsuarioMail(String mail) {
       // return dao.getUsuarioMail(c, mail); 
    //}
    
 public void getInsertarUsuario(Usuario user)throws Exception{
 //throws es una clase que permite programas nuestras
 //propias exceptiones
 Conexion con= new Conexion();
 String mensajeError="";
 String us = user.getUsuario();
 String nombre = user.getNombre();
 String clave = user.getClave();
 String perfil = user.getPerfil();
 String estado = user.getEstado();
 String mail = user.getMail();
 if ("".equals(us)|| null ==us){
 mensajeError+="<br>Ingrese el Usuario";
 }
 
  if ("".equals(nombre)|| null ==nombre){
 mensajeError+="<br>Ingrese el nombre";
 }
  
   if ("".equals(clave)|| null ==clave){
 mensajeError+="<br>Ingrese la clave";
 }
   
    if ("".equals(perfil)|| null ==perfil){
 mensajeError+="<br>Ingrese el Perfil";
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
 mensajeError= dao.getInsertarUsuario(con.getCon(), us, 
         nombre, clave, perfil, estado,mail);
 
//validamos y enviamos una excepcion al guardar el 
//dato 
 if(!"".equals(mensajeError)){
 throw new Exception(mensajeError);
 }
 }//fin metodo Regresamos al UsuarioServlet    
 
 public Usuario getValidarIngreso(String user,String ca){
Connection c= new Conexion().getCon();
return dao.validarIngreso(c, user,ca);
// una vez programado pasamos

}
//  al UsuarioServlet al buscar
 
 //modificar un dato
 
 
 public void getActualizarUsuario(Usuario user)throws Exception{
 //throws es una clase que permite programas nuestras
 //propias exceptiones
 Conexion con= new Conexion();
 String mensajeError="";
 String us = user.getUsuario();
 String nombre = user.getNombre();
 String clave = user.getClave();
 String perfil = user.getPerfil();
 String estado = user.getEstado();
 String mail = user.getMail();
 if ("".equals(us)|| null ==us){
 mensajeError+="<br>Ingrese el Usuario";
 }
 
  if ("".equals(nombre)|| null ==nombre){
 mensajeError+="<br>Ingrese el nombre";
 }
  
   if ("".equals(clave)|| null ==clave){
 mensajeError+="<br>Ingrese la clave";
 }
   
    if ("".equals(perfil)|| null ==perfil){
 mensajeError+="<br>Ingrese el Perfil";
 }
    
     if ("".equals(estado)|| null ==estado){
 estado="Activo";
 }
      if ("".equals(mail)|| null ==mail){
 mensajeError+="<br>Ingrese correo electronico";
 }
 //Lanzamos una excepcion cuando falte algun
 //Dato obligatorio
 if(!"".equals(mensajeError)){
 throw new Exception(mensajeError);
 }
 
 //Validar un que no empiece por un caracter especifico
 

 //fin si no hay ningun error 
 //Ejecutamos la accion
 mensajeError= dao.getActualizarUsuario(con.getCon(), us, 
         nombre, clave, perfil, estado);
 
//validamos y enviamos una excepcion al guardar el 
//dato 
 if(!"".equals(mensajeError)){
 throw new Exception(mensajeError);
 }
 }//fin metodo Regresamos al UsuarioServlet    
 
public Usuario getValidarActualizar(String user,String ca){
Connection c= new Conexion().getCon();
return dao.validarActualizar(c, user,ca);
}

}  // fin clase

 
 
 
 
 
 
 
 
 