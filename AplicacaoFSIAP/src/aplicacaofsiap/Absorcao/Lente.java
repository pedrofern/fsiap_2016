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

    public double obterAnguloEquivalente(double angulo) {
        double ang_reduzido_ao1o_ou4o_Quadrante;
        if (angulo <= 90 && angulo >= -90) {
            return angulo;
        } else {
            ang_reduzido_ao1o_ou4o_Quadrante = angulo;
            while (ang_reduzido_ao1o_ou4o_Quadrante > 90
                    || ang_reduzido_ao1o_ou4o_Quadrante < -90) {
                ang_reduzido_ao1o_ou4o_Quadrante
                        = ang_reduzido_ao1o_ou4o_Quadrante - 180;
            }
        }
        return ang_reduzido_ao1o_ou4o_Quadrante;
    }

    public static boolean validaAngulo_emGraus(double angulo_emGraus) {
        return ((angulo_emGraus >= -360) && (angulo_emGraus <= 360));
    }

    @Override
    public String toString() {
        return "Lente{" + "angulo_emGraus=" + angulo_emGraus + '}';
    }

}
