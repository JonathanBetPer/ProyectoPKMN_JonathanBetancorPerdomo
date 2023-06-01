import java.util.Arrays;

/**
 * @author Jonathan Betancor Perdomo
 * @since 11/05/2023
 * @version v0.1
 *
 * CLase Pokémon. Criaturas que combaten y cosas así, no sé muy bien como explicarlo
 *
 * @// TODO: 11/05/2023 Faltan las Stats, subida de nivel
 * @// TODO: 11/05/2023 Faltan atributos esteticos como género, pokerus, fecha captura...
 *
 *
 */

public class Pokemon {
    private int id;
    private String nombre;
    private tipos tipo1;
    private tipos tipo2;
    private int nivel;
    private int hp;
    private int pp;
    private final Movimiento[] listaAtaques;


    public Pokemon (int id, String nombre, tipos tipo1, tipos tipo2, int nivel, int hp, int pp)  {

        this.id = id;
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.nivel = nivel;
        this.hp = hp;
        this.pp = pp;
        this.listaAtaques = new Movimiento[4];
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public tipos getTipo1() {
        return tipo1;
    }

    public tipos getTipo2() {
        return tipo2;
    }

    public int getNivel() {
        return nivel;
    }

    public int getHp() {
        return hp;
    }

    public int getPp() {
        return pp;
    }

    public Movimiento[] getListaAtaques() {
        return listaAtaques;
    }

    public void anadirMovimiento(Movimiento nuevoMO) {

        byte huecoLibre=-1;
        for (byte i=0; i < listaAtaques.length; i++) {
            if (listaAtaques[i] == null){
                huecoLibre=i;
                break;
            }
        }

        if (huecoLibre!=-1){
            listaAtaques[huecoLibre]=nuevoMO;
        }

    }

    public void anadirMovimiento(byte posicion, Movimiento nuevoMO) {

        eliminarMovimiento(posicion);

        listaAtaques[posicion]=nuevoMO;

    }


    public void eliminarMovimiento(byte posicionMovimiento){
       listaAtaques[posicionMovimiento]=null;
    }


    @Override
    public String toString() {
        return "Pokémon: " +
                " Nombre: " + nombre + '\'' +
                " Tipo: " + tipo1.name() + tipo2.name() +
                " Nivel: " + nivel +
                " Vida: " + hp +
                " PP: " + pp +
                " Movimientos: " + Arrays.toString(listaAtaques);
    }
}
