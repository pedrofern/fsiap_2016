/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import java.util.HashSet;

/**
 * Classe que permite armazenar as simulações efetuadas pelo utilizador/ficheiro
 * @author DianaSilva
 */
public class ListaPolarizacoes {
    /**
     * Lista que armazena as polarizações simuladas
     */
    private HashSet<Simulacao> listaSimulacoes;
    
    /**
     * Cria uma instãncia de listaPolarizacoes
     */
    public ListaPolarizacoes(){
        listaSimulacoes=new HashSet<>();
    }
    
    /**
     * Devolve a lista de polarizações simuladas
     * @return lista de polarizações
     */
   public HashSet getListaSimulacoes(){
       return listaSimulacoes;
   } 
   
    /**
     * Metodo que vai adicionar a polarização passada por parametro à lista
     * @param simulacao simulacao a adicionar
     * @return true se adicionar false em caso contrario
     */
    public boolean adicionarSimulacao(Simulacao simulacao){
        return listaSimulacoes.add(simulacao);
    }
    
    @Override
    public String toString(){
        String descricao="Lista de Simulações\n";
        for(Simulacao s: listaSimulacoes){
            descricao+=s.toString();
        }
        return descricao;
    } 
}