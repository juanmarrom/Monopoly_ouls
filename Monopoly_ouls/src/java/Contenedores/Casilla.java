/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenedores;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Casilla implements Serializable {
    private int id;
    private String nombre;
    private int es_comprable;
    private int precio;
    private String color;
    private int grupo;
    private int total_grupo;
    private int tipo;
    private int alquiler;
    private int alquiler_1;
    private int alquiler_2;
    private int alquiler_3;
    private int alquiler_4;
    private int alquiler_hotel;
    private int hipoteca;
    private int precio_casa;
    private int precio_hotel;
    private int pertenece_a_jugador;
    private int numero_casas;
    private int numero_hoteles;
    private int tengo_grupo;
        
    public Casilla(int id,String nombre,int es_comprable,int precio,String color,int grupo,int total_grupo,int tipo,int alquiler,int alquiler_1,int alquiler_2,int alquiler_3,int alquiler_4,int alquiler_hotel,int hipoteca,int precio_casa,int precio_hotel) {
        this.id = id;
        this.nombre = nombre;
        this.es_comprable = es_comprable;
        this.precio = precio;
        this.color = color;
        this.grupo = grupo;
        this.total_grupo = total_grupo;
        this.tipo = tipo;
        this.alquiler = alquiler;
        this.alquiler_1 = alquiler_1;
        this.alquiler_2 = alquiler_2;
        this.alquiler_3 = alquiler_3;
        this.alquiler_4 = alquiler_4;
        this.alquiler_hotel = alquiler_hotel;
        this.hipoteca = hipoteca;
        this.precio_casa = precio_casa;
        this.precio_hotel = precio_hotel;
        this.pertenece_a_jugador = -1;
        this.numero_casas = 0;
        this.numero_hoteles = 0;
        this.tengo_grupo = 0;        
    }            

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the es_comprable
     */
    public int getEs_comprable() {
        return es_comprable;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the grupo
     */
    public int getGrupo() {
        return grupo;
    }

    /**
     * @return the total_grupo
     */
    public int getTotal_grupo() {
        return total_grupo;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @return the alquiler
     */
    public int getAlquiler() {
        return alquiler;
    }

    /**
     * @return the alquiler_1
     */
    public int getAlquiler_1() {
        return alquiler_1;
    }

    /**
     * @return the alquiler_2
     */
    public int getAlquiler_2() {
        return alquiler_2;
    }

    /**
     * @return the alquiler_3
     */
    public int getAlquiler_3() {
        return alquiler_3;
    }

    /**
     * @return the alquiler_4
     */
    public int getAlquiler_4() {
        return alquiler_4;
    }

    /**
     * @return the alquiler_hotel
     */
    public int getAlquiler_hotel() {
        return alquiler_hotel;
    }

    /**
     * @return the hipoteca
     */
    public int getHipoteca() {
        return hipoteca;
    }

    /**
     * @return the precio_casa
     */
    public int getPrecio_casa() {
        return precio_casa;
    }

    /**
     * @return the precio_hotel
     */
    public int getPrecio_hotel() {
        return precio_hotel;
    }

    /**
     * @return the pertenece_a_jugador
     */
    public int getPertenece_a_jugador() {
        return pertenece_a_jugador;
    }

    /**
     * @param pertenece_a_jugador the pertenece_a_jugador to set
     */
    public void setPertenece_a_jugador(int pertenece_a_jugador) {
        this.pertenece_a_jugador = pertenece_a_jugador;
    }

    /**
     * @return the numero_casas
     */
    public int getNumero_casas() {
        return numero_casas;
    }

    /**
     * @param numero_casas the numero_casas to set
     */
    public void setNumero_casas(int numero_casas) {
        this.numero_casas = numero_casas;
    }

    /**
     * @return the numero_hoteles
     */
    public int getNumero_hoteles() {
        return numero_hoteles;
    }

    /**
     * @param numero_hoteles the numero_hoteles to set
     */
    public void setNumero_hoteles(int numero_hoteles) {
        this.numero_hoteles = numero_hoteles;
    }

    /**
     * @return the tengo_grupo
     */
    public int getTengo_grupo() {
        return tengo_grupo;
    }

    /**
     * @param tengo_grupo the tengo_grupo to set
     */
    public void setTengo_grupo(int tengo_grupo) {
        this.tengo_grupo = tengo_grupo;
    }
                
}
