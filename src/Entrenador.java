/**
 * @author Jonathan Betancor Perdomo
 * @since 15/05/2023
 * @version v0.2
 *
 * CLase Entrandor. Tiene asociada una Pokedex y tiene un equipo de Pókemon
 *
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Entrenador {
    private int id;
    private String nombre;
    private ArrayList<Pokemon> equipo = new ArrayList<>();
    private Pokedex pokedex;

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

    /**
     * @param entrenadorIntercambio
     * @param pokemonIntercambiar
     */
    public void intercambiar(Entrenador entrenadorIntercambio, Pokemon pokemonIntercambiar){
        if (this.equipo.contains(pokemonIntercambiar)){
            entrenadorIntercambio.capturarPokemon(pokemonIntercambiar);
            liberarPokemon(pokemonIntercambiar);
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
            System.out.println((i+1)+". "+equipo.get(i));
        }
    }

    protected Pokemon preseleccion(){
        mostrarEquipo();
        Scanner sc=new Scanner(System.in);
        int numEquipo=-1;
        do {
            System.out.println("Elige un pokemon: ");
            numEquipo= sc.nextInt();
        }while (numEquipo<=0||numEquipo>=equipo.size());
        return equipo.get(numEquipo-1);
    }

    public String getNombre() {
        return nombre;
    }

}
