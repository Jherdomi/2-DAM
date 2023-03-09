<%@page import="dao.CuentaDaoImplement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRINCIPAL</title>
        <link rel="stylesheet" href="estilos/style.css">
    </head>
    <body>
        <% Boolean conectado = (Boolean) session.getAttribute("conectado");
            if (!conectado.booleanValue()) { 
                response.sendRedirect(request.getContextPath() + "index.jsp");
            } else { %>

        <header>
            <h1>Práctica 5 HLC</h1>
            <form method="post" action="CerrarSesion">
                <input type="submit" value="Salir" />
            </form>
        </header>

        <% int id = Integer.parseInt(session.getAttribute("id").toString());
            double recargo = new CuentaDaoImplement().getRecargo(id);%>

        <img src="fotos/${foto}" />
        <h1>Bienvenid@ ${nombre}</h1>
        <div class="list">
            <button class="option" onclick='alert("<%= recargo%>")'>Recargos Pendientes</button>

            <button class="option" onclick="location.href = 'tabla.jsp';">Tabla</button>
            
            <button class="option" onclick="location.href = 'articulo.jsp';">Articulos</button>
        </div>
        <footer><h1>Trabajo realizado por: <a href="github.com/Jherdomi">Juan Fco Hernández Domínguez</a></h1></footer>

        <% }%>
    </body>
</html>
