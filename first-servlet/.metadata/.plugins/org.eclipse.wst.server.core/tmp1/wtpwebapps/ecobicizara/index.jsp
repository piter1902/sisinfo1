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

<!-- Para que aparezca mapa -->
<link rel="stylesheet"
	href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css" />
<script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"></script>
<!-- Para generar rutas en el mapa -->
<link rel="stylesheet"
	href="mapa/leaflet-routing-machine-master/dist/leaflet-routing-machine.css" />
<script
	src="https://unpkg.com/leaflet-routing-machine@latest/dist/leaflet-routing-machine.js"></script>
<link rel="stylesheet"
	href="mapa/leaflet-routing-machine-master/examples/Control.Geocoder.css" />
<script
	src="mapa/leaflet-routing-machine-master/examples/Control.Geocoder.js"></script>
<!-- Para puntos de calor -->
<script src="mapa/heatmap.js-master/build/heatmap.js"></script>
<script src="mapa/heatmap.js-master/build/heatmap.min.js"></script>

</head>

<body>
	<!--================Header Area =================-->
	<jsp:include page="cabecera.jsp"></jsp:include>
	<!--================Header Area =================-->
	<div></div>
	<!--================banner Area =================-->
	<section class="banner_area d-flex text-center">
		<div class="container align-self-center">
			<div class="row">
				<div class="col-md-12">
					<div class="banner_content">
						<!--<h6>Who Created us</h6>-->
						<h1>Bienvenido a EcoBiciZara</h1>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================banner Area =================-->

	<!--================Event Date Area =================-->
	<section class="event_date_area" style="height: 500px">
		<div id="conjunto">
			<!-- <form id="consulta" action="" method="post">
				<table class="tablaConsulta" style="size: 5px">
					<tr>Realizar Busqueda:
					</tr>
					<tr>
						<td><label for="origen:" class="consulIntro">
								<p class="campoIntro">Origen:</p>
						</label><br> <input class="introConsul" size="10px" type="text"
							name="origen" value="" /></td>
					</tr>
					<tr>
						<td><label for="destino" class="consulIntro">
								<p class="campoIntro">Destino:</p>
						</label><br> <input class="introConsul" size="10px" type="text"
							name="destino" value="" /></td>
					</tr>
					<tr>
						<td><input class="introConsul campoIntroFin" size="10px"
							type="reset" value="Reiniciar consulta" /></td>
					</tr>
					<tr>
						<td><input class="introConsul campoIntroFin" size="10px"
							type="submit" value="Enviar consulta" /></td>
					</tr>
					<tr>
						<td><input class="introConsul campoIntroFin" size="10px"
							type="submit" value="Guardar consulta" /></td>
					</tr>
				</table>
			</form> -->
			<div id="mapa"></div>
			<script>
				//Generador puntos calientes.

				var testData = {
					max : 8,
					data : [ {
						lat : 41.670735,
						lng : -0.889915,
						count : 1
					} ]
				};

				var cfg = {
					"radius" : .001,
					"maxOpacity" : .8,
					// scales the radius based on map zoom
					"scaleRadius" : true,
					// if set to false the heatmap uses the global maximum for colorization
					// if activated: uses the data maximum within the current map boundaries
					//   (there will always be a red spot with useLocalExtremas true)
					"useLocalExtrema" : true,
					latField : 'lat',
					lngField : 'lng',
					valueField : 'count'
				};

				var heatmapLayer = new HeatmapOverlay(cfg);

				//Capa base del mapa
				var baseLayer = L
						.tileLayer(
								'http://{s}.tile.osm.org/{z}/{x}/{y}.png',
								{
									attribution : 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery Â© <a href="http://cloudmade.com">CloudMade</a>',
									maxZoom : 18
								});
				//creamos el objeto mapa, aplicandole las capas creadas anteriormente
				var map = new L.Map('mapa', {
					center : new L.LatLng(41.648986, -0.891893),
					zoom : 12,
					layers : [ baseLayer, heatmapLayer ]
				});

				//Generador de rutas
				var controlLayer = L.Routing.control({
					router : new L.Routing.osrmv1({
						profile : 'car',
						language : 'es'
					}),
					geocoder : L.Control.Geocoder.photon({}),
					language : 'es',
					routeWhileDragging : true
				}).on(
						'routeselected',
						function(e) {
							/*var coord = e.route.coordinates;
							var time = e.route.summary.totalTime;
							var distance = e.route.summary.totalDistance;
							var instr = e.route.instructions;
							var formatter = new L.Routing.Formatter();
							var puntos = 
							/*for (var i = 0; i < instr.length; ++i) {
							 	alert("Instruccion: " + instr[i].text);
							  }*/
							//Time in seconds
							/*alert("time " + time/60 + " minutes");
							alert("distance " + distance/1000 + "Km");
							alert("Nombre " + name);
							 */
							var route = e.route;
							
							 for(var i = 0; i < route.inputWaypoints.length; ++i){
								 alert("Origen: " + route.inputWaypoints[i].name);
							 }
						}).addTo(map);
				// Para capturar errores.
				L.Routing.errorControl(controlLayer).addTo(map);
				heatmapLayer.setData(testData);
			</script>
		</div>
	</section>
	<!--================Event Date Area =================-->

	<!--================About Area =================-->
	<!-- 
	<section class="about_area section_gap">
		<div class="container"></div>
	</section>
	-->
	<!--================About Area =================-->

	<!--================Features Area =================-->
	<!--  <section class="features_area"></section> -->
	<!--================Features Area =================-->

	<!--================Sermons work Area =================-->
	<!-- 
	<section class="sermons_work_area section_gap">
		<div id="consulta1">
			<form action="" method="get">
				<h5>Buscar consultas</h5>
				<label for="fecha">
					<p>Fecha:</p>
				</label> <input type="date" name="fecha" value="" /> &nbsp; <br> <label
					for="origen">
					<p>Origen:</p>
				</label> &nbsp; <br> <input size="5px" type="text" name="origen"
					value="" /> &nbsp; <br> <label for="destino">
					<p>Destino:</p>
				</label> &nbsp; <br> <input size="5px" type="text" name="destino"
					value="" /> &nbsp; <br> <input size="15px" type="reset"
					value="Resetear consulta" /> <br> &nbsp; <br> <input
					size="15px" type="submit" value="Enviar consulta" />
			</form>
		</div>
		<div id="resultados1">
			<b>InformaciÃ³n obtenida en la consulta</b>
		</div>
	</section>
	 -->
	<!--================ start footer Area  =================-->
	<footer class="footer-area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6 class="footer_title">About Agency</h6>
						<p>The world has become so fast paced that people donât want
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
			<div
				class="row footer-bottom d-flex justify-content-between align-items-center">
				<p class="col-lg-8 col-sm-8 footer-text m-0">
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					Copyright &copy;
					<script>
						document.write(new Date().getFullYear());
					</script>
					All rights reserved | This template is made with <i
						class="fa fa-heart-o" aria-hidden="true"></i> by <a
						href="https://colorlib.com" target="_blank">Colorlib</a>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				</p>
				<div class="col-lg-4 col-sm-4 footer-social">
					<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
						class="fa fa-twitter"></i></a> <a href="#"><i
						class="fa fa-dribbble"></i></a> <a href="#"><i
						class="fa fa-behance"></i></a>
				</div>
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
	<script src="js/mail-script.js"></script>
	<script src="js/stellar.js"></script>
	<script src="vendors/lightbox/simpleLightbox.min.js"></script>
	<script src="vendors/flipclock/timer.js"></script>
	<script src="vendors/nice-select/js/jquery.nice-select.min.js"></script>
	<script src="js/custom.js"></script>
</body>

</html>