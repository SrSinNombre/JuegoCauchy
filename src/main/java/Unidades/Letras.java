package Unidades;

public class Letras {
    private Unidades historiador = new Unidades(100, 20, 25, 4, 2, false);
    private Unidades filologo = new Unidades(100,25,20,2,4, false);
    private Unidades teologo = new Unidades(110, 50, 25, 2, 2, false);
    private Unidades traductor = new Unidades(80, 50, 10, 2, 4, false);
    private Unidades filosofo = new Unidades(150, 21, 20, 1, 1, false);

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
