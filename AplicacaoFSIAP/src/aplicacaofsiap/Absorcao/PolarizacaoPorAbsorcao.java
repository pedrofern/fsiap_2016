/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

/**
 *
 * @author Helder
 */
public class PolarizacaoPorAbsorcao extends Polarizacao {

    private TipoDPolarizacao tipoDPolarizacao = TipoDPolarizacao.ABSORCAO;

    private Polarizador polarizador;

    private Analisador analisador;

    private FeixeResultante feixe_resultante;

    public PolarizacaoPorAbsorcao(FeixeIncidente f_incidente, Polarizador polarizador, Analisador analisador, FeixeResultante feixe_resultante) {
        super(f_incidente);
        this.polarizador = polarizador;
        this.analisador = analisador;
        this.feixe_resultante = feixe_resultante;
    }

    public PolarizacaoPorAbsorcao() {
        super();
        this.polarizador = new Polarizador();
    }

    public TipoDPolarizacao getTipoDPolarizacao() {
        return tipoDPolarizacao;
    }

    public void setTipoDPolarizacao(TipoDPolarizacao tipoDPolarizacao) {
        this.tipoDPolarizacao = tipoDPolarizacao;
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

    public FeixeResultante getFeixe_resultante() {
        return feixe_resultante;
    }

    public void setFeixe_resultante(FeixeResultante feixe_resultante) {
        this.feixe_resultante = feixe_resultante;
    }

    @Override
    public String toString() {
        return "tipoDPolarizacao=" + tipoDPolarizacao + ", polarizador=" + polarizador + ", analisador=" + analisador + ", feixe_resultante=" + feixe_resultante + '}';
    }

    public double obterIntensidadeDFeixeAposPolarizador() {
        return this.getF_incidente().getIntensidade() / 2;
    }

    public double obterAnguloEntrePolarizadorEAnalisador() {
        double angulo = 0;
        //metodo incompleto, terminar  
        if (this.getTipoDPolarizacao() == TipoDPolarizacao.ABSORCAO) {
            angulo = this.analisador.getAngulo_emGraus();
        }
        return angulo;
    }

    public double obterIntensidadeDFeixeResultante_AposAnalisador(double anguloEntreLentes) {
        return this.obterIntensidadeDFeixeAposPolarizador()
                * Math.pow(Math.cos(Math.toRadians(anguloEntreLentes)), 2);
    }

    public String realizarPolarizAbsor_obterResultados() {
        String resultados = " Intensidade Feixe Incidente: "
                + this.getF_incidente().getIntensidade()
                + "\n Intensidade Feixe Intermédio: "
                + this.obterIntensidadeDFeixeAposPolarizador()
                + "\n Ângulo entre lentes: "
                + this.obterAnguloEntrePolarizadorEAnalisador()
                + "º\n Intensidade Feixe Resultante: "
                + this.obterIntensidadeDFeixeResultante_AposAnalisador(this.obterAnguloEntrePolarizadorEAnalisador());
        return resultados;
    }

    public void realizarPolarizacao_PObterResultados() {
        this.feixe_resultante.setIntensidade(
                this.obterIntensidadeDFeixeResultante_AposAnalisador(
                        this.obterAnguloEntrePolarizadorEAnalisador()));
    }
   
}