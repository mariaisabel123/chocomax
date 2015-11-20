/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.persistencia;

/**
 *
 * @author Joha
 */
public class SQLHelpers {
    
    public static String getUsuario()
    {
    return"select usuario,nombre,clave,perfil,estado,mail from tblusuario";
    } // fin metodo
    //Buscar dato
    
    public static String getUsuario(String us)
    {
    return"select usuario,nombre,clave"
          +",perfil,estado,mail from tblusuario" 
          +" where usuario='"+us+"'";
    } // fin metodo buscar un dato 
    //ìnsertar un dato
    
    public static String getMailUsuario(String mail){
return "SELECT usuario,nombre,clave "
        + ",perfil,estado, mail from tblusuario"
        + "  where mail ='"+mail+"'";    
}// fin método buscar un dato
    
    public static String getInsertarUsuario(){
    return"INSERT INTO tblusuario(usuario,nombre,clave,perfil,estado,mail)"
            + "VALUES(?,?,?,?,?)";
    }//fin insertar
    public static String getActualizarUsuario(){ 
    return "UPDATE tblusuario set nombre=?,clave=?,"
            + "perfil=?,estado=?, mail=? where usuario=? ";
      }//fin actualizar
        
   public static String getBorrarUsuario(String user){
    return"delete from tblusuario where usuario='"+user+"'";
        }//fin borrar   
   
    public static String validarIngreso(String usuario,String clave){  
      return "SELECT usuario,nombre,clave,perfil,estado,mail"
              + " FROM tblusuario WHERE usuario='"+usuario+"' "
              + "AND clave='"+clave+"'  ";
  }// fin validar ingreso
    
    
    
 public static String getcliente()
    {
    return"select codcliente,nombre,primerapellido,segundoapellido,telefono,mail,direccion,estado from tblcliente";
    } // fin metodo
    //Buscar dato
    
    public static String getcliente(String cc)
    {
    return"select nombre,primerapellido"
          +",segundoapellido,telefono,mail, direccion,estado from tblcliente" 
          +"   where codcliente='"+cc+"'";
    } // fin metodo buscar un dato 
    //ìnsertar un dato
    public static String getInsertarcliente(){
    return"INSERT INTO tblcliente(codcliente,nombre,primerapellido,segundoapellido,telefono,mail,direccion,estado)"
            + "VALUES(?,?,?,?,?,?,?,?)";
    }//fin insertar
    public static String getActualizarcliente(){ 
    return "UPDATE tblcliente set nombre=?,primerapellido=?,segundoapellido=?"
            + " telefono=?,mail=?,direccion=?,estado=? where codcliente=? ";
        
  }//fin actualizar
    
  

     public static String getproductos() {
    return"select codproducto,nombre,valor_venta,valor_compra,stock_min,stock_maximo,estado from tblproductos";
    } // fin metodo
    //Buscar dato
    
    /**
     *
     * @param pro
     * @return
     */
    public static String getproductos(String pro)
    {
    return"select codproducto,nombre,costo"
          +",valor_venta,valor_compra,existencias,stock_min,stock_max,estado from tblproductos" 
          +" where codproducto='"+pro+"'";
    } // fin metodo buscar un dato 
    //ìnsertar un dato
    public static String getInsertarproductos(){
    return"INSERT INTO tblproductos(codproducto,nombre,valor_venta,valor_compra,existencias,stock_min,stock_max,estado;)"
            + "VALUES(?,?,?,?,?,?,?,?)";
    }//fin insertar
    public static String getActualizarproductos(){ 
    return "UPDATE tblproductos set nombre=?,valor_venta=?,valor_compra=?,existencia=?,"
            + "stock_min=?,stock_max=?,estado=? where codproducto=? ";
      }//fin actualizar
    
   public static String getVenta(){
   
       return "select cons, idecliente,usuario, fecha,subtotal, iva,estado from tblventa ";
   }
   public static String getVenta(String campo,String valor)
   {    
       return "select cons, idecliente,usuario, fecha,subtotal, iva,estado"
               + "   from tblventa  where "+campo+" ='"+valor+"'   ";
   
   }
     public static String getActualizarVenta(String cons) {    
    return "UPDATE tblventa set subtotal=?, iva=?,estado=?  where codventa=?" ;
    
}
     public static String getInsertarventa(){
         return "INSERT INTO tblventa (cons, idecliente,usuario, fecha,subtotal, iva,estado)VALUES(?,?,?,?,?,?,?)";
     }
     
     
     
      
    }// fin de la clase
   // Nos vamos para------> Daos
        



        



