/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

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
public class AnalisadorTest {

    public AnalisadorTest() {
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
     * Test of toString method, of class Analisador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Analisador instance = new Analisador(45.0);
        String expResult = "Analisador{"
                + "Lente{" + "angulo_emGraus=" + "45.0" + '}'
                + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
