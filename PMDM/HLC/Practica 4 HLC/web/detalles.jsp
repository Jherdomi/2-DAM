<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fecha.listaComida"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles de la comida</title>
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
                color: #333;
                margin-bottom: 10px;
            }

            p {
                font-size: 18px;                               
                line-height: 1.5;                              
                padding: 20px;                                 
                
            }

            img {
                display: block;                                
                margin-left: 45%;                              
                max-width: 100%;                               
                height: auto;                                  
                margin-top: 0;
            }

            .arribado {
                float: left;
                margin-top: -500px;
            }
            .arriba2{                
                float: left;
                margin-top: -400px;
            }
            .titulo {
                margin-left: 10vw;
                float: left;
                margin-top: -600px;
            }
        </style>
    </head>
    <body>
        <header>
            COMIDAS
	</header>
        <% 
            String datos = request.getParameter("country");
            if (datos != null) {
                if (datos.contains("Revuelto")) {
        %>     
               
        <p>
            <img src="img/revuelto.jpeg" width="800" height="400" alt="Revuelto">
            <h2 class="titulo">Revuelto</h2>
        </p>
        <p class="arribado"><u><strong>  Datos: </strong></u></p>
        </br>
        <p class="arriba2"> <%=datos%></p>
        
        <p><u><strong> Descripcion </strong></u></p>
        
        <p>
            El revuelto de huevo o huevos revueltos es un plato hecho con huevos de gallina ligeramente batidos y cocinado 
            en una sartén con aceite o mantequilla hasta que cuaja y forma grumos. Está considerado uno de los platos más 
            genéricos de la cocina y forma parte principalmente del desayuno, aunque en algunos países también puede ser un 
            plato principal.</br></br>
                
        </p>
            <%                
        } else if (datos.contains("Enchilada")) {
            %><p><h2>Enchilada</h2></p>
        <img src="img/enchilada.jpeg" width="800" height="400" alt="Enchilada">
        
        <p><u><strong>  Datos: </strong></u></p>
        <p> <%=datos%></p>
        
         <p><u><strong> Descripcion </strong></u></p>
        <p>
            Las enchiladas son un plato de la gastronomía de México y Centroamérica, en cada país la preparación e ingredientes 
            son diferentes, en México se elabora con tortillas de maíz enrolladas o dobladas y bañadas en alguna salsa picante. 
            Se trata de uno de los platos más populares de México y presentan gran diversidad en las distintas gastronomías 
            regionales del país. Dependiendo del estilo, la enchilada puede ir acompañada o rellena de carnes —pollo, res, 
            pavo— queso o verdura cocida; además, usualmente se acompaña de alguna guarnición adicional, que generalmente 
            consiste en cebolla fresca picada o en rodajas, lechuga, crema de leche y/o queso.
            </br></br>
                
        </p>

        <%
    } else if (datos.contains("Guacamole")) {
        %><p><h2>Guacamole</h2></p>
        <img src="img/guacamole.jpeg" width="800" height="400" alt="Guacamole">
        
        <p><u><strong>  Datos: </strong></u></p>
        <p> <%=datos%></p>
        
         <p><u><strong> Descripcion </strong></u></p>
        <p>
            El guacamole o guacamol es una salsa mexicana preparada a base de aguacate y chile verde o chile pimiento, y 
            algunas veces tomate/jitomate. El nombre guacamole proviene del náhuatl ahuacamolli traducido al español, 
            que se compone de las palabras ahuacatl (aguacate) + molli (mole o salsa). El aguacate tenía una significación 
            erótica para los aztecas, tanto que las mujeres no podían realizar la recolección de los frutos,
            ya que simbolizaban los testículos. Según la mitología prehispánica, Quetzalcoatl, el dios tolteca, ofreció la 
            receta del guacamole a su pueblo, quienes la extendieron por el territorio de Mesoamérica.
            </br></br>

            Se basa en una salsa de aguacate (también conocido como avocado o palta) a la que se le agregó posteriormente 
            otros ingredientes como cebolla o cilantro y jengibre.
            </br></br>
        </p>
        <%
    } else if (datos.contains("Ezquites")) {
        %><p><h2>Ezquites</h2></p>
        <img src="img/ezquites.jpeg" width="800" height="400" alt="Ezquites">
        
        <p><u><strong>  Datos: </strong></u></p>
        <p> <%=datos%></p>
        
         <p><u><strong> Descripcion </strong></u></p>
        <p>
            Los ezquites en vaso son una preparación mexicana de granos de elote (maíz), generalmente hervido con sal y epazote, 
            aunque con muchas variantes regionales. Se considera un antojito, es decir, una comida de calle mexicana, y es popular del país.  
            Las denominaciones e ingredientes varían ampliamente dependiendo la zona donde se prepare.
            </br></br>
        </p>
        <%
    } else if (datos.contains("Croquetas")) {
        %><p><h2>Croquetas</h2></p>
<img src="img/croqueta.jpeg" width="800" height="400" alt="Croquetas">

<p><u><strong>  Datos: </strong></u></p>
        <p> <%=datos%></p>
        
         <p><u><strong> Descripcion </strong></u></p>
        <p>            
            La croqueta es porción de masa hecha de una salsa densa como la bechamel y un picadillo de diversos ingredientes, que ha sido 
            rebozada en huevo y pan rallado, y frita en abundante aceite. Esto le proporciona una textura crujiente y un color dorado. 
            Generalmente son saladas, tienen forma ovalada y se sirven calientes como entremés o guarnición, aunque también las hay que 
            son dulces y se sirven como postre. La croqueta moderna es de origen francés, aunque lo cierto es que la técnica de reaprovechar 
            las sobras rebozándolas se remonta, por lo menos, a la Antigua Roma. En un principio consideradas una preparación «ordinaria», 
            con el tiempo las croquetas se convirtieron en un plato tradicional de muchas cocinas en Europa, como la española, la italiana 
            o la neerlandesa, y en América, como la cubana.
            </br></br>
        </p>
        <%
    } else if (datos.contains("Feijoada")) {
        %><p><h2>Feijoada</h2></p>
        <img src="img/feijoada.png" width="220" height="150" alt="Feijoada">
        
        <p><u><strong>  Datos: </strong></u></p>
        <p> <%=datos%></p>
        
         <p><u><strong> Descripcion </strong></u></p>
        <p>
            La feijoada («frijolada» o «frejolada» en español) es uno de los platos típicos de la cocina brasileña (considerado como plato 
            nacional), de la gastronomía de Portugal y también muy común en Mozambique y Angola. Sus ingredientes básicos son los frijoles (suelen 
            ser negros en Brasil, blancos o rojos en Portugal) y la carne de cerdo en salazón. Se suele presentar acompañada de arroz y naranjas. 
        </br></br>
        </p><%
    } else if (datos.contains("Tortilla de patatas")) {
        %><p><h2>Tortilla de patatas</h2></p>
        <img src="img/tortilla.jpg" width="220" height="150" alt="Tortilla de patatas">
        
        <p><u><strong>  Datos: </strong></u></p>
        <p> <%=datos%></p>
        
         <p><u><strong> Descripcion </strong></u></p>
        <p>
            La tortilla de patatas o tortilla española es una tortilla u omelet (es decir, huevo batido, cuajado con aceite en la sartén) a la que se 
            le agrega patatas troceadas. Se trata de uno de los platos más conocidos y emblemáticos de la cocina española, siendo un producto muy 
            popular que se puede encontrar en casi cualquier bar o restaurante del país.
            </br></br>

            A partir de la receta básica hay múltiples variantes, tanto en el modo de cocinar los ingredientes como en el cuajado del huevo. 
            El ingrediente adicional más habitual es la cebolla, considerándose más popular incluso la preparación con ella que la receta simple.
            </br></br>
        </p><%
    } else if (datos.contains("Tacos")) {
        %><p><h2>Los Tacos</h2></p>
        <img src="img/tacos.jpeg" width="800" height="400" alt="Tacos">
        
        <p><u><strong>  Datos: </strong></u></p>
        <p> <%=datos%></p>
        
         <p><u><strong> Descripcion </strong></u></p>
        <p>
            El taco es una preparación culinaria muy popular de México que consiste en una tortilla, generalmente de maíz, que comúnmente se enrolla 
            para contener dentro diversos ingredientes y algún tipo de salsa y verdura. Es el antojito más representativo de la cocina mexicana y se 
            puede encontrar en todos los lugares de la república y en restaurantes mexicanos por todo el mundo.
            </br></br>

            En la actualidad los tacos están extendidos mundialmente como un tipo de comida rápida. Sin embargo, lo que se conoce como taco a nivel 
            internacional son los tacos de influencia estadounidense que difieren bastante en ingredientes y preparación de los mexicanos y provienen 
            de la comida Tex-Mex, lo que influye en la forma de preparación y sabor.
            </br></br>

            Estos pueden tener diversos ingredientes y existen diversas presentaciones. Como los tacos dorados o de canasta y varían según su preparación.
            </br></br>
        </p><%
    } else if (datos.contains("Farofa")) {
        %><p><h2>Farofa</h2></p>
        <img src="img/farofa.png" width="220" height="150" alt="Farofa">
        
        <p><u><strong>  Datos: </strong></u></p>
        <p> <%=datos%></p>
        
         <p><u><strong> Descripcion </strong></u></p>
        <p>
            La farofa es un acompañamiento tradicional y típico de la cocina brasileña cuyo ingrediente principal es la mandioca rallada; de la cual se 
            extrae el almidón; NO es harina de mandioca; es la mandioca rallada muy fino para extracción del almidón. Se lo conoce o recibe el nombre de 
            "fariña de mandioca " ("fariña" - farinha- significa "harina" en portugués), es la mandioca propiamente dicha; rallada finamente y tostada. 
            Se puede condimentar generalmente con algún alimento graso y otros ingredientes, tales como: judías carillas, mijo, tocino torrado, chorizo 
            frito, huevos, salsas, cebollas, bananas, col entre otros.
            </br></br>
        </p><%
    } else if (datos.contains("Gazpacho")) {
        %><p><h2>Gazpacho</h2></p>
        <img src="img/gazpacho.png" width="220" height="150" alt="Gazpacho">
        
        <p><u><strong>  Datos: </strong></u></p>
        <p> <%=datos%></p>
        
         <p><u><strong> Descripcion </strong></u></p>
        <p>
            El gazpacho es una sopa fría con varios ingredientes como aceite de oliva, vinagre, agua, hortalizas crudas, generalmente tomates, pepinos, 
            pimientos y ajo. Hay versiones antiguas que añaden a los ingredientes principales harina de habas, naranjas amargas o almendras y no 
            incluyen tomate, que no se utilizó entre sus ingredientes hasta la colonización de América.
            </br></br>

            Suele servirse fresco en los meses calurosos de verano. Su color varía desde el anaranjado pálido al rojo, según se empleen tomates más o 
            menos maduros (que aportan un colorante natural denominado licopeno). El origen del actual gazpacho es incierto, aunque tradicionalmente 
            se lo ha considerado un plato del interior de Andalucía, donde el aceite de oliva y los productos de la huerta son abundantes, y los 
            veranos muy secos y calurosos. Por esta razón, se lo conoce comúnmente como gazpacho andaluz. A pesar de ello, el origen del gazpacho 
            como plato "desmigado" es anterior al uso de hortalizas en su elaboración y data de la época del al-Ándalus.
            </br></br>
        </p><%
    } else {
        %><p>No hay información disponible para esta comida.</p><%
    }
} else {
        %><p>No se seleccionó ninguna comida.</p><%
}
        %>
         <p><a href="index.jsp">Volver</a></p>
         <footer>
		&copy; Derechos reservados
	</footer>
    </body>
</html>
