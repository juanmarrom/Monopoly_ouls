/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenedores;

/**
 *
 * @author User
 */
public class Tarjeta {
    private int id; //tipo 0 suerte, tipo 1 comunidad
    private int tipo; //tipo 0 suerte, tipo 1 comunidad
    private String texto; //
    private int subtipo; //o normal, 1 ir a la carcel
    private int cobrar; //0 pagar, 1 cobrar
    private int cantidad; //0 pagar, 1 cobrar
    private int ir_a_casilla; //de 0 a 39

    
    public Tarjeta(int id, int tipo, String texto, int subtipo, int cobrar, int cantidad, int ir_a_casilla) {
        this.id = id; //tipo 0 suerte, tipo 1 comunidad
        this.tipo = tipo; //tipo 0 suerte, tipo 1 comunidad
        this.texto = texto; 
        this.subtipo = subtipo; //o normal, 1 ir a la carcel
        this.cobrar = cobrar;
        this.cantidad = cantidad;
        this.ir_a_casilla = ir_a_casilla;
    }
    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the subtipo
     */
    public int getSubtipo() {
        return subtipo;
    }

    /**
     * @param subtipo the subtipo to set
     */
    public void setSubtipo(int subtipo) {
        this.subtipo = subtipo;
    }

    /**
     * @return the cobrar
     */
    public int getCobrar() {
        return cobrar;
    }

    /**
     * @param cobrar the cobrar to set
     */
    public void setCobrar(int cobrar) {
        this.cobrar = cobrar;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the ir_a_casilla
     */
    public int getIr_a_casilla() {
        return ir_a_casilla;
    }

    /**
     * @param ir_a_casilla the ir_a_casilla to set
     */
    public void setIr_a_casilla(int ir_a_casilla) {
        this.ir_a_casilla = ir_a_casilla;
    }
}
