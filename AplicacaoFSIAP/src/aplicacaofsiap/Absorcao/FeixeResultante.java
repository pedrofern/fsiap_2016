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
public class FeixeResultante extends FeixeDLuz {

    public FeixeResultante(double intensidade, double angulo) {
        super(TipoDLuz.POLARIZADA, intensidade, angulo);
    }

    public FeixeResultante() {
        super(TipoDLuz.POLARIZADA, 0, 0);
    }

    public FeixeResultante(double intensidade) {
        super(TipoDLuz.POLARIZADA, intensidade, 0);
    }

    @Override
    public String toString() {
        return "FeixeResultante{" + '}';
    }

}
