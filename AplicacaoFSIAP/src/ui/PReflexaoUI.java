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
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author Pedro Fernandes and Diana Silva (controller)
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
    private JTextField angIncidencia, angReflexaoRes, angRefracaoRes, angBrewster, intIncidencia,intReflexaoPar,intReflexaoPerp,intRefracao;
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
     * dados do grafico
     */
    private XYSeriesCollection dataset;
    /**
     * painel do grafico
     */
    private ChartPanel chartPanel;
    
    
    /**
     * Constroi uma janela para simular polarizao por reflexao
     * recebendo a janela anterior como parametro
     * @param framePai janela anterior
     * @param lg
     * @param s
     */
    public PReflexaoUI(DefinirPolarizaoUI framePai, LightGo lg, Simulacao s){
        super(framePai, "LIGHT GO -> Polarização por Reflexão", true);
        
        this.framePai = framePai;
        this.pr=s.getPolarizacaoPorReflexao();
        this.controller=new PReflexaoController(lg, s);
        
        listaMeios =controller.getListaMeios();
        
        criarComponentes();
        
        setMinimumSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
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
        
        angIncidencia = new JTextField(10);
        intIncidencia = new JTextField(10);
        
        p.add(criarPainelLabelTextfieldLabel("Intensidade:", intIncidencia,"(W/m2)"));
        p.add(criarPainelLabelTextfieldLabel("Ângulo entrada:", angIncidencia,"(º Graus)"));
        
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
        p.add(criarPainelGrafico(),BorderLayout.CENTER);
        p.add(criarPainelBotaoUnico(criarBotaoLimpar()),BorderLayout.SOUTH);
        
        return p;           
    }
    
    private JPanel criarPainelAngulos(){
        JPanel p = new JPanel(new GridLayout(6,1));
        
        p.setBorder(new TitledBorder("Ângulos e Intensidades Resultantes:"));
        
        angReflexaoRes = new JTextField(10);
        angRefracaoRes = new JTextField(10);
        angBrewster= new JTextField(10);
        intReflexaoPar= new JTextField(10);
        intReflexaoPerp= new JTextField(10);
        intRefracao= new JTextField(10);
        angReflexaoRes.setEditable(false);
        angRefracaoRes.setEditable(false);
        angBrewster.setEditable(false);
        intReflexaoPar.setEditable(false);
        intReflexaoPerp.setEditable(false);
        intRefracao.setEditable(false);
        
        String graus = "(º Graus)";
        String amperes = "(%)";
        
        String l1="Ângulo Reflexão:";
        String l2="Ângulo Refração:";
        String l3="Ângulo Brewster:";
        String l4="Refletância (direção paralela):";
        String l5="Refletância (direção perpendicular):";
        String l6="Refratância:";
        
        p.add(criarPainelLabelTextfieldLabel(l1, angReflexaoRes,graus));
        p.add(criarPainelLabelTextfieldLabel(l2, angRefracaoRes,graus));
        p.add(criarPainelLabelTextfieldLabel(l3, angBrewster,graus));
        p.add(criarPainelLabelTextfieldLabel(l4, intReflexaoPar,amperes));
        p.add(criarPainelLabelTextfieldLabel(l5, intReflexaoPerp,amperes));
        p.add(criarPainelLabelTextfieldLabel(l6, intRefracao,amperes));
        
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
     * Cria painel com um grafico
     * @return painel com um grafico
     */
    private ChartPanel criarPainelGrafico() {

        dataset = new XYSeriesCollection();

        JFreeChart xylineChart = ChartFactory.createXYLineChart(
         "Angulos",
         "","",
         dataset,
         PlotOrientation.VERTICAL,
         true,false,false);
        
        XYPlot plot = xylineChart.getXYPlot( );
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.CYAN);
        renderer.setSeriesPaint( 2 , Color.BLUE );
        renderer.setSeriesPaint( 3 , Color.BLACK );
        renderer.setSeriesPaint( 4 , Color.BLACK );
        renderer.setBaseShapesVisible(false);
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 3 , new BasicStroke( 2.0f ) );
        renderer.setSeriesStroke( 4 , new BasicStroke( 2.0f ) );
        plot.setRenderer( renderer ); 
        
        chartPanel = new ChartPanel(xylineChart);
        
        return chartPanel;
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
                if(lerAngulo()){
                    controller.setAngulo(Double.parseDouble(angIncidencia.getText()));
                    if(lerIntensidade()){                        
                        controller.setIntensidade(Double.parseDouble(intIncidencia.getText()));
                        if(controller.gerarResultado()==true){
                            //adiciona dados da simulação à lista para efeitos de estatística
                            controller.addListaSimulacoes();
                            
                            angReflexaoRes.setText(String.format("%.2f", controller.getFeixeReflexao1().getAngulo()));
                            angRefracaoRes.setText(String.format("%.2f", controller.getFeixeRefracao().getAngulo())); 
                            angBrewster.setText(String.format("%.2f", controller.getAnguloBrewster()));

                            intReflexaoPar.setText(String.format("%.2f", controller.getFeixeReflexao1().getIntensidade()));
                            intReflexaoPerp.setText(String.format("%.2f", controller.getFeixeReflexao2().getIntensidade()));
                            intRefracao.setText(String.format("%.2f", controller.getFeixeRefracao().getIntensidade()));
    
                            // adiciona dados ao grafico
                            double angInc= Double.parseDouble(angIncidencia.getText());
                            double angRefra= controller.getFeixeRefracao().getAngulo();
                            double angRefle= controller.getFeixeReflexao1().getAngulo();

                            dataset.removeAllSeries();
                            
                            XYSeries serie0 = new XYSeries("INCIDENCIA");
                            XYSeries serie1 = new XYSeries("REFRACAO");
                            XYSeries serie2 = new XYSeries("REFLEXAO");
                            XYSeries serie3 = new XYSeries("EIXO Y");
                            XYSeries serie4 = new XYSeries("EIXO X");
                            
                            if(meio1==meio2){
                                serie0.add(-((Math.tan(Math.toRadians(angInc)))), 1.0);
                                serie0.add(0, 0);                                
                                serie0.add(((Math.tan(Math.toRadians(angInc)))), -1.0);

                            }else{
                                if(angInc==90){
                                    serie0.add(0, 0);
                                    serie0.add(0, 1.0);
                                    
                                    serie1.add(0, 0);
                                    serie1.add(0, -1.0);
                                }else{
                                serie0.add(0, 0);
                                serie0.add(-((Math.tan(Math.toRadians(angInc)))), 1.0);

                                serie1.add(0, 0);
                                serie1.add((Math.tan(Math.toRadians(angRefra))), -1.0);

                                serie2.add(0, 0);
                                serie2.add(((Math.tan(Math.toRadians(angRefle)))), 1.0);
                                }
                            }

                            //para manter escala x=1,y=1
                            serie3.add(0.0, 1.0);
                            serie3.add(0.0, -1.0);
                            serie4.add(1.0, 0.0);
                            serie4.add(-1.0, 0.0);
      
                            dataset.addSeries(serie0);
                            dataset.addSeries(serie1);
                            dataset.addSeries(serie2);
                            dataset.addSeries(serie3);
                            dataset.addSeries(serie4);
                            
                            chartPanel.revalidate();
                            chartPanel.repaint();
                            
                            // guarda para ficheiro
                            guardar.setEnabled(true);
                            
                        }
                        else{
                            popUpMensagemDErro("Não foi possível gerar os resultados!");
                        }
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
                angIncidencia.setText("");
                angReflexaoRes.setText("");
                angRefracaoRes.setText("");
                angBrewster.setText("");
                intIncidencia.setText("");
                intReflexaoPar.setText("");
                intReflexaoPerp.setText("");
                intRefracao.setText("");
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
                "Meio1: ", comboMateriais1.getSelectedItem().toString(),
                "Meio2: ", comboMateriais2.getSelectedItem().toString(),
                "Intensidade: ", intIncidencia.getText(), 
                "Angulo Entrada: ", angIncidencia.getText(),
                "Angulo Reflexao: ", angReflexaoRes.getText(),
                "Angulo Brewster: ", angBrewster.getText(),
                "Intensidade Reflexao Paralela: ", intReflexaoPar.getText(),
                "Intensidade Reflexao Perpendicular: ", intReflexaoPerp.getText(),                
                "Intensidade Refraccao: ", intRefracao.getText());
        output.close();
        JOptionPane.showMessageDialog(this, "Ficheiro guardado com sucesso", "Guardar", JOptionPane.INFORMATION_MESSAGE);
        guardar.setEnabled(false);
    }
    private boolean lerIntensidade() {
        boolean bool = false;
        try {
        if (intIncidencia.getText().isEmpty() || !controller.setIntensidade(Double.parseDouble(intIncidencia.getText()))) {
            popUpMensagemDErro("Intensidade inválida!");
        }else{
            bool = true;
        }
        }catch (NumberFormatException ne){
               popUpMensagemDErro("Introduza um número entre 0º e 90º no campo Angulo!");
               return false;
        }
        return bool;
    }

    private boolean lerAngulo() {
        boolean bool = false;
        try {
        if (angIncidencia.getText().isEmpty() || !controller.setAngulo(Double.parseDouble(angIncidencia.getText()))) {
            popUpMensagemDErro("Angulo Inválido!");
        }else{
            bool = true;
        }
        }catch (NumberFormatException ne){
               popUpMensagemDErro("Introduza um número no campo Intensidade!");
               return false;
        }
        return bool;
    }

    private void popUpMensagemDErro(String msg) {
        JOptionPane.showMessageDialog(this,
                msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
}
