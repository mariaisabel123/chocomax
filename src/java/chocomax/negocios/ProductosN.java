/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.negocios;

import chocomax.entidades.Producto;
import chocomax.persistencia.Daos;
import chocomax.utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

 
    
/**
 *
 * @author MANU
 */
public class ProductosN {
 Daos dao;
    private String StringmensajeError;
    private Object codproducto;
 public ProductosN(){
 dao = new Daos();
 
 } // fin constructor
 
 public List<Producto>listadoproductos(){
 Connection c= new Conexion().getCon();
  return dao.ListadoProductos(c);
  //Una vez programado pasamos al servlet 

 }

    
    public Producto getproductos(String pro) {
        Connection c=new Conexion().getCon();
        return dao.getproductos(c, pro);
        
     
    }
 public void getInsertarproducto(Producto pro)throws Exception{
 //throws es una clase que permite programas nuestras
 //propias exceptiones
 Conexion con= new Conexion();
 String mensajeError="";
 String codproducto = pro.getCodproducto();
 String nombre = pro.getNombre();
 String valor_venta = pro.getValor_venta();
 String valor_compra = pro.getValor_compra();
 String existencias = pro.getExistencias();
 String stock_min = pro.getStock_min();
 String stock_max = pro.getStock_max();
 String Estado = pro.getEstado();
 
 if ("".equals(codproducto)|| null ==codproducto){
 mensajeError+="<br>Ingrese el Codigo del Producto";
 }
 
  if ("".equals(nombre)|| null ==nombre){
 mensajeError+="<br>Ingrese el nombre";
 }
  
   if ("".equals(valor_venta)|| null ==valor_venta){
 mensajeError+="<br>Ingrese el valor_venta";
 }
   
    if ("".equals(valor_compra)|| null ==valor_compra){
 mensajeError+="<br>Ingrese el valor_compra";
 }
    
     if ("".equals(existencias)|| null ==existencias){
 mensajeError+="<br>Ingrese las existencias";
 }
    
     if ("".equals(stock_min)|| null ==stock_min){
 mensajeError+="<br>Ingrese el stock minimo";
 }
     if ("".equals(stock_max)|| null ==stock_max){
 mensajeError+="<br>Ingrese el stock maximo";
 }
     if ("".equals(Estado)|| null ==Estado){
 Estado="Activo";
 }
 //Lanzamos una excepcion cuando falte algun
 //Dato obligatorio
 if(!"".equals(mensajeError)){
 throw new Exception(mensajeError);
 }//fin si no hay ningun error 
 //Ejecutamos la accion
 mensajeError= dao.getInsertarproducto(con.getCon(), Estado, stock_min, Estado, valor_venta, stock_min, stock_max, Estado);
 
//validamos y enviamos una excepcion al guardar el 
//dato 
 if(!"".equals(mensajeError)){
 throw new Exception(mensajeError);
 }
 }//fin metodo Regresamos al UsuarioServlet    
 
 
//  al UsuarioServlet al buscar
 
 //modificar un dato
 
 
 public void getActualizarUsuario(Producto pro)throws Exception{
 //throws es una clase que permite programas nuestras
 //propias exceptiones
 Conexion con= new Conexion();
 String mensajeError="";
 String codproducto = pro.getCodproducto();
 String nombre = pro.getNombre();
 String valor_venta= pro.getValor_venta();
 String valor_compra = pro.getValor_compra();
 String existencias = pro.getExistencias();
 String stock_min = pro.getStock_min();
 String stock_max = pro.getStock_max();
 String estado = pro.getEstado();
 
 if ("".equals(codproducto)|| null ==codproducto){
 mensajeError+="<br>Ingrese el codigo del producto";
 }
 
  if ("".equals(nombre)|| null ==nombre){
 mensajeError+="<br>Ingrese el nombre";
 }
  
   if ("".equals(valor_venta)|| null ==valor_venta){
 mensajeError+="<br>Ingrese el valor venta";
 }
   
    if ("".equals(valor_compra)|| null ==valor_compra){
 mensajeError+="<br>Ingrese el valor compra";
 }
    
    if ("".equals(existencias)|| null ==existencias){
 mensajeError+="<br>Ingrese las existencias";
 }
    
     if ("".equals(stock_min)|| null ==stock_min){
 mensajeError+="<br>Ingrese el stock minimo";
 }
     if ("".equals(stock_max)|| null ==stock_max){
 mensajeError+="<br>Ingrese el stock maximo";
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
 mensajeError= dao.getActualizarProductos(con.getCon(), codproducto, 
         nombre, valor_venta, valor_compra, existencias, stock_min, stock_max, estado);
 
//validamos y enviamos una excepcion al guardar el 
//dato 
 if(!"".equals(mensajeError)){
 throw new Exception(mensajeError);
 }
 }//fin metodo Regresamos al UsuarioServlet    
 

}

