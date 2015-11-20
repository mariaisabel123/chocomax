<style>

body {

background: #e1c192 url(css/Imagenes/fondo.png);
</style>


<%
String mensajeError = (String) request.getAttribute("mensajeError");
String usuario = request.getParameter("usuario") == null ? "" : request.getParameter("usuario");
//String usuario = request.getParameter("usuario");
%>
<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
     
<script LANGUAGE= "javascript" TYPE="text/javascript" src="./scripts/validar.js"></script>
</script>
 <script type="text/javascript">
    function popup(url,ancho,alto) {
    var posicion_x; 
    var posicion_y; 
    posicion_x=(screen.width/2)-(ancho/2); 
    posicion_y=(screen.height/2)-(alto/2); 
    window.open(url, "tusitio.com", "width="+ancho+",height="+alto+",menubar=0,toolbar=0,directories=0,scrollbars=no,resizable=no,left="+posicion_x+",top="+posicion_y+"");
    }
    </script>


<div  style="position: absolute; width: 180px; height: 100px; z-index: 1; left: 20px; top: 200px" >
    <p>
    <form id="fondoformulario" name ="xForm" method="POST" action="./Autenticacion" Onsubmit= "return valida_envia();"/>
       
 <table>
        <tr>
            <td><font color="tan">Usuario</font></td>
            <td>
            <input name="txtusuario" type="text" class="texto"  id ="estilo" value="<%=usuario%>" size="10">
            </td>       </tr>
        <tr>
            <td><font color="tan">Clave</font></</td>
            <td>
                <input name="txtclave" id="estilo" class="texto" type="password" value="" size="10">
            </td> 
        </tr>
         <tr>
           
            <td><button type="submit" name="action"  value="ingresar" class="btn1"> Aceptar</button></td>
         <td>   <a href="javascript:popup('FEnvioMail.jsp',500,400)">
                 <button type="submit" name="action"  value="ingresar" class="btn1">Recordar clave</a></button></td>
                
                
                </div> 
             </tr>
        <%if (mensajeError != null) {%>
       		
	   <div id="dialog" title="Ingreso a citas">
                <%=mensajeError%>
       
           </div>     
        <%}%>
   </table>
        
</form>
</p>
</div>

