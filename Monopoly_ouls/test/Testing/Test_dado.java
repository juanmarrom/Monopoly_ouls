package Testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Contenedores.Dado;
import org.junit.*;
/**
 *
 * @author User
 */
public class Test_dado {
    private Dado dado;
    private int numero = 3;
        
    @Before
    public void preparacionTest() throws Exception{
        System.out.println(" AAE Numero dlkjsklñdj");
        dado = new Dado();
        numero = dado.tirar_dado();
        System.out.println(" AAE Numero " + numero);
    }            
    
    @Test
    public void calculoBasico() {                
        System.out.println("Numero " + numero);
        Assert.assertTrue(numero >= 1 && numero <= 6);        
    }    
}
