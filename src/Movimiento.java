/**
 * @author Jonathan Betancor Perdomo
 * @since 11/05/2023
 * @version v0.1
 *
 * CLase Movimiento. Es un Pokémon son capaces de aprender y que usan en los combates con el fin de debilitar a sus oponentes.
 *
 * @// TODO: 11/05/2023 Efecto de estado.
 * @// TODO: 11/05/2023 Hacer clase abstracta. Derivar movimiento físico, y movimiento especial
 *
 */
public class Movimiento {
    private String nombre;
    private tipos tipo;
    private byte pp;
    private int potencia;
    private float precision;


    public Movimiento( String nombre, tipos tipo, byte pp, int potencia, float precision) {
        this.nombre=nombre;
        this.tipo=tipo;
    }
}
