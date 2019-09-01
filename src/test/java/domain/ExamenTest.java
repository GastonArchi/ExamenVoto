package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ExamenTest {
    private Eleccion eleccion;
    private Partido unPartido;
    private Partido otroPartido;

    @Before
    public void init(){
        this.eleccion = new Eleccion();
        this.unPartido = new Partido("El reino de Gary", LocalDate.of(2019, 9, 12), true);
        this.otroPartido = new Partido("Los perros del vecino",LocalDate.of(2019,5,15), false);
    }


    @Test
    public void agregarYContarPostulantesTest(){

        /*El partido crea una lista y se la guarda*/

        unPartido.crearLista("Frente de Gary",360);

        /*el partido le suma 5 postulantes a su Lista*/

        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("presidente","Gary");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("vicepresidente","Meow");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("Senador","ElGatto");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("diputado","Kat");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("gobernador","Eze");

        /*chequeo si fueron agregados correctamente y cumplimos con el punto de la primera iteracion*/


        Assert.assertEquals(5, unPartido.getUnaLista().contarPostulantes());



}
        /*partido.presentarLista(partido.getUnaLista(),partido, eleccion);*/

    @Test
    public void vigenciaDePartidosTest() {

        /*Los partidos crean una lista y se la guardan*/

        unPartido.crearLista("Frente de Gary", 360);
        otroPartido.crearLista("BFFs del hombre", 630);

        /*ambos partidos le suman postulantes a sus Listas*/

        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("presidente", "Gary");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("vicepresidente", "Meow");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("Senador", "ElGatto");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("diputado", "Kat");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("gobernador", "eze");

        otroPartido.getUnaLista().agregarPostulanteAListaPostulantes("presidente", "Brutus");
        otroPartido.getUnaLista().agregarPostulanteAListaPostulantes("vicepresidente", "Woof");
        otroPartido.getUnaLista().agregarPostulanteAListaPostulantes("Senador", "ElPerro");
        otroPartido.getUnaLista().agregarPostulanteAListaPostulantes("diputado", "Doug");

        /*chequeo si fueron agregados correctamente y cumplo con el punto 1 de la primera iteracion*/

        Assert.assertEquals(5, unPartido.getUnaLista().contarPostulantes());
        Assert.assertEquals(4, otroPartido.getUnaLista().contarPostulantes());

        /*intento agregar ambas listas a la eleccion*/

        unPartido.presentarLista(unPartido.getUnaLista(),unPartido,eleccion);
        otroPartido.presentarLista(otroPartido.getUnaLista(),otroPartido,eleccion);

        /*se supone que la vigente añadio su lista a la eleccion y la no vigente no,
        ademas cumplo con el punto 3 de la primera iteracion */

        /*ademas cumplo con el punto 2 de la primera iteracion*/

        Assert.assertEquals(1, eleccion.contarListasAprobadas());

        /*demuestro el punto 4 de la primera iteracion*/

        otroPartido.volverVigente();

        otroPartido.presentarLista(otroPartido.getUnaLista(),otroPartido,eleccion);

        Assert.assertEquals(2, eleccion.contarListasAprobadas());

    }





    }
