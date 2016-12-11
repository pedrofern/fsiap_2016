/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

import aplicacaofsiap.FeixeDLuzResultante;
import aplicacaofsiap.TipoDPolarizacao;
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
public class PolarizacaoPorAbsorcaoTest {
    
    public PolarizacaoPorAbsorcaoTest() {
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
     * Test of getTipoDPolarizacao method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testGetTipoDPolarizacao() {
        System.out.println("getTipoDPolarizacao");
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        TipoDPolarizacao expResult = TipoDPolarizacao.ABSORCAO;
        TipoDPolarizacao result = instance.getTipoDPolarizacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPolarizador method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testGetPolarizador() {
        System.out.println("getPolarizador");
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        Polarizador expResult = new Polarizador(0);
        instance.setPolarizador(expResult);
        Polarizador result = instance.getPolarizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPolarizador method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testSetPolarizador() {
        System.out.println("setPolarizador");
        Polarizador polarizador = new Polarizador(0);
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        instance.setPolarizador(polarizador);

    }

    /**
     * Test of getAnalisador method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testGetAnalisador() {
        System.out.println("getAnalisador");
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        Analisador expResult = new Analisador(0);
        instance.setAnalisador(expResult);
        Analisador result = instance.getAnalisador();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnalisador method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testSetAnalisador() {
        System.out.println("setAnalisador");
        Analisador analisador = new Analisador(0);
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        instance.setAnalisador(analisador);
    }

    /**
     * Test of getFeixe_resultante method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testGetFeixe_resultante() {
        System.out.println("getFeixe_resultante");
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        FeixeDLuzResultante expResult = new FeixeDLuzResultante();
        instance.setFeixe_resultante(expResult);
        FeixeDLuzResultante result = instance.getFeixe_resultante();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFeixe_resultante method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testSetFeixe_resultante() {
        System.out.println("setFeixe_resultante");
        FeixeDLuzResultante feixe_resultante = new FeixeDLuzResultante();
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        instance.setFeixe_resultante(feixe_resultante);

    }

    /**
     * Test of getFeixe_intermedio method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testGetFeixe_intermedio() {
        System.out.println("getFeixe_intermedio");
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        FeixeDLuzResultante expResult = new FeixeDLuzResultante();
        instance.setFeixe_intermedio(expResult);
        FeixeDLuzResultante result = instance.getFeixe_intermedio();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFeixe_intermedio method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testSetFeixe_intermedio() {
        System.out.println("setFeixe_intermedio");
        FeixeDLuzResultante feixe_intermedio = new FeixeDLuzResultante();
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        instance.setFeixe_intermedio(feixe_intermedio);
    }

    /**
     * Test of realizarPolarizacao_PObterResultados method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testRealizarPolarizacao_PObterResultados() {
        System.out.println("realizarPolarizacao_PObterResultados");
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        instance.realizarPolarizacao_PObterResultados();
    }

    /**
     * Test of calcularIntensidadeDFeixeIntermedio method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testCalcularIntensidadeDFeixeIntermedio() {
        System.out.println("calcularIntensidadeDFeixeIntermedio");
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        double expResult = 0.0;
        double result = instance.calcularIntensidadeDFeixeIntermedio();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularIntensidadeDFeixeResultante method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testCalcularIntensidadeDFeixeResultante() {
        System.out.println("calcularIntensidadeDFeixeResultante");
        double anguloEntreLentes = 0.0;
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        double expResult = 0.0;
        double result = instance.calcularIntensidadeDFeixeResultante(anguloEntreLentes);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of obterAnguloEntrePolarizadorEAnalisador method, of class PolarizacaoPorAbsorcao.
     */
    @Test
    public void testObterAnguloEntrePolarizadorEAnalisador() {
        System.out.println("obterAnguloEntrePolarizadorEAnalisador");
        PolarizacaoPorAbsorcao instance = new PolarizacaoPorAbsorcao();
        double expResult = 0.0;
        double result = instance.obterAnguloEntrePolarizadorEAnalisador();
        assertEquals(expResult, result, 0.0);
    }

    
}
