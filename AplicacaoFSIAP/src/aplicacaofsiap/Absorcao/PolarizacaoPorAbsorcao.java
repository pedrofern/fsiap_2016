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

    
}