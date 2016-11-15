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
public class FeixeIncidente extends FeixeDLuz{
     
    public FeixeIncidente(TipoDLuz tipo, double intensidade, double angulo) {
        super(tipo, intensidade, angulo);
    }
        
    public FeixeIncidente() {
        super(TipoDLuz.NAO_POLARIZADA,0,0);
    }

    @Override
    public String toString() {
        return "FeixeIncidente{" + '}';
    }

    
}
