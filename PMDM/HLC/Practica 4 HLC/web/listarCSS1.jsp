<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fecha.listaComida"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
         <%-- <link rel="icon" type="image/x-icon" href="00_resources/images/esa_logo.ico"> --%>
        <style>
            h1 {
                font-size: 36px;                                    
                text-align: center;                                 
            }
            * {
                box-sizing: border-box;
            }
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
            
            .column {
                float: left;
                width: 25%;
                padding: 10px;
                height: 300px;                                     
            }

            
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            
            @media screen and (max-width: 1000px) {
                .column {
                    width: 100%;
                }
            }
        </style>
    </head>

    <body>  
        <header>
		Practica 4 HLC
	</header> 
        </br></br>
        <%--<%!HashMap<Integer, Country> countries = new HashMap<Integer, Country>();%>
        <%
            countries.put(1, new Country("España", "spain.png", 169, new GregorianCalendar(1975,3,15)));
            countries.put(2, new Country("Alemania", "germany.png", 614, new GregorianCalendar(1975,3,15)));
            countries.put(3, new Country("Francia", "france.png", 778, new GregorianCalendar(1975,3,15)));
            countries.put(4, new Country("Noruega", "norway.png", 33, new GregorianCalendar(1975,3,15)));
            countries.put(5, new Country("Italia", "italy.png", 397, new GregorianCalendar(1975,3,15)));
            countries.put(6, new Country("Irlanda", "ireland.png", 12, new GregorianCalendar(1975,3,15)));
        %>--%>
        
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

         
        <section class="row">
           
            <%
                for(java.util.Map.Entry<Integer, fecha.listaComida> mem : countries.entrySet()) {
                    int index = mem.getKey();
                    listaComida country = mem.getValue();
            %>
            <article class="column">
                <div style="text-align:center">
                    <%--<img src="00_resources/images/<%=country.getFoto()%>" width="220" height="150" alt="Flag Image">--%>
                    <img src="img/<%=country.getFoto()%>" width="220" height="150" alt="Comida Imagen">
                    <h5><%=country.getNombre()%></h5>
                    <% String datos = "\nNombre: " + country.getNombre() + "     \nCalorias: " + country.getCalorias() + "     \nFecha Invencion: " + country.getFecha();
                        %>
                    <form action="detalles.jsp">
                        <input type="hidden" value="<%=datos%>" name="country"/>
                        <input type="submit" class="btn btn-primary" value="Saber Más"/>
                    </form>
                </div>
            </article>
            <%
                }
            %>
        </section>
         <p><a href="index.jsp">Volver</a></p>
          <footer>
		BalBer S.L. &copy; 
	</footer>   
    </body>
</html>
