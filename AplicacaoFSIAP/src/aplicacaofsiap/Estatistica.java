/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
import java.util.ArrayList;

/**
 ** * Classe para gerir e guardar as informações necessárias para gerar a estatística 
 * relativa às polarizações simuladas. 
 * @author Diana Silva
 */
public class Estatistica {

    private ArrayList<PolarizacaoPorReflexao> listaEstatistica;
    
     /**
     * Construtor relativo à lista de estatísticas
     */
    public Estatistica(){
        listaEstatistica = new ArrayList<>();
    }
    
    /**
     * Devolve a lista de polarizações simuladas
     * */
    public ArrayList<PolarizacaoPorReflexao> getListaEstatistica(){
        return listaEstatistica;
    }
    
    /**
     * Adiciona a polarização passada por parâmetro à lista
     * @param pr polarização simulada
     * @return true se adicionado, false em caso contrário
     */    
    public boolean addPolarizacaEstatistica(PolarizacaoPorReflexao pr) {
      if(validaEstatistica(pr))
          return listaEstatistica.add(pr);
      return false;      
    }
    
    
    private boolean validaEstatistica(PolarizacaoPorReflexao pr){
        return !listaEstatistica.contains(pr);
    }
    
}
