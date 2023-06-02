import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
/**
 * @author Jonathan Betancor Perdomo
 * @since 11/05/2023
 * @version v0.8
 *
 * Principal. Programa básado en Pokémon. Opciones de captura, combate....
 *
 * // TODO: 02/06/2023 Falta documentar
 *
 */


public class Main {

    private static Scanner entrada;
    private static Pokemon[] allPokemon;
    private static final ArrayList<Entrenador> listaEntrenadores=new ArrayList<>();

    private static Entrenador entrenadorProtagonista;

    public static void main(String[] args) throws IOException, InterruptedException {
        entrada=new Scanner(System.in);
        allPokemon = iniciadorObjetos();

        entrenadorProtagonista = comenzar();
        entrenadorProtagonista.capturarPokemon(elegirInicial());

        menu();
    }


    public static void menu(){
        byte menu;

        do{

            System.out.println("* ------------ MENÚ ------------ *");
            System.out.println("  1. Combatir");
            System.out.println("  2. Ver equipo");
            System.out.println("  3. Ver Pokédex");
            System.out.println("  4. Curar todo el equipo");
            System.out.println("  5. Intercambio Pokémon");
            System.out.println("  6. Añadir nuevo entrenador");
            System.out.println("  7. Cambiar a otro entrenador");
            System.out.println("  8. Salir");
            System.out.println("* ------------------------------ *");

            System.out.print("->\t");
            try {
                menu=Byte.parseByte(entrada.nextLine());
            }catch (Exception e){
                menu=-1;
            }

            switch (menu) {

                case 1:
                    nuevoCombate();
                break;

                case 2:
                    entrenadorProtagonista.mostrarEquipo();
                break;

                case 3:
                    entrenadorProtagonista.mostrarPokedex();
                break;

                case 4:
                    curar();
                break;

                case 5:
                    entrenadorProtagonista.intercambiar(listaEntrenadores.get(elegirEntrenador()-1), listaEntrenadores.get(elegirEntrenador()-1).elegirPokemonEquipo(), entrenadorProtagonista.elegirPokemonEquipo());
                break;

                case 6:
                    nuevoEntrenador();
                break;

                case 7:
                    cambiarEntrenador(elegirEntrenador());
                break;

                case 8:
                    System.out.println("No se guardará nada ¿Seguro que quieres salir?\n Escriba 'N' para cancelar:\n\t");
                    String comprobacion;
                    comprobacion=entrada.nextLine().toUpperCase();

                    if (comprobacion.equals("N")){
                        menu=-0;
                    }

                break;

                default:
                    System.out.println("Error: Opción incorrecta");
            }
        }while (menu!=8);
    }

