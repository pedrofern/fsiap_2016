/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.FeixeDLuzIncidente;
import aplicacaofsiap.FeixeDLuzResultante;
import aplicacaofsiap.LightGo;
import aplicacaofsiap.Reflexao.ListaMeiosReflexao;
import aplicacaofsiap.Reflexao.MeioReflexao;
import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
import aplicacaofsiap.Simulacao;
import aplicacaofsiap.TipoDPolarizacao;
import javafx.scene.effect.Light;
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
public class PReflexaoControllerTest {
    LightGo lg = new LightGo();
    Simulacao s = new Simulacao(TipoDPolarizacao.REFLEXAO);
    
    public PReflexaoControllerTest() {
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
     * Test of getListaMeios method, of class PReflexaoController.
     */
    @Test
    public void testGetListaMeios() {
        System.out.println("getListaMeios");
        PReflexaoController instance = new PReflexaoController(lg, s);
        ListaMeiosReflexao expResult = lg.getListaMeios();
        ListaMeiosReflexao result = instance.getListaMeios();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnguloIncidente method, of class PReflexaoController.
     */
    @Test
    public void testGetAnguloIncidente() {
        System.out.println("getAnguloIncidente");
        PReflexaoController instance = new PReflexaoController(lg, s);
        instance.setAngulo(23);
        double expResult = 23.0;
        double result = instance.getAnguloIncidente();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getAnguloBrewster method, of class PReflexaoController.
     */
    @Test
    public void testGetAnguloBrewster() {
        System.out.println("getAnguloBrewster");
        lg.getListaMeios().registaMeio(new MeioReflexao("c", 1.1));
        lg.getListaMeios().registaMeio(new MeioReflexao("d", 1.1));
        s.setPolarizacaoPorReflexao(new PolarizacaoPorReflexao(
                new FeixeDLuzIncidente(1), new MeioReflexao("a", 1) ,
                new MeioReflexao("b", 1.1), new FeixeDLuzResultante(), 
                new FeixeDLuzResultante(), new FeixeDLuzResultante(), 23));
        PReflexaoController instance = new PReflexaoController(lg, s);
        instance.setAngulo(23);
        double expResult = 23;
        double result = instance.getAnguloBrewster();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSimulacao method, of class PReflexaoController.
     */
    @Test
    public void testGetSimulacao() {
        System.out.println("getSimulacao");
        PReflexaoController instance = new PReflexaoController(lg, s);
        Simulacao expResult = s;
        Simulacao result = instance.getSimulacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMeioReflexao1 method, of class PReflexaoController.
     */
    @Test
    public void testSetMeioReflexao1() {
        System.out.println("setMeioReflexao1");
        lg.getListaMeios().registaMeio(new MeioReflexao("a", 1.1));
        MeioReflexao meio1 = lg.getListaMeios().getListaMeios().get(0);
        PReflexaoController instance = new PReflexaoController(lg, s);
        boolean expResult = true;
        boolean result = instance.setMeioReflexao1(meio1);
        assertEquals(expResult, result);
    }

    /**
     * Test of setMeioReflexao2 method, of class PReflexaoController.
     */
    @Test
    public void testSetMeioReflexao2() {
        System.out.println("setMeioReflexao2");
        lg.getListaMeios().registaMeio(new MeioReflexao("b", 1.11));
        MeioReflexao meio2 = lg.getListaMeios().getListaMeios().get(0);
        PReflexaoController instance = new PReflexaoController(lg, s);
        boolean expResult = true;
        boolean result = instance.setMeioReflexao2(meio2);
        assertEquals(expResult, result);
    }

    /**
     * Test of setAngulo method, of class PReflexaoController.
     */
    @Test
    public void testSetAngulo() {
        System.out.println("setAngulo");
        double angulo = 23.0;
        PReflexaoController instance = new PReflexaoController(lg, s);
        boolean expResult = true;
        boolean result = instance.setAngulo(angulo);
        assertEquals(expResult, result);
    }

    /**
     * Test of setIntensidade method, of class PReflexaoController.
     */
    @Test
    public void testSetIntensidade() {
        System.out.println("setIntensidade");
        double intensidade = 1.0;
        PReflexaoController instance = new PReflexaoController(lg, s);
        boolean expResult = true;
        boolean result = instance.setIntensidade(intensidade);
        assertEquals(expResult, result);
    }

    /**
     * Test of gerarResultado method, of class PReflexaoController.
     */
    @Test
    public void testGerarResultado() {
        System.out.println("gerarResultado");
        PReflexaoController instance = new PReflexaoController(lg, s);
        instance.setAngulo(23);
        instance.setIntensidade(1);
        instance.setMeioReflexao1(new MeioReflexao("a", 1.11));
        instance.setMeioReflexao1(new MeioReflexao("b", 1.11));
        boolean expResult = true;
        boolean result = instance.gerarResultado();
        assertEquals(expResult, result);
    }

    /**
     * Test of addListaSimulacoes method, of class PReflexaoController.
     */
    @Test
    public void testAddListaSimulacoes() {
        System.out.println("addListaSimulacoes");
        PReflexaoController instance = new PReflexaoController(lg, s);
        boolean expResult = true;
        boolean result = instance.addListaSimulacoes();
        assertEquals(expResult, result);
    }
    
}
