/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import aplicacaofsiap.Reflexao.ListaMeiosReflexao;
import aplicacaofsiap.Reflexao.MeioReflexao;
import java.util.ArrayList;
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
public class ListaMeiosReflexaoTest {
    
    public ListaMeiosReflexaoTest() {
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
     * Test of obterMeioReflexao method, of class ListaMeiosReflexao.
     */
    @Test
    public void testObterMeioReflexao() {
        System.out.println("obterMeioReflexao");
        int indice = 0;
        ListaMeiosReflexao instance = new ListaMeiosReflexao();
        ArrayList<MeioReflexao> novo = new ArrayList<>();
        MeioReflexao m = new MeioReflexao("a",1.0);
        instance.registaMeio(m);
        novo.add(m);
        MeioReflexao expResult = novo.get(indice);
        MeioReflexao result = instance.obterMeioReflexao(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of getArray method, of class ListaMeiosReflexao.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        ListaMeiosReflexao instance = new ListaMeiosReflexao();
        ArrayList<MeioReflexao> novo = new ArrayList<>();
        MeioReflexao m = new MeioReflexao("a",1.0);
        instance.registaMeio(m);
        novo.add(m);
        MeioReflexao[] expResult = novo.toArray(new MeioReflexao[novo.size()]);
        MeioReflexao[] result = instance.getArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getListaMeios method, of class ListaMeiosReflexao.
     */
    @Test
    public void testGetListaMeios() {
        System.out.println("getListaMeios");
        ListaMeiosReflexao instance = new ListaMeiosReflexao();
        ArrayList<MeioReflexao> novo = new ArrayList<>();
        MeioReflexao m = new MeioReflexao("a",1.0);
        instance.registaMeio(m);
        novo.add(m);
        List<MeioReflexao> expResult = novo;
        List<MeioReflexao> result = instance.getListaMeios();
        assertEquals(expResult, result);
    }

    /**
     * Test of registaMeio method, of class ListaMeiosReflexao.
     */
    @Test
    public void testRegistaMeio() {
        System.out.println("registaMeio");
        MeioReflexao m = new MeioReflexao("a",1.0);
        ListaMeiosReflexao instance = new ListaMeiosReflexao();
        boolean expResult = true;
        boolean result = instance.registaMeio(m);
        assertEquals(expResult, result);
    }

    /**
     * Test of removerMeio method, of class ListaMeiosReflexao.
     */
    @Test
    public void testRemoverMeio() {
        System.out.println("removerMeio");
        MeioReflexao meio = new MeioReflexao("a",1.0);
        ListaMeiosReflexao instance = new ListaMeiosReflexao();
        instance.registaMeio(meio);
        boolean expResult = true;
        boolean result = instance.removerMeio(meio);
        assertEquals(expResult, result);
    }

    /**
     * Test of tamanho method, of class ListaMeiosReflexao.
     */
    @Test
    public void testTamanho() {
        System.out.println("tamanho");
        MeioReflexao meio = new MeioReflexao("a",1.0);
        ListaMeiosReflexao instance = new ListaMeiosReflexao();
        instance.registaMeio(meio);
        int expResult = 1;
        int result = instance.tamanho();
        assertEquals(expResult, result);
    }

    /**
     * Test of contem method, of class ListaMeiosReflexao.
     */
    @Test
    public void testContem() {
        System.out.println("contem");
        MeioReflexao meio = new MeioReflexao("a",1.0);
        ListaMeiosReflexao instance = new ListaMeiosReflexao();
        instance.registaMeio(meio);
        boolean expResult = true;
        boolean result = instance.contem(meio);
        assertEquals(expResult, result);
    }
    
}
