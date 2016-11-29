/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

import aplicacaofsiap.FeixeDLuz;
import aplicacaofsiap.Polarizacao;
import aplicacaofsiap.TipoDPolarizacao;
import aplicacaofsiap.FeixeDLuzIncidente;
import aplicacaofsiap.FeixeDLuzResultante;

/**
 * Esta classe é uma subclasse de polarização e representa uma instância de polarização por absorção.
 * @author Helder, Gonçalo
 */
public class PolarizacaoPorAbsorcao extends Polarizacao {

    private static final TipoDPolarizacao tipoDPolarizacao = TipoDPolarizacao.ABSORCAO;

    private Polarizador polarizador;

    private Analisador analisador;

    private FeixeDLuzResultante feixe_intermedio, feixe_resultante;
    
    /**
     * Permite a instanciação de uma polarização por absorção
     * @param f_incidente novo feixe de luz inciddente
     * @param polarizador novo polarizador
     * @param f_intermedio novo feixe de luz intermédio
     * @param analisador novo analisador
     * @param feixe_resultante novo feixe de luz resultante
     */
    public PolarizacaoPorAbsorcao(FeixeDLuzIncidente f_incidente, Polarizador polarizador,
            FeixeDLuzResultante f_intermedio, Analisador analisador, FeixeDLuzResultante feixe_resultante) {
        super(f_incidente);
        this.polarizador = polarizador;
        this.feixe_intermedio = f_intermedio;
        this.analisador = analisador;
        this.feixe_resultante = feixe_resultante;
    }

    /**
     * Construtor vazio que permite a instânciação de uma polarização por absorção, inicializando com um
     * polarizador, um feixe intermédio, um analisador e um feixe resultante, da instância de
     * polarização por absorção.
     */
    public PolarizacaoPorAbsorcao() {
        super();
        this.polarizador = new Polarizador();
        this.feixe_intermedio = new FeixeDLuzResultante();
        this.analisador = new Analisador();
        this.feixe_resultante = new FeixeDLuzResultante();
    }

    /**
     * Devolve o tipo de polarização da instância de polarização por absorção.
     * @return o tipo de polarização da instância de polarização por absorção
     */
    public TipoDPolarizacao getTipoDPolarizacao() {
        return tipoDPolarizacao;
    }
    
    /**
     * Devolve o polarizador da instância de polarização por absorção.
     * @return o polarizador da instância de polarização por absorção
     */
    public Polarizador getPolarizador() {
        return polarizador;
    }

    /**
     * Modifica o polarizador da instância de polarização por abosrção.
     * @param polarizador o novo polarizador da instância de polarização por absorção
     */
    public void setPolarizador(Polarizador polarizador) {
        this.polarizador = polarizador;
    }

    /**
     * Devolve o analisador da instância de polarização por absorção.
     * @return o analisador da instância de polarização por absorção
     */
    public Analisador getAnalisador() {
        return analisador;
    }

    /**
     * Modifica o analizador da instância de polarização por absorção.
     * @param analisador o novo analisador da instância de polarização por absorção
     */
    public void setAnalisador(Analisador analisador) {
        this.analisador = analisador;
    }
    
    /**
     * Devolve o feixe resultante da instância de polarização por absorção.
     * @return o feixe resultante da instância de polarização por absorção
     */
    public FeixeDLuzResultante getFeixe_resultante() {
        return feixe_resultante;
    }

    /**
     * Modifica o feixe resultante da instância de polarização por absorção.
     * @param feixe_resultante o novo feixe resultante da instância de polarização por absorção
     */
    public void setFeixe_resultante(FeixeDLuzResultante feixe_resultante) {
        this.feixe_resultante = feixe_resultante;
    }
    
    /**
     * Devolve o feixe intermédio da instância de polarização por absorção.
     * @return o feixe intermédio da instância de polarização por absorção
     */
    public FeixeDLuzResultante getFeixe_intermedio() {
        return feixe_intermedio;
    }

    /**
     * Modifica o feixe intermédio da instância de polarização por absorção.
     * @param feixe_intermedio o novo feixe intermédio da instância de polarização por absorção
     */
    public void setFeixe_intermedio(FeixeDLuzResultante feixe_intermedio) {
        this.feixe_intermedio = feixe_intermedio;
    }
    /**
     * Devolve a descrição textual de uma polarização por absorção.
     * @return a descrição textual de uma polarização por absorção
     */
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
        double intensidade_incid = this.getF_incidente().getIntensidade();
        if (this.getF_incidente().getTipo() == FeixeDLuz.TipoDLuz.NAO_POLARIZADA) {
            this.feixe_intermedio.setIntensidade(
                    intensObtidaDeFNaoP_para_FPolarizado(intensidade_incid));
        }
        if (this.getF_incidente().getTipo() == FeixeDLuz.TipoDLuz.POLARIZADA) {
            double angDLente = this.getPolarizador().getAngulo_emGraus();
            this.feixe_intermedio.setIntensidade(
                    intensObtidaDeFP_para_FPolarizado(intensidade_incid, angDLente));
        }
        return this.feixe_intermedio.getIntensidade();
    }

    private double intensObtidaDeFNaoP_para_FPolarizado(double int_incidente) {
        return Math.round((int_incidente / 2) * 1000) / 1000.000;
    }

    private double intensObtidaDeFP_para_FPolarizado(double intensidd, double angulo) {
        return Math.round((intensidd * Math.pow(Math.cos(Math.toRadians(angulo)), 2))
                * 1000) / 1000.000;
    }

    public double obterAnguloEntrePolarizadorEAnalisador() {
        return Math.abs(this.getAnalisador().getAngulo_emGraus()
                - this.getPolarizador().getAngulo_emGraus());
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
