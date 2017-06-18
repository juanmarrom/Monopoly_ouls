<%-- 
    Document   : jugador
    Created on : 18.06.2017, 09:03:15
    Author     : User
--%>

<%@page import="Contenedores.Jugador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Contenedores.Tablero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Jugador</title>
    </head>
    <body>
    <%
        String id_jugador = request.getParameter("id"); 
        HttpSession objSesion = request.getSession(false); 
        Tablero tablero = (Tablero) session.getAttribute("tablero");
    %>    
    <h1>Jugador <%out.print(id_jugador);%> </h1>
    <h1>Tablero 
        <%
            ArrayList jugadores = tablero.getJugadores();
            int numero_jugadores = jugadores.size();
            String ret = "<table border='1px black' style='border-collapse:collapse; padding-left: 5px; padding-right: 5px;'>";                            
            for (int i = 0; i < jugadores.size(); i++) {
                ret += "<tr>";
                int numero_jugador = i + 1;            
                Jugador jugador = (Jugador)jugadores.get(i);
                String str_jugador = jugador.getNombre();
                int dinero = jugador.getDineroTotal();

                ret += "<td>&nbsp;&nbsp;Jugador " + numero_jugador + "&nbsp;&nbsp;" + str_jugador + "&nbsp;&nbsp;(" + dinero + ")</td>";
                String color_jugador = jugador.getColor();
                if (color_jugador.compareToIgnoreCase("azul") == 0) {
                    ret += "<td style=\"background-color:blue\">&nbsp;&nbsp;</td>";
                }
                if (color_jugador.compareToIgnoreCase("amarillo") == 0) {
                    ret += "<td style=\"background-color:yellow\">&nbsp;&nbsp;</td>";
                }
                if (color_jugador.compareToIgnoreCase("naranja") == 0) {
                    ret += "<td style=\"background-color:orange\">&nbsp;&nbsp;</td>";
                }
                if (color_jugador.compareToIgnoreCase("verde") == 0) {
                    ret += "<td style=\"background-color:green\">&nbsp;&nbsp;</td>";
                }
                if (color_jugador.compareToIgnoreCase("rojo") == 0) {
                    ret += "<td style=\"background-color:red\">&nbsp;&nbsp;</td>";
                }
                if (color_jugador.compareToIgnoreCase("violeta") == 0) {
                    ret += "<td style=\"background-color:violet\">&nbsp;&nbsp;</td>";
                }
                if (color_jugador.compareToIgnoreCase("negro") == 0) {
                    ret += "<td style=\"background-color:black\">&nbsp;&nbsp;</td>";
                }
                ret += "</tr>";
            }
            out.print(ret);
        %> 
    
    </h1>
    </body>
</html>
