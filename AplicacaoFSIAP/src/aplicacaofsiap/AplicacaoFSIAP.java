/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import ui.DefinirPolarizaoUI;

/**
 *
 * @author 
 */
public class AplicacaoFSIAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LightGo s= new LightGo();
        
        DefinirPolarizaoUI definir = new DefinirPolarizaoUI(s);
//        LightGo simulacao = new LightGo();
//        CarregarFicheiroController teste = new CarregarFicheiroController(simulacao);
//        teste.carregaMeios();
//        for(int i=0; i < simulacao.getListaMeios().tamanho(); i++){
//            System.out.println(simulacao.getListaMeios().obterMeioReflexao(i).toString());
//        }
        
    }
    
}
