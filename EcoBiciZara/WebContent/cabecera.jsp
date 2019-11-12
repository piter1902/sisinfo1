<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
							<%
								String nick = (String) session.getAttribute("nickname");
								if (nick == null || nick.trim().equals("")) {
									nick = "";
								}
							%>
							<p>
								<label for="nick">Usuario:</label> <input size="8px" readonly
									type="text" name="nick" value="<%=nick%>" />
							</p>
						</form>
					</td>
					<%
						if (!nick.equals("")) {
					%>
					<td><a class="preferencias" href="datosPersonales.jsp"><img
							class="tuerca" src="imagenes/tuerca.png" alt=""></a></td>
					<%
						}
					%>
					<td>
						<form class="cerrarSesion" action="logout" method="post">
							<input size="2px" class="campo" type="submit"
								value="Cerrar Sesión" />
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
						<li class="nav-item active">
							<center>
								<a class="nav-link" href="index.jsp">Home</a>
							</center>
						</li>
						<li class="nav-item">
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
</body>
</html>