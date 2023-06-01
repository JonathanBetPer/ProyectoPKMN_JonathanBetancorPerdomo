public enum tablaTipos {
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
    );
    private  tipos[] superEficaz;
    private tipos[] pocoEficaz;
    private tipos[] nulo;

    private tablaTipos (tipos[] superEficaz, tipos[] pocoEficaz, tipos[] nulo ){
        this.superEficaz= superEficaz;
        this.pocoEficaz=pocoEficaz;
        this.nulo=nulo;
    }

    public tipos[] getSuperEficaz(){
        return this.superEficaz;
    }

    public tipos[] pocoEficaz(){
        return this.pocoEficaz;
    }

    public tipos[] nulo(){
        return this.nulo;
    }


}
