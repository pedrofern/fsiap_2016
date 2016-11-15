/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

/**
 *
 * @author Helder
 */
public class Simulacao {

    private TipoDPolarizacao tipoDPolarizacao;

    private Polarizacao polarizacao;

    public Simulacao(TipoDPolarizacao tipoDPolarizacao) {
        this.tipoDPolarizacao = tipoDPolarizacao;
        if (this.tipoDPolarizacao == TipoDPolarizacao.ABSORCAO) {
            this.polarizacao = new PolarizacaoPorAbsorcao();
        } else if (this.tipoDPolarizacao == TipoDPolarizacao.REFLEXAO) {
            // this.polarizacao = new PolarizacaoPorREFLEXAO();
        }
    }

    public TipoDPolarizacao getTipoDPolarizacao() {
        return tipoDPolarizacao;
    }

    public void setTipoDPolarizacao(TipoDPolarizacao tipoDPolarizacao) {
        this.tipoDPolarizacao = tipoDPolarizacao;
    }

    public Polarizacao getPolarizacao() {
        return polarizacao;
    }

    public void setPolarizacao(Polarizacao polarizacao) {
        this.polarizacao = polarizacao;
    }

    @Override
    public String toString() {
        return "Simulacao{" + "tipoDPolarizacao=" + tipoDPolarizacao + '}';
    }

    public double obterIntensidadeDFeixeAposPolarizador() {
        return this.getPolarizacao().getF_incidente().getIntensidade() / 2;
    }
    
     public double obterAnguloEntrePolarizadorEAnalisador(){
         double angulo = 0;
          //metodo incompleto, terminar  
         if(this.getTipoDPolarizacao()==TipoDPolarizacao.ABSORCAO){
             PolarizacaoPorAbsorcao polar_Absor = (PolarizacaoPorAbsorcao)this.getPolarizacao();
             angulo = polar_Absor.getAnalisador().getAngulo_emGraus();
         }
         return angulo;
     }
     
    public double obterIntensidadeDFeixeResultante_AposAnalisador(double anguloEntreLentes) {
        return this.obterIntensidadeDFeixeAposPolarizador()
                * Math.pow(Math.cos(Math.toRadians(anguloEntreLentes)), 2);
    }
    
    public String realizarPolarizAbsor_obterResultados(){        
        String resultados = " Intensidade Feixe Incidente: " +
                this.getPolarizacao().getF_incidente().getIntensidade() +
                "\n Intensidade Feixe Intermédio: " +
                this.obterIntensidadeDFeixeAposPolarizador() +
                "\n Ângulo entre lentes: " +
                this.obterAnguloEntrePolarizadorEAnalisador() +                
                "º\n Intensidade Feixe Resultante: " +
                this.obterIntensidadeDFeixeResultante_AposAnalisador(this.obterAnguloEntrePolarizadorEAnalisador());
        return resultados;
    }

}
