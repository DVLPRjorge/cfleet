package taglib;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import dao.*;
import java.util.ArrayList;

public class TagVehiculos extends TagSupport {
    private String tabla;
    private String id;
    private String descripcion;
    
    public String getTabla() {
        return tabla;
    }
    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int doStartTag()throws JspException{
        JspWriter out = pageContext.getOut();
        try{           
            VehiculoDAO vhdao = new VehiculoDAO();
            ArrayList lista = vhdao.llenarAlta(tabla, id, descripcion);
            out.println("<select name='"+tabla+"' >");
            
            for (int i = 0; i < lista.size(); i++) {
                Catalogo c = (Catalogo) lista.get(i);
                out.println("<option value='"+c.getId()+"'>"+c.getDescripcion()+"</option>");
            }
            out.println("</select>");            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    return SKIP_BODY;
    }
    
//    public int doEndTag(){} /* No requiere dicho metodo ya que no se necesita un cuerpo o BODY.
//                          Ademas se hace enfansis con el "return SKIP_BODY;" del metodo doStartTag() */ 
 
}
