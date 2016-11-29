/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

/**
 * Esta classe permite representar uma Lente
 * @author Helder, Gonçalo
 */
public abstract class Lente {

    /**
     * O ângulo em graus relativamente ao eixo de transmissão da lente.
     */
    private double angulo_emGraus;

    /**
     * O ângulo por omissão relaticamente ao eixo de transmissão da lente.
     */
    private final static double ANG_POR_OMISSAO = 0;

    /**
     * Permite a instanciação de uma lente
     * @param angulo_emGraus novo angulo em graus
     */
    public Lente(double angulo_emGraus) {
        this.angulo_emGraus = angulo_emGraus;
    }

    /**
     * Construtor vazio que permite a instânciação de uma lente com o ângulo por omissão cujo valor é 0 (zero).
     */
    public Lente() {
        this.angulo_emGraus = ANG_POR_OMISSAO;
    }

    /**
     * Devolve o angulo em graus da instância de lente.
     * @return o angulo em graus da instância de lente.
     */
    public double getAngulo_emGraus() {
        return angulo_emGraus;
    }

    /**
     * Caso o valor do ângulo esteja em graus, modifica o ângulo em graus da instância de lente.
     * @param angulo_emGraus o novo ângulo em graus da instância de lente
     */
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
