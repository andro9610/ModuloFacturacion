package Vista.Herramientas;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class labelMaker extends JLabel {
    private static final long serialVersionUID = 1L;

    public labelMaker(String textoLabel, int posX, int posY, int width, int height,Color colorTexto, Font fuenteLabel) {
        setBackground(new colorMaker().obtainColor("invisible"));
        setForeground(colorTexto);
        setText(textoLabel);
        setFont(fuenteLabel);
        setBounds(posX, posY, width, height);
    }
}