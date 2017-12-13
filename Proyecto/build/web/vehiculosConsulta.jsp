<%-- 
    Document   : consultaVehiculos
    Created on : 27/11/2017, 01:23:46 PM
    Author     : lapjoselito
--%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Control" method="POST">   
            <input type="hidden" name="pagina" value="vehiculosConsulta">
            
            <%VehiculoDAO veh=new VehiculoDAO();
            Vehiculo v = (Vehiculo) veh.consultar(Integer.parseInt(request.getParameter("id"))); %>
            
            <input type='hidden' name='id' value=<%=request.getParameter("id") %> > <br><br>
                
            Nombre: <input type='text' name='nombre' value=<%=v.getNombre() %>> <br>
            Marca <input type='text' name='marca' value=<%=v.getMarca() %> ><br>
            Modelo: <input type='text' name='modelo' value=<%=v.getModelo() %> ><br>
            Año: <input type='text' name='ano' value=<%=v.getAño() %> ><br>
            Tipo de Vehiculo: <input type='tipoVehiculo' name='sexo' value=<%=v.getTipoVehiculo() %> ><br>
            Estatus: <input type='text' name='estatus' value=<%=v.getEstatus() %> ><br>
            Kilometraje: <input type='text' name='kilometraje' value=<%=v.getKilometraje() %> ><br>
            No. de Serie: <input type='text' name='noSerie' value=<%=v.getNoSerie() %> ><br>
            Placa <input type='text' name='placa' value=<%=v.getPlaca() %> ><br>
            Color <input type='text' name='color' value=<%=v.getColor() %> ><br>
            Compañia de Seguro: <input type='text' name='compañiaSeguro' value=<%=v.getCompañiaSeguro() %> ><br>
            Poliza de Seguro: <input type='text' name='polizaSeguro' value=<%=v.getPolizaSeguro() %> ><br>
            
            <input type='submit' value='Actualizar'>
            <input type='reset' value='Cancelar'>   
                        
        </form>
    </body>
</html>
