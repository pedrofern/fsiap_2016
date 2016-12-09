package aplicacaofsiap;

/**
 * Esta classe representa um feixe de luz com os atributos: tipo de luz,
 * intendidade e ângulo de incidência.
 *
 * @author Helder
 */
public abstract class FeixeDLuz {

    /**
     * Os tipos de feixe de luz.
     */
    public static enum TipoDLuz {

        NAO_POLARIZADA, POLARIZADA
    };

    /**
     * O tipo de um feixe de luz.
     */
    private TipoDLuz tipo;

    /**
     * A intensidade de um feixe de luz (em Amperes).
     */
    private double intensidade;

    /**
     * O ângulo de um feixe de luz.
     */
    private double angulo;

    /**
     * A intensidade de um feixe de luz por omissão.
     */
    protected final static double INTENSIDADE_POR_OMISSAO = 0;

    /**
     * O ângulo de um feixe de luz por omissão.
     */
    protected final static double ANGULO_POR_OMISSAO = 0;

    /**
     * Cria uma instância de feixe de luz, com os atributos tipo de luz,
     * intensidade e ângulo passados por parãmetro.
     *
     * @param tipo o tempo de um feixe de luz
     * @param intensidade a intensidade de um feixe de luz
     * @param angulo o ângulo de um feixe de luz
     */
    public FeixeDLuz(TipoDLuz tipo, double intensidade, double angulo) {
        this.tipo = tipo;
        this.intensidade = intensidade;
        this.angulo = angulo;
    }

    /**
     * Cria uma instância de feixe de luz, com os atributos tipo de luz não
     * polarizada, e a intensidade e ângulo passados por parãmetro.
     *
     * @param intensidade a intensidade de um feixe de luz
     * @param angulo o ângulo de um feixe de luz
     */
    public FeixeDLuz(double intensidade, double angulo) {
        this.tipo = TipoDLuz.NAO_POLARIZADA;
        this.intensidade = intensidade;
        this.angulo = angulo;
    }

    /**
     * Cria uma instância de feixe de luz, com o tipo de luz passado por
     * parãmetro e a intensidade e ângulo com os valores por omissão.
     *
     * @param tipo o tipo de luz de um feixe de luz
     */
    public FeixeDLuz(TipoDLuz tipo) {
        this.tipo = tipo;
        this.intensidade = INTENSIDADE_POR_OMISSAO;
        this.angulo = ANGULO_POR_OMISSAO;
    }

    /**
     * Cria uma instância de feixe de luz com o atributo tipo de luz não
     * polarizada e intensidade e ângulo com os valores por omissão.
     */
    public FeixeDLuz() {
        this.tipo = TipoDLuz.NAO_POLARIZADA;
        this.intensidade = INTENSIDADE_POR_OMISSAO;
        this.angulo = ANGULO_POR_OMISSAO;
    }

    /**
     * Devolve o tipo de luz de um feixe de luz.
     *
     * @return o tipo de luz de um feixe de luz
     */
    public TipoDLuz getTipo() {
        return tipo;
    }

    /**
     * Modifica o tipo de luz de um feixe de luz.
     *
     * @param tipo o novo tipo de luz de um feixe de luz
     */
    public void setTipo(TipoDLuz tipo) {
        this.tipo = tipo;
    }

    /**
     * Devolve a intensidade de um feixe de luz.
     *
     * @return a intensidade de um feixe de luz
     */
    public double getIntensidade() {
        return intensidade;
    }

    /**
     * Modifica a intensidade de um feixe de luz, atribuindo-lhe a intensidade
     * passada por parâmetro, se a nova intensidade for um valor válido.
     *
     * @param intensidade a intensidade de um feixe de luz
     */
    public void setIntensidade(double intensidade) {
        if (validaIntensidade(intensidade)) {
            this.intensidade = intensidade;
        }
    }

    /**
     * Valida a intensidade passada por parâmetro, retornando true se for válida
     * ou false em caso contrário.
     *
     * @param intensidade a intensidade de um feixe de luz
     * @return true se intensidade for válida, caso contrário retorna false
     */
    public static boolean validaIntensidade(double intensidade) {
        return intensidade >= 0;
    }

    /**
     * Devolve o ângulo de um feixe de luz.
     *
     * @return o ângulo de um feixe de luz
     */
    public double getAngulo() {
        return angulo;
    }

    /**
     * Modifica o ângulo de um feixe de luz, caso o ângulo passado por parãmetro
     * seja válido.
     *
     * @param angulo o ângulo de um feixe de luz
     */
    public void setAngulo(double angulo) {
        if (validaAngulo(angulo)) {
            this.angulo = angulo;
        }
    }

    /**
     * Valida o ângulo de um feixe de luz, devolvendo true se o ângulo for
     * válido, ou false caso contrário.
     *
     * @param angulo o ângulo de um feixe de luz
     * @return true se ângulo for válido, caso contrário retorna false
     */
    public boolean validaAngulo(double angulo) {
        return angulo >= 0 && angulo <= 90;
    }

    /**
     * Altera a Ã¢ngulo do feixe de luz
     *
     * @param angulo the anguloDeIncidencia a alterar
     * @return true se alterou, false se nÃ£o alterou
     */
    public boolean setAnguloValidacao(double angulo) {
        if (validaAngulo(angulo) == true) {
            this.angulo = angulo;
        }
        return this.angulo == angulo;
    }

    /**
     * Altera a intensidade do feixe de luz
     *
     * @param intensidade intensidade do feixe de luz
     * @return true se alterou, false se não alterou
     */
    public boolean setIntensidadeValidacao(double intensidade) {
        if (validaIntensidade(intensidade) == true) {
            this.intensidade = intensidade;
        }
        return this.intensidade == intensidade;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        FeixeDLuzIncidente outroFeixe = (FeixeDLuzIncidente) outroObjeto;

        return angulo == outroFeixe.getAngulo();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.angulo) ^ (Double.doubleToLongBits(this.angulo) >>> 32));
        return hash;
    }

    /**
     * Devolve a descrição textual de um feixe de luz.
     *
     * @return a descrição textual de um feixe de luz
     */
    @Override
    public String toString() {
        return "FeixeDLuz{" + "tipo=" + tipo + ", intensidade=" + intensidade + ", angulo=" + angulo + '}';
    }

}
