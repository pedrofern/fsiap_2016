/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.ListaMeiosReflexao;
import aplicacaofsiap.Simulacao;
import aplicacaofsiap.PolarizacaoPorReflexao;
import aplicacaofsiap.MeioReflexao;

/**
 * Classe que coordena as operações relacionadas com a simulação da Polarização por Reflexão (Brewster)
 * @author Diana Silva
 */
public class PReflexaoController {
    
    
    private static Simulacao s;
    private static PolarizacaoPorReflexao pr;
    
    /**
     *  Constrói uma instância do controller com a simulacao e polarizacao reflexao passados 
     * como parâmetros
     * @param simulacao simula experiências de polarização
     * @param polarizacaoReflexao a polarização a simular
     */
    public PReflexaoController(Simulacao simulacao, PolarizacaoPorReflexao polarizacaoReflexao){
        s=simulacao;
        pr=polarizacaoReflexao;
    }
    
    /**
     * Devolve a lista de meios/materiais guardados na Simulacao
     * @return lista de meios/materiais de reflexão
     */
    public ListaMeiosReflexao getListaMeios(){
        return s.getListaMeios();
    }
    
    /**
     * Altera o meio de reflexão de onde é projetado o feixe de luz
     * @param meio1 meio de reflexão onde está o feixe de luz projetado inicialmente
     * @return true se alterou, false se não alterou
     */
    public boolean setMeioReflexao1(MeioReflexao meio1){
        return pr.setMeioReflexao1(meio1);
    }
    
    /**
     * Altera o meio de reflexão de onde o feixe de luz irá incidir
     * @param meio2 meio de reflexão em que ocorrerá a reflexão
     * @return true se alterou, false se não alterou
     */
    public boolean setMeioReflexao2(MeioReflexao meio2){
        return pr.setMeioReflexao2(meio2);
    }
    
    /**
     * Altera o ângulo de incidência do feixe de luz
     * @param angulo ângulo de incidência do feixe de luz inicial
     * @return true se alterou, false se não alterou
     */
    public boolean setAngulo(double angulo){
        return pr.setAngulo(angulo);
    }
    
    /**
     * Gera o resultado da simulação da reflexão por reflexão
     * @param pr polarização a simular
     * @return true se gerou resultado, false se não gerou
     */
    public boolean gerarResultado(PolarizacaoPorReflexao pr){
        return s.gerarImagem(pr);
    }
    
    /**
     * Adiciona os resultados obtidos na simualação à ListaEstatistica para fins de estatística
     * @param pr polarização por reflexão simulada
     * @return true se adicionou resultado à lista, caso contrário false
     */
    public boolean addEstatisticaALista(PolarizacaoPorReflexao pr){
        return s.getListaEstatistica().addPolarizacaEstatistica(pr);
    }
            
}
