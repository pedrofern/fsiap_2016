/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import aplicacaofsiap.Absorcao.Lente;
import aplicacaofsiap.FeixeDLuz;
import aplicacaofsiap.Simulacao;
import controller.PolarAbsorcaoController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.*;

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
    private static final Dimension LABEL_TAMANHO = new JLabel("Intensidade: ").
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

    private JRadioButton naoPolarizadaButton, polarizadaButton;

    /**
     * A instancia do controller de polarizacao por absorcao
     */
    private PolarAbsorcaoController controll;

    private JPanel panelPrimeiraLente = criarPainelPolarizador("Lente Polarizadora");

    /**
     * Constroi uma janela para simular polarizao por absorção recebendo a
     * janela anterior como parametro
     *
     * @param framePai janela anterior
     */
    public PAbsorcaoUI(DefinirPolarizaoUI framePai) {
        super(framePai, "LIGHT GO -> Polarização por Absorção", true);

        this.framePai = framePai;
        this.controll = new PolarAbsorcaoController(this);

        criarComponentes();

        setMinimumSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(true);
        setLocationRelativeTo(framePai);
        setVisible(true);
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

        painel.add(criarPainelDadosDEntrada(), BorderLayout.NORTH);
        painel.add(criarPainelBotoes(), BorderLayout.CENTER);

        return painel;
    }

    private JPanel criarPainelDadosDEntrada() {
        JPanel p = new JPanel(new GridLayout(1, 5));

        p.add(criarPainelFeixeIncidente());
        p.add(panelPrimeiraLente);
        p.add(criarPainelFeixeIntermedio());
        p.add(criarPainelAnalisador());
        p.add(criarPainelFeixeResultante());

        return p;
    }

    private JPanel criarPainelFeixeIncidente() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(new TitledBorder("Feixe Incidente"));

        intTxt1 = new JTextField(5);
        // p.add(criarPainelLabelTextfield("Intensidade: ", intTxt1), BorderLayout.NORTH);
        p.add(criarPainelLabelTextfield2("Intensidade: ", intTxt1, "A"), BorderLayout.NORTH);

        JPanel radioButtPanel = new JPanel();
        radioButtPanel.setBorder(new TitledBorder("Tipo de Luz"));

        naoPolarizadaButton = new JRadioButton("Não Polarizada");
        polarizadaButton = new JRadioButton("Polarizada");
        naoPolarizadaButton.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(naoPolarizadaButton);
        group.add(polarizadaButton);

        radioButtPanel.add(naoPolarizadaButton);
        radioButtPanel.add(polarizadaButton);

        p.add(radioButtPanel, BorderLayout.CENTER/* BorderLayout.SOUTH*/);

        JLabel l = new JLabel("Considera-se luz polarizada com direção do eixo vertical");
        l.setVisible(false);
        p.add(l, BorderLayout.SOUTH);

        polarizadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (polarizadaButton.isSelected()) {
                    panelPrimeiraLente.setBorder(new TitledBorder("Lente Analisadora"));
                    String observacao = "Luz polarizada com";// direção do eixo vertical";
                    l.setVisible(true);
                    JLabel lb = new JLabel(observacao/*, JLabel.RIGHT*/);
                    //lb.setPreferredSize(LABEL_TAMANHO);
                    //JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    //p2.add(lb);
                    //JLabel lb1 = new JLabel(observacao);

                    p.add(lb, BorderLayout.SOUTH);
                }
            }
        });

        naoPolarizadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (naoPolarizadaButton.isSelected()) {
                    panelPrimeiraLente.setBorder(new TitledBorder("Lente Polarizadora"));
                    l.setVisible(false);
                }
            }
        });

        return p;
    }

    private JPanel criarPainelPolarizador(String tipoDLente) {
        JPanel p = new JPanel();

        p.setBorder(new TitledBorder(tipoDLente));

        angTxt1 = new JTextField(3);

        angTxt1.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                intTxt2.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                intTxt2.setText("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //Texto simples não lança este tipo de eventos
            }

        });

        angTxt1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                intTxt2.setText("");
            }
        });

        p.add(criarPainelLabelTextfield2("Ângulo: ", angTxt1, "º (graus)"));

        return p;
    }

    private JPanel criarPainelFeixeIntermedio() {
        JPanel p = new JPanel();

        p.setBorder(new TitledBorder("Feixe Intermédio"));

        intTxt2 = new JTextField(5);
        intTxt2.setEditable(false);

        p.add(criarPainelLabelTextfield2("Intensidade: ", intTxt2, "A"));
//      p.add(criarPainelLabelTextfield("Intensidade: ", intTxt2));

        return p;
    }

    private JPanel criarPainelAnalisador() {
        JPanel p = new JPanel();

        p.setBorder(new TitledBorder("Lente Analisadora"));

        angTxt2 = new JTextField(3);

        angTxt2.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                intTxt3.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                intTxt3.setText("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //Texto simples não lança este tipo de eventos
            }

        });

        angTxt2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                intTxt3.setText("");
            }
        });
        p.add(criarPainelLabelTextfield2("Ângulo", angTxt2, "º (graus)"));

        JLabel observ = new JLabel("Utilize um intervalo na escala [-90 ; 90].");
        p.add(observ);

        return p;
    }

    private JPanel criarPainelFeixeResultante() {
        JPanel p = new JPanel();

        p.setBorder(new TitledBorder("Feixe Resultante"));

        intTxt3 = new JTextField(5);
        intTxt3.setEditable(false);

        p.add(criarPainelLabelTextfield2("Intensidade: ", intTxt3, "A"));
        //p.add(criarPainelLabelTextfield("Intensidade", intTxt3));

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

    private JPanel criarPainelLabelTextfield2(String label1, JTextField texto, String label2) {
        JLabel lb1 = new JLabel(label1, JLabel.RIGHT);
        lb1.setPreferredSize(LABEL_TAMANHO);

        JLabel lb2 = new JLabel(label2, JLabel.RIGHT);
        lb1.setPreferredSize(LABEL_TAMANHO);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p.add(lb1);
        p.add(texto);
        p.add(lb2);
//p.addFocusListener(null);
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
        simular.setToolTipText("Simular a polarização por absorção");

        simular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (polarizadaButton.isSelected()) {
                    controll.setTipoDFeixeIncidente(FeixeDLuz.TipoDLuz.POLARIZADA);
                } else if (naoPolarizadaButton.isSelected()) {
                    controll.setTipoDFeixeIncidente(FeixeDLuz.TipoDLuz.NAO_POLARIZADA);
                }
                if (lerIntensidade(intTxt1.getText())
                        && lerAngulo(angTxt1.getText(), "polarizador")
                        && lerAngulo(angTxt2.getText(), "analisador")) {

                    controll.setDadosParaSimularPolarizacao(intTxt1.getText(),
                            angTxt1.getText(), angTxt2.getText());

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
        novaSimulacao.setToolTipText("Nova Simulacao - polarização por absorção");
        novaSimulacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                naoPolarizadaButton.setSelected(true);
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
        voltar.setToolTipText("Cancela a simulação e volta ao menu anterior");
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
        guardar.setToolTipText("Guardar a simulação");
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //implementar
                    guardarDadosSimulacao_EmFicheiro();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PAbsorcaoUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        return guardar;
    }

    private void guardarDadosSimulacao_EmFicheiro() throws FileNotFoundException {
        String outputFile = "absorcaoOutputFile.txt"; //basta q ficheiro esteja dentro da pasta principal deste programa
        Formatter output = new Formatter(new File(outputFile));
        output.format("%s%s %n%s%s", "Intensidade de entrada:",
                intTxt1.getText(), "Intensidade final: ", intTxt3.getText());
        output.close();
    }

    private boolean lerIntensidade(String imput) {
        boolean bool = false;
        //verifica valor de intensidade introduzido e despoleta pop-ups se necessário
        if (imput.isEmpty()) {
            popUpMensagemDErro("Insira um valor para a intensidade do feixe incidente!");
        } else {
            try {
                double valor_intensidade = Double.parseDouble(imput);
                if (!FeixeDLuz.validaIntensidade(valor_intensidade)) {
                    popUpMensagemDErro("A intensidade do feixe incidente deve ser um valor positivo!");
                } else {
                    bool = true;
                    //continua com confirmação dos restantes inputs antes de fazer setDados
                }
            } catch (NumberFormatException ex) { //se não foi introduzido um valor numérico
                popUpMensagemDErro("A intensidade do feixe incidente deve ser um valor numérico!");
            }
        }
        return bool;
    }

    private boolean lerAngulo(String input, String tipoDLente) {
        //verifica valor de anguloDLente introduzido e despoleta pop-ups se necessário
        boolean bool = false;
        if (input.isEmpty()) {
            popUpMensagemDErro("Insira o valor do ângulo do " + tipoDLente + "!");
        } else {
            try {
                double valor_intensidade = Double.parseDouble(input);
                if (!Lente.validaAngulo_emGraus(valor_intensidade)) {
                    popUpMensagemDErro("Introduza um valor para o ângulo do " + tipoDLente + " no intervalo [(-360) - 360].");
                } else {
                    bool = true;
                    //continua 
                }
            } catch (NumberFormatException ex) { //se não foi introduzido um valor numérico
                popUpMensagemDErro("O ângulo do " + tipoDLente + " deve ser um valor numérico!");
            }
        }
        return bool;
    }

    private void popUpMensagemDErro(String msg) {
        JOptionPane.showMessageDialog(this,
                msg, "Dados da Simulação", JOptionPane.WARNING_MESSAGE);
    }



}
