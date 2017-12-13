package dao;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO implements DAO{

    @Override
    public boolean alta(Object o) {
        boolean b=false;
        try{
            Connection c = new DataSource().getConexion();
            String sql = "insert into Usuario(nombre,user,pwd,idTipoUsuario,estatus)"
                    + " values (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            
            Usuario us = (Usuario) o;
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getUser());
            ps.setString(3, us.getPwd());
            ps.setInt(4, us.getIdTipoUsuario());
            ps.setInt(5, us.getEstatus());
            
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
            String sql ="Update Usuario set nombre=?,user=?,pwd=?,idTipoUuario=?,estatus=? where idUsuario=?";
            PreparedStatement ps = c.prepareStatement(sql);
            
            Usuario us = (Usuario) o;
            ps.setString(1,us.getNombre());
            ps.setString(2,us.getUser());
            ps.setString(3,us.getPwd());
            ps.setInt(4,us.getIdTipoUsuario());
            ps.setInt(5,us.getEstatus());
            
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
        Usuario u = null;
        try{
            Connection c = new DataSource().getConexion();
            String sql="select * from Usuario where user=? and pwd=?";
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setString(1,user);
            ps.setString(2,pwd);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                u.setUser(rs.getString("user"));
                u.setPwd(rs.getString("pwd"));
                u.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                u.setEstatus(rs.getInt("estatus"));
            }
            rs.close();
            ps.close();
            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return u;
    }


    @Override
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
        Usuario us = new Usuario();
        try{
            Connection c = new DataSource().getConexion();
            String sql = "select * from Usuario where idUsuario = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet r = ps.executeQuery();
                if(r.next()){
                    us.setIdUsuario(r.getInt("idUsuario"));
                    us.setNombre(r.getString("nombre"));
                    us.setUser(r.getString("user"));
                    us.setPwd(r.getString("pwd"));
                    us.setIdTipoUsuario(r.getInt("idTipoUsuario"));
                    us.setEstatus(r.getInt("estatus"));                                       
                }
                
                r.close();
                ps.close();
                c.close();
            
        }catch(Exception e ){
            e.printStackTrace();
        }
        return us;
    }

    @Override
    public ArrayList consultaTotal() {    
        ArrayList a = new ArrayList();
        
        try{
            Connection c = new DataSource().getConexion();
            String sql ="select idUsuario,nombre,user,pwd,tipousuario.descripcion,estatus"
                    + " from usuario "
                    + "inner join tipousuario on usuario.idTipoUsuario=tipousuario.idTipoUsuario\n "
                    + "order by 1";

//            String sql ="select * from Usuario";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Usuario us = new Usuario();
                TipoUsuario tUs = new TipoUsuario();
                                   
                us.setIdUsuario(rs.getInt("idUsuario"));
                us.setNombre(rs.getString("nombre"));
                us.setUser(rs.getString("user"));
                us.setPwd(rs.getString("pwd"));
                tUs.setDescripcion(rs.getString("descripcion"));
//                us.setDescripcion(rs.getString("tipousuario.descripcion"));
                us.setEstatus(rs.getInt("estatus"));
                a.add(us);
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
            String sql = "delete from Usuario where idUsuario = ?";
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
