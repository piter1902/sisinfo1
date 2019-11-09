<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="imagenes/Hoja1.png" type="imagenes/Hoja1.png">
<title>EcoBiciZara</title>
<!-- Bootstrap CSS -->
<link href="css/estilo.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="vendors/linericon/style.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
<link rel="stylesheet" href="vendors/lightbox/simpleLightbox.css">
<link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
<!-- main css -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script type="text/javascript" src="javascript/codigo.js"></script>
<link rel="stylesheet"
	href="http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.css" />
<script src="http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.js"></script>
</head>
<body>
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
			<a class="logo" href="index.jsp"><img class="hoja"
				src="imagenes/marca.png" alt=""></a>
			<table id="tablaCabecera">
				<tr>
					<td><a class="inicioSesion" href="iniciarSesion.jsp"><img
							class="iconoInicio" src="imagenes/inicioSesion.png" alt=""></a>
					</td>
					<td>
						<form class="usuarioActual" action="" method="get">
							<% String nick = (String) session.getAttribute("nickname");
							if(nick == null || nick.trim().equals("")){ nick = ""; } %>
							<p>
								<label for="nick">Usuario:</label> <input size="8px" readonly
									type="text" name="nick" value="<%= nick %>" />
							</p>
						</form>
					</td>
					<td><a class="preferencias" href="datosPersonales.html"><img
							class="tuerca" src="imagenes/tuerca.png" alt=""></a></td>
					<td>
						<form class="cerrarSesion" action="logout" method="post">
							<input size="2px" class="campo" type="submit"
								value="Cerrar SesiÃ³n" />
						</form>
					</td>
				</tr>
			</table>
		</div>
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse offset"
					id="navbarSupportedContent">
					<ul class="nav navbar-nav menu_nav ml-auto">
						<li class="nav-item">
							<center>
								<a class="nav-link" href="index.jsp">Home</a>
							</center>
						</li>
						<li class="nav-item active">
							<center>
								<a class="nav-link" href="contact.jsp">Contact</a>
							</center>
						</li>
						<li class="nav-item">
							<center>
								<a class="nav-link" href="help.jsp">Help</a>
							</center>
						</li>
						<li class="nav-item">
							<center>
								<a class="nav-link" href="registrarse.jsp">Registrarse</a>
							</center>
						</li>
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
				<h2 class="page-cover-tittle">Contact Us</h2>
				<!--<ol class="breadcrumb">
                        <li><a href="index.jsp">Home</a></li>
                        <li class="active">Contact Us</li>
                    </ol>-->
			</div>
		</div>
	</section>
	<!--================Breadcrumb Area =================-->
	<section class="event_date_area">
		<div id="mapacontact"></div>
		<script>
			var mymap = L.map('mapacontact').setView([ 41.683149, -0.887533 ],
					17);

			L
					.tileLayer(
							'http://{s}.tile.osm.org/{z}/{x}/{y}.png',
							{
								attribution : '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
							}).addTo(mymap);

			var marker = L.marker([ 41.683149, -0.887533 ]).addTo(mymap);
			marker.bindPopup("<b>Estamos aquí</b><br>").openPopup();
			var circle = L.circle([ 41.679253, -0.878876 ], {
				color : 'red',
				fillColor : '#f03',
				fillOpacity : 0.5,
				radius : 500
			}).addTo(mymap);
		</script>
	</section>
	<!--================Breadcrumb Area =================-->

	<!--================Contact Area =================-->
	<section class="contact_area section_gap">
		<div class="container">
			<!-- <div id="mapacontact" class="mapacontact" 
                    data-lat="40.701083" 
                    data-lon="-74.1522848" 
                    data-zoom="13" 
                    data-info="PO Box CT16122 Collins Street West, Victoria 8007, Australia."
                    data-mlat="40.701083"
                    data-mlon="-74.1522848">
                </div> -->
			<div class="row">
				<div class="col-md-3">
					<div class="contact_info">
						<div class="info_item">
							<i class="lnr lnr-home"></i>
							<h6>Zaragoza,España</h6>
							<p>Universidad de Zaragoza: Escuela de Ingeniería y
								Arquitectura, Edificio Ada Byron</p>
						</div>
						<div class="info_item">
							<i class="lnr lnr-phone-handset"></i>
							<h6>
								<a href="#">656293327</a>
							</h6>
							<p>Lunes a Viernes 8am - 19pm</p>
						</div>
						<div class="info_item">
							<i class="lnr lnr-envelope"></i>
							<h6>
								<a href="#">ecobicizara@gmail.com</a>
							</h6>
							<p>Contacta con nosotros para cualquier duda.</p>
						</div>
					</div>
				</div>
				<div class="col-md-9">
					<form class="row contact_form" action="contact_process.php"
						method="post" id="contactForm" novalidate="novalidate">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" id="name" name="name"
									placeholder="Introduce tu nombre">
							</div>
							<div class="form-group">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="Introduce correo electrónico">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="subject"
									name="subject" placeholder="Introduce asunto">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<textarea class="form-control" name="message" id="message"
									rows="1" placeholder="Escribe mensaje"></textarea>
							</div>
						</div>
						<div class="col-md-12 text-right">
							<button type="submit" value="submit"
								class="btn btn_hover btn_hover_two">Enviar mensaje</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!--================Contact Area =================-->

	<!--================ start footer Area  =================-->
	<footer class="footer-area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6 class="footer_title">About Agency</h6>
						<p>The world has become so fast paced that people don’t want
							to stand by reading a page of information, they would much rather
							look at a presentation and understand the message. It has come to
							a point</p>
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
						<p>For business professionals caught between high OEM price
							and mediocre print and graphic output,</p>
						<div id="mc_embed_signup">
							<form target="_blank"
								action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
								method="get" class="subscribe_form relative">
								<div class="input-group d-flex flex-row">
									<input name="EMAIL" placeholder="Email Address"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Email Address '" required=""
										type="email">
									<button class="btn sub-btn">
										<span class="lnr lnr-location"></span>
									</button>
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
			<!--<div class="row footer-bottom d-flex justify-content-between align-items-center">
                    <p class="col-lg-8 col-sm-8 footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			<!--Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>-->
			<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			</p>
			<!--<div class="col-lg-4 col-sm-4 footer-social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-dribbble"></i></a>
                        <a href="#"><i class="fa fa-behance"></i></a>
                    </div>
                </div>-->
		</div>
	</footer>
	<!--================ End footer Area  =================-->


	<!--================Contact Success and Error message Area =================-->
	<div id="success" class="modal modal-message fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<i class="fa fa-close"></i>
					</button>
					<h2>Thank you</h2>
					<p>Your message is successfully sent...</p>
				</div>
			</div>
		</div>
	</div>

	<!-- Modals error -->

	<div id="error" class="modal modal-message fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<i class="fa fa-close"></i>
					</button>
					<h2>Sorry !</h2>
					<p>Something went wrong</p>
				</div>
			</div>
		</div>
	</div>
	<!--================End Contact Success and Error message Area =================-->


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="vendors/owl-carousel/owl.carousel.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/mail-script.js"></script>
	<script src="js/stellar.js"></script>
	<script src="vendors/imagesloaded/imagesloaded.pkgd.min.js"></script>
	<script src="vendors/isotope/isotope-min.js"></script>
	<script src="js/stellar.js"></script>
	<script src="vendors/lightbox/simpleLightbox.min.js"></script>
	<!--gmaps Js-->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="js/gmaps.min.js"></script>
	<!-- contact js -->
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="vendors/nice-select/js/jquery.nice-select.min.js"></script>
	<script src="js/contact.js"></script>
	<script src="js/custom.js"></script>
</body>
</html>