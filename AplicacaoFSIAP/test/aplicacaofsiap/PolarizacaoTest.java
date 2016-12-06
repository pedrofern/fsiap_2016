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
public class PolarizacaoTest {
    
    public PolarizacaoTest() {
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
     * Test of getF_incidente method, of class Polarizacao.
     */
    @Test
    public void testGetF_incidente() {
        System.out.println("getF_incidente");
        Polarizacao instance = new PolarizacaoImpl();
        FeixeDLuzIncidente expResult = new FeixeDLuzIncidente(1);
        instance.setF_incidente(expResult);
        FeixeDLuzIncidente result = instance.getF_incidente();
        assertEquals(expResult, result);
    }

    /**
     * Test of setF_incidente method, of class Polarizacao.
     */
    @Test
    public void testSetF_incidente() {
        System.out.println("setF_incidente");
        FeixeDLuzIncidente f_incidente = new FeixeDLuzIncidente(1);
        Polarizacao instance = new PolarizacaoImpl();
        instance.setF_incidente(f_incidente);
    }

    /**
     * Test of toString method, of class Polarizacao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polarizacao instance = new PolarizacaoImpl();
        String expResult = "Polarizacao{" + "f_incidente=" + instance.getF_incidente() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    public class PolarizacaoImpl extends Polarizacao {
    }
    
}
