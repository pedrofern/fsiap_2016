/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Reflexao;

import aplicacaofsiap.FeixeDLuzIncidente;
import aplicacaofsiap.FeixeDLuzResultante;
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
public class PolarizacaoPorReflexaoTest {
    
    public PolarizacaoPorReflexaoTest() {
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
     * Test of getMeioPolarizacao1 method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testGetMeioPolarizacao1() {
        System.out.println("getMeioPolarizacao1");
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        MeioReflexao expResult = new MeioReflexao("teste", 1.23);
        instance.setMeioReflexao1(expResult);
        MeioReflexao result = instance.getMeioPolarizacao1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMeioPolarizacao2 method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testGetMeioPolarizacao2() {
        System.out.println("getMeioPolarizacao2");
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        MeioReflexao expResult = new MeioReflexao("teste", 1.23);
        instance.setMeioReflexao2(expResult);
        MeioReflexao result = instance.getMeioPolarizacao2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFeixeDeLuzIncidente method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testGetFeixeDeLuzIncidente() {
        System.out.println("getFeixeDeLuzIncidente");
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        FeixeDLuzIncidente expResult = null;
        FeixeDLuzIncidente result = instance.getFeixeDeLuzIncidente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeixeReflexao1 method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testGetFeixeReflexao1() {
        System.out.println("getFeixeReflexao1");
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        FeixeDLuzResultante expResult = new FeixeDLuzResultante();
  
        FeixeDLuzResultante result = instance.getFeixeReflexao1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeixeReflexao2 method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testGetFeixeReflexao2() {
        System.out.println("getFeixeReflexao2");
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        FeixeDLuzResultante expResult = null;
        FeixeDLuzResultante result = instance.getFeixeReflexao2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeixeRefracao method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testGetFeixeRefracao() {
        System.out.println("getFeixeRefracao");
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        FeixeDLuzResultante expResult = null;
        FeixeDLuzResultante result = instance.getFeixeRefracao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnguloBrewster method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testGetAnguloBrewster() {
        System.out.println("getAnguloBrewster");
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        double expResult = -1;
        double result = instance.getAnguloBrewster();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setMeioReflexao1 method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testSetMeioReflexao1() {
        System.out.println("setMeioReflexao1");
        MeioReflexao meio1 = new MeioReflexao("teste", 1.23);
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        boolean expResult = true;
        boolean result = instance.setMeioReflexao1(meio1);
        assertEquals(expResult, result);
    }

    /**
     * Test of setMeioReflexao2 method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testSetMeioReflexao2() {
        System.out.println("setMeioReflexao2");
        MeioReflexao meio2 = new MeioReflexao("teste", 1.23);
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        boolean expResult = true;
        boolean result = instance.setMeioReflexao2(meio2);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaMaterial method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testValidaMaterial() {
        System.out.println("validaMaterial");
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        instance.setMeioReflexao1(new MeioReflexao("teste1", 1.23));
        instance.setMeioReflexao1(new MeioReflexao("teste2", 1.24));
        boolean expResult = true;
        boolean result = instance.validaMaterial();
        assertEquals(expResult, result);
    }

    /**
     * Test of validaAngulo method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testValidaAngulo() {
        System.out.println("validaAngulo");
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        boolean expResult = false;
        boolean result = instance.validaAngulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gerarResultado method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testGerarResultado() {
        System.out.println("gerarResultado");
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        boolean expResult = false;
        boolean result = instance.gerarResultado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = null;
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularAnguloReflexaoBrewster method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testCalcularAnguloReflexaoBrewster() {
        System.out.println("calcularAnguloReflexaoBrewster");
        double anguloIncidencia = 0.0;
        MeioReflexao meio1 = null;
        MeioReflexao meio2 = null;
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        instance.calcularAnguloReflexaoBrewster(anguloIncidencia, meio1, meio2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularAnguloBrewster method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testCalcularAnguloBrewster() {
        System.out.println("calcularAnguloBrewster");
        double n1 = 0.0;
        double n2 = 0.0;
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        instance.calcularAnguloBrewster(n1, n2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularAnguloRefracao method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testCalcularAnguloRefracao() {
        System.out.println("calcularAnguloRefracao");
        double n1 = 0.0;
        double n2 = 0.0;
        double angReflexao = 0.0;
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        instance.calcularAnguloRefracao(n1, n2, angReflexao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularIntensidadeReflexaoPerpendicular method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testCalcularIntensidadeReflexaoPerpendicular() {
        System.out.println("calcularIntensidadeReflexaoPerpendicular");
        double n1 = 0.0;
        double n2 = 0.0;
        double angIncidencia = 0.0;
        double angRefracao = 0.0;
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        instance.calcularIntensidadeReflexaoPerpendicular(n1, n2, angIncidencia, angRefracao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularIntensidadeReflexaoParalela method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testCalcularIntensidadeReflexaoParalela() {
        System.out.println("calcularIntensidadeReflexaoParalela");
        double n1 = 0.0;
        double n2 = 0.0;
        double angIncidencia = 0.0;
        double angRefracao = 0.0;
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        instance.calcularIntensidadeReflexaoParalela(n1, n2, angIncidencia, angRefracao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularIntensidadeRefracao method, of class PolarizacaoPorReflexao.
     */
    @Test
    public void testCalcularIntensidadeRefracao() {
        System.out.println("calcularIntensidadeRefracao");
        double n1 = 0.0;
        double n2 = 0.0;
        double angIncidencia = 0.0;
        double angRefracao = 0.0;
        PolarizacaoPorReflexao instance = new PolarizacaoPorReflexao();
        instance.calcularIntensidadeRefracao(n1, n2, angIncidencia, angRefracao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
