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
public abstract class Lente {

    private double angulo_emGraus;

    private final static double ANG_POR_OMISSAO = 0;

    public Lente(double angulo_emGraus) {
        this.angulo_emGraus = angulo_emGraus;
    }

    public Lente() {
        this.angulo_emGraus = ANG_POR_OMISSAO;
    }

    public double getAngulo_emGraus() {
        return angulo_emGraus;
    }

    public void setAngulo_emGraus(double angulo_emGraus) {
        if (validaAngulo_emGraus(angulo_emGraus)) {
            this.angulo_emGraus = angulo_emGraus;
        }
    }

    public static boolean validaAngulo_emGraus(double angulo_emGraus) {
        return (angulo_emGraus >= 0 || angulo_emGraus <= 360);
    }

    @Override
    public String toString() {
        return "Lente{" + "angulo_emGraus=" + angulo_emGraus + '}';
    }

}
