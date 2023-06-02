/**
 * @author Jonathan Betancor Perdomo
 * @since 11/05/2023
 * @version v0.8
 *
 * CLase Pokémon. Criaturas que combaten y cosas así, no sé muy bien como explicarlo
 *
 * @// TODO: 11/05/2023 Faltan las Stats, subida de nivel
 * @// TODO: 11/05/2023 Faltan atributos esteticos como género, pokerus, fecha captura...
 *
 *
 */

public class Pokemon {
    private int id;
    private String nombre;
    private tipos tipo1;
    private tipos tipo2;
    private int nivel;
    private int hp;
    private int pp;
    private final Movimiento[] listaAtaques;

    public Pokemon (int id, String nombre, tipos tipo1, int nivel, int hp, int pp)  {
        this.id = id;
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.nivel = nivel;
        this.hp = hp;
        this.pp = pp;
        this.listaAtaques = new Movimiento[4];
    }

    public Pokemon (int id, String nombre, tipos tipo1, tipos tipo2, int nivel, int hp, int pp)  {

        this.id = id;
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.nivel = nivel;
        this.hp = hp;
        this.pp = pp;
        this.listaAtaques = new Movimiento[4];
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public tipos getTipo1() {
        return tipo1;
    }

    public tipos getTipo2() {
        return tipo2;
    }

    public int getNivel() {
        return nivel;
    }

    public int getHp() {
        return hp;
    }

    public int getPp() {
        return pp;
    }

    public int getDanioPorMovimiento (Movimiento movimientoAtacante, Pokemon PokemonRecibe){
        double danio=1;

        danio=movimientoAtacante.getPotencia()*(movimientoAtacante.getPrecision()/100);



        switch (movimientoAtacante.getTipo()){

            case Planta -> {
                if (tablaTipos.Planta.contieneSuperEficaz(PokemonRecibe.tipo1) || tablaTipos.Planta.contieneSuperEficaz(PokemonRecibe.tipo2)){
                    danio=danio*2;
                } else if (tablaTipos.Planta.contienePocoEficaz(PokemonRecibe.tipo1) || tablaTipos.Planta.contienePocoEficaz(PokemonRecibe.tipo2)) {
                    danio=danio*0.5;
                } else if ((tablaTipos.Planta.contieneNulo(PokemonRecibe.tipo1) || tablaTipos.Planta.contieneNulo(PokemonRecibe.tipo2))) {
                    danio=0;
                }
            }

            case Fuego -> {
                if (tablaTipos.Fuego.contieneSuperEficaz(PokemonRecibe.tipo1) || tablaTipos.Fuego.contieneSuperEficaz(PokemonRecibe.tipo2)){
                    danio=danio*2;
                } else if (tablaTipos.Fuego.contienePocoEficaz(PokemonRecibe.tipo1) || tablaTipos.Fuego.contienePocoEficaz(PokemonRecibe.tipo2)) {
                    danio=danio*0.5;
                } else if ((tablaTipos.Fuego.contieneNulo(PokemonRecibe.tipo1) || tablaTipos.Fuego.contieneNulo(PokemonRecibe.tipo2))) {
                    danio=0;
                }
            }

            case Agua -> {
                if (tablaTipos.Agua.contieneSuperEficaz(PokemonRecibe.tipo1) || tablaTipos.Agua.contieneSuperEficaz(PokemonRecibe.tipo2)){
                    danio=danio*2;
                } else if (tablaTipos.Agua.contienePocoEficaz(PokemonRecibe.tipo1) || tablaTipos.Agua.contienePocoEficaz(PokemonRecibe.tipo2)) {
                    danio=danio*0.5;
                } else if ((tablaTipos.Agua.contieneNulo(PokemonRecibe.tipo1) || tablaTipos.Agua.contieneNulo(PokemonRecibe.tipo2))) {
                    danio=0;
                }
            }

            case Normal -> {
                if (tablaTipos.Normal.contieneSuperEficaz(PokemonRecibe.tipo1) || tablaTipos.Normal.contieneSuperEficaz(PokemonRecibe.tipo2)){
                    danio=danio*2;
                } else if (tablaTipos.Normal.contienePocoEficaz(PokemonRecibe.tipo1) || tablaTipos.Normal.contienePocoEficaz(PokemonRecibe.tipo2)) {
                    danio=danio*0.5;
                } else if ((tablaTipos.Normal.contieneNulo(PokemonRecibe.tipo1) || tablaTipos.Normal.contieneNulo(PokemonRecibe.tipo2))) {
                    danio=0;
                }
            }
        }

        return (int) danio;
    }

    public String getListaAtaques() {
        StringBuilder resultado= new StringBuilder();

        for (int i = 0; i < listaAtaques.length; i++) {

            if (listaAtaques[i]!=null){
                resultado.append(i).append(". ").append(listaAtaques[i].toString()).append("\n");
            }

        }
        
        return resultado.toString();
    }

    public void anadirMovimiento(Movimiento nuevoMO) {

        byte huecoLibre=-1;
        for (byte i=0; i < listaAtaques.length; i++) {
            if (listaAtaques[i] == null){
                huecoLibre=i;
                break;
            }
        }

        if (huecoLibre!=-1){
            listaAtaques[huecoLibre]=nuevoMO;
        }

    }

    public void anadirMovimiento(byte posicion, Movimiento nuevoMO) {

        eliminarMovimiento(posicion);

        listaAtaques[posicion]=nuevoMO;

    }

    public Movimiento  getMovimiento (byte posicion){

        if (posicion>0 && posicion < listaAtaques.length){
            return listaAtaques[posicion];
        }

        return listaAtaques[0];
    }


    public void bajarHp(int hp) {
        if (this.hp-hp>=0){
            this.hp = this.hp-hp;
        }else {
            this.hp=0;
        }
    }

    public void setHp(int hp) {
        this.hp=hp;
    }



    public void eliminarMovimiento(byte posicionMovimiento){
       listaAtaques[posicionMovimiento]=null;
    }


    @Override
    public String toString() {

        String tipo2cadena = (tipo2 == null) ? " " : tipo2.name();

        StringBuilder salida = new StringBuilder("Pokémon: "
                + nombre +
                " Tipos " + tipo1.name() + tipo2cadena +
                " Nivel " + nivel +
                ", Vida: " + hp +
                " PP: " + pp +
                " \n\tMovimientos:");

        for (Movimiento ataque:listaAtaques) {
            if (ataque!=null){
                salida.append(ataque.toString());
            }

        }

        return salida.toString();
    }
}
