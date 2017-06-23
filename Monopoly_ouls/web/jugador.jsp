<%-- 
    Document   : jugador
    Created on : 18.06.2017, 09:03:15
    Author     : User
--%>

<%@page import="Contenedores.Jugador"%>
<%@page import="Contenedores.Casilla" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Contenedores.Tablero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles Jugador</title>
    </head>
    <body>
        <%
            String id_jugador = request.getParameter("id");
            HttpSession objSesion = request.getSession(false);
            Tablero tablero = (Tablero) session.getAttribute("tablero");
        %>    
        <h1>Jugador <%out.print(id_jugador);%> - Datos del jugador </h1>
        <h2><%
            ArrayList jugadores = tablero.getJugadores();
            //int numero_jugadores = jugadores.size();
            String ret = "<table border='1px black' style='border-collapse:collapse; padding-left: 5px; padding-right: 5px;'>";
            //for (int i = 0; i < jugadores.size(); i++) {
            int numero_jugador = Integer.parseInt(id_jugador);
            Jugador jugador = (Jugador) jugadores.get(Integer.parseInt(id_jugador) - 1);
            String str_jugador = jugador.getNombre();
            int dinero = jugador.getDineroTotal();

            ret += "<tr><br/><td>&nbsp;&nbsp;" + str_jugador + "&nbsp;&nbsp;</td>";
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
            ret += "<tr><td>&nbsp;&nbsp;Dinero disponible&nbsp;&nbsp;</td><td>&nbsp;&nbsp;" + dinero + "&nbsp;&nbsp;</td></tr></table>";

            ret += "<br/><table border='1px black' style='border-collapse:collapse; padding-left: 5px; padding-right: 5px;'>";
           /* ret += "<tr><td>&nbsp;&nbsp;Billetes&nbsp;&nbsp;</td><td>&nbsp;&nbspCantidad&nbsp;&nbsp</td></tr>";
            ret += "<tr><td>&nbsp;&nbsp;De 1&nbsp;&nbsp;</td><td style='text-align:center;'>&nbsp;&nbsp;" + jugador.getBilletes_de_1() + "&nbsp;&nbsp;</td></tr>";
            ret += "<tr><td>&nbsp;&nbsp;De 5&nbsp;&nbsp;</td><td style='text-align:center;'>&nbsp;&nbsp;" + jugador.getBilletes_de_5() + "&nbsp;&nbsp;</td></tr>";
            ret += "<tr><td>&nbsp;&nbsp;De 10&nbsp;&nbsp;</td><td style='text-align:center;'>&nbsp;&nbsp;" + jugador.getBilletes_de_10() + "&nbsp;&nbsp;</td></tr>";
            ret += "<tr><td>&nbsp;&nbsp;De 20&nbsp;&nbsp;</td><td style='text-align:center;'>&nbsp;&nbsp;" + jugador.getBilletes_de_20() + "&nbsp;&nbsp;</td></tr>";
            ret += "<tr><td>&nbsp;&nbsp;De 50&nbsp;&nbsp;</td><td style='text-align:center;'>&nbsp;&nbsp;" + jugador.getBilletes_de_50() + "&nbsp;&nbsp;</td></tr>";
            ret += "<tr><td>&nbsp;&nbsp;De 100&nbsp;&nbsp;</td><td style='text-align:center;'>&nbsp;&nbsp;" + jugador.getBilletes_de_100() + "&nbsp;&nbsp;</td></tr>";
            ret += "<tr><td>&nbsp;&nbsp;De 500&nbsp;&nbsp;</td><td style='text-align:center;'>&nbsp;&nbsp;" + jugador.getBilletes_de_500() + "&nbsp;&nbsp;</td></tr></table>";
*/
            if (jugador.getEsta_en_la_carcel() == 0) {
                ret += "<br/>" + str_jugador + " no está en la cárcel.";
            } else {
                if (jugador.getTurnos_en_la_carcel() != 1) {
                    ret += "<br/>CÁRCEL. " + str_jugador + " lleva " + jugador.getTurnos_en_la_carcel() + " turnos en la cárcel.";
                } else {
                    ret += "<br/>CÁRCEL. " + str_jugador + " lleva " + jugador.getTurnos_en_la_carcel() + " turno en la cárcel.";
                }
            }

            if (jugador.getEsta_en_la_carcel() == 0) {
                ArrayList casillas = tablero.getCasillas();
                Casilla casilla_actual = new Casilla();
                casilla_actual = ((Casilla) casillas.get(jugador.getEsta_en_casilla()));
                String nombre_casilla = casilla_actual.getNombre();
                if (jugador.getEsta_en_casilla() == 0) {
                    ret += "<br/><br/>" + str_jugador + ", actualmente, está en la casilla " + jugador.getEsta_en_casilla() + ", SALIDA.";
                } else {
                    ret += "<br/><br/>" + str_jugador + ", actualmente, está en la casilla " + jugador.getEsta_en_casilla() + ", " + nombre_casilla;
                }
            }

            ArrayList casillas_jugador = jugador.getCasillas();
            Casilla casilla_actual = new Casilla();
                
            if (casillas_jugador.size() == 0) {
                ret += "<br/><br/>" + jugador.getNombre() + " aún no ha comprado ninguna casilla.<br/>";
            } else {
                ret += "<br/><br/>Casillas compradas:<br/>";
                ret += "<table border='1px black' style='border-collapse:collapse; padding-left: 5px; padding-right: 5px;'>";
                for (int i = 0; i < casillas_jugador.size(); i++) {
                    casilla_actual = ( (Casilla) casillas_jugador.get(i));
                    ret += "<tr><td>" + casilla_actual.getNombre() + "</td></tr>";
                }
                ret += "</table>";
            }

            //}
            out.print(ret);
            %> 

        </h2>
    </body>
</html>
