/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
import aplicacaofsiap.Reflexao.ListaMeiosReflexao;
import java.io.Serializable;

/**
 * Classe principal da aplicação que tem o objectivo de simular experiências 
 * de reflexao e absorção
 * 
 * @author Pedro Fernandes, Diana Silva
 */
public class LightGo implements Serializable{
    
    /**
     * Lista de meios para realizar a simulação das polarizações
     */
    ListaMeiosReflexao listaMeiosReflexao;
    
    /**
     * Lista para guardar a informação necessária para a geração de estatísticas
     */
    Estatistica estatistica;

    
    /**
     * Lista para guardar as simulações das polarizações
     */
    ListaSimulacoes listaSimulacoes;
    
    /**
     *  Constrói uma instância de Simulacao criando as listas necessárias para
     * a simulação de polarizações
     */
    public LightGo(){
        listaMeiosReflexao=new ListaMeiosReflexao();
        estatistica=new Estatistica();
        listaSimulacoes=new ListaSimulacoes();
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
    public Estatistica getEstatistica(){
        return estatistica;
    }
    
    /**
     * Devolve a lista de simulações
     * @return lista de polarização 
     */
    public ListaSimulacoes getListaSimulacoes(){
        return listaSimulacoes;
    }    
    
}
