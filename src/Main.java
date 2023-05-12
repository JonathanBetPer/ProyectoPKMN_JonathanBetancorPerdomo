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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        byte menu=-1;

        do{

            System.out.println("->\t");
            menu=Byte.parseByte(entrada.next());



            switch (menu) {

                case 1:

                break;
                case 2:

                break;
                case 3:

                break;

                default:
            }



        }while (menu!=0);


    }
}