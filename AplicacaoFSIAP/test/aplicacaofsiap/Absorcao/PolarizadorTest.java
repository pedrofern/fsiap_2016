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
public class PolarizadorTest {

    public PolarizadorTest() {
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
     * Test of toString method, of class Polarizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polarizador instance = new Polarizador(35.1);
        String expResult = "Polarizador{"
                + "Lente{" + "angulo_emGraus=" + "35.1" + '}'
                + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
