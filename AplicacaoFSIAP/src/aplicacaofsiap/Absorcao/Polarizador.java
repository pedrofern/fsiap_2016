package aplicacaofsiap.Absorcao;

/**
 * Esta classe é uma subclasse da Classe Lente e representa uma instância de
 * Polarizador.
 *
 * @author Helder, Gonçalo
 */
public class Polarizador extends Lente {

    /**
     * Construtor permite criar uma instância de polarizador, passando como
     * parâmetro o ângulo em graus em relacão ao eixo de transmissão vertical.
     *
     * @param angulo_emGraus o ângulo em graus em relacão ao eixo de transmissão
     * vertical
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
