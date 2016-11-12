/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que identifica uma polarizao por reflexão
 * 
 * @author Pedro Fernandes, Diana Silva (ListaEstatistica)
 */
public class PolarizacaoPorReflexao implements Serializable{
    
    private ListaMeiosReflexao listaMeiosReflexao;
    private List<FeixeDeLuzResultante> resultados;
    
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

    public boolean setMeioReflexao1(MeioReflexao meio1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean setMeioReflexao2(MeioReflexao meio2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean setAngulo(double angulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean validaMaterial(MeioReflexao meio){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean gerarResultado(){
        List<FeixeDeLuzResultante> resultados=new ArrayList<>();
        //criar o feixe de luz de reflecão
        //f1.calcularIntensidade
        //f1.calcularAnguloRelfexao
        //f2.calcularAnguloRefracoa
        //resultados.add(e);
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }
    
}
