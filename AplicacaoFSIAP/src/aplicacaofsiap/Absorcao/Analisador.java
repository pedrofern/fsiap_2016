package aplicacaofsiap.Absorcao;

/**
 * Esta classe representa um analisador. A classe Analisador é uma subclasse da
 * classe Lente.
 *
 * @author Helder
 */
public class Analisador extends Lente {

    /**
     * Permite criar uma instância de analisador, passando por parâmetro o
     * ângulo em relação ao eixo de transmissão vertical.
     *
     * @param angulo o ângulo em graus em relação ao eixo de transmissão
     * vertical
     */
    public Analisador(double angulo) {
        super(angulo);
    }

    /**
     * Construtor vazio que permite criar uma instância de analisador,
     * atribuindo ao ângulo o valor por omissão de 0 graus.
     */
    public Analisador() {
        super();
    }

    /**
     * Devolve a descrição textual de um analisador.
     *
     * @return a descrição textual de um analisador
     */
    @Override
    public String toString() {
        return "Analisador{" + super.toString() + '}';
    }

}
