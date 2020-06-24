/**
 * @author Luna, Lihue Leandro
 * @author Merino, Mateo
 * @author Bonino, Francisco Ignacio
 */

import javax.swing.ImageIcon;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertEquals(false,pedirNombres.chequearNombres(nombre1,nombre1)); //Dos nombres iguales.
        assertEquals(true,pedirNombres.chequearNombres(nombre1,nombre2));  //Dos nombres distintos.
        assertEquals(false,pedirNombres.chequearNombres(nombre1,nombre3)); //Un nombre vacio.
    }
    
    //Test que evalua un intento de selecci�n de ficha en una celda vacia.
    @Test (expected = NullPointerException.class)
    public void fichaSelectionTest() throws NullPointerException {
    	juego.seleccionarFicha(testSelectionNull);
    }
    
    //Test que evalua la cantidad de casillas que tienem disponibles diferentes fichas.
    @Test
    public void testArrayMovement() {
    	assertEquals(2,tablero.getCeldas()[5][4].getFicha().celdasContiguas(tablero.getCeldas()[5][4],tablero.getCeldas()).size()); //Ficha roja que puede moverse en diagonal arriba a ambos lados.
    	assertEquals(1,tablero.getCeldas()[5][0].getFicha().celdasContiguas(tablero.getCeldas()[5][0],tablero.getCeldas()).size()); //Ficha roja de un costado que solo puede moverse en diagonal arriba a la derecha.
    	assertEquals(0,tablero.getCeldas()[6][1].getFicha().celdasContiguas(tablero.getCeldas()[6][1],tablero.getCeldas()).size()); //Ficha roja que no puede moverse.
    	assertEquals(1,tablero.getCeldas()[2][7].getFicha().celdasContiguas(tablero.getCeldas()[2][7],tablero.getCeldas()).size()); //Ficha blanca de un costado que solo tiene un movimiento posible en diagonal abajo a la izquierda.
    }
    
    //Test que evalua la cantidad de celdas para moverse y eliminar ficha enemiga que tiene una ficha en el medio. Se abarcan los tres casos (0, 1 y 2).
    @Test
    public void testArrayEliminations() {
    	assertEquals(0,tablero.getCeldas()[5][4].getFicha().celdasEliminar(tablero.getCeldas()[5][4],tablero.getCeldas()).size()); //Ficha roja que no tiene ficha blanca alrededor (0).
        
    	tablero.getCeldas()[4][3].setFicha(fichaTest); //Coloco una ficha en la posicion [4][3] y testeo (1).
    	tablero.getCeldas()[4][3].hayFicha(true);
    	tablero.getCeldas()[4][3].setIcon(fichaTest.getIcon());
    	
    	assertEquals(1,tablero.getCeldas()[5][4].getFicha().celdasEliminar(tablero.getCeldas()[5][4],tablero.getCeldas()).size());
    
    	tablero.getCeldas()[4][5].setFicha(fichaTest); //Agrego una ficha en [4][5] y vuelvo a testear (2).
    	tablero.getCeldas()[4][5].hayFicha(true);
    	tablero.getCeldas()[4][5].setIcon(fichaTest.getIcon());
    	
    	assertEquals(2,tablero.getCeldas()[5][4].getFicha().celdasEliminar(tablero.getCeldas()[5][4],tablero.getCeldas()).size());
    	
    	tablero.getCeldas()[4][3].setFicha(null); //Saco las fichas de [4][3] y [4][5] para terminar test.
    	tablero.getCeldas()[4][3].hayFicha(false);
    	tablero.getCeldas()[4][3].setIcon(vacio);
    	tablero.getCeldas()[4][5].setFicha(null);
    	tablero.getCeldas()[4][5].hayFicha(false);
    	tablero.getCeldas()[4][5].setIcon(vacio);
    }
    
    /*
     * Test que verifica que una ficha roja pudo moverse correctamente.
     * Caso particular evaluado: movimiento de [5][4] hasta [4][3].
     */
    @Test
    public void testMovementCoord() throws NullPointerException {
    	testMovement = tablero.getCeldas()[5][4];
    	fichaMovementTest = testMovement.getFicha();
    	contiguas = testMovement.getFicha().celdasContiguas(testMovement,tablero.getCeldas());
    	
    	juego.seleccionarFicha(testMovement); //Muevo la ficha.
    	juego.moverFicha(contiguas.get(0));
    	juego.seleccionarFicha(contiguas.get(0));
    	
    	assertEquals(fichaMovementTest,contiguas.get(0).getFicha());
    	
    	testMovement.setFicha(fichaMovementTest);
    	testMovement.hayFicha(true);
    	testMovement.setIcon(fichaMovementTest.getIcon());
    	
    	tablero.getCeldas()[4][3].setFicha(null); //Revierto los cambios hechos para este test.
    	tablero.getCeldas()[4][3].hayFicha(false);
    	tablero.getCeldas()[4][3].setIcon(vacio);
    }
    
    //Test que eval�a la correcta eliminaci�n de una ficha.
    @Test
    public void eliminationTest() {
    	tablero.getCeldas()[4][3].setFicha(fichaTest); //Seteo una ficha blanca en [4][3] para comerla desde [5][4].
    	tablero.getCeldas()[4][3].hayFicha(true);
    	tablero.getCeldas()[4][3].setIcon(fichaTest.getIcon());
    	
    	testMovement = tablero.getCeldas()[5][4];
    	fichaMovementTest = testMovement.getFicha();
    	eliminar = fichaMovementTest.celdasEliminar(testMovement,tablero.getCeldas());
    	
    	juego.seleccionarFicha(testMovement); //Como la ficha y testeo haberme movido.
    	juego.comerFicha(eliminar.get(0));
    	
    	assertEquals(fichaMovementTest,eliminar.get(0).getFicha());
    	
    	tablero.getCeldas()[3][2].setFicha(null); //Revierto los cambios hechos para este test.
    	tablero.getCeldas()[3][2].hayFicha(false);
    	tablero.getCeldas()[3][2].setIcon(vacio);
    	testMovement.setFicha(new Ficha(ColorFicha.ROJA,fichaRoja));
    	testMovement.hayFicha(true);
    	testMovement.setIcon(fichaMovementTest.getIcon());
    	
    	juego.seleccionarFicha(testMovement);
    }
}