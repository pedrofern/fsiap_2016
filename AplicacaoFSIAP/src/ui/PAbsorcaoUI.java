/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import aplicacaofsiap.Absorcao.*;
import controller.PolarAbsorcaoController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Pedro Fernandes e Helder Silva
 */
public class PAbsorcaoUI extends JDialog {

    /**
     * Guarda a janela anterior
     */
    private DefinirPolarizaoUI framePai;

    /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 900, JANELA_ALTURA_MINIMO = 350;

    /**
     * Guarda a dimensão de uma label por omissão
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Intensidade:").
            getPreferredSize();
    /**
     * Guarda os angulos e intensidades
     */
    private JTextField intTxt1, intTxt2, intTxt3, angTxt1, angTxt2;

    /**
     * Guarda a simulação
     */
    private Simulacao simulacao;

    /**
     * Guarda os botoes
     */
    private JButton novaSimulacao, simular, voltar, guardar;

    /**
     * A instancia do controller de polarizacao por absorcao
     */
    private PolarAbsorcaoController controll;

    /**
     * Constroi uma janela para simular polarizao por absorção recebendo a
     * janela anterior como parametro
     *
     * @param framePai janela anterior
     */
    public PAbsorcaoUI(DefinirPolarizaoUI framePai) {
        super(framePai, "LIGHT GO -> Polarização por Absorção");

        this.framePai = framePai;
        this.controll = new PolarAbsorcaoController(this);

        criarComponentes();

        setMinimumSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(true);
        setLocationRelativeTo(framePai);
        setVisible(true);
        setModal(true);
    }

    /**
     * cria os componentes da janela
     */
    private void criarComponentes() {

        add(criarPainelGeral(), BorderLayout.NORTH);
        add(criarBotaoGuardar(), BorderLayout.CENTER);

    }

    private JPanel criarPainelGeral() {
        JPanel painel = new JPanel(new BorderLayout());

        painel.add(criarPainelResultados(), BorderLayout.NORTH);
        painel.add(criarPainelBotoes(), BorderLayout.CENTER);

        return painel;
    }

    private JPanel criarPainelResultados() {
        JPanel p = new JPanel(new GridLayout(1, 5));

        p.add(criarPainelFeixeIncidente());
        p.add(criarPainelPolarizador());
        p.add(criarPainelFeixeIntermedio());
        p.add(criarPainelAnalisador());
        p.add(criarPainelFeixeResultante());

        return p;
    }

    private JPanel criarPainelFeixeIncidente() {
        JPanel p = new JPanel();

        p.setBorder(new TitledBorder("Feixe Incidente"));

        intTxt1 = new JTextField(10);

        p.add(criarPainelLabelTextfield("Intensidade", intTxt1));

        return p;
    }

    private JPanel criarPainelPolarizador() {
        JPanel p = new JPanel();

        p.setBorder(new TitledBorder("Polarizador"));

        angTxt1 = new JTextField(10);

        p.add(criarPainelLabelTextfield("Angulo", angTxt1));

        return p;
    }

    private JPanel criarPainelFeixeIntermedio() {
        JPanel p = new JPanel();

        p.setBorder(new TitledBorder("Feixe Intermedio"));

        intTxt2 = new JTextField(10);
        intTxt2.setEditable(false);
        p.add(criarPainelLabelTextfield("Intensidade", intTxt2));

        return p;
    }

    private JPanel criarPainelAnalisador() {
        JPanel p = new JPanel();

        p.setBorder(new TitledBorder("Analisador"));

        angTxt2 = new JTextField(10);

        p.add(criarPainelLabelTextfield("Angulo", angTxt2));

        return p;
    }

    private JPanel criarPainelFeixeResultante() {
        JPanel p = new JPanel();

        p.setBorder(new TitledBorder("Feixe Resultante"));

        intTxt3 = new JTextField(10);
        intTxt3.setEditable(false);
        p.add(criarPainelLabelTextfield("Intensidade", intTxt3));

        return p;
    }

    /**
     * cria painel para introduzir label1, campo para introdução dados
     *
     * @param label1 introduzir label1
     * @param texto campo para introdução dados
     * @return painel para introduzir label1, campo para introdução dados
     */
    private JPanel criarPainelLabelTextfield(String label1, JTextField texto) {
        JLabel lb1 = new JLabel(label1, JLabel.RIGHT);
        lb1.setPreferredSize(LABEL_TAMANHO);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p.add(lb1);
        p.add(texto);

        return p;
    }

    /**
     * cria painel botoes
     *
     * @return painel botoes
     */
    private JPanel criarPainelBotoes() {

        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel(l);

        p.add(criarBotaoSimular());
        p.add(criarBotaoNovaSimulacao());
        p.add(criarBotaoVoltar());

        getRootPane().setDefaultButton(simular);

        return p;
    }

    /**
     * criar botão simular
     *
     * @return botão simular
     */
    private JButton criarBotaoSimular() {
        simular = new JButton("Simular");
        simular.setMnemonic(KeyEvent.VK_S);
        simular.setToolTipText("Simular a polarizacao por absorção");

        simular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (controll.setDadosParaSimularPolarizacao(intTxt1.getText(),
                        angTxt1.getText(), angTxt2.getText())) {
                    controll.calcularResultadosDPolarizacao();

                    //colocação de resultados de polarizacao no interface
                    intTxt2.setText(controll.obterIntensidadeDFeixeIntermedio());
                    intTxt3.setText(controll.obterIntensidadeDFeixeResultante());
                }

            }
        }
        );

        return simular;
    }

    /**
     * criar botão nova simulacao
     *
     * @return botão nova simulacao
     */
    private JButton criarBotaoNovaSimulacao() {
        novaSimulacao = new JButton("Nova Simulação");
        novaSimulacao.setMnemonic(KeyEvent.VK_N);
        novaSimulacao.setToolTipText("Nova Simulacao - polarizacao por absorção");
        novaSimulacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intTxt1.setText("");
                intTxt2.setText("");
                intTxt3.setText("");
                angTxt1.setText("");
                angTxt2.setText("");
            }
        });
        return novaSimulacao;
    }

    /**
     * criar botão Voltar e volta menu anterior
     *
     * @return botão Voltar e volta menu anterior
     */
    private JButton criarBotaoVoltar() {
        voltar = new JButton("Voltar");
        voltar.setMnemonic(KeyEvent.VK_V);
        voltar.setToolTipText("Cancela a simulacao e volta ao menu anterior");
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return voltar;
    }

    /**
     * criar botão Guardar
     *
     * @return botão Guardar
     */
    private JButton criarBotaoGuardar() {
        guardar = new JButton("Guardar");
        guardar.setMnemonic(KeyEvent.VK_V);
        guardar.setToolTipText("Guardar a simulacao");
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementar
            }
        });

        return guardar;
    }
}
