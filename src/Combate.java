import java.util.Random;
import java.util.Scanner;

public class Combate {

    private Entrenador entrenador;
    private Pokemon pokemon;
    private Pokemon pokemonEnemigo;
    private Pokemon[] pokemonEnemigos;

    /**
     * @param entrenador
     * @param pokemonEnemigos
     */
    public Combate(Entrenador entrenador, Pokemon[] pokemonEnemigos) {
        this.entrenador=entrenador;
        this.pokemonEnemigos = pokemonEnemigos;
    }

    public void iniciar() {
        Random rn = new Random();
        pokemon= entrenador.preseleccion();
        pokemonEnemigo=pokemonEnemigos[rn.nextInt(pokemonEnemigos.length+1)];

        Scanner sc=new Scanner(System.in);

        while (pokemon.getHp() > 0 && pokemonEnemigo.getHp() > 0) {
            System.out.println("¡Es tu turno, " + entrenador.getNombre() + "!");
            int ataque=-1;
            do {
                if (pokemon. Fuego){
                    System.out.println("Elige ataque: ");
                    System.out.println("1. Inferno");
                    System.out.println("2. Llamarada");
                    System.out.println("3. Ataque normal");
                } else if (pokemon instanceof  Planta) {
                    System.out.println("Elige ataque: ");
                    System.out.println("1. Pistola agua");
                    System.out.println("2. Hidropulso");
                    System.out.println("3. Ataque normal");
                } else if (pokemon instanceof  Agua) {
                    System.out.println("Elige ataque: ");
                    System.out.println("1. Planta Feroz");
                    System.out.println("2. Lluevehojas");
                    System.out.println("3. Ataque normal");
                }
                ataque= sc.nextInt();
            }while (ataque<1||ataque>3);

            if (ataque==3){
                pokemon.atacar(pokemonEnemigo);
            } else{
                if (pokemon instanceof Fuego){
                    if (ataque==1){
                        ((Fuego) pokemon).inferno(pokemonEnemigo);
                    }else {
                        ((Fuego) pokemon).llamarada(pokemonEnemigo);
                    }
                } else if (pokemon instanceof  Planta) {
                    if (ataque==1){
                        ((Planta) pokemon).plantaFeroz(pokemonEnemigo);
                    }else {
                        ((Planta) pokemon).lluevehojas(pokemonEnemigo);
                    }

                } else if (pokemon instanceof  Agua) {
                    if (ataque==1){
                        ((Agua) pokemon).pistolaAgua(pokemonEnemigo);
                    }else {
                        ((Agua) pokemon).hidroPulso(pokemonEnemigo);
                    }
                }
            }

            int ataqueRandom= rn.nextInt(3)+1;

            String nombreAtaque="";
            if (ataqueRandom==3){
                pokemonEnemigo.atacar(pokemon);
                nombreAtaque="Ataque normal";
            } else{
                if (pokemonEnemigo instanceof Fuego){
                    if (ataqueRandom==1){
                        ((Fuego) pokemonEnemigo).inferno(pokemon);
                        nombreAtaque="Inferno";
                    }else {
                        ((Fuego) pokemonEnemigo).llamarada(pokemon);
                        nombreAtaque="Llamarada";
                    }
                } else if (pokemonEnemigo instanceof  Planta) {
                    if (ataqueRandom==1){
                        ((Planta) pokemonEnemigo).plantaFeroz(pokemon);
                        nombreAtaque="Planta Feroz";
                    }else {
                        ((Planta) pokemonEnemigo).lluevehojas(pokemon);
                        nombreAtaque="Lluevehojas";
                    }

                } else if (pokemonEnemigo instanceof  Agua) {
                    if (ataqueRandom==1){
                        ((Agua) pokemonEnemigo).pistolaAgua(pokemon);
                        nombreAtaque="Pistola Agua";
                    }else {
                        ((Agua) pokemonEnemigo).hidroPulso(pokemon);
                        nombreAtaque="Hidropulso";
                    }
                }
            }

            System.out.println("El enemigo ha usado "+nombreAtaque+" .");
        }

        if (pokemonEnemigo.getVida()<=0){
            System.out.println("Has ganao.");
        }else {
            System.out.println("Has perdio.");
        }

    }
}
