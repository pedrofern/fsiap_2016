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
 * @author Pedro Fernandes, Diana Silva
 */
public class Simulacao implements Serializable{
    
    /**
     * Lista de meios para realizar a simulação das polarizações
     */
    ListaMeiosReflexao listaMeiosReflexao;
    
    /**
     * Lista para guardar a informação necessária para a geração de estatísticas
     */
    ListaEstatistica listaEstatistica;
    
    /**
     * Lista para guardar as simulações relativas à polarização de Brewster
     */
    ListaPReflexao listaPReflexao;
    
    /**
     * Lista para guardar as simulações relativas à polarização de Mallus
     */
    ListaPAbsorcao listaPAbsorcao;
    
    /**
     *  Constrói uma instância de Simulacao criando as listas necessárias para
     * a simulação de polarizações
     */
    public Simulacao(){
        listaMeiosReflexao=new ListaMeiosReflexao();
        listaEstatistica=new ListaEstatistica();
        listaPAbsorcao=new ListaPAbsorcao();
        listaPReflexao=new ListaPReflexao();
    }
    
    /**
     * Devolve a lista de meios para realizar a simulação 
     * @return lista de meios 
     */
    public ListaMeiosReflexao getListaMeios(){
        return listaMeiosReflexao;
    }

    /**
     * Devolve a lista de polarizações simuladas (sem repetição)
     * @return lista de polarizações simuladas
     */
    public ListaEstatistica getListaEstatistica(){
        return listaEstatistica;
    }
    
    /**
     * Devolve a lista de polarizações por absorção
     * @return lista de polarização Mallus
     */
    public ListaPAbsorcao getListaPAbsorcao(){
        return listaPAbsorcao;
    }
    
    /**
     * Devolve a lista de polarizações por reflexão
     * @return lista de polarização Brewster
     */
    public ListaPReflexao getListaPReflexao(){
        return listaPReflexao;
    }
    
    /**
     * Gera output com imagem ilustrativa da polarização simulada
     */
    public boolean gerarImagem(PolarizacaoPorReflexao pr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
