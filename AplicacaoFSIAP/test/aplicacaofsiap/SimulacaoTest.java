/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import aplicacaofsiap.Absorcao.PolarizacaoPorAbsorcao;
import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
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
public class SimulacaoTest {
    
    public SimulacaoTest() {
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
     * Test of getTipoDPolarizacao method, of class Simulacao.
     */
    @Test
    public void testGetTipoDPolarizacao() {
        System.out.println("getTipoDPolarizacao");
        Simulacao instance = new Simulacao(TipoDPolarizacao.REFLEXAO);
        TipoDPolarizacao expResult = TipoDPolarizacao.REFLEXAO;
        TipoDPolarizacao result = instance.getTipoDPolarizacao();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTipoDPolarizacao method, of class Simulacao.
     */
    @Test
    public void testSetTipoDPolarizacao() {
        System.out.println("setTipoDPolarizacao");
        TipoDPolarizacao tipoDPolarizacao = TipoDPolarizacao.REFLEXAO;
        Simulacao instance = new Simulacao(TipoDPolarizacao.ABSORCAO);
        instance.setTipoDPolarizacao(tipoDPolarizacao);
    }

    /**
     * Test of getPolarizacaoPorAbsorcao method, of class Simulacao.
     */
    @Test
    public void testGetPolarizacaoPorAbsorcao() {
        System.out.println("getPolarizacaoPorAbsorcao");
        Simulacao instance = new Simulacao(TipoDPolarizacao.REFLEXAO);
        PolarizacaoPorAbsorcao expResult = new PolarizacaoPorAbsorcao();
        instance.setPolarizacaoPorAbsorcao(expResult);
        PolarizacaoPorAbsorcao result = instance.getPolarizacaoPorAbsorcao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPolarizacaoPorAbsorcao method, of class Simulacao.
     */
    @Test
    public void testSetPolarizacaoPorAbsorcao() {
        System.out.println("setPolarizacaoPorAbsorcao");
        PolarizacaoPorAbsorcao polarizacaoPorAbsorcao = new PolarizacaoPorAbsorcao();
        Simulacao instance = new Simulacao(TipoDPolarizacao.ABSORCAO);
        instance.setPolarizacaoPorAbsorcao(polarizacaoPorAbsorcao);
    }

    /**
     * Test of getPolarizacaoPorReflexao method, of class Simulacao.
     */
    @Test
    public void testGetPolarizacaoPorReflexao() {
        System.out.println("getPolarizacaoPorReflexao");
        Simulacao instance = new Simulacao(TipoDPolarizacao.REFLEXAO);
        PolarizacaoPorReflexao expResult = new PolarizacaoPorReflexao();
        instance.setPolarizacaoPorReflexao(expResult);
        PolarizacaoPorReflexao result = instance.getPolarizacaoPorReflexao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPolarizacaoPorReflexao method, of class Simulacao.
     */
    @Test
    public void testSetPolarizacaoPorReflexao() {
        System.out.println("setPolarizacaoPorReflexao");
        PolarizacaoPorReflexao polarizacaoPorReflexao = new PolarizacaoPorReflexao();
        Simulacao instance = new Simulacao(TipoDPolarizacao.REFLEXAO);
        instance.setPolarizacaoPorReflexao(polarizacaoPorReflexao);
    }

    /**
     * Test of toString method, of class Simulacao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Simulacao instance = new Simulacao(TipoDPolarizacao.ABSORCAO);
        String expResult = "Simulacao{" + "tipoDPolarizacao=" + instance.getTipoDPolarizacao() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
