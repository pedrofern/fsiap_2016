/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.Simulacao;

/**
 *
 * @author Pedro Fernandes
 */
public class CarregarFicheiroController {
    
    private Simulacao simulacao;
    
    public CarregarFicheiroController(Simulacao simulacao){
        this.simulacao=simulacao;
    }
    
    public void carregaMeios(){
        
// *************************  implementar    ***************
        simulacao.getPolarizacaoPorReflexao().getListaMeios();
    }
    
}
