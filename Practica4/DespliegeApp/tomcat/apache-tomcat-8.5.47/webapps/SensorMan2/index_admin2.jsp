
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*"%>
<%@ page import="pdaosyvos.*"%>
<!DOCTYPE html>
<html>

<% HttpSession prueba = request.getSession(false);
	System.out.println(prueba.getAttribute("username"));
	String username =(String) prueba.getAttribute("username");
   
   List<SensorVO> result = new ArrayList<SensorVO>();
   result = SensorDAO.List(username,10);
   int uno = result.size();
   System.out.println(uno);
 %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body class="flex-fill" style="height: 100%;">
    <nav class="navbar navbar-light navbar-expand-lg fixed-top clean-navbar" style="background-color: rgb(52,4,81);color: rgb(255,255,255);width: 100%;height: 80px;">
        <div class="container"><a class="navbar-brand logo" href="#" style="color: #ffffff;"><br>Sensor Maintenance<br><br></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1" style="background-color: #624592;"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon shadow-lg" style="color: rgb(255,255,255);background-color: #ffffff;"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1" style="background-color: rgb(52,4,81);color: rgb(255,255,255);">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="index_admin.jsp" style="color: #ffffff;">Inicio</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="query_admin.jsp" style="color: #ffffff;">Consulta administrativa</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="new-sensor.jsp" style="color: #ffffff;">registrar sensor</a></li>      
                    <li class="nav-item" role="presentation"><a class="nav-link" href="index.html" style="color: #ffffff;">Log out</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="delete_user.jsp" style="color: #ffffff;">Borrar usuario</a></li>
                </ul>
        </div>
        </div>
    </nav>
    <main class="flex-fill" style="width: 100%;height: 95%;background-image: url(&quot;assets/img/smartcity-1565003196783.jpg&quot;);background-position: top;background-size: cover;background-repeat: no-repeat;">
        <section class="clean-block clean-form dark" style="height: 330px;background-color: rgba(246,246,246,0);">
            <div class="container" style="width: 90%;height: 80%;">
                <div class="block-heading">
                	<% 
                	String vacio="";%>
                    <c:choose>
                        <c:when test="(username.equals(vacio))">
                            <h2 style="color: #ffffff;">Pagina principal administrativa</h2>
                        </c:when>    
                        <c:otherwise>
                            <h2 style="color: #ffffff;">Pagina principal administrativa de ${username}</h2>
                        	                        </c:otherwise>
                    </c:choose>
                    <p style="color: rgb(255,255,255);background-color: rgba(0,0,0,0.46);">Bienvenido a la pagina principal administrativa. Seleccione el botan de abajo para obtener una lista de sus sensores registrados con su estado o realice una consulta desde la barra de navegacian.</p>
               </div><a class="btn btn-primary btn-block" role="button" href="index_admin2.jsp" style="padding-top: 12px;margin-top: 25px;">Obtener sensores</a></div>
        </section>
		        <div class="container" style="width: 90%;height: 80%;">
            <%if (uno==0){ %>
                <p>No tienes ningun sensor registrado.</p>
        	<%}else{ %>
            <table border="1" align="center" style="background-color:rgb(54,4,81)" >
				<tr>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Id del sensor</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Tipo</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Latitud</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Longitud</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Estado</th>
				</tr>
				<%Iterator<SensorVO> iterator = result.iterator();
				while(iterator.hasNext()){
						SensorVO sensor = iterator.next();
				%>
				<tr>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">
					<% out.println(sensor.getid()); %></th>
 					<%if(sensor.gettipo()==0){%>
 							<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Low cost</th>
 					<%}else if(sensor.gettipo()==1){ %>
 							<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Atmosferico</th>
 					<%}else{ %>
 							<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Contaminacion</th>
 					<%} %>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(sensor.getlatitud()); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(sensor.getlongitud()); %></th>
 					
 					<%if(sensor.getestado()==1){ %>
 						<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">ACTIVO</th>
 					<%}else{ %>
 					 	<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">FUERA DE SERVICIO</th>
 					<%} %>
				</tr>
				<%} %>
				</table>
       <%} %>
       </div>
    </main>
    <footer style="background-color: rgb(52,4,81);height: 46px;">
        <p class="text-center" id="COPY" style="align-self: stretch;color: rgb(255,255,255);padding-top: 9px;margin-bottom: 4px;">© 2019 Copyright&nbsp;<br></p>
    </footer>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/script.min.js"></script>
</body>

</html>
