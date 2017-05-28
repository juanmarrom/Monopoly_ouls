/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenedores;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Jugador {
    private int id;
    private String nombre;
    private String color;
    private ArrayList casillas;
    private int billetes_de_1;
    private int billetes_de_5;
    private int billetes_de_10;
    private int billetes_de_20;
    private int billetes_de_50;
    private int billetes_de_100;
    private int billetes_de_500;
    private int esta_en_casilla;
    
    
    public Jugador(int id, String nombre, String color) {
        /* Billetes al iniciar
        2 de 500 
        2 de 10 
        4 de 100 
        1 de 5 
        1 de 50 
        5 de 1 
        y 1 de 20
        */
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.billetes_de_1 = 5;
        this.billetes_de_5 = 1;
        this.billetes_de_10 = 2;
        this.billetes_de_20 = 1;
        this.billetes_de_50 = 1;
        this.billetes_de_100 = 4;
        this.billetes_de_500 = 2;
        this.casillas = new ArrayList();
        this.esta_en_casilla = 0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the casillas
     */
    public ArrayList getCasillas() {
        return casillas;
    }

    /**
     * @param casillas the casillas to set
     */
    public void setCasillas(ArrayList casillas) {
        this.casillas = casillas;
    }

    /**
     * @return the billetes_de_1
     */
    public int getBilletes_de_1() {
        return billetes_de_1;
    }

    /**
     * @param billetes_de_1 the billetes_de_1 to set
     */
    public void setBilletes_de_1(int billetes_de_1) {
        this.billetes_de_1 = billetes_de_1;
    }

    /**
     * @return the billetes_de_5
     */
    public int getBilletes_de_5() {
        return billetes_de_5;
    }

    /**
     * @param billetes_de_5 the billetes_de_5 to set
     */
    public void setBilletes_de_5(int billetes_de_5) {
        this.billetes_de_5 = billetes_de_5;
    }

    /**
     * @return the billetes_de_10
     */
    public int getBilletes_de_10() {
        return billetes_de_10;
    }

    /**
     * @param billetes_de_10 the billetes_de_10 to set
     */
    public void setBilletes_de_10(int billetes_de_10) {
        this.billetes_de_10 = billetes_de_10;
    }

    /**
     * @return the billetes_de_20
     */
    public int getBilletes_de_20() {
        return billetes_de_20;
    }

    /**
     * @param billetes_de_20 the billetes_de_20 to set
     */
    public void setBilletes_de_20(int billetes_de_20) {
        this.billetes_de_20 = billetes_de_20;
    }

    /**
     * @return the billetes_de_50
     */
    public int getBilletes_de_50() {
        return billetes_de_50;
    }

    /**
     * @param billetes_de_50 the billetes_de_50 to set
     */
    public void setBilletes_de_50(int billetes_de_50) {
        this.billetes_de_50 = billetes_de_50;
    }

    /**
     * @return the billetes_de_100
     */
    public int getBilletes_de_100() {
        return billetes_de_100;
    }

    /**
     * @param billetes_de_100 the billetes_de_100 to set
     */
    public void setBilletes_de_100(int billetes_de_100) {
        this.billetes_de_100 = billetes_de_100;
    }

    /**
     * @return the billetes_de_500
     */
    public int getBilletes_de_500() {
        return billetes_de_500;
    }

    /**
     * @param billetes_de_500 the billetes_de_500 to set
     */
    public void setBilletes_de_500(int billetes_de_500) {
        this.billetes_de_500 = billetes_de_500;
    }
    
   /**
     * @return the billetes_de_500
     */
    public int getEsta_en_casilla() {
        return this.esta_en_casilla % 40;
    }

    /**
     * @param billetes_de_500 the billetes_de_500 to set
     */
    public void setEsta_en_casilla(int offset) {
        this.esta_en_casilla = (this.esta_en_casilla + offset) % 40; /* 40 casillas: de 0 a 39*/
    }
    
}
