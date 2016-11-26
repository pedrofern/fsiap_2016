/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

/**
 *
 * @author Helder
 */
public class FeixeDLuzIncidente extends FeixeDLuz {

    public FeixeDLuzIncidente(TipoDLuz tipo, double intensidade, double angulo) {
        super(tipo, intensidade, angulo);
    }

    public FeixeDLuzIncidente() {
        super();
    }

    public FeixeDLuzIncidente(double intensidade) {
        super(TipoDLuz.NAO_POLARIZADA, intensidade, 0);
    }

    @Override
    public String toString() {
        return "FeixeIncidente{" + '}';
    }

}
