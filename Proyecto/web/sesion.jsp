<%-- 
    Document   : Sesion
    Created on : 5/11/2017, 02:00:54 PM
    Author     : lapjoselito
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="dao.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion @C-Fleet</title>
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

input[type=text], input[type=password] {
    width: 100%;
    padding: 10px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.container {
    padding_top: 50px;
    padding-bottom: 240px; 
    padding-left: 150px;
    padding-right: 150px;
}

.containerCan {
    padding: 10px;
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
    .cancelbtn {
       width: 100%;
    }
}

</style> 
   

<body background="imgMBenz.jpg">
        <!--<img src="imgMBenz.jpg" style="max-width: 100px; max-height: 100px">-->
        <form action="Control" method="POST">
            <input type="hidden" name="pagina" value="sesion">          
            
            <center>
               <h1>CONTROL DE FLOTILLAS</h1>  
            </center>
                
            
            <div class="containerTotal">            
                <div class="container">
                    <label><b>Usuario:</b></label>
                    <input type="text" placeholder="Enter Username" name="user" required>

                    <label><b>Contraseña:</b></label>
                    <input type="password" placeholder="Enter Password" name="pwd" required>

                    <button type="submit">Login</button>
                </div>
            </div>    

            <div class="containerCan" style="background-color:#f1f1f1">
              <button type="button" class="cancelbtn">Cancelar</button>   
              <span class="psw">C-Fleet v1.0 @Copyright_2017</span>
            </div>
            
            <!--
            <br>
            <center>
                <h1>CONTROL DE FLOTILLAS</h1>
                <table>
                    <tr><td><span>Usuario:</span></td>
                        <td><input type="text" name="user" class="texto"></td><br>
                    </tr>
                    <tr><td><span>Contraseña:</span></td>
                        <td><input type="password" name="pwd" class="texto"></td><br> 
                    </tr>
                </table>                
                <br>
                <input type="submit" name="enviar" value="Ingresar">
                <input type="reset" name="cancelar" value="Cancelar">  
            </center>        
            -->           
           
        </form>
    </body>
</html>
