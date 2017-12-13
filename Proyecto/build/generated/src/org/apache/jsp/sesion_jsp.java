package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.UsuarioDAO;
import dao.Usuario;

public final class sesion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Iniciar Sesion @C-Fleet</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("   <style> \n");
      out.write("form {\n");
      out.write("    border: 3px solid #f1f1f1;\n");
      out.write("}\n");
      out.write("\n");
      out.write("h1{\n");
      out.write("    color: #ffffff; \n");
      out.write("    font: bold;\n");
      out.write("    padding-bottom: 60px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=text], input[type=password] {\n");
      out.write("    width: 100%;\n");
      out.write("    padding: 10px 20px;\n");
      out.write("    margin: 8px 0;\n");
      out.write("    display: inline-block;\n");
      out.write("    border: 1px solid #ccc;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("}\n");
      out.write("\n");
      out.write("button {\n");
      out.write("    background-color: #4CAF50;\n");
      out.write("    color: white;\n");
      out.write("    padding: 14px 20px;\n");
      out.write("    margin: 8px 0;\n");
      out.write("    border: none;\n");
      out.write("    cursor: pointer;\n");
      out.write("    width: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("button:hover {\n");
      out.write("    opacity: 0.8;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".cancelbtn {\n");
      out.write("    width: auto;\n");
      out.write("    padding: 10px 18px;\n");
      out.write("    background-color: #f44336;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".container {\n");
      out.write("    padding_top: 50px;\n");
      out.write("    padding-bottom: 240px; \n");
      out.write("    padding-left: 150px;\n");
      out.write("    padding-right: 150px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".containerCan {\n");
      out.write("    padding: 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("span.psw {\n");
      out.write("    float: right;\n");
      out.write("    padding-top: 16px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("/* Change styles for span and cancel button on extra small screens */\n");
      out.write("@media screen and (max-width: 30px) {\n");
      out.write("    span.psw {\n");
      out.write("       display: block;\n");
      out.write("       float: inside;\n");
      out.write("    }\n");
      out.write("    .cancelbtn {\n");
      out.write("       width: 100%;\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style> \n");
      out.write("   \n");
      out.write("\n");
      out.write("<body background=\"imgMBenz.jpg\">\n");
      out.write("        <!--<img src=\"imgMBenz.jpg\" style=\"max-width: 100px; max-height: 100px\">-->\n");
      out.write("        <form action=\"Control\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"pagina\" value=\"sesion\">          \n");
      out.write("            \n");
      out.write("            <center>\n");
      out.write("               <h1>CONTROL DE FLOTILLAS</h1>  \n");
      out.write("            </center>\n");
      out.write("                \n");
      out.write("            \n");
      out.write("            <div class=\"containerTotal\">            \n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <label><b>Usuario:</b></label>\n");
      out.write("                    <input type=\"text\" placeholder=\"Enter Username\" name=\"user\" required>\n");
      out.write("\n");
      out.write("                    <label><b>Contraseña:</b></label>\n");
      out.write("                    <input type=\"password\" placeholder=\"Enter Password\" name=\"pwd\" required>\n");
      out.write("\n");
      out.write("                    <button type=\"submit\">Login</button>\n");
      out.write("                </div>\n");
      out.write("            </div>    \n");
      out.write("\n");
      out.write("            <div class=\"containerCan\" style=\"background-color:#f1f1f1\">\n");
      out.write("              <button type=\"button\" class=\"cancelbtn\">Cancelar</button>   \n");
      out.write("              <span class=\"psw\">C-Fleet v1.0 @Copyright_2017</span>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <!--\n");
      out.write("            <br>\n");
      out.write("            <center>\n");
      out.write("                <h1>CONTROL DE FLOTILLAS</h1>\n");
      out.write("                <table>\n");
      out.write("                    <tr><td><span>Usuario:</span></td>\n");
      out.write("                        <td><input type=\"text\" name=\"user\" class=\"texto\"></td><br>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr><td><span>Contraseña:</span></td>\n");
      out.write("                        <td><input type=\"password\" name=\"pwd\" class=\"texto\"></td><br> \n");
      out.write("                    </tr>\n");
      out.write("                </table>                \n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" name=\"enviar\" value=\"Ingresar\">\n");
      out.write("                <input type=\"reset\" name=\"cancelar\" value=\"Cancelar\">  \n");
      out.write("            </center>        \n");
      out.write("            -->           \n");
      out.write("           \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
