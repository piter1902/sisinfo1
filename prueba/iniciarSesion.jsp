<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
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
		<link rel="stylesheet" href="http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.css" />
		<script src="http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript" src="javascript/toTop.js"></script>
    </head>
    <body>
		<button onclick="topFunction()" id="myBtn" title="Go to top"><img class="arrow" src="imagenes/arrow.png" alt=""/></button>
        <!--================Header Area =================-->
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
					<a  class="logo" href="index.jsp" ><img class="hoja" src="imagenes/marca.png" alt=""/></a>
				<div id="tablaCabecera">
						<div class="columna1">
							<a 	class="inicioSesion" href="iniciarSesion.jsp" ><img  class="iconoInicio" src="imagenes/inicioSesion.png" alt=""></a>
						</div>
						<div  class="columna2">
							<form class="usuarioActual" action="" method="get">
													<%
														String nick = (String) session.getAttribute("nickname");
														if(nick == null || nick.trim().equals("")){
															nick = "";
														}
													%>
													<p>
														<label for="nick">Usuario:</label> <input size="8px" readonly
															type="text" name="nick"
															value="<%= nick %>" />
													</p>
							</form>
						</div>
						<div class="columna3">
							<a 	class="preferencias" href="datosPersonales.jsp" ><img class="tuerca" src="imagenes/tuerca.png" alt=""/></a>
						</div>
						<div class="columna4">
							<form class="cerrarSesion" action="" method="post">
								<input size="2px" class="campo" type="submit" value="Cerrar Sesión"/>
							</form>
						</div>
				</div>
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
                            <li class="nav-item"><center><a class="nav-link"  href="index.jsp">Home</a></center></li> 
                            <li class="nav-item"><center><a class="nav-link" href="contact.jsp">Contact</a></center></li>
							<li class="nav-item"><center><a class="nav-link" href="help.jsp">Help</a></center></li>
                            <li class="nav-item"><center><a class="nav-link" href="registrarse.jsp">Registrarse</a></center></li>
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
                    <h2 class="page-cover-tittle">Iniciar Sesión</h2>
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
                <!--<div class="section_title text-center">
                    <h2>Sermons This Week</h2>
                    <p>The French Revolution constituted for the conscience of the dominant aristocratic class a fall from</p>
                </div>-->
                <!--<div class="sermons_slider owl-carousel">-->
					<form class="iniciarse" action="" method="get">
						<center>
							<div class="iniciarS">
									<div class="tablaC"><label for="nick"><b class="inicio1">Nombre de usuario:</b></label></div>
									<div class="tablaC"><input class="campo" type="text" name="name" value=""/></div>
									<div class="tablaC"><label for="password"><b class="inicio1">Contraseña:</b></label></div>
									<div class="tablaC"><input class="campo" type="password" name="password" value=""/></div>
									<div class="tablaC">
										<input class="" type="reset" value="Resetear"/>
										<input class="campo" type="submit" value="Iniciar Sesión"/>	
									</div>
								</tr>
							</div>
						</center>
					</form>
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
            <div class="container2">
				<!--<img class="upToPage" src="imagenes/arrow.png" style="transform: rotate(-90deg);float:right;width:10%;height:10%;" alt=""/>-->
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
                                        <li><a href="index.html">Home</a></li>
                                        <li><a href="contact.html">Contact</a></li>
                                        <li><a href="help.html">Help</a></li>
                                        <li><a href="registrarse.html">Registrarse</a></li>
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
                <!--<div class="border_line"></div>-->
                <div class="row footer-bottom d-flex justify-content-between align-items-center">
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