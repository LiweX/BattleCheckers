import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

public class testsProyecto {

    private static String nombre1, nombre2, nombre3;
    private static PedirNombres pedirNombres;


    @BeforeClass
    public static void beforeClass() {
        nombre1 = "jugador1";
        nombre2 = "jugador2";
        nombre3 = "";

        pedirNombres = new PedirNombres();

    }

    @Test
    public void nameTest() {
        Assert.assertEquals(false,pedirNombres.chequearNombres(nombre1,nombre1));
        Assert.assertEquals(true,pedirNombres.chequearNombres(nombre1,nombre2));
        Assert.assertEquals(false,pedirNombres.chequearNombres(nombre1,nombre3));
    }
    
    
}
