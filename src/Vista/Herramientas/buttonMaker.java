package Vista.Herramientas;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class buttonMaker extends JButton {

    private static final long serialVersionUID = 1L;

    public buttonMaker(String buttonLabel, int posX, int posY, int width, int height, Color[] normalColor,Color[] focusedColor, Font normalFont, Font focusedFont) {
        setText(buttonLabel);
        setLayout(null);
        setBackground(normalColor[0]);
        setForeground(normalColor[1]);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(normalFont);
        
        setBounds(new Rectangle(posX, posY, width, height));
        /**Method that changes the Behavior of the Button */
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
                setFont(focusedFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor[0]);
                setForeground(normalColor[1]);
                setFont(normalFont);
            }
        });
    }
}