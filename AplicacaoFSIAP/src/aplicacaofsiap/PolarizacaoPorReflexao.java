/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import java.io.Serializable;

/**
 * Classe que identifica uma polarizao por reflexão
 * 
 * @author Pedro Fernandes
 */
public class PolarizacaoPorReflexao implements Serializable{
    
    private ListaMeiosReflexao listaMeiosReflexao;
    
    public PolarizacaoPorReflexao(){
        listaMeiosReflexao = new ListaMeiosReflexao();
    }
    
//    public PolarizacaoPorReflexao getPolarizacaoPorReflexao(){
//// ************** alterar se necessário *************************
//        return this;
//    }
    
    public ListaMeiosReflexao getListaMeios(){
        return this.listaMeiosReflexao;
    }
    
}
