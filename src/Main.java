/**
 * @author Jonathan Betancor Perdomo
 * @since 11/05/2023
 * @version v0.1
 *
 * Principal. Programa básado en Pokémon. Opciones de captura, combate....
 *
 * @// TODO: 11/05/2023 Faltan las Stats
 *
 *
 */
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.ErrorManager;

public class Main {

    private static Scanner entrada;
    private static Pokemon allPokemon[];

    public static void main(String[] args) throws IOException, InterruptedException {


        allPokemon=iniciadorObjetos();

        Entrenador entrenador = comenzar();


        entrenador.capturarPokemon(elegirInicial());


        entrada=new Scanner(System.in);
        byte menu=-1;

        do{

            System.out.println("* --- MENÚ --- *");
            System.out.println(" 1. Buscar Pókemon");
            System.out.println(" 2. Ver equipo");
            System.out.println(" 3. Ver Pokédex");
            System.out.println(" 4. Salir");
            System.out.println("* ------------ *");


            System.out.println("->\t");
            try {
                menu=Byte.parseByte(entrada.nextLine());
            }catch (Exception e){
                menu=-1;
            }




            switch (menu) {

                case 1:

                break;
                case 2:

                break;
                case 3:

                break;

                case 4:
                    System.out.println("No se guardará nada ¿Seguro que quieres salir?\n Escriba 'N' para cancelar:\n\t");
                    if (entrada.nextLine().toUpperCase().equals("N")){
                        menu=-0;
                    }

                break;

                default:
                    System.out.println("Error: Opción incorrecta");
            }


        }while (menu!=4);

    }


    public static Pokemon[] iniciadorObjetos(){
        // Pokémon
        Pokemon bulbasaur = new Pokemon(1,"Bulbasaur",tipos.Planta, null,9, 25, 150);
        Pokemon ivysaur = new Pokemon(2,"Ivysaur",tipos.Planta,null,15, 155, 200);
        Pokemon venusaur = new Pokemon(3,"Venusaur",tipos.Planta,null,25, 255, 245);


        Pokemon charmander = new Pokemon(4,"Charmander",tipos.Fuego, null,9, 25, 100);
        Pokemon charmeleon = new Pokemon(5,"Charmeleon",tipos.Fuego,null,15, 155, 200);
        Pokemon charizard = new Pokemon(6,"Charizard",tipos.Fuego,null,25, 255, 245);

        Pokemon squirtle = new Pokemon(7,"Squirtle",tipos.Agua, null,9, 25, 100);
        Pokemon wartortle = new Pokemon(8,"Wartortle",tipos.Agua,null,15, 155, 200);
        Pokemon blastoise = new Pokemon(9,"Blastoise",tipos.Agua,null,25, 255, 245);


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


        return new Pokemon[]{bulbasaur, ivysaur, venusaur, charmander, charmeleon, charizard, squirtle, wartortle, blastoise};
    }

    public static Entrenador comenzar(){

        System.out.println("Digame su nombre para empezar: ");
        String nombre=entrada.nextLine();

        Pokedex pokedex = new Pokedex(1);
        Entrenador entrenador = new Entrenador(0, nombre.trim(), pokedex);

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
                    System.out.println("->");
                    numEleccion=Byte.parseByte(entrada.nextLine());
                }catch (Exception e){
                    System.out.println("Error: Opción incorrecta");
                    numEleccion=-1;
                }
            }while (numEleccion<1||numEleccion>3);

            System.out.println("Has elegido a"+ pokemonIniciales[numEleccion].getNombre()+" como tu inicial, n podrás cambiarlo luego. \n¿Estás seguro?");

            System.out.println("1. Sí");
            System.out.println("2. Mostrar más información");
            System.out.println("3. No");


            try {
                System.out.println("->");
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


}