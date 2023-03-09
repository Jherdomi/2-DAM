<%@page import="dao.MensajeDaoImplement"%>
<%@page import="model.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Articulo</title>
        <link rel="stylesheet" href="estilos/style.css">
    </head>
    <body>
        <% Boolean conectado = (Boolean) session.getAttribute("conectado");
            if (!conectado.booleanValue()) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {%>
        <header>
            <h1>Práctica 5 HLC</h1>
            <form method="post" action="CerrarSesion">
                <input type="submit" value="Salir" />
            </form>
            <form method="post" action="principal.jsp">
                <input type="submit" value="Atras" />
            </form>
        </header>
        <div class="list">
            <%
                int id = Integer.parseInt(session.getAttribute("id").toString());
                ArrayList<Mensaje> mensajes = new MensajeDaoImplement().getMensajesUsuario(id);
                for (Mensaje men : mensajes) {
                    Mensaje mensaje = men;

            %>
            <section>
                    <article class="espacio">
                        <h4><b><%= mensaje.getAsunto()%></b></h4>
                        <form method="post" action="detalle.jsp">
                            <input type="hidden" value="<%= mensaje.getNumero()%>" name="id" />
                            <input type="submit" class="btn btn-primary" value="Detalles">
                        </form>
                        <br>
                    </article> 
                </section>
                <% } %>
        </div>
        <footer><h1>Trabajo realizado por: <a href="github.com/Jherdomi">Juan Fco Hernández Domínguez</a></h1></footer>
            <% }%>
    </body>
</html>
