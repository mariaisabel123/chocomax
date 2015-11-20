/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chocomax.utilidades;

import chocomax.persistencia.SQLHelpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**@serial 000-8999
 * @author Maria
 * @since 29-05-2014
 */
public class Conexion {
   Connection Con; 
   public Conexion(){}//constructor de la clase 
   static{
   try{
       Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //Crea una instancia o
       //una copia de oracle.
       // cath captura errores
   }
   catch(ClassNotFoundException e1){  // es una clase que implementa 
   System.out.println("ClassNotFoundException"+
           e1.getMessage());
   
   } 
   catch(InstantiationException e2){
   System.out.println("InstantiationException"+
           e2.getMessage());
   
   
   }
   catch(IllegalAccessException e3){ // es una clase que controla aquellas 
       //excepciones de la clase no autorizada
   System.out.println("IllegalAccessException"+
           e3.getMessage());
   
   }
   catch(Exception e){ // Error general
   System.out.println("Exception"+
           e.getMessage());
   
   }
   
   }//fin static
    public Connection getCon() {
        ConexionBD();
        return Con;
    }//devuelve (get)

    public void setCon(Connection Con) {
        this.Con = Con;
    }//establece (set)
   
public void ConexionBD(){    // se define un metodo vacio sin parametros  
String host="Localhost";
String puerto="1521";
String SID="xe"; // PARAMETRO PARA ORACLE
String user="Prueba";
String password="123";

    try{
     DriverManager.registerDriver(
             new oracle.jdbc.driver.OracleDriver());
    setCon(DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+puerto+":"+SID, user, password));
    // thin parametro flaco
}
catch(SQLException e4){
System.out.println("SQLException"+ e4.getMessage());
}
catch(Exception e){
System.out.println("Exception"+ e.getMessage());
}
    
}
public static void main(String param[]){
Conexion c = new Conexion();
try{
ResultSet r=c.getCon()
        .prepareStatement(SQLHelpers.getcliente()).executeQuery();
if(r.next()){
System.out.println("Nombre "+r.getString(2) );
System.out.println("Usuario "+r.getString(1) );
while(r.next()){
System.out.println("Nombre "+r.getString(2) );
System.out.println("Usuario "+r.getString(1) );
}//fin mientras
}else{
System.out.print("¡..No hay datos..!");
}// fin si
}catch(Exception e){
System.out.print("Error :"+e.getMessage()+"Causa :"+e.getCause() );

}
        
}

  
 }//fin Conexion
