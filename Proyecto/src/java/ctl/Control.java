package ctl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Unitec
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String pagina = request.getParameter("pagina");
        
        if(pagina.equals("usuarioAlta")){
            usuarioAlta(request,response);            
        }
        if(pagina.equals("usuarioConsultaTot")){
            usuarioConsultaTot(request,response);            
        }        
        if(pagina.equals("usuarioActualizar")){
            usuarioActualizar(request,response);            
        }
        if(pagina.equals("sesion")){
            sesion(request,response);            
        }    
        if(pagina.equals("vehiculosActualizar")){
            vehiculosActualizar(request,response);            
        }
        if(pagina.equals("vehiculosAlta")){
            vehiculosAlta(request,response);            
        }
        if(pagina.equals("vehiculosConsultaTot")){
            vehiculosConsultaTot(request,response);            
        }
        if(pagina.equals("gasolina")){
            gasolina(request,response);            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


    private void usuarioAlta(HttpServletRequest request, HttpServletResponse response) throws IOException{
    
        Usuario us = new Usuario();        
        us.setNombre(request.getParameter("nombre"));
        us.setUser(request.getParameter("user"));
        us.setPwd(request.getParameter("pwd"));
        us.setIdTipoUsuario(Integer.parseInt(request.getParameter("idTipoUsuario")));
        us.setEstatus(Integer.parseInt(request.getParameter("estatus")));
        
        UsuarioDAO usDAO = new UsuarioDAO();
        boolean b = usDAO.alta(us);
        if(b)
            response.sendRedirect("index.html");
        else
            response.sendRedirect("usuarioAlta.jsp");
        }


    private void usuarioActualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usu = new Usuario();
        usu.setNombre(request.getParameter("nombre"));
        usu.setUser(request.getParameter("user"));
        usu.setPwd(request.getParameter("pwd"));
        usu.setIdTipoUsuario(Integer.parseInt(request.getParameter("TipoUsuario")));
        usu.setEstatus(Integer.parseInt(request.getParameter("estatus")));

        UsuarioDAO uDAO = new UsuarioDAO();
        boolean b= uDAO.actualizar(usu);
        if(b)
         response.sendRedirect("index.jsp");
        else
            response.sendRedirect("actualizarpersona.jsp");
               
    }

    private void sesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        
        UsuarioDAO usd = new UsuarioDAO();
        Usuario u = (Usuario) usd.Validar(user,pwd);  
        
        if(u==null){ //Si el usuario no existe, entonces..
//            String message = (String) request.getAttribute ("Usuario y/o contraseña invalido");
            response.sendRedirect("sesion.jsp");                                             
                       
        }else{
            if(u.getIdTipoUsuario()==1){
                response.sendRedirect("menuAdmin.jsp");
            }
            if(u.getIdTipoUsuario()==2){
                response.sendRedirect("menuNormal.jsp");
            }
            
            //Bean
//            HttpSession session = request.getSession();
//            session.setAttribute("user",u);//obtener variables de la sesión
//            //session.setAttribute("nombre variable de sesión", <objeto que quieres almacenar en sesión>);
//            System.out.println(session);
//            String nombre = (String)session.getAttribute("user");//guarda todo como Object, el casteo es obligatorio
//            
            
//            <% 
//            String mensaje="<script language='javascript'> alert('Usuario y/o contraseña invalido'); </script>"; 
//            out.println(mensaje); 
//            %> 
            
        }
    }

    private void vehiculosAlta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Vehiculo ve = new Vehiculo();
        ve.setNombre(request.getParameter("nombre"));  
        ve.setMarca(Integer.parseInt(request.getParameter("marcaVehiculo")));
        ve.setModelo(request.getParameter("modelo"));
        ve.setAño(Integer.parseInt(request.getParameter("ano")));
        ve.setTipoVehiculo(Integer.parseInt(request.getParameter("tipoVehiculo")));
        ve.setEstatus(Integer.parseInt(request.getParameter("estatusVehiculo")));      
        ve.setKilometraje(Integer.parseInt(request.getParameter("kilometraje")));
        ve.setNoSerie(request.getParameter("noSerie"));
        ve.setPlaca(request.getParameter("placa"));
        ve.setColor(request.getParameter("color"));
        ve.setCompañiaSeguro(request.getParameter("companiaSeguro"));
        ve.setPolizaSeguro(request.getParameter("polizaSeguro"));        
        
        VehiculoDAO vhDAO = new VehiculoDAO();
        boolean b = vhDAO.alta(ve);        
        if(b)//Si se creo
            response.sendRedirect("index.html");
        else//Si no se creo
            response.sendRedirect("vehiculosAlta.jsp");
    }

    private void vehiculosConsultaTot(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList a = new ArrayList();
        
        Vehiculo ve = new Vehiculo();
        EstatusVehiculo ev = new EstatusVehiculo();
        TipoVehiculo tv = new TipoVehiculo();
        VehiculoMarca vm = new VehiculoMarca();        
        
        ve.setIdVehiculo(Integer.parseInt(request.getParameter("id")));
        ve.setNombre(request.getParameter("nombre"));  
        vm.setNombre(request.getParameter("nombreMarca"));
//        ve.setMarca(Integer.parseInt(request.getParameter("marcaVehiculo")));
        ve.setModelo(request.getParameter("modelo"));
        ve.setAño(Integer.parseInt(request.getParameter("ano")));
        tv.setNombreTipoVehiculo(request.getParameter("nombretipoVehiculo"));
        ev.setEstatus(request.getParameter("estatus"));
//        ve.setTipoVehiculo(Integer.parseInt(request.getParameter("tipoVehiculo")));
//        ve.setEstatus(Integer.parseInt(request.getParameter("estatusVehiculo")));      
        ve.setKilometraje(Integer.parseInt(request.getParameter("kilometraje")));
        ve.setNoSerie(request.getParameter("noSerie"));
        ve.setPlaca(request.getParameter("placa"));
        ve.setColor(request.getParameter("color"));
        ve.setCompañiaSeguro(request.getParameter("companiaSeguro"));
        ve.setPolizaSeguro(request.getParameter("polizaSeguro"));  
  
        VehiculoDAO vDAO = new VehiculoDAO();
        a.add(ve);

        a= vDAO.consultaTotal();    
    }

    private void vehiculosActualizar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void gasolina(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void usuarioConsultaTot(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList a = new ArrayList();
        
        Usuario us = new Usuario();
        TipoUsuario tUs = new TipoUsuario();
        
        us.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
        us.setNombre(request.getParameter("nombre"));  
        us.setUser(request.getParameter("user"));  
        us.setPwd(request.getParameter("pwd"));  
        tUs.setDescripcion(request.getParameter("descripcion"));
//        us.setIdTipoUsuario(Integer.parseInt(request.getParameter("idTipoUsuario")));
        us.setEstatus(Integer.parseInt(request.getParameter("estatus")));  
        
        UsuarioDAO uDAO = new UsuarioDAO();
        a.add(us);
        a = uDAO.consultaTotal();
        
    }
}




