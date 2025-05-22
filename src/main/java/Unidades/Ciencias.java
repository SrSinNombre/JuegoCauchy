package Unidades;

public class Ciencias {
    private Unidades quimico = new Unidades("Químico",100, 20, 25, 4, 2, true);
    private Unidades biologo = new Unidades("Biólogo",100,25,20,2,4, true);
    private Unidades matematico = new Unidades("Matemático",110, 50, 25, 2, 2, true);
    private Unidades fisico = new Unidades("Físico",80, 50, 10, 2, 4, true);
    private Unidades ingeniero = new Unidades("Ingeniero",150, 21, 20, 1, 1, true);

    public Ciencias(){}
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
