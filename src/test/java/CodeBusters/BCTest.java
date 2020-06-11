import org.junit.BeforeClass;
import org.junit.Assert;
import org.junit.Test;

public class BCTest {
    private static PedirNombres pedir;

    @BeforeClass
    public static void beforeClass() {
        pedir = new PedirNombres();
    }

    @Test
    public void test1() {
        boolean esperado = false;
        boolean obtuve = pedir.checkNames("pepe","pepe");

        Assert.assertEquals(esperado,obtuve);
    }
}