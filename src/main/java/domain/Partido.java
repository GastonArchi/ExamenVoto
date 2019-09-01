package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Partido {

    private String nombrePartido;
    private LocalDate fechaConformacion;
    private Boolean vigencia;
    private Lista unaLista;
    private List<Postulante> postulantes;


    public Partido(String nombrePartido, LocalDate fecha, Boolean vigencia) {
        this.nombrePartido = nombrePartido;
        this.fechaConformacion = fecha;
        this.vigencia = vigencia;
        this.postulantes = new ArrayList<>();
    }

    public void volverVigente() {
        this.vigencia = true;
    }

    public Boolean getVigencia() {
        return vigencia;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    public Lista getUnaLista() {
        return unaLista;
    }

    public List<Postulante> getPostulantes() {
        return postulantes;
    }

    /*El partido es el responsable de crear una Lista, y al hacerlo la Lista recuerda que partido la creó*/

    public void crearLista(String nombreLista, int numeroLista){

        unaLista = new Lista (nombreLista,numeroLista,this.nombrePartido);

    }

    public void presentarLista(Lista unaLista, Partido unPartido ,Eleccion unaEleccion){

        unaEleccion.agregarLista(unaLista, unPartido);

    }

}
