<%-- 
    Document   : actualizarUsuario
    Created on : 11/10/2017, 11:32:35 AM
    Author     : lapjoselito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="Control" method="POST">
            <input type="hidden" name="pagina" value="usuarioActualizar">
            <center>
                <B> Actualizar Usuario</B>
            </center><br>
            <br>
            Selecciona el campo que desees modificar:<br>
            Nombre : <input type='text' name ="nombre"><br>
            User : <input type='text' name="user"><br>
            Password : <input type='text' name ="pwd"><br>
            Tipo Usuario : <input type="" name ="tipoUsuario"><br>
            Estatus : <select name = 'estatus'>
                <option value ='0'>Inactivo</option>
                <option value ='1'>Activo</option>
        </select>        
            <input type="submit" value ='Aceptar'>
            <input type="reset" value="Cancelar">
        </form> 
</html>
