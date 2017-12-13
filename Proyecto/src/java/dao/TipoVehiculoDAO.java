package dao;
import java.sql.*;
import java.util.ArrayList;

public class TipoVehiculoDAO implements DAO{

    @Override
    public boolean alta(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Validar(String user, String pwd) {
        return null;
    }

    @Override
    public Object consultar(int id) {
        return null;
    }

    @Override
    public ArrayList consultaTotal() {
      ArrayList a = new ArrayList();
        
      try{
            Connection c = new DataSource().getConexion();
            String sql ="select * from tipoVehiculo";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                TipoVehiculo tp = new TipoVehiculo();                                  
                tp.setIdTipoVehiculo(rs.getInt("idtipoVehiculo"));
                tp.setNombreTipoVehiculo(rs.getString("nombretipoVehiculo"));         
                a.add(tp);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList llenarAlta(String tabla, String id, String descripcion) {
        return null;
    }
    
}
