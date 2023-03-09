<%@page import="dao.UsuarioDaoImplement"%>
<%@page import="model.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <title><%=request.getSession().getAttribute("usuarioName").toString().substring(0, 1).toUpperCase() + request.getSession().getAttribute("usuarioName").toString().substring(1)%>'s Cuentas</title>
        
    </head>
    <body style="background-color: #ccccff">
        <div class="container">
            <h2>Estás conectado como <%=request.getSession().getAttribute("usuarioName").toString().substring(0, 1).toUpperCase() + request.getSession().getAttribute("usuarioName").toString().substring(1)%>.
            </h2>    
            <form action="index.jsp" method="post">
                <input type="submit" value="Log out" name="logout">
                <input type="hidden" name="invalidate" value="true">
            </form>
        </div>
        <%
            ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) request.getAttribute("cuentas");
            UsuarioDaoImplement UDI = new UsuarioDaoImplement();
        %>
        <div class="container"> 
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Email</th>
                        <th>Fecha de alta</th>
                        <th>Mensajes Max</th>
                        <th>Coste extra por msg</th>
                        <th>Usuario</th>                          
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int i = 0; i < cuentas.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <%=cuentas.get(i).getCodigo()%> 
                        </td>
                        <td>
                            <%=cuentas.get(i).getEmail()%> 
                        </td>
                        <td>
                            <%=cuentas.get(i).getFechaalta()%> 
                        </td>
                        <td>
                            <%=cuentas.get(i).getMaximomensajes()%> 
                        </td>
                        <td>
                            <%=cuentas.get(i).getCostemensajeextra()%> 
                        </td>
                        <td>
                            <%=cuentas.get(i).getUsunumero()%> 
                        </td>                            
                    </tr>

                    <%
                        }
                    %>
                </tbody>
            </table> 
        </div>
        <footer><h1>Trabajo realizado por: <a href="github.com/Jherdomi">Juan Fco Hernández Domínguez</a></h1></footer>
    </body>
</html>
