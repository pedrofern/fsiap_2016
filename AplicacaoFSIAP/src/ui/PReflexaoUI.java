/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import aplicacaofsiap.ListaMeiosReflexao;
import aplicacaofsiap.MeioReflexao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Pedro Fernandes
 */
public class PReflexaoUI extends JFrame{
    
    /**
     * Guarda a janela anterior
     */
    private DefinirPolarizaoUI framePai;
    /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 900;
    /**
     * Guarda a altura mínima da janela em píxeis.
     */
    private static final int JANELA_ALTURA_MINIMO = 550; 
    /**
     * Guarda a dimensão de uma label por omissão
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Ângulo entrada (º Graus):").
                                                        getPreferredSize();
    /**
     * Guarda o angulo1
     */
    private JTextField angTxt1;
    /**
     * Guarda o angulo2
     */
    private JTextField angTxt2;
    /**
     * Guarda o botao nova simulacao
     */
    private JButton novaSimulacao;
    /**
     * Guarda o botao simular
     */
    private JButton simular;
    /**
     * Guarda lista com materiais numa combobox
     */
    private JComboBox comboMateriais1;
    /**
     * Guarda lista com materiais numa combobox
     */
    private JComboBox comboMateriais2;
    /**
     * Guarda lista dos materiais
     */
    private ListaMeiosReflexao listaMeios;
    
    
    /**
     * Constroi uma janela para simular polarizao por reflexao
     * recebendo a janela anterior como parametro
     * @param framePai janela anterior
     */
    public PReflexaoUI(DefinirPolarizaoUI framePai){
        super("LIGHT GO -> Polarização por Reflexão");
        
        this.framePai = framePai;
//        listaMeios = getlista meios();
listaMeios =new ListaMeiosReflexao();
        
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
        JPanel p3 = criarPainelBotaoUnico(criarBotaoVoltar());
        
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
        
        comboMateriais1 = criarComboMateriais(listaMeios);
        comboMateriais2 = criarComboMateriais(listaMeios);
        
        String label="Ângulo entrada (º Graus):";
        angTxt1 = new JTextField(10);

        
        p.add(criarPainelComboMateriais("Material 1",comboMateriais1));
        p.add(criarPainelComboMateriais("Material 2",comboMateriais2));
        p.add(criarPainelLabelTextfield(label, angTxt1));
        
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
        p.add(criarPainelBotaoUnico(criarBotaoNovaSimulacao()),BorderLayout.SOUTH);
        novaSimulacao.setEnabled(false);
        
        return p;           
    }
    
    private JPanel criarPainelAngulos(){
        JPanel p = new JPanel(new GridLayout(2,1));
        
        p.setBorder(new TitledBorder("Ângulos:"));
        
        angTxt1 = new JTextField(10);
        angTxt2 = new JTextField(10);
        angTxt1.setEditable(false);
        angTxt2.setEditable(false);
        
        String label1="Ângulo 1 (º Graus):";
        String label2="Ângulo 2 (º Graus):";
        
        p.add(criarPainelLabelTextfield(label1, angTxt1));
        p.add(criarPainelLabelTextfield(label2, angTxt2));
        
        return p;
        
    }
    
    /**
     * cria painel para introduzir label1, campo para introdução dados
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
     * Cria painel com uma imagem
     * @return painel com uma imagem
     */
    private JPanel criarPainelImagem() {
//************************************++  implementar para escolher imagem   *******************************+
        ImageIcon background = new ImageIcon("src/ficheiros/imagem.jpg");
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
                //implementar
            }
        });

        return simular;
    }
    /**
     * criar botão nova simulacao
     * @return botão nova simulacao
     */
    private JButton criarBotaoNovaSimulacao() {
        novaSimulacao= new JButton("Nova Simulação");
        novaSimulacao.setMnemonic(KeyEvent.VK_N);
        novaSimulacao.setToolTipText("Nova Simulacao - polarizacao por reflexão");
        novaSimulacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementar
            }
        });

        return novaSimulacao;
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
}
