<%-- 
    Document   : gasolina
    Created on : 10/11/2017, 02:34:20 AM
    Author     : lapjoselito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style> 
        form {
            border: 3px solid #f1f1f1;
        }

        h1{
            color: #ffffff; 
            font: bold;
            padding-bottom: 60px;
        }
        
        h2{
            color: white; 
        }

        .container {
            padding_top: 50px;
            padding-bottom: 180px; 
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
    
    <body background="gas.png" 
          style=" background-repeat:no-repeat; background-position: right; background-size:  contain" >
        <form action="Control" method="POST">
            <input type="hidden" name="pagina" value="gasolina">
        <legend>Vehiculo/Cargas de Combustible</legend><br><br>
    
    <legend>Informacion de Referencia:</legend>
    <table>
        <tr><td>Fecha</td>
            <td><input type="text" name="fecha" placeholder="Ej. Fecha de Carga" value="" data-required="true" maxlength="10"></td>       
            <td>Hora</td>
            <td><input type="text" name="hora" placeholder="Ej. Hora de Carga" value="" data-required="true" maxlength="6"></td>  
            <td>Referencia</td>
            <td><input type="text" name="referencia" placeholder="Ej. # de Ticket" value="" data-required="true"></td>                    
        </tr>
    </table>
    <br>
    
    
    <legend>Valores de Carga</legend>
    <table>
        <tr><td>Cantidad</td>
            <td><input type="text" name="cantidad" placeholder="litros(lts.)" value="" required>*</td>                    
            <td>Costo Unitario</td>
            <td><input type="text" name="counitario" placeholder="$$$" value="" required>*</td>  
        </tr>
    </table>
    <br>
    <table>
        <input type="submit" value="Guardar">
        <input type="reset" value="Cancelar">
    </table>    
    
    <br><br><br><br><br><br><br><br>
    
    <span class="psw">C-Fleet v1.0 @JACS 18_1.2017</span>
        
    </body>
</html>
