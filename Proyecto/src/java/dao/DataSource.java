package dao;
import java.sql.*;

public class DataSource {
    private Connection c;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/BDProyecto","root","mistareas");
        }catch (Exception e){
            e.printStackTrace();
        }return c;
    }
}