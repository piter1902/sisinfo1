<%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="imagenes/Hoja1.png" type="imagenes/Hoja1.png">
        <title>EcoBiciZara</title>
        <!-- Bootstrap CSS -->
		<link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="vendors/linericon/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="vendors/lightbox/simpleLightbox.css">
        <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
        <!-- main css -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">
    </head>
    <body>
        <%
            String nickError="";String passError="";String pass1Error="";String emailError="";String apeError="";String vehicError=""; String nombError="";
            String nickValor="";String passValor="";String pass1Valor="";String emailValor="";String apeValor="";String vehicValor=""; String nombValor="";
            Map<String,String> err = (Map<String,String>)request.getAttribute("error");
                if(err!=null){
                    String cabecera ="<span style=\"color:red\">"; 
                    String fin = "</span>";
                    if(err.containsKey("nickname"))nickError = cabecera + err.get("nickname")+fin;
                    if(err.containsKey("nombre"))nombError = cabecera + err.get("nombre") + fin;
                    if(err.containsKey("password"))passError = cabecera + err.get("password")+fin;
                    if(err.containsKey("password1"))nickError = cabecera + err.get("password1")+fin;
                    if(err.containsKey("apellidos"))nickError = cabecera + err.get("nickname")+fin;
                    if(err.containsKey("email"))nickError = cabecera + err.get("email")+fin;
                    if(err.containsKey("vehiculo"))nickError = cabecera + err.get("vehiculo")+fin;
                    nickValor = request.getParameter("nickname");
                    nombValor = request.getParameter("nombre");
                    passValor = request.getParameter("password");
                    pass1Valor = request.getParameter("password1");    
                    apeValor = request.getParameter("apellidos");
                    emailValor = request.getParameter("email");
                    vehicValor = request.getParameter("vehiculo");
                }%>

        <header class="header_area">
            <div class="header_top">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-5">
                            <!--<ul class="nav social_icon">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-behance"></i></a></li>
                            </ul>-->
                        </div>
                                                <div class="col-sm-6 col-7">
							<div class="top_btn d-flex justify-content-end">
								
                                <!--<a href="#">My Account</a>
                                <a href="#">Donate Now</a>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="zoneLink">
					<a  class="logo" href="index.html" ><img class="hoja" src="imagenes/marca.png" alt=""></a>
				<table id="tablaCabecera">
					<tr>	
						<td>
							<a 	class="inicioSesion" href="iniciarSesion.html" ><img  class="iconoInicio" src="imagenes/inicioSesion.png" alt=""></a>
						</td>
						<td>
							<form class="usuarioActual" action="" method="get">
													<p>
														<label for="nick">Usuario:</label>
														<input size="8px" readonly type="text" name="nick" value=""/>
													</p>
							</form>
						</td>
						<td>
							<a 	class="preferencias" href="datosPersonales.html" ><img class="tuerca" src="imagenes/tuerca.png" alt=""></a>
						</td>
						<td>
							<form class="cerrarSesion" action="" method="post">
								<input size="2px" class="campo" type="submit" value="Cerrar Sesión"/>
							</form>
						</td>
					</tr>
				</table>
			</div>
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto">
                            <li class="nav-item"><center><a class="nav-link"  href="index.html">Home</a></center></li> 
                            <li class="nav-item"><center><a class="nav-link" href="contact.html">Contact</a></center></li>
							<li class="nav-item"><center><a class="nav-link" href="help.html">Help</a></center></li>
                            <li class="nav-item active" ><center><a class="nav-link" href="registrarse.html">Registrarse</a></center></li>
                        </ul>
                    </div> 
                </div>
            </nav>
        </header>
         <!--================Header Area =================-->
		 <div></div>
        <!--================Breadcrumb Area =================-->
        <section class="breadcrumb_area br_image">
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">Registrase</h2>
                    <!--<ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="active">Sermons</li>
                    </ol>-->
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        <!--================Sermons work Area =================-->
        <section class="sermons_work_area section_gap">
            <div class="container">
					<form id="registro" action="registrarse" method="post">
					<center><h3>Nuevo Usuario</h3></center>
					<center><p>
						<label for="NickName">NickName:</label>
						<input type="text" name="nickname" value="<%=nickValor%>"id="idNick"/><%=nickError%>
					</p></center>
					<center><p>
						<label for="name">Nombre:</label>
						<input type="text" name="nombre" value="<%=nombValor%>"id="idNombre"/><%=nombError%>
					</p></center>
					<center><p>
						<label for="apellidos">Apellidos:</label>
						<input type="text" name="apellidos" value="<%=apeValor%>"id="idValor"/><%=apeError%>
					</p></center>
					<center><p>
						<label for="password">Contraseña:</label>
						<input type="password" name="password" value="<%=passValor%>"id="idPassword"/><%=passError%>
					</p></center>
					<center><p>
						<label for="password1">Repetir Contraseña:</label>
						<input type="password" name="password1" value="<%=pass1Valor%>"id="idPassword1"/><%=pass1Error%>
					</p></center>
					<center><p>
						<label for="email">Dirección de Correo:</label>
						<input type="text" name="email" value="<%=emailValor%>"id="idEmail"/><%=emailError%>
					</p></center>
						<p>
							<select class="lista1" name="vehiculo" value="<%=vehicValor%>"id="idVehiculo"/><%=vehicError%>
								<option selected value="0"><label for="vehiculo">Elige un tipo de vehiculo</label></option>
								<option value="Moto">
									<label for="moto">Moto</label>
								</option>
								<option value="Coche">
									<label for="coche">Coche</label>
								</option>
								<option value="Furgoneta">
									<label for="furgoneta">Furgoneta</label>
								</option>
							</select>
						</p>
					<br>
					<br>
					<br>
					<center class="entrada1"><p>
						<input class="entrada1_1" type="reset" value="Resetear"/>
						<input class="entrada1_1" type="submit" value="Registrase"/>
					</p></center>
					
				</form>
				<div class="box">
					  <select>
						<option data-display="Select">Nothing</option>
						<option value="1">Some option</option>
						<option value="2">Another option</option>
						<option value="3" disabled>A disabled option</option>
						<option value="4">Potato</option>
					  </select>
				</div>
          
            </div>
        </section>
        <!--================Sermons work Area=================-->
        
        <!--================Event Blog Area=================-->
        <section class="event_blog_area section_gap">
            <div class="container">
                <div class="row">
                    <!--<div class="col-md-4">
                        <div class="event_post">
                            <img src="image/blog1.jpg" alt="">
                            <a href="#"><h2 class="event_title">Spreading Peace to world</h2></a>
                            <ul class="list_style sermons_category">
                                <li><i class="lnr lnr-user"></i>Saturday, 5th may, 2018</li>
                                <li><i class="lnr lnr-apartment"></i>Rocky beach Church</li>
                                <li><i class="lnr lnr-location"></i>Santa monica, Los Angeles, USA</li>
                            </ul>
                            <a href="#" class="btn_hover">View Details</a>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="event_post">
                            <img src="image/blog2.jpg" alt="">
                            <a href="#"><h2 class="event_title">Spread Happyness to world</h2></a>
                            <ul class="list_style sermons_category">
                                <li><i class="lnr lnr-user"></i>Saturday, 5th may, 2018</li>
                                <li><i class="lnr lnr-apartment"></i>Rocky beach Church</li>
                                <li><i class="lnr lnr-location"></i>Santa monica, Los Angeles, USA</li>
                            </ul>
                            <a href="#" class="btn_hover">View Details</a>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="event_post">
                            <img src="image/blog3.jpg" alt="">
                            <a href="#"><h2 class="event_title">Spreading Light to world</h2></a>
                            <ul class="list_style sermons_category">
                                <li><i class="lnr lnr-user"></i>Saturday, 5th may, 2018</li>
                                <li><i class="lnr lnr-apartment"></i>Rocky beach Church</li>
                                <li><i class="lnr lnr-location"></i>Santa monica, Los Angeles, USA</li>
                            </ul>
                            <a href="#" class="btn_hover">View Details</a>
                        </div>
                    </div>-->
                </div>
            </div>
        </section>
		<div>
        <!--================Blog Area=================-->
        
        <!--================ start footer Area  =================-->	
        <footer class="footer-area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6 class="footer_title">About Agency</h6>
                            <p>The world has become so fast paced that people don’t want to stand by reading a page of information, they would much rather look at a presentation and understand the message. It has come to a point </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6 class="footer_title">Navigation Links</h6>
                            <div class="row">
                                <div class="col-4">
                                    <ul class="list_style">
                                        <li><a href="#">Home</a></li>
                                        <li><a href="#">Feature</a></li>
                                        <li><a href="#">Services</a></li>
                                        <li><a href="#">Portfolio</a></li>
                                    </ul>
                                </div>
                                <div class="col-4">
                                    <ul class="list_style">
                                        <li><a href="#">Team</a></li>
                                        <li><a href="#">Pricing</a></li>
                                        <li><a href="#">Blog</a></li>
                                        <li><a href="#">Contact</a></li>
                                    </ul>
                                </div>										
                            </div>							
                        </div>
                    </div>							
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6 class="footer_title">Newsletter</h6>
                            <p>For business professionals caught between high OEM price and mediocre print and graphic output, </p>		
                            <div id="mc_embed_signup">
                                <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="subscribe_form relative">
                                    <div class="input-group d-flex flex-row">
                                        <input name="EMAIL" placeholder="Email Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email Address '" required="" type="email">
                                        <button class="btn sub-btn"><span class="lnr lnr-location"></span></button>		
                                    </div>									
                                    <div class="mt-10 info"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-footer-widget instafeed">
                            <h6 class="footer_title">InstaFeed</h6>
                            <ul class="list_style instafeed d-flex flex-wrap">
                                <li><img src="image/instagram/Image-01.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-02.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-03.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-04.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-05.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-06.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-07.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-08.jpg" alt=""></li>
                            </ul>
                        </div>
                    </div>						
                </div>
                <div class="border_line"></div>
                <div class="row footer-bottom d-flex justify-content-between align-items-center">
                    <p class="col-lg-8 col-sm-8 footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    <!--<div class="col-lg-4 col-sm-4 footer-social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-dribbble"></i></a>
                        <a href="#"><i class="fa fa-behance"></i></a>
                    </div>-->
                </div>
            </div>
        </footer>
		<!--================ End footer Area  =================-->
        
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="vendors/nice-select/js/jquery.nice-select.min.js"></script>
        <script src="js/stellar.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>