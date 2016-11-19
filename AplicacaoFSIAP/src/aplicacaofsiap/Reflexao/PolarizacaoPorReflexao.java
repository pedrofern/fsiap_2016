/* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Reflexao;

import aplicacaofsiap.FeixeDLuz;
import aplicacaofsiap.FeixeDLuzIncidente;
import aplicacaofsiap.FeixeDLuzResultante;
import aplicacaofsiap.Polarizacao;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que permite gerir e guardar informações relativas à simulação da  
 * polarização segundo a Lei de Brewster.
 * 
 * @author  Diana Silva, Pedro Fernandes
 */
public class PolarizacaoPorReflexao extends Polarizacao implements Serializable{
    
    /**
     * os meios/materiais de onde o feixe de luz surge (meio1) e onde vai incidir e refletir (meio2)
     */
    private MeioReflexao meio1,meio2;
    /**
     * os feixes luz de resultantes (resultante da reflexão e da refração)
     */
    private FeixeDLuzResultante feixeReflexao, feixeRefracao;
    
    /**
     * ângulo de Brewster
    */
    private double anguloBrewster;
    
    /**
     * Constrói uma instância de PolarizacaoPorReflexao, recebendo o feixe de luz
     * incidentes e os meios de reflexão por parâmetro
     */
    public PolarizacaoPorReflexao(FeixeDLuzIncidente f_incidente,MeioReflexao meio1, MeioReflexao meio2, FeixeDLuzResultante feixeReflexao, FeixeDLuzResultante feixeRefracao, double angulo){
        super(f_incidente);
        this.meio1=meio1;
        this.meio2=meio2;
        this.feixeReflexao=feixeReflexao;
        this.feixeRefracao=feixeRefracao;
        this.anguloBrewster=angulo;
    }
    
    
    /**
     * Constrói uma instância de PolarizacaoPorReflexao com valores por omissão
     */
    public PolarizacaoPorReflexao(){
        super();
        meio1=new MeioReflexao();
        meio2=new MeioReflexao();
        feixeReflexao=new FeixeDLuzResultante();
        feixeReflexao.setTipo(FeixeDLuz.TipoDLuz.NAO_POLARIZADA);
        feixeRefracao=new FeixeDLuzResultante();
        feixeRefracao.setTipo(FeixeDLuz.TipoDLuz.NAO_POLARIZADA); 
        anguloBrewster=-1;
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
     * @return o meio de reflexÃ£o
     */
    public MeioReflexao getMeioPolarizacao2(){
        return meio2;
    }
    
    /**
     * Devolve  feixe de luz incidente
     * @return o feixe luz incidente
     */
    public FeixeDLuzIncidente getFeixeDeLuzIncidente(){
        return super.getF_incidente();
    }

    /**
     * Retorna o Ã¢ngulo da reflexão
     * @return Ã¢ngulo da reflexão
     */
    public double getFeixeReflexao(){
        return feixeReflexao.getAngulo();
    }
    
    /**
     * Retorna o Ã¢ngulo do feixe de refracão
     * @return Ã¢ngulo do feixe de refraÃcão
     */
    public double getFeixeRefracao(){
        return feixeRefracao.getAngulo();
    }
    
    /**
     * Retorna o Ã¢ngulo de Brewster
     * @return Ã£ngulo de Brewster
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
     * Valida se a Polarizaçã+PorReflexão tem os meios necessários para a simulação
     * @return true se a polarização tem os meios necessÃ¡rios, caso contrário false
     */
    public boolean validaMaterial(){
        return meio1!=null && meio2!=null;
    }
    
      /**
     * Valida se a PolarizaçãooPorReflexão tem o ângulo de incidência válido
     * @return true se o ângulo é válido, caso contrário false
     */
    public boolean validaAngulo(){
        return super.getF_incidente().getAngulo()>0 && super.getF_incidente().getAngulo()<=360;
    }
    
    /**
     * Gera o resultado da simulação da polarização segundo a lei de Brewster
     * @return true se criou os dois feixes de luz resultantes e o ângulo de Brewster, caso contrário false
     */
    public boolean gerarResultado(){
  
        calcularAnguloReflexaoBrewster(super.getF_incidente().getAngulo(), meio1, meio2);

        calcularAnguloRefracao(meio1.getIndiceRefracao(), meio2.getIndiceRefracao(), super.getF_incidente().getAngulo());
        
        calcularAnguloBrewster(meio1.getIndiceRefracao(), meio2.getIndiceRefracao());
        
        if(anguloBrewster==feixeRefracao.getAngulo()) feixeRefracao.setTipo(FeixeDLuz.TipoDLuz.POLARIZADA);
        
        return feixeReflexao.getAngulo()!=0 && feixeRefracao.getAngulo()!=0 && anguloBrewster!=-1;
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
        
        return meio1.equals(outraPolarizacao.getMeioPolarizacao1()) && meio2.equals(outraPolarizacao.getMeioPolarizacao2());
    }
     
     
     /**
     * Calcula o ângulo do feixe de reflexão
     * @param anguloIncidencia ângulo do feixe de luz de incidência
     */
    public void calcularAnguloReflexaoBrewster(double anguloIncidencia, MeioReflexao meio1, MeioReflexao meio2) {
        //se forem 2 materiais diferentes
        if(!meio1.equals(meio2))
            feixeReflexao.setAngulo(anguloIncidencia);
        else
            feixeReflexao.setAngulo(anguloIncidencia+90);
    }

    /**
     * 
     * @param n1 índice de refração do meio externo
     * @param n2 ínndice de refração do meio a incidir
     * @return Ã¢ngulo de brewster
     */
    public void calcularAnguloBrewster(double n1, double n2) {
       //quando incidimos a reflexão no ar, não há polarização
       if(n1!=n2 && n2!=1){
           //angulo brewster=arctg(n2/n1)
            double brewster=Math.atan(n2/n1);
            //converter o ângulo de graus para radianos (n2/n1)
            anguloBrewster=Math.toDegrees(brewster);         
            
       //se os 2 materiais forem iguais não há polarização 
       }else
          anguloBrewster=0;      
    }

    public void calcularAnguloRefracao(double n1, double n2, double angReflexao) {
       //quando incidimos a reflexão no ar, não há refração
       if(n1!=n2 && n2!=1){
           //n1senOreflexao=n2sen0refracao   logo 0refracao= (n1.sen0reflexao)/n2              
          //quando Ã© superior a 60 Agua-Vidro da erro
                feixeRefracao.setAngulo(n1*Math.toDegrees((Math.asin(Math.toRadians(angReflexao))))/n2); 
        
       //se os 2 materiais forem iguais não há refração
       }else
           feixeRefracao.setAngulo(0);
       
    }
     /**
      * Devolve a descrição textual da polarização por reflexão
      * @return descrição textual da polarização por reflexão
      */
    @Override
     public String toString(){
         return "Polarização por reflexão: " + "\tmeio1: " + meio1 + "\tmeio2: " + meio2 + "\tÂngulo de incidência: " + super.getF_incidente().getAngulo();
     }
    
}
