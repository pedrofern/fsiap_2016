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
        if(this.tipoDPolarizacao==TipoDPolarizacao.ABSORCAO){
            this.polarizacao = new PolarizacaoPorAbsorcao();
        } else if (this.tipoDPolarizacao==TipoDPolarizacao.REFLEXAO){
           // this.polarizacao = new PolarizacaoPorREFLEXAO();
        }
    }

    @Override
    public String toString() {
        return "Simulacao{" + "tipoDPolarizacao=" + tipoDPolarizacao + '}';
    }
    
}
