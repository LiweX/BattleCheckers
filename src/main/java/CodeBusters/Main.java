/**
 * @author  Luna, Lihué Leandro
 *          Merino, Mateo
 *          Bonino, Francisco Ignacio
 */
public class Main {
    MenuPrincipal menu;
    ComoJugar tutorial;
    
    public static boolean jugando = false;

    public static void main(String args[]) {
        MenuPrincipal menu = new MenuPrincipal();
        
        menu.setBounds(0,0,300,600);
        menu.setVisible(true);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);
        menu.setTitle("BattleCheckers");
    }
}
