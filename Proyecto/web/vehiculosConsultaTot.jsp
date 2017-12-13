<%-- 
    Document   : consultaVehiculos
    Created on : 27/11/2017, 01:23:46 PM
    Author     : lapjoselito
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@taglib uri="/WEB-INF/tlds/Tag1" prefix="c"%>
    
    <head>       
        <title>Consulta General de Vehiculos</title>
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
            <input type="hidden" name="pagina" value="vehiculosConsultaTot">
            
            <table>
                <tr>
                    <th>ID </th>
                    <th>Nombre del Vehiculo</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Año</th>
                    <th>Tipo de Vehiculo</th>
                    <th>Estatus</th>
                    <th>Kilometraje</th>
                    <th>Numero de Serie</th>
                    <th>Placa</th>
                    <th>Color</th>
                    <th>Compañia de Seguro</th>
                    <th>Poliza de Seguro</th>
                </tr>
            
            
            <%  VehiculoDAO vh=new VehiculoDAO();
                EstatusVehiculoDAO ev = new EstatusVehiculoDAO();
                TipoVehiculoDAO tv = new TipoVehiculoDAO();
                VehiculoMarcaDAO vm = new VehiculoMarcaDAO();           
            
                ArrayList<Vehiculo> v = vh.consultaTotal();
                ArrayList<TipoVehiculo> t = tv. consultaTotal();
                ArrayList<VehiculoMarca> m = vm.consultaTotal();
                ArrayList<EstatusVehiculo> e = ev.consultaTotal(); %>
            
                <%for(int i=0;i<v.size();i++){ %>
                <tr>
                    <td><%=v.get(i).getIdVehiculo()%> </td>
                    <td><%=v.get(i).getNombre()%></td>
                    <td><%=m.get(i).getNombre()%></td>
                    <td><%=v.get(i).getModelo()%></td>
                    <td><%=v.get(i).getAño()%></td>
                    <td><%=t.get(i).getNombreTipoVehiculo()%></td>
                    <td><%=e.get(i).getEstatus()%></td>
                    <td><%=v.get(i).getKilometraje()%></td>
                    <td><%=v.get(i).getNoSerie()%></td>
                    <td><%=v.get(i).getPlaca()%></td>
                    <td><%=v.get(i).getColor()%></td>
                    <td><%=v.get(i).getCompañiaSeguro()%></td>
                    <td><%=v.get(i).getPolizaSeguro()%></td>
                </tr>
                <%} %> 
            </table> 
            
        </form>
    </body>
</html>
