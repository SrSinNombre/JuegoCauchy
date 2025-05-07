package controlPartida;

public class CasillaEspecial {
    private int[] coordenadas;
    private String propiedad;

    public CasillaEspecial(int[] coordenadas, String propiedad){
        this.coordenadas = coordenadas;
        this.propiedad = propiedad;
    }

    public int[] getCoordenadas() {
        return coordenadas;
    }
    public String getPropiedad() {
        return propiedad;
    }
}
