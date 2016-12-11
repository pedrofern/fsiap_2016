/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class ListaSimulacoesTest {
    
    public ListaSimulacoesTest() {
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
     * Test of adicionarSimulacao method, of class ListaSimulacoes.
     */
    @Test
    public void testAdicionarSimulacao() {
        System.out.println("adicionarSimulacao");
        Simulacao simulacao = new Simulacao(TipoDPolarizacao.ABSORCAO);
        ListaSimulacoes instance = new ListaSimulacoes();
        boolean expResult = true;
        boolean result = instance.adicionarSimulacao(simulacao);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class ListaSimulacoes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ListaSimulacoes instance = new ListaSimulacoes();
        Simulacao s= new Simulacao(TipoDPolarizacao.ABSORCAO);
        instance.adicionarSimulacao(s);
        String expResult = "Lista de Simulações\n"+s.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
