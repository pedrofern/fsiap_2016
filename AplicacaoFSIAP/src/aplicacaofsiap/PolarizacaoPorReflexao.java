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

    public boolean setMeioReflexao1(MeioReflexao meio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean setMeioReflexao2(MeioReflexao meio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean setAngulo(double angulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
