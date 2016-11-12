/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.ListaMeiosReflexao;
import aplicacaofsiap.Simulacao;
import aplicacaofsiap.PolarizacaoPorReflexao;
import aplicacaofsiap.ListaPReflexao;
import aplicacaofsiap.MeioReflexao;

/**
 * Classe que coordena as operações relacionadas com a simulação da Polarização por Reflexão (Brewster)
 * @author Diana Silva
 */
public class PReflexaoController {
    
    
    private static Simulacao s;
    private static PolarizacaoPorReflexao pr;
    
    public PReflexaoController(Simulacao simulacao, PolarizacaoPorReflexao polarizacaoReflexao){
        s=simulacao;
        pr=polarizacaoReflexao;
    }
    
    public ListaMeiosReflexao getListaMeios(){
        return s.getListaMeios();
    }
    
    public boolean setMeioReflexao1(MeioReflexao meio1){
        return pr.setMeioReflexao1(meio1);
    }
    
    public boolean setMeioReflexao2(MeioReflexao meio2){
        return pr.setMeioReflexao2(meio2);
    }
    
    public boolean setAngulo(double angulo){
        return pr.setAngulo(angulo);
    }
    
    public boolean gerarResultado(PolarizacaoPorReflexao pr){
        return s.gerarImagem(pr);
    }
    
    public boolean addEstatisticaALista(PolarizacaoPorReflexao pr){
        return s.getListaEstatistica().addPolarizacaEstatistica(pr);
    }
            
}
