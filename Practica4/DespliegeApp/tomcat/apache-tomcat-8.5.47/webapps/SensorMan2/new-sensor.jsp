<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>



<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body>
    <main class="flex-fill" style="padding-top: 106px;height: 95%;color: rgb(255,255,255);background-image: url(&quot;assets/img/smartcity-1565003196783.jpg&quot;);background-position: bottom;background-size: cover;background-repeat: no-repeat;">
        <div class="container">
            <div>
                <h1 class="display-4 text-monospace text-center" style="padding-top: 10px;color: rgb(255,255,255);">Insertar Sensor</h1>
                <form class="border rounded-0 border-primary" action ="registerSensor" method ="POST"  style="height: 457px;width: 80%;margin-right: 10%;margin-left: 10%;padding-top: 25px;padding-right: 5%;padding-left: 5%;margin-top: 19px;background-color: rgb(68,97,118);">
                    <div class="form-group"><label style="color: rgb(255,255,255);">Id de sensor:</label><input class="form-control" type="number" name="idSensor" style="margin-right: 10px;"></div>
                    <div class="form-group"><label style="color: rgb(255,255,255);">Tipo (0=low cost, 1=atmosféricos, 2=contaminación):</label><input class="form-control" type="number" name="typeSensor" style="margin-right: 10px;"></div>
                    <div class="form-group"><label style="color: rgb(255,255,255);">Latitud:</label><input class="form-control" type="number" name="LatSensor" style="margin-right: 10px;"></div>
                    <div class="form-group"><label style="color: rgb(255,255,255);">Longitud:</label><input class="form-control" type="number" name="LongSensor"></div>
                     <div class="form-group"><input type="submit" value="Introducir sensor" style="padding-top: 12px;padding-bottom: 12px;  width: 80%;margin-right: 10%;margin-left: 10%;background-color: rgb(168,50,218);"/></div>
                </form>
            </div>
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
                    <li class="nav-item" role="presentation"><a class="nav-link" href="query_admin.html" style="color: #ffffff;">Consulta administrativa</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="new-sensor.jsp" style="color: #ffffff;">registrar sensor</a></li>
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