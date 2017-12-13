<%-- 
    Document   : vehiculosFRAME
    Created on : 4/11/2017, 11:51:51 AM
    Author     : lapjoselito
--%>
<%@page import="dao.Vehiculo"%>
<%@page import="dao.VehiculoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
    <%@taglib uri="/WEB-INF/tlds/Tag1" prefix="c"%>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALTA DE VEHICULOS</title>
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


    <body background="fleet-cover.jpg" 
          style=" background-repeat:no-repeat; background-position: right" >
        
        <form action="Control" method="POST"><!--El "action" debe ser "control" ya que este ultimo tiene la logica
                                            del TO y los JSP, y extraera los datos por medio del method "get"-->   
            <input type="hidden" name="pagina" value="vehiculosAlta">
            
            
            <center>
                <h1>CONTROL DE FLOTILLAS</h1>
            </center>
            
            <B>Registrar Vehiculos</B><br><br>
            
            <legend>Informacion Basica</legend><br>
            <table>
                <tr><td>Nombre del vehiculo</td>
                    <td><input type="text" name="nombre" placeholder="Ej. Jetta01," value="" required maxlength="70">*</td>                    
                </tr>
                <tr><td>Marca</td>
                    <td><c:llenarAlta tabla="marcaVehiculo" id="idMarca" descripcion="nombreMarca"/>
<!--                        
                        <select name="marca" id="marcaVehiculo" class="form-control" data-required="true">
                            <option value="0" >Chevrolet</option>
                            <option value="1" >Dodge</option>
                            <option value="2" >Ford</option>
                            <option value="3" >Nissan</option>
                            <option value="4" >Peugeot</option>
                            <option value="5" >VW</option>
                        </select>  
-->                       
                    </td>                    
                    <td>Modelo</td>
                    <td><input type="text" name="modelo" placeholder="Ej. Golf GLI" value="" required  maxlength="50">*</td>                    
                    <td>Año</td>
                    <td><input type="text" name="ano" placeholder="Ej. 2016" value="" required maxlength="4">*</td>                                       
                </tr>
            </table><br><br>

            <legend>Configuracion</legend><br> 
            <table>
                <tr><td>Tipo de Vehiculo</td>
                    <td><c:llenarAlta tabla="tipoVehiculo" id="idtipoVehiculo" descripcion="nombretipoVehiculo"/>                        
<!--                        
                        <select name="tipoVehiculo" id="tipoVehiculo" class="form-control" data-required="true">
                            <option value="0" >Autobus</option>
                            <option value="1" >Automóvil</option>
                            <option value="2" >Camión</option>
                            <option value="3" >Camioneta</option>
                            <option value="4" >SUV</option>
                            <option value="5" >Trailer</option>
                            <option value="6" >Van</option>
                        </select>   
-->
                    </td>                  
                </tr>
                <tr><td>Estatus</td>
                    <td><c:llenarAlta tabla="estatusVehiculo" id="idEstatus" descripcion="estatus"/>                        
<!--                        
                        <select name="estatus" id="estatus" class="form-control" data-required="true">
                            <option value='0'>Disponible</option>
                            <option value='1'>En taller</option>
                            <option value='2'>Fuera de servicio</option>
                            <option value='3'>Ocupado</option>
                        </select>                        
-->
                    </td>                  
                </tr>
                <tr><td>Kilometraje</td>
                    <td><input type="text" name="kilometraje" placeholder="(Km Actual o Inicial)" value="" required maxlength="6">*</td>
            </table><br><br>

            <legend>Informacion Adicional(opcional)</legend><br> 
            <table>
                <tr><td>No. de Serie</td>
                    <td><input type="text" name="noSerie" maxlength="17" required>*</td>
                </tr>
                <tr><td>Placa</td>
                    <td><input type="text" name="placa" maxlength="9" placeholder="PRS-33-61" required>*</td>
                    <td>Color</td>
                    <td><input type="text" name="color"></td>
                </tr>
                <tr><td>Compañia de Seguros</td>
                    <td><input type="text" name="companiaSeguro" placeholder="Zurich,Mapfre" ></td>                    
                    <td>Poliza de Seguros</td>
                    <td><input type="text" name="polizaSeguro"></td>   
                </tr>
            </table><br>

            <table>
                <input type="submit" value="Guardar">
                <input type="reset" value="Cancelar">
            </table>   
            
            <span class="psw">C-Fleet v1.0 @JACS 18_1.2017</span>
            
        </form>
    </body>   
</html>
