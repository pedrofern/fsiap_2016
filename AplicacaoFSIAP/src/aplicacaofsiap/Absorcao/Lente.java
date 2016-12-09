/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

/**
 * Esta classe permite representar uma Lente.
 *
 * @author Helder, Gonçalo
 */
public abstract class Lente {

    /**
     * O ângulo de rotação da lente relativamente ao eixo de transmissão
     * vertical, em graus.
     */
    private double angulo_emGraus;

    /**
     * O ângulo de rotação da lente relativamente ao eixo de transmissão
     * vertical, por omissão (em graus).
     */
    private final static double ANG_POR_OMISSAO = 0;

    /**
     * Permite a instanciação de uma lente, passando por parâmetro o ângulo de
     * rotação da lente em graus.
     *
     * @param angulo_emGraus o ângulo de rotação da lente em graus
     */
    public Lente(double angulo_emGraus) {
        this.angulo_emGraus = angulo_emGraus;
    }

    /**
     * Construtor vazio que permite a instanciação de uma lente com o ângulo por
     * omissão cujo valor é 0 (zero).
     */
    public Lente() {
        this.angulo_emGraus = ANG_POR_OMISSAO;
    }

    /**
     * Devolve o angulo em graus da instância de lente.
     *
     * @return o angulo em graus da instância de lente.
     */
    public double getAngulo_emGraus() {
        return angulo_emGraus;
    }

    /**
     * Modifica o ângulo em graus da instância de lente, caso o seu valor seja
     * válido.
     *
     * @param angulo_emGraus o novo ângulo em graus da instância de lente
     */
    public void setAngulo_emGraus(double angulo_emGraus) {
        if (validaAngulo_emGraus(angulo_emGraus)) {
            this.angulo_emGraus = angulo_emGraus;
        }
    }
    
        /**
     * Valida o angulo em graus. Se o angulo se encontrar no intervalo [-90-90]
     * retorna true, senão retorna false.
     *
     * @param angulo_emGraus o angulo em graus a validar
     * @return
     */
    public static boolean validaAngulo_emGraus(double angulo_emGraus) {
        return ((angulo_emGraus >= -90) && (angulo_emGraus <= 90));
    }

    /**
     * Devolve a descrição textual de uma lente.
     *
     * @return a descrição textual de uma lente
     */
    @Override
    public String toString() {
        return "Lente{" + "angulo_emGraus=" + angulo_emGraus + '}';
    }

}
