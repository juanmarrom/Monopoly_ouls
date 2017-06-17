/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenedores;

import Iniciadores.Parsear_tablero;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Tablero {
    private ArrayList casillas;
    private ArrayList jugadores;
    private int turno;
    
    public Tablero(String carpeta) {
        Parsear_tablero parser = new Parsear_tablero();
        casillas = parser.parsear_xml_casillas(carpeta);
        jugadores = new ArrayList();
        System.out.println("Tablero: C " + casillas.size());
        System.out.println("Tablero: J " + jugadores.size());
        this.turno = 0;
    }

    /**
     * @return the casillas
     */
    public ArrayList getCasillas() {
        return casillas;
    }

    /**
     * @return the jugadores
     */
    public ArrayList getJugadores() {
        return jugadores;
    }

    /**
     * @param jugadores the jugadores to set
     */
    public void setJugadores(Jugador jugador) {
        this.jugadores.add(jugador);
    }
    
    public int getTurno() {
        return turno;
    }

    /**
     * @param jugadores the jugadores to set
     */
    public void setTurno() {
        this.turno = (this.turno + 1) % this.jugadores.size();
    }  
    
    private ArrayList grupo_casilla(int grupo) {
        ArrayList ret = new ArrayList();
        for (int i = 0; i < casillas.size(); i++) {                        
            Casilla casilla = (Casilla)casillas.get(i);
            if (casilla.getGrupo() == grupo) {
                ret.add(i);
            }            
        }
        return ret;
    }
    
    public String analizar_jugada(int turno_actual, int casilla_actual) {
        System.out.println ("Analizar_Jugada");
        String ret = "";
        int numero_jugadores = jugadores.size();
        Jugador jugador = (Jugador)jugadores.get(turno_actual);
        Casilla datos_casilla = ((Casilla)casillas.get(casilla_actual));
        int casilla_pertenece_a = datos_casilla.getPertenece_a_jugador();
        if (casilla_pertenece_a == -1) { //No pertenece a nadie, se puede comprar
            String nombre_casilla = datos_casilla.getNombre();
            int tipo = datos_casilla.getTipo();
            int grupo = datos_casilla.getGrupo();
            int total_grupo = datos_casilla.getTotal_grupo();
            ArrayList casillas_grupo = grupo_casilla(grupo);
            //tipo 0 es salida, 1 calle, 2 ferrocarril, 3 empresa, 4 suerte/caja de comunidad, 5 ir a la carcel, 6 carcel, 7 impuesto, 8 parking,  hay 40 casillas
            if (tipo == 0) {//Salida, no se hace nada, solo se le suma 
                jugador.setDineroTotal(jugador.getDineroTotal() + 200); //200 mas
            } 
            if (tipo == 1) {//Calle, comprar o edificar
                int precio = datos_casilla.getPrecio();
                int precio_casa = datos_casilla.getPrecio_casa();
                int precio_hotel = datos_casilla.getPrecio_hotel();
                
                int alquiler = datos_casilla.getAlquiler();
                int alquiler_1 = datos_casilla.getAlquiler_1();
                int alquiler_2 = datos_casilla.getAlquiler_2();
                int alquiler_3 = datos_casilla.getAlquiler_3();
                int alquiler_4 = datos_casilla.getAlquiler_4();
                int alquiler_hotel = datos_casilla.getAlquiler_hotel();

                ret += "<span>";                
                ret += "La casilla " + nombre_casilla + " se puede comprar por " + precio;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "El precio por edificar casa es de " + precio_casa + " y por hotel de " + precio_hotel;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Los ingresos serian de " + alquiler + ", " + alquiler_1 + ", " + alquiler_2 + ", " + alquiler_3 + ", " + alquiler_4 + ", " + alquiler_hotel + " según el número de edificaciones ";
                ret += "</span><br>";
                
                                
                int numero_casillas_grupo = datos_casilla.getTotal_grupo();
                ret += "<span>";
                ret += "El total del grupo son:";  
                ret += "</span><br>";
                for (int i = 0; i < casillas_grupo.size(); i++) {                        
                    int del_grupo = (Integer)casillas_grupo.get(i);
                    if (casilla_actual != del_grupo) {
                        Casilla datos_casilla_grupo = ((Casilla)casillas.get(del_grupo));
                        String nombre_casilla_grupo = datos_casilla_grupo.getNombre();
                        int pertenece_a_jugador_de_grupo = datos_casilla_grupo.getPertenece_a_jugador();
                        int precio_grupo = datos_casilla_grupo.getPrecio();
                        ret += "<span>";                
                        if (pertenece_a_jugador_de_grupo == -1) {
                            ret += "La casilla " + nombre_casilla_grupo + " se puede comprar por " + precio_grupo + " y está libre";                                    
                        }
                        else {
                            ret += "La casilla " + nombre_casilla_grupo + " que pertenece a jugador " + (pertenece_a_jugador_de_grupo + 1) + "";
                        }
                        ret += "</span><br>";                    
                    }
                }                                           
                int dinero_disponible = jugador.getDineroTotal();
                
                ret += "<span>";                
                ret += "Desea comprar?Dispone de " + dinero_disponible;
                ret += "</span><br><br>";
                ret += "<input type='button' value='Si' style='width: 100px;' onclick='comprar(" + turno_actual + "," + casilla_actual + ")'>";                
                ret += "&nbsp;&nbsp;&nbsp;<input type='button' value='No' style='width: 100px;' onclick='pasar()'>";
                
                ret += "<br><br><span id='id_turno_jugador' style='display:none;'>";
                int turno = getTurno() + 1;
                ret += "El turno lo tiene el jugador " + turno;
                ret += "</span><br><br>";
                ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px; display:none;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                
            } 
            if (tipo == 2) {//Ferrocarril, comprar pagar
                
            } 
            if (tipo == 3) {//Empresa, comprar pagar
                
            } 
            if (tipo == 4) {//Suerte/caja comunidad
                
            } 
            if (tipo == 5) {//ir a la carcel
                
            } 
            if (tipo == 6) {//Carcel
                ret += "<span>";                
                ret += "Ha caido en la carcel!!!!";
                ret += "</span><br><br>";
                
                
                ret += "<br><br><span id='id_turno_jugador'>";
                int turno = getTurno() + 1;
                ret += "El turno lo tiene el jugador " + turno;
                ret += "</span><br><br>";
                ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                                
            } 
            if (tipo == 7) {//impuesto
                
            } 
            if (tipo == 8) {//Parking
                
            } 
            
            
                /* ret += "El jugador " + turno_actual + " ha sacado:<br><b>Dado1: " + dado1 + "</b><br><b>Dado2: " + dado2 + "</b>";
                
                ret += "<br>En total avanza " + total + " casillas";
                ret += "<br>Desde la casilla " + casilla_antes_de_tirar + " a la casilla " + casilla_despues_de_tirar;
                ret += "</span><br><br>";   */
        }
        else { //pertenece alguien, a pagar segun lo que tenga el dueño
            
        }
        return ret;
    }
    
    public void comprar(int turno_actual, int casilla_actual) {
        System.out.println ("Analizar_Jugada");
        String ret = "";
        Jugador jugador = (Jugador)jugadores.get(turno_actual);
        Casilla datos_casilla = ((Casilla)casillas.get(casilla_actual));
        jugador.setDineroTotal(jugador.getDineroTotal() - datos_casilla.getPrecio());
        datos_casilla.setPertenece_a_jugador(turno_actual);        
    }    
    
}
