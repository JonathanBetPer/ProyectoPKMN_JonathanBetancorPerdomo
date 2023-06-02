import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 * @author Jonathan Betancor Perdomo
 * @since 15/05/2023
 * @version v0.8
 *
 * CLase Entrandor. Tiene asociada una Pokedex y tiene un equipo de Pókemon
 * @// TODO: 11/05/2023 Faltan objetos para currar, atrapar, idk... faltan tantas cosas que me da hasta vergÜenza
 */


public class Entrenador {
    private final int id;
    private static int actualID=0;
    private final String nombre;
    private ArrayList<Pokemon> equipo;
    private Pokedex pokedex;

    public Entrenador(String nombre, Pokedex pokedex) {

        this.id = actualID;
        incrementarActualID();
        this.nombre = nombre;
        this.equipo  = new ArrayList<>();
        this.pokedex = pokedex;
    }

    private void incrementarActualID(){
        actualID++;
    }

    /**
     * @param pokemonCaprurado
     */
    public void capturarPokemon(Pokemon pokemonCaprurado){
        pokedex.registrarPokemon(pokemonCaprurado);
        equipo.add(pokemonCaprurado);
    }

    /**
     * @param pokemonLiberado
     */
    public void liberarPokemon(Pokemon pokemonLiberado){
        equipo.remove(pokemonLiberado);
    }

    public void liberarPokemon(int numero){
        equipo.remove(numero);
    }

    /**
     * @param entrenadorIntercambio
     * @param pokemonRecibir
     */
    public void intercambiar(Entrenador entrenadorIntercambio, Pokemon pokemonRecibir, Pokemon pokemonDar){

        if (this.equipo.contains(pokemonDar) && entrenadorIntercambio.equipo.contains(pokemonRecibir)){
            entrenadorIntercambio.liberarPokemon(pokemonRecibir);
            entrenadorIntercambio.capturarPokemon(pokemonDar);
            liberarPokemon(pokemonDar);
            capturarPokemon(pokemonRecibir);
        }else {
            System.out.println("Error al intercambiar\nDetalles: \n\tNo ha se podido intercambiar el Pokémon "+
                                pokemonDar.getNombre() + " de " + this.nombre+ " por el Pokémon " +
                                pokemonRecibir.getNombre() + " de " + entrenadorIntercambio.nombre
            );
        }

    }

    public boolean buscarPokedexPKMN(String nombrePKMN){
        return pokedex.existePokemon(nombrePKMN);
    }

    public void mostrarPokedex(){
        pokedex.mostrarLista();
    }

    public void mostrarEquipo(){
        for (int i = 0; i <equipo.size(); i++) {
            if (equipo.get(i)!=null){
                System.out.println((i+1)+". "+equipo.get(i).toString());
            }
        }
    }

    protected Pokemon elegirPokemonEquipo(){

        mostrarEquipo();

        Scanner entrada=new Scanner(System.in);

        int numEquipo=-1;

        do {
            System.out.print("Elige un Pokémon: ");

            try {
                numEquipo = Integer.parseInt(entrada.next());
            }catch (Exception e){
                numEquipo=-1;
            }

        }while (numEquipo<0||numEquipo>equipo.size());

        return equipo.get(numEquipo-1);
    }

    public Pokemon[] getEquipoVector(){

        Pokemon[] resultado = new Pokemon[this.equipo.size()];

        for (int i = 0; i < this.equipo.size() ; i++) {
            resultado[i]=this.equipo.get(i);
        }

        return resultado;
    }

    public String getNombre() {
        return nombre;
    }

}
