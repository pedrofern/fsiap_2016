/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

/**
 *
 * @author Helder
 */
public abstract class FeixeDLuz {    

    /**
     * Tipos de luz
     */
    public static enum TipoDLuz { NAO_POLARIZADA, POLARIZADA };
    
    private TipoDLuz tipo;
    
    private double intensidade;
    
    private double angulo;

    public FeixeDLuz(TipoDLuz tipo, double intensidade, double angulo) {
        this.tipo = tipo;
        this.intensidade = intensidade;
        this.angulo = angulo;
    }

    public FeixeDLuz(double intensidade, double angulo) {
        this.tipo = TipoDLuz.NAO_POLARIZADA;
        this.intensidade = intensidade;
        this.angulo = angulo;
    }

    public FeixeDLuz() {
        this.tipo = TipoDLuz.NAO_POLARIZADA;
        this.intensidade = 0;
        this.angulo = 0;
    }
        
     public TipoDLuz getTipo() {
        return tipo;
    }

    public void setTipo(TipoDLuz tipo) {
        this.tipo = tipo;
    }

    public double getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(double intensidade) {
        if(validaIntensidade(intensidade))
            this.intensidade = intensidade;
    }
    
    public static boolean validaIntensidade(double intensidade) {
        return intensidade >= 0;
    }      

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    @Override
    public String toString() {
        return "FeixeDLuz{" + "tipo=" + tipo + ", intensidade=" + intensidade + ", angulo=" + angulo + '}';
    }
    
}
