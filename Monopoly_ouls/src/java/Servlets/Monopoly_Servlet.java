/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Contenedores.Casilla;
import Contenedores.Dado;
import Contenedores.Jugador;
import Contenedores.Tablero;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class Monopoly_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    
    Tablero tablero;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Monopoly_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Monopoly_Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType( "text/html; charset=iso-8859-1" );
        PrintWriter out = response.getWriter();
       
        
        // Obtengo los datos de la peticion
        String accion = request.getParameter("accion");
        
        System.out.println("TEST: '" + accion + "'");
        if (accion.compareToIgnoreCase("nueva") == 0) {
            HttpSession session = request.getSession();
            String carpeta = request.getParameter("carpeta");
            session.setAttribute("carpeta", carpeta);             
            inicializar(request, carpeta);
            String nombre1 = request.getParameter("nombre1");
            String color1 = request.getParameter("color1");
            String nombre2 = request.getParameter("nombre2");
            String color2 = request.getParameter("color2");
            String nombre3 = request.getParameter("nombre3");
            String color3 = request.getParameter("color3");
            String nombre4 = request.getParameter("nombre4");
            String color4 = request.getParameter("color4");
            String nombre5 = request.getParameter("nombre5");
            String color5 = request.getParameter("color5");
            String nombre6 = request.getParameter("nombre6");
            String color6 = request.getParameter("color6");
            String nombre7 = request.getParameter("nombre7");
            String color7 = request.getParameter("color7");
            Jugador jugador1 = new Jugador (1, nombre1, color1);
            Jugador jugador2 = new Jugador (2, nombre2, color2);
            tablero.setJugadores(jugador1);
            tablero.setJugadores(jugador2);
            if (nombre3 != null && !nombre3.isEmpty()) {
                Jugador jugador3 = new Jugador (3, nombre3, color3);
                tablero.setJugadores(jugador3);
            }
            if (nombre4 != null && !nombre4.isEmpty()) {
                Jugador jugador4 = new Jugador (4, nombre4, color4);
                tablero.setJugadores(jugador4);
            }
            if (nombre5 != null && !nombre5.isEmpty()) {
                Jugador jugador5 = new Jugador (5, nombre5, color5);
                tablero.setJugadores(jugador5);
            }
            if (nombre6 != null && !nombre6.isEmpty()) {
                Jugador jugador6 = new Jugador (6, nombre6, color6);
                tablero.setJugadores(jugador6);
            }
            if (nombre7 != null && !nombre7.isEmpty()) {
                Jugador jugador7 = new Jugador (7, nombre7, color7);
                tablero.setJugadores(jugador7);
            }                                  
            session.setAttribute("tablero", tablero);            
        }
        if (accion.compareToIgnoreCase("cargar") == 0) {
            //TO DO
        }        
        if (accion.compareToIgnoreCase("inicializar") == 0) {
            String html = get_tablero(request);
            out.println(html);
        }

        if (accion.compareToIgnoreCase("inicializar_jugadores") == 0) {
            String html = get_jugadores(request);
            out.println(html);
        }                      
        if (accion.compareToIgnoreCase("tirar_dado") == 0) {
            String html = tirar_dado(request);
            out.println(html);
        }                      
       if (accion.compareToIgnoreCase("comprar") == 0) {         
            HttpSession session = request.getSession();
            String turno_actual = request.getParameter("turno_actual");
            String casilla_actual = request.getParameter("casilla_actual");
            comprar(Integer.parseInt(turno_actual), Integer.parseInt(casilla_actual), request);
        }                        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void inicializar(HttpServletRequest request, String carpeta) {
        tablero = new Tablero(carpeta);
        HttpSession session = request.getSession();
        session.setAttribute("tablero", tablero);
    }

    public String get_tablero(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Tablero tablero = (Tablero) session.getAttribute("tablero");
        ArrayList casillas = tablero.getCasillas();
        
        String ret = "<table border='1px black' style='border-collapse:collapse;'>";                    
        ret += "<tr>";
        for (int i = 20; i <= 30; i++) {
            Casilla casilla = (Casilla)casillas.get(i);
            String str_casilla = dibujar_casilla(casilla);
            ret += "<td>" + str_casilla + "</td>";
        }
        ret += "</tr><tr>";
        Casilla casilla = (Casilla)casillas.get(19);
        String str_casilla = dibujar_casilla(casilla);
        ret += "<td>" + str_casilla + "</td>";
        ret += "<td colspan='9' rowspan='9' style='border-bottom:0px;border-top:0px;vertical-align=middle' align='center'><img src='img/monopoly.png'/></td>";
        casilla = (Casilla)casillas.get(31);
        str_casilla = dibujar_casilla(casilla);
        ret += "<td>" + str_casilla + "</td></tr>";
        
        int j = 0;
        for (int i = 18; i >= 11; i--) {
           
           casilla = (Casilla)casillas.get(i);
           str_casilla = dibujar_casilla(casilla);
           ret += "<tr><td>" + str_casilla + "</td>"; 

           int k = i + (12 + (j*2));
           casilla = (Casilla)casillas.get(i);
           str_casilla = dibujar_casilla(casilla);
           ret += "<td>" + str_casilla + "</td></tr>"; 

           j++;
        }
        ret += "<tr>";
        for (int i = 10; i >= 0; i--) {
            casilla = (Casilla)casillas.get(i);
            str_casilla = dibujar_casilla(casilla);
            ret += "<td>" + str_casilla + "</td>";
        }
        ret += "</tr></table>";
        session.setAttribute("tablero", tablero);
        return ret;
    }

    private String dibujar_casilla(Casilla casilla) {
        int precio = casilla.getPrecio();
        String precio_casilla = precio + "";
        if (precio == 0) {
            precio_casilla = "";
        }
        String ret = "<table width='100%' height='100%' id='" + casilla.getId() + "'><tr><td colspan='3' style='border-bottom:1px solid; background-color:#" + casilla.getColor() + "'><br></td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>" + casilla.getNombre() + "<br>" + precio_casilla + "</td></tr></table>";
        return ret;
    }
  
    public String get_jugadores(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Tablero tablero = (Tablero) session.getAttribute("tablero");
        ArrayList jugadores = tablero.getJugadores();
        int numero_jugadores = jugadores.size();
        String ret = "<table border='1px black' style='border-collapse:collapse; padding-left: 5px; padding-right: 5px;'>";                            
        for (int i = 0; i < jugadores.size(); i++) {
            ret += "<tr>";
            int numero_jugador = i + 1;            
            Jugador jugador = (Jugador)jugadores.get(i);
            String str_jugador = jugador.getNombre();            
            ret += "<td>&nbsp;&nbsp;Jugador " + numero_jugador + "&nbsp;&nbsp;" + str_jugador + "&nbsp;&nbsp;</td>";
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
        ret += "</table><br><br><br><br>";
        ret += "<table border='1px black' style='border-collapse:collapse; padding-left: 5px; padding-right: 5px;'>";                            
        for (int i = 0; i < jugadores.size(); i++) {
            int numero_jugador = i + 1;
            ret += "<tr>";
            Jugador jugador = (Jugador)jugadores.get(i);
            String str_jugador = jugador.getNombre();
            int str_casilla_jugador = jugador.getEsta_en_casilla();            
            ret += "<td>&nbsp;&nbsp;Jugador " + numero_jugador + " está en casilla " + str_casilla_jugador + "&nbsp;&nbsp;</td>";
            ret += "</tr>";
        }
        ret += "</table><br><br>";
        ret += "<span>";
        int turno = tablero.getTurno() + 1;
        ret += "El turno lo tiene el jugador " + turno;
        ret += "</span><br><br>";
        ret += "<input type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";
        
        session.setAttribute("tablero", tablero);
        return ret;
    }
    
    public String tirar_dado(HttpServletRequest request) {
        System.out.println ("Tirar DAdo");
        int dado1 = Dado.tirar_dado();
        int dado2 = Dado.tirar_dado();
        HttpSession session = request.getSession();
        Tablero tablero = (Tablero) session.getAttribute("tablero");
        int turno_actual = tablero.getTurno() + 1;
        int turno_actual_pos = tablero.getTurno();
        tablero.setTurno();
        int casilla_antes_de_tirar = ((Jugador)tablero.getJugadores().get(turno_actual_pos)).getEsta_en_casilla();
        ((Jugador)tablero.getJugadores().get(turno_actual_pos)).setEsta_en_casilla(dado1 + dado2);
        int casilla_despues_de_tirar = ((Jugador)tablero.getJugadores().get(turno_actual_pos)).getEsta_en_casilla();
        ArrayList jugadores = tablero.getJugadores();
        int numero_jugadores = jugadores.size();
        String ret = "<table border='1px black' style='border-collapse:collapse; padding-left: 5px; padding-right: 5px;'>";                            
        for (int i = 0; i < jugadores.size(); i++) {
            ret += "<tr>";
            int numero_jugador = i + 1;            
            Jugador jugador = (Jugador)jugadores.get(i);
            String str_jugador = jugador.getNombre();            
            ret += "<td>&nbsp;&nbsp;Jugador " + numero_jugador + "&nbsp;&nbsp;" + str_jugador + "&nbsp;&nbsp;</td>";
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
        ret += "</table><br><br><br><br>";
        ret += "<table border='1px black' style='border-collapse:collapse; padding-left: 5px; padding-right: 5px;'>";                            
        for (int i = 0; i < jugadores.size(); i++) {
            int numero_jugador = i + 1;
            ret += "<tr>";
            Jugador jugador = (Jugador)jugadores.get(i);
            String str_jugador = jugador.getNombre();
            int str_casilla_jugador = jugador.getEsta_en_casilla();            
            ret += "<td>&nbsp;&nbsp;Jugador " + numero_jugador + " está en casilla " + str_casilla_jugador + "&nbsp;&nbsp;</td>";
            ret += "</tr>";
        }
        ret += "</table><br><br>";

        ret += "<span>";
        
        ret += "El jugador " + turno_actual + " ha sacado:<br><b>Dado1: " + dado1 + "</b><br><b>Dado2: " + dado2 + "</b>";
        int total = dado1 + dado2;
        ret += "<br>En total avanza " + total + " casillas";
        ret += "<br>Desde la casilla " + casilla_antes_de_tirar + " a la casilla " + casilla_despues_de_tirar;
        ret += "</span><br><br>";        
        
        
        ret += tablero.analizar_jugada(turno_actual_pos, casilla_despues_de_tirar);
        
        
        ret += "<br><br><span id='id_turno_jugador' style='display:none;'>";
        int turno = tablero.getTurno() + 1;
        ret += "El turno lo tiene el jugador " + turno;
        ret += "</span><br><br>";
        ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px; display:none;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";
        
        session.setAttribute("tablero", tablero);
        return ret;
    }  
    
    private String comprar(int turno_actual, int casilla_actual, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Tablero tablero = (Tablero) session.getAttribute("tablero");   
        tablero.comprar(turno_actual, casilla_actual);
        session.setAttribute("tablero", tablero);
        return "";
    }
}
