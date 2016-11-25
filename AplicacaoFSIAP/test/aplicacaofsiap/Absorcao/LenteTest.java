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
public class LenteTest {

    public LenteTest() {
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
     * Test of getAngulo_emGraus method, of class Lente.
     */
    @Test
    public void testGetAngulo_emGraus() {
        System.out.println("getAngulo_emGraus");
        Lente instance = new LenteImpl();
        double expResult0 = 0;
        double result0 = instance.getAngulo_emGraus();
        assertEquals(expResult0, result0, 0.0);

        instance.setAngulo_emGraus(45.0);
        double expResult = 45.0;
        double result = instance.getAngulo_emGraus();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAngulo_emGraus method, of class Lente.
     */
    @Test
    public void testSetAngulo_emGraus() {
        System.out.println("setAngulo_emGraus");
        double angulo_emGraus = 90.0;
        Lente instance = new LenteImpl();
        instance.setAngulo_emGraus(angulo_emGraus);
        
        double expResult = angulo_emGraus;
        double result = instance.getAngulo_emGraus();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of obterAnguloEquivalente method, of class Lente.
     */
    @Test
    public void testObterAnguloEquivalente() {
        System.out.println("obterAnguloEquivalente");
        double angulo = 100.0; //90+10
        Lente instance = new LenteImpl();
        double expResult = -80.0;
        double result = instance.obterAnguloEquivalente(angulo);
        assertEquals(expResult, result, 0.0);

        double angulo2 = -100.0; //-90-10
        double expResult2 = 80.0;
        double result2 = instance.obterAnguloEquivalente(angulo2);
        assertEquals(expResult2, result2, 0.0);

        double angulo3 = 50.0;
        double expResult3 = 50.0;
        double result3 = instance.obterAnguloEquivalente(angulo3);
        assertEquals(expResult3, result3, 0.0);

        double angulo4 = -50.0;
        double expResult4 = -50.0;
        double result4 = instance.obterAnguloEquivalente(angulo4);
        assertEquals(expResult4, result4, 0.0);
    }

    /**
     * Test of validaAngulo_emGraus method, of class Lente.
     */
    @Test
    public void testValidaAngulo_emGraus() {
        System.out.println("validaAngulo_emGraus");
        double angulo_emGraus = 0.0;
        boolean expResult = false;
        boolean result = Lente.validaAngulo_emGraus(angulo_emGraus);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Lente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Lente instance = new LenteImpl();
        String expResult = "Lente{" + "angulo_emGraus=" + "0.0" + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
        instance.setAngulo_emGraus(45.0);
        String expResult2 = "Lente{" + "angulo_emGraus=" + "45.0" + '}';
        String result2 = instance.toString();
        assertEquals(expResult2, result2);
    }

    public class LenteImpl extends Lente {
    }

}
