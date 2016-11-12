/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

/**
 * * Classe que permite gerir e guardar informações relativas ao feixe de luz 
 * incidente na polarização.
 * 
 * @author Diana Silva
 */
public class FeixeDeLuzIncidente {
    
    /**
     * tipo de ondas eletromagnéticas da luz incidente (conforme a frequência de radiação- espetro eletromagnético)
     */
    private String tipo;
    
    /**
     * intensidade das ondas eletromagnéticas
     */
    private double intensidade;
    
    /**
     * ângulo de incidência do feixe de luz em relação ao eixo xx
     */
    private double anguloDeIncidencia;
    
    /**
     * Constrói uma instância de FeixeDeLuzIncidencia com os dados por omissão 
     * (atributos inicializados a -1000 ou "não definido)
     */
    public FeixeDeLuzIncidente(){
        tipo="não definido";
        intensidade=-1000;
        anguloDeIncidencia=-1000;
    }

    /**
     * Devolve o tipo de ondas do feixe de luz
     * @return the tipo descrição textual do tipo de ondas eletromagnéticas
     */
    public String getTipo() {
        return tipo;
    }    
    
    /**
     * Devolve o ângulo de incidência do feixe de luz
     * @return the anguloDeIncidencia ângulo do feixe de luz relativamente ao eixo xx
     */
    public double getAnguloDeIncidencia() {
        return anguloDeIncidencia;
    }

    /**
     * Altera a ângulo de incidência do feixe de luz
     * @param anguloDeIncidencia the anguloDeIncidencia a alterar
     * @return true se alterou, false se não alterou
     */
    public boolean setAngulo(double anguloDeIncidencia) {
        if(validaAngulo(anguloDeIncidencia)==true)
                this.anguloDeIncidencia = anguloDeIncidencia;
        return this.anguloDeIncidencia==anguloDeIncidencia;
    }
    
    public boolean validaAngulo(double angulo){
        return angulo>=0 && angulo<=360;       
    }
    
     public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        FeixeDeLuzIncidente outroFeixe= (FeixeDeLuzIncidente) outroObjeto;
        
        return anguloDeIncidencia==outroFeixe.getAnguloDeIncidencia();
    }
    
}
