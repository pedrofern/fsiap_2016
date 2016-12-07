/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.Reflexao.ListaMeiosReflexao;
import aplicacaofsiap.Reflexao.MeioReflexao;
import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
import aplicacaofsiap.LightGo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Controller para carregar ficheiros
 * 
 * @author Pedro Fernandes
 */
public class CarregarFicheiroController {
    
    private LightGo light_go;
    
    private PolarizacaoPorReflexao ppr;
    
    private ListaMeiosReflexao lm;
    
    private static final String FICHEIRO_MEIOS = "src/ficheiros/meioReflexao.txt";
    
    public CarregarFicheiroController(LightGo lg){
        light_go=lg;
        lm=light_go.getListaMeios();
    }
    
    public boolean carregaMeios(String ficheiro){
        try {
            Scanner fInput = new Scanner(new File(ficheiro));
            while (fInput.hasNextLine()) {
                String str = fInput.nextLine();
                if (!str.isEmpty()) {
                    String[] temp = str.split(",");              
                    if(validaNome(temp[0].trim()) == true && validaIndice(temp[1].trim()) == true){
                        MeioReflexao m = new MeioReflexao(temp[0].trim(), Double.parseDouble(temp[1].trim()));
                        boolean valida = m.valida();
                        if(valida){
                            lm.registaMeio(m);
                        }
                    }
                }
            }
            fInput.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Não foi encontrado ficheiro de carrgamento automatico");
            return false;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro ao carregar ficheiro => ficheiro danificado");
            return false; 
         }
        
    }
    
    public boolean carregaMeiosAutomaticamente(){
        return carregaMeios(FICHEIRO_MEIOS);
    }
    
    public boolean validaNome(String nome){
        if(nome != null && !nome.isEmpty()){
            return true;
        }else{
            System.out.println("Nome inválido!");
            return false;
        }
    }
    
    public boolean validaIndice(String indice){
       
            if(indice != null){
                 try{
                if(Double.parseDouble(indice)>=1){
                    return true;
                }else{
                    return false;
                }
            
                 }catch (NumberFormatException e){
            System.out.println("Indice inválido!");
            return false; 
                 }}
            else{
                return false;
            }
        
        
    }
}
