/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.LightGo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Fernandes
 */
public class CarregarFicheiroControllerTest {
    
    public CarregarFicheiroControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of carregaMeios method, of class CarregarFicheiroController.
     */
    @Test
    public void testCarregaMeios() {
        System.out.println("carregaMeios");
        String ficheiro = "src/ficheiros/meioReflexao.txt";
        LightGo lgo = new LightGo();
        CarregarFicheiroController instance = new CarregarFicheiroController(lgo);
        boolean expResult = true;
        boolean result = instance.carregaMeios(ficheiro);
        assertEquals(expResult, result);
    }

    /**
     * Test of carregaMeiosAutomaticamente method, of class CarregarFicheiroController.
     */
    @Test
    public void testCarregaMeiosAutomaticamente() {
        System.out.println("carregaMeiosAutomaticamente");
        LightGo lgo = new LightGo();
        CarregarFicheiroController instance = new CarregarFicheiroController(lgo);
        boolean expResult = true;
        boolean result = instance.carregaMeiosAutomaticamente();
        assertEquals(expResult, result);
    }
    
}
