package domain;

import java.util.ArrayList;
import java.util.List;

public class Lista {

    private String nombreLista;
    private List<Postulante> postulantes;
    private int numeroLista;
    private String nombrePartido;



    public Lista(String nombreLista,int numeroLista, String nombrePartido) {
        this.nombreLista = nombreLista;
        this.numeroLista = numeroLista;
        this.nombrePartido = nombrePartido;
        this.postulantes = new ArrayList<>();
    }




    public void agregarPostulanteAListaPostulantes(String puesto, String nombre){

        postulantes.add(new Postulante (puesto,nombre));

    }


    public int contarPostulantes() {

       return this.postulantes.size();

    }


}
