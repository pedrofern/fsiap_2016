/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap;

import aplicacaofsiap.FeixeDLuzIncidente;

/**
 *
 * @author Helder
 */
public abstract class Polarizacao {

    private FeixeDLuzIncidente f_incidente;

    public Polarizacao(FeixeDLuzIncidente f_incidente) {
        this.f_incidente = f_incidente;
    }

    public Polarizacao() {
        this.f_incidente = new FeixeDLuzIncidente();
    }

    public FeixeDLuzIncidente getF_incidente() {
        return f_incidente;
    }

    public void setF_incidente(FeixeDLuzIncidente f_incidente) {
        this.f_incidente = f_incidente;
    }

    @Override
    public String toString() {
        return "Polarizacao{" + "f_incidente=" + f_incidente + '}';
    }

}
