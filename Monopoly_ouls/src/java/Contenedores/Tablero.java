/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenedores;

import Iniciadores.Parsear_tablero;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Tablero implements Serializable {
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

    public void setTurnoAtras() {
        this.turno = (this.jugadores.size() + this.turno - 1) % this.jugadores.size();
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
    
    public String analizar_jugada(int turno_actual, int casilla_actual, int salio_doble) {        
        String ret = "";
        int numero_jugadores = jugadores.size();
        Jugador jugador = (Jugador)jugadores.get(turno_actual);
                                
        Casilla datos_casilla = ((Casilla)casillas.get(casilla_actual));
        int casilla_pertenece_a = datos_casilla.getPertenece_a_jugador();
        String nombre_casilla = datos_casilla.getNombre();
        int tipo = datos_casilla.getTipo();
        int grupo = datos_casilla.getGrupo();
        int total_grupo = datos_casilla.getTotal_grupo();
        ArrayList casillas_grupo = grupo_casilla(grupo);
        
        System.out.println ("Analizar_Jugada-Tipo: " + tipo + " Grupo " + grupo);
        System.out.println ("Analizar_Jugada-turno_actual: " + turno_actual + " casilla_actual " + casilla_actual);
        
        if (casilla_pertenece_a == -1) { //No pertenece a nadie, se puede comprar
            //tipo 0 es salida, 1 calle, 2 ferrocarril, 3 empresa, 4 suerte/caja de comunidad, 5 ir a la carcel, 6 carcel, 7 impuesto, 8 parking,  hay 40 casillas
            if (tipo == 0) {//Salida, no se hace nada, solo se le suma 
                jugador.setDineroTotal(jugador.getDineroTotal() + 200); //200 mas
                ret += "<span>";                
                ret += "Dispone de " + jugador.getDineroTotal();
                ret += "</span><br><br>";
                ret += "<br><br><span id='id_turno_jugador'>";
                int turno = getTurno() + 1;
                ret += "El turno lo tiene el jugador " + turno;
                ret += "</span><br><br>";
                ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                    
                
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
                ret += "Edificar casa:" + precio_casa + " y hotel:" + precio_hotel;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla:" + alquiler;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 1 casa:" + alquiler_1;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 2 casa:" + alquiler_2;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 3 casa:" + alquiler_3;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 4 casa:" + alquiler_4;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla hotel:" + alquiler_hotel;
                ret += "</span><br>";

                int numero_casillas_grupo = datos_casilla.getTotal_grupo();
                ret += "<span>";
                ret += "El grupo es:";  
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
                            ret += "La casilla " + nombre_casilla_grupo + " y está libre";                                    
                        }
                        else {
                            ret += "La casilla " + nombre_casilla_grupo + " que pertenece a jugador " + (pertenece_a_jugador_de_grupo + 1) + "";
                        }
                        ret += "</span><br>";                    
                    }
                }                                           
                int dinero_disponible = jugador.getDineroTotal();                                
                if(dinero_disponible > precio) {                
                    ret += "<span>";                
                    ret += "Desea comprar? Dispone de " + dinero_disponible;
                    ret += "</span><br><br>";
                    ret += "<input type='button' value='Si' id='id_si' style='width: 100px;' onclick='comprar(" + turno_actual + "," + casilla_actual + ")'>";                
                    ret += "&nbsp;&nbsp;&nbsp;<input type='button' value='No' id='id_no' style='width: 100px;' onclick='pasar()'>";                
                    ret += "<br><br><span id='id_turno_jugador' style='display:none;'>";
                    int turno = getTurno() + 1;
                    ret += "El turno lo tiene el jugador " + turno;
                    ret += "</span><br><br>";
                    ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px; display:none;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";
                }
                else {
                    ret += "<span>";                
                    ret += "Dispone de " + dinero_disponible + ", así que no puede comprar";
                    ret += "</span><br><br>";
                    ret += "<br><br><span id='id_turno_jugador'>";
                    int turno = getTurno() + 1;
                    ret += "El turno lo tiene el jugador " + turno;
                    ret += "</span><br><br>";
                    ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                    
                }
            } 
            if (tipo == 2) {//Ferrocarril, comprar pagar
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
                ret += "Edificar casa:" + precio_casa + " y hotel:" + precio_hotel;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla:" + alquiler;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 1 casa:" + alquiler_1;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 2 casa:" + alquiler_2;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 3 casa:" + alquiler_3;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 4 casa:" + alquiler_4;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla hotel:" + alquiler_hotel;
                ret += "</span><br>";

                int numero_casillas_grupo = datos_casilla.getTotal_grupo();
                ret += "<span>";
                ret += "El grupo es:";  
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
                            ret += "La casilla " + nombre_casilla_grupo + " y está libre";                                    
                        }
                        else {
                            ret += "La casilla " + nombre_casilla_grupo + " que pertenece a jugador " + (pertenece_a_jugador_de_grupo + 1) + "";
                        }
                        ret += "</span><br>";                    
                    }
                }                                           
                int dinero_disponible = jugador.getDineroTotal();                
                if(dinero_disponible > precio) {                
                    ret += "<span>";                
                    ret += "Desea comprar? Dispone de " + dinero_disponible;
                    ret += "</span><br><br>";
                    ret += "<input type='button' value='Si' id='id_si' style='width: 100px;' onclick='comprar(" + turno_actual + "," + casilla_actual + ")'>";                
                    ret += "&nbsp;&nbsp;&nbsp;<input type='button' value='No' id='id_no' style='width: 100px;' onclick='pasar()'>";                
                    ret += "<br><br><span id='id_turno_jugador' style='display:none;'>";
                    int turno = getTurno() + 1;
                    ret += "El turno lo tiene el jugador " + turno;
                    ret += "</span><br><br>";
                    ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px; display:none;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";
                }
                else {
                    ret += "<span>";                
                    ret += "Dispone de " + dinero_disponible + ", así que no puede comprar";
                    ret += "</span><br><br>";
                    ret += "<br><br><span id='id_turno_jugador'>";
                    int turno = getTurno() + 1;
                    ret += "El turno lo tiene el jugador " + turno;
                    ret += "</span><br><br>";
                    ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                    
                }
                
            } 
            if (tipo == 3) {//Empresa, comprar pagar
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
                ret += "Edificar casa:" + precio_casa + " y hotel:" + precio_hotel;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla:" + alquiler;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 1 casa:" + alquiler_1;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 2 casa:" + alquiler_2;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 3 casa:" + alquiler_3;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla 4 casa:" + alquiler_4;
                ret += "</span><br>";
                ret += "<span>";                
                ret += "Ingresos casilla hotel:" + alquiler_hotel;
                ret += "</span><br>";

                int numero_casillas_grupo = datos_casilla.getTotal_grupo();
                ret += "<span>";
                ret += "El grupo es:";  
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
                            ret += "La casilla " + nombre_casilla_grupo + " y está libre";                                    
                        }
                        else {
                            ret += "La casilla " + nombre_casilla_grupo + " que pertenece a jugador " + (pertenece_a_jugador_de_grupo + 1) + "";
                        }
                        ret += "</span><br>";                    
                    }
                }                                           
                int dinero_disponible = jugador.getDineroTotal();                
                if(dinero_disponible > precio) {                
                    ret += "<span>";                
                    ret += "Desea comprar? Dispone de " + dinero_disponible;
                    ret += "</span><br><br>";
                    ret += "<input type='button' value='Si' id='id_si' style='width: 100px;' onclick='comprar(" + turno_actual + "," + casilla_actual + ")'>";                
                    ret += "&nbsp;&nbsp;&nbsp;<input type='button' value='No' id='id_no' style='width: 100px;' onclick='pasar()'>";                
                    ret += "<br><br><span id='id_turno_jugador' style='display:none;'>";
                    int turno = getTurno() + 1;
                    ret += "El turno lo tiene el jugador " + turno;
                    ret += "</span><br><br>";
                    ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px; display:none;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";
                }
                else {
                    ret += "<span>";                
                    ret += "Dispone de " + dinero_disponible + ", así que no puede comprar";
                    ret += "</span><br><br>";
                    ret += "<br><br><span id='id_turno_jugador'>";
                    int turno = getTurno() + 1;
                    ret += "El turno lo tiene el jugador " + turno;
                    ret += "</span><br><br>";
                    ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                    
                }                
            } 
            if (tipo == 4) {//Suerte/caja comunidad
                ret += "<span>";                
                ret += "Ha caido en Tarjeta";
                ret += "</span><br><br>";
                
                
                ret += "<br><br><span id='id_turno_jugador'>";
                int turno = getTurno() + 1;
                ret += "El turno lo tiene el jugador " + turno;
                ret += "</span><br><br>";
                ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                                
                
            } 
            if (tipo == 5) {//ir a la carcel
                ret += "<span>";                
                ret += "A la carcel!!!!";
                ret += "</span><br><br>";   
                jugador.setVeces_salio_doble(0);
                jugador.setEsta_en_la_carcel(1);
                jugador.setEsta_en_casilla(20); //casilla de la carcel, se le pasa el offset                
                ret += "<br><br><span id='id_turno_jugador'>";
                int turno = getTurno() + 1;
                ret += "El turno lo tiene el jugador " + turno;
                ret += "</span><br><br>";
                ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                
            } 
            if (tipo == 6) {//Carcel
                ret += "<span>";                
                ret += "Ha caido en la carcel!!!!";
                ret += "</span><br><br>";                
                jugador.setEsta_en_la_carcel(1);
                jugador.setVeces_salio_doble(0);
                ret += "<br><br><span id='id_turno_jugador'>";
                int turno = getTurno() + 1;
                ret += "El turno lo tiene el jugador " + turno;
                ret += "</span><br><br>";
                ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                                
            } 
            if (tipo == 7) {//impuesto
                jugador.setDineroTotal(jugador.getDineroTotal() - 200); //200 menos
                ret += "<span>";                
                ret += "Hay que pagar impuestos";
                ret += "</span><br><br>";
                ret += "<span>";                
                ret += "Dispone de " + jugador.getDineroTotal();
                ret += "</span><br><br>";                                
                ret += "<br><br><span id='id_turno_jugador'>";
                int turno = getTurno() + 1;
                ret += "El turno lo tiene el jugador " + turno;
                ret += "</span><br><br>";
                ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                                
            } 
            if (tipo == 8) {//Parking
                ret += "<span>";                
                ret += "Ha caido en Parking--No pasa nada!!!";
                ret += "</span><br><br>";
                ret += "<span>";                
                ret += "Dispone de " + jugador.getDineroTotal();
                ret += "</span><br><br>";                                                
                ret += "<br><br><span id='id_turno_jugador'>";
                int turno = getTurno() + 1;
                ret += "El turno lo tiene el jugador " + turno;
                ret += "</span><br><br>";
                ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                                                
            } 
            
            
                /* ret += "El jugador " + turno_actual + " ha sacado:<br><b>Dado1: " + dado1 + "</b><br><b>Dado2: " + dado2 + "</b>";
                
                ret += "<br>En total avanza " + total + " casillas";
                ret += "<br>Desde la casilla " + casilla_antes_de_tirar + " a la casilla " + casilla_despues_de_tirar;
                ret += "</span><br><br>";   */
        }
        else { //pertenece alguien, a pagar segun lo que tenga el dueño
            if (casilla_pertenece_a == turno_actual) {//ediifcar o no hacer nada
                if (tipo == 1) {
                    int num_casas = datos_casilla.getNumero_casas();
                    int num_hoteles = datos_casilla.getNumero_casas();
                    int precio_casa = datos_casilla.getPrecio_casa();
                    int precio_hotel = datos_casilla.getPrecio_hotel();
                    if (num_casas < 4) {
                        ret += "<span>";                
                        ret += "Se puede edificar casas por:" + precio_casa;
                        ret += "</span><br>";                                
                        ret += "<span>";                
                        ret += "Casas edficadas:" + num_casas;
                        ret += "</span><br>"; 
                        ret += "Número casas a edificar:<select id='id_casas'>"; 
                        ret += "<option value=" + 0 +">" + 0 + "</option>"; 
                        for (int i = 1; i <= 4 - num_casas; i++) {
                            ret += "<option value=" + i +">" + i + "</option>"; 
                        }
                        ret += "</select><br><br>"; 
                    }
                    if (num_hoteles == 0) {
                        ret += "<span>";                
                        ret += "Se puede edificar hotel por:" + precio_casa;
                        ret += "</span><br>";                                
                        ret += "Número hoteles a edificar:<select id='id_hoteles'>"; 
                        ret += "<option value=" + 0 +">" + 0 + "</option>"; 
                        ret += "<option value=" + 1 +">" + 1 + "</option>";                         
                        ret += "</select><br><br>";
                    }
                    if (num_casas >= 4 && num_hoteles > 0) {
                        ret += "<span>";                
                        ret += "No se puede Edificar más";
                        ret += "</span><br><br>";                                
                        ret += "<br><br><span id='id_turno_jugador'>";
                        ret += "<br><br><span id='id_turno_jugador'>";
                        int turno = getTurno() + 1;
                        ret += "El turno lo tiene el jugador " + turno;
                        ret += "</span><br><br>";
                        ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                                                            
                        return ret;
                    }
                    ret += "<input type='button' value='Continuar' id='id_const' style='width: 100px;' onclick='construir(" + turno_actual + "," + casilla_actual + ")'>";                
                    ret += "<br><br><span id='id_turno_jugador' style='display:none;'>";
                    int turno = getTurno() + 1;
                    ret += "El turno lo tiene el jugador " + turno;
                    ret += "</span><br><br>";
                    ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px; display:none;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";
                   
                }
                else {
                    ret += "<span>";                
                    ret += "Esta casilla le pertenece y no se puede hacer nada";
                    ret += "</span><br><br>";                                
                    ret += "<br><br><span id='id_turno_jugador'>";
                    int turno = getTurno() + 1;
                    ret += "El turno lo tiene el jugador " + turno;
                    ret += "</span><br><br>";
                    ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                    
                }
                
            }
            else {// Pagar
                ret += "<span>";                
                ret += "A pagar!!!";
                ret += "</span><br><br>";                                
                int turno = getTurno() + 1;
                
                ret += "<span>";                
                ret += "La casilla pertenece al jugador:" + (casilla_pertenece_a + 1);
                ret += "</span><br><br>";                
                int a_pagar = 0;
                if (tipo == 1) {//Calle, Pagar
                    int num_casas = datos_casilla.getNumero_casas();
                    int num_hoteles = datos_casilla.getNumero_casas();
                    
                    if (num_casas == 0) {
                        ret += "<span>";                
                        ret += "El jug. " + (casilla_pertenece_a + 1) + " tiene la propiedad";
                        ret += "</span><br>";                         
                        a_pagar = datos_casilla.getAlquiler();
                        //casilla_pertenece_a == turno_actual
                        int numero_casillas_grupo = datos_casilla.getTotal_grupo();
                        int encontradas = 0;
                        for (int i = 0; i < casillas_grupo.size(); i++) {                        
                            int del_grupo = (Integer)casillas_grupo.get(i);
                            Casilla datos_casilla_grupo = ((Casilla)casillas.get(del_grupo));
                            int pertenece_a_jugador_de_grupo = datos_casilla_grupo.getPertenece_a_jugador();
                            if (casilla_pertenece_a == pertenece_a_jugador_de_grupo) {
                                encontradas++;
                            }                            
                        }
                        if (encontradas == numero_casillas_grupo) {
                            a_pagar = a_pagar * 2;
                            ret += "<span>";                
                            ret += "Todo el grupo pertenece al jugador:" + (casilla_pertenece_a + 1);
                            ret += "</span><br>";                            
                        }
                    }
                    if (num_casas == 1) {
                        a_pagar = datos_casilla.getAlquiler_1();
                        ret += "<span>";                
                        ret += "El jug. " + (casilla_pertenece_a + 1) + " tiene 1 casa";
                        ret += "</span><br>";                                                 
                    }
                    if (num_casas == 2) {
                        a_pagar = datos_casilla.getAlquiler_2();
                        ret += "<span>";                
                        ret += "El jug. " + (casilla_pertenece_a + 1) + " tiene 2 casas";
                        ret += "</span><br>";                                                                         
                    }
                    if (num_casas == 3) {
                        a_pagar = datos_casilla.getAlquiler_3();
                        ret += "<span>";                
                        ret += "El jug. " + (casilla_pertenece_a + 1) + " tiene 3 casas";
                        ret += "</span><br>";                                                                         
                    }
                    if (num_casas == 4) {
                        if (num_hoteles == 1) {
                            a_pagar = datos_casilla.getAlquiler_hotel();
                            ret += "<span>";                
                            ret += "El jug. " + (casilla_pertenece_a + 1) + " tiene 4 casas y hotel";
                            ret += "</span><br>";                                                                             
                        }
                        else {
                            a_pagar = datos_casilla.getAlquiler_4();
                            ret += "<span>";                
                            ret += "El jug. " + (casilla_pertenece_a + 1) + " tiene 4 casas";
                            ret += "</span><br>";                                                                                                         
                        }
                    }
                } 
                if (tipo == 2) {//Ferrocarril, pagar
                    int encontradas = 0;
                    a_pagar = datos_casilla.getAlquiler();
                    for (int i = 0; i < casillas_grupo.size(); i++) {                        
                        int del_grupo = (Integer)casillas_grupo.get(i);
                        Casilla datos_casilla_grupo = ((Casilla)casillas.get(del_grupo));
                        int pertenece_a_jugador_de_grupo = datos_casilla_grupo.getPertenece_a_jugador();
                        if (casilla_pertenece_a == pertenece_a_jugador_de_grupo) {
                            encontradas++;
                        }                            
                    }
                    if (encontradas == 2) {
                        a_pagar = datos_casilla.getAlquiler_2();
                        ret += "<span>";                
                        ret += "El jug. " + (casilla_pertenece_a + 1) + " tiene 2 estaciones";
                        ret += "</span><br>";                            
                    }
                    if (encontradas == 3) {
                        a_pagar = datos_casilla.getAlquiler_3();
                        ret += "<span>";                
                        ret += "El jug. " + (casilla_pertenece_a + 1) + " tiene 2 estaciones";
                        ret += "</span><br>";                            
                    }
                    if (encontradas == 4) {
                        a_pagar = datos_casilla.getAlquiler_4();
                        ret += "<span>";                
                        ret += "El jug. " + (casilla_pertenece_a + 1) + " tiene 2 estaciones";
                        ret += "</span><br>";                            
                    }                    
                } 
                if (tipo == 3) {//Empresa, pagar
                    int dado1 = Dado.tirar_dado();
                    int dado2 = Dado.tirar_dado();                    
                    int encontradas = 0;
                    a_pagar = datos_casilla.getAlquiler();
                    ret += "<span>";                
                    ret += "Dados= " + dado1 + ", " + dado2 + " = " + (dado1 + dado2) + " en total";
                    ret += "</span><br>";                            
                    
                    a_pagar = (dado1 + dado2) * 4;
                    
                    for (int i = 0; i < casillas_grupo.size(); i++) {                        
                        int del_grupo = (Integer)casillas_grupo.get(i);
                        Casilla datos_casilla_grupo = ((Casilla)casillas.get(del_grupo));
                        int pertenece_a_jugador_de_grupo = datos_casilla_grupo.getPertenece_a_jugador();
                        if (casilla_pertenece_a == pertenece_a_jugador_de_grupo) {
                            encontradas++;
                        }                            
                    }
                    if (encontradas == 2) {
                        a_pagar = (dado1 + dado2) * 10;
                        ret += "<span>";                
                        ret += "El jug. " + (casilla_pertenece_a + 1) + " tiene 2 Empresas";
                        ret += "</span><br>";                            
                    }
                
                }
                ret += "<span>";                
                ret += "Jug. " + (turno_actual + 1) + " paga " + a_pagar + " a jug. " +  (casilla_pertenece_a + 1);
                ret += "</span><br>";
                
                jugador.setDineroTotal(jugador.getDineroTotal() - a_pagar);
                Jugador jugador2 = (Jugador)jugadores.get(casilla_pertenece_a);
                jugador2.setDineroTotal(jugador2.getDineroTotal() + a_pagar);
                ret += "<span>";                
                ret += "El jug. " + (jugador.getId()) + "dispone de " + jugador.getDineroTotal();
                ret += "</span><br>";
                ret += "<span>";                
                ret += "El jug. " + (jugador2.getId()) + "dispone de " + jugador2.getDineroTotal();
                ret += "</span><br>";                                                
                ret += "<br><br><span id='id_turno_jugador'>";
                ret += "El turno lo tiene el jugador " + turno;
                ret += "</span><br><br>";
                ret += "<input id='id_boton_turno_jugador' type='button' value='Tirar Dado' style='width: 100px;' onclick='tirar_dado(" + turno + "," + numero_jugadores + ")'>";                                                            
            }
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
