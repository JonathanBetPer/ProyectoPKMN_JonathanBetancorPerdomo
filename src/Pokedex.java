/**
 * @author Jonathan Betancor Perdomo
 * @since 15/05/2023
 * @version v0.2
 *
 * CLase Pokedex. Contiene información de los Pokémon vistos y atrapados
 *
 */
import java.util.ArrayList;

public class Pokedex {
    private int id;
    private ArrayList<Pokemon> registro = new ArrayList<>();

    public Pokedex(int id) {
        this.id = id;
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
