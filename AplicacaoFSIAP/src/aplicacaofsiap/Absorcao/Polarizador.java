/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaofsiap.Absorcao;

/**
 * Esta classe é uma subclasse de Lente e representa uma instância de
 * Polarizador.
 *
 * @author Helder, Gonçalo
 */
public class Polarizador extends Lente {

    /**
     * Construtor permite criar uma instância de polarizador, passando como
     * parâmetro o ângulo em graus em relacão ao eixo de transmissão.
     *
     * @param angulo_emGraus o ângulo em graus em relacão ao eixo de transmissão
     */
    public Polarizador(double angulo_emGraus) {
        super(angulo_emGraus);
    }

    /**
     * Construtor vazio que permite criar uma instância de Polarizador,
     * atribuindo ao ângulo o valor por omissão de 0 (zero) graus.
     */
    public Polarizador() {
        super();
    }

    /**
     * Devolve a descrição textual de um polarizador.
     *
     * @return descrição textual de um polarizador
     */
    @Override
    public String toString() {
        return "Polarizador{" + super.toString() + '}';
    }
}