    public static Pokemon[] iniciadorObjetos(){
        // Pokémon
        Pokemon bulbasaur = new Pokemon(1,"Bulbasaur",tipos.Planta,9, 25, 150);
        Pokemon ivysaur = new Pokemon(2,"Ivysaur",tipos.Planta,15, 155, 200);
        Pokemon venusaur = new Pokemon(3,"Venusaur",tipos.Planta,25, 255, 245);


        Pokemon charmander = new Pokemon(4,"Charmander",tipos.Fuego,9, 25, 100);
        Pokemon charmeleon = new Pokemon(5,"Charmeleon",tipos.Fuego,15, 155, 200);
        Pokemon charizard = new Pokemon(6,"Charizard",tipos.Fuego,25, 255, 245);

        Pokemon squirtle = new Pokemon(7,"Squirtle",tipos.Agua,9, 25, 100);
        Pokemon wartortle = new Pokemon(8,"Wartortle",tipos.Agua,15, 155, 200);
        Pokemon blastoise = new Pokemon(9,"Blastoise",tipos.Agua,25, 255, 245);


        //Movimientos
        Movimiento placaje = new Movimiento("Placaje",tipos.Normal, 35, 40, 100);
        Movimiento latigoCepa = new Movimiento("Látigo Cepa",tipos.Planta, 25, 46, 100);
        Movimiento hojaAfilada = new Movimiento("Hoja Afilida",tipos.Planta, 25, 55, 95);
        Movimiento bombaGermen = new Movimiento("Bomba Germen",tipos.Planta, 15, 80, 100);

        Movimiento araniazo = new Movimiento("Arañazo", tipos.Normal, 35, 40, 100);
        Movimiento ascuas = new Movimiento("Ascuas", tipos.Fuego, 25, 40, 100);
        Movimiento colmilloIgneo = new Movimiento("Colmillo Ígneo",tipos.Fuego, 15, 65, 95);
        Movimiento inferno = new Movimiento("Inferno", tipos.Fuego, 5, 40, 50);


        Movimiento pistolaAgua = new Movimiento("Pistola Agua", tipos.Agua, 35, 40, 100);
        Movimiento hidropulso = new Movimiento("Hidropulso",tipos.Agua, 20, 60, 100);
        Movimiento hidrobomba = new Movimiento("Inferno", tipos.Agua, 5, 110, 80);



        //Añadir movimiento a Pókemon
        bulbasaur.anadirMovimiento(placaje);
        bulbasaur.anadirMovimiento(latigoCepa);

        ivysaur.anadirMovimiento(placaje);
        ivysaur.anadirMovimiento(latigoCepa);
        ivysaur.anadirMovimiento(hojaAfilada);

        venusaur.anadirMovimiento(placaje);
        venusaur.anadirMovimiento(latigoCepa);
        venusaur.anadirMovimiento(hojaAfilada);
        venusaur.anadirMovimiento(bombaGermen);


        charmander.anadirMovimiento(araniazo);
        charmander.anadirMovimiento(ascuas);

        charmeleon.anadirMovimiento(araniazo);
        charmeleon.anadirMovimiento(ascuas);
        charmeleon.anadirMovimiento(colmilloIgneo);

        charizard.anadirMovimiento(araniazo);
        charizard.anadirMovimiento(ascuas);
        charizard.anadirMovimiento(colmilloIgneo);
        charizard.anadirMovimiento(inferno);


        squirtle.anadirMovimiento(placaje);
        squirtle.anadirMovimiento(pistolaAgua);

        wartortle.anadirMovimiento(placaje);
        wartortle.anadirMovimiento(pistolaAgua);
        wartortle.anadirMovimiento(hidropulso);

        blastoise.anadirMovimiento(placaje);
        blastoise.anadirMovimiento(pistolaAgua);
        blastoise.anadirMovimiento(hidropulso);
        blastoise.anadirMovimiento(hidrobomba);




        Pokemon[] vector = new  Pokemon[]{bulbasaur, ivysaur, venusaur, charmander, charmeleon, charizard, squirtle, wartortle, blastoise};

        //Entrenadores

        Entrenador Red = new Entrenador("Red", new Pokedex());

        for (Pokemon monstruito: vector) {
            Red.capturarPokemon(monstruito);
        }

        Entrenador Liko = new Entrenador("Liko", new Pokedex());

        listaEntrenadores.add(Red);
        listaEntrenadores.add(Liko);

        return vector;

    }



    public static Entrenador comenzar(){

        System.out.println("Digame su nombre para empezar: ");
        String nombre=entrada.nextLine();

        Pokedex pokedex = new Pokedex();
        Entrenador entrenador = new Entrenador(nombre.trim(), pokedex);

        System.out.println("\n\n\n\nBievenida/o "+entrenador.getNombre()+"! \n ");

        return entrenador;
    }



