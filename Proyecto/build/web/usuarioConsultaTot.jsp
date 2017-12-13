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
        <title>Consulta General de vehiculos</title>
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
            <input type="hidden" name="pagina" value="usuarioConsultaTot">
            
            <table>
                <tr>
                    <th>ID de Usuario</th>
                    <th>Nombre</th>
                    <th>Usuario</th>
                    <th>Contraseña</th>
                    <th>Tipo de Usuario</th>
                    <th>Estatus</th>
                </tr>

                
                <%UsuarioDAO us=new UsuarioDAO();
                TipoUsuarioDAO ob=new TipoUsuarioDAO();
                 
                ArrayList<Usuario> v = us.consultaTotal();
                ArrayList<TipoUsuario> ot = ob.consultaTotal(); %>
            
                <%for(int i=0;i<v.size();i++){ %>
                <tr>
                    <td><%=v.get(i).getIdUsuario() %> </td>
                    <td><%=v.get(i).getNombre()%></td>
                    <td><%=v.get(i).getUser()%></td>
                    <td><%=v.get(i).getPwd()%></td>
                    <td><%=ot.get(i).getDescripcion()%></td>
                    <td><%=v.get(i).getEstatus()%></td>
                </tr>
                <%} %> 
                   
            </table> 
            
        </form> 
    </body>
</html>
