package Vista.Herramientas;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class buttonMenuMaker extends JButton {

    private static final long serialVersionUID = 1L;


    Color colorSeleccion;

    public buttonMenuMaker(String buttonLabel,
            int posX, int posY, int width, int height,
            Color[] focusedColor,
            Color panelColor,
            Font normalFont,String rutaIcono) {
        colorMaker pincel = new colorMaker();
        setHorizontalAlignment(SwingConstants.LEFT);
        setHorizontalTextPosition(SwingConstants.RIGHT); 
        setText("  "+buttonLabel);
        setLayout(null);
        setBackground(pincel.obtainColor("invisible"));
        setForeground(focusedColor[1]);
        setFont(normalFont);
        setFocusable(false);
        setBounds(new Rectangle(posX, posY, width, height));
        setIcon(new ImageIcon(getClass().getResource(rutaIcono)));
        setBorder(BorderFactory.createMatteBorder(0, 10, 0, 0, panelColor));
        addMouseListener(new MouseListener() {            

            @Override
            public void mouseReleased(MouseEvent e) {
                /**Aspecto del boton en un momento cualquiera */
                /** Modificar propiedades de visibilidad en vez de color*/
                colorSeleccion = panelColor;
                setBorder(BorderFactory.createMatteBorder(0, 10, 0, 0, colorSeleccion));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                /**Aspecto del boton con el mouse encima */
                colorSeleccion = focusedColor[0];
                setBorder(BorderFactory.createMatteBorder(0, 10, 0, 0, colorSeleccion));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setBorder(BorderFactory.createMatteBorder(0, 10, 0, 0, colorSeleccion));
                setBackground(colorSeleccion);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBorder(BorderFactory.createMatteBorder(0, 10, 0, 0, colorSeleccion));
                setBackground(colorSeleccion);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                /**Aspecto del boton cuando el mouse ya no esta encima */
                colorSeleccion = panelColor;
                setBorder(BorderFactory.createMatteBorder(0, 10, 0, 0, colorSeleccion));
            }
            
        });
    }

}