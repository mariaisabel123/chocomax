<%@page import="chocomax.entidades.Cliente"%>
<%@page import="java.util.List"%>
<%
  String nombre=request.getParameter("txtnombre");
  String mail = request.getParameter("txtmail");
  String descripcion =request.getParameter("txtdescripcion");
  
  
  
String men =(String)request.getAttribute("mensajes");
String dat =(String)request.getAttribute("datos");  


    


%>

<html>
<head><title> Cliente </title></head>
<body>


<style>

body {

background: #e1c192 url(css/Imagenes/fondo.png);
</style>



<h1><center><font color="tan">Contactanos.</font></center></h1>

<head>
    <link rel="stylesheet" type="text/css" href="css/Estilo.css"></link>
</head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contactanos</title></head>
<body>

<div id="formulario">



    
    <h3>Si usted tiene alguna pregunta sobre nuestros productos,
                póngase en contacto con nosotros y estaremos encantados de ayudarle.</h3>
    
    <table>


        <tr>
            <td>Nombre</td>
            <td> <input type="text" name="txtnombre" size="35" maxlength="13"></td>
        </tr>
        
        <tr>
            <td>Mail</td>
            <td> <input type="text" name="txtmail" value="@" size="35" maxlength="20"></td>
        </tr>



       
            <td>Descripcion</td>
            <td> <input type="text" name="txtdescripcion"  size="35" maxlength="120"></td>
        </tr>

        
        <td><center><button input type="submit" name="action" value="enviar" id="" title ="enviar">Enviar</button></center></td>

        

    </table>
 
            
           

</div>
</body>






</html>
