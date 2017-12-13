package dao;
import java.sql.*;
import java.util.ArrayList;

public class VehiculoDAO implements DAO{

    @Override
    public boolean alta(Object o) {
        boolean b= false;
        try{
            Connection c = new DataSource().getConexion();
            String sql = "insert into Vehiculo(nombre,marca,modelo,año,tipoVehiculo,"
                    + "estatus,kilometraje,noSerie,placa,color,compañiaSeguro,polizaSeguro) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            
            Vehiculo ve = (Vehiculo) o;
            ps.setString(1,ve.getNombre());           
            ps.setInt(2,ve.getMarca());                
            ps.setString(3,ve.getModelo());
            ps.setInt(4,ve.getAño());
            ps.setInt(5,ve.getTipoVehiculo());
            ps.setInt(6,ve.getEstatus());
            ps.setInt(7,ve.getKilometraje());
            ps.setString(8,ve.getNoSerie());
            ps.setString(9,ve.getPlaca());
            ps.setString(10,ve.getColor());
            ps.setString(11,ve.getCompañiaSeguro());
            ps.setString(12,ve.getPolizaSeguro());
            int r = ps.executeUpdate();          
            
            if(r>0){
                b=true;
                c.close();
                ps.close();
            }    
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }


    @Override
    public boolean actualizar(Object o) {
        boolean b= false;
        try{
            Connection c = new DataSource().getConexion();
            String sql = "Update Vehiculo set nombre=?,marca=?,modelo=?,año=?,tipoVehiculo=?,"
                    + "estatus=?,kilometraje=?,noSerie=?,placa=?,color=?,compañiaSeguro=?,polizaSeguro=?) "
                    + "where idVehiculo=?";
            PreparedStatement ps = c.prepareStatement(sql);
            
            Vehiculo ve = (Vehiculo) o;
            ps.setString(1,ve.getNombre());
            ps.setInt(2,ve.getMarca());
            ps.setString(3,ve.getModelo());
            ps.setInt(4,ve.getAño());            
            ps.setInt(5,ve.getTipoVehiculo());
            ps.setInt(6,ve.getEstatus());
            ps.setInt(7,ve.getKilometraje());
            ps.setString(8,ve.getNoSerie());
            ps.setString(9,ve.getPlaca());
            ps.setString(10,ve.getColor());
            ps.setString(11,ve.getCompañiaSeguro());
            ps.setString(12,ve.getPolizaSeguro());
            int r = ps.executeUpdate();

            if(r>0){
                b=true;
                c.close();
                ps.close();
            }    
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public Object Validar(String user, String pwd) {
        return null;
    }

    @Override /*En "vehiculDAO" debe estar este metodo que pase las variables del TagLib, 
                ya quede de lo contrario saldran vacios los ComboBox en el JSP */
    public ArrayList llenarAlta(String tabla, String id, String descripcion) {
        ArrayList lista = null;
        try{
            Connection c = new DataSource().getConexion();
            String sql = "select * from "+tabla;
            PreparedStatement ps = c.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Catalogo cat= new Catalogo();
                cat.setId(rs.getString(id));
                cat.setDescripcion(rs.getString(descripcion));
                lista.add(cat);
            }
            rs.close();
            ps.close();
            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Object consultar(int id) {
        Vehiculo veh = new Vehiculo();
        try{
            Connection c = new DataSource().getConexion();
            String sql = "select * from Vehiculo where idVehiculo = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet r = ps.executeQuery();
                if(r.next()){
                    veh.setIdVehiculo(r.getInt("idVehiculo"));
                    veh.setNombre(r.getString("nombre"));
                    veh.setMarca(r.getInt("marca"));
                    veh.setModelo(r.getString("modelo"));
                    veh.setAño(r.getInt("año"));
                    veh.setTipoVehiculo(r.getInt("idTipoUsuario"));
                    veh.setEstatus(r.getInt("estatus"));
                    veh.setKilometraje(r.getInt("kilometraje"));
                    veh.setNoSerie(r.getString("noSerie"));
                    veh.setPlaca(r.getString("placa"));
                    veh.setColor(r.getString("color"));
                    veh.setCompañiaSeguro(r.getString("compañiaSeguro"));
                    veh.setPolizaSeguro(r.getString("polizaSeguro"));  
                    
                }
                
                r.close();
                ps.close();
                c.close();
            
        }catch(Exception e ){
            e.printStackTrace();
        }
        return veh;
    }

    @Override
    public ArrayList consultaTotal() {
        ArrayList a = new ArrayList();
        try{
            Connection c = new DataSource().getConexion();
            //String sql ="select * from Vehiculo";
            String sql ="select vh.idVehiculo,nombre,mv.nombreMarca,modelo,año,tv.nombretipoVehiculo,ev.estatus,"
                    + "kilometraje,noSerie,placa,color,compañiaSeguro,polizaSeguro\n" +
                        "from vehiculo vh\n" +
                        "inner join marcavehiculo mv on mv.idMarca=vh.marca\n" +
                        "inner join tipovehiculo tv on tv.idtipoVehiculo=vh.tipoVehiculo\n" +
                        "inner join estatusvehiculo ev on ev.idEstatus=vh.estatus\n "+
                        "order by 1"
                    ;
           
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Vehiculo vh = new Vehiculo();
                EstatusVehiculo ev = new EstatusVehiculo();
                TipoVehiculo tv = new TipoVehiculo();
                VehiculoMarca vm = new VehiculoMarca();
                                   
                vh.setIdVehiculo(rs.getInt("idVehiculo"));
                vh.setNombre(rs.getString("nombre"));
                vm.setNombre(rs.getString("nombremarca"));
//                vh.setMarca(rs.getInt("marca"));
                vh.setModelo(rs.getString("modelo"));
                vh.setAño(rs.getInt("año"));
                tv.setNombreTipoVehiculo(rs.getString("nombretipoVehiculo"));
                ev.setEstatus(rs.getString("estatus"));
//                vh.setTipoVehiculo(rs.getInt("tipoVehiculo"));
//                vh.setEstatus(rs.getInt("estatus"));
                vh.setKilometraje(rs.getInt("kilometraje"));
                vh.setNoSerie(rs.getString("noSerie"));
                vh.setPlaca(rs.getString("placa"));
                vh.setColor(rs.getString("color"));
                vh.setCompañiaSeguro(rs.getString("compañiaSeguro"));
                vh.setPolizaSeguro(rs.getString("polizaSeguro"));
                a.add(vh);     
                
            }
            rs.close();
            c.close();
            ps.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean Baja(int id) {
        boolean b = false;
        try {
            Connection c = new DataSource().getConexion();
            String sql = "delete from Vehiculo where idVehiculo = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setInt(1,id);
            int r = ps.executeUpdate();

            if(r>0){
                b=true;
            }
            ps.close();
            c.close();
        }catch(Exception e){
            e.printStackTrace();            
        }
        return b;
    }
    
}
