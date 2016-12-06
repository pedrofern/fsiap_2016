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
public class FeixeDLuzResultante extends FeixeDLuz {

    public FeixeDLuzResultante(double intensidade, double angulo) {
        super(TipoDLuz.POLARIZADA, intensidade, angulo);
    }

    public FeixeDLuzResultante() {
        super(TipoDLuz.POLARIZADA, 0, 0);
    }
    
        public FeixeDLuzResultante(TipoDLuz tipo) {
        super(tipo, 0, 0);
    }

    public FeixeDLuzResultante(double intensidade) {
        super(TipoDLuz.POLARIZADA, intensidade, 0);
    }

    @Override
    public String toString() {
        return "FeixeResultante{" + '}';
    }

}
