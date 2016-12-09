package aplicacaofsiap;

/**
 * Esta classe representa um feixe de luz incidente. A classe FeixeDLuzIncidente
 * é uma subclasse de FeixeDLuz.
 *
 * @author Helder
 */
public class FeixeDLuzIncidente extends FeixeDLuz {

    /**
     * Cria uma instãncia de feixe de luz incidente, com o tipo de luz,
     * intensidade e ângulo passados por parâmetros.
     *
     * @param tipo o tipo de um feixe de luz incidente
     * @param intensidade a intensidade de um feixe de luz incidente
     * @param angulo o ângulo de um feixe de luz incidente
     */
    public FeixeDLuzIncidente(TipoDLuz tipo, double intensidade, double angulo) {
        super(tipo, intensidade, angulo);
    }

    /**
     * Cria uma instância de feixe de luz incidente com a intensidade passada
     * por parâmetro, tipo de luz não polarizada e ângulo com o valor por
     * omissão.
     *
     * @param intensidade a intensidade de um feixe de luz incidente
     */
    public FeixeDLuzIncidente(double intensidade) {
        super(TipoDLuz.NAO_POLARIZADA, intensidade, FeixeDLuz.ANGULO_POR_OMISSAO);
    }

    /**
     * Cria uma instância de feixe de luz incidente, com os atributos tipo de
     * luz não polarizada e intensidade e ângulo com os valores por omissão.
     */
    public FeixeDLuzIncidente() {
        super();
    }

    /**
     * Devolve a descrição textual de um feixe de luz incidente.
     *
     * @return a descrição textual de um feixe de luz incidente
     */
    @Override
    public String toString() {
        return "FeixeIncidente{" + '}';
    }

}
