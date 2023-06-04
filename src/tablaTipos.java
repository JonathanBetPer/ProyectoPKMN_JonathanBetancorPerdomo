/**
 * @author Jonathan Betancor Perdomo
 * @since 13/05/2023
 * @version v1
 *
 * Enum tablaTipos. Aporta qué tipo de Pokémon tiene debilidad a que otros
 *
 // TODO: 04/06/2023  Podría controlarse la tabla de tipo
 *
 */
public  enum  tablaTipos {
    Agua(
            //superEficaz
            new tipos[]{tipos.Fuego},
            //pocoEficaz
            new tipos[]{tipos.Planta},
            //nulo
            new tipos[]{}
    ),
    Fuego(
            //superEficaz
            new tipos[]{tipos.Planta},
            //pocoEficaz
            new tipos[]{tipos.Agua},
            //nulo
            new tipos[]{}
    ),
     Planta(
            //superEficaz
            new tipos[]{tipos.Agua},
            //pocoEficaz
            new tipos[]{tipos.Fuego},
            //nulo
            new tipos[]{}
    ),
    Normal(
            //superEficaz
            new tipos[]{},
            //pocoEficaz
            new tipos[]{},
            //nulo
            new tipos[]{}
    );

    private  tipos[] superEficaz;
    private tipos[] pocoEficaz;
    private tipos[] nulo;

    /**
     * Constructor privado para poder almacenar datos dentro de un mismo tipo
     *
     * @param superEficaz todos los tipos que puntuan x2
     * @param pocoEficaz todos los tipos que puntuan x0.5
     * @param nulo todos los tipos que puntuan x0
     */
    private tablaTipos (tipos[] superEficaz, tipos[] pocoEficaz, tipos[] nulo ){
        this.superEficaz=superEficaz;
        this.pocoEficaz=pocoEficaz;
        this.nulo=nulo;
    }

    /**
     * Método para comprobar si existe ese tipo en la lis
     *
     * @param tipo
     * @return de vuelve
     */
    public boolean contieneSuperEficaz(tipos tipo){

        for (tipos tipoEnLista: superEficaz) {
            if (tipoEnLista==tipo){
                return true;
            }
        }
        return false;
    }

    public boolean contieneNulo(tipos tipo){

        for (tipos tipoEnLista: nulo) {
            if (tipoEnLista==tipo){
                return true;
            }
        }
        return false;
    }

    public boolean contienePocoEficaz(tipos tipo){

        for (tipos tipoEnLista: pocoEficaz) {
            if (tipoEnLista==tipo){
                return true;
            }
        }
        return false;
    }

    /* Para corregir el Switch en Pokémon.getDanioPorMovimiento
        public boolean contiene(tipos tipoMov, tipos tiposDefensor){

            return potenciador;
        }
    */
}
