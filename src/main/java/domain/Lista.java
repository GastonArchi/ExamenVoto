package domain;

import java.util.ArrayList;
import java.util.List;

public class Lista {

    private String nombreLista;
    private List<Postulante> postulantes;
    private int numeroLista;
    private String nombrePartido;
    private int cantidadDeVotos;



    public Lista(String nombreLista,int numeroLista, String nombrePartido) {
        this.nombreLista = nombreLista;
        this.numeroLista = numeroLista;
        this.nombrePartido = nombrePartido;
        this.postulantes = new ArrayList<>();
    }


    public int getNumeroDeLista() {
        return numeroLista;
    }

    public void agregarPostulanteAListaPostulantes(String puesto, String nombre){

        postulantes.add(new Postulante (puesto,nombre));

    }


    public int contarPostulantes() {

       return this.postulantes.size();

    }

    public void serVotado(){

        this.cantidadDeVotos++;


    }

    public int getCantidadDeVotos() {
        return cantidadDeVotos;
    }

    public void votarPostulante(String puesto){

        for (Postulante any: postulantes) {

            if (puesto == any.getCargo()){

                any.serVotado();

            }

        }



    }


    public int getCantidadDeVotosDe(String cargoPostulante) {

            int retorno = 0;


            for (Postulante any: postulantes) {

                if (cargoPostulante == any.getCargo()){

                    retorno = any.getCantidadVotos();

                }

            }

            return retorno;

        }



}


