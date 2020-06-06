import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComoJugar extends JFrame implements ActionListener {
    private JButton atras, adelante, volver;
    private JLabel imagenTutorial;
    private int numPagina=0;

    public ComoJugar(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        atras = new JButton("Atras");
        atras.setBounds(10,375,90,25);
        atras.setEnabled(false);
        add(atras);
        atras.addActionListener(this);


        adelante = new JButton("Adelante");
        adelante.setBounds(525,375,90,25);
        add(adelante);
        adelante.addActionListener(this);


        volver = new JButton("Volver");
        volver.setBounds(10,10,90,25);
        add(volver);
        volver.addActionListener(this);

        imagenTutorial = new JLabel("Pagina 0");
        imagenTutorial.setFont(new Font("Arial",3,18));
        imagenTutorial.setBounds(75,100,300,30);
        add(imagenTutorial);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == atras){
            if(numPagina==1) atras.setEnabled(false);
            else adelante.setEnabled(true);
            numPagina--;
            imagenTutorial.setText("Pagina "+numPagina);

        }
        if(e.getSource() == adelante){
            if(numPagina==9) adelante.setEnabled(false);
            else atras.setEnabled(true);
            numPagina++;
            imagenTutorial.setText("Pagina "+numPagina);

        }
        if(e.getSource() == volver){
            if(Main.jugando==false){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setBounds(0,0,300,600);
            menu.setVisible(true);
            menu.setResizable(false);
            menu.setLocationRelativeTo(null);
            menu.setTitle("BattleCheckers");
            this.setVisible(false);
            }
            else this.setVisible(false);

        }
    }
}
