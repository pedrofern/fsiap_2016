/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import aplicacaofsiap.LightGo;
import aplicacaofsiap.Simulacao;
import aplicacaofsiap.TipoDPolarizacao;
import controller.CarregarFicheiroController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * Constrói a janela principal da aplicação
 * 
 * @author Pedro Fernandes
 */
public class DefinirPolarizaoUI extends JFrame{
            /**
     * O controller Carregar Ficheiro (para carregar auto)
     */
    private CarregarFicheiroController controlFicheiro;    
    /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 820;
    /**
     * Guarda a altura mínima da janela em píxeis.
     */
    private static final int JANELA_ALTURA_MINIMO = 750;      
    /**
     * Representa o botão absorcao
     */
    private JButton botaoAbsorcao;
    /**
     * Representa o botão reflexao
     */
    private JButton botaoReflexao;
    /**
     * Representa o botão carrega
     */
    private JButton botaoCarrega;
    /**
     * Identifica a janela principal
     */
    private DefinirPolarizaoUI framePai;
    private PReflexaoUI prui;
    private PAbsorcaoUI paui;
    private EstatisticaUI peui;
    private CarregarFicheiroUI cfui;
    
    private LightGo lg;
    
    public DefinirPolarizaoUI(LightGo lg){
        super("LIGHT GO");
        this.lg=lg;
        framePai = DefinirPolarizaoUI.this;
        
        controlFicheiro = new CarregarFicheiroController(lg);
        controlFicheiro.carregaMeiosAutomaticamente();
        
        JPanel botoes = criarBotoes();
        JPanel imagem = criarPainelImagem();
        
        add(imagem, BorderLayout.CENTER);
        add(botoes, BorderLayout.EAST);
        JPanel painelBtnSair = new JPanel(new BorderLayout());
        painelBtnSair.setBorder(new EmptyBorder(0, 30, 10, 30));
        painelBtnSair.add(criarBotaoSair(), BorderLayout.CENTER);
        add(painelBtnSair, BorderLayout.SOUTH);
        
        criarBarraMenus();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        pack();
        setLocationRelativeTo(null);      
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                terminar();
            }
        });
    }
    
    /**
     * cria botões
     * @return botões
     */
    private JPanel criarBotoes() {
        GridLayout gl = new GridLayout(3,1);

        gl.setHgap(30);
        gl.setVgap(30);

        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 30, MARGEM_DIREITA = 30;

        JPanel p = new JPanel(gl);
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(criarBotaoAbsorcao());
        p.add(criarBotaoReflexao());
        p.add(criarBotaoCarregaFich());
        p.add(criarBotaoEstatistica());

        this.getRootPane().setDefaultButton(botaoAbsorcao);

        return p;
    }
    /**
     * cria botão absorcao
     * @return botão absorcao
     */
    private JButton criarBotaoAbsorcao() {
        Icon icone = new ImageIcon( "src/ficheiros/polarização_absorcao.jpg" );
        botaoAbsorcao = new JButton(" Absorção", icone);
        botaoAbsorcao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoAbsorcao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoAbsorcao.setMnemonic(KeyEvent.VK_A);
        botaoAbsorcao.setToolTipText("Simula uma Polarização por Absorção");
        botaoAbsorcao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                absorcao();
            }
        });

        return botaoAbsorcao;
    }
    /**
     * cria botão carrega
     * @return botão carrega
     */
    private JButton criarBotaoCarregaFich() {
        Icon icone = new ImageIcon("src/ficheiros/carregaFich.png");
        botaoCarrega = new JButton("Carregar Ficheiro", icone);
        botaoCarrega.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoCarrega.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoCarrega.setMnemonic(KeyEvent.VK_C);
        botaoCarrega.setToolTipText("Carrega os Meios de Reflexao através ficheiro txt");
        botaoCarrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregaFicheiro();
            }
        });

        return botaoCarrega;
    }
    /**
     * cria botão reflexao
     * @return botão reflexao
     */
    private JButton criarBotaoReflexao() {
        Icon icone = new ImageIcon( "src/ficheiros/polarização_reflexao.jpg" );
        botaoReflexao = new JButton(" Reflexão", icone);
        botaoReflexao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoReflexao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoReflexao.setMnemonic(KeyEvent.VK_R);
        botaoReflexao.setToolTipText("Simula uma Polarização por Reflexão");
                
        botaoReflexao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reflexao();
            }
        });

        return botaoReflexao;
    }
    
     /**
     * cria botão reflexao
     * @return botão reflexao
     */
    private JButton criarBotaoEstatistica() {
        Icon icone = new ImageIcon( "src/ficheiros/polarização_reflexao.jpg" );
        botaoReflexao = new JButton(" Estatística", icone);
        botaoReflexao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoReflexao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoReflexao.setMnemonic(KeyEvent.VK_E);
        botaoReflexao.setToolTipText("Gera a estatística de polarização por reflexão");
                
        botaoReflexao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estatistica();
            }
        });

        return botaoReflexao;
    }
    
    
    /**
     * cria botão Sair
     * @return botão Sair
     */
    private JButton criarBotaoSair() {
        JButton botao = new JButton("Sair");
        botao.setMnemonic(KeyEvent.VK_S);
        botao.setToolTipText("Termina a execução do programa");

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terminar();
            }
        });

        return botao;
    }
    /**
     * Cria painel com uma imagem
     * @return painel com uma imagem
     */
    private JPanel criarPainelImagem() {
        ImageIcon background = new ImageIcon("src/ficheiros/lightGoExpand.png");
        
        JLabel label = new JLabel();
        label.setIcon(background);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 10, 10, 10));
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }
    
    /**
     * Constrói a barra menus da janela
     * @return barra menus
     */
    private JMenuBar criarBarraMenus() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuBar.add(criarMenuMenu());
        menuBar.add(criarMenuOpcoes());

        return menuBar;
    }
    /**
     * cria menu Menu na barra menu
     * @return menu Menu
     */
    private JMenu criarMenuMenu() {
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        
        menu.add(criarItemCarregarFicheiroMateriais());
        menu.addSeparator();
        menu.add(criarItemAbsorcao());
        menu.add(criarItemReflexao());
        menu.add(criarItemEstatistica());
        menu.addSeparator();
        menu.add(criarItemSair());

        return menu;
    }
    /**
     * cria MenuItem Sair
     * @return MenuItem Sair
     */
    private JMenuItem criarItemCarregarFicheiroMateriais() {
        JMenuItem item = new JMenuItem("Carregar Materiais", KeyEvent.VK_C);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregaFicheiro();
            }
        });
        return item;
    }
    /**
     * cria menu Opções na barra menu
     * @return menu Opções 
     */
    private JMenu criarMenuOpcoes() {
        JMenu menu = new JMenu("Opções");
        menu.setMnemonic(KeyEvent.VK_O);

        menu.add(criarSubMenuEstilo());
        menu.addSeparator();
        menu.add(criarItemAcerca());

        return menu;
    }    
    /**
     * cria MenuItem Sair
     * @return MenuItem Sair
     */
    private JMenuItem criarItemSair() {
        JMenuItem item = new JMenuItem("Sair", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terminar();
            }
        });
        return item;
    }
    /**
     * cria SubMenu Estilos
     * @return SubMenu Estilos
     */
    private JMenu criarSubMenuEstilo() {
        JMenu menu = new JMenu("Estilo");
        menu.setMnemonic(KeyEvent.VK_E);

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            menu.add(criarItemEstilo(info));
        }

        return menu;
    }
    /**
     * cria Item Estilo
     * @param info 
     * @return Item Estilo
     */
    private JMenuItem criarItemEstilo(UIManager.LookAndFeelInfo info) {
        JMenuItem item = new JMenuItem(info.getName());

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if (menuItem.getActionCommand().equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    SwingUtilities.updateComponentTreeUI(DefinirPolarizaoUI.this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DefinirPolarizaoUI.this,
                            ex.getMessage(),
                            "Estilo " + menuItem.getActionCommand(),
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return item;
    }
    /**
     * cria MenuItem Acerca
     * @return MenuItem Acerca
     */
    private JMenuItem criarItemAcerca() {
        JMenuItem item = new JMenuItem("Acerca", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(DefinirPolarizaoUI.this,
                    "@Copyright\nFSIAP 2015/2016\n"
                        + "\nAplicação sobre:\n"
                        + "- Polarização Absorção\n"
                        + "- Polarização Reflexão\n"
                        + "\nTurma: 2DJ - Grupo 4:\n"
                        + "1151088 - Diana Silva\n" 
                        + "1150693 - Gonçalo Silva\n" 
                        + "1140808 - Hélder Silva\n" 
                        + "1060503 - Pedro Fernandes\n",                            
                    "Acerca",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return item;
    }
    /**
     * cria MenuItem absorcao
     * @return MenuItem absorcao
     */
    private JMenuItem criarItemAbsorcao() {
        JMenuItem item = new JMenuItem("Absorção", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                absorcao();
            }
        });
        return item;
    }
    
    /**
     * cria MenuItem reflexao
     * @return MenuItem reflexao
     */
    private JMenuItem criarItemReflexao() {
        JMenuItem item = new JMenuItem("Reflexão", KeyEvent.VK_R);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reflexao();
            }
        });
        return item;
    }
    
    
     /**
     * cria MenuItem estatistica
     * @return MenuItem estatistica
     */
    private JMenuItem criarItemEstatistica() {
        JMenuItem item = new JMenuItem("Estatística", KeyEvent.VK_E);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estatistica();
            }
        });
        return item;
    }
    
    /**
     * Método para abrir PolarizacaoPorAbsorcao
     */
    private void absorcao() {
        paui = new PAbsorcaoUI(this);
    }
    /**
     * Método para abrir PolarizacaoPorReflexao 
     */
    private void reflexao() {       
            Simulacao s=new Simulacao(TipoDPolarizacao.REFLEXAO);
            prui = new PReflexaoUI(this,lg,s); 
    }
    
    /**
     * Método para gerar estatísticas
     */
    private void estatistica() {
        peui = new EstatisticaUI(this,lg);
    }
    
    /**
     * Método para abrir PolarizacaoPorReflexao 
     */
    private void carregaFicheiro() {
        cfui = new CarregarFicheiroUI(DefinirPolarizaoUI.this, lg);
    }
    /**
     * Método para guardar a informação em ficheiro e fechar a aplicação
     */
    private void terminar() {        
        // implementar para guardar informacao em ficheiro
        dispose(); 
    }
    
}
