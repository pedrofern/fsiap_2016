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
public abstract class Polarizacao {

    private FeixeIncidente f_incidente;

    public Polarizacao(FeixeIncidente f_incidente) {
        this.f_incidente = f_incidente;
    }

    public Polarizacao() {
        this.f_incidente = new FeixeIncidente();
    }

    public FeixeIncidente getF_incidente() {
        return f_incidente;
    }

    public void setF_incidente(FeixeIncidente f_incidente) {
        this.f_incidente = f_incidente;
    }

    @Override
    public String toString() {
        return "Polarizacao{" + "f_incidente=" + f_incidente + '}';
    }

}
