<%-- 
    Document   : altaUsuario
    Created on : 9/10/2017, 12:37:48 PM
    Author     : lapjoselito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%@taglib uri="/WEB-INF/tlds/Tag1" prefix="c"%>
    
    <head>
        <title>Alta Usuario</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
    </head>
    
    <style> 
        form {
            border: 3px solid #f1f1f1;
        }

        h1{
            color: #000; 
            font: bold;
            padding-bottom: 50px;
        }
        
        h2{
            color: white; 
        }

        .container {
            padding_top: 50px;
            padding-bottom: 100px; 
            padding-left: 150px;
            padding-right: 150px;
        }
        
        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 30px) {
            span.psw {
               display: block;
               float: inside;
            }
    </style> 
    
    
    <body background="usus.png" 
          style=" background-repeat:no-repeat; background-position: right ; background-size: contain " >
        
        <form action="Control" method="POST">
            <input type="hidden" name="pagina" value="usuarioAlta">
            <center>
                <h1>Alta de Usuario</h1>
            </center><br>
            
            <table>
                <tr><td>Nombre :</td>
                    <td><input type='text' name ="nombre"></td>
                </tr>
                <tr><td>User :</td>
                    <td><input type='text' name ="user"></td>
                </tr>
                <tr><td>Password : </td>
                    <td><input type='text' name ="pwd"></td>
                </tr>
                <tr><td>Tipo Usuario :</td>
                    <td><c:llenarAlta tabla="TipoUsuario" id="idTipoUsuario" descripcion="descripcion"/>
<!--                        
                        <input type='text' name ="tipoUsuario">
-->                        
                    </td>
                </tr>
                <tr><td>Estatus :</td>
                    <td>                        
                        <select name = 'estatus'>
                            <option value ='0'>Inactivo</option>
                            <option value ='1'>Activo</option>            
                        </select>                        
                    </td>
                </tr>  
            </table>
            
            <table>
                <input type="submit" value="Aceptar">
                <input type="reset" value="Cancelar">
            </table> 

            <br><br><br><br><br><br><br><br><br>
            
            <span class="psw">C-Fleet v1.0 @JACS 18_1.2017</span>
            
        </form> 
    </body>
</html>
