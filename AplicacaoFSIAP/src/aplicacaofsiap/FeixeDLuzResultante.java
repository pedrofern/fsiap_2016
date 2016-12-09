package aplicacaofsiap;

/**
 * Esta classe representa um feixe de luz resultante. A classe
 * FeixeDLuzResultante é uma subclasse de FeixeDLuz.
 *
 * @author Helder
 */
public class FeixeDLuzResultante extends FeixeDLuz {

    /**
     * Cria uma instãncia de feixe de luz resultante, com os valores de
     * intensidade e ângulo passados por parâmetro.
     *
     * @param intensidade a intensidade de um feixe de luz resultante
     * @param angulo o ãngulo de um feixe de luz resultante
     */
    public FeixeDLuzResultante(double intensidade, double angulo) {
        super(TipoDLuz.POLARIZADA, intensidade, angulo);
    }

    /**
     * Cria uma instãncia de feixe de luz resultante, com os atributos: tipo de
     * luz polarizada e intensidade e ângulo com os valores por omissão.
     */
    public FeixeDLuzResultante() {
        super(TipoDLuz.POLARIZADA, FeixeDLuz.INTENSIDADE_POR_OMISSAO,
                FeixeDLuz.ANGULO_POR_OMISSAO);
    }

    /**
     * Cria uma instância de feixe de luz resultante, com o atributo tipo de luz
     * passado por parâmetro e intensidade e ângulo com os valores por omissão.
     *
     * @param tipo o tipo de luz de um feixe de luz resultante
     */
    public FeixeDLuzResultante(TipoDLuz tipo) {
        super(tipo, FeixeDLuz.INTENSIDADE_POR_OMISSAO, FeixeDLuz.ANGULO_POR_OMISSAO);
    }

    /**
     * Cria uma instância de feixe de luz resultante, com os atributos tipo de
     * luz polarizada, com a intensidade passada por parâmetro e o ângulo com o
     * valor por omissão de 0 graus.
     *
     * @param intensidade a intensidade do feixe de luz resultante
     */
    public FeixeDLuzResultante(double intensidade) {
        super(TipoDLuz.POLARIZADA, intensidade, FeixeDLuz.ANGULO_POR_OMISSAO);
    }

    /**
     * Devolve a descrição textual de um feixe de luz resultante.
     *
     * @return descrição textual de um feixe de luz resultante
     */
    @Override
    public String toString() {
        return "FeixeResultante{" + '}';
    }

}
