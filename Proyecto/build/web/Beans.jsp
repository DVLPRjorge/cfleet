<%-- 
    Document   : Beans
    Created on : 10/12/2017, 10:44:37 PM
    Author     : lapjoselito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>    
    <%@page import="dao.*" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    
    <body>
        
        <% 
            request.setAttribute("usuarioSesion","dao.Usuario");
        %>

        <jsp:forward page="/menuAdmin.jsp"/>

    </body>
    
</html>
