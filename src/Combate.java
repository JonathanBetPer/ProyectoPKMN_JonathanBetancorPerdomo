import java.util.Random;
import java.util.Scanner;
/**
 * @author Jonathan Betancor Perdomo
 * @since 01/06/2023
 * @version v0.5
 *
 * Clase Combate. Permite que dos Pokémon se taquen hasta que uno de los dos llegue a 0 HP.
 *
 * // TODO: 02/06/2023 : Añadir funcionalidad de cambiar de Pokémon?
 *
 */
public class Combate {

    private Entrenador entrenador;
    private Pokemon pokemon;
    private Pokemon pokemonEnemigo;
    private Pokemon[] pokemonEnemigos;


    public Combate(Entrenador entrenador, Pokemon[] pokemonEnemigos) {
        this.entrenador=entrenador;
        this.pokemonEnemigos = pokemonEnemigos;
    }

    public Pokemon iniciar() {
        //Variables
        Random rmNum = new Random();
        Scanner entrada = new Scanner(System.in);
        byte numAtaque = 0;
        boolean turno=true;
        int danio=0;


        pokemon = entrenador.elegirPokemonEquipo();

        pokemonEnemigo=pokemonEnemigos[rmNum.nextInt(pokemonEnemigos.length+1)];

        Scanner sc=new Scanner(System.in);

        System.out.println(pokemon.getNombre() + " vs. " + pokemonEnemigo.getNombre());
        while (pokemon.getHp() > 0 && pokemonEnemigo.getHp() > 0) {

            if (turno){

                System.out.println("¡Es tu turno, " + entrenador.getNombre() + "!");


                System.out.println("Elije un ataque:");
                System.out.println(pokemon.getListaAtaques());

                do {
                    try {
                        numAtaque = Byte.parseByte(entrada.nextLine());
                    } catch (Exception e) {
                        numAtaque = -1;
                        System.out.println("Número incorrecto");
                    }
                }while (numAtaque!=-1);

                danio=pokemon.getDanioPorMovimiento(pokemon.getMovimiento(numAtaque), pokemonEnemigo);

                pokemonEnemigo.setHp(danio);

                System.out.println(pokemon.getNombre() + " a realizado " + pokemon.getMovimiento(numAtaque).getNombre() + " con " + danio + " de daño" );

                turno=false;
            }else {

                numAtaque= (byte) rmNum.nextInt(pokemonEnemigo.getListaAtaques().length());

                danio=pokemonEnemigo.getDanioPorMovimiento(pokemonEnemigo.getMovimiento(numAtaque), pokemon);

                pokemon.setHp(danio);

                System.out.println(pokemonEnemigo.getNombre() + " a realizado " + pokemonEnemigo.getMovimiento(numAtaque).getNombre() + " con " + danio + " de daño" );

                turno=true;
            }

        }

        if (pokemonEnemigo.getHp()<=0){
            System.out.println("¡Has ganado!.");
            return pokemonEnemigo;
        }else {
            System.out.println("¡Has perdido :_C!");
        }

        return null;
    }
}
