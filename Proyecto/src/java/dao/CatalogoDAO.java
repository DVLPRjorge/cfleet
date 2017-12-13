package dao;
import java.util.ArrayList;
import java.sql.*;

public class CatalogoDAO implements DAO{

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
        return null;
    }

    @Override
    public boolean Baja(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
