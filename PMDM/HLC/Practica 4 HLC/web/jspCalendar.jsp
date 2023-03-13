<!DOCTYPE html>
<html  lang="es">
<head>
<title>HLC 4: Zodiaco</title>
<style>
    body {
        font-family: Arial, sans-serif;                 
        background-color: #b1b1b1;                     
        margin: 0px;                                  
        margin-top: 0;
        padding: 0;                                   
        text-align: center;                           
        width: 100%;
    }

    header {
        background-color: #8076d7;
        text-align: center;
        font-size: 30px;
        padding: 50px;
        color: black;	
        margin-top: 0;	
    }

    footer {
        background-color: #8076d7;
        padding: 10px;
        text-align: center;
        color: black;
        width: 100%;
    }
    h1 {
        font-size: 36px;                              
        text-align: center;                           
    }
</style>
</head>
    <body>    
        <header>
            Practica 4 HLC
        </header>
        <%@page language="java" import="java.util.*" %>
        <H1>Bienvenido a JSPCalendar</H1>
        <jsp:useBean id="clock" class="fecha.JspCalendar" />
        <p>
            Fecha actual: <%= clock.getDayOfMonth() %>/<%= clock.getMonthInt() %>/<%= clock.getYear() %>
        </p>
        </br>
        </br>
        <%-- Check for AM or PM --%>
        <%! int time = Calendar.getInstance().get(Calendar.AM_PM); %>
        <%
        if (time == Calendar.AM) {
        %>
        <h2>Buenos d&iacute;as!</h2>
        <%
        }
        else {
        %>
        <h2>Buenas tardes!</h2>
        <%
        }
        %>
        <%--
        <%@ include file="copyright.html" %>
        --%>

        </br>
        </br>

        <h4>Juanfri: <%= clock.calcularEdad() %> (<%= clock.SignoZodiaco() %>)</h4>
        </br>
        <p><a href="index.jsp">Volver</a></p>
        <footer>
                &copy; Derechos reservados
        </footer>   
    </body>
</html> 
