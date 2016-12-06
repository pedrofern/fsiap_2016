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
public class FeixeDLuzIncidenteTest {
    
    public FeixeDLuzIncidenteTest() {
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
     * Test of toString method, of class FeixeDLuzIncidente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FeixeDLuzIncidente instance = new FeixeDLuzIncidente();
        String expResult = "FeixeIncidente{" + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
