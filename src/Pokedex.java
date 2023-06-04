import java.util.ArrayList;
/**
 * @author Jonathan Betancor Perdomo
 * @since 15/05/2023
 * @version v1
 *
 * CLase Pokedex. Contiene información de los Pokémon vistos y atrapados
 *
 */


public class Pokedex {
    private int id;
    private static int actualID=0;
    private ArrayList<Pokemon> registro = new ArrayList<>();

    public Pokedex() {
        this.id = actualID;
        incrementarActualID();
    }
    private void incrementarActualID(){
        actualID++;
    }


    public void registrarPokemon(Pokemon PokemonNuevo){
        registro.add(PokemonNuevo);
    }

    public boolean existePokemon(String nombre){
        for (Pokemon e:registro) {
            if (e.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }

    public boolean existePokemon(int ID){
        for (Pokemon e:registro) {
            if (e.getId()==ID){
                return true;
            }
        }
        return false;
    }

    public void mostrarLista(){
        for (Pokemon e:registro) {
            System.out.println(e.toString());
        }
    }
}
