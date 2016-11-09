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
public class MeioReflexaoTest {
    
    public MeioReflexaoTest() {
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
     * Test of getNome method, of class MeioReflexao.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        MeioReflexao instance = new MeioReflexao();
        instance.setNome("abc");
        String expResult = "abc";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class MeioReflexao.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "abc";
        MeioReflexao instance = new MeioReflexao();
        instance.setNome(nome);
    }

    /**
     * Test of getIndiceRefracao method, of class MeioReflexao.
     */
    @Test
    public void testGetIndiceRefracao() {
        System.out.println("getIndiceRefracao");
        MeioReflexao instance = new MeioReflexao();
        instance.setIndiceRefracao(1.0);
        double expResult = 1.0;
        double result = instance.getIndiceRefracao();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setIndiceRefracao method, of class MeioReflexao.
     */
    @Test
    public void testSetIndiceRefracao() {
        System.out.println("setIndiceRefracao");
        double indice = 1.0;
        MeioReflexao instance = new MeioReflexao();
        instance.setIndiceRefracao(indice);
    }

    /**
     * Test of equals method, of class MeioReflexao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new MeioReflexao("abc", 1.0);
        MeioReflexao instance = new MeioReflexao();
        instance.setIndiceRefracao(1.0);
        instance.setNome("abc");
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Test of valida method, of class MeioReflexao.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        MeioReflexao instance = new MeioReflexao("abc",1.0);
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
    }
    
}
