/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import aplicacaofsiap.Reflexao.ListaMeiosReflexao;
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
public class LightGoTest {
    
    public LightGoTest() {
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
     * Test of getListaMeios method, of class LightGo.
     */
    @Test
    public void testGetListaMeios() {
        System.out.println("getListaMeios");
        LightGo instance = new LightGo();
        ListaMeiosReflexao expResult = instance.listaMeiosReflexao;
        ListaMeiosReflexao result = instance.getListaMeios();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstatistica method, of class LightGo.
     */
    @Test
    public void testGetEstatistica() {
        System.out.println("getEstatistica");
        LightGo instance = new LightGo();
        Estatistica expResult = instance.estatistica;
        Estatistica result = instance.getEstatistica();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaSimulacoes method, of class LightGo.
     */
    @Test
    public void testGetListaSimulacoes() {
        System.out.println("getListaSimulacoes");
        LightGo instance = new LightGo();
        ListaSimulacoes expResult = instance.listaSimulacoes;
        ListaSimulacoes result = instance.getListaSimulacoes();
        assertEquals(expResult, result);
    }
    
}
