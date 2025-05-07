package Unidades;

public class Ciencias {
    private Unidades quimico = new Unidades(100, 40, 60, 2, 3, true);
    private Unidades biologo = new Unidades(120,15,40,2,1, true);
    private Unidades matematico = new Unidades(150, 35, 50, 3, 3, true);
    private Unidades fisico = new Unidades(110, 30, 40, 2, 1, true);
    private Unidades ingeniero = new Unidades(80, 60, 30, 4, 3, true);

    public Unidades getBiologo() {
        return biologo;
    }
    public Unidades getFisico() {
        return fisico;
    }
    public Unidades getIngeniero() {
        return ingeniero;
    }
    public Unidades getMatematico() {
        return matematico;
    }
    public Unidades getQuimico() {
        return quimico;
    }
}
