package aplicacaofsiap;

import aplicacaofsiap.Absorcao.PolarizacaoPorAbsorcao;
import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;

/**
 * Esta classe representa uma simulação. Existem vários tipos de simulação. Uma
 * simulação tem um tipo de polarização que pode ser polarização por absorção ou
 * polarização por reflexão.
 *
 * @author Helder
 */
public class Simulacao {

    /**
     * O tipo de polarização de uma simulação.
     */
    private TipoDPolarizacao tipoDPolarizacao;

    /**
     * A polarização por absorção de uma simulação.
     */
    private PolarizacaoPorAbsorcao polarizacaoPorAbsorcao;

    /**
     * A polarização por reflexão de uma simulação.
     */
    private PolarizacaoPorReflexao polarizacaoPorReflexao;

    /**
     * Cria uma instância de simulação com o tipo de polarização passado por
     * parâmetro, inicializando a correspondente polarização por absorção ou
     * polarização por reflexão.
     *
     * @param tipoDPolarizacao o tipo de polarização de uma simulação
     */
    public Simulacao(TipoDPolarizacao tipoDPolarizacao) {
        this.tipoDPolarizacao = tipoDPolarizacao;
        if (this.tipoDPolarizacao == TipoDPolarizacao.ABSORCAO) {
            this.polarizacaoPorAbsorcao = new PolarizacaoPorAbsorcao();
        } else if (this.tipoDPolarizacao == TipoDPolarizacao.REFLEXAO) {
            this.polarizacaoPorReflexao = new PolarizacaoPorReflexao();
        }
    }

    /**
     * Devolve o tipo de polarização de uma simulação.
     *
     * @return o tipo de polarização de uma simulação
     */
    public TipoDPolarizacao getTipoDPolarizacao() {
        return tipoDPolarizacao;
    }

    /**
     * Modifica o tipo de polarização de uma simulação.
     *
     * @param tipoDPolarizacao o novo tipo de polarização de uma simulação
     */
    public void setTipoDPolarizacao(TipoDPolarizacao tipoDPolarizacao) {
        this.tipoDPolarizacao = tipoDPolarizacao;
    }

    /**
     * Devolve a polarização por absorção de uma simulação.
     *
     * @return a polarização por absorção de uma simulação
     */
    public PolarizacaoPorAbsorcao getPolarizacaoPorAbsorcao() {
        return polarizacaoPorAbsorcao;
    }

    /**
     * Modifica a polarização por absorção de uma simulação.
     *
     * @param polarizacaoPorAbsorcao a nova polarização por absorção de uma
     * simulação
     */
    public void setPolarizacaoPorAbsorcao(PolarizacaoPorAbsorcao polarizacaoPorAbsorcao) {
        this.polarizacaoPorAbsorcao = polarizacaoPorAbsorcao;
    }

    /**
     * Devolve a polarização por reflexão de uma simulação.
     *
     * @return a polarização por reflexão de uma simulação
     */
    public PolarizacaoPorReflexao getPolarizacaoPorReflexao() {
        return polarizacaoPorReflexao;
    }

    /**
     * Modifica a polarização por reflexão de uma simulação.
     *
     * @param polarizacaoPorReflexao a nova polarização por reflexão de uma
     * simulação
     */
    public void setPolarizacaoPorReflexao(PolarizacaoPorReflexao polarizacaoPorReflexao) {
        this.polarizacaoPorReflexao = polarizacaoPorReflexao;
    }

    /**
     * Devolve a descrição textual de uma simulação.
     *
     * @return a descrição textual de uma simulação
     */
    @Override
    public String toString() {
        return "Simulacao{" + "tipoDPolarizacao=" + tipoDPolarizacao + '}';
    }

}
