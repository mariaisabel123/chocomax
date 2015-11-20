<%-- 
    Document   : FProductos
    Created on : 3/08/2014, 09:12:39 PM
    Author     : MANU
--%>
<%@page import="chocomax.entidades.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
        String codproducto = request.getParameter("txtcodproducto");
        String descripcion = request.getParameter("txtdescripcion");
        String costo = request.getParameter("costo");
        String precioventa = request.getParameter("precioventa");
        String stock_min = request.getParameter("stock_min");
        String stock_max = request.getParameter("stock_max");
        String estado = request.getParameter("estado");
    String men1 = (String) request.getAttribute("mensaje");
    String dat1 = (String) request.getAttribute("datos");
    List<productos> LP = (List<productos>) request.getAttribute("Listado1")!=null? 
            (List<productos>) request.getAttribute("Listado1"):null;
 productos prod=(productos) request.getAttribute("datoproducto")!=null?
          (productos) request.getAttribute("datoproducto"):null;
 //los datos estan cargadoes en un usu(objeto) detipo Usuario
 //cargamos los datos en las variables
 if(prod!=null){
     codproducto=prod.getCodproducto();
     descripcion=prod.getDescripcion();
     costo=prod.getCosto();
     precioventa=prod.getPrecioventa();
     stock_min=prod.getStock_Min();
     stock_max=prod.getStock_Max();
     estado=prod.getEstado();
 }//fin si 
         
 
%>   
<!DOCTYPE html>
<html>
    <body>
        
        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <script type="text/javascript" src="js/validar.js"></script> 
		 <script type="text/javascript" src="js/validar.js"></script> 
    </head>

    
    <font face="arial"></font>
    <div id="productos">
     <style>
			
  

	</style>
        <body >
        <div id=" " style="position: absolute; width: 480px;  z-index: 1; left: 300px;      top: 68px"> 
        <form name="xform" id="" method="POST" action="./ProductosServlet">
            <body>
             

                <form action = "mailto:Mervi@gmail.com" method = "post" enctype ="text/plain" >
                    

                    <h1><title>Productos</title></head></head><center>PRODUCTOS</center></title></head></center></h1>
                    <table>
                        <tr>
                            <td>Cod_Producto</td>
                            <td><input type="text" name="txtcodproducto" value="<%=codproducto!=null?codproducto:"" %>" size="20" maxlength="8" 
                                       onkeypress="return numeros(event);">
                            </td>



                            <td>Descripcion</td>
                            <td><input type="text" name="txtdescripcion" value="<%=descripcion!=null?descripcion:"" %>" size="20" maxlength="20" 
                                       onkeypress="return sololetras(event);"></td>
                            <td>
                        </tr>

                        <tr>
                            <td>Costo</td>
                            <td><input type="text" name="txtcosto" value="<%=costo!=null?costo:"" %>" size="20" maxlength="8" 
                                       onkeypress="return numeros(event);">
                            </td>



                            <td>Precio Venta</td>
                            <td><input type="text" name="txtprecioventa" value="<%=precioventa!=null?precioventa:"" %>" size="20" maxlength="10" 
                                       onkeypress="return numeros(event);"></td>
                            <td>

                        </tr>



                        <tr>
                            <td>Stock Minimo</td>
                            <td><input type="text" name="txtstock_min" value="<%=stock_min!=null?stock_min:""%>" size="20" maxlength="10" 
                                       onkeypress="return numeros(event);"></td>
                            </td>


                            <td>Stock Maximo</td>
                            <td><input type="text" name="txtstock_max" value="<%=stock_max!=null?stock_max:"" %>" size="20" maxlength="3" 
                                       onkeypress="return numeros(event);">
                            </td>

                        </tr>
                        <td>Estado</td>
                                    <td><input type="radio" name="estado" <%if("Activo".equals(estado)){%>checked<%}%> value="Activo" checked> Activo
                                    <input type="radio" name="estado" <%if("Inactivo".equals(estado)){%>checked<%}%> value="Inactivo"> Inactivo</td>
                        
  
                         <jsp:include page="FBotones.jsp" flush="true"/>           
                                    
                    </table>

                                    
      
                                    
                                    
                                     <br>Datos enviados  <%=dat1%>
                                     <br>Mensaje recibido  <%=men1%>
                                    <%if(LP!= null) {%>
                <table>
                   <tr>
                        <td>Codproducto</td>  
                        <td>Descripcion</td>
                        <td>Costo</td>
                        <td>Precioventa</td>
                        <td>Stockmin</td>
                        <td>Stockmax</td>  
                        <td>Estado</td>
                        
                        
                    </tr>  
                    <!--Recorrer para cargar los datos-->
                    <%for(productos po:LP) {%>
                    <tr>
                        <td><%=po.getCodproducto()%> </td>
                        <td><%=po.getDescripcion()%> </td>
                        <td><%=po.getCosto()%> </td>
                        <td><%=po.getPrecioventa()%> </td>
                        <td><%=po.getStock_Min()%> </td>
                        <td><%=po.getStock_Max()%> </td>
                        <td><%=po.getEstado()%> </td>
                        
                        
                        
                   </tr>
                    <%}%>
                </table>
                <%}%>

                                
                                    </form>
                                    </div>
                                    </body>
                                    </html>



