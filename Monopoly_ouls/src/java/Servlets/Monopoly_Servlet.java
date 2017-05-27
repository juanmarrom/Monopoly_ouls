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
        String ret = "";
        ret += "<table style= cellspacing='1' bgcolor='#0099cc'>";
        ret += "<tr>";
        ret += "<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>Hay " + casillas.size() + " Casillas</td>";
        ret += "</tr>";
        ret += "</table>";   
        return ret;
        /*out.println("<table border='1px black' style='border-collapse:collapse;'>");
        out.println("<tr>");
        out.println("<td colspan='15'> TABLERO MONOPOLY</td>");
        out.println("</tr>");
        ArrayList casillas = tablero.getCasillas();
        for(int i=0; i < casillas.size(); i++) {            
            System.out.println(casillas.get(i));
            Casilla casilla = (Casilla)casillas.get(i);
            if (i == 0) {
                out.println("<tr>");
            }
            if (i >= 0 && i <= 9) {
                String fila = "<td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>" + casilla.getNombre() + "<br>" + casilla.getPrecio() + "</td></tr></table></td>";
            }
            if (i == 9) {
                out.println("</tr>");
                out.println("<tr>");
            }
           if (i == 10) {
                out.println("<td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>\n" +
"                        <td colspan='8' rowspan='8' style='border-bottom:0px;border-top:0px;vertical-align=middle' align='center'>\n" +
"                                <img src='monopoly.png'/>\n" +
"                        </td>\n" +
"");
                
            }            
        
        }
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>
                        <td colspan='8' rowspan='8' style='border-bottom:0px;border-top:0px;vertical-align=middle' align='center'>
                                <img src='monopoly.png'/>
                        </td>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>			
                </tr>

                <tr>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>

                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>			
                </tr>
                <tr>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>

                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>			
                </tr>
                <tr>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>

                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>			
                </tr>
                <tr>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>

                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>			
                </tr>
                <tr>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>

                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>			
                </tr>
                <tr>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>

                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>			
                </tr>
                <tr>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>

                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>			
                </tr>
                <tr>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>
                        <td><table><tr><td colspan='3' style='border-bottom:1px solid'>Color CASILLA</td></tr><tr><td colspan='3' rowspan='10' align='center' style='vertical-align:middle'>NombreCasilla<br>Precio</td></tr></table></td>					
                </tr>						
        </table>*/

    }

  

    
    
}
