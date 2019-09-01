package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ExamenTest2 {
    private Eleccion eleccion;
    private Partido unPartido;
    private Partido otroPartido;
    private Votante unVotante;
    private Votante otroVotante;

    @Before
    public void init() {
        this.eleccion = new Eleccion();
        this.unPartido = new Partido("El reino de Gary", LocalDate.of(2019, 9, 12), true);
        this.otroPartido = new Partido("Los perros del vecino", LocalDate.of(2019, 5, 15), false);
        this.unVotante = new Votante(50);
        this.otroVotante = new Votante(16);

    }


    @Test
    public void Iteracion2Test(){

        /*El partido crea una lista y se la guarda*/

        unPartido.crearLista("Frente de Gary",360);

        /*el partido le suma 5 postulantes a su Lista*/

        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("presidente","Gary");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("vicepresidente","Meow");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("Senador","ElGatto");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("diputado","Kat");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("gobernador","Eze");

        Assert.assertEquals(5, unPartido.getUnaLista().contarPostulantes());


        /*el partido presenta la Lista para que pueda ser votada*/
        unPartido.presentarLista(unPartido.getUnaLista(),unPartido,eleccion);

        unVotante.votaA(360, eleccion);

        /*chequeo si el voto fue concretado*/

        Assert.assertEquals(1, unPartido.getUnaLista().getCantidadDeVotos());

        /*y le pregunto al votante si ha votado*/

        Assert.assertTrue(unVotante.getHaVotado());

        /*el votante intentara votar a pesar de ya haberlo hecho*/

        unVotante.votaA(360, eleccion);

        /*el voto no se va a concretar*/

        Assert.assertEquals(1, unPartido.getUnaLista().getCantidadDeVotos());





    }

    @Test
    public void PresenciaPartidoTest(){

        /*El partido crea una lista y se la guarda*/

        unPartido.crearLista("Frente de Gary",360);

        /*el partido le suma 5 postulantes a su Lista*/

        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("presidente","Gary");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("vicepresidente","Meow");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("Senador","ElGatto");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("diputado","Kat");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("gobernador","Eze");

        Assert.assertEquals(5, unPartido.getUnaLista().contarPostulantes());

        /*el partido presenta la Lista para que pueda ser votada*/

        unPartido.presentarLista(unPartido.getUnaLista(),unPartido,eleccion);

        /*la presencia del partido deberia ser confirmada en la eleccion*/

        Assert.assertEquals(true, unPartido.getPresencia());

        /*por lo tanto si intenta presentar la lista de nuevo no se le va a permitir*/

        unPartido.presentarLista(unPartido.getUnaLista(),unPartido,eleccion);

        Assert.assertEquals(1, eleccion.cantidadDeListasAceptadas());


    }

    @Test
    public void Iteracion2anotherTest(){

        /*El partido crea una lista y se la guarda*/

        unPartido.crearLista("Frente de Gary",360);

        /*el partido le suma 5 postulantes a su Lista*/

        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("presidente","Gary");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("vicepresidente","Meow");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("Senador","ElGatto");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("diputado","Kat");
        unPartido.getUnaLista().agregarPostulanteAListaPostulantes("gobernador","Eze");

        Assert.assertEquals(5, unPartido.getUnaLista().contarPostulantes());

        /*el partido presenta la Lista para que pueda ser votada*/

        unPartido.presentarLista(unPartido.getUnaLista(),unPartido,eleccion);

        unVotante.votaA(360, eleccion, "presidente");
        otroVotante.votaA(360, eleccion, "presidente");

        /*chequeo si el voto fue concretado*/

        Assert.assertEquals(2, eleccion.cantidadDeVotosDeUnCargo(unPartido.getUnaLista(), "presidente"));

        /*Conteo de Votos*/

        Assert.assertEquals(2, eleccion.getVotosTotalesEleccion());


    }

}
