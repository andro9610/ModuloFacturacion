package Vista.Herramientas;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

public class imageMaker extends JPanel {
    private static final long serialVersionUID = 1L;
    /**Variables para reescribir el metodo paint de forma dinamica */
    int X, Y, width, height;
    String ruta;
    public imageMaker(int posX, int posY, int ancho, int alto, String rutaImagen) {
        this.width = ancho;
        this.height = alto;
        this.X = posX;
        this.Y = posY;
        this.setBounds(X,Y,width,height);
        this.ruta = rutaImagen;
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon Img = new ImageIcon(getClass().getResource(ruta));
        g.drawImage(Img.getImage(), 0, 0, width, height, null);
    }    
}