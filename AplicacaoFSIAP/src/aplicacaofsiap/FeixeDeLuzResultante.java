/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

/**
 * * * Classe que permite gerir e guardar informações relativas aos feixes de luz 
 * resultantes da simulação da polarização. 
 * @author Diana Silva
 */
public class FeixeDeLuzResultante {
    /**
     * intensidade das ondas eletromagnéticas resultantes da polarização
     */
    private double intensidade;
    /**
     * Ângulo do feixe de luz resultante relativamente ao eixo xx
     */
    private double anguloResultante;
    
   /**
     * Constrói uma instância de FeixeDeLuzIncidencia com os dados por omissão 
     * (atributos inicializados a -1000 ou "não definido)
     */
    public FeixeDeLuzResultante(){
        anguloResultante=-1000;
    }
    /**
     * Devolve o ângulo do feixe de luz resultante
     * @return the anguloResultante
     */
    public double getAnguloResultante() {
        return anguloResultante;
    }

    /**
     * Altera o ângulo do feixe de luz resultante
     * @param anguloResultante the anguloResultante to set
     */
    public void setAnguloResultante(double anguloResultante) {
        this.anguloResultante = anguloResultante;
    }  
    

    public void calcularAnguloReflexaoBrewster() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void calcularAnguloRefracaoBrewster() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
