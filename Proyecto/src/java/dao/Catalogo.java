package dao;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class Catalogo extends TagSupport {
    
    private String id;
    private String descripcion;

    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
    
}
