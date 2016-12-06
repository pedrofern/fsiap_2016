/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

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
public class FeixeDLuzTest {
    
    public FeixeDLuzTest() {
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
     * Test of getTipo method, of class FeixeDLuz.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        FeixeDLuz instance = new FeixeDLuzImpl();
        FeixeDLuz.TipoDLuz expResult = FeixeDLuz.TipoDLuz.NAO_POLARIZADA;
        FeixeDLuz.TipoDLuz result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTipo method, of class FeixeDLuz.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        FeixeDLuz.TipoDLuz tipo = FeixeDLuz.TipoDLuz.NAO_POLARIZADA;
        FeixeDLuz instance = new FeixeDLuzImpl();
        instance.setTipo(tipo);
    }

    /**
     * Test of getIntensidade method, of class FeixeDLuz.
     */
    @Test
    public void testGetIntensidade() {
        System.out.println("getIntensidade");
        FeixeDLuz instance = new FeixeDLuzImpl();
        double expResult = 0.0;
        double result = instance.getIntensidade();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setIntensidade method, of class FeixeDLuz.
     */
    @Test
    public void testSetIntensidade() {
        System.out.println("setIntensidade");
        double intensidade = 1.0;
        FeixeDLuz instance = new FeixeDLuzImpl();
        instance.setIntensidade(intensidade);
    }

    /**
     * Test of validaIntensidade method, of class FeixeDLuz.
     */
    @Test
    public void testValidaIntensidade() {
        System.out.println("validaIntensidade");
        double intensidade = 1.0;
        boolean expResult = true;
        boolean result = FeixeDLuz.validaIntensidade(intensidade);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAngulo method, of class FeixeDLuz.
     */
    @Test
    public void testGetAngulo() {
        System.out.println("getAngulo");
        FeixeDLuz instance = new FeixeDLuzImpl();
        double expResult = 0.0;
        double result = instance.getAngulo();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAngulo method, of class FeixeDLuz.
     */
    @Test
    public void testSetAngulo() {
        System.out.println("setAngulo");
        double angulo = 70.0;
        FeixeDLuz instance = new FeixeDLuzImpl();
        instance.setAngulo(angulo);
    }

    /**
     * Test of setAnguloValidacao method, of class FeixeDLuz.
     */
    @Test
    public void testSetAnguloValidacao() {
        System.out.println("setAnguloValidacao");
        double anguloDeIncidencia = 70.0;
        FeixeDLuz instance = new FeixeDLuzImpl();
        boolean expResult = true;
        boolean result = instance.setAnguloValidacao(anguloDeIncidencia);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaAngulo method, of class FeixeDLuz.
     */
    @Test
    public void testValidaAngulo() {
        System.out.println("validaAngulo");
        double angulo = 70.0;
        FeixeDLuz instance = new FeixeDLuzImpl();
        boolean expResult = true;
        boolean result = instance.validaAngulo(angulo);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class FeixeDLuz.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new FeixeDLuzIncidente(1);
        FeixeDLuz instance = new FeixeDLuzIncidente(1);
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class FeixeDLuz.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        FeixeDLuz instance = new FeixeDLuzImpl();
        int expResult = 679;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    public class FeixeDLuzImpl extends FeixeDLuz {
    }
    
}
