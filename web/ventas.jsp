<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Estilo.css"></link>

<style>

body {

background: #e1c192 url(css/Imagenes/fondo.png);
</style>


</head>
<h1><center><font color="tan">VENTAS CHOCOMAX.</font></center></h1>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro de usuario</title></head>
<body>
<div id="formulario">
<form action = "mailto:lauramarin228@gmail.com" method = "post" enctype ="text/plain" >
<table>

<tr>
<td>Usuario</td>
<td>

<select name="utilizacion">
<option value="">.:.Seleccione.:.</option>

<option value="1">Administrador 
<option value="2">Empleado
</select></td>
</tr>



<tr>
<td>Producto vendido  </td>
<td> <input type="text" name="Producto vendido" size="20" maxlength="100" ></td>
</tr>
<table>
<tr>
<tr>
<td> Cantidad vendida </td>
<td> <input type="text" name="cantidad vendida" size="20" maxlength="3" ></td>
</tr>
<table>
<tr>

<td>Pedido</td>
<td>
<select name="cboperfil"id="">
<option value="">.:.Seleccione.:.</option>

<option value="Admin">Entregado</option>

<option value="Estudiante">Aplazado</option>

<option value="Profesor">Cancelado</option>

</select>
</table>







<table>
<tr>
<td><button input type="submit" name="accion" value="guardar"title="Guardar usuario">Guardar</button></td>
</table>

<table>
<td><button input type="reset" name="accion" value="cancelar"title="Limpiar datos"> Cancelar</button></td>
</tr>
</table>

<table>
<td><button input type="sumit" name="accion" value="actualizar"title="Actualizar datos"> Actualizar</button></td>
</tr>
</table>


</table>



</form>
</div>
</body>






</html>



