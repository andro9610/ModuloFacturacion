package Vista.Herramientas;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

public class windowMaker extends javax.swing.JFrame{
    private static final long serialVersionUID = 1L;
    /**
     * windowMaker: Creates a window
     * 
     * @param width
     * @param height
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public windowMaker(int width, int height, String rutaIconoAplicacion) {
        /**Basic parameters of the window*/
        setSize(width,height);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource(rutaIconoAplicacion));
        Image Image = ImageIcon.getImage();
        setIconImage(Image);
    }

    /**Metodos que permiten la interaccion con el Controlador */
    public void cerrarVentana(){
        this.dispose();
    }
}