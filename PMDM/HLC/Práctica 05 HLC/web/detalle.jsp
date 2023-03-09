<%@page import="dao.CuentaDaoImplement"%>
<%@page import="dao.UsuarioDaoImplement"%>
<%@page import="model.Mensaje"%>
<%@page import="dao.MensajeDaoImplement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle</title>
        <link rel="stylesheet" href="estilos/style.css">
    </head>
    <body>
        <% Boolean conectado = (Boolean) session.getAttribute("conectado");
            if (!conectado.booleanValue()) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {%>
        <% int id = Integer.parseInt("" + session.getAttribute("id"));
            Mensaje men = new MensajeDaoImplement().getMensaje(id);
            String origen = new CuentaDaoImplement().getEmail(men.getCuecodigoorigen());
        %>
        <header>
            <h1>Práctica 5 HLC</h1>
            <form method="post" action="CerrarSesion">
                <input type="submit" value="Salir" />
            </form>
            <form method="post" action="articulo.jsp">
                <input type="submit" value="Atras" />
            </form>
        </header>
        <section>
            <article id="mensaje">
                <h1><%= men.getAsunto()%></h1>
                <h1>De: <%= origen%></h1>
                <p>Fecha Envio: <%= men.getFecha().toString()%><p>
                <p>Leido: <% if (men.getLeido() == 1) { %>
                    Si
                    <%} else { %>
                    No
                    <%}%></p>
                <p><%= men.getContenido()%></p>
            </article>
        </section>
        <footer><h1>Trabajo realizado por: <a href="github.com/Jherdomi">Juan Fco Hernández Domínguez</a></h1></footer>
            <% }%>
    </body>
</html>
