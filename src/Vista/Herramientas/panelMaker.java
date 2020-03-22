package Vista.Herramientas;

import javax.swing.JPanel;
import java.awt.Color;

public class panelMaker extends JPanel{

    private static final long serialVersionUID = 1L;

    public panelMaker(int posX, int posY, int ancho, int alto, Color colorFondo){
        setLayout(null);
        setBackground(colorFondo);
        setBounds(posX, posY, ancho, alto);
    }
}