    public static Pokemon elegirInicial (){

        boolean done=false;
        byte numEleccion=0, menu=0;

        Pokemon[] pokemonIniciales = new Pokemon[]{allPokemon[0],allPokemon[3],allPokemon[6]};

        do {
            System.out.println("Debe elegir entre uno de los siguientes Pokémon: ");

            for (int i = 0; i < pokemonIniciales.length; i++) {
                System.out.println("\t"+(i+1)+". "+pokemonIniciales[i].getNombre());
            }


            do {
                try {
                    System.out.print("-> ");
                    numEleccion=Byte.parseByte(entrada.nextLine());
                }catch (Exception e){
                    System.out.println("Error: Opción incorrecta");
                    numEleccion=-1;
                }
                numEleccion--;
            }while (numEleccion<0||numEleccion>2);

            System.out.println("Has elegido a "+ pokemonIniciales[numEleccion].getNombre()+" como tu inicial, no podrás cambiarlo luego. \n¿Estás seguro?");

            System.out.println("1. Sí");
            System.out.println("2. Mostrar más información");
            System.out.println("3. No");


            try {
                System.out.print("-> ");
                menu=Byte.parseByte(entrada.nextLine());
            }catch (Exception e){
                System.out.println("Error: Opción incorrecta");
                menu=-1;
            }

            if (menu==2){
                System.out.println(pokemonIniciales[numEleccion].toString());
            } else if (menu==1) {
                done=true;
            }

        }while (!done);

        return pokemonIniciales[numEleccion];

    }



    public static void nuevoEntrenador(){

        Entrenador nuevoEntrnador=comenzar();

        nuevoEntrnador.capturarPokemon(elegirInicial());

        listaEntrenadores.add(nuevoEntrnador);

    }



    public static void mostrarListaEntrenadores(){
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + listaEntrenadores.get(i).getNombre());
        }
    }



    public static void cambiarEntrenador(int numero){

        Entrenador auxiliar = entrenadorProtagonista;
        entrenadorProtagonista=listaEntrenadores.get(numero-1);
        listaEntrenadores.remove(numero-1);
        listaEntrenadores.add(numero-1, auxiliar);
    }



    public static int elegirEntrenador(){
        byte numEntrenador;
        mostrarListaEntrenadores();

        System.out.print("Elija el entrenador\n\t-> ");

        do {
            try {
                numEntrenador = Byte.parseByte(entrada.next());
            } catch (Exception e) {
                numEntrenador = -1;
                System.out.println("Error: Opción incorrecta, vuelva a introducir un número \n ");
            }
        }while (numEntrenador<0||numEntrenador>listaEntrenadores.size());

        return numEntrenador;
    }


    public static void curar(){


        //Voy a curra a todo porque estoy LOCO

        Pokemon[] equipo = entrenadorProtagonista.getEquipoVector();

        for (int i = 0; i < equipo.length; i++) {
            for (Pokemon e : allPokemon) {
                if (equipo[i].getNombre().equals(e.getNombre())){
                    equipo[i].setHp(e.getHp());
                }
            }
        }

        for (int i = 0; i < listaEntrenadores.size(); i++) {
            equipo=listaEntrenadores.get(i).getEquipoVector();
            for (int j = 0; j < equipo.length; j++) {
                for (Pokemon e : allPokemon) {
                    if (equipo[i].getNombre().equals(e.getNombre())){
                        equipo[i].setHp(e.getHp());
                    }
                }
            }
        }


        System.out.println("Has curado a todos los Pokémon");


    }

    public static void nuevoCombate(){

        byte combateOpcion, eleccionEntrenador;

        Combate combate1;
        System.out.println("\t1. Combate contra entrenador");
        System.out.println("\t2. Combate contra Pokémon salvaje");
        System.out.print("\t\t-> ");

        try {
            combateOpcion=Byte.parseByte(entrada.nextLine());
        }catch (Exception e){
            combateOpcion=-1;
        }

        switch (combateOpcion) {
            case 1 -> {

                eleccionEntrenador = (byte) elegirEntrenador();

                Pokemon[] listaPokemon = listaEntrenadores.get(eleccionEntrenador - 1).getEquipoVector();

                combate1 = new Combate(entrenadorProtagonista, listaPokemon);

                combate1.iniciar();
            }
            case 2 -> {
                combate1 = new Combate(entrenadorProtagonista, allPokemon);

                Pokemon pokemon= combate1.iniciar();


                if (pokemon!=null){
                    System.out.println("Por obra de la magía y del destino has capturado el Pokémon "+pokemon);
                    entrenadorProtagonista.capturarPokemon(pokemon);
                }

            }
            default -> System.out.println("Error: Opción incorrecta");
        }
    }
}