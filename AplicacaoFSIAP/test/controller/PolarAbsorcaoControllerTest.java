/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Helder
 */
public class PolarAbsorcaoControllerTest {

    public PolarAbsorcaoControllerTest() {
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
     * Test of setIntensidade_FeixeIncid method, of class
     * PolarAbsorcaoController.
     */
    @Test
    public void testSetIntensidade_FeixeIncid() {
        System.out.println("setIntensidade_FeixeIncid");
        //valor válido
        String value = "1.5";
        PolarAbsorcaoController instance = new PolarAbsorcaoController(null);
        boolean expResult = true;
        boolean result = instance.setIntensidade_FeixeIncid(value);
        assertEquals(expResult, result);
        //valor nulo
        String value2 = "";
        PolarAbsorcaoController instance2 = new PolarAbsorcaoController(null);
        boolean expResult2 = false;
        boolean result2 = instance2.setIntensidade_FeixeIncid(value2);
        assertEquals(expResult2, result2);
        //valor não é numérico
        String value3 = "not_a_number";
        PolarAbsorcaoController instance3 = new PolarAbsorcaoController(null);
        boolean expResult3 = false;
        boolean result3 = instance3.setIntensidade_FeixeIncid(value3);
        assertEquals(expResult3, result3);
        //valor é negativo
        String value4 = "-1";
        PolarAbsorcaoController instance4 = new PolarAbsorcaoController(null);
        boolean expResult4 = false;
        boolean result4 = instance4.setIntensidade_FeixeIncid(value4);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of setAngulo_Analisador method, of class PolarAbsorcaoController.
     */
    @Test
    public void testSetAngulo_Analisador() {
        System.out.println("setAngulo_Analisador");
        //valor válido
        String value = "20.5";
        PolarAbsorcaoController instance = new PolarAbsorcaoController(null);
        boolean expResult = true;
        boolean result = instance.setAngulo_Analisador(value);
        assertEquals(expResult, result);
        //valor vazio  //colocar a mensagem a sair de domínio na validação e ver se no
        //teste já não aparece mensagem
//        String value2 = "";
//        PolarAbsorcaoController instance2 = new PolarAbsorcaoController(null);
//        boolean expResult2 = false;
//        boolean result2 = instance2.setAngulo_Analisador(value2);
//        assertEquals(expResult2, result2);
//        try {
        //o valor não é um número
        String value3 = "not_a_Number";
        PolarAbsorcaoController instance3 = new PolarAbsorcaoController(null);
        boolean expResult3 = false;
        boolean result3 = instance3.setAngulo_Analisador(value3);
//            fail("Expected NumberFormatException");
        assertEquals(expResult3, result3);
//        } catch (NumberFormatException ex) {
//            assertThat(ex.getMessage(), is("pppO ângulo do "));
//        }
    }

}
