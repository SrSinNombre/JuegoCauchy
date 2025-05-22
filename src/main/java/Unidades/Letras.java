package Unidades;

public class Letras {
    private Unidades historiador = new Unidades("Historiador",100, 20, 25, 4, 2, false);
    private Unidades filologo = new Unidades("Filólogo",100,25,20,2,4, false);
    private Unidades teologo = new Unidades("Teólogo",110, 50, 25, 2, 2, false);
    private Unidades traductor = new Unidades("Traductor",80, 50, 10, 2, 4, false);
    private Unidades filosofo = new Unidades("Filósofo",150, 21, 20, 1, 1, false);

    public Letras(){}
    public Unidades getFilologo() {
        return filologo;
    }
    public Unidades getFilosofo() {
        return filosofo;
    }
    public Unidades getHistoriador() {
        return historiador;
    }
    public Unidades getTeologo() {
        return teologo;
    }
    public Unidades getTraductor() {
        return traductor;
    }
}
