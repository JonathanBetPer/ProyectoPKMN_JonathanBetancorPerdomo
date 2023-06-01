/**
 * @author Jonathan Betancor Perdomo
 * @since 11/05/2023
 * @version v0.1
 *
 * CLase Movimiento. Es un Pokémon son capaces de aprender y que usan en los combates con el fin de debilitar a sus oponentes.
 *
 * @// TODO: 11/05/2023 Efecto de estado.
 * @// TODO: 11/05/2023 Hacer clase abstracta. Derivar movimiento físico, y movimiento especial
 * @// TODO: 11/05/2023 Falta crear un atributo más para limitar lás veces que se puede usar un ataque
 *
 */
public class Movimiento {
    private String nombre;
    private tipos tipo;
    private int pp;
    private int potencia;
    private int precision;


    public Movimiento( String nombre, tipos tipo, int pp, int potencia, int precision) {
        this.nombre=nombre;
        this.tipo=tipo;
        this.pp=pp;
        this.potencia=potencia;
        this.precision=precision;
    }

    public tipos getTipo() {
        return tipo;
    }

    public int getPp() {
        return pp;
    }

    public int getPotencia() {
        return potencia;
    }

    public double getPrecision() {
        return precision;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre  +
                "\nTipo" + tipo +
                ", PP " + pp +
                ", Potencia " + potencia +
                ", Precisión " + precision;
    }
}

