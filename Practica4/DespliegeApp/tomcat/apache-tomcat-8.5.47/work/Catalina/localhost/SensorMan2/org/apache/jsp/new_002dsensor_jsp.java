/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.47
 * Generated at: 2019-12-01 09:05:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class new_002dsensor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/home/fran/Escritorio/DespliegeApp/tomcat/apache-tomcat-8.5.47/webapps/SensorMan2/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153377882000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1573818754000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\n");
      out.write("    <title>Home - Brand</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/styles.min.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <main class=\"flex-fill\" style=\"padding-top: 106px;height: 95%;color: rgb(255,255,255);background-image: url(&quot;assets/img/smartcity-1565003196783.jpg&quot;);background-position: bottom;background-size: cover;background-repeat: no-repeat;\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div>\n");
      out.write("                <h1 class=\"display-4 text-monospace text-center\" style=\"padding-top: 10px;color: rgb(255,255,255);\">Insertar Sensor</h1>\n");
      out.write("                <form class=\"border rounded-0 border-primary\" action =\"registerSensor\" method =\"POST\"  style=\"height: 457px;width: 80%;margin-right: 10%;margin-left: 10%;padding-top: 25px;padding-right: 5%;padding-left: 5%;margin-top: 19px;background-color: rgb(68,97,118);\">\n");
      out.write("                    <div class=\"form-group\"><label style=\"color: rgb(255,255,255);\">Id de sensor:</label><input class=\"form-control\" type=\"number\" name=\"idSensor\" style=\"margin-right: 10px;\"></div>\n");
      out.write("                    <div class=\"form-group\"><label style=\"color: rgb(255,255,255);\">Tipo (0=low cost, 1=atmosféricos, 2=contaminación):</label><input class=\"form-control\" type=\"number\" name=\"typeSensor\" style=\"margin-right: 10px;\"></div>\n");
      out.write("                    <div class=\"form-group\"><label style=\"color: rgb(255,255,255);\">Latitud:</label><input class=\"form-control\" type=\"number\" name=\"LatSensor\" style=\"margin-right: 10px;\"></div>\n");
      out.write("                    <div class=\"form-group\"><label style=\"color: rgb(255,255,255);\">Longitud:</label><input class=\"form-control\" type=\"number\" name=\"LongSensor\"></div>\n");
      out.write("                     <div class=\"form-group\"><input type=\"submit\" value=\"Introducir sensor\" style=\"padding-top: 12px;padding-bottom: 12px;  width: 80%;margin-right: 10%;margin-left: 10%;background-color: rgb(168,50,218);\"/></div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </main>\n");
      out.write("    <footer style=\"background-color: rgb(52,4,81);height: 46px;\">\n");
      out.write("        <p class=\"text-center\" id=\"COPY\" style=\"align-self: stretch;color: rgb(255,255,255);padding-top: 9px;margin-bottom: 4px;\">Â© 2019 Copyright&nbsp;<br></p>\n");
      out.write("    </footer>\n");
      out.write("    <nav class=\"navbar navbar-light navbar-expand-lg fixed-top clean-navbar\" style=\"background-color: rgb(52,4,81);color: rgb(255,255,255);width: 100%;height: 80px;\">\n");
      out.write("        <div class=\"container\"><a class=\"navbar-brand logo\" href=\"#\" style=\"color: #ffffff;\"><br>Sensor Maintenance<br><br></a><button data-toggle=\"collapse\" class=\"navbar-toggler\" data-target=\"#navcol-1\" style=\"background-color: #624592;\"><span class=\"sr-only\">Toggle navigation</span><span class=\"navbar-toggler-icon shadow-lg\" style=\"color: rgb(255,255,255);background-color: #ffffff;\"></span></button>\n");
      out.write("            <div\n");
      out.write("                class=\"collapse navbar-collapse\" id=\"navcol-1\" style=\"background-color: rgb(52,4,81);color: rgb(255,255,255);\">\n");
      out.write("                <ul class=\"nav navbar-nav ml-auto\">\n");
      out.write("                    <li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link\" href=\"index_admin.jsp\" style=\"color: #ffffff;\">Inicio</a></li>\n");
      out.write("                    <li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link\" href=\"query_admin.html\" style=\"color: #ffffff;\">Consulta administrativa</a></li>\n");
      out.write("                    <li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link active\" href=\"new-sensor.jsp\" style=\"color: #ffffff;\">registrar sensor</a></li>\n");
      out.write("                    <li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link\" href=\"index.html\" style=\"color: #ffffff;\">Log out</a></li>\n");
      out.write("                    <li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link\" href=\"delete_user.jsp\" style=\"color: #ffffff;\">Borrar usuario</a></li>\n");
      out.write("                </ul>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <script src=\"assets/js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/script.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
