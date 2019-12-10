<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*"%>
<%@ page import="pdaosyvos.*"%>
<!DOCTYPE html>
<html>

<%   String userid = session.getAttribute("username").toString();
	int sensorid = Integer.parseInt(request.getParameter("ID"));
   List<MedicionVO> result = new ArrayList<MedicionVO>();
   result = MedicionDAO.List(sensorid,10);
   int size = result.size();
   int tipo = 0;
	int CO=0;
	int NO2=0;
	int NO=0;
	int O3=0;
	int Convectie_scale_velocity=0;
	int Planetary_Boundary=0;
	int Surface_friction_vel=0;
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

<body class="flex-fill">
    <main class="flex-fill" style="padding-top: 85px;height: 95%;background-image: url(&quot;assets/img/smartcity-1565003196783.jpg&quot;);background-size: cover;background-repeat: no-repeat;background-position: top;color: rgb(255,255,255);">
        <div class="container">
            <div>
                <h1 class="display-4 text-monospace text-center" style="padding-top: 10px;">Consulta administrativa</h1>
                <p class="lead text-center">Obtenga la informacion completa de un sensor especifico introduciendo la id.</p><form class="border rounded-0 border-primary" action ="query_admin2.jsp" method ="POST" style="height: 200px;width: 80%;margin-right: 10%;margin-left: 10%;padding-top: 25px;padding-right: 5%;padding-left: 5%;margin-top: 19px;">
                <input type="number" style="width: 100%;" name="ID"/>
                <input type="submit" value="Consultar" style="padding-top: 12px;margin-top: 25px;"/>
                </form></div>
        </div>
        <div class="container" style="width: 90%;height: 80%;">
            <%if (size==0){ %>
                <p>No tiene ninguna medición registrada.</p>
        	<%}else{
        		Iterator<MedicionVO> iterator = result.iterator();
        		MedicionVO medicion = iterator.next();
        		Integer C6H6 = medicion.getC6H6();
				Integer roughness_length = medicion.getroughness_length();
				if(C6H6 != null){
					//Tipo = 1 (C6H6,CO,NO,NO2,O3)
					tipo = 1;
					CO = medicion.getCO();
					NO2 = medicion.getNO2();
					NO = medicion.getNO();
					O3 = medicion.getO3();
				}else if(roughness_length != null){
					//Tipo = 3 (roughness_length,Convectie_scale_velocity,Planetary_Boundary,Surface_friction_vel)
					tipo = 3;
					Convectie_scale_velocity = medicion.getConvectie_scale_velocity();
					Planetary_Boundary = medicion.getPlanetary_Boundary();
					Surface_friction_vel = medicion.getSurface_friction_vel();
				}else{
					tipo = 2;
					CO = medicion.getCO();
					NO2 = medicion.getNO2();
					NO = medicion.getNO();
					O3 = medicion.getO3();
				}
        		%>
            <table border="1" align="center" style="background-color:rgb(54,4,81)">
            	<%if (tipo == 1){ %>
				<tr>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">C6H6</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">CO</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">NO</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">NO2</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">O3</th>
				</tr>
				<tr>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(C6H6); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(CO); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(NO); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(NO2); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(O3); %></th>
				</tr>		
				<%}else if(tipo == 2){ %>
				<tr>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">CO</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">NO</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">NO2</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">O3</th>
				</tr>		
				<tr>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(CO); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(NO); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(NO2); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(O3); %></th>
				</tr>		
				<%}else{ %>
				<tr>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Roughness lenght</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Convectile scale velocity</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">PLanetary boundary</th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;">Surface friction velocity</th>
				</tr>
				<tr>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(roughness_length); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(Convectie_scale_velocity); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(Planetary_Boundary); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(Surface_friction_vel); %></th>
				</tr>
				<%
				}
            	while(iterator.hasNext()){
						medicion = iterator.next();
						tipo = 0; //No tiene tipo
						C6H6 = medicion.getC6H6();
						roughness_length = medicion.getroughness_length();
						if(C6H6 != null){
							//Tipo = 1 (C6H6,CO,NO,NO2,O3)
							tipo = 1;
							CO = medicion.getCO();
							NO2 = medicion.getNO2();
							NO = medicion.getNO();
							O3 = medicion.getO3();
						}else if(roughness_length != null){
							//Tipo = 3 (roughness_length,Convectie_scale_velocity,Planetary_Boundary,Surface_friction_vel)
							tipo = 3;
							Convectie_scale_velocity = medicion.getConvectie_scale_velocity();
							Planetary_Boundary = medicion.getPlanetary_Boundary();
							Surface_friction_vel = medicion.getSurface_friction_vel();
						}else{
							tipo = 2;
							CO = medicion.getCO();
							NO2 = medicion.getNO2();
							NO = medicion.getNO();
							O3 = medicion.getO3();
						}
				%><%if (tipo == 1){ %>
				<tr>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(C6H6); %></th>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(CO); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(NO); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(NO2); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(O3); %></th>
				</tr>		
				<%}else if(tipo == 2){ %>
				<tr>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(CO); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(NO); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(NO2); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(O3); %></th>
				</tr>		
				<%}else{ %>
				<tr>
					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(roughness_length); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(Convectie_scale_velocity); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(Planetary_Boundary); %></th>
 					<th style="color: #ffffff;padding-right: 10px;padding-left: 10px;"><% out.println(Surface_friction_vel); %></th>
				</tr>
				<%} %>
      		 <%} %>
				</table>
      		 <%} %>
       </div>
    </main>
    <footer style="background-color: rgb(52,4,81);height: 46px;">
        <p class="text-center" id="COPY" style="align-self: stretch;color: rgb(255,255,255);padding-top: 9px;margin-bottom: 4px;">Â© 2019 Copyright&nbsp;<br></p>
    </footer>
    <nav class="navbar navbar-light navbar-expand-lg fixed-top clean-navbar" style="background-color: rgb(52,4,81);color: rgb(255,255,255);width: 100%;height: 80px;">
        <div class="container"><a class="navbar-brand logo" href="#" style="color: #ffffff;"><br>Sensor Maintenance<br><br></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1" style="background-color: #624592;"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon shadow-lg" style="color: rgb(255,255,255);background-color: #ffffff;"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1" style="background-color: rgb(52,4,81);color: rgb(255,255,255);">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="index_admin.jsp" style="color: #ffffff;">Inicio</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="query_admin.jsp" style="color: #ffffff;">Consulta administrativa</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="new-sensor.jsp" style="color: #ffffff;">registrar sensor</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="index.html" style="color: #ffffff;">Log out</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="delete_user.jsp" style="color: #ffffff;">Borrar usuario</a></li>
                </ul>
        </div>
        </div>
    </nav>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/script.min.js"></script>
</body>

</html>