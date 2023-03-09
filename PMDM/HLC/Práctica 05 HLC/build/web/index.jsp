<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>IES El Majuelo</title>
        <link rel="stylesheet" href="estilos/style.css">
    </head>
    <body>
        <% session.setAttribute("conectado", false);%>
        <header><h1>Práctica 5 HLC</h1></header>

        <h2>Github: Jherdomi</h2>
        <h2>Gmail: jherdom495@g.educaand.es</h2>

        <form method="post" action="InicioSesion">
            Usuario:    <input type="text" name="user"></br>
            Contraseña: <input type="password" name="pass"</br>
            </br></br><input type="submit" value="Login">
        </form>

        <footer><h1>Trabajo realizado por: <a href="github.com/Jherdomi">Juan Fco Hernández Domínguez</a></h1></footer>
    </body>
</html>
