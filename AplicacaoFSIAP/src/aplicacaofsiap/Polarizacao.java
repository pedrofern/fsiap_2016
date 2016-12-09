package aplicacaofsiap;

/**
 * Esta classe representa uma polarização. Uma polarização especializa-se nas
 * subclasses PolarizacaoPorAbsorcao ou PolarizacaoPorReflexao.
 * @author Helder
 */
public abstract class Polarizacao {

    /**
     * O feixe de luz incidente de uma polarização.
     */
    private FeixeDLuzIncidente f_incidente;

    /**
     * Cria uma instância de polarização, passando por parâmetro um feixe de luz
     * incidente.
     *
     * @param f_incidente feixe de luz incidente
     */
    public Polarizacao(FeixeDLuzIncidente f_incidente) {
        this.f_incidente = f_incidente;
    }

    /**
     * Cria uma instância de polarização, inicializando-a com um feixe de luz
     * incidente com os atributos por omissão (tipo de luz não polarizada, com
     * ângulo de 0 graus e intensidade de 1 Ampere)
     */
    public Polarizacao() {
        this.f_incidente = new FeixeDLuzIncidente();
    }

    /**
     * Devolve o feixe de luz incidente de uma polarização.
     *
     * @return o feixe de luz incidente de uma polarização
     */
    public FeixeDLuzIncidente getF_incidente() {
        return f_incidente;
    }

    /**
     * Modifica o feixe de luz incidente de uma polarização.
     *
     * @param f_incidente o novo feixe de luz incidente de uma polarização
     */
    public void setF_incidente(FeixeDLuzIncidente f_incidente) {
        this.f_incidente = f_incidente;
    }

    /**
     * Devolve a descrição textual de uma polarização.
     *
     * @return a descrição textual de uma polarização
     */
    @Override
    public String toString() {
        return "Polarizacao{" + "f_incidente=" + f_incidente + '}';
    }

}
