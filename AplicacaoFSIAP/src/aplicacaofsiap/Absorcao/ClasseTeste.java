/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

import java.util.Scanner;

/**
 *
 * @author Helder
 */
public class ClasseTeste {
    

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        //Selecionar tipo de simulação/polarização pretendida
        Simulacao s = new Simulacao(TipoDPolarizacao.ABSORCAO);
        System.out.println("Intensidade do feixe de luz incidente: ");        
        double intensidade = ler.nextDouble();        
        FeixeIncidente f_inc = new FeixeIncidente(FeixeDLuz.TipoDLuz.NAO_POLARIZADA, intensidade, 0);
        
        Polarizador polarizador = new Polarizador(0);
        
        System.out.println("Angulo do analisador com o polarizador: ");        
        double angulo = ler.nextDouble();        
        Analisador analisador = new Analisador(angulo);
        
        FeixeResultante feixe_resultante = new FeixeResultante();
               
        PolarizacaoPorAbsorcao pol_por_abs = new PolarizacaoPorAbsorcao(f_inc,
                polarizador, analisador, new FeixeResultante());
        
        s.setPolarizacao(pol_por_abs);
        
        System.out.println("Resultados: ");
        double intensidadeFinal = s.obterIntensidadeDFeixeResultante_AposAnalisador(angulo);
        System.out.println("Intensidade Final do Feixe:" + intensidadeFinal);
        
        //System.out.printf("%.1f" + Math.round(Math.pow(Math.cos(Math.toRadians(angulo)), 2))/1.0);
        
        System.out.println("Fim do Teste");
    }
}
