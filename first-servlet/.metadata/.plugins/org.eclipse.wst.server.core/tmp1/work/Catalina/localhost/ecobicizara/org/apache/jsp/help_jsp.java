/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.26
 * Generated at: 2019-12-11 12:12:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class help_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<!-- Required meta tags -->\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<link rel=\"icon\" href=\"imagenes/Hoja1.png\" type=\"imagenes/Hoja1.png\">\r\n");
      out.write("<title>EcoBiciZara</title>\r\n");
      out.write("<!-- Bootstrap CSS -->\r\n");
      out.write("<link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"vendors/linericon/style.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"vendors/owl-carousel/owl.carousel.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"vendors/lightbox/simpleLightbox.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"vendors/nice-select/css/nice-select.css\">\r\n");
      out.write("<!-- main css -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/responsive.css\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"javascript/codigo.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--================Header Area =================-->\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "cabecera.jsp", out, false);
      out.write("\r\n");
      out.write("\t<!--================Breadcrumb Area =================-->\r\n");
      out.write("\t<section class=\"breadcrumb_area br_image\" style=\"margin-top: 150px\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"page-cover text-center\">\r\n");
      out.write("\t\t\t\t<h2 class=\"page-cover-tittle\">Contact Us</h2>\r\n");
      out.write("\t\t\t\t<!--<ol class=\"breadcrumb\">\r\n");
      out.write("                        <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                        <li class=\"active\">Contact Us</li>\r\n");
      out.write("                    </ol>-->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!--================Breadcrumb Area =================-->\r\n");
      out.write("\t<section class=\"event_date_area\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<div style=\"background-color: #2eb34e; color:black;\">\r\n");
      out.write("\t\t\t\t<!-- Pregunta 1: Como registrarse -->\r\n");
      out.write("\t\t\t\t<h3> ¿Cómo darse de alta? </h3>\r\n");
      out.write("\t\t\t\t<p> Para registrarse, acceda a la pestaña de <a style=\"color:#0a465c;\"href=\"registrarse.jsp\"> registrarse </a> e introduzca sus datos.</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"background-color: #2eb34e; color:black;\">\r\n");
      out.write("\t\t\t\t<!--  Pregunta 2: Como darse de baja -->\r\n");
      out.write("\t\t\t\t<h3> ¿Cómo darse de baja? </h3>\r\n");
      out.write("\t\t\t\t<p> Para darse de baja, acceda a su cuenta de usuario y dirijase a la pestaña de modificar usuario y seleccione: \"Quiero darme de baja\" </p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"background-color: #2eb34e; color:black;\">\r\n");
      out.write("\t\t\t\t<!-- Pregunta 3: Cambiar datos de vehiculo -->\r\n");
      out.write("\t\t\t\t<h3> ¿Cómo cambiar los datos de mi vehículo? </h3>\r\n");
      out.write("\t\t\t\t<p> Para modificar los datos del vehículo, acceda a su cuenta de usuario y dirijase a la pestaña de modificar usuario y modifique aquellos campos del su vehículo. </p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!--================Contact Area =================-->\r\n");
      out.write("\t<section class=\"contact_area section_gap\">\r\n");
      out.write("\t\t<div class=\"container\"></div>\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-3\"></div>\r\n");
      out.write("\t\t\t<div class=\"col-md-9\">\r\n");
      out.write("\t\t\t\t<form class=\"row contact_form\" action=\"contact_process.php\"\r\n");
      out.write("\t\t\t\t\tmethod=\"post\" id=\"contactForm\" novalidate=\"novalidate\"></form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!--================Contact Area =================-->\r\n");
      out.write("\r\n");
      out.write("\t<!--================ start footer Area  =================-->\r\n");
      out.write("\t<footer class=\"footer-area section_gap\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-3  col-md-6 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-footer-widget\">\r\n");
      out.write("\t\t\t\t\t\t<h6 class=\"footer_title\">About Agency</h6>\r\n");
      out.write("\t\t\t\t\t\t<p>The world has become so fast paced that people donât want\r\n");
      out.write("\t\t\t\t\t\t\tto stand by reading a page of information, they would much rather\r\n");
      out.write("\t\t\t\t\t\t\tlook at a presentation and understand the message. It has come to\r\n");
      out.write("\t\t\t\t\t\t\ta point</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-3 col-md-6 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-footer-widget\">\r\n");
      out.write("\t\t\t\t\t\t<h6 class=\"footer_title\">Navigation Links</h6>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"list_style\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Feature</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Services</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Portfolio</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"list_style\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Team</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Pricing</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Blog</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Contact</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-3 col-md-6 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-footer-widget\">\r\n");
      out.write("\t\t\t\t\t\t<h6 class=\"footer_title\">Newsletter</h6>\r\n");
      out.write("\t\t\t\t\t\t<p>For business professionals caught between high OEM price\r\n");
      out.write("\t\t\t\t\t\t\tand mediocre print and graphic output,</p>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"mc_embed_signup\">\r\n");
      out.write("\t\t\t\t\t\t\t<form target=\"_blank\"\r\n");
      out.write("\t\t\t\t\t\t\t\taction=\"https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01\"\r\n");
      out.write("\t\t\t\t\t\t\t\tmethod=\"get\" class=\"subscribe_form relative\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"input-group d-flex flex-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"EMAIL\" placeholder=\"Email Address\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tonfocus=\"this.placeholder = ''\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tonblur=\"this.placeholder = 'Email Address '\" required=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttype=\"email\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button class=\"btn sub-btn\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"lnr lnr-location\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"mt-10 info\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-3 col-md-6 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"single-footer-widget instafeed\">\r\n");
      out.write("\t\t\t\t\t\t<h6 class=\"footer_title\">InstaFeed</h6>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"list_style instafeed d-flex flex-wrap\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><img src=\"image/instagram/Image-01.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><img src=\"image/instagram/Image-02.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><img src=\"image/instagram/Image-03.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><img src=\"image/instagram/Image-04.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><img src=\"image/instagram/Image-05.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><img src=\"image/instagram/Image-06.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><img src=\"image/instagram/Image-07.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><img src=\"image/instagram/Image-08.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"border_line\"></div>\r\n");
      out.write("\t\t\t<!--<div class=\"row footer-bottom d-flex justify-content-between align-items-center\">\r\n");
      out.write("                    <p class=\"col-lg-8 col-sm-8 footer-text m-0\"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("\t\t\t<!--Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a>-->\r\n");
      out.write("\t\t\t<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<!--<div class=\"col-lg-4 col-sm-4 footer-social\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-dribbble\"></i></a>\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-behance\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>-->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("\t<!--================ End footer Area  =================-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!--================Contact Success and Error message Area =================-->\r\n");
      out.write("\t<div id=\"success\" class=\"modal modal-message fade\" role=\"dialog\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-close\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<h2>Thank you</h2>\r\n");
      out.write("\t\t\t\t\t<p>Your message is successfully sent...</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Modals error -->\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"error\" class=\"modal modal-message fade\" role=\"dialog\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-close\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<h2>Sorry !</h2>\r\n");
      out.write("\t\t\t\t\t<p>Something went wrong</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--================End Contact Success and Error message Area =================-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Optional JavaScript -->\r\n");
      out.write("\t<!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n");
      out.write("\t<script src=\"js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/popper.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script src=\"vendors/owl-carousel/owl.carousel.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery.ajaxchimp.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/mail-script.js\"></script>\r\n");
      out.write("\t<script src=\"js/stellar.js\"></script>\r\n");
      out.write("\t<script src=\"vendors/imagesloaded/imagesloaded.pkgd.min.js\"></script>\r\n");
      out.write("\t<script src=\"vendors/isotope/isotope-min.js\"></script>\r\n");
      out.write("\t<script src=\"js/stellar.js\"></script>\r\n");
      out.write("\t<script src=\"vendors/lightbox/simpleLightbox.min.js\"></script>\r\n");
      out.write("\t<!--gmaps Js-->\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE\"></script>\r\n");
      out.write("\t<script src=\"js/gmaps.min.js\"></script>\r\n");
      out.write("\t<!-- contact js -->\r\n");
      out.write("\t<script src=\"js/jquery.form.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery.validate.min.js\"></script>\r\n");
      out.write("\t<script src=\"vendors/nice-select/js/jquery.nice-select.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/contact.js\"></script>\r\n");
      out.write("\t<script src=\"js/custom.js\"></script>\r\n");
      out.write("</body>\r\n");
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
