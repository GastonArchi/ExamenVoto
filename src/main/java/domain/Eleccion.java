package domain;

import java.util.ArrayList;
import java.util.List;

public class Eleccion {

    private  List<Lista> listasAprobadas;

    public Eleccion() {
        this.listasAprobadas = new ArrayList<>();
    }

    public  void agregarLista(Lista unaLista, Partido unPartido) {

        if (unPartido.getVigencia()) {

            listasAprobadas.add(unaLista);

        }

    }

    public int contarListasAprobadas() {

        return this.listasAprobadas.size();

    }

    }




