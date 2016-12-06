/* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Reflexao;

import aplicacaofsiap.FeixeDLuz;
import aplicacaofsiap.FeixeDLuzIncidente;
import aplicacaofsiap.FeixeDLuzResultante;
import aplicacaofsiap.Polarizacao;
import java.io.Serializable;

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
    private FeixeDLuzResultante feixeReflexao1, feixeReflexao2, feixeRefracao;
    
    /**
     * ângulo de Brewster
    */
    private double anguloBrewster;
    
    
    /**
     * Constrói uma instância de PolarizacaoPorReflexao, recebendo o feixe de luz
     * incidentes e os meios de reflexão por parâmetro
     */
    public PolarizacaoPorReflexao(FeixeDLuzIncidente f_incidente,MeioReflexao meio1, MeioReflexao meio2, FeixeDLuzResultante feixeReflexao1, FeixeDLuzResultante feixeReflexao2, FeixeDLuzResultante feixeRefracao, double angulo){
        super(f_incidente);
        this.meio1=meio1;
        this.meio2=meio2;
        this.feixeReflexao1=feixeReflexao1;
        this.feixeReflexao2=feixeReflexao2;
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
        feixeReflexao1=new FeixeDLuzResultante(FeixeDLuz.TipoDLuz.NAO_POLARIZADA);
        feixeReflexao2=new FeixeDLuzResultante(FeixeDLuz.TipoDLuz.NAO_POLARIZADA);
        feixeRefracao=new FeixeDLuzResultante(FeixeDLuz.TipoDLuz.NAO_POLARIZADA);
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
     * Retorna o feixe da reflexão (paralela)
     * @return feixe de reflexão resultante
     */
    public FeixeDLuzResultante getFeixeReflexao1(){
        return feixeReflexao1;
    }
    
     /**
     * Retorna o feixe da reflexão (perpendicular)
     * @return feixe de reflexão resultante
     */
    public FeixeDLuzResultante getFeixeReflexao2(){
        return feixeReflexao2;
    }
    
    /**
     * Retorna o ângulo do feixe de refracão
     * @return ângulo do feixe de refraÃcão
     */
    public FeixeDLuzResultante getFeixeRefracao(){
        return feixeRefracao;
    }
    
    /**
     * Retorna o ângulo de Brewster
     * @return ângulo de Brewster
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
        return getFeixeDeLuzIncidente().getAngulo()>0 && getFeixeDeLuzIncidente().getAngulo()<=90;
    }
    
    /**
     * Gera o resultado da simulação da polarização segundo a lei de Brewster
     * @return true se criou os dois feixes de luz resultantes e o ângulo de Brewster, caso contrário false
     */
    public boolean gerarResultado(){
  
        calcularAnguloReflexaoBrewster(getFeixeDeLuzIncidente().getAngulo(), meio1, meio2);

        calcularAnguloRefracao(meio1.getIndiceRefracao(), meio2.getIndiceRefracao(), getFeixeDeLuzIncidente().getAngulo());
        
        calcularAnguloBrewster(meio1.getIndiceRefracao(), meio2.getIndiceRefracao());
        
        calcularIntensidadeReflexaoPerpendicular(meio1.getIndiceRefracao(), meio2.getIndiceRefracao(), getFeixeDeLuzIncidente().getAngulo(), getFeixeRefracao().getAngulo());
        calcularIntensidadeReflexaoParalela(meio1.getIndiceRefracao(), meio2.getIndiceRefracao(), getFeixeDeLuzIncidente().getAngulo(), getFeixeRefracao().getAngulo());  
        
        calcularIntensidadeRefracao(meio1.getIndiceRefracao(), meio2.getIndiceRefracao(), getFeixeDeLuzIncidente().getAngulo(), getFeixeRefracao().getAngulo());  
        
        //Se ângulo de brewster for igual ao ângulo de refração -> Luz Polarizada
        if(anguloBrewster==feixeRefracao.getAngulo()) feixeRefracao.setTipo(FeixeDLuz.TipoDLuz.POLARIZADA);
        
        return feixeReflexao1.getAngulo()!=0 && feixeRefracao.getAngulo()!=0 && anguloBrewster!=-1;
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
        if(!meio1.equals(meio2)){
            feixeReflexao1.setAngulo(anguloIncidencia);
            feixeReflexao2.setAngulo(anguloIncidencia);
        }else{
                feixeReflexao1.setAngulo(anguloIncidencia+90);
                feixeReflexao2.setAngulo(anguloIncidencia+90);
        }
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
 
       if(n1!=n2){
           //n1senOreflexao=n2sen0refracao   logo 0refracao= (n1.sen0reflexao)/n2              
          //quando Ã© superior a 60 Agua-Vidro da erro
                feixeRefracao.setAngulo(n1*Math.toDegrees((Math.asin(Math.toRadians(angReflexao))))/n2); 
        
       //se os 2 materiais forem iguais não há refração
       }else
           feixeRefracao.setAngulo(0);
    }
    
    /**
     * Devolve a intensidade resulante do feixe de reflexão na polarização perpendicular
     * @param n1 índice de refração do meio de origem
     * @param n2 índice de refração do meio de incidência
     * @param angIncidencia ângulo do feixe de incidência
     * @param angRefracao ângulo do feixe de refração resultante
     */
     public void calcularIntensidadeReflexaoPerpendicular(double n1, double n2, double angIncidencia, double angRefracao) {
      
        if(n1!=n2){
          //n1cos(AngIncidencia) - n2cos(angRefratado) / n1cos(AngInc) + n2cos(AngRefratado)
          double f1=n1*Math.toDegrees(Math.acos(Math.toRadians(angIncidencia)));
          double f2=n2*Math.toDegrees(Math.acos(Math.toRadians(angRefracao)));
          double res= (f1-f2)/(f1+f2);
          feixeRefracao.setIntensidade(res);  

       //se os 2 materiais forem iguais não há refração
       }else
           feixeReflexao2.setIntensidade(0);
    }
     
     /**
     * Devolve a intensidade resulante do feixe de reflexão na polarização paralela
     * @param n1 índice de refração do meio de origem
     * @param n2 índice de refração do meio de incidência
     * @param angIncidencia ângulo do feixe de incidência
     * @param angRefracao ângulo do feixe de refração resultante
     */
     public void calcularIntensidadeReflexaoParalela(double n1, double n2, double angIncidencia, double angRefracao) {
      
        if(n1!=n2){
          //n2cos(AngIncidencia) - n1cos(angRefratado) / n1cos(AngInc) + n2cos(AngRefratado)
          double f1=n2*Math.toDegrees(Math.acos(Math.toRadians(angIncidencia)));
          double f2=n1*Math.toDegrees(Math.acos(Math.toRadians(angRefracao)));
          double f3=n1*Math.toDegrees(Math.acos(Math.toRadians(angIncidencia)));
          double f4=n2*Math.toDegrees(Math.acos(Math.toRadians(angRefracao)));
          double res= (f1-f2)/(f3+f4);
          feixeReflexao1.setIntensidade(res);  

       //se os 2 materiais forem iguais não há refração
       }else
           feixeReflexao1.setIntensidade(0);
    }
     
     
    /**
     * Devolve a intensidade resulante do feixe de refracao
     * @param n1 índice de refração do meio de origem
     * @param n2 índice de refração do meio de incidência
     * @param angIncidencia ângulo do feixe de incidência
     * @param angRefracao ângulo do feixe de refração resultante
     */
     public void calcularIntensidadeRefracao(double n1, double n2, double angIncidencia, double angRefracao) {
      
        if(n1!=n2){
          //2x n1 x cos(AngIncidencia) / (n1cos(angIncid) + n2cos(AngRef)
          double f1=2*n1*Math.toDegrees(Math.acos(Math.toRadians(angIncidencia)));
          double f2=n1*Math.toDegrees(Math.acos(Math.toRadians(angIncidencia)));
          double f3=n2*Math.toDegrees(Math.acos(Math.toRadians(angRefracao)));
          double res= f1/(f2+f3);
          feixeRefracao.setIntensidade(res);  

       //se os 2 materiais forem iguais não há refração
       }else
           feixeRefracao.setIntensidade(0);
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
