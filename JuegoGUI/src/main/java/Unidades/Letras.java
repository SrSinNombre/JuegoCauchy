package Unidades;

public class Letras {
    private Unidades historiador = new Unidades(130,35,50,4,1, false);
    private Unidades filologo = new Unidades(70,45,30,2,4, false);
    private Unidades teologo = new Unidades(120,40, 20, 3, 2, false);
    private Unidades traductor = new Unidades(110, 25, 40, 3, 2, false);
    private Unidades filosofo = new Unidades(150, 20, 45, 1, 3, false);

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
