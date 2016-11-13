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
    
    /**
     * Calcula o ângulo do feixe de reflexão
     * @param anguloIncidencia ângulo do feixe de luz de incidência
     */
    public void calcularAnguloReflexaoBrewster(double anguloIncidencia, MeioReflexao meio1, MeioReflexao meio2) {
        //se forem 2 materiais diferentes
        if(!meio1.equals(meio2))
                anguloResultante=anguloIncidencia;
        else
            anguloResultante=anguloIncidencia+90;
    }

    /**
     * 
     * @param n1 índice de refração do meio externo
     * @param n2 índice de refração do meio a incidir
     */
    public double calcularAnguloRefracaoBrewster(double n1, double n2) {
       //quando incidimos a reflexão no ar, não há polarização
       if(n1!=n2 && n2!=1){
           //angulo brewster=arctg(n2/n1)
            double brewster=Math.atan(n2/n1);
            //converter o ãngulo de graus para radianos (n2/n1)
            anguloResultante=Math.toDegrees(brewster);         
            
       //se os 2 materiais forem iguais não há polarização 
       }else
           anguloResultante=0;
       return anguloResultante;
       
    }

    public void calcularAnguloRefracao(double n1, double n2, double angReflexao) {
       //quando incidimos a reflexão no ar, não há refração
       if(n1!=n2 && n2!=1){
           //n1senOreflexao=n2sen0refracao   logo 0refracao= (n1.sen0reflexao)/n2              
          //quando é superior a 60 Agua-Vidro da erro
                anguloResultante=n1*Math.toDegrees((Math.asin(Math.toRadians(angReflexao))))/n2; 
        
       //se os 2 materiais forem iguais não há refração
       }else
           anguloResultante=0;
       
    }

}
