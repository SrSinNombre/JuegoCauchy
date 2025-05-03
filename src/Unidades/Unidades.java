package Unidades;

public class Unidades {
    private int HP;
    private int ataque;
    private int defensa;
    private int rango_movimiento;
    private int rango_ataque;

    public Unidades(int HP, int ataque, int defensa, int rango_movimiento, int rango_ataque) {
        this.HP = HP;
        this.ataque = ataque;
        this.defensa = defensa;
        this.rango_movimiento = rango_movimiento;
        this.rango_ataque = rango_ataque;
    }

    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
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
}
