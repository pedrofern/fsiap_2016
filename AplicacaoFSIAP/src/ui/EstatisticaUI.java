/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import aplicacaofsiap.LightGo;
import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import controller.GerarEstatisticaController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
* UserInterface que permite ao utilizador visualizar as estatísticas das simulações 
* da polarização por reflexão criadas
 * @author Diana Silva
 */
public class EstatisticaUI extends JDialog{
    
     /**
     * Guarda a janela anterior
     */
    private DefinirPolarizaoUI framePai;
    
    /**
     * Controller que permite efetuar as operações relativas à estatística
     */
    private GerarEstatisticaController controller;
    
    /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 1200, JANELA_ALTURA_MINIMO =700;

    /**
     * Guarda a dimensão de uma label por omissão
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Intensidade: ").
            getPreferredSize();
    
    /**
     * Painel da tabela de estatísticas
     */
    private JPanel painelTabela, painelGraficos;
    
/**
 * Constrói uma janela para gerar estatísticas das simulações da polarização por 
* reflexão recebendo a janela anterior como parametro
 * @param framePai
 * @param lg 
 */
    public EstatisticaUI(DefinirPolarizaoUI framePai, LightGo lg){
         super(framePai, "LIGHT GO -> Polarização por Absorção", true);

        this.framePai = framePai;
        this.controller = new GerarEstatisticaController(lg);

        criarComponentes();

        pack();
        setResizable(false);
        setSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    
    private void criarComponentes(){
        add(criarPainelTabela(), BorderLayout.CENTER);
    }
    
    public JPanel criarPainelTabela(){
        painelTabela=new JPanel();   
        painelTabela.setLayout(new BorderLayout());
        painelTabela.setBorder(new TitledBorder("Estatística (Polarização por reflexão):"));
        painelTabela.add(criarTabela(), BorderLayout.NORTH);
        painelTabela.add(criarGraficos(), BorderLayout.CENTER);
        return painelTabela;    
    
    } 
    private JTable criarTabela(){
        DefaultTableModel modeloEstatistica=new DefaultTableModel();
        JTable table = new JTable(modeloEstatistica);
         
       // modeloEstatistica.addColumn("Col1");
        String[] colunas = {"Meio1(n)","Meio2(n)","Coeficiente Refração", "Ângulo Brewster"};
    
        for (String coluna : colunas) {
               modeloEstatistica.addColumn(coluna);
        }
    
        table.setModel(modeloEstatistica);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        painelTabela.add(scrollPane);
          
        
        if(controller.getListaPolarizacoesReflexao()!=null || !controller.getListaPolarizacoesReflexao().isEmpty()){
            
            /**para uma melhor leitura, os dados estão ordenados pelo ângulo de brewster obtido)**/
            controller.ordenar();
            for(PolarizacaoPorReflexao polarizacaoRef:controller.getListaPolarizacoesReflexao()){
                     modeloEstatistica.addRow(polarizacaoRef.toStringEstatistica());
            }
        }
    
        return table;
    } 
    
    private JPanel criarGraficos(){
        painelGraficos=new JPanel();   
        painelGraficos.setLayout(new BorderLayout());
        painelGraficos.setBorder(new TitledBorder("Estatística Geral (vácuo):"));
        Icon imagem1 = new ImageIcon( "src/ficheiros/Brewster.JPG" );
        
        JLabel grafico1=new JLabel(imagem1);
        Icon imagem2 = new ImageIcon( "src/ficheiros/Brewster2.JPG" );
        JLabel grafico2=new JLabel(imagem2);
        
        painelGraficos.add(grafico1, BorderLayout.WEST);
        painelGraficos.add(grafico2, BorderLayout.EAST);
       
        return painelGraficos;
    }
}
