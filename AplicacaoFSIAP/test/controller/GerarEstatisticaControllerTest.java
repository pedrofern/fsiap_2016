/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.LightGo;
import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
import java.util.Collections;
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
public class GerarEstatisticaControllerTest {
    LightGo lg = new LightGo();
    GerarEstatisticaController instance = new GerarEstatisticaController(lg);
    
    public GerarEstatisticaControllerTest() {
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
     * Test of getValorMedioSubmissaoGlobal method, of class GerarEstatisticaController.
     */
    @Test
    public void testGetValorMedioSubmissaoGlobal() {
        System.out.println("getValorMedioSubmissaoGlobal");
        String expResult = "media: ";
        String result = instance.getValorMedioSubmissaoGlobal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTaxaAceitacaoGlobal method, of class GerarEstatisticaController.
     */
    @Test
    public void testGetTaxaAceitacaoGlobal() {
        System.out.println("getTaxaAceitacaoGlobal");
        String expResult = "ola taxa";
        String result = instance.getTaxaAceitacaoGlobal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaPolarizacoesReflexao method, of class GerarEstatisticaController.
     */
    @Test
    public void testGetListaPolarizacoesReflexao() {
        System.out.println("getListaPolarizacoesReflexao");
        List<PolarizacaoPorReflexao> expResult = lg.getListaSimulacoes().getListaPolarizacoesReflexao() ;
        List<PolarizacaoPorReflexao> result = instance.getListaPolarizacoesReflexao();
        assertEquals(expResult, result);
    }

    /**
     * Test of ordenar method, of class GerarEstatisticaController.
     */
    @Test
    public void testOrdenar() {
        System.out.println("ordenar");
        Collections.sort(instance.getListaPolarizacoesReflexao());
    }
    
}
