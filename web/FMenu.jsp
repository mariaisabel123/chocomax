
<%@page import="chocomax.entidades.Usuario"%>

<%
Usuario entUsuario =(Usuario) session.getAttribute("usuario");
String user = entUsuario.getUsuario();
String nombre = entUsuario.getNombre();
String perfil = entUsuario.getPerfil();
String estado = entUsuario.getEstado();
%>
<div style="position: absolute;  height: 100px;z-index: 1;left: 20px; top: 200px ">
    <ul id="cssmenu" >
        <% if(!"0".equals(user)){%>      
        <% if(!"Inactivo".equals(estado)){%>      
         <li> <%=nombre%></li> 
        <% if("admin".equals(perfil)){%>      
        <li><font color="tan"><a href="./UsuarioServlet?action=mostrar" title="Usuarios">Admin Usuarios</a></font></li>
        <li><font color="tan"><a href="ClienteServlet" title="">Cliente</a></font></li>
        <li><font color="tan"><a href="productos.jsp" title="">Productos</a></font></li>
        <li><font color="tan"><a href="FVentas.jsp" title="">Ventas</a></font></li>
        
        <%}%>
        
          <% if("cliente".equals(perfil)){%>      
    
        <li><font color="tan"><a href="ClienteServlet" title="">Cliente</a></font></li>
        <li><font color="tan"><a href="productos.jsp" title="">Productos</a></font></li>
        <li><font color="tan"><a href="FPedidos.jsp" title="">Pedidos</a></font></li>
     
        <%}%>
        
       
       <li><font color="tan"> <a href="./UsuarioServlet?action=salir" title="Cerrar sesion">Cerrar Sesion</a></font></li>
        <%}else{%>
        <tr><td>!..Usted no está Activo..¡</td></tr>
        <%}%>
        <%}else{%>
        <tr><td>Error al Ingresar al sistema..</td></tr>
         <%}%>
    </ul>    
    

</div>