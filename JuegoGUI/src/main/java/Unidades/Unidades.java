package Unidades;

public class Unidades {
    private double HP;
    private int ataque;
    private int defensa;
    private int rango_movimiento;
    private int rango_ataque;
    private boolean esDeCiencias;

    public Unidades(int HP, int ataque, int defensa, int rango_movimiento, int rango_ataque, boolean esDeCiencias) {
        this.HP = HP;
        this.ataque = ataque;
        this.defensa = defensa;
        this.rango_movimiento = rango_movimiento;
        this.rango_ataque = rango_ataque;
        this.esDeCiencias = esDeCiencias;
    }
    public double getHP() {
        return HP;
    }
    public void setHP(double HP){
        this.HP = HP;
    }
    public int getAtaque() {
        return ataque;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getRango_movimiento() {
        return rango_movimiento;
    }
    public void setRango_movimiento(int rango_movimiento) {
        this.rango_movimiento = rango_movimiento;
    }
    public int getRango_ataque() {
        return rango_ataque;
    }
    public void setRango_ataque(int rango_ataque) {
        this.rango_ataque = rango_ataque;
    }

    public boolean isDeCiencias() {
        return esDeCiencias;
    }

    public boolean isUnidadMuerta(){
        return HP <= 0;
    }

    public void subirHP(double inc){
        HP += inc;
    }
    public void subirAtaque(int inc){
        ataque += inc;
    }
    public void subirDefensa(int inc){
        defensa += inc;
    }
}
