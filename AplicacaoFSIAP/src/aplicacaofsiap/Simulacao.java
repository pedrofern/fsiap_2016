/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import aplicacaofsiap.Absorcao.PolarizacaoPorAbsorcao;
import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;

/**
 *
 * @author Helder
 */
public class Simulacao {

    private TipoDPolarizacao tipoDPolarizacao;
    private PolarizacaoPorAbsorcao polarizacaoPorAbsorcao;
    private PolarizacaoPorReflexao polarizacaoPorReflexao;

    public Simulacao(TipoDPolarizacao tipoDPolarizacao) {
        this.tipoDPolarizacao = tipoDPolarizacao;
        if (this.tipoDPolarizacao == TipoDPolarizacao.ABSORCAO) {
            this.polarizacaoPorAbsorcao = new PolarizacaoPorAbsorcao();
        } else if (this.tipoDPolarizacao == TipoDPolarizacao.REFLEXAO) {
             this.polarizacaoPorReflexao = new PolarizacaoPorReflexao();
        }
    }

    public TipoDPolarizacao getTipoDPolarizacao() {
        return tipoDPolarizacao;
    }

    public void setTipoDPolarizacao(TipoDPolarizacao tipoDPolarizacao) {
        this.tipoDPolarizacao = tipoDPolarizacao;
    }

    public PolarizacaoPorAbsorcao getPolarizacaoPorAbsorcao() {
        return polarizacaoPorAbsorcao;
    }

    public void setPolarizacaoPorAbsorcao(PolarizacaoPorAbsorcao polarizacaoPorAbsorcao) {
        this.polarizacaoPorAbsorcao = polarizacaoPorAbsorcao;
    }

    public PolarizacaoPorReflexao getPolarizacaoPorReflexao() {
        return polarizacaoPorReflexao;
    }

    public void setPolarizacaoPorReflexao(PolarizacaoPorReflexao polarizacaoPorReflexao) {
        this.polarizacaoPorReflexao = polarizacaoPorReflexao;
    }

    @Override
    public String toString() {
        return "Simulacao{" + "tipoDPolarizacao=" + tipoDPolarizacao + '}';
    }

}
