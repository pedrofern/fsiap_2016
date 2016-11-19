/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

import aplicacaofsiap.TipoDPolarizacao;
import aplicacaofsiap.Simulacao;
import aplicacaofsiap.FeixeDLuzIncidente;
import aplicacaofsiap.FeixeDLuzResultante;
import aplicacaofsiap.FeixeDLuz;
import java.util.Scanner;

/**
 *
 * @author Helder
 */
public class ClasseTesteAbsorcao {
    

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        //Selecionar tipo de simulação/polarização pretendida
        Simulacao s = new Simulacao(TipoDPolarizacao.ABSORCAO);
        System.out.print("Introduza os seguintes dados:\n-intensidade do feixe de luz incidente: ");        
        double intensidade = ler.nextDouble();        
        FeixeDLuzIncidente f_inc = new FeixeDLuzIncidente(FeixeDLuz.TipoDLuz.NAO_POLARIZADA, intensidade, 0);
        
        Polarizador polarizador = new Polarizador(0);
        
        System.out.print("-angulo do analisador com o polarizador: ");        
        double angulo = ler.nextDouble();        
        Analisador analisador = new Analisador(angulo);
        
        FeixeDLuzResultante f_int = new FeixeDLuzResultante();
          
        FeixeDLuzResultante feixe_resultante = new FeixeDLuzResultante();
               
        PolarizacaoPorAbsorcao pol_por_abs = new PolarizacaoPorAbsorcao(f_inc,
                polarizador, f_int, analisador, feixe_resultante);
       
        System.out.println("\nResultados: ");

        System.out.println(""+ pol_por_abs.resultadosDPolarizacaoToString());

        System.out.println("Fim do Teste");
                
    }
}
