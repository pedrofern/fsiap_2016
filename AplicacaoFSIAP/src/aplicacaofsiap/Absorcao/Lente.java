package aplicacaofsiap.Absorcao;

/**
 * Esta classe permite representar uma Lente. Uma lente tem como atributo um
 * ângulo de rotação relativamente ao eixo de transmissão que neste contexto se
 * considera ser o eixo de transmissão vertical.
 *
 * @author Helder, Gonçalo
 */
public abstract class Lente {

    /**
     * O ângulo de rotação da lente relativamente ao eixo de transmissão
     * vertical, em graus.
     */
    private double angulo;

    /**
     * O ângulo de rotação da lente relativamente ao eixo de transmissão
     * vertical, por omissão (em graus).
     */
    private final static double ANG_POR_OMISSAO = 0;

    /**
     * Permite a instanciação de uma lente, passando por parâmetro o ângulo de
     * rotação da lente em graus.
     *
     * @param angulo o ângulo de rotação da lente em graus
     */
    public Lente(double angulo) {
        this.angulo = angulo;
    }

    /**
     * Construtor vazio que permite a instanciação de uma lente com o ângulo por
     * omissão cujo valor é 0 (zero).
     */
    public Lente() {
        this.angulo = ANG_POR_OMISSAO;
    }

    /**
     * Devolve o angulo em graus da instância de lente.
     *
     * @return o angulo em graus da instância de lente.
     */
    public double getAngulo_emGraus() {
        return angulo;
    }

    /**
     * Modifica o ângulo em graus da instância de lente, caso o seu valor seja
     * válido.
     *
     * @param angulo o novo ângulo em graus da instância de lente
     */
    public void setAngulo_emGraus(double angulo) {
        if (validaAngulo_emGraus(angulo)) {
            this.angulo = angulo;
        }
    }

    /**
     * Valida o angulo em graus. Se o angulo se encontrar no intervalo [-90-90]
     * retorna true, senão retorna false.
     *
     * @param angulo o angulo em graus a validar
     * @return
     */
    public static boolean validaAngulo_emGraus(double angulo) {
        return ((angulo >= -90) && (angulo <= 90));
    }

    /**
     * Devolve a descrição textual de uma lente.
     *
     * @return a descrição textual de uma lente
     */
    @Override
    public String toString() {
        return "Lente{" + "angulo=" + angulo + '}';
    }

}
