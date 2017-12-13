package dao;
import java.util.*;

public interface DAO {
    public boolean alta(Object o); 
    public boolean actualizar (Object o); 
    public Object Validar(String user, String pwd); 
    public Object consultar (int id); // consultaIndividual
    public ArrayList consultaTotal();//consultaGeneral
    public boolean Baja(int id);
    
    public ArrayList llenarAlta(String tabla, String id, String descripcion);
}

