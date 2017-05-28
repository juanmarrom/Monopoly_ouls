/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenedores;

import java.util.Random;

/**
 *
 * @author User
 */
public class Dado {
   public static int tirar_dado() {
        Random r = new Random();
        int valor_dado = r.nextInt(6)+1;
        return valor_dado;
    }       
}
