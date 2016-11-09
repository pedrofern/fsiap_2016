/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.ListaMeiosReflexao;
import aplicacaofsiap.MeioReflexao;
import aplicacaofsiap.PolarizacaoPorReflexao;
import aplicacaofsiap.Simulacao;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Controller para carregar ficheiros
 * 
 * @author Pedro Fernandes
 */
public class CarregarFicheiroController {
    
    private Simulacao simulacao;
    
    private PolarizacaoPorReflexao ppr;
    
    private ListaMeiosReflexao lm;
    
    private static final String FICHEIRO_MEIOS = "src/ficheiros/meioReflexao.txt";
    
    public CarregarFicheiroController(Simulacao s){
        simulacao=s;
        lm=simulacao.getListaMeios();
    }
    
    public boolean carregaMeios(){
        try {
            Scanner fInput = new Scanner(new File(FICHEIRO_MEIOS));
            while (fInput.hasNextLine()) {
                String str = fInput.nextLine();
                if (!str.isEmpty()) {
                    String[] temp = str.split(",");              
                    MeioReflexao m = new MeioReflexao(temp[0].trim(), Double.parseDouble(temp[1].trim()));
                    lm.registaMeio(m);
                }
            }
            fInput.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
        
    }
    
}
