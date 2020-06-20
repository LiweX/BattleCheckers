package CodeBusters;

import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

public class BCTest {
    private static PedirNombres pedir;
    private static String n1, n2;
    private static boolean expected;

    @BeforeClass
    public static void beforeClass() {
        pedir = new PedirNombres();

        n1 = "nombreJugador1";
        n2 = "nombreJugador2";

        expected = true;
    }

    @Test
    public void testNombres() {
        boolean actual = pedir.chequearNombres(n1,n2);
        Assert.assertEquals(expected,actual);
    }
}