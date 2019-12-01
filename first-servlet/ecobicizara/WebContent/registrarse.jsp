<%@ page import="java.lang.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
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
</head>
<body>
	<%
		String nickError = "";
		String passError = "";
		String pass1Error = "";
		String emailError = "";
		String apeError = "";
		String nombError = "";
		String tipoVehicError = "";
		String combustError = "";
		String contamError = "";
		String motorError = "";
		String nickValor = "";
		String passValor = "";
		String pass1Valor = "";
		String emailValor = "";
		String apeValor = "";
		String nombValor = "";
		String tipoVehicValor = "";
		String combustValor = "";
		String contamValor = "";
		String motorValor = "";
		Map<String, String> err = (Map<String, String>) request.getAttribute("errores");
		if (err != null) {
			String cabecera = "<span style=\"color:red\">";
			String fin = "</span>";
			if (err.containsKey("nickname"))
				nickError = cabecera + err.get("nickname") + fin;
			if (err.containsKey("nombre"))
				nombError = cabecera + err.get("nombre") + fin;
			if (err.containsKey("password"))
				passError = cabecera + err.get("password") + fin;
			if (err.containsKey("password1"))
				pass1Error = cabecera + err.get("password1") + fin;
			if (err.containsKey("apellidos"))
				apeError = cabecera + err.get("apellidos") + fin;
			if (err.containsKey("email"))
				emailError = cabecera + err.get("email") + fin;
			if (err.containsKey("tipo_vehiculo"))
				tipoVehicError = cabecera + err.get("tipo_vehiculo") + fin;
			if (err.containsKey("combustible"))
				tipoVehicError = cabecera + err.get("combustible") + fin;
			if (err.containsKey("contaminante"))
				tipoVehicError = cabecera + err.get("contaminante") + fin;
			if (err.containsKey("motor"))
				tipoVehicError = cabecera + err.get("motor") + fin;
			nickValor = request.getParameter("nickname");
			nombValor = request.getParameter("nombre");
			passValor = request.getParameter("password");
			pass1Valor = request.getParameter("password1");
			apeValor = request.getParameter("apellidos");
			emailValor = request.getParameter("email");
			tipoVehicValor = request.getParameter("tipo_vehiculo");
			combustValor = request.getParameter("combustible");
			contamValor = request.getParameter("contaminante");
			motorValor = request.getParameter("motor");
		}
	%>

	<!--================Header Area =================-->
	<jsp:include page="cabecera.jsp"></jsp:include>
	<!--================Header Area =================-->
	<div></div>
	<!--================Breadcrumb Area =================-->
	<section class="breadcrumb_area br_image">
		<div class="container">
			<div class="page-cover text-center">
				<h2 class="page-cover-tittle">Registrase</h2>
				<!--<ol class="breadcrumb">
                        <li><a href="index.jsp">Home</a></li>
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
				<center>
					<h3>Nuevo Usuario</h3>
				</center>
				<div class="camposReg">
					<p>
						<label class="camposNewReg1" for="NickName">NickName:</label> <input
							class="camposNewReg2" type="text" name="nickname"
							value="<%=nickValor%>" id="idNick" /><%=nickError%>
					</p>
					<p>
						<label class="camposNewReg1" for="name">Nombre:</label> <input
							class="camposNewReg2" type="text" name="nombre"
							value="<%=nombValor%>" id="idNombre" /><%=nombError%>
					</p>
					<p>
						<label class="camposNewReg1" for="apellidos">Apellidos:</label> <input
							class="camposNewReg2" type="text" name="apellidos"
							value="<%=apeValor%>" id="idValor" /><%=apeError%>
					</p>
					<p>
						<label class="camposNewReg1" for="password">Contraseña:</label> <input
							class="camposNewReg2" type="password" name="password"
							value="<%=passValor%>" id="idPassword" /><%=passError%>
					</p>
					<p>
						<label class="camposNewReg1" for="password1">Repetir
							Contraseña:</label> <input class="camposNewReg2" type="password"
							name="password1" value="<%=pass1Valor%>" id="idPassword1" /><%=pass1Error%>
					</p>
					<p>
						<label class="camposNewReg1" for="email">Dirección de
							Correo:</label> <input class="camposNewReg2" type="text" name="email"
							value="<%=emailValor%>" id="idEmail" /><%=emailError%>
					</p>
				</div>
				<br>
				<div class="tablaReg">
					<table>
						<tr>
							<th>Tipo de vehiculo</th>
							<th>Combustible</th>
						</tr>
						<tr>
							<td><label for="tipo_vehiculo"> <select
									class="listaRegistro" name="tipo_vehiculo"
									value="<%=tipoVehicValor%>" id="idVehiculo" /><%=tipoVehicError%>
									<option value="mal" selected>Elige un tipo de vehiculo</option>
									<option value="Moto">Moto</option>
									<option value="Coche">Coche</option>
									<option value="Bus">Bus</option>
									<option value="Camión">Camión</option> </select>
							</label></td>
							<td><label for="combustible"> <select
									class="listaRegistro" name="combustible"
									value="<%=combustValor%>" id="idCombust" /><%=combustError%>
									<option value="mal" selected>Elige un tipo de
										combustible</option>
									<option value="gasolina">Gasolina</option>
									<option value="diesel">Diesel</option>
									<option value="hibrido">Hibrido</option>
									<option value="lpg_bifuel">lpg bifuel</option>
									<option value="lpg_biguel_petrol">lpg_biguel_petrol</option> </select>
							</label></td>
						</tr>
						<tr>
							<th>Contaminante</th>
							<th>Motor</th>
						</tr>
						<tr>
							<td><label for="contaminante"> <select
									class="listaRegistro" name="contaminante"
									value="<%=contamValor%>" id="idContam" /><%=contamError%>
									<option value="mal" selected>Elige el contaminante</option>
									<option value="desconocido">Desconocido</option>
									<option value="co">co</option>
									<option value="nox">nox</option>
									<option value="0">0</option> </select>
							</label></td>
							<td><label for="motor"> <select
									class="listaRegistro" name="motor" value="<%=motorValor%>"
									id="idMotor" /><%=motorError%>
									<option value="mal" selected>Elige el motor</option>
									<option value="desconocido">Desconocido</option>
									<option value="gdi">gdi</option>
									<option value="pfi">pfi</option>
									<option value="gdi+gpf">gdi+gpf</option>
									<option value="dpf">dpf</option>
									<option value="dpf+src">dpf+src</option>
									<option value="lnt+dpf">lnt+dpf</option>
									<option value="src">src</option>
									<option value="egr">egr</option> </select>
							</label></td>
						</tr>
					</table>
					</p>
					<br> <br> <br>
					<div class="botonesRegistro">
						<input class="entrada1_1" type="submit" value="Registrase" />
					</div>
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
			<div class="container">
				<div class="row">
					<div class="col-lg-3  col-md-6 col-sm-6">
						<div class="single-footer-widget">
							<h6 class="footer_title">About Agency</h6>
							<p>The world has become so fast paced that people donâ€™t
								want to stand by reading a page of information, they would much
								rather look at a presentation and understand the message. It has
								come to a point</p>
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