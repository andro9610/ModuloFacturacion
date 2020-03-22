package Vista.Herramientas;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class buttonIconMaker extends JButton {
    private static final long serialVersionUID = 1L;

    public buttonIconMaker(
        String rutaIcono,
        int posX,int posY,int dimension,
        Color[] normalColor,
        Color[] focusedColor) {
        setBackground(normalColor[0]);
        setForeground(normalColor[1]);
        setFocusPainted(false);
        setBorderPainted(false);
        setIcon(new ImageIcon(getClass().getResource(rutaIcono)));
        setBounds(new Rectangle(posX, posY, dimension, dimension));
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(focusedColor[0]);
                setForeground(focusedColor[1]);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor[0]);
                setForeground(normalColor[1]);
            }
        });
    }
}