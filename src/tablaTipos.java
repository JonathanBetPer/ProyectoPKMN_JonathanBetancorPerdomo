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

    private tablaTipos (tipos[] superEficaz, tipos[] pocoEficaz, tipos[] nulo ){
        this.superEficaz=superEficaz;
        this.pocoEficaz=pocoEficaz;
        this.nulo=nulo;
    }

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

}
