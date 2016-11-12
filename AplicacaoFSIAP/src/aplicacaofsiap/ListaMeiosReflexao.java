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
 * Classe que guarda os objectos Meios Reflexão
 * 
 * @author Pedro Fernandes
 */
public class ListaMeiosReflexao implements Serializable{
    
    private ArrayList<MeioReflexao> listaMeios;
    
    /**
     * Construtor relativo a lista de Meios Reflexao
     */
    public ListaMeiosReflexao(){
        listaMeios = new ArrayList<>();
    }
    
    /**
     * Metodo que retorna o meio na posicao do indice passado por parametro
     *
     * @param indice indice
     * @return o meio na posicao do indice passado por parametro
     */
    public MeioReflexao obterMeioReflexao(int indice) {
        return listaMeios.get(indice);
    }

    /**
     * Metodo que vai retorna o array de meios
     *
     * @return o array de meios
     */
    public MeioReflexao[] getArray() {
        return listaMeios.toArray(new MeioReflexao[listaMeios.size()]);
    }

    /**
     * Metodo que vai retorna a lista de meios
     *
     * @return lista de meios
     */
    public List<MeioReflexao> getListaMeios() {
        return listaMeios;
    }

    /**
     * Metodo que vai adicionar o meio passado por parametro a lista
     *
     * @param meio meio
     * @return true se adicionar false em caso contrario
     */
    private boolean adicionaMeio(MeioReflexao meio) {
        if (validaMeio(meio)) {
            return listaMeios.add(meio);
        }
        return false;
    }
    /**
     * valida se meio passado por parametro ja existe na lista
     * @param meio
     * @return false se existir na lista, true se nao existir
     */
    private boolean validaMeio(MeioReflexao meio){
        return !listaMeios.contains(meio);
    }
    
    public boolean registaMeio(MeioReflexao m){
        return adicionaMeio(m);
    }

    /**
     * Metodo que vai remover o meio passado por parametro a lista
     *
     * @param meio meio
     * @return true se remover false em caso contrario
     */
    public boolean removerMeio(MeioReflexao meio) {
        return listaMeios.remove(meio);
    }

    /**
     * Metodo que vai retorna o tamanho da lista
     *
     * @return o tamanho da lista
     */
    public int tamanho() {
        return this.listaMeios.size();
    }

     /**
     * Metodo que vai verificar se a lista de meio contem o meio passado por parametro
     *
     * @param meio meio
     * @return true se existir false em caso contrario
     */
    public boolean contem(MeioReflexao meio) {
        return listaMeios.contains(meio);
    } 
    
}
