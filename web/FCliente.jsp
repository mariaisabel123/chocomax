
<%@page import="chocomax.entidades.Cliente"%>
<%@page import="java.util.List"%>
<%
  String codcliente=request.getParameter("txtcodcliente");
  String nombre = request.getParameter("txtnombre");
  String apellido1 =request.getParameter("txtapellido1");
  String apellido2 =request.getParameter("txtapellido2");
  String telefono = request.getParameter("txttelefono");
  String mail = request.getParameter("txtmail");
  String direccion = request.getParameter("txtdireccion");
  String estado = request.getParameter("txtestadocliente");
  
  
String men =(String)request.getAttribute("mensajes");
String dat =(String)request.getAttribute("datos");  
List<Cliente> LC = (List<Cliente>)request.getAttribute("listado")!= null?
         (List<Cliente>)request.getAttribute("listado"):null;


Cliente encliente = (Cliente)request.getAttribute("datocliente")!= null?
        (Cliente)request.getAttribute("datocliente"): null;

if (encliente != null) {
        codcliente = encliente.getCodcliente();
        nombre = encliente.getNombre();
        apellido1 = encliente.getPrimerapellido();
        apellido2 = encliente.getSegundoapellido();
        telefono = encliente.getTelefono();
        mail = encliente.getMail();
        direccion = encliente.getDireccion();
        estado = encliente.getEstado();


    }//fin si 


%>

<html>
<head><title> Cliente </title></head>
<body>


<style>

body {

background: #e1c192 url(css/Imagenes/fondo.png);
</style>



<h1><center><font color="tan">ABRE UNA CUENTA EN CHOCOMAX.</font></center></h1>

<head>
<link rel="stylesheet" type="text/css" href="css/Estilo.css"></link>
</head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro de clientes</title></head>
<body>

<div id="formulario">
<form action = "./ClienteServlet" method = "post"  >




    <table>


        <tr>
            <td>Codigo cliente</td>
            <td> <input type="text" name="txtcodcliente" value="<%=codcliente != null ? codcliente : ""%>"size="35" maxlength="13"></td>
            <td>Nombre</td>
            <td> <input type="text" name="txtnombre" value="<%=codcliente != null ? nombre : ""%>" size="35" maxlength="20"></td>
        </tr>



        <tr>
            <td>Primer Apellido</td>
            <td> <input type="text" name="txtapellido1" value="<%=codcliente != null ? apellido1 : ""%>"size="35" maxlength="20"></td>
            <td>Segundo Apellido</td>
            <td> <input type="text" name="txtapellido2" value="<%=codcliente != null ? apellido2 : ""%>" size="35" maxlength="20"></td>
        </tr>


        <tr>
            <td>Tel&#233;fono</td>
            <td> <input type="text" name="txttelefono" value="<%=codcliente != null ? telefono : ""%>"size="35" maxlength="8"></td>
            <td>Email</td>
            <td> <input type="text" name="txtmail" value="<%=codcliente != null ? mail : ""%>" size="35" maxlength="100" ></td>
        </tr>

        <tr>
            <td>Direccion</td>
            <td> <input type="text" name="txtdireccion" value="<%=codcliente != null ? direccion : ""%>" size="35" maxlength="20"></td>
            <td>Estado cliente</td>
            <td><input type="radio" name="txtestado cliente" value="Activo" checked>Activo
                <input type="radio" name="txtestado cliente" value="Inactivo" checked>Inactivo
        </tr>

    </table>
    
    
    
            <jsp:include page="FBotones.jsp" flush="true"/>
    
            <br>Datos enviados<%=dat%>
            <br>Mensaje recibido<%=men%>
            <%if (LC != null) {%>
            
            
            <table border="1" id="tabla">
                    <tr id="titulo">
                    <td>Codigo cliente</td>
                    <td>Nombre</td>
                    <td>Apellido 1</td>
                    <td>Apellido 2</td>
                    <td>Tel&#233;fono</td>
                    <td>Email</td>
                    <td>Direccion</td>
                    <td>Estado</td>
                </tr>
                <!--Recorrer para cargar datos-->
      <%for(Cliente c: LC){ %> 
      <tr>
          <td><%=c.getCodcliente()%></td>
          <td><%=c.getNombre()%></td>
          <td><%=c.getPrimerapellido()%></td>
          <td><%=c.getSegundoapellido()%></td>
          <td><%=c.getTelefono()%></td>
          <td><%=c.getMail()%></td>
          <td><%=c.getDireccion()%></td>
          <td><%=c.getEstado()%></td>
          
          
      </tr>
      <%}%>  
            </table>
            <%}%>
</form>
</div>
</body>






</html>
















