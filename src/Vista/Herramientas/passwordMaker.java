package Vista.Herramientas;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class passwordMaker extends JPasswordField{

    private static final long serialVersionUID = 1L;
    private static final int CENTER_ALIGNMENT = 0;

    Color focusColor;
    /** While the user modifies text in the field, it shows this color */
    Color releaseColor;

    /** While the user don't focus this field, it shows this color */

    public passwordMaker(int posX, int posY, int width, int height, Color focusColor, Color releaseColor, Font inputFont) {

        setBounds(new Rectangle(posX, posY, width, height));
        setSize(width, height);

        /** Behaivor changes */
        setHorizontalAlignment((int) CENTER_ALIGNMENT);
        setEchoChar('•');

        /** Appereance changes */
        setBackground(new colorMaker().obtainColor("grisEnfasisClaro"));
        setBorder(BorderFactory.createLineBorder(releaseColor, 3));
        setForeground(releaseColor);
        setFont(inputFont);
        setCaretColor(new colorMaker().obtainColor("invisible"));
        /** Adding listeners */
        addFocusListener(new FocusListener() {
            /**While the focus is in the element or not the fields gain certain colors */
            @Override
            public void focusGained(FocusEvent e) {
                setForeground(focusColor);
                setBorder(BorderFactory.createLineBorder(focusColor, 3));	

            }

            @Override
            public void focusLost(FocusEvent e) {
                setForeground(releaseColor);
                setBorder(BorderFactory.createLineBorder(releaseColor, 3));	

            }
            
        });

    }
    
    public String getValue(){
        return new String(this.getPassword());
    }

}