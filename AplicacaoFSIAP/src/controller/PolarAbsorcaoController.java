/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.TipoDPolarizacao;
import aplicacaofsiap.Simulacao;
import aplicacaofsiap.FeixeDLuz;
import javax.swing.JOptionPane;
import aplicacaofsiap.Absorcao.*;
import ui.PAbsorcaoUI;

/**
 *
 * @author Helder
 */
public class PolarAbsorcaoController {

    private PAbsorcaoUI ui;

    private Simulacao simulacao;

    public PolarAbsorcaoController(PAbsorcaoUI activeWindow) {
        this.ui = activeWindow;
        this.simulacao = new Simulacao(TipoDPolarizacao.ABSORCAO);
    }

    public boolean setDadosParaSimularPolarizacao(String intens, String ang_pol, String ang_analis) {
        return setIntensidade_FeixeIncid(intens)
                && setAngulo_Polarizador(ang_pol)
                && setAngulo_Analisador(ang_analis);
    }

    public void calcularResultadosDPolarizacao() {
        this.simulacao.getPolarizacaoPorAbsorcao().realizarPolarizacao_PObterResultados();
    }

    public String obterIntensidadeDFeixeResultante() {
        return "" + this.simulacao.getPolarizacaoPorAbsorcao().getFeixe_resultante().getIntensidade();
    }

    public String obterIntensidadeDFeixeIntermedio() {
        return "" + this.simulacao.getPolarizacaoPorAbsorcao().
                getFeixe_intermedio().getIntensidade();
    }

    public boolean setIntensidade_FeixeIncid(String value) {
        if (intensidade_FeixeIncid_E_Valida(value)) {
            this.simulacao.getPolarizacaoPorAbsorcao().getF_incidente().setIntensidade(Double.parseDouble(value));
            return true;
        }
        return false;
    }

    public boolean setAngulo_Polarizador(String value) {
        if (anguloDLente_E_Valido(value, "polarizador")) {
            this.simulacao.getPolarizacaoPorAbsorcao().getPolarizador().setAngulo_emGraus(Double.parseDouble(value));
            return true;
        }
        return false;
    }

    public boolean setAngulo_Analisador(String value) {
        if (anguloDLente_E_Valido(value, "analisador")) {
            this.simulacao.getPolarizacaoPorAbsorcao().getAnalisador().setAngulo_emGraus(Double.parseDouble(value));
            return true;
        }
        return false;
    }

    private boolean intensidade_FeixeIncid_E_Valida(String value) {
        boolean bool = false;
        //validações 
        if (value.isEmpty()) {    // se nenhum valor tiver sido inserido
            //bool = false;            
            //é lançada popUpMensagemDErro em PAbsorcaoUI("Insira um valor para a intensidade do feixe incidente!");
            System.err.println("Não foi inserido um valor para a intensidade do feixe incidente!");
        } else {
            double valorIntrodPeloUtil;
            try {
                valorIntrodPeloUtil = Double.parseDouble(value);
                if (!FeixeDLuz.validaIntensidade(valorIntrodPeloUtil)) {  // s valor<0
                    //bool = false;            
                    //é lançada popUpMensagemDErro em PAbsorcaoUI("A intensidade do feixe incidente deve ser um valor positivo!");
                    System.err.println("A intensidade do feixe incidente deve ser "
                            + "um valor positivo! --> Valor introduzido: " + valorIntrodPeloUtil);
                } else {    // valor válido
                    bool = true;
                }
            } catch (NumberFormatException ex) { //se valor introduzido não é numérico
                //bool = false;
                //é lançada popUpMensagemDErro em PAbsorcaoUI("A intensidade do feixe incidente deve ser um valor numérico!");
                System.err.println("A intensidade do feixe incidente "
                        + "deve ser um valor numérico! --> " + ex.getMessage());
            }
        }
        return bool;
    }

    private boolean anguloDLente_E_Valido(String value, String tipoDLente) {
        boolean bool = false;
        //validações
        if (value.isEmpty()) {    // se nenhum valor tiver sido inserido
            //bool = false;            
            //é lançada popUpMensagemDErro em PAbsorcaoUI("Insira o valor do ângulo do " + tipoDLente + "!");
            System.err.println("Não foi inserido o valor do ângulo do " + tipoDLente + "!");
        } else {
            double valorIntrodPeloUtil;
            try {
                valorIntrodPeloUtil = Double.parseDouble(value);
                if (!Lente.validaAngulo_emGraus(valorIntrodPeloUtil)) {
                    //bool = false;            
                    //é lançada popUpMensagemDErro em PAbsorcaoUI("O ângulo do " + tipoDLente + " deve ser um valor no intervalo [0-360].");
                    System.err.println("O ângulo do " + tipoDLente + " deve ser "
                            + "um valor no intervalo [0-360]. "
                            + "--> Valor introduzido: " + valorIntrodPeloUtil);
                } else {
                    bool = true;
                }
            } catch (NumberFormatException ex) { //se não foi introduzido um valor numérico
                //bool = false;
                //é lançada popUpMensagemDErro em PAbsorcaoUI("O ângulo do " + tipoDLente + " deve ser um valor numérico!");
                System.err.println("O ângulo do " + tipoDLente
                        + " deve ser um valor numérico! --> " + ex.getMessage());
            }
        }
        return bool;
    }

    public void popUpMensagemDErro(String msg) {
        JOptionPane.showMessageDialog(ui,
                msg, "Dados da Simulação", JOptionPane.WARNING_MESSAGE);
    }

}
