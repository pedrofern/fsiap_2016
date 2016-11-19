/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

import aplicacaofsiap.Polarizacao;
import aplicacaofsiap.TipoDPolarizacao;
import aplicacaofsiap.FeixeDLuzIncidente;
import aplicacaofsiap.FeixeDLuzResultante;

/**
 *
 * @author Helder
 */
public class PolarizacaoPorAbsorcao extends Polarizacao {

    private static final TipoDPolarizacao tipoDPolarizacao = TipoDPolarizacao.ABSORCAO;

    private Polarizador polarizador;

    private Analisador analisador;

    private FeixeDLuzResultante feixe_intermedio, feixe_resultante;

    public PolarizacaoPorAbsorcao(FeixeDLuzIncidente f_incidente, Polarizador polarizador,
            FeixeDLuzResultante f_intermedio, Analisador analisador, FeixeDLuzResultante feixe_resultante) {
        super(f_incidente);
        this.polarizador = polarizador;
        this.feixe_intermedio = f_intermedio;
        this.analisador = analisador;
        this.feixe_resultante = feixe_resultante;
    }

    public PolarizacaoPorAbsorcao() {
        super();
        this.polarizador = new Polarizador();
        this.feixe_intermedio = new FeixeDLuzResultante();
        this.analisador = new Analisador();
        this.feixe_resultante = new FeixeDLuzResultante();
    }

    public TipoDPolarizacao getTipoDPolarizacao() {
        return tipoDPolarizacao;
    }

    public Polarizador getPolarizador() {
        return polarizador;
    }

    public void setPolarizador(Polarizador polarizador) {
        this.polarizador = polarizador;
    }

    public Analisador getAnalisador() {
        return analisador;
    }

    public void setAnalisador(Analisador analisador) {
        this.analisador = analisador;
    }

    public FeixeDLuzResultante getFeixe_resultante() {
        return feixe_resultante;
    }

    public void setFeixe_resultante(FeixeDLuzResultante feixe_resultante) {
        this.feixe_resultante = feixe_resultante;
    }

    public FeixeDLuzResultante getFeixe_intermedio() {
        return feixe_intermedio;
    }

    public void setFeixe_intermedio(FeixeDLuzResultante feixe_intermedio) {
        this.feixe_intermedio = feixe_intermedio;
    }

    @Override
    public String toString() {
        return "PolarizacaoPorAbsorcao{" + "polarizador=" + polarizador
                + ", feixe_intermedio=" + feixe_intermedio + ", analisador="
                + analisador + ", feixe_resultante=" + feixe_resultante + '}';
    }

    public void realizarPolarizacao_PObterResultados() {
        calcularIntensidadeDFeixeIntermedio();

        calcularIntensidadeDFeixeResultante(
                this.obterAnguloEntrePolarizadorEAnalisador());
    }

    public double calcularIntensidadeDFeixeIntermedio() {
        this.feixe_intermedio.setIntensidade(
                Math.round((this.getF_incidente().getIntensidade() / 2)
                        * 1000) / 1000.000);
        return this.feixe_intermedio.getIntensidade();
    }

    public double obterAnguloEntrePolarizadorEAnalisador() {
        return Math.abs(this.getAnalisador().getAngulo_emGraus()
                - this.getPolarizador().getAngulo_emGraus() );
    }

    public double calcularIntensidadeDFeixeResultante(double anguloEntreLentes) {
        this.feixe_resultante.setIntensidade(Math.round((this.calcularIntensidadeDFeixeIntermedio()
                * Math.pow(Math.cos(Math.toRadians(anguloEntreLentes)), 2))
                * 1000) / 1000.000);
        return this.feixe_resultante.getIntensidade();
    }

    public String resultadosDPolarizacaoToString() {
        String resultados = " Intensidade Feixe Incidente: "
                + this.getF_incidente().getIntensidade()
                + "\n Intensidade Feixe Intermédio: "
                + this.calcularIntensidadeDFeixeIntermedio()
                + "\n Ângulo entre lentes: "
                + this.obterAnguloEntrePolarizadorEAnalisador()
                + "º\n Intensidade Feixe Resultante: "
                + this.calcularIntensidadeDFeixeResultante(
                        this.obterAnguloEntrePolarizadorEAnalisador());
        return resultados;
    }

}
