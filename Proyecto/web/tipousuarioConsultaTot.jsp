<%-- 
    Document   : altaUsuario
    Created on : 9/10/2017, 12:37:48 PM
    Author     : lapjoselito
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.*"%>
<%@page import="dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%@taglib uri="/WEB-INF/tlds/Tag1" prefix="c"%>
    
    <head>
        <title>Alta Usuario</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
    </head>
    
    
    <head>
        <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 70%;
        }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
        </style>
    </head>
    
    <body>
        <form action="Control" method="POST">
            <input type="hidden" name="pagina" value="tipousuarioConsultaTot">
            
            <table>
                <tr>
                    <th>ID Tipo Usuario</th>
                    <th>Descripcion</th>
                </tr>

                
                <%TipoUsuarioDAO tUs=new TipoUsuarioDAO();
                 
                ArrayList<TipoUsuario> v = tUs.consultaTotal();
            
                <%for(TipoUsuario var:v){ %>
                
                <tr>
                    <td><%=v.get(i).getIdUsuario() %> </td>
                    <td><%=var.getNombre()%></td>
                    <td><%=var.getUser()%></td>
                    <td><%=var.getPwd()%></td>
                    <td><%=v.get(i).getIdUsuario() %></td>
                    <td><%=var.getEstatus()%></td>
                </tr>
                
                <%} %> 
                
                
            </table> 
            
        </form> 
    </body>
</html>
