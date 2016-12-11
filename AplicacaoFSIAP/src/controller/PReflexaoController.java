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
import aplicacaofsiap.Simulacao;

/**
 * Classe que coordena as operações relacionadas com a simulação da Polarização por Reflexão (Brewster)
 * @author Diana Silva
 */
public class PReflexaoController {
    
    private static LightGo lg;
    private PolarizacaoPorReflexao pr;
    private  Simulacao s;
    
    /**
     *  Constrói uma instância do controller com a simulacao e polarizacao reflexao passados 
     * como parâmetros
     * @param lg os dados da aplicação
     * @param simulacao simulacao
     */
    public PReflexaoController(LightGo lg, Simulacao simulacao){
        this.lg=lg;
        this.s=simulacao;
        pr=s.getPolarizacaoPorReflexao();
    }
    
    /**
     * Devolve a lista de meios/materiais guardados na LightGo
     * @return lista de meios/materiais de reflexão
     */
    public ListaMeiosReflexao getListaMeios(){
        return lg.getListaMeios();
    }
    
    /**
     * Devolve o ângulo do feixe de luz incidente
     * @return ângulo do feixe de luz incidente
     */
    public double getAnguloIncidente(){
        return pr.getF_incidente().getAngulo();
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

    public Simulacao getSimulacao() {
        return s;
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
     * Altera a intensidade do feixe de luz incidente
     * @param intensidade intensidade do feixe de luz incidente
     * @return true se alterou, false se não alterou
     */
    public boolean setIntensidade(double intensidade){
        return pr.getFeixeDeLuzIncidente().setIntensidadeValidacao(intensidade);
    }
    
    /**
     * Gera o resultado da simulação da reflexão por reflexão
     * @return true se gerou resultado, false se não gerou
     */
    public boolean gerarResultado(){
        //s.gerarImagem(pr);
        return pr.gerarResultado();
                
    }
    
    /**
     * Adiciona os resultados obtidos na simualação à Estatistica para fins de estatística
     * @return true se adicionou resultado à lista, caso contrário false
     */
    public boolean addListaSimulacoes(){
        return lg.getListaSimulacoes().adicionarSimulacao(s);
    }            
}
