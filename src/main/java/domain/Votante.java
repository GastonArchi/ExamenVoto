package domain;

public class Votante {

    private int edad;
    private boolean haVotado;

    public Votante(int edad) {
        this.edad = edad;
        this.haVotado = false;
    }

    public boolean getHaVotado() {
        return haVotado;
    }

    public int getEdad() {
        return edad;
    }


    public void setHaVotado(boolean haVotado) {
        this.haVotado = haVotado;
    }

    public void votaA (int numeroLista , Eleccion unaEleccion){

        unaEleccion.votarLista(numeroLista, this);

        setHaVotado(true);

    }

    public void votaA (int numeroLista , Eleccion unaEleccion , String cargoAVotar ){

        unaEleccion.votarPostulante(numeroLista, this, cargoAVotar);

        setHaVotado(true);

    }




}
