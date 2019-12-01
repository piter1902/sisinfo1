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
	<%
		request.setAttribute("origRequestURL", request.getRequestURL());
		String[] temporal = (request.getRequestURL().toString()).split("/");
		String[] temporal2 = new String[temporal.length - 1];
		for (int i = 0; i < temporal.length - 1; i++) {
			temporal2[i] = temporal[i];
		}
		String path = String.join("/", temporal2);
		request.setAttribute("pathURL", path);
	%>
	<header class="header_area">
		<div class="header_top">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-5"></div>
					<div class="col-sm-6 col-7">
						<div class="top_btn d-flex justify-content-end"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="zoneLink">
			<a class="logo" href="index.jsp"><img class="hoja"
				src="imagenes/marca.png" alt=""></a>
			<table id="tablaCabecera">
				<%
					String nick = (String) session.getAttribute("nickname");
					if (nick == null || nick.trim().equals("")) {
						nick = "";
					}
				%>
				<tr>
					<%
						if (nick.equals("")) {
					%>
					<a class="inicioSesion" href="iniciarSesion.jsp"
						style="float: right; margin-right: 55px;"><img
						class="iconoInicio" src="imagenes/inicioSesion.png" alt=""></a>
					<%
						} else if (!nick.equals("")) {
					%>
					<td>
						<form class="usuarioActual" action="" method="get">
							<p>
								<label for="nick">Usuario:</label> <input size="8px" readonly
									type="text" name="nick" value="<%=nick%>" />
							</p>
						</form>
					</td>
					<td><a class="preferencias" href="datosPersonales.jsp"><img
							class="tuerca" src="imagenes/tuerca.png" alt=""></a></td>
					<td>
						<form class="cerrarSesion" action="logout" method="post">
							<input size="2px" class="campo" type="submit"
								value="Cerrar Sesión" />
						</form>
					</td>
					<%
						}
					%>
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
						<li class="nav-item${origRequestURL  eq  pathURL.concat("/index.jsp") ? ' active' : ''}">
							<center>
								<a class="nav-link" href="index.jsp">Home</a>
							</center>
						</li>
						<li class="nav-item${origRequestURL  eq  pathURL.concat("/contact.jsp") ? ' active' : ''}">
							<center>
								<a class="nav-link" href="contact.jsp">Contact</a>
							</center>
						</li>
						<li class="nav-item${origRequestURL  eq  pathURL.concat("/help.jsp") ? ' active' : ''}">
							<center>
								<a class="nav-link" href="help.jsp">Help</a>
							</center>
						</li>
						<%
							//Solo se muestra pestaña de registro si no ha iniciado sesión.
							String pathURL = (String) request.getAttribute("pathURL");
							String origRequestURL = ((StringBuffer) request.getAttribute("origRequestURL")).toString();
							if (nick == null || nick.trim().equals("")) {
						%>
						<li class="nav-item${origRequestURL  eq  pathURL.concat("/registrarse.jsp") ? ' active' : ''}">
							<center>
								<a class="nav-link" href="registrarse.jsp">Registrarse</a>
							</center>
						</li>
						<%
							}
						%>

					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!--================Header Area =================-->
</body>
</html>