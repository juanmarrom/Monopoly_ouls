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
    
    
}
