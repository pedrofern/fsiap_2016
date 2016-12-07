/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import aplicacaofsiap.Reflexao.ListaMeiosReflexao;
import aplicacaofsiap.Reflexao.MeioReflexao;
import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
import aplicacaofsiap.LightGo;
import aplicacaofsiap.Simulacao;
import controller.PReflexaoController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Pedro Fernandes
 */
public class PReflexaoUI extends JDialog{
    
    /**
     * Guarda a janela anterior
     */
    private DefinirPolarizaoUI framePai;
    /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 1000, JANELA_ALTURA_MINIMO = 700; 
    /**
     * Guarda a dimensão de uma label por omissão
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Intensidade Reflexão Perpendicular:").
                                                    getPreferredSize(); 
    /**
     * Guarda o angulo1
     */
    private JTextField angTxt1, angTxt2, angTxt3, angTxt4, int1,int2,int3,int4;
    /**
     * Guarda o botao nova simulacao
     */
    private JButton limpar,simular,guardar;
    /**
     * Guarda lista com materiais numa combobox
     */
    private JComboBox comboMateriais1, comboMateriais2;
    /**
     * Guarda lista dos materiais
     */
    private ListaMeiosReflexao listaMeios;
    /**
     * O controller da Polarização por Reflexão
     */
    private PReflexaoController controller;
    /**
     * A polarização por reflexão que iremos simular
     */
    private PolarizacaoPorReflexao pr;
    /**
     * Constroi uma janela para simular polarizao por reflexao
     * recebendo a janela anterior como parametro
     * @param framePai janela anterior
     */
    public PReflexaoUI(DefinirPolarizaoUI framePai, LightGo lg, Simulacao s){
        super(framePai, "LIGHT GO -> Polarização por Reflexão", true);
        
        this.framePai = framePai;
        this.pr=s.getPolarizacaoPorReflexao();
        this.controller=new PReflexaoController(lg, pr);
        
        listaMeios =controller.getListaMeios();
        
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
    private void criarComponentes(){
        
        JPanel p1 = criarPainelEsquerda();
        JPanel p2 = criarPainelDireita();
        JPanel p3 = criarPainelBotoes();
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
    }
    private JPanel criarPainelEsquerda(){
        JPanel p = new JPanel();
        
        p.setBorder(new TitledBorder("Escolher materiais e angulo entrada:"));
        
        p.add(criarPainelMateriaisAngulo(),BorderLayout.CENTER);
        p.add(criarPainelBotaoUnico(criarBotaoSimular()),BorderLayout.SOUTH);
        simular.setEnabled(true);
        
        return p;           
    }
    private JPanel criarPainelMateriaisAngulo(){
        JPanel p = new JPanel(new FlowLayout());
        
        p.add(criarPainelAnguloIntensidade());
        p.add(criarPainelMaterias());
        
        return p;
        
    }
     private JPanel criarPainelAnguloIntensidade(){
        JPanel p = new JPanel(new GridLayout(2, 1));
        
        p.setBorder(new TitledBorder("Angulo e Intensidade"));
        
        angTxt1 = new JTextField(10);
        int1 = new JTextField(10);
        
        p.add(criarPainelLabelTextfieldLabel("Intensidade:", int1,"(Amperes)"));
        p.add(criarPainelLabelTextfieldLabel("Ângulo entrada:", angTxt1,"(º Graus)"));
        
        return p;
    }
    private JPanel criarPainelMaterias(){
        JPanel p = new JPanel(new GridLayout(2, 1, 30, 30));
        
        p.setBorder(new TitledBorder("Materiais"));
        
        comboMateriais1 = criarComboMateriais(listaMeios);
        comboMateriais2 = criarComboMateriais(listaMeios);
        
        p.add(criarPainelComboMateriais("Material 1",comboMateriais1));
        p.add(criarPainelComboMateriais("Material 2",comboMateriais2));
        
        return p;
    }
    private JPanel criarPainelComboMateriais(String material, JComboBox combo){
        JPanel p = new JPanel(new GridLayout(1,1));
        
        p.setBorder(new TitledBorder(material));
        
        p.add(combo);
        
        return p;
        
    }
    
    private JPanel criarPainelDireita(){
        JPanel p = new JPanel();
        
        p.setBorder(new TitledBorder("Resultado:"));
        
        p.add(criarPainelAngulos(),BorderLayout.NORTH);
        p.add(criarPainelImagem(),BorderLayout.CENTER);
        p.add(criarPainelBotaoUnico(criarBotaoLimpar()),BorderLayout.SOUTH);
        
        return p;           
    }
    
    private JPanel criarPainelAngulos(){
        JPanel p = new JPanel(new GridLayout(6,1));
        
        p.setBorder(new TitledBorder("Ângulos e Intensidades Resultantes:"));
        
        angTxt2 = new JTextField(10);
        angTxt3 = new JTextField(10);
        angTxt4= new JTextField(10);
        int2= new JTextField(10);
        int3= new JTextField(10);
        int4= new JTextField(10);
        angTxt2.setEditable(false);
        angTxt3.setEditable(false);
        angTxt4.setEditable(false);
        int2.setEditable(false);
        int3.setEditable(false);
        int4.setEditable(false);
        
        String graus = "(º Graus)";
        String amperes = "(Amperes)";
        
        String l1="Ângulo Reflexão:";
        String l2="Ângulo Refração:";
        String l3="Ângulo Brewster:";
        String l4="Intensidade Reflexão Paralela:";
        String l5="Intensidade Reflexão Perpendicular:";
        String l6="Intensidade Refração:";
        
        p.add(criarPainelLabelTextfieldLabel(l1, angTxt2,graus));
        p.add(criarPainelLabelTextfieldLabel(l2, angTxt3,graus));
        p.add(criarPainelLabelTextfieldLabel(l3, angTxt4,graus));
        p.add(criarPainelLabelTextfieldLabel(l4, int2,amperes));
        p.add(criarPainelLabelTextfieldLabel(l5, int3,amperes));
        p.add(criarPainelLabelTextfieldLabel(l6, int4,amperes));
        
        return p;
        
    }
    
    /**
     * cria painel para introduzir label1, campo para introdução dados
     * @param label introduzir label
     * @param texto campo para introdução dados 
     * @return painel para introduzir label1, campo para introdução dados
     */
    private JPanel criarPainelLabelTextfieldLabel(String label, JTextField texto, String label2) {
        JLabel lb1 = new JLabel(label, JLabel.RIGHT);
        JLabel lb2 = new JLabel(label2, JLabel.LEFT);
        lb1.setPreferredSize(LABEL_TAMANHO);
        
        FlowLayout l = new FlowLayout(FlowLayout.LEFT);

        l.setHgap(20);
        l.setVgap(20);
        
        JPanel p = new JPanel(l);

        p.add(lb1);
        p.add(texto);
        p.add(lb2);

        return p;
    }
    /**
     * Cria painel com uma imagem
     * @return painel com uma imagem
     */
    private JPanel criarPainelImagem() {
//************************************++  implementar para escolher imagem   *******************************+
        ImageIcon background = new ImageIcon("src/ficheiros/lightGo.png");
//*************************************************************************************************+++++

        JLabel label = new JLabel();
        label.setIcon(background);

        JPanel panel = new JPanel();
        panel.add(label);

        return panel;
    }
    /**
     * cria painel botão unico
     * @return painel botão unico
     */
    private JPanel criarPainelBotaoUnico(JButton botao) {

        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel(l);
        
        getRootPane().setDefaultButton(botao);
        
        p.add(botao);
        
        return p;
    }
    /**
     * cria painel botão unico
     * @return painel botão unico
     */
    private JPanel criarPainelBotoes() {

        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel(l);
        
        p.add(criarBotaoGuardar());
        p.add(criarBotaoVoltar());
        
        return p;
    }
    /**
     * criar botão Voltar e volta menu anterior
     * @return botão Voltar e volta menu anterior 
     */
    private JButton criarBotaoVoltar() {
        JButton botao = new JButton("Voltar");
        botao.setMnemonic(KeyEvent.VK_V);
        botao.setToolTipText("Cancela a simulacao e volta ao menu anterior");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return botao;
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
        guardar.setEnabled(false);
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //implementar
                    guardarDadosSimulacaoReflexao_EmFicheiro();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PReflexaoUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        return guardar;
    }
    /**
     * criar botão simular 
     * @return botão simular  
     */
    private JButton criarBotaoSimular() {
        simular= new JButton("Simular");
        simular.setMnemonic(KeyEvent.VK_S);
        simular.setToolTipText("Simulacao a polarizacao por reflexão");
        simular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                MeioReflexao meio1=(MeioReflexao)comboMateriais1.getSelectedItem();
                MeioReflexao meio2=(MeioReflexao)comboMateriais2.getSelectedItem();
                controller.setMeioReflexao1(meio1);
                controller.setMeioReflexao2(meio2);
                if(angTxt1.getText().isEmpty() || !controller.setAngulo(Double.parseDouble(angTxt1.getText())))
                  JOptionPane.showMessageDialog(rootPane, "Ângulo inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                else{
                    if(controller.gerarResultado(pr)==true){
                        angTxt2.setText(String.format("%.2f", controller.getFeixeReflexao1()));
                        // angTxt2.setText(String.format("%.2f", controller.getFeixeReflexao2()));
                        angTxt3.setText(String.format("%.2f", controller.getFeixeRefracao())); 
                        angTxt4.setText(String.format("%.2f", controller.getAnguloBrewster()));
                        guardar.setEnabled(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível gerar os resultados.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        return simular;
    }
    /**
     * criar botão nova simulacao
     * @return botão nova simulacao
     */
    private JButton criarBotaoLimpar() {
        limpar= new JButton("Limpar");
        limpar.setMnemonic(KeyEvent.VK_L);
        limpar.setToolTipText("Limpa os dados");
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angTxt1.setText("");
                angTxt2.setText("");
                angTxt3.setText("");
                angTxt4.setText("");
                int1.setText("");
                int2.setText("");
                int3.setText("");
                int4.setText("");
                getRootPane().setDefaultButton(simular);
            }
        });

        return limpar;
    }

    public static JComboBox criarComboMateriais(ListaMeiosReflexao lista) {
        MeioReflexao[] opcoes = lista.getArray();
        JComboBox combo = new JComboBox();
        combo.setSelectedIndex(-1);
        combo.setEditable(false);
        combo.setPreferredSize(new Dimension(200, 20));
        DefaultComboBoxModel comb = new DefaultComboBoxModel(opcoes);

        combo.setModel(comb);

        return combo;
    }
    
    private void guardarDadosSimulacaoReflexao_EmFicheiro() throws FileNotFoundException {
        String outputFile = "reflexaoOutputFile.txt"; //basta q ficheiro esteja dentro da pasta principal deste programa
        Formatter output = new Formatter(new File(outputFile));
        output.format("%s%s %n%s%s %n%s%s %n%s%s %n%s%s %n%s%s %n%s%s %n%s%s %n%s%s", 
                "Meio1:", comboMateriais1.getSelectedItem().toString(),
                "Meio2: ", comboMateriais2.getSelectedItem().toString(),
                "Intensidade: ", int1.getText(), 
                "Angulo Entrada: ", angTxt1.getText(),
                "Angulo Reflexão: ", angTxt2.getText(),
                "Angulo Brewster: ", angTxt3.getText(),
                "Intensidade Reflexao Paralela: ", angTxt4.getText(),
                "Intensidade Reflexao Perpendicular: ", angTxt4.getText(),                
                "Intensidade Refraccao: ", int3.getText());
        output.close();
        JOptionPane.showMessageDialog(this, "Ficheiro guardado com sucesso", "Guardar", JOptionPane.INFORMATION_MESSAGE);
        guardar.setEnabled(false);
    }
//    private boolean lerIntensidade(String imput) {
//        boolean bool = false;
//        //verifica valor de intensidade introduzido e despoleta pop-ups se necessário
//        if (imput.isEmpty()) {
//            popUpMensagemDErro("Insira um valor para a intensidade do feixe incidente!");
//        } else {
//            try {
//                double valor_intensidade = Double.parseDouble(imput);
//                if (!FeixeDLuz.validaIntensidade(valor_intensidade)) {
//                    popUpMensagemDErro("A intensidade do feixe incidente deve ser um valor positivo!");
//                } else {
//                    bool = true;
//                    //continua com confirmação dos restantes inputs antes de fazer setDados
//                }
//            } catch (NumberFormatException ex) { //se não foi introduzido um valor numérico
//                popUpMensagemDErro("A intensidade do feixe incidente deve ser um valor numérico!");
//            }
//        }
//        return bool;
//    }
//
//    private boolean lerAngulo(String input, String tipoDLente) {
//        //verifica valor de anguloDLente introduzido e despoleta pop-ups se necessário
//        boolean bool = false;
//        if (input.isEmpty()) {
//            popUpMensagemDErro("Insira o valor do ângulo de entrada!");
//        } else {
//            try {
//                double valor_intensidade = Double.parseDouble(input);
//                if (!Lente.validaAngulo_emGraus(valor_intensidade)) {
//                    popUpMensagemDErro("Introduza um valor para o ângulo do " + tipoDLente + " no intervalo [(-90) ; 90].");
//                } else {
//                    bool = true;
//                    //continua 
//                }
//            } catch (NumberFormatException ex) { //se não foi introduzido um valor numérico
//                popUpMensagemDErro("O ângulo do " + tipoDLente + " deve ser um valor numérico!");
//            }
//        }
//        return bool;
//    }
//
//    private void popUpMensagemDErro(String msg) {
//        JOptionPane.showMessageDialog(this,
//                msg, "Dados da Simulação", JOptionPane.WARNING_MESSAGE);
//    }
}
