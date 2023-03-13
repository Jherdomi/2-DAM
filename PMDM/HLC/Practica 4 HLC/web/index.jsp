<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Práctica 4 HLC</title>
        
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
            
            h2 {
                text-align: center;                             
                letter-spacing: 2px;
                font-weight: 700;
                font-family: 'Montserrat', sans-serif;
                color: #292525;
                margin-bottom: 10px;
            }
            
            h4{
                font-size: 18px;                                
                line-height: 1.5;                               
            }

            p {
                font-size: 18px;                                
                line-height: 1.5;                               
                padding: 10px;                                  
            }

            img {
                text-align: center;
                display: block;                                 
                margin: 0 auto;                                 
                max-width: 100%;                                
                height: auto;                                   
            }
            
            li{
                margin-bottom: 30px;
            }
            
            ul{
                margin-bottom: 50px;
            }
            
            .centraito {
                text-align: left;
                margin-left: 35vw;
            }
            
            .seguidos{
                position: absolute;
                list-style: none;
                align-content: center;
            }
            
            .seguidos li{
                float: left;
                position: relative; 
            }            
            
            .seguidos a{
                text-decoration: none;  
                position: relative;
                margin-left: 5vw;
                margin-bottom: 5vh;              
            }
            
            .bajo{
                margin-top: 15vh;
            }
        </style>        
    </head>
    <body>
        <header>
            HLC 4
	</header>
        <h4>HLC 4 - JSP:</h4>

        <ul class="centraito">
            <li>Zodiaco: Muestra las edades y el signo</li>
            <li>Art&iacute;culos: Lista de comidas del mundo</li>
            <li>Tabla: Tabla con las comidas más detalladamente </li>
        </ul>

        <h4>Enlaces de la web:</h4>
        <ul class="seguidos centraito">
            <li><a href="jspCalendar.jsp">Zodiaco</a></li>
            <li><a href="listarCSS1.jsp">Articulos</a></li>
            <li><a href ="listarArticulos.jsp">Tabla</a></li>
        </ul>    

        <h4 class="bajo">Autores:</h4>
        <p>Juan Fco H&aacute;ernandez 25/12/2001</p>
        <footer>
            JHERDOMI &copy; 
	</footer>   
    </body>
</html>
