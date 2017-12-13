package dao;
import java.sql.*;
import java.util.ArrayList;

public class TipoUsuarioDAO implements DAO {

    @Override
    public boolean alta(Object o) {
        boolean b=false;
        try{
            Connection c = new DataSource().getConexion();
            String sql = "insert into TipoUsuario(descripcion)"
                    + " values (?)";
            PreparedStatement ps = c.prepareStatement(sql);
            
            TipoUsuario tu = (TipoUsuario) o;
            ps.setString(1, tu.getDescripcion());
            
            int r = ps.executeUpdate();
            if(r > 0){
                b = true;
            }
            
            ps.close();
            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean actualizar(Object o) {
        boolean b=false;
        try{
            Connection c = new DataSource().getConexion();
            String sql ="Update TipoUsuario set descripcion=? where idTipoUsuario=?";
            PreparedStatement ps = c.prepareStatement(sql);
            
            TipoUsuario tu = (TipoUsuario) o;
            ps.setString(1,tu.getDescripcion());          
           
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

    @Override
    public Object Validar(String user, String pwd) {
        return null; // Se pone null porque el metodo no tendra funcionalidad
    }

    @Override
    public ArrayList llenarAlta(String tabla, String id, String descripcion) {
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
            String sql ="select * from TipoUsuario";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                TipoUsuario tu = new TipoUsuario();                                  
                tu.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                tu.setDescripcion(rs.getString("descripcion"));         
                a.add(tu);
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
            String sql = "delete from TipoUsuario where idTipoUsuario = ?";
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
