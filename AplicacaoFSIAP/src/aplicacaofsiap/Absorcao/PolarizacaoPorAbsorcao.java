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
 * Esta classe é uma subclasse de polarização e representa uma instância de
 * polarização por absorção.
 *
 * @author Helder, Gonçalo
 */
public class PolarizacaoPorAbsorcao extends Polarizacao {

    private static final TipoDPolarizacao tipoDPolarizacao = TipoDPolarizacao.ABSORCAO;

    /**
     * O polarizador de uma polarização por absorção.
     */
    private Polarizador polarizador;

    /**
     * O analisador de uma polarização por absorção.
     */
    private Analisador analisador;

    /**
     * O feixe intermédio de uma polarização por absorção.
     */
    private FeixeDLuzResultante feixe_intermedio;

    /**
     * O feixe resultante final de uma polarização por absorção.
     */
    private FeixeDLuzResultante feixe_resultante;

    /**
     * Permite instanciar uma polarização por absorção, passando por parâmetro
     * um feixe de luz incidente, um polarizador, um feixe de luz resultante
     * intermédio, um analisador e um feixe de luz resultante final.
     *
     * @param f_incidente o feixe de luz incidente
     * @param polarizador o polarizador
     * @param f_intermedio o feixe de luz resultante intermédio
     * @param analisador o analisador
     * @param feixe_resultante o feixe de luz resultante final
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
     * Construtor vazio que permite a instanciação de uma polarização por
     * absorção, inicializando os seus objetos polarizador, feixe intermédio,
     * analisador e um feixe resultante com os atributos por omissão.
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
     *
     * @return o tipo de polarização da instância de polarização por absorção
     */
    public TipoDPolarizacao getTipoDPolarizacao() {
        return tipoDPolarizacao;
    }

    /**
     * Devolve o polarizador da instância de polarização por absorção.
     *
     * @return o polarizador da instância de polarização por absorção
     */
    public Polarizador getPolarizador() {
        return polarizador;
    }

    /**
     * Modifica o polarizador da instância de polarização por abosrção.
     *
     * @param polarizador o novo polarizador da instância de polarização por
     * absorção
     */
    public void setPolarizador(Polarizador polarizador) {
        this.polarizador = polarizador;
    }

    /**
     * Devolve o analisador da instância de polarização por absorção.
     *
     * @return o analisador da instância de polarização por absorção
     */
    public Analisador getAnalisador() {
        return analisador;
    }

    /**
     * Modifica o analizador da instância de polarização por absorção.
     *
     * @param analisador o novo analisador da instância de polarização por
     * absorção
     */
    public void setAnalisador(Analisador analisador) {
        this.analisador = analisador;
    }

    /**
     * Devolve o feixe resultante da instância de polarização por absorção.
     *
     * @return o feixe resultante da instância de polarização por absorção
     */
    public FeixeDLuzResultante getFeixe_resultante() {
        return feixe_resultante;
    }

    /**
     * Modifica o feixe resultante da instância de polarização por absorção.
     *
     * @param feixe_resultante o novo feixe resultante da instância de
     * polarização por absorção
     */
    public void setFeixe_resultante(FeixeDLuzResultante feixe_resultante) {
        this.feixe_resultante = feixe_resultante;
    }

    /**
     * Devolve o feixe intermédio da instância de polarização por absorção.
     *
     * @return o feixe intermédio da instância de polarização por absorção
     */
    public FeixeDLuzResultante getFeixe_intermedio() {
        return feixe_intermedio;
    }

    /**
     * Modifica o feixe intermédio da instância de polarização por absorção.
     *
     * @param feixe_intermedio o novo feixe intermédio da instância de
     * polarização por absorção
     */
    public void setFeixe_intermedio(FeixeDLuzResultante feixe_intermedio) {
        this.feixe_intermedio = feixe_intermedio;
    }

    /**
     * Devolve a descrição textual de uma polarização por absorção.
     *
     * @return a descrição textual de uma polarização por absorção
     */
    @Override
    public String toString() {
        return "PolarizacaoPorAbsorcao{" + "polarizador=" + polarizador
                + ", feixe_intermedio=" + feixe_intermedio + ", analisador="
                + analisador + ", feixe_resultante=" + feixe_resultante + '}';
    }

