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
public class FeixeResultante extends FeixeDLuz{

    public FeixeResultante(TipoDLuz tipo, double intensidade, double angulo) {
        super(tipo, intensidade, angulo);
    }

    @Override
    public String toString() {
        return "FeixeResultante{" + '}';
    }
    
}
