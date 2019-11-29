<!doctype html>
<%@page import="baseDatos.UsuarioDAO"%>
<%@page import="baseDatos.Usuario"%>
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
		String passError = "";
		String emailError = "";
		String nickError = "";
		String decisError = "";
		String passValor = "";
		String emailValor = "";
		String nickValor = "";
		Map<String, String> err = (Map<String, String>) request.getAttribute("errores");
		if (err != null) {
			String cabecera = "<span style=\"color:red\">";
			String fin = "</span>";
			if (err.containsKey("password"))
				passError = cabecera + err.get("password") + fin;
			if (err.containsKey("email"))
				emailError = cabecera + err.get("email") + fin;
			if (err.containsKey("nickname"))
				nickError = cabecera + err.get("nickname") + fin;
			if (err.containsKey("decision"))
				decisError = cabecera + err.get("decision") + fin;
			nickValor = request.getParameter("newnickname");
			emailValor = request.getParameter("newemail");
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
			</div>
		</div>
	</section>
	<!--================Breadcrumb Area =================-->
	<%
		String userNick = (String) session.getAttribute("nickname");
		System.out.println("Usuario en sesion: " + userNick);
		Usuario currentUser = UsuarioDAO.findUserByLogin(userNick);
		String userName = currentUser.getNombre();
		String userApell = currentUser.getApellidos();
		String userEmail = currentUser.getEmail();
		int userVehic = currentUser.getVehicle_id();
	%>
	<!--================Sermons work Area =================-->
	<section class="sermons_work_area section_gap">
		<div class="container">
			<div id="moverse1">
				<form id="NuevoNick" action="modificarUser" method="post">
					<table>
						<tr>
							<td>
								<p>
									<label for="nick">Nick:</label> <input readonly type="text"
										name="nick" value="<%=userNick%>" />
								</p>
							</td>
							<td>
								<p>
									<label for="name">Cambiar Nick:</label> <input type="text"
										name="newnickname" value="<%=nickValor%>" id="idNickname" /><%=nickError%><br>
								</p>
							</td>
						</tr>
						<tr>
							<td>
								<p>
									<label for="name">Nombre:</label> <input readonly type="text"
										name="nombre" value="<%=userName%>" />
								</p>
							</td>
							<td>
								<p>
									<label for="name">Cambiar Nombre:</label> <input type="text"
										name="newnombre" value="" />
								</p>
							</td>
						</tr>
						<tr>
							<td>
								<p>
									<label for="apellidos">Apellidos:</label> <input readonly
										type="text" name="apellidos" value="<%=userApell%>" />
								</p>
							</td>
							<td>
								<p>
									<label for="appellidos">Cambiar Apellidos:</label> <input
										type="text" name="newapellidos" value="" />
								</p>
							<td>
						</tr>
						<tr>
							<td>
								<p>
									<label for="password">Contraseña:</label> <input
										type="password" readonly name="password" value="" />
								</p>
							</td>
							<td>
								<p>
									<label for="password">Contraseña:</label> <input
										type="password" name="newpassword" value="" />
								</p>
								<p>
									<label for="password1">Repetir Contraseña:</label> <input
										type="password" name="newpassword1" value="" id="idPassword" /><%=passError%>
								</p>
							</td>
						</tr>
						<tr>
							<td>
								<p>
									<label for="email">Dirección de Correo:</label> <input readonly
										type="text" name="email" value="<%=userEmail%>" />
								</p>
							</td>
							<td>
								<p>
									<label for="email">Cambiar Dirección de Correo:</label> <input
										type="text" name="newemail" value="<%=emailValor%>"
										id="idEmail" /><%=emailError%><br>
								</p>
							</td>
						</tr>
						<tr>
							<td>
								<p>
									<label for="vehiculo">Vehiculo actual:</label> <input readonly
										type="text" name="vehiculo" value="<%=userVehic%>" />
								</p>
							</td>
							<td>
								<p>
									<label for="vehiculo">Cambiar Vehículo:</label> <select
										name="newvehiculo">
										<option selected value="">Elige un tipo de vehículo</option>
										<option value="Moto"><label for="moto">Moto</label>
										</option>
										<option value="Coche"><label for="coche">Coche</label>
										</option>
										<option value="Furgoneta"><label for="furgoneta">Furgoneta</label>
										</option>
										<option value="Camión"><label for="camion">Camión</label>
										</option>
									</select>
								</p>
							</td>
						</tr>
					</table>
					<input type="reset" value="Cancelar" /> <input type="submit"
						value="Modificar Usuario" /> <br>
				</form>
				<form id="DarseDeBaja" action="eliminarUser" method="post"
					style="text-align: center">
					<center>
						<h3>Darse de baja en el servicio</h3><%=decisError%>
					</center>
					<p>Si está seguro, marque la casilla "Si":</p>
					<input type="radio" name="decision" value="no" />No<br> <input
						type="radio" name="decision" value="si" />Si<br> <input
						type="reset" value="Cancelar" /> <input type="submit"
						value="Darse de baja" />
				</form>
			</div>
		</div>
	</section>
	<!--================Sermons work Area=================-->

	<!--================Event Blog Area=================-->
	<section class="event_blog_area section_gap">
		<div class="container">
			<div class="row">
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