    /**
     * Realiza os cálculos relativos à polarização por absorção, de acordo com a
     * intensidade do feixe incidente e os ângulos das lentes, atribuindo as
     * intensidades apuradas aos feixes resultantes intermédio e final.
     */
    public void realizarPolarizacao_PObterResultados() {
        calcularIntensidadeDFeixeIntermedio();

        calcularIntensidadeDFeixeResultante(
                this.obterAnguloEntrePolarizadorEAnalisador());
    }

    /**
     * Calcula a intensidade do feixe resultante intermédio, de acordo com o
     * tipo de luz e intensidade da luz incidente e o ângulo da primeira lente
     * atravessada em relação ao eixo de transmissão que por omissão foi
     * considerado como sendo o eixo de transmissão vertical. O valor da
     * intensidade apurado é ainda atribuído ao feixe de luz intermédio.
     *
     * @return a intensidade do feixe de luz resultante intermédio
     */
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

    /**
     * Calcula a intensidade do feixe resultante final, de acordo com a
     * intensidade do feixe resultante intermédio e o ângulo diferença obtido
     * através dos ângulos entre a primeira e segunda lentes. O valor da
     * intensidade apurado é ainda atribuído ao feixe de luz resultante final.
     *
     * @param anguloEntreLentes o ângulo entre as lentes
     * @return a intensidade do feixe de luz resultante final
     */
    public double calcularIntensidadeDFeixeResultante(double anguloEntreLentes) {
        this.feixe_resultante.setIntensidade(Math.round((this.calcularIntensidadeDFeixeIntermedio()
                * Math.pow(Math.cos(Math.toRadians(anguloEntreLentes)), 2))
                * 1000) / 1000.000);
        return this.feixe_resultante.getIntensidade();
    }

    /**
     * Devolve a nova intensidade obtida quando um feixe não polarizado
     * atravessa uma lente e se transforma num feixe polarizado.
     *
     * @param int_incidente a intensidade do feixe que incide na lente
     * @return a nova intensidade do novo feixe polarizado após atravessar a
     * lente polarizadora
     */
    private double intensObtidaDeFNaoP_para_FPolarizado(double int_incidente) {
        return Math.round((int_incidente / 2) * 1000) / 1000.000;
    }

    /**
     * Devolve a nova intensidade obtida quando um feixe polarizado atravessa
     * uma lente analisadora com um deterinado ângulo de rotação relativamente
     * ao eixo de transmissão no qual o feixe se encontra polarizado.
     *
     * @param intensidd a intensidade do feixe que incide na lente
     * @param angulo o ângulo entre a lente e o eixo de tranmissão que polarizou
     * anteriormente o feixe de luz
     * @return a intensidade do feixe polarizado resultante após atravessar a
     * lente analisadora
     */
    private double intensObtidaDeFP_para_FPolarizado(double intensidd, double angulo) {
        return Math.round((intensidd * Math.pow(Math.cos(Math.toRadians(angulo)), 2))
                * 1000) / 1000.000;
    }

    /**
     * Devolve o módulo da diferença entre os ângulos da segunda e da primeira
     * lente.
     *
     * @return o ângulo entre as duas lentes
     */
    public double obterAnguloEntrePolarizadorEAnalisador() {
        return Math.abs(this.getAnalisador().getAngulo_emGraus()
                - this.getPolarizador().getAngulo_emGraus());
    }

    /**
     * Devolve a descrição textual de uma polarização por absorção,
     * discriminando o ângulo combinado entre as duas lentes.
     *
     * @return descrição textual de uma polarização por absorção, discriminando
     * o ângulo combinado entre as duas lentes
     */
    public String resultadosDPolarizacaoCAnguloComb_ToString() {
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

    /**
     * Devolve uma descrição textual completa e formatada de uma polarização por
     * absorção passada por parâmetro.
     *
     * @return descrição textual completa e formatada de uma polarização por
     * absorção
     */
    public String resultadosCompletosFormatados_toString() {
        return String.format("%s %n%s%s %n%s%s%s %n%s%s%s",
                "Simulação de Polarização por Absorção:",
                "Tipo de luz incidente: ", this.getF_incidente().getTipo(),
                "Intensidade Feixe Incidente: ", this.getF_incidente().getIntensidade(), " A",
                "Intensidade Feixe Resultante: ", this.getFeixe_resultante().getIntensidade(), " A");
    
    
    }

}
