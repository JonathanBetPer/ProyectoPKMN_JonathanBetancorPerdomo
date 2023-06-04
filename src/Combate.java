import java.util.Random;
import java.util.Scanner;
/**
 * @author Jonathan Betancor Perdomo
 * @since 01/06/2023
 * @version v1
 *
 * Clase Combate. Permite que dos Pokémon se taquen hasta que uno de los dos llegue a 0 HP.
 *
 * // TODO: 02/06/2023 : Añadir funcionalidad de cambiar de Pokémon?
 *
 */
public class Combate {

    private boolean turno;
    private Entrenador entrenador;
    private Pokemon pokemon;
    private Pokemon pokemonEnemigo;
    private Pokemon[] pokemonEnemigos;

    /**
     * Constructor de la clase
     *
     * @param entrenador (Entrenador)
     * @param pokemonEnemigos (Pokemon[])
     */
    public Combate(Entrenador entrenador, Pokemon[] pokemonEnemigos) {
        this.turno=true;
        this.entrenador=entrenador;
        this.pokemonEnemigos = pokemonEnemigos;
    }

    /**
     * Método que da comienzo al combate y que no termina mientras que uno de los dos Pókemon mno llegue a 0 HP
     * @return el Pokémon del rival sí es una victoria
     */

    public Pokemon iniciar() {
        //Variables
        Random rmNum = new Random();
        Scanner entrada = new Scanner(System.in);

        byte numAtaque = 0;
        int danio=0;

        pokemon = entrenador.elegirPokemonEquipo();
        pokemonEnemigo=pokemonEnemigos[rmNum.nextInt(pokemonEnemigos.length)];

        System.out.println(pokemon.getNombre() + " vs. " + pokemonEnemigo.getNombre());

        //Bucle del combate
        while (pokemon.getHp() > 0 && pokemonEnemigo.getHp() > 0) {

            //Datos de la vida
            System.out.println(pokemon.getNombre() + " tiene " + pokemon.getHp() + " de "+ pokemon.getMaxHP()+ " HP");
            System.out.println(pokemonEnemigo.getNombre() + " tiene " + pokemonEnemigo.getHp()+ " de "+ pokemon.getMaxHP()+ " HP");

            //Comprobación turno
            if (this.turno){

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
                }while ((numAtaque<0||numAtaque>4) && pokemon.getMovimiento((byte) (numAtaque-1))!=null);


                danio=pokemon.getDanioPorMovimiento(pokemon.getMovimiento((byte) (numAtaque-1)), pokemonEnemigo);

                pokemonEnemigo.bajarHp(danio);

                System.out.println(pokemon.getNombre() + " a realizado " + pokemon.getMovimiento(numAtaque).getNombre() + " con " + danio + " de daño" );

                turno=false;
            }else {

                numAtaque= (byte) rmNum.nextInt(pokemonEnemigo.getListaAtaques().length());

                danio=pokemonEnemigo.getDanioPorMovimiento(pokemonEnemigo.getMovimiento(numAtaque), pokemon);

                pokemon.bajarHp(danio);

                System.out.println(pokemonEnemigo.getNombre() + " a realizado " + pokemonEnemigo.getMovimiento(numAtaque).getNombre() + " con " + danio + " de daño" );

                turno=true;
            }

        }

        //Resultados
        if (pokemonEnemigo.getHp()<=0){
            System.out.println("¡Has ganado! :D");
            return pokemonEnemigo;
        }else {
            System.out.println("¡Has perdido :_C!");
        }

        return null;
    }
}
