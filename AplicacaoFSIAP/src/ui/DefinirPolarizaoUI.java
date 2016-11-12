/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import aplicacaofsiap.Simulacao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
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

/**
 * Constrói a janela principal da aplicação
 * 
 * @author Pedro Fernandes
 */
public class DefinirPolarizaoUI extends JFrame{
    
    /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 800;
    /**
     * Guarda a altura mínima da janela em píxeis.
     */
    private static final int JANELA_ALTURA_MINIMO = 450;      
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
    private CarregarFicheiroUI cfui;
    
    private Simulacao s;
    
    public DefinirPolarizaoUI(Simulacao s){
        super("LIGHT GO");
        this.s=s;
        framePai = DefinirPolarizaoUI.this;
        
        JPanel botoes = criarBotoes();
        JPanel imagem = criarPainelImagem();
        
        add(imagem, BorderLayout.NORTH);
        add(botoes, BorderLayout.SOUTH);
        
        criarBarraMenus();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        setLocationRelativeTo(null);
        pack();
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
        FlowLayout gl = new FlowLayout();

        gl.setHgap(10);
        gl.setVgap(10);

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;

        JPanel p = new JPanel(gl);
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(criarBotaoAbsorcao());
        p.add(criarBotaoReflexao());
        p.add(criarBotaoCarregaFich());
        p.add(criarBotaoSair());

        this.getRootPane().setDefaultButton(botaoAbsorcao);

        return p;
    }
    /**
     * cria botão absorcao
     * @return botão absorcao
     */
    private JButton criarBotaoAbsorcao() {
        botaoAbsorcao = new JButton("Absorção");
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
        botaoAbsorcao = new JButton("Carregar Ficheiro");
        botaoAbsorcao.setMnemonic(KeyEvent.VK_C);
        botaoAbsorcao.setToolTipText("Carrega os Meios de Reflexao através ficheiro txt");
        botaoAbsorcao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregaFicheiro();
            }
        });

        return botaoAbsorcao;
    }
    /**
     * cria botão reflexao
     * @return botão reflexao
     */
    private JButton criarBotaoReflexao() {
        botaoReflexao = new JButton("Reflexão");
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
        ImageIcon background = new ImageIcon("src/ficheiros/imagem.jpg");
        JLabel label = new JLabel();
        label.setIcon(background);

        JPanel panel = new JPanel();
        panel.add(label);

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
     * cria MenuItem absorcao
     * @return MenuItem absorcao
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
     * Método para abrir PolarizacaoPorAbsorcao
     */
    private void absorcao() {
        //implementar
    }
    /**
     * Método para abrir PolarizacaoPorReflexao 
     */
    private void reflexao() {
        prui = new PReflexaoUI(DefinirPolarizaoUI.this);
    }
    /**
     * Método para abrir PolarizacaoPorReflexao 
     */
    private void carregaFicheiro() {
        cfui = new CarregarFicheiroUI(DefinirPolarizaoUI.this, s);
    }
    /**
     * Método para guardar a informação em ficheiro e fechar a aplicação
     */
    private void terminar() {        
        // implementar para guardar informacao em ficheiro
        dispose(); 
    }
    
}
