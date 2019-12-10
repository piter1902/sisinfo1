<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="height: 100%;">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body style="height: 100%;">
    <nav class="navbar navbar-light navbar-expand-lg fixed-top clean-navbar" style="background-color: rgb(52,4,81);color: rgb(255,255,255);height: 80px;width: 100%;">
        <div class="container"><a class="navbar-brand logo" href="#" style="color: #ffffff;"><br>Sensor Maintenance<br><br></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1" style="background-color: #624592;"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon shadow-lg" style="color: rgb(255,255,255);background-color: #ffffff;"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1" style="background-color: rgb(52,4,81);color: rgb(255,255,255);">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="index.html" style="color: #ffffff;">Inicio</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="query.html" style="color: #ffffff;">Consulta</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="log_in.jsp" style="color: #ffffff;">Log in</a></li>
                </ul>
        </div>
        </div>
    </nav>
    <main class="flex-fill" style="padding-top: 106px;height: 996px;color: rgb(255,255,255);background-image: url(&quot;assets/img/smartcity-1565003196783.jpg&quot;);background-position: bottom;background-size: cover;background-repeat: no-repeat;">
        <div class="container">
            <div>
                <h1 class="display-4 text-monospace text-center" style="padding-top: 10px;color: rgb(255,255,255);">Crear usuario</h1>
                <form class="border rounded-0 border-primary" action ="registerUser" method ="POST"  style="height: 707px;width: 80%;margin-right: 10%;margin-left: 10%;padding-top: 25px;padding-right: 5%;padding-left: 5%;margin-top: 19px;background-color: rgb(68,97,118);">
                    <div class="form-group"><label style="color: rgb(255,255,255);">Nombre de usuario:</label><input class="form-control" type="text" name="username" style="margin-right: 10px;"></div>
                    <div class="form-group"><label style="color: rgb(255,255,255);">Nombre:</label><input class="form-control" type="text" name="firstName" style="margin-right: 10px;"></div>
                    <div class="form-group"><label style="color: rgb(255,255,255);">Apellidos:</label><input class="form-control" type="text" name="lastName" style="margin-right: 10px;"></div>
                    <div class="form-group"><label style="color: rgb(255,255,255);">Año de nacimiento:</label><input class="form-control" type="date" name="nac"></div>
                    <div class="form-group"><label style="color: rgb(255,255,255);">Correo electronico:</label><input class="form-control" type="email" name="email"></div>
                    <div class="form-group"><label style="color: rgb(255,255,255);">Contraseña:</label><input class="form-control" type="password" name="pass"></div>
                    <div class="form-group"><label style="color: rgb(255,255,255);">Repita la contraseña:</label><input class="form-control" type="password" name="repass"></div>
                    <div class="form-group"><input type="submit" value="Crear usuario" style="padding-top: 12px;padding-bottom: 12px;  width: 80%;margin-right: 10%;margin-left: 10%;background-color: rgb(168,50,218);"/></div>
                </form>
            </div>
        </div>
    </main>
    <footer style="background-color: rgb(52,4,81);height: 46px;">
        <p class="text-center" id="COPY" style="align-self: stretch;color: rgb(255,255,255);padding-top: 9px;margin-bottom: 4px;">Â© 2019 Copyright&nbsp;<br></p>
    </footer>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/script.min.js"></script>
</body>

</html>