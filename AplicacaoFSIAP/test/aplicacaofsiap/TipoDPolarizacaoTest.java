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
public class TipoDPolarizacaoTest {
    
    public TipoDPolarizacaoTest() {
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
     * Test of valueOf method, of class TipoDPolarizacao.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "ABSORCAO";
        TipoDPolarizacao expResult = TipoDPolarizacao.ABSORCAO;
        TipoDPolarizacao result = TipoDPolarizacao.valueOf(name);
        assertEquals(expResult, result);
    }
    
}
