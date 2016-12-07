/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.FeixeDLuzResultante;
import aplicacaofsiap.Reflexao.ListaMeiosReflexao;
import aplicacaofsiap.LightGo;
import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
import aplicacaofsiap.Reflexao.MeioReflexao;

/**
 * Classe que coordena as operações relacionadas com a simulação da Polarização por Reflexão (Brewster)
 * @author Diana Silva
 */
public class PReflexaoController {
    
    private static LightGo lg;
    private static PolarizacaoPorReflexao pr;
    
    /**
     *  Constrói uma instância do controller com a simulacao e polarizacao reflexao passados 
     * como parâmetros
     * @param lg os dados da aplicação
     * @param polarizacaoReflexao a polarização a simular
     */
    public PReflexaoController(LightGo lg, PolarizacaoPorReflexao polarizacaoReflexao){
        this.lg=lg;

        pr=polarizacaoReflexao;
        
    }
    
    /**
     * Devolve a lista de meios/materiais guardados na LightGo
     * @return lista de meios/materiais de reflexão
     */
    public ListaMeiosReflexao getListaMeios(){
        return lg.getListaMeios();
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
        return pr.getFeixeDeLuzIncidente().setAnguloValidacao(angulo);
    }
    
    /**
     * Gera o resultado da simulação da reflexão por reflexão
     * @param pr polarização a simular
     * @return true se gerou resultado, false se não gerou
     */
    public boolean gerarResultado(PolarizacaoPorReflexao pr){
        //s.gerarImagem(pr);
        return pr.gerarResultado();
                
    }
    
    /**
     * Adiciona os resultados obtidos na simualação à Estatistica para fins de estatística
     * @param pr polarização por reflexão simulada
     * @return true se adicionou resultado à lista, caso contrário false
     */
    public boolean addEstatisticaALista(PolarizacaoPorReflexao pr){
        return lg.getEstatistica().addPolarizacaEstatistica(pr);
    }
    
    public FeixeDLuzResultante  getFeixeReflexao1() {
        return pr.getFeixeReflexao1();
    }
    
    public FeixeDLuzResultante  getFeixeReflexao2() {
        return pr.getFeixeReflexao2();
    }

    public FeixeDLuzResultante getFeixeRefracao() {
        return pr.getFeixeRefracao();
    }
    
    public double getAnguloBrewster() {
        return pr.getAnguloBrewster();
    }
            
}
