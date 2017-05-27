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
public class Casilla {
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
    }            
                
}
