import java.util.Arrays;

/**
 * @author Jonathan Betancor Perdomo
 * @since 11/05/2023
 * @version v0.1
 *
 * CLase Pokémon. Criaturas que combaten y cosas así, no sé muy bien como explicarlo
 *
 * @// TODO: 11/05/2023 Faltan las Stats
 * @// TODO: 11/05/2023 Faltan atributos esteticos como género, pokerus, fecha captura...
 *
 *
 */

public class Pokemon {
    private int id;
    private String nombre;
    private tipos tipo1;
    private tipos tipo2;
    private byte nivel;
    private int hp;
    private int pp;
    private final Movimiento[] listaAtaques = new Movimiento[4];


    public Pokemon (int id, String nombre, tipos tipo1, tipos tipo2, byte nivel, int hp, int pp) throws Exception {
        if (nivel<1){
            throw new Exception("Error: El nivel debe ser mayor que 0");
        }
        this.id = id;
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.nivel = nivel;
        this.hp = hp;
        this.pp = pp;
    }


    public Movimiento[] getListaAtaques() {
        return listaAtaques;
    }

    public void setMovimiento(Movimiento nuevoMO){
        for (int i=0; i < listaAtaques.length; i++) {
            if (listaAtaques[i] == null){
                listaAtaques[i]=nuevoMO;
            }
        }


    }

    @Override
    public String toString() {
        return "Pokemon: " +
                " Nombre: " + nombre + '\'' +
                " Tipo: " + tipo1.name() + tipo2.name() +
                " Nivel: " + nivel +
                " Vida: " + hp +
                " PP: " + pp +
                " Ataques: " + Arrays.toString(listaAtaques);
    }
}
