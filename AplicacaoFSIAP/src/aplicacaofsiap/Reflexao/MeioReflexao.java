/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Reflexao;

import java.io.Serializable;

/**
 * Classe que identifica cada meio reflexao
 * 
 * @author Pedro Fernandesz
 */
public class MeioReflexao implements Serializable{
    
    private String nome;
    
    private double indice;
    
    public MeioReflexao(){        
    }
    /**
     * Construtor relativo a um Meio Reflexao
     * @param nome nome meio refracao 
     * @param indice indice refracao
     */
    public MeioReflexao(String nome, double indice){
        this.nome=nome;
        this.indice=indice;
    }

    /**
     * @return the nome meio refracao
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome meio refracao
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @return the indice refracao
     */
    public double getIndiceRefracao() {
        return indice;
    }

    /**
     * @param indice the indice refracao
     */
    public void setIndiceRefracao(double indice) {
        this.indice = indice;
    }
    
    /**
     * Metodo que vai comparar dois objetos iguais
     * @param outroObjeto
     * @return se os objetos forem iguais retorna true caso contrario false
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        MeioReflexao outroMeio = (MeioReflexao) outroObjeto;
        
        return nome.equals(outroMeio.nome);
    }
    /**
     * valida se meio pode ser inserido correctamente
     * @return 
     */
    public boolean valida(){
        //o vácuo tem o índice menor que é 1. Todos os outros materiais serão superiores
        return !(nome == null || nome.isEmpty() || indice < 1);
    }
    /**
     * metodo para imprimir os atributos dos meio reflexao
     * @return 
     */
    @Override
    public String toString(){
        return "Meio: "+ nome;
    }
}
