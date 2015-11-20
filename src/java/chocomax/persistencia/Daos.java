/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.persistencia;


import chocomax.entidades.Cliente;
import chocomax.entidades.Usuario;
import chocomax.entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class Daos {
    //copiamos este metodo
    public List<Usuario>ListadoUsuarios(Connection con){
       List<Usuario> resultado = new ArrayList<Usuario>();
       try{
           PreparedStatement p= con.prepareStatement(SQLHelpers.getUsuario());
           ResultSet r=p.executeQuery();
           while(r.next()){
               Usuario u= new Usuario();     
               u.setUsuario(r.getString(1));
               u.setNombre(r.getString(2));
               u.setClave(r.getString(3));
               u.setPerfil(r.getString(4));
               u.setEstado(r.getString(5));
               u.setMail(r.getString(6));
               resultado.add(u);
               
           }// fin mientras
           
       }//fin try
        catch(Exception e1){}
       finally{
       try {con.close();
       }// fin control cerrar conexion    
           
       catch (Exception e2){}
       
       }// fin finally
       
        return resultado;
    }//fin metodo
    
    //lo pegamos aqui y lo modificamos
    //metodo para buscar dato
     public Usuario getUsuario(Connection con, String user){
       Usuario u = new Usuario();
       
       try{
           PreparedStatement p= con.prepareStatement(SQLHelpers.getUsuario(user));
           ResultSet r=p.executeQuery();
           while(r.next()){
               
               u.setUsuario(r.getString(1));
               u.setNombre(r.getString(2));
               u.setClave(r.getString(3));
               u.setPerfil(r.getString(4));
               u.setEstado(r.getString(5));
               u.setMail(r.getString(6));
           }// fin mientras
           
           
           
       }//fin try
        catch(Exception e1){}
       finally{
       try {con.close();
       }// fin control cerrar conexion    
           
       catch (Exception e2){}
       
       }// fin finally
       
        return u;
    }//fin metodo 
     
     public String getValidarActualizar(
             Connection con,
             String usuario,
             String nombre,
             String clave,
             String perfil,
             String estado,
             String mail){
             
         String respuesta="";
        final String respuesta1 = respuesta;
     try{ 
        PreparedStatement p = con.prepareStatement(
                SQLHelpers.getInsertarUsuario());
        
     p.setString(1,usuario);
     p.setString(2,nombre);
     p.setString(3,clave);
     p.setString(4,perfil);
     p.setString(5,estado); 
     p.setString(6,mail);
     
     //luego ejecutamos la accion
     p.execute();//este metodo no retona filas
     // a diferencias del metodo executeQuery()
     if(p.getUpdateCount()<=0){
     respuesta="Error..!El usuario no fue validado ni actualizado";
          
      }else{
      respuesta="El usuario fue validado y Actualizado";
               }//fin si 
       
     }catch(Exception e){
      respuesta+=":"+ e.getMessage() + "causa :"+e.getCause();
     }finally{try{con.close();}catch (Exception e1){}}//fin finally
     //con. close();permite cerrar la conexion a la 
    return respuesta1; 
     }
     
     
     public String getInsertarUsuario(
             Connection con,
             String user,
             String nombre,
             String clave,
             String perfil,
             String estado,
             String mail ){
     String respuesta="";
     try{
     PreparedStatement p = 
     con.prepareStatement(SQLHelpers.getInsertarUsuario());
     p.setString(1,user);
     p.setString(2,nombre);
     p.setString(3,clave);
     p.setString(4,perfil);
     p.setString(5,estado);
     p.setString(6,mail);
     //Luego ejecutamos la accion
     p.execute();//Este metodo no retorna filas
     //a diferencias del metodo executeQuery()
     if(p.getUpdateCount()>0){
     respuesta = "Usuario agregado";
     }else{
     respuesta = "Error..!Usuario No agregado...¡";
     }//fin si          
     }catch(Exception e){
     respuesta+=":"+ e.getMessage()+"Causa :"+e.getCause();
     }finally{try{con.close();}catch(Exception e1){}}// fin finally
     // con.close(); Permit cerrar la conexion a la bd
     return respuesta;
     }//fin metodo regresamos a la capa de negocio 
     
       
    public boolean  siExisteMail(Connection con, String mail){
   boolean u = false;
    
    try {//iniciar para controlar errores
        PreparedStatement us = con.prepareStatement(SQLHelpers.getUsuario(mail));
        ResultSet r= us.executeQuery();
        while (r.next()){
            u = true;
            }
        
    } catch (Exception e){
        System.out.print("" + e.getCause());
        
    }finally{
        try{
            con.close();
        }catch (Exception c){}
    }
    return u;        
}
   public Usuario validarActualizar(Connection con, String usuario, String clave){
    Usuario u = new Usuario();
    u.setUsuario("0");
    try {//iniciar para controlar errores
        PreparedStatement us = con.prepareStatement(SQLHelpers.validarIngreso(usuario, clave));
        ResultSet r= us.executeQuery();
        while (r.next()){
            u.setUsuario(r.getString(1));
            u.setNombre(r.getString(2));
            u.setClave(r.getString(3));
            u.setPerfil(r.getString(4));
            u.setEstado(r.getString(5));
            u.setMail(r.getString(6));
            }
        
    } catch (Exception e){
        e.printStackTrace();
        System.out.print("" + e.getCause());
        return null;
    }finally{
        try{
            con.close();
        }catch (Exception c){}
    }
    return u;        
}  
  
    public Usuario validarIngreso(Connection con, String usuario, String clave){
    Usuario u = new Usuario();
    u.setUsuario("0");
    try {//iniciar para controlar errores
        PreparedStatement us = con.prepareStatement(SQLHelpers.validarIngreso(usuario, clave));
        ResultSet r= us.executeQuery();
        while (r.next()){
            u.setUsuario(r.getString(1));
            u.setNombre(r.getString(2));
            u.setClave(r.getString(3));
            u.setPerfil(r.getString(4));
            u.setEstado(r.getString(5));
            u.setMail(r.getString(6));
            }
        
    } catch (Exception e){
        e.printStackTrace();
        System.out.print("" + e.getCause());
        return null;
    }finally{
        try{
            con.close();
        }catch (Exception c){}
    }
    return u;        
}
    

   public List<Cliente>Listadocliente(Connection con){
       List<Cliente> resultado = new ArrayList<Cliente>();
       try{
           PreparedStatement p= con.prepareStatement(SQLHelpers.getcliente());
           ResultSet r=p.executeQuery();
           while(r.next()){
               Cliente c= new Cliente();     
               c.setCodcliente(r.getString(1));
               c.setNombre(r.getString(2));
               c.setPrimerapellido(r.getString(3));
               c.setSegundoapellido(r.getString(4));
               c.setTelefono(r.getString(5));
               c.setMail(r.getString(6));
               c.setDireccion(r.getString(7));
               c.setEstado(r.getString(8));
              
               resultado.add(c);
           }// fin mientras
           
       }//fin try
        catch(Exception e1){}
       finally{
       try {con.close();
       }// fin control cerrar conexion    
           
       catch (Exception e2){}
       
       }// fin finally
       
        return resultado;
    }//fin metodo
    
    //lo pegamos aqui y lo modificamos
    //metodo para buscar dato
     public Cliente getCliente(Connection con, String cc){
       Cliente c = new Cliente();
       try{
           PreparedStatement p= con.prepareStatement(SQLHelpers.getcliente(cc));
           ResultSet r=p.executeQuery();
           while(r.next()){
               
               c.setCodcliente(r.getString(1));
               c.setNombre(r.getString(2));
               c.setPrimerapellido(r.getString(3));
               c.setSegundoapellido(r.getString(4));
               c.setTelefono(r.getString(5));
               c.setMail(r.getString(6));
               c.setDireccion(r.getString(7));
               c.setEstado(r.getString(8));
              
           }// fin mientras
           
       }//fin try
        catch(Exception e1){}
       finally{
       try {con.close();
       }// fin control cerrar conexion    
           
       catch (Exception e2){}
       
       }// fin finally
       
        return c;
    }//fin metodo 
     
     public String getInsertarCliente(
             Connection con,
             String cc,
             String nombre,
             String primerapellido,
             String segundoapellido,
             String telefono,
             String mail,
             String direccion,
             String estado){
     String respuesta="";
     try{
     PreparedStatement p = 
     con.prepareStatement(SQLHelpers.getInsertarUsuario());
     p.setString(1,cc);
     p.setString(2,nombre);
     p.setString(3,primerapellido);
     p.setString(4,segundoapellido); 
     p.setString(5,telefono);
     p.setString(6,mail);
     p.setString(7,direccion);
     p.setString(8,estado);
     
     //Luego ejecutamos la accion
     p.execute();//Este metodo no retorna filas
     //a diferencias del metodo executeQuery()
     if(p.getUpdateCount()>0){
     respuesta = "Cliente agregado";
     }else{
     respuesta = "Error..!Cliente No agregado...¡";
     }//fin si          
     }catch(Exception e){
     respuesta+=":"+ e.getMessage()+"Causa :"+e.getCause();
     }finally{try{con.close();}catch(Exception e1){}}// fin finally
     // con.close(); Permit cerrar la conexion a la bd
     return respuesta;
     }//fin metodo regresamos a la capa de negocio 

     //UsuarioN
     public Usuario getUsuarioMail(Connection con,String mail ){
Usuario u = new Usuario();
u.setUsuario("0");
try{
PreparedStatement p= 
  con.prepareStatement(SQLHelpers.getMailUsuario(mail));
ResultSet r=p.executeQuery();
while(r.next()){
u.setUsuario(r.getString(1));
u.setNombre(r.getString(2));
u.setClave(r.getString(3));
u.setPerfil(r.getString(4));
u.setEstado(r.getString(5));
u.setMail(r.getString(6));

}// fin mientras 
}// fin try
catch(Exception e1){}
finally{
try{con.close();}// fin control cerrar conexion    
catch(Exception clo){}

}// fin finally

 return u;   
}// fin métodos 
     
     public String getActualizarUsuario(
             Connection con,
             String user,
             String nombre,
             String clave,
             String  perfil,
             String estado){
             
         String respuesta="";
        final String respuesta1 = respuesta;
     try{ 
         
  
        /* tblusuario set nombre=1?, clave2?,perfil=3?,estado=4?,"
         *     + where usuario
         */
        PreparedStatement p = con.prepareStatement(
                SQLHelpers.getInsertarUsuario());
        //(?,?,?,?,?)
     p.setString(1,user);
     p.setString(2,nombre);
     p.setString(3,clave);
     p.setString(4,perfil);
     p.setString(5,estado); 
     
     //luego ejecutamos la accion
     p.execute();//este metodo no retona filas
     // a diferencias del metodo executeQuery()
     if(p.getUpdateCount()<=0){
     respuesta="Error..!usuario no Actualizado";
          
      }else{
      respuesta="usuario Actualizar";
               }//fin si 
       
     }catch(Exception e){
      respuesta+=":"+ e.getMessage() + "causa :"+e.getCause();
     }finally{try{con.close();}catch (Exception e1){}}//fin finally
     //con. close();permite cerrar la conexion a la 
    return respuesta1; 
     }// fin metodo regresamos a la capa de negocio
     //UauarioN
     
     // validar si existe un dato 
     
    
    public boolean  siExisteCliente(Connection con, String identificacion){
   boolean c = false;
    
    try {//iniciar para controlar errores
        PreparedStatement id = con.prepareStatement(SQLHelpers.getcliente(identificacion));
        ResultSet r= id.executeQuery();
        while (r.next()){
            c = true;
            }
        
    } catch (Exception e){
        System.out.print("" + e.getCause());
        
    }finally{
        try{
            con.close();
        }catch (Exception u){}
    }
    return c;        
}

    
    
    public List<Producto>ListadoProductos(Connection con){
       List<Producto> resultado = new ArrayList<Producto>();
       try{
           PreparedStatement p= con.prepareStatement(SQLHelpers.getproductos());
           ResultSet r=p.executeQuery();
           while(r.next()){
               Producto pro= new Producto();     
               pro.setCodproducto(r.getString(1));
               pro.setNombre(r.getString(2));
               pro.setValor_venta(r.getString(3));
               pro.setExistencias(r.getString(4));
               pro.setStock_min(r.getString(5));
               pro.setStock_max(r.getString(6));
               pro.setEstado(r.getString(7));
               resultado.add(pro);
           }// fin mientras
           
       }//fin try
        catch(Exception e1){}
       finally{
       try {con.close();
       }// fin control cerrar conexion    
           
       catch (Exception e2){}
       
       }// fin finally
       
        return resultado;
    }//fin metodo
    
    //lo pegamos aqui y lo modificamos
    //metodo para buscar dato
     public Producto getproductos(Connection con, String prd){
       Producto pd = new Producto();
       try{
           PreparedStatement p= con.prepareStatement(SQLHelpers.getproductos(prd));
           ResultSet r=p.executeQuery();
           while(r.next()){
               
               
               pd.setCodproducto(r.getString(1));
               pd.setNombre(r.getString(2));
               pd.setValor_venta(r.getString(3));
               pd.setValor_compra(r.getString(4));
               pd.setExistencias(r.getString(5));
               pd.setStock_min(r.getString(6));
               pd.setStock_max(r.getString(7));
               pd.setEstado(r.getString(8));
           }// fin mientras
           
           
           
       }//fin try
        catch(Exception e1){}
       finally{
       try {con.close();
       }// fin control cerrar conexion    
           
       catch (Exception e2){}
       
       }// fin finally
       
        return pd;
    }//fin metodo 
     
     public String getInsertarproducto(
             Connection con,
             String pro,
             String descripcion,
             String costo,
             String precioventa,
             String stock_min,
             String stock_max,
             String estado){
     String respuesta="";
     try{
     PreparedStatement p = 
     con.prepareStatement(SQLHelpers.getInsertarproductos());
     p.setString(1,pro);
     p.setString(2,descripcion);
     p.setString(3,costo);
     p.setString(4,precioventa);
     p.setString(5,stock_min);
     p.setString(6,stock_max); 
     p.setString(7,estado); 
     //Luego ejecutamos la accion
     p.execute();//Este metodo no retorna filas
     //a diferencias del metodo executeQuery()
     if(p.getUpdateCount()>0){
     respuesta = "Producto agregado";
     }else{
     respuesta = "Error..!Producto No agregado...¡";
     }//fin si          
     }catch(Exception e){
     respuesta+=":"+ e.getMessage()+"Causa :"+e.getCause();
     }finally{try{con.close();}catch(Exception e1){}}// fin finally
     // con.close(); Permit cerrar la conexion a la bd
     return respuesta;
     }//fin metodo regresamos a la capa de negocio 

 public String getActualizarProductos(
             Connection con,
             String codproducto,
             String nombre,
             String valor_venta,
             String valor_compra,
             String existencias,
             String stock_min,
             String stock_max,
             String estado){
             
         String respuesta="";
        final String respuesta1 = respuesta;
     try{ 
        PreparedStatement p = con.prepareStatement(
                SQLHelpers.getInsertarUsuario());
        
     p.setString(1,codproducto);
     p.setString(2,nombre);
     p.setString(3,valor_venta);
     p.setString(4,valor_compra);
     p.setString(5,existencias); 
     p.setString(6,stock_min);
     p.setString(7,stock_max);
     p.setString(8,estado);
     //luego ejecutamos la accion
     p.execute();//este metodo no retona filas
     // a diferencias del metodo executeQuery()
     if(p.getUpdateCount()<=0){
     respuesta="Error..!El producto no fue Actualizado";
          
      }else{
      respuesta="Producto Actualizado";
               }//fin si 
       
     }catch(Exception e){
      respuesta+=":"+ e.getMessage() + "causa :"+e.getCause();
     }finally{try{con.close();}catch (Exception e1){}}//fin finally
     //con. close();permite cerrar la conexion a la 
    return respuesta1; 
     }

    public Daos() {}

    
 
  }// fin de la clase Daos
   //Nos vamos para capa de negocio
    // Llamada-------->UsuarioN