<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<% 
  String target= request.getAttribute("target")!=null?(String)request.getAttribute("target"):"FLoginBox.jsp";


%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chocomax</title>
        <link rel="shortcut icon" href="favicon.ico" >
        <link rel="stylesheet" type="text/css" href="css/estilo.css"/>
     
 </head>
    <body >
    <table>
    <tr>
    <td><jsp:include page="<%=target%>" flush="true"></jsp:include></td>

    </tr>      
    </table>
    
     <div id="layer1" style="position: absolute; width:300px; height: 300px; z-index: 1; left: 600px; top: 68px">
      <img alt="" height="290" src="imagenes/logo.png" width="350" /></div>
                 
  
    </body>
</html>
