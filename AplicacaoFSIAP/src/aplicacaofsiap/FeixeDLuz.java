/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     * 
     * @param tipo
     * @param intensidade
     * @param angulo 
     */
    public FeixeDLuz(TipoDLuz tipo, double intensidade, double angulo) {
        this.tipo = tipo;
        this.intensidade = intensidade;
        this.angulo = angulo;
    }

    public FeixeDLuz(double intensidade, double angulo) {
        this.tipo = TipoDLuz.NAO_POLARIZADA;
        this.intensidade = intensidade;
        this.angulo = angulo;
    }

    public FeixeDLuz(TipoDLuz tipo) {
        this.tipo = tipo;
        this.intensidade = INTENSIDADE_POR_OMISSAO;
        this.angulo = ANGULO_POR_OMISSAO;
    }

    public FeixeDLuz() {
        this.tipo = TipoDLuz.NAO_POLARIZADA;
        this.intensidade = INTENSIDADE_POR_OMISSAO;
        this.angulo = ANGULO_POR_OMISSAO;
    }

    public TipoDLuz getTipo() {
        return tipo;
    }

    public void setTipo(TipoDLuz tipo) {
        this.tipo = tipo;
    }

    public double getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(double intensidade) {
        if (validaIntensidade(intensidade)) {
            this.intensidade = intensidade;
        }
    }

    public static boolean validaIntensidade(double intensidade) {
        return intensidade >= 0;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
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

    public boolean validaAngulo(double angulo) {
        return angulo > 0 && angulo <= 90;
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

    @Override
    public String toString() {
        return "FeixeDLuz{" + "tipo=" + tipo + ", intensidade=" + intensidade + ", angulo=" + angulo + '}';
    }

}
