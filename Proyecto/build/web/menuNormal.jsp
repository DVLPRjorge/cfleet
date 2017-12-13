<%-- 
    Document   : vehiculosMenu
    Created on : 4/11/2017, 01:55:39 PM
    Author     : lapjoselito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU PRINCIPAL</title>
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
            padding-bottom: 230px; 
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
       
    

<body background="imgtrucks.jpg" >
    <form action="Control" method="POST">
        <input type="hidden" name="pagina" value="menuNormal">
    
        <!-- Insertar leyenda de BIENVENIDA al sistema con el nombre del usuario -->

        <center>
            <h1>MENU PRINCIPAL</h1>  
        </center>
        <br>

        <div class="container">
            <h2><b>Usuarios</b></h2>
                
            </form>

            <form name="IrRegistrarUsu" action="usuarioAlta.jsp" method="POST">
                <input type="submit" name="bRegistrarUsu" value="Registar Usuarios" style=" width:100%">
            </form>

        <br>

            <h2><b>Vehiculos</b></h2>

            <form name="IrRegistrarVeh" action="vehiculosAlta.jsp" method="POST">
                <input type="submit" name="bRegistrarVeh" value="Registar Vehiculos" style=" width:100%">
            </form>

            <form name="IrGasolinaVeh" action="gasolina.jsp" method="POST">
                 <input type="submit" name="bGasolinaVeh" value="Registrar Consumo de Gasolina" style=" width:100%"> 
            </form>  
        </div>

          <span class="psw">C-Fleet v1.0 @JACS 18_1.2017</span>
            
        </form>   
    
    </body>
</html>
