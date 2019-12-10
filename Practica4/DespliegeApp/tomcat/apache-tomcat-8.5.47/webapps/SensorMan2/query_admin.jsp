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

<body class="flex-fill">
    <main class="flex-fill" style="padding-top: 85px;height: 95%;background-image: url(&quot;assets/img/smartcity-1565003196783.jpg&quot;);background-size: cover;background-repeat: no-repeat;background-position: top;color: rgb(255,255,255);">
        <div class="container">
            <div>
                <h1 class="display-4 text-monospace text-center" style="padding-top: 10px;">Consulta administrativa</h1>
                <p class="lead text-center">Obtenga la informacion completa de un sensor especifico introduciendo la id.</p>
                <form class="border rounded-0 border-primary" action ="query_admin2.jsp" method ="POST" style="height: 180px;width: 80%;margin-right: 10%;margin-left: 10%;padding-top: 25px;padding-right: 5%;padding-left: 5%;margin-top: 19px;">
                <input type="number" style="width: 100%;" name="ID"/>
                <input type="submit" value="Consultar" style="padding-top: 12px;margin-top: 25px;"/>
                </form></div>
        </div>
    </main>
    <footer style="background-color: rgb(52,4,81);height: 46px;">
        <p class="text-center" id="COPY" style="align-self: stretch;color: rgb(255,255,255);padding-top: 9px;margin-bottom: 4px;">© 2019 Copyright&nbsp;<br></p>
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