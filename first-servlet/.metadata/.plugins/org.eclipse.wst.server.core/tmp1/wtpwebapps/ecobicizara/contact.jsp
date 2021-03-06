<%@ page import="java.util.*"%>
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
	<%
		String emailError = "";
		String nombError = "";
		String asuntoError = "";
		String msgError = "";
		String emailValor = "";
		String nombValor = "";
		String asuntoValor = "";
		String msgValor = "";
		Map<String, String> err = (Map<String, String>) request.getAttribute("errores");
		if (err != null) {
			String cabecera = "<span style=\"color:red\">";
			String fin = "</span>";
			if (err.containsKey("asunto"))
				asuntoError = cabecera + err.get("asunto") + fin;
			if (err.containsKey("nombre"))
				nombError = cabecera + err.get("nombre") + fin;
			if (err.containsKey("msg"))
				msgError = cabecera + err.get("msg") + fin;
			if (err.containsKey("email"))
				emailError = cabecera + err.get("email") + fin;
			nombValor = request.getParameter("nombre");
			emailValor = request.getParameter("email");
			msgValor = request.getParameter("msg");
			asuntoValor = request.getParameter("asunto");
		}
	%>

	<!--================Header Area =================-->
	<jsp:include page="cabecera.jsp"></jsp:include>
	<!--================Breadcrumb Area =================-->
	<section class="breadcrumb_area br_image" style="margin-top: 150px">
		<div class="container">
			<div class="page-cover text-center">
				<h2 class="page-cover-tittle">Contact Us</h2>
			</div>
		</div>
	</section>
	<!--================Contact Area =================-->
	<section class="contact_area section_gap">
		<div class="envMensaje" style="float: left">
			<div class="row">
				<div class="row" style="margin-left: 5%">
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
								<a href="mailto:ecobicizara@gmail.com">ecobicizara@gmail.com</a>
							</h6>
							<p>Contacta con nosotros para cualquier duda.</p>
						</div>
					</div>
				</div>
				<div class="row" style="margin-left: 5%">
					<form class="row contact_form" action="addComment" method="post"
						id="contactForm" novalidate="novalidate">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" id="name" name="nombre"
									placeholder="Introduce tu nombre" value="<%=nombValor%>"><%=nombError%>
							</div>
							<div class="form-group">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="Introduce correo electrónico"
									value="<%=emailValor%>"><%=emailError%>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="subject"
									name="asunto" placeholder="Introduce asunto"
									value="<%=asuntoValor%>"><%=asuntoError%>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<textarea class="form-control" name="msg" id="message" rows="1"
									placeholder="Escribe mensaje"><%=msgValor%></textarea><%=msgError%>
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
		<div id="mapacontact"></div>
	</section>
	<!--================Contact Area =================-->

	<!--================Breadcrumb Area =================-->
	<section class="event_date_area">
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
</body>
</html>