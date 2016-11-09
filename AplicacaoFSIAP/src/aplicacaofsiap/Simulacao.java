/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import java.io.Serializable;

/**
 * Classe principal da aplicação que tem o objectivo de simular experiências 
 * de reflexao e absorção
 * 
 * @author Pedro Fernandes
 */
public class Simulacao implements Serializable{
    
    PolarizacaoPorReflexao ppr;
    
    public Simulacao(){
        ppr = new PolarizacaoPorReflexao();
    }
    
    public PolarizacaoPorReflexao getPolarizacaoPorReflexao(){
        return ppr.getPolarizacaoPorReflexao();
    }
    
    
}
