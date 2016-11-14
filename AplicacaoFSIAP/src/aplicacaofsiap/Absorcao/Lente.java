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

public abstract class Lente {
    
    private double angulo_emGraus;

    public Lente(double angulo_emGraus) {
        this.angulo_emGraus = angulo_emGraus;
    }
    
    public double getAngulo_emGraus() {
        return angulo_emGraus;
    }

    public void setAngulo_emGraus(double angulo_emGraus) {
        this.angulo_emGraus = angulo_emGraus;
    }

    @Override
    public String toString() {
        return "Lente{" + "angulo_emGraus=" + angulo_emGraus + '}';
    }

}
