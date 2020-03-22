package Vista.Herramientas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

public class listMaker {

    /** Variables utiles en otros metodos */
    int posX, posY;

    /** Constructor */
    public JComboBox<String> crear(int posX, int posY, int ancho, int alto, Color bgColor, Font fuenteLista,
            String[] opciones) {
        JComboBox<String> listaDesplegable = new JComboBox<>();
    
        /** Personalizacion del Componente */
        listaDesplegable.setLocation(posX, posY);
        listaDesplegable.setSize(ancho, alto);
        listaDesplegable.setBackground(bgColor);
        listaDesplegable.setFont(fuenteLista);
        listaDesplegable.setFocusable(false);
        listaDesplegable.setBorder(null);
        for (int contador = 0; contador < opciones.length; contador++) {
            listaDesplegable.addItem(opciones[contador]);
        }
        return listaDesplegable;
    }

}