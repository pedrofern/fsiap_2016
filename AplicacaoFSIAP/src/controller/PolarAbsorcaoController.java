/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    
    public void calcularResultadosDPolarizacao(){
        this.simulacao.getPolarizacaoPorAbsorcao().realizarPolarizacao_PObterResultados();
    }

    public boolean setIntensidade_FeixeIncid(String value) {
        if (intensidade_FeixeIncid_E_Valida(value)) {
            this.simulacao.getPolarizacaoPorAbsorcao().getF_incidente().setIntensidade(Double.parseDouble(value));
        }
        return false;
    }

    public boolean setAngulo_Polarizador(String value) {
        if (anguloDLente_E_Valido(value, "polarizador")) {
            this.simulacao.getPolarizacaoPorAbsorcao().getPolarizador().setAngulo_emGraus(Double.parseDouble(value));
        }
        return anguloDLente_E_Valido(value, "polarizador");
    }

    public boolean setAngulo_Analisador(String value) {
        if (anguloDLente_E_Valido(value, "analisador")) {
            this.simulacao.getPolarizacaoPorAbsorcao().getAnalisador().setAngulo_emGraus(Double.parseDouble(value));
        }
        return anguloDLente_E_Valido(value, "analisador");
    }

    private boolean intensidade_FeixeIncid_E_Valida(String value) {
        boolean bool = false;
        //validações 
        if (value.isEmpty()) {    // se nenhum valor tiver sido inserido
            popUpMensagemDErro("Insira um valor para a intensidade do feixe incidente!");
        } else {
            double valorIntrodPeloUtil;
            try {
                valorIntrodPeloUtil = Double.parseDouble(value);
                if (!FeixeDLuz.validaIntensidade(valorIntrodPeloUtil)) {  // se valor nao é >=0
                    popUpMensagemDErro("A intensidade do feixe incidente deve ser um valor positivo!");
                } else {
                    bool = true;
                }
            } catch (NumberFormatException ex) { //se não foi introduzido um valor numérico
                popUpMensagemDErro("A intensidade do feixe incidente deve ser um valor numérico!");
            }
        }
        return bool;
    }

    private boolean anguloDLente_E_Valido(String value, String lente) {
        String tipodeLente = lente;
        boolean bool = false;
        //validações
        if (value.isEmpty()) {    // se nenhum valor tiver sido inserido
            popUpMensagemDErro("Insira o valor do ângulo do " + tipodeLente + "!");
        } else {
            double valorIntrodPeloUtil;
            try {
                valorIntrodPeloUtil = Double.parseDouble(value);
                if (!Lente.validaAngulo_emGraus(valorIntrodPeloUtil)) {
                    popUpMensagemDErro("O ângulo do " + tipodeLente + " deve ser um valor no intervalo [0-360].");
                } else {
                    bool = true;
                }
            } catch (NumberFormatException ex) { //se não foi introduzido um valor numérico
                popUpMensagemDErro("O ângulo do " + tipodeLente + " deve ser um valor numérico!");
            }
        }
        return bool;
    }

    private void popUpMensagemDErro(String msg) {
        JOptionPane.showMessageDialog(ui,
                msg, "Dados da Simulação", JOptionPane.WARNING_MESSAGE);
    }
}
