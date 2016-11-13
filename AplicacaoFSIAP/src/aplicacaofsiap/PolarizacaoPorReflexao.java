/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que permite gerir e guardar informações relativas à simulação da 
 * polarização segundo a Lei de Brewster.
 * 
 * @author  Diana Silva, Pedro Fernandes
 */
public class PolarizacaoPorReflexao implements Serializable{

    /**
     * o feixe de luz incidente
     */
    private FeixeDeLuzIncidente feixeLuzIncidente;
    /**
     * os meios/materiais de onde o feixe de luz surge (meio1) e onde vai incidir e refletir (meio2)
     */
    private MeioReflexao meio1,meio2;
    /**
     * os feixes luz de resultantes (resultante da reflexão e da refração)
     */
    private FeixeDeLuzResultante feixeReflexao, feixeRefracao;
    
    /**
     * ângulo de Brewster
    */
    private double anguloBrewster;
    
    /**
     * Constrói uma instância de PolarizacaoPorReflexao, criando os atributos
     * necessários para a simulação
     */
    public PolarizacaoPorReflexao(){
        meio1=new MeioReflexao();
        meio2=new MeioReflexao();
        feixeLuzIncidente=new FeixeDeLuzIncidente();
        feixeReflexao=new FeixeDeLuzResultante();
        feixeRefracao=new FeixeDeLuzResultante();
        anguloBrewster=0;
    }
    
    /**
     * Devolve o meio de onde vem o feixe de luz
     * @return o meio de origem
     */
    public MeioReflexao getMeioPolarizacao1(){
        return meio1;
    }
    
    /**
     * Devolve o meio onde o feixe de luz incide
     * @return o meio de reflexão
     */
    public MeioReflexao getMeioPolarizacao2(){
        return meio2;
    }
    
    /**
     * Devolve  feixe de luz incidente
     * @return o feixe luz incidente
     */
    public FeixeDeLuzIncidente getFeixeDeLuzIncidente(){
        return feixeLuzIncidente;        
    }
    
    /**
     * Retorna o ângulo da reflexão
     * @return ângulo da reflexão
     */
    public double getFeixe1(){
        return feixeReflexao.getAnguloResultante();
    }
    
    /**
     * Retorna o ângulo do feixe de refração
     * @return ângulo do feixe de refração
     */
    public double getFeixe2(){
        return feixeRefracao.getAnguloResultante();
    }
    
    /**
     * Retorna o ângulo de Brewster
     * @return ãngulo de Brewster
     */
    public double getAnguloBrewster(){
        return anguloBrewster;
    }
    
    /**
     * Altera o meio de origem do feixe de luz
     * @param meio1 meio para o qual se pretende alterar
     * @return true se alterou, caso contrário false
     */
    public boolean setMeioReflexao1(MeioReflexao meio1) {
        this.meio1.setIndiceRefracao(meio1.getIndiceRefracao());
        this.meio1.setNome(meio1.getNome());
        return this.meio1.equals(meio1);
    }

    /**
     * Altera o meio onde o feixe de luz vai incidir
     * @param meio2 meio para o qual se pretende alterar
     * @return true se alterou, caso contrário false
     */
    public boolean setMeioReflexao2(MeioReflexao meio2) {
        this.meio2.setIndiceRefracao(meio2.getIndiceRefracao());
        this.meio2.setNome(meio2.getNome());
        return this.meio2.equals(meio2);     
    }

    /**
     * Altera o ãngulo do feixe de luz de incidência
     * @param angulo ãngulo para o qual se pretende alterar
     * @return true se alterou, caso contrário false
     */
    public boolean setAngulo(double angulo) {
        return this.feixeLuzIncidente.setAngulo(angulo);
    }
    
    /**
     * Valida se a PolarizaçãoPorReflexão tem os meios necessários para a simulação
     * @return true se a polarização tem os meios necessários, caso contrário false
     */
    public boolean validaMaterial(){
        return meio1!=null && meio2!=null;
    }
    
      /**
     * Valida se a PolarizaçãoPorReflexão tem o ângulo de incidência válido
     * @return true se o ângulo é válido, caso contrário false
     */
    public boolean validaÂngulo(){
        return feixeLuzIncidente.getAnguloDeIncidencia()>=0 && feixeLuzIncidente.getAnguloDeIncidencia()<=360;
    }
    
    /**
     * Gera o resultado da simulação da polarização segundo a lei de Brewster
     * @return true se criou os dois feixes de luz resultantes, caso contrário false
     */
    public boolean gerarResultado(){
        feixeReflexao.calcularAnguloReflexaoBrewster(feixeLuzIncidente.getAnguloDeIncidencia(), meio1, meio2);

        anguloBrewster=feixeRefracao.calcularAnguloRefracaoBrewster(meio1.getIndiceRefracao(), meio2.getIndiceRefracao());
        
        feixeRefracao.calcularAnguloRefracao(meio1.getIndiceRefracao(), meio2.getIndiceRefracao(), feixeLuzIncidente.getAnguloDeIncidencia());
        
        return feixeReflexao.getAnguloResultante()!=-1000 && feixeRefracao.getAnguloResultante()!=-1000;
    }
    
    @Override
     public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        PolarizacaoPorReflexao outraPolarizacao = (PolarizacaoPorReflexao) outroObjeto;
        
        return meio1.equals(outraPolarizacao.getMeioPolarizacao1()) && meio2.equals(outraPolarizacao.getMeioPolarizacao2())
                && feixeLuzIncidente.equals(outraPolarizacao.getFeixeDeLuzIncidente());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.feixeLuzIncidente);
        hash = 89 * hash + Objects.hashCode(this.meio1);
        hash = 89 * hash + Objects.hashCode(this.meio2);
        return hash;
    }
     
     /**
      * Devolve a descrição textual da polarização por reflexão
      * @return descrição textual da polarização por reflexão
      */
    @Override
     public String toString(){
         return "Polarização por reflexão: " + "\tmeio1: " + meio1 + "\tmeio2: " + meio2 + "\tângulo de incidência: " + feixeLuzIncidente.getAnguloDeIncidencia();
     }
    
}
