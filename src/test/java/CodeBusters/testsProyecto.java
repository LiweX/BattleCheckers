import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assert;

import javax.swing.ImageIcon;
import java.util.ArrayList;

public class testsProyecto {

    private static String nombre1, nombre2, nombre3;
    private static PedirNombres pedirNombres;
    private static Celda testSelectionNull, testMovement;
    private static Tablero tablero;
    private static Estadisticas stats;
    private static Juego juego;
    private static ImageIcon fichaBlanca, fichaRoja, vacio;
    private static Ficha fichaTest, fichaMovementTest;
    private static ArrayList<Celda> contiguas, eliminar;

    @BeforeClass
    public static void beforeClass() {
        nombre1 = "jugador1";
        nombre2 = "jugador2";
        nombre3 = "";
        
        fichaBlanca = new ImageIcon("src/resources/fichaBlanca.png");
        fichaRoja = new ImageIcon("src/resources/fichaRoja.png");
        vacio = new ImageIcon("");
        
        tablero = new Tablero();
        
        stats = new Estadisticas();
        
        juego = new Juego(tablero,stats);

        pedirNombres = new PedirNombres();
        
        testSelectionNull = new Celda(0,1);
        
        fichaTest = new Ficha(ColorFicha.BLANCA,fichaBlanca);
    }

    //Test que evalua distintos casos de inputs de nombres.
    @Test
    public void nameTest() {
        Assert.assertEquals(false,pedirNombres.chequearNombres(nombre1,nombre1)); //Dos nombres iguales.
        Assert.assertEquals(true,pedirNombres.chequearNombres(nombre1,nombre2));  //Dos nombres distintos.
        Assert.assertEquals(false,pedirNombres.chequearNombres(nombre1,nombre3)); //Un nombre vacio.
    }
    
    
}
