0<%
String targetModulo = request.getAttribute("targetModulo") == null ? "FBlanco.jsp":(String)request.getAttribute("targetModulo");
%>
 <link rel="stylesheet" type="text/css" href="css/estilo.css"/>    

<br>
<table>
    <tr>
        <td width="60%">
        <jsp:include page="FMenu.jsp" flush="true"></jsp:include>
        </td>
        <td width="*">
           
         <jsp:include page="<%=targetModulo%>" flush="true"></jsp:include>
         
        </td>
    </tr>
</table>
 