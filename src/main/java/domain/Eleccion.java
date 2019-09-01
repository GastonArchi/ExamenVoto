package domain;

import java.util.ArrayList;
import java.util.List;

public class Eleccion {

    private  List<Lista> listasAprobadas;
    private int votosTotalesEleccion;

    public Eleccion() {
        this.listasAprobadas = new ArrayList<>();
    }

    /*agregado de listas a Eleccion*/

    public  void agregarLista(Lista unaLista, Partido unPartido) {

        if (unPartido.getVigencia() && !unPartido.getPresencia()) {

            listasAprobadas.add(unaLista);

            unPartido.setPresencia(true);

        }

    }

    public int getVotosTotalesEleccion() {
        return votosTotalesEleccion;
    }

    public int contarListasAprobadas() {

        return this.listasAprobadas.size();

    }


    /*///////////////////////////////////////////////////////////////*/

    public boolean chequearVotante(Votante unVotante){

        return !unVotante.getHaVotado() && unVotante.getEdad() >= 16;


    }

    public int cantidadDeListasAceptadas(){

        return listasAprobadas.size();

    }


    public void votarLista(int numeroLista , Votante unVotante){

        if (this.chequearVotante(unVotante)) {

            this.contarVoto();


            for (Lista laLista: listasAprobadas) {

                if (numeroLista == laLista.getNumeroDeLista()){

                    laLista.serVotado();

                }

            }

        }

    }

    public void contarVoto(){

        this.votosTotalesEleccion++;

    }

    public void votarPostulante(int numeroLista , Votante unVotante, String puesto ){



        if (this.chequearVotante(unVotante)) {

            this.contarVoto();


            for (Lista laLista: listasAprobadas) {

                if (numeroLista == laLista.getNumeroDeLista()){

                    laLista.votarPostulante(puesto);

                }

            }

        }

    }

    public int cantidadDeVotosDeUnaLista(Lista unaLista){

        int retorno = 0;


         for (Lista laLista: listasAprobadas) {

            if (unaLista == laLista){

                retorno =laLista.getCantidadDeVotos();

            }

        }

         return retorno;

    }




    public int cantidadDeVotosDeUnCargo(Lista unaLista , String cargoPostulante){




        int retorno = 666;




        for (Lista laLista: listasAprobadas) {

            if (unaLista == laLista){

                retorno = laLista.getCantidadDeVotosDe(cargoPostulante);

            }

        }

        return retorno;

    }


}




