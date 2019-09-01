package domain;

public class Postulante {

    private String cargo;
    private String nombre;
    private int cantidadVotos;

    public Postulante(String puesto, String nombre) {
        this.cargo = puesto;
        this.nombre = nombre;
        this.cantidadVotos = 0;

    }

    public String getCargo() {
        return cargo;
    }

    public void serVotado(){

        cantidadVotos++;

    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

}
