<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="fecha.listaComida"%>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <jsp:useBean id="fecha" class="fecha.listaComida" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Listar tablas</title>
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
            table {
                border-collapse: collapse;                     
                width: 100%;                                   
                max-width: 800px;                              
                margin: 0 auto;                                 
                margin-bottom: 20px;                           
                background-color: #fff;                         
            }

            th, td {
                text-align: left;                               
                padding: 12px;                                 
                border-bottom: 1px solid #ddd;                 
            }

            th {
                background-color: #8076d7;                      
                color: #fff;                                    
            }

            tr:nth-child(even) {
                background-color: #15325c;                      
            }
            
            tr{
                 background-color: #7977f5;
                 opacity: 80%;
            }

            tr:hover {
                background-color: #5fdac9;                      
            }
    
            
        </style>
    </head>

    <body> 
            <%
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            %>
      
            <% Map<Integer, fecha.listaComida> countries = new Hashtable<Integer, fecha.listaComida>();
                countries.put(1, new listaComida("Revuelto", "revuelto.jpeg", 171, new GregorianCalendar(1846,3,15)));
                countries.put(2, new listaComida("Enchilada", "enchilada.jpeg", 157, new GregorianCalendar(1975,2,15)));
                countries.put(3, new listaComida("Guacamole", "guacamole.jpeg", 178, new GregorianCalendar(1784,7,15)));
                countries.put(4, new listaComida("Gazpacho", "gazpacho.jpeg", 19, new GregorianCalendar(1975,3,15)));
                countries.put(5, new listaComida("Ezquites", "ezquites.jpeg", 178, new GregorianCalendar(1784,3,15)));
                countries.put(6, new listaComida("Croquetas", "croqueta.jpeg", 366, new GregorianCalendar(1975,3,15)));
                countries.put(7, new listaComida("Feijoada", "feijoada.jpeg", 174, new GregorianCalendar(1900,3,15)));
                countries.put(8, new listaComida("Tortilla de patatas", "tortilla.jpeg", 140, new GregorianCalendar(1975,5,15)));
                countries.put(9, new listaComida("Tacos", "tacos.jpeg", 216, new GregorianCalendar(1368,1,15)));
                countries.put(10, new listaComida("Farofa", "farofa.jpeg", 180, new GregorianCalendar(1620,4,15)));
                pageContext.setAttribute("sharePrice", countries);
            %>
    
    <header>
        Practica 4 HLC
    </header>    
    </br></br>

    <div class="responsive-table">
        <table>
            <tr>
                <th>ID</th>
                <th>Comida</th>
                <th>Calorias</th>
                <th>Fecha</th>   
            </tr>
  
            <c:forEach var="entry" items="${pageScope.sharePrice}">            
                 <tr>
                     <td><c:out value="${entry.key}"/></td>
                     <td><c:out value="${entry.value.nombre}"/></td>
                     <td><c:out value="${entry.value.calorias}"/> </td>
                     <td><c:out value="${entry.value.fecha}" /> </td>
                </tr>
            </c:forEach>            
        </table>
        
       
    </div>
         <p><a href="index.jsp">Volver</a></p> 
          <footer>
		BalBer S.L. &copy; 
	</footer>   
    </body>
</html>

