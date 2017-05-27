/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Contenedores.Casilla;
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
        String nombre = request.getParameter("nombre");
        
        System.out.println("TEST: '" + nombre + "'");
        if (nombre.compareToIgnoreCase("nueva") == 0) {
            inicializar(request);
        }
        if (nombre.compareToIgnoreCase("cargar") == 0) {
            //TO DO
        }
        System.out.println("TESTC: '" + nombre.compareToIgnoreCase("inicializar") + "'");
        if (nombre.compareToIgnoreCase("inicializar") == 0) {
            System.out.println("TEST5: '");
            String pepe = get_tablero(request);
            System.out.println("TEST2: '" + pepe + "'");
            out.println(pepe);
        }
        
        /*
        String apellido = request.getParameter("apellido");
        String edad = request.getParameter("edad");

                String texto = nombre + " " + apellido + " " + edad;



        out.println("<table style= cellspacing='1' bgcolor='#0099cc'>");
        out.println("<tr>");
        out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'> NOMBRE </td>");			
        out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>APELLIDO</td>");
        out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>EDAD:" + texto + " </td>");
        out.println("</tr>");
        out.println("</table>"); 
        */
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
    
    public void inicializar(HttpServletRequest request) {
        tablero = new Tablero();
        System.out.println("Tablero SEVLET: C " + tablero.getCasillas().size());
        HttpSession session = request.getSession();
        session.setAttribute("tablero", tablero);
    }

    public String get_tablero(HttpServletRequest request) {
        System.out.println("TEST6: '");
        HttpSession session = request.getSession();
        Tablero tablero = (Tablero) session.getAttribute("tablero");
        ArrayList casillas = tablero.getCasillas();
        System.out.println("TEST7: '");
        
        String ret = "<table border='1px black' style='border-collapse:collapse;'><tr><td colspan='15'> TABLERO MONOPOLY</td></tr>";                    
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
        String ret = "<table width='100%' height='100%' id='" + casilla.getId() + "'><tr><td colspan='3' style='border-bottom:1px solid; background-color:#" + casilla.getColor() + "'><br></td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>" + casilla.getNombre() + "<br>" + casilla.getPrecio() + "</td></tr></table>";
        return ret;
    }
  

    
    
